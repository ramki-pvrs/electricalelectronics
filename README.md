# References Used  
- https://github.com/ramki-pvrs/electricalelectronics/blob/main/README.md 
- https://www.scaler.com/topics/association-composition-and-aggregation-in-java/ 
- https://www.oracle.com/java/technologies/java-base-system-libraries.html 
- https://docs.oracle.com/javase/tutorial/essential/concurrency/procthread.html



# Java Basics  

## Keywords  
- Class, Object, Attribute, Method, Constructor, Access Modifier, Non-Access Modifier, Interface, Association, Composition, Aggregation  
- **super** and **super()**: 1. to refer immediate parent class instance variable super.xyz; 2. invoke immediate parent class method super.doSome() 3. super() to invoke immediate parent class constructor
- **this** and **this()**:  1. refers to current instance this.<something>; can be used as first line in constructor to run this(zero or more args)
- Concurrency, Process, Thread  
    -- Producer/Consumer 
    -- Runnable (run, obj.start(task), no waiting on response)  
    -- Callable (call, obj.submit(task), future, obj.get() get the response)  
    -- volatile  
    -- thread_t2.join(); thread t1 calls t2 and when t2 says t2.join(), t1 is waiting for t2 to complete  
- 

## Abstraction, Encapsulation, Inheritance, Polymorphism (many forms)

- Abstraction: abstract implementation (Abstract class, Interfaces)
- Encapsulation: hide data and methods acting on that data - Private instance attributes in class; possible to update instantiated object only by getters and setters  
    -- Abstraction is design level process and Encapsulation is implementation level process  
    -- Encapsulation is used to provide privacy and maintain control over transparency of data(getters and setters (accessor and mutator); immutable objects)
- Inheritance: Sub-class extending Parent Class
- Polymorphism:
   -- Compile Time Polymorphism (Early Binding): Method Overloading - same method name but different number of args or different type of args
   -- Run Time Polymorphism (Late Binding): Method Overriding - sub-class method over-riding parent class method 
      -- method signature (name, parameters, and return type) should be same but implementation can be different
   
## Randoms  
- As Grady Booch put it, "An object has state, behavior, and identity"  
- Abstraction and Encapsulation both hides something; Abstraction hides implementation and Encapsulation hides object data and methods  
   -- to access hidden data, you have to use getters and to update hidden data use setters (another name is accessors and mutators)
 

## Abstract Classes

- Abstract classes can only be extended; meaning cannot have objects instantiated from Abstract classes  
- Abstract class can have both non-abstract and abstract methods  
	-- once you have an abstract method inside any class, that class should also be Abstract class (otherwise compile error)  
	-- abstract methods cannot be private because you have to implement them in sub-classes
	-- there is nothing like abstract variables/attributes, abstraction applies only to methods and classes  
- Concrete class extends abstract class  and should implement all abstract methods
- https://www.javatpoint.com/abstract-method-in-java - illegal combos
- Any class cannot be private or protected  

## Final Classes  
- Final class cannot be extended; no sub-classing from final  
- you create objects from final class and use them  
- https://stackoverflow.com/questions/5181578/what-is-the-point-of-final-class-in-java 
- https://programming.guide/java/when-to-create-a-final-class.html  


## Final Classes, Methods and Variables  
- In java final variables can't reassign, final classes can't extends and final methods can't override  
- As Grady Booch put it, "An object has state, behavior, and identity". 
   -- While we can't change an object's identity once its reference has been marked as final, we do have a chance to change its state by assigning new values to its non-final fields (provided, of course, it has them.)  
- final methods are useful when those methods are part of some public API call and should not be over-ridden  
- final variables must be initialized when declared or in constructor of the class they are declared  
- security and perfomance are benefits from final class, method or variables; compiler optmizes when it knows finals cannot be changed
   
# Access Modifiers and Non-access Modifiers  
## Access Modifiers  
- visibility control: in Java, Access modifiers help to restrict the scope of a class, constructor, variable, method, or data member  
- It provides security, accessibility, etc to the user depending upon the access modifier used with the element.
- **default**: can be used only within the package
- **private**: can only be used inside the class where it is declared
- **protected**: accessible within the same package or subclasses in different packages
- **public**: accessible from everywhere in the program  

## Non-access Modifiers  
- They are used with classes, methods, variables, constructors, etc to provide information about their behavior to JVM  
- **static**: memory management; apply to variables, methods, blocks, and nested classes  
    -- belongs to a class and not objects
    -- objects can use static variables and methods   
    -- object methods can use static variables but static methods (class methods) cannot use object variables  
    -- static methods can be overloaded but not over-ridden 
    -- can be public or private; if private can only be used inside class (increment serial number inside object constructor??) 
    -- https://stackoverflow.com/questions/7279887/what-is-the-use-of-a-private-static-variable-in-java
- **final**: applicable only to a variable, a method, or a class. It is used to restrict a user in Java  
   -- if applied to a class, that class cannot be extended  
   -- if applied to a method, that method cannot be over-ridden  
   -- if applied to a variable (attribute) it cannot be changed during course of the program execution once initialized 
        -- need to be initialized on declaration or in constructor of the class
- **synchronized**: Java Synchronization is used to make sure by some synchronization method that only one thread can access the resource at a given point in time.  
   -- Java provides a way of creating threads and synchronizing their tasks using synchronized blocks  
- **transient**:  used in serialization; at the time of serialization if we are not storing the variable value persistent, we use transient keyword  
   -- addresses security concerns, when user data arrives may be we dont want to store password or dob persistent  
   -- another use cases, add transient to calculated variables based on other variable; age from dob
- **volatile**:  Using volatile is yet another way (like synchronized, atomic wrapper) of making class thread-safe.  
   -- class SharedObj {
           //volatile keyword here makes sure that the changes made in one thread are immediately reflect in other thread
            static volatile int sharedVar = 6;
      }  
   -- https://www.geeksforgeeks.org/volatile-keyword-in-java/  
   -- Note that volatile should not be confused with the static modifier. static variables are class members that are shared among all objects. There is only one copy of them in the main memory. 
      **volatile vs synchronized**: Before we move on let’s take a look at two important features of locks and synchronization. 

**Mutual Exclusion**: It means that only one thread or process can execute a block of code (critical section) at a time.  
**Visibility**: It means that changes made by one thread to shared data are visible to other threads.
Java’s synchronized keyword guarantees both mutual exclusion and visibility. If we make the blocks of threads that modify the value of the shared variable synchronized only one thread can enter the block and changes made by it will be reflected in the main memory. All other threads trying to enter the block at the same time will be blocked and put to sleep. 

In some cases, we may only desire visibility and not atomicity. The use of synchronized in such a situation is overkill and may cause scalability problems. Here volatile comes to the rescue. Volatile variables have the visibility features of synchronized but not the atomicity features. The values of the volatile variable will never be cached and all writes and reads will be done to and from the main memory. However, the use of volatile is limited to a very restricted set of cases as most of the times atomicity is desired. For example, a simple increment statement such as x = x + 1; or x++ seems to be a single operation but is really a compound read-modify-write sequence of operations that must execute atomically.   


- **native**: only for methods; the native keyword in Java is applied to a method to indicate that the method is implemented in native code using JNI (Java Native Interface).  
   -- The methods which are implemented in C, C++ are called native methods or foreign methods.  
   
## Constructors  
- Constructor name is same as Class name
- Constructors are used to initialize the objects after they are created
- JVM provides default constructor without any args  
- Constructors can be overloaded - different number of args or different types of args makes them overloaded 
- Constructor chaining possible  - use constructor call super() or this() as first line in constructor; not both
- **super** keyword inside constructor as first line, makes parent constructor to be run
- **this** keyword inside constructor as first line, makes this class constructor to be run; either super or this only and not both 
   -- At the beginning of a constructor, you can call a different constructor of the same class by using this(parameter_1, ... parameter_n); as first instruction


    

## Interfaces  
- Interface **abstracts behavior of objects**  
- Class implements one or more Interfaces; csv of interfaces  
- Class which implements an interface must implement all methods defined in that interface
- while class is a blue-print of an object state(attributes and methods), interface is blue-print of object behavior (only methods)  
   -- Java supports only single inheritance but multiple interface implementations
- interface can contain attributes and only method definitions (methods are not implemented)  
- all methods are public  
- all attributes are public static final (that means they cannot be changed; only can be used)  
- an interface can extend another interface and a class which implements this interface chain should implement all methods of interfaces from the chain  
- **JDK 8**:  
   -- interface can contain default implementation for methods  
         -- when a new method added to the interface, it will still work with old class which implemented this interface but does have any implementation for this new interface method  
   -- define static methods in interfaces that can be called independently without an instance reference  
   
- In a Simple way, the interface contains multiple abstract methods, so write the implementation in implementation classes. If the implementation is unable to provide an implementation of all abstract methods, then declare the implementation class with an abstract modifier, and complete the remaining method implementation in the next created child classes. It is possible to declare multiple child classes but at final we have completed the implementation of all abstract methods.  

- **JDK 9**: interfaces can contain the following also Static Methods; Private Methods; Private Statis Methods 


## Association, Composition, Aggregation 
- A class can have a **"has-a" relationship** of objects from unrelated classes in Java. This is called association.
Association is a relationship between two classes where one class uses the other class. 
The two classes are unrelated, each can exist without the other one. 
Association can be a one-to-one, one-to-many, many-to-one, or many-to-many relationship.

Two types of Association : Composition and Aggregation

Aggregation: related objects can exist independently with "has a" relationship
Composition: tight coupling: "has a" relationship, better way is to say "belongs to" relationship; one cannot exist without the other
the objects’ life-cycles are tied. It means that if we destroy the owner object, its members also will be destroyed with it.
e.g. if library is destroyed all books in it are destroyed

in our ElectricalElectronics project, for example screen belongs to TV, 
if TV is destroyed that specific screen has no meaning by itself and it looses its existence

Note: you cannot say screen is a TV or TV is a screen, so no "is a" relation so no inheritance here but only association
Screen obj 34523 belongs to TV obj 563452; in this case it is one to one relation; one TV one Screen




# Java Concurrency


# SOLID - basic coding style


