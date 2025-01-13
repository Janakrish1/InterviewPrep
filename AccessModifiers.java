class AccessModifiers {
    private int count; // Changed to int to use increment operator
    String name;

    // Private method to increment count
    private void incrementCount() {
        count++;
    }

    // Protected method to add numbers
    protected int addNumbers(int a, int b) {
        return a + b;
    }

    // Public method to set the name
    public void setName(String name) {
        this.name = name;
    }

    // Public method to print the count
    public void printCount() {
        System.out.println("Count: " + count);
    }

    public static void main(String[] args) {
        AccessModifiers obj = new AccessModifiers();
        obj.setName("Example Name");
        obj.incrementCount(); // Private method can be called within the class
        obj.printCount(); // Print updated count
    }
}

class Child extends AccessModifiers {
    // Overriding the addNumbers method with the same signature and return type
    @Override
    protected int addNumbers(int a, int b) {
        return super.addNumbers(a, b) + 10; // Adding 10 to the result
    }

    public static void main(String[] args) {
        Child childObj = new Child();
        childObj.setName("Jana"); // Accessing the public method from parent
        System.out.println("Sum: " + childObj.addNumbers(5, 10)); // Overridden method
    }
}
