class RunnableDemo implements Runnable {
    private Thread thread;
    private String threadName;

    RunnableDemo(String name) {
        threadName = name;
        System.out.println("Creating thread " + threadName);
    }

    public void run() {
        System.out.println("Running thread " + threadName);
        try {
            for(int i = 0;i < 4;i++) {
                System.out.println("Thread: " + threadName);

                thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thred "+  threadName + " interrupted.");
            System.out.println("Thred "+  threadName + " exited.");

        }
        
    }

    public void start() {
        System.out.println("Starting thread " + threadName);
        if(thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}

class ThreadExample {
    public static void main(String[] args) {
        RunnableDemo thread1 = new RunnableDemo("Thread1");
        thread1.start();

        RunnableDemo thread2 = new RunnableDemo("Thread2");
        thread2.start();
    }
}