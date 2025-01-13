class Device {
    public void deviceDetails() {
        System.out.println("Generic Device");
    }
}

class Laptop extends Device {
    @Override
    public void deviceDetails() {
        System.out.println("Laptop: Macboor Air 32GB M1 chip");
    }
}

class Desktop extends Device {
    @Override
    public void deviceDetails() {
        System.out.println("Desktop: Dell Inspiron, Intel i7, 32GB RAM");
    }
}

class Tablet extends Device {
    @Override
    public void deviceDetails() {
        System.out.println("Tablet: iPad Pro, M2 chip, 12.9 inch display");
    }
}

public class RuntimePolymorphism {
    public static void main(String args[]) {
        Device[] devices = {new Laptop(), new Desktop(), new Tablet()};

        for(Device device : devices) {
            device.deviceDetails();
        }
    }
}

/*
 * 
 * Here’s how you can explain this program in an interview, focusing on the key aspects of **runtime polymorphism**:

---

### **Introduction:**
"This program demonstrates runtime polymorphism by leveraging method overriding in Java. Runtime polymorphism allows behavior to be determined dynamically during execution, showcasing the flexibility and scalability of object-oriented programming."

---

### **Breakdown of the Code:**
1. **Base Class and Subclasses:**
   - "The base class `Device` defines a method `deviceDetails()` with a generic implementation. This method is overridden in the subclasses `Laptop`, `Desktop`, and `Tablet` to provide specific details for each device."
   - "This shows how subclasses customize the behavior of a method defined in the base class."

2. **Polymorphic Behavior:**
   - "In the `main()` method, I create an array of the base class type `Device[]` but store objects of the subclasses (`Laptop`, `Desktop`, `Tablet`)."
   - "Even though the array is of the base type, when the `deviceDetails()` method is called, the overridden version in the respective subclass is executed at runtime. This is achieved through dynamic method dispatch."

3. **Dynamic Method Dispatch:**
   - "Dynamic method dispatch is the key concept here, where the JVM decides at runtime which method implementation to call based on the actual object type. This demonstrates how runtime polymorphism ensures that the most specific version of a method is executed."

4. **Scalability and Use Case:**
   - "This approach is scalable because we can add new device types (e.g., `Smartphone`, `Smartwatch`) without changing existing code. The base class reference will automatically call the appropriate method for the new subclasses."

---

### **Key Features:**
- **Reusability and Maintainability:** "The base class provides a common interface for all subclasses, making the code reusable and easy to maintain."
- **Real-World Relevance:** "This concept is widely used in frameworks like Spring, where beans or objects are dynamically resolved based on the type."

---

### **Conclusion:**
"To summarize, this program highlights how runtime polymorphism enables us to write flexible and extensible code. It not only simplifies design but also allows behavior to adapt dynamically based on object type, which is a core principle of object-oriented programming."

---

By structuring your explanation this way, you demonstrate both technical understanding and practical relevance.
 */