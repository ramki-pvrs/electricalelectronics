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
    -- Executor, ExecutorService, Future, 
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
- setters comes into picture afer object is created
- SOLID: remember if you are not supposed to do something in/with an object (class), you should not even have that method (behavior) in that class  
   -- for example fly method in birds class because some birds cannot fly  
-- **class loading**: https://www.geeksforgeeks.org/what-is-class-loading-and-static-blocks-in-java/  
-- https://www.javatpoint.com/classloader-in-java  
-- Class Loading is the process of storing the class-specific information in the memory. Class-specific information means, information about the class members, i.e., variables and methods. It is just like that before firing a bullet, first, we need to load the bullet into the pistol. Similarly, to use a class first we need to load it by a class loader. Static block runs only once in the life of a class. It can only access the static members and will only belong to the class.

Static Block is just like any block of code beginning with a ‘static’ keyword is a static block. Static is a keyword which when attached to the method, variable, Block makes it Class method, class variable, and class Block. You can call a static variable/method using ClassName. JVM executes the static block at “CLASS LOADING TIME”.

Execution Order: For every static block, there is an order in which static block/method/variable gets initialized. 

Static Block
Static Variable
Static Method

Illustration: Showcasing generic execution of that static block is supposed to happen with series of steps as mentioned.

Randomly considering a java file ‘File.java’, having a static block in it is followed by a series of steps as mentioned.
Compilation of java file.
Execution of java file.
Java virtual machine JVM is calling main method in the program.
Class is loaded and all the necessary information is stored in memory by now.
Execution of static block begins.  
- ============================================================================================
 

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


### Final Classes, Methods and Variables  
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
- Constructor name is same as Class name; 1. Default Constructor 2. Parameterized Constructor 3. Copy Constructor
- Constructors are used to initialize the objects after they are created
- JVM provides default constructor without any args  
- Constructors can be overloaded - different number of args or different types of args makes them overloaded 
- Constructor chaining (telescoping of constructors) possible  - use constructor call super() or this() as first line in constructor; not both
- **super** keyword inside constructor as first line, makes parent constructor to be run
- **this** keyword inside constructor as first line, makes this class constructor to be run; either super or this only and not both 
   -- At the beginning of a constructor, you can call a different constructor of the same class by using this(parameter_1, ... parameter_n); as first instruction 
### Copy constructor  
- you have to write it; no default copy constructor; shallow copy; deep copy  
   -- primitive values are easily copied  
   -- when it is objects (a list for example) as constructor params, shallow copy will only copy the reference pointer not the actual values; you need deep copy 
   -- to create an exact copy of an existing object of the class. There is also a condition, if we have made any changes in the copy it should not reflect in the original one and vice-versa. For such cases, Java provides the concept of a copy constructor.
   -- https://www.geeksforgeeks.org/copy-constructor-in-java/  
   -- Here’s a basic algorithm for implementing a copy constructor in Java: 
   1. Define a class: Create a class that represents the object you want to manage. 
   2. Define instance variables: Within the class, define instance variables that represent the data you want to manage. 
   3. Define a constructor: Define a constructor for the class that takes an instance of the same class as its argument. This constructor will be used to create a copy of the object. 
   4. Initialize the instance variables: Within the constructor, initialize the instance variables with the values from the argument object. 
   5. Use the this keyword to refer to the instance variables: To refer to the instance variables of the class within the constructor, use the this keyword.
   6. Check for null values: If the argument object is null, return a new instance of the class with default values for the instance variables. 
   7. Implement deep copying: If the instance variables are objects, create new instances of those objects within the constructor and initialize them with the values from the argument object. This is called deep copying and ensures that changes to the copied object do not affect the original object.


    

## Interfaces  
- Interface **abstracts behavior of objects**  
- Class implements one or more Interfaces; csv of interfaces  
- Class which implements an interface must implement all methods defined in that interface
- while class is a blue-print of an object state(attributes and methods), interface is blue-print of object behavior (only methods)  
   -- Java supports only single inheritance but multiple interface implementations
- interface can contain attributes and only method definitions (methods are not implemented)  
- all methods are public abstract
- all attributes are public static final (that means they cannot be changed; can only be used)  
- an interface can extend another interface and a class which implements this interface chain should implement all methods of interfaces from the chain  
- **JDK 8**:  
   -- interface can contain default implementation for methods  
         -- when a new method added to the interface, it will still work with old class which implemented this interface but does have any implementation for this new interface method  
   -- define static methods in interfaces that can be called independently without an instance reference  
   
- In a Simple way, the interface contains multiple abstract methods, so write the implementation in implementation classes. If the implementation is unable to provide an implementation of all abstract methods, then declare the implementation class with an abstract modifier, and complete the remaining method implementation in the next created child classes. It is possible to declare multiple child classes but at final we have completed the implementation of all abstract methods.  

- **JDK 9**: interfaces can contain the following also Static Methods; Private Methods; Private Static Methods 


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

- **Composition** is a strong type of "has-a" relationship because the containing object is its owner. So, objects are tightly coupled, which means if we delete the parent object, the child object will also get deleted with it. School has a class room and if School is not there that class room is not there; class room belongs to that school  
- **Aggregation**, objects are not tightly coupled or don't involve owning. All the objects are independent of each other and can exist even if the parent object gets deleted 
   -- A car comes with a wheel, and if we take off its wheels, the wheels will still exist. But a car without wheels won't be as useful as a car with its wheels 
   -- and that's how this relationship existed in the first place for assembling the parts to a bigger construct, **which is capable of more things than its parts**




# Java Concurrency 
-- https://medium.com/@codecraftclub/simplifying-java-multithreading-runnable-interface-with-a-construction-analogy-56852d7c3df0  
-- https://jenkov.com/tutorials/java-concurrency/creating-and-starting-threads.html
- **Concurrency and Parallelism**: illusion of multiple tasks running in parallel is Concurrency (time-slicing and context switching); multiple tasks running in parallel in real is Parallelism
- **Process and Thread**: Process is independent and Thread(s) is/are sub-set of process; CPU actually executes a thread and not a process 
   -- Process has its own PID, memory, call stack, 
   -- Thread uses process memory but has its own call stack
   --Single Core CPU based machines also can run multiple threads and processes  
       -- difference between single core and multi core is whether in parallel can we run multiple tasks without context switching 
- https://stackoverflow.com/questions/3042717/what-is-the-difference-between-a-thread-process-task  

- **think in terms of tasks and not threads**  
   -- analyse your requirements; can you break it down into multiple tasks  
   -- whether each task can run concurrently  
   -- dependencies between tasks  
   -- do the tasks manipulate shared data (same data) 
      -- do they need to do it sequential 
      -- or is there a possibility during runtime they will try read/write shared data at the same time (critical section)
   -- does one task need to call another task 
      -- does calling task need to wait on called task or it can terminate independently (.join())
   -- do we wait for results from task execution or not (callable or runnable) 
   
- **Thread Life Cycle : States**: New, (Runnable, Running), Blocked, Waiting, Timed Waiting, Terminated 
- A thread state. A thread can be in one of the following states  
   -- **NEW**: A thread that has not yet started is in this state  
   -- **RUNNABLE**: A thread executing in the Java virtual machine is in this state  
   -- **BLOCKED**: A thread that is blocked waiting for a monitor lock is in this state  
   -- **WAITING**: A thread that is waiting indefinitely for another thread to perform a particular action is in this state  
   -- **TIMED_WAITING**: A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state  
   -- **TERMINATED**: A thread that has exited is in this state.


**A thread can be in only one state at a given point in time. These states are virtual machine states which do not reflect any operating system thread states.**  

### Java Threading - two ways  
- Extending Thread Class  
   -- public myClass extends Thread  
   -- not preferred approach
- Implementing Runnable Interface  
  -- public myClass implements Runnable  
  -- preferred approach  because 
     -- once extended Thread you cannot extend any other parent class from your app  
     -- more importantly Runnable/Callable are having more control the way you want to be executing your threads and thread pool and separate management of creation and execution of threads



### Java Thread Program Concepts using Runnable interface
- your myClass implements Runnable interface  
   -- Runnable interface has run method which is implemented in myClass; (start() the run)  
   -- java.lang.Runnable is an interface that is to be implemented by a class whose instances are intended to be executed by a thread
   -- create myClassObj1
- create Thread class object thread1; Thread class provided by core  
   -- pass myClassObj1 to therad1 object as constructor parameter
   -- thread1.start() executes myClasObj1 run method internally
- typically it is create tasks, create threads add tasks to threads and load them up separately to some executors  
   -- executors manage the execution of the threads, sync, shared data handling, thread pool and all 
- **Runnable**: represents the code to be executed
- **Executor**: and its subclasses represent execution strategies. Consumes Runnable (task); sophisticated tools and Thread Pools, Future

# SOLID PRINCIPLES - basic coding style  

# Design Patterns 
- https://dzone.com/articles/java-singletons-using-enum 
- https://refactoring.guru/design-patterns/singleton 
- https://staff.cs.utu.fi/~jounsmed/doos_06/material/DesignPrinciplesAndPatterns.pdf 

- 
- Shared Vocabulary (problems at creation of objects)
- **Types of Design Patterns : 1. Creational 2. Structural 3. Behavioural** 
## Creational Design Patterns:  creation of objects  
- problems at the creation of objects 
- Singleton  - rarely used in normal dev scenarios  
   -- create class and instantiate only one object; user should not be able to create more than one  
   -- may be shared resources scenario where you dont want more than one object of same class (type) as shared resource  
   -- dB connection object; if constructor is available, no one can stop me from creating object  
   -- so restrict constructor access; private constructor - which means you can call it only inside **DBConn class**
   -- then getInstance method inside class DBConn { 
       **private static DBConn dbconn1 = null**; 
       //create a DBConn obj inside; if it is null create new one; else; return already created on new creation request
       //static dbconn1 will be accessed in static getInstance() method
       
      private DBConn(); //**PRIVATE CONSTRUCTOR**;
      //private constructor means not available for object instantiation outside class (new DBConn() is not possible)
     public static getInstance() { 
     
          if(dbconn1 == null) {
          		return new dbconn(); 
          } else {
          return dbconn1;
          }
       		
        } 
        
      } 
      
      with above logic DBConn.getInstance(); will always have only one connection object
   -- private constructor means, I am not allowing anyone else to create the object outside of me
   -- static getInstance() method means can be accessed only by class DBConn
   -- also if already created dbconn1 obj is present, I am not creating another one but returning existing object  
   
   -- IS the above dbconn logic thread safe? **NOT THERAD SAFE**  
      -- two threads calling getInstance() at the same time and seeing dbconn1 null may create two dbconn objects which is not what you wanted; Race Condition - Sync issue  
      
      -- METHOD 1 FIX: private static DBConn dbconn1 = new DBConn(); 
      //when class is loaded dbconn1 is initialised; we remove if(dbconn1 == null) check in above code block  
      // so even if multiple threads all of them will return the same object; threads are not even checking for dbconn1 object presence  
      -- METHOD 2 FIX: 
       1. lets say I dont want to increase my class loading time;  
       2. what if I want to pass dbconn params only on run time and not on class loading (which happens when APP is started) 
       -- METHOD 2 FIX: public static synchromised getInstance() {} will slow down because once first obj is created after that there is no critical section but threads will keep checking sync; 100 threads can directly use the obj because it is already created but synchronised key word on getInstance method will not allow it, it will keep checking
        -- FIX 2: use locks; DOES NOT SOLVE SYNC issue; more worse if you add lock() my-getInstance-codeblock unlock(); 
        -- **FINAL SOLN FOR SINGLETON DOUBLE LOCK**: you are in airport; get into toilet when it was free but you comeout for quick phone pick-up and you goback to the same toilet; but still you will knock before entering
        public static getInstance() {  //MAKE It public
        -- if(dbconn1 == null) {
       	 	lock();
        	if(dbconn1 == null) { //Double checking
        		db1conn = new DBConn();
        		unlock();
        	}
        } 
      -- SYNC issue solved; thread1 locks  and creates dbconn1 created; second therad comes in but 2nd null check will fail so directly return dbconn1 obj;
- Registry 
- Prototype 
- Factory 
- **Builder** 
  - only for class with lot of attributes and different type of attributes (int, String....)  
  - inheritance of different house types wodden, concrete, glass OR  
  - different parameterized constructors 2 params, 5 params, 100 params... for different config of a house or student class (object)  
  - **if you have lot of attributes, may be all the time you dont need all the attributes to create an object**  
  - may be setters (but not greate solution); setters comes into picture after object is created; now I am leaving the decision to the user of the object after it is created; not good
  - now try Builder design pattern  (consider it as alternative solution)  
   -- certain values for certain keys (attributes) - HashMap
   Map <String, Object> m;
   m.add("naeam" 12); user can pass wrong name or value; no control
   -- I need something like a map key-value pair; I need type checking on values; I need keys fixed; I need some check on keys as well;  
   -- which is then not HashMap but class; so you can have attributes as keys and data type to make sure values are of only allowed data types for those keys (attributes)
   -- so create a Helper class with same attributes of Student class and pass that Helper object h as the Constructor param in Student object s; this means in Student constructor you can apply all the validations before creating the student object
   
    
## Structural  
- Adapter  
- Facade 
- Decorator  
- Flyweight  
  
## Behavioral  
- Observer 
- Strategy 
- Command (Case Studies - splitwise)


