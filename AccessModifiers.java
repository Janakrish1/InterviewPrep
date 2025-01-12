class AccessModifiers {
    private String count;
    String name;
    private void incrementCount() {
        count++;
    }

    protected boolean addNumbers(int a, int b) {
        return a + b;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String args[]) {
        incrementCount();
    }
}

class Child extends AccessModifiers {
    public static void main(String args[]) {
        AccessModifiers obj = new AccessModifiers();
        obj.setName("Jana");
    }
    
    boolean addNumbers(int a, int b) {
        return a + b;
    }
}
