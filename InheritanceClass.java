class Calculation {
    protected int res;

    public void add(int a, int b) {
        res = a + b;
        System.out.println("Addition = "+ res);
    }

    public void substract(int a, int b) {
        res = a - b;
        System.out.println("Subtraction = " + res);
    }
}

public class InheritanceClass extends Calculation {
    private void multiply(int a, int b) {
        // Note res was not initialized again here since it had inherited the attributed also from calculation class
        res = a * b;
        System.out.println("Multiply = " + res);
    }
    public static void main(String args[]) {
        int a = 20, b = 30;
        InheritanceClass obj = new InheritanceClass();
        obj.add(a, b);
        obj.substract(a, b);
        obj.multiply(a, b);
    }    
}
