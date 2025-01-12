```markdown
# Interview Preparation: Java Concepts

## Classes
- **Definition**: User-defined blueprint that can have multiple objects for the same class. It binds the data and the methods.
  
## Objects
- **Definition**: The basic unit of object-oriented programming and an instance of a class.  
- **Purpose**: Methods and data members of a class are accessed through its objects.

## Read-Only Class Attributes
- To make a class attribute read-only, declare it with the `final` keyword:  
  ```java
  final String name = "Jana";
  ```

## Class Methods
- **Definition**: A set of statements defined to perform specific tasks in a class.
- **Access**: Use the dot (`.`) operator to access class attributes and methods.

---

## Public vs Static Class Methods
- Public methods are accessible from any other class.
- Static methods belong to the class and can be accessed without creating an instance of the class.

---

## Method Overloading
- **Definition**: When a class has two or more methods with the same name but different parameters.  
- **Example**:
  ```java
  int min(int a, int b);
  int min(int a, int b, int c);
  ```

---

## Command-Line Arguments
- `main(String args[])`: Arguments passed while running a program.
- **Example**:  
  ```bash
  $ java CommandLine this is a command line 200 -100
  ```
  **Output**:
  ```
  args[0]: this
  args[1]: is
  args[2]: a
  args[3]: command
  args[4]: line
  args[5]: 200
  args[6]: -100
  ```

---

## Finalize Method
- **Definition**: The method called just before an object is destroyed by the garbage collector.  
- **Usage**: Used for resource cleanup, such as closing files.  
- **Syntax**:  
  ```java
  protected void finalize() {
      // Cleanup code here
  }
  ```

---

## Default Access Modifier
- Fields in an interface are implicitly `public static final`.
- Methods in an interface are by default `public`.

---

## Constructor Overloading
- **Definition**: A class can have multiple constructors with different parameters.

---

## Access Modifiers
1. **Private**:  
   - Attributes or methods declared `private` are accessible only within the declared class.
2. **Public**:  
   - Classes, attributes, methods, and constructors declared `public` are accessible from any other class.  
   - The `main` method must be `public` for the Java interpreter to run the class.
3. **Protected**:  
   - Variables, constructors, and methods declared `protected` in a superclass are accessible in subclasses (even in other packages) or any class within the same package.  
   - For a subclass to override or change the implementation, it must extend the parent class.  
   - Methods and fields in an interface cannot be declared `protected`.

```