class Dog {
    String breed;
    String color;
    int age;
    String name;

    public Dog(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printDetails() {
        System.out.println(this.breed);
        System.out.println(this.color);
        System.out.println(this.age);
    }
}

public class Main {
    public static void main(String args[]) {
        Dog dog = new Dog("Tommy");
        dog.setBreed("Golden Retriever");
        dog.setColor("Gold");
        dog.setAge(12);
        dog.printDetails();
    } 
}