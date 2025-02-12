class PrintDemo2 extends Thread {
   public void printCount() {
      try {
         for(int i = 5; i > 0; i--) {
            Thread.sleep(50);
            System.out.println("Counter --- " + i );
         }
      } catch (Exception e) {
         System.out.println("Thread " + Thread.currentThread().getName()+" interrupted.");
      }
   }
   public synchronized void run() {
      printCount();
      System.out.println("Thread " + Thread.currentThread().getName() + " exiting.");
   }
}
public class TestThreadMethod {
   public static void main(String args[]) {
      PrintDemo2 printDemo = new PrintDemo2();
      Thread t1 = new Thread(printDemo );
      Thread t2 = new Thread(printDemo );
      t1.start();
      t2.start();
      // wait for threads to end
      try {
         t1.join();
         t2.join();
      } catch ( Exception e) {
         System.out.println("Interrupted");
      }
   }
}