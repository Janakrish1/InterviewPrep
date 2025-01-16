interface Animals {
    public void eat();
    public void move();
}

class Dog implements Animals {
    @Override
    public void eat() {
        System.out.println("Dog eats bones!");
    }

    @Override
    public void move() {
        System.out.println("Dog runs in four legs.");
    }
}

class Bird implements Animals {
    @Override
    public void eat() {
        System.out.println("Bird eats seeds!");
    }

    @Override
    public void move() {
        System.out.println("Bird fly in the sky.");
    }
}

public class Interface {
    public static void main(String args[]) {
        Animals dog = new Dog();
        dog.eat();
        dog.move();

        Bird bird = new Bird();
        bird.eat();
        bird.move();
    }
}