abstract class Vehicle {
    abstract void startEngine();

    void stopEngine() {
        System.out.println("Engine stopped!");
    }
}

class Bike extends Vehicle {
    @Override
    void startEngine() {
        System.out.println("Bike engine started!");
    }
}

class Car extends Vehicle {
    @Override
    void startEngine() {
        System.out.println("Car engine started!");
    }
}

public class AbsractClass {
    public static void main(String args[]) {
        Bike b = new Bike();
        Car c = new Car();

        b.startEngine();
        b.stopEngine();

        c.startEngine();
        c.stopEngine();
    }
}


/*### Abstraction in Java

**Abstraction** is one of the key principles of Object-Oriented Programming (OOP). It focuses on hiding the internal details and showing only the necessary functionality of an object. In Java, abstraction is achieved using **abstract classes** and **interfaces**.

An **abstract class** can have both abstract methods (methods without a body) and concrete methods (methods with a body). Meanwhile, an **interface** is a completely abstract class that defines only abstract methods (in Java 8 and later, interfaces can also have default and static methods).

---

### Key Points
1. **Why abstraction?**
   - To focus on "what" an object does rather than "how" it does it.
   - It provides a blueprint for subclasses to implement specific behaviors.
   - It enhances maintainability and scalability by separating implementation details from usage.

2. **Levels of abstraction in Java:**
   - Abstract class: Partial abstraction.
   - Interface: Full abstraction.

---

### Example: Abstraction using Abstract Class

```java
// Abstract class example
abstract class Vehicle {
    // Abstract method (no body)
    abstract void startEngine();
    
    // Concrete method (has body)
    void stopEngine() {
        System.out.println("Engine stopped.");
    }
}

// Subclass
class Car extends Vehicle {
    // Providing implementation for the abstract method
    @Override
    void startEngine() {
        System.out.println("Car engine started.");
    }
}

class Bike extends Vehicle {
    // Providing implementation for the abstract method
    @Override
    void startEngine() {
        System.out.println("Bike engine started.");
    }
}

public class AbstractionExample {
    public static void main(String[] args) {
        // Creating objects of subclasses
        Vehicle car = new Car();
        Vehicle bike = new Bike();

        // Using the objects
        car.startEngine();
        car.stopEngine();

        bike.startEngine();
        bike.stopEngine();
    }
}
```

---

### Explanation for the Interview

- The `Vehicle` class is **abstract** because we don't need to define a specific way to start the engine at this level; instead, the subclasses (`Car` and `Bike`) define their own versions of `startEngine()`.
- The `stopEngine()` method is common for all vehicles and is implemented in the abstract class itself.
- This demonstrates the concept of **abstraction**—we expose only the essential features (`startEngine` and `stopEngine` methods) while hiding the internal details of how they are implemented in subclasses.

---

### Interview-Friendly Points to Highlight
1. **What is abstraction?**  
   Abstraction is about hiding implementation details and exposing only the required functionalities.

2. **Why use abstraction?**  
   It helps in designing reusable and maintainable code by separating what an object does from how it does it.

3. **Example in context:**  
   - The `Vehicle` class serves as a blueprint for all types of vehicles.
   - The `Car` and `Bike` classes implement their specific behavior for starting the engine, fulfilling the requirement of the abstract `startEngine()` method.

4. **How is it useful?**  
   - It allows adding new vehicle types (like `Truck` or `Bus`) without changing the abstract class, making the design extensible.
   - Code written for `Vehicle` works seamlessly with any subclass, promoting polymorphism.

 * 
 * 
 */