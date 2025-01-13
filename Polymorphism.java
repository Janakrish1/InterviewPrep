interface Vegetarian {}

class Animal {
    String name;

    public void animalName(String name) {
        this.name = name;
    }

    public void getName() {
        System.out.println("Animal Name: " + name);
    }

    public void displayName() {
        System.out.println("Inside Animal class " + name);
    }
}

class Deer extends Animal implements Vegetarian {
    public void setName(String name) {
        super.name = name;
    }

    @Override
    public void displayName() {
        System.out.println("Inside Deer class " + super.name);
    }

    public void testPolymorphism() {
        System.out.println("I'm here");

        Deer d = new Deer();
        Animal a = d;
        Vegetarian v = d;

        Animal obj = new Animal();

        System.out.println(d instanceof Deer); // true
        System.out.println(a instanceof Deer); // true
        System.out.println(v instanceof Deer); // true

        a.animalName("Goat");
        d.animalName("Cow");
        obj.animalName("Lion");

        a.getName();
        d.getName();

        d.displayName();
        obj.displayName();
    }
}


public class Polymorphism {
    public void addition(int a, int b) {
        System.out.println("Addition integers: " + (a + b));
    }

    public void addition(double a, double b) {
        System.out.println("Addition double integers: " + (a + b));
    }

    public static void main(String[] args) {
        Deer obj = new Deer();
        obj.testPolymorphism();

        Polymorphism obj2 = new Polymorphism();
        obj2.addition(1, 2);
        obj2.addition(2.5, 3.6);
        System.out.println("---------------------------");
    }
}
