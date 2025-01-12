public class Chef {
    static String name;

    static void setName(String _name) {
        name = _name;
    }

    static String getName() {
        System.out.println(name);
    }

    static void main(String args[]) {
        Chef.setName("Jana")
        Chef.getName();
    }    
}