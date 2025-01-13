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
   - **Method Overloading:** Same method names but different parameters.

2. **Runtime Polymorphism (Dynamic Polymorphism):**
   - **Method Overriding:** 
     - Overriding means redefining the functionality of an existing method.
     - A child class can override a method from its parent class based on its requirements.
     - Also known as **dynamic method dispatch** because the object behaves differently in many forms at runtime.

```