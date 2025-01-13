class Classes {
    static String name;

    static void setName(String _name) {
        name = _name;
    }

    static void getName() {
        System.out.println(name);
    }

    public static void main(String args[]) {
        Classes.setName("Jana");
        Classes.getName();
    }    
}