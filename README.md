# Interview Preparation Notes

## Classes
- **Definition**: User-defined blueprint that can have multiple objects for the same class. It binds data and methods together.
- **Key Points**:
  - Acts as a template for creating objects.
  - Example:
    ```java
    class Example {
        // Attributes and methods
    }
    ```

## Objects
- **Definition**: Basic unit of object-oriented programming and an instance of a class.
- **Accessing Methods and Data Members**: Methods and data members of a class are accessed through its objects.

## Making Class Attributes Read-Only
- Declare the variable with the `final` keyword.
  ```java
  final String name = "Jana";

## Class Methods
- **Definition**: Set of statements defined to perform specific tasks in the class.
- **Accessing Attributes and Methods**: Use the dot operator (`.`) to access attributes and methods.
  ```java
  Example obj = new Example();
  obj.methodName();
  ```

## Public vs Static Class Methods
- **Public**: Methods that can be accessed by any other class.
- **Static**: Methods that belong to the class rather than an instance of the class. These can be called without creating an object.

## Method Overloading
- **Definition**: When a class has two or more methods with the same name but different parameters.
- **Example**:
  ```java
  int min(int a, int b);
  int min(int a, int b, int c);
  ```

## Main Method and Command Line Arguments
- **Definition**: The `main(String[] args)` method is the entry point of a Java program.
- **Command Line Arguments**:
  - Passed when running the program.
  - Example:
    ```shell
    $ java CommandLine this is a command line 200 -100
    ```
    Output:
    ```
    args[0]: this
    args[1]: is
    args[2]: a
    args[3]: command
    args[4]: line
    args[5]: 200
    args[6]: -100
    ```

## Finalize Method
- **Definition**: Method executed just before the object's destruction by the garbage collector.
- **Use Case**: To release resources such as closing files.
- **Syntax**:
  ```java
  protected void finalize() {
      // Cleanup code
  }
  ```

## Default Access Modifier
- Fields in an interface are implicitly `public static final`.
- Methods in an interface are by default `public`.

## Constructor Overloading
- **Definition**: Multiple constructors with different parameters in a class.
- **Example**:
  ```java
  class Example {
      Example() {
          // Default constructor
      }
      Example(int x) {
          // Parameterized constructor
      }
  }
  ```

## Access Modifiers
1. **Private**: Accessible only within the class where it is declared.
   - Example:
     ```java
     private int value;
     ```
2. **Public**: Accessible from any other class.
   - **Main Method**: Must be `public` to be called by the Java interpreter.
     ```java
     public static void main(String[] args) {
         // Main method
     }
     ```
3. **Protected**: Accessible within the same package or subclasses in other packages.
   - Example:
     ```java
     protected int value;
     ```
   - Note: For subclass access, the child class should extend the parent class.

# Inheritance

Inheritance is the process in which a class acquires the properties like methods and attributes of another class.

## Key Terms:
- **Subclass:** The class that inherits properties.
- **Superclass:** The class whose properties are inherited.

## Need for Inheritance:
1. **Code Reusability:** Reuse the features of one base class to reduce redundancy.
2. **Extensibility:** Extend the features of one class and implement additional functionality in the derived class.
3. **Method Overriding:** Achieve one of the concepts of polymorphism through method overriding.
4. **Abstraction:** Abstraction is achieved through inheritance.

### Syntax:
```java
class Super {
    // Superclass members
}

class Sub extends Super {
    // Subclass members
}
```

## `super` Keyword:
- **Purpose:** Used in the subclass to differentiate the members or methods shared with the superclass.
- **Constructor Chaining:** To call the parameterized constructor of the superclass, use `super(parameters)`.

---

## Types of Java Inheritance:
1. **Single Inheritance**
2. **Multilevel Inheritance**
3. **Hierarchical Inheritance**

> Note: Java does not support **Multiple Inheritance** and **Hybrid Inheritance** directly to avoid ambiguity issues.

---

# Polymorphism

Polymorphism is the ability of an object to take on many forms.

## Types of Polymorphism:
1. **Compile-Time Polymorphism (Static Polymorphism):**
   - **Method Overloading:** Same method names but different number of parameters or different types.

2. **Runtime Polymorphism (Dynamic Polymorphism):**
   - **Method Overriding:** 
     - Overriding means redefining the functionality of an existing method.
     - A child class can override a method from its parent class based on its requirements.
     - Also known as **dynamic method dispatch** because the object behaves differently in many forms at runtime.
     - Method declared final cannot be overridden.
     - Method declared static cannot be overridden but can be re-declared.

# Dynamic Binding (Late Binding)

- **Definition:** Linking between the method call and method implementation is resolved at runtime.  
- **Example:** **Method Overriding**  
  ```java
  Animal b = new Dog(); 
  ```
  - Even though `b` is a reference type of `Animal`, the check is made on the reference type during compile time.
  - However, the **JVM** determines the object type at runtime and executes the method belonging to that object.

---

# Static Binding (Early Binding)

- **Definition:** Linking between the method call and the actual implementation is resolved at compile time.  
- **Example:** **Method Overloading**

---

# Instance Initializer Block

- **Definition:** A block of code defined inside a class to initialize instance data members. It works like a constructor but is executed **before** the constructor.

## Execution Order:
1. **Superclass Constructor** (if inherited)
2. **Instance Initializer Block** of the subclass
3. **Subclass Constructor**

## Use Cases:
1. Initialize instance variables.
2. Initialize resources used in the code.
3. Perform dynamic initialization of instance variables.
4. Use common initialization logic for multiple constructors.

## Syntax:
```java
{
    System.out.println("Inside instance initializer block");
    a = 10;
}
```

# Abstraction
- **Abstraction** in OOPs in Java is the quality of an object to deal with ideas rather than events.
- It is basically about **hiding the implementation** and showing only the functionality of the object.
- Abstraction is achieved using **abstract classes** and **interfaces**.
- It focuses on **what** the object does instead of **how** it is done.
- Provides a **blueprint** for subclasses to implement specific behaviors.

### Levels of Abstraction
- **Abstract Class**: Partial abstraction.
- **Interface**: Full abstraction.

---

# Encapsulation
- **Encapsulation** is also a fundamental concept of OOPs.
- It is the mechanism of **wrapping data (variables)** and **code acting on the data (methods)** together as a single unit.
- Encapsulation involves **hiding the variables** of a class from other classes, making them accessible only through the methods of the same class.  
  Therefore, it is also called **data hiding**.
- **Encapsulation** is implemented via **getters** and **setters**:
  - Only getters → **Read-only class**.
  - Only setters → **Write-only class**.
- Variables are always declared as **private**.

# Interfaces
- An **interface** is a collection of abstract methods. It is used to achieve **abstraction** and **multiple inheritance** in Java.
- Methods in an interface are declared without implementation, and a class that implements the interface provides their definitions.
- Interfaces can extend other interfaces using the `extends` keyword, and a class implements an interface using the `implements` keyword.
- An interface can extend **multiple interfaces**:
  ```java
  public interface Hockey extends Sports, Event {
      // Additional methods
  }
  ```
- An interface is essentially the **blueprint for a class**.

---

# Packages
A **Java package** is a grouping of related types (classes, interfaces, enumerations, and annotations) to provide:
- **Access protection**.
- **Namespace management**.

Packages in Java help:
- Prevent naming conflicts.
- Control access to classes.
- Simplify searching and usage of classes and interfaces.

### **Types of Java Packages**
1. **Built-in Java Packages**: Predefined in Java, like `java.util` and `java.io`.
2. **User-defined Java Packages**: Created by users to organize their classes.

---

# Nested Classes
### **Static Nested Classes**
- A static nested class does not require an instance of the outer class.
- It can be accessed using the outer class's name:
  ```java
  class MyOuter {
      static class Nested_Demo {
          // Static nested class
      }
  }
  ```

### **Inner Classes**
- Non-static nested classes have access to the outer class's instance variables and methods:
  ```java
  class MyOuter {
      private class Nested_Demo {
          // Inner class
      }
  }
  ```

---

## **Anonymous Classes**
- An **anonymous class** is a nameless inner class that is typically used to override a method or provide a specific implementation.
- Example:
  ```java
  public class Tester {
      public static void main(String[] args) {
          Software s = new Software() {
              @Override
              public void develop() {
                  System.out.println("Software Developed in Java");
              }
          };
          s.develop();
          System.out.println(s.getClass().getName());
      }
  }
  ```
  Output:
  ```
  Software Developed in Java
  Tester$1
  ```

  Here’s the formatted content in Markdown:

---

# Singleton Design Pattern

**Definition**:  
The Singleton design pattern ensures that a class has only one instance and provides a global point of access to that instance. It is particularly useful for:  
- Configuration settings  
- Logging  
- Managing shared resources  
- Database connection pools  

### How It Works:  
1. **Private Constructor**: Prevents instantiation from other classes.  
2. **Static Method**: Provides a single instance of the class.  

### Thread-Safety:  
In multi-threaded environments, the Singleton should be thread-safe to avoid multiple instances being created simultaneously.

---

# Java Wrapper Classes

When working with numbers, primitive data types like `int`, `float`, `double`, `byte`, `long`, etc., are commonly used. However, in some scenarios, we need objects instead of primitives. Java provides **Wrapper Classes** for this purpose.  

### Wrapper Classes:  
- `Integer`  
- `Long`  
- `Byte`  
- `Double`  
- `Float`  
- `Short`  

All wrapper classes are subclasses of the abstract class **`Number`**. These classes wrap a primitive data type within an object.

---

# Java Enum

An **enum** in Java is a special class that represents a group of pre-defined constant values.  
- Enums are used in switch expressions for comparison and as constants in application code.  
- **Key Property**: Java enums can only have private constructors.

### Example:
```java
enum Mobile {
    Samsung,
    Nokia,
    Motorola
}
```

---

# Exception Handling in Java

**Definition**:  
An exception is a problem that arises during program execution. When an exception occurs, the normal program flow is disrupted, leading to abnormal termination. Exceptions must be handled to maintain program stability.

### Try-Catch Block:  
The `try` block contains the code that might generate an exception. The `catch` block is used to handle the exception.

**Syntax**:
```java
try {
    // Protected code
} catch (ExceptionName e1) {
    // Catch block
}
```

### The `finally` Block:
The `finally` block executes regardless of whether an exception occurs. It is used for cleanup operations.

**Example**:
```java
try {
    // Protected code
} catch (Exception e) {
    // Handle exception
} finally {
    // Cleanup code
}
```

---

# Custom Exceptions

You can define your own exception class by extending the predefined `Exception` class.

**Example**:
```java
class MyException extends Exception {
    // Custom exception logic
}
```

**Note**: Custom exceptions are considered **checked exceptions**.

---