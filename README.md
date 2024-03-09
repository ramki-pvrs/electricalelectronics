# References Used  
- https://github.com/ramki-pvrs/electricalelectronics/blob/main/README.md 
- https://www.scaler.com/topics/association-composition-and-aggregation-in-java/ 
- https://www.oracle.com/java/technologies/java-base-system-libraries.html 
- https://docs.oracle.com/javase/tutorial/essential/concurrency/procthread.html



# Java Basics  

## Keywords  
- Abstraction, Encapsulation, Inheritance, Polymorphism
- Class, Object, Attribute, Method, Constructor, Access Modifier, Non-Access Modifier, Interface, Association, Composition, Aggregation  
- **super** and **super()**: 1. to refer immediate parent class instance variable super.xyz; 2. invoke immediate parent class method super.doSome() 3. super() to invoke immediate parent class constructor
- **this** and **this()**:  1. refers to current instance this.<something>; can be used as first line in constructor to run this(zero or more args)
- Concurrency, Process, Thread  (learn also Virtual Threads)
    -- Producer/Consumer 
    -- Runnable (run, obj.start(task), no waiting on response)  
    -- Callable (call, obj.submit(task), future, obj.get() get the response)  
    -- volatile  - https://www.baeldung.com/java-volatile 
    -- thread methods join(), wait()...
    -- thread_t2.join(); thread t1 calls t2 and when t2 says t2.join(), t1 is waiting for t2 to complete  
    -- Executors (util class); Executor (interface); ExecutorService (interface); ThreadPoolExecutor (class); Future; 
- Atomic Variables
- Collections, Generics, Java Lambda, Java Stream 
- Nested Classes 
  -- https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html 
  -- https://www.geeksforgeeks.org/nested-classes-java/
  -- Nested Classes - Inner Class, Local Class  
  -- Two Categories of Nested Classes: 1. static nested class 2. inner class 
     --- two special inner classes: 1. Local Inner Classes 2, Anonymous Inner Classes
- https://www.javatpoint.com/java-inner-class 
- Immutable Objects: An immutable object is an object whose internal state remains constant after it has been entirely created.  
  -- This means that the public API of an immutable object guarantees us that it will behave in the same way during its whole lifetime.
  -- https://www.baeldung.com/java-immutable-object 
  

## Abstraction, Encapsulation, Inheritance, Polymorphism (many forms)

- Abstraction: abstract implementation (Abstract class, Interfaces)
- Encapsulation: hide data and methods acting on that data - Private instance attributes in class; possible to update instantiated object only by getters and setters  
    -- Abstraction is design level process and Encapsulation is implementation level process  
    -- Encapsulation is used to provide privacy and maintain control over transparency of data(getters and setters (accessor and mutator); immutable objects)
- Inheritance: Sub-class extending Parent Class
- Polymorphism:
   -- Compile Time Polymorphism (Early Binding): Method Overloading - same method name but different number of args or different types of args
   -- Run Time Polymorphism (Late Binding): Method Overriding - sub-class method over-riding parent class method 
      -- method signature (name, parameters, and return type) should be same but implementation can be different
   
## Randoms  
- As Grady Booch put it, "An object has state, behavior, and identity"  
- Abstraction and Encapsulation both hides something; Abstraction hides implementation and Encapsulation hides object data and methods  
   -- to access hidden data, you have to use getters and to update hidden data use setters (another name is accessors and mutators)  
- setters comes into picture after object is created
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

- Remember that **ThreadPool** is a single instance; you may submit multiple tasks to the pool
- Executors is a helperclass; Executor and ExectorService are interfaces  
- Bounded queue in Java is limited size queue; unbounded is un-limited size 
  -- java.util package queues are Unbounded 
  -- java.util.concurrent pacage queues are bounded
- The double colon (::) operator, also known as method reference operator in Java, is used to call a method by referring to it with the help of its class directly. They behave exactly as the lambda expressions. The only difference it has from lambda expressions is that this uses direct reference to the method by name instead of providing a delegate to the method. Syntax:  
<Class name>::<method name>   
   -- https://www.geeksforgeeks.org/double-colon-operator-in-java/
   
   
- <> diamond operator; Generics and type checking context
  -- you can write List<String> list = new LinkedList(); you will get warning LinkedList is a raw type. References to generic type LinkedList<E> should be parameterized
  -- if you ask Eclipse to fix it, it will make it as List<String> list = new LinkedList<String>(); observe the String inside diamond operator on right side; before Java 7
  -- after Java 7 it should be: List<String> list = new LinkedList<>(); whatever the generic type on left side is assumed on right by JVM with empty <>; preferred approachG 
  
- Fail Fast and Fail Safe Iterators in Java

- Performance of TreeSet : Principle of Locality
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
- Constructor name is same as Class name; 
- 3 types: 1. Default Constructor 2. Parameterized Constructor(s) 3. Copy Constructor(s)  (refer Television.java)
- Constructors are used to initialize the objects after they are created
- JVM provides default constructor without any args  
- multiple constructors with different number of parameters or different types of parameters possible 
- Constructors can be overloaded - different number of args or different types of args makes them overloaded 
- Constructor chaining (telescoping of constructors) possible  - use constructor call super() or this() as first line in constructor; not both; refer Television.java
- **super** keyword inside constructor as first line, makes parent constructor to be run
- **this** keyword inside constructor as first line, makes this class constructor to be run; either super or this only and not both 
   -- At the beginning of a constructor, you can call a different constructor of the same class by using this(parameter_1, ... parameter_n); as first instruction 
### Copy constructor  
- no default copy constructor in Java; you have to write it; shallow copy; deep copy  
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
- better that cloning because in clone(), you need to Cloneable should be imported; we cannot assign values if original object attributes are final; clone() return should be typecasted. 


    

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
-- https://www.baeldung.com/java-util-concurrent
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
- RMEMBER: all executor calls uses generics because only at the time of call you know the datatype

- order of learning: Thread - Runnable - Callable - Executor - ExecutorService 
- you can use Thread class to run a thread (not recommended) 
- Runnable interface to start() the thread execution (which runs run method from your class implementing run() method from Runnable interface); no waiting on response from thread execution 
  -- The Runnable interface is a functional interface and has a single run() method that doesn’t accept any parameters and no return any values.
- Callable - submit() to run thread and return a future; future.get() to get the value from future 
  -- The Callable interface is a functional generic interface containing a single call() method that returns a generic value V: learn Generics
- Executor wraps runnable start() for single thread exec at a time
- ExecutorService thread pool and runnable and callable both supported
- Exceptions example: https://howtodoinjava.com/java/multi-threading/java-callable-future-example/#:~:text=Java%20Callable%20Future%20Example%201%201.%20Java%20Callable,it%20has%20been%20completed.%20...%203%203.%20Conclusion

### Executor Framework 
- https://www.geeksforgeeks.org/what-is-java-executor-framework/ 
- java.util.concurrent.Executor JDK 5 
- System (OS) level threads context switch is not good if we keep on creating new threads; context switching by OS and CPU time-slicing becomes very costly and actually the job may be slower
  -- so create known number of threads ThreadPool and attach tasks to thread pool 
  -- submit your task to an instance of Thread Pool for execution; ThreadPool instance controls re-use of already created threads from pool as and when tasks are completed otherwise maintain tasks in Queue
- run Runnable objects using Thread Pool (Executors framework provides factory methods to create Thread Pools) 
  -- worker threads; Queue 
  -- type of Java Executors 
  1. SingleThreadExecutor 
  2. FixedThreadPool(n)+ (fixed n number of Threads; Tasks wait in queue if all threads are busy currently)
  3. CachedThreadPool (dynamically creates thread pool on more work load; if current thread completes its job, re-used; uses SynchronousQueue)
  4. ScheduledExecutor  (cron job kind. run thread at scheduled interval; uses ScheduledExecutorService interface) 
- Executor and ExecutorService 
- An Executor that provides methods to manage termination and methods that can produce a Future for tracking progress of one or more asynchronous tasks... 
- "Execution" + "Service" == "ExecutionService" - 
   -- **Executor** just executes stuff you give it. cannot handle callables (meaning cannot wait for thread return values)
   -- **ExecutorService** adds startup, shutdown, and the ability to wait for and look at the status of jobs you've submitted for execution on top of Executor (which it extends). 
     -- Callable possible 
-  https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Executor.html
  -- **Executor**: An object that executes submitted Runnable tasks. **This interface provides a way of decoupling task submission from the mechanics of how each task will be run**, including details of thread use, scheduling, etc. **An Executor is normally used instead of explicitly creating threads**. For example, rather than invoking new Thread(new(RunnableTask())).start() for each of a set of tasks, you might use:
 Executor executor = anExecutor;
 executor.execute(new RunnableTask1());
 executor.execute(new RunnableTask2());
 ... 
 - **ExecutorService**: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html 
 -  public interface ExecutorService extends Executor
An Executor that provides methods to manage termination and methods that can produce a Future for tracking progress of one or more asynchronous tasks.
An ExecutorService can be shut down, which will cause it to reject new tasks. Two different methods are provided for shutting down an ExecutorService. The shutdown() method will allow previously submitted tasks to execute before terminating, while the shutdownNow() method prevents waiting tasks from starting and attempts to stop currently executing tasks. Upon termination, an executor has no tasks actively executing, no tasks awaiting execution, and no new tasks can be submitted. An unused ExecutorService should be shut down to allow reclamation of its resources.

Method submit extends base method Executor.execute(Runnable) by creating and returning a Future that can be used to cancel execution and/or wait for completion. Methods invokeAny and invokeAll perform the most commonly useful forms of bulk execution, executing a collection of tasks and then waiting for at least one, or all, to complete. (Class ExecutorCompletionService can be used to write customized variants of these methods.)

The Executors class provides factory methods for the executor services provided in this package.  
//https://www.baeldung.com/java-executor-service-tutorial

## MultiThreads - Critical Section and Mutex (Mutual Exclusion) 
- https://www.baeldung.com/java-mutex 
- https://www.baeldung.com/java-mutex#bd-synch
- Part of the code block which accesses shared resources (like data-structures, input-output devices, files, and network connections) are called **Critical Section** 
  -- in our project, 'ValueForDataSyncIssues' has a private attribute in it 'sharedValue' which is the shared resource; being object, it is by reference and 2 threads Adder and Subtractor adding and subrtacting from it at the same time gives random value 
  -- expectation after adder and subtractor is 0 but you will get some random
- **Race Condition**: when shared data is manipulated by multiple threads at the same time (critical section), we may get un-expected behavior, without proper handling of the sequencing only in critical section
- **Dead Lock**: two threads; you wait on me, I wait on you; no progress 
- 
   
 ## Synchronized Method vs ReentrantLock 
 - Note: if a room with 5 doors, how do you make sure only one person can go inside; 5 locks to 5 doors but single key 
       -- when one person gets the key and goes inside, <some action>, comes out locks his door and gives the key to the other person in next door,
### Producer Consumer problem (also known as the bounded-buffer problem)
- A shop with 5 shelves; at a time only one item per shelf (in SW those 5 shelves means a single data buffer or queue)
- Only when producer produces and shelf loaded, consumer can consume
- Only when a shelf is free, producer thread can enter the shop to load the shelf 
- with a single key approach, not effective because only one producer or consumer thread can access but based on current state of shelfs 5 threads are possible to be inside the shop  
     -- because as soon as a shelf is loaded consumer can consume or as soon as one shelf is free producer can load 
     
- https://www.geeksforgeeks.org/producer-consumer-solution-using-threads-java/
- In computing, the producer-consumer problem (also known as the bounded-buffer problem) is a classic example of a multi-process synchronization problem. The problem describes two processes, the producer and the consumer, which share a common, fixed-size buffer used as a queue. 

The producer’s job is to generate data, put it into the buffer, and start again.
At the same time, the consumer is consuming the data (i.e. removing it from the buffer), one piece at a time.
Problem 
To make sure that the producer won’t try to add data into the buffer if it’s full and that the consumer won’t try to remove data from an empty buffer.

Solution 
The producer is to either go to sleep or discard data if the buffer is full. The next time the consumer removes an item from the buffer, it notifies the producer, who starts to fill the buffer again. In the same way, the consumer can go to sleep if it finds the buffer to be empty. The next time the producer puts data into the buffer, it wakes up the sleeping consumer. 
An inadequate solution could result in a deadlock where both processes are waiting to be awakened.  
 
- Lock is an interface and ReentrantLock is a concrete class that implements Lock 
   -- a Reentrant lock is a mutual exclusion (mutex) mechanism that allows threads to reenter into a lock on a resource (multiple times) without a deadlock situation 
   -- A thread entering into the lock increases the hold count by one every time  
   -- similarly the hold count decreases when unlock is requested 


## Mutex vs Semaphore 
 - Mutex : single thread only and Semaphore more than one thread (inside a shop 5 shelves; mutex will allow only one producer or consumer; Semaphore will allow more than one producer/consumer based on number of shelves empty/loaded)

- In Java, Mutex and Semaphore are both synchronization primitives used to control access to shared resources in a multi-threaded environment, but they have different characteristics and use cases.

Mutex:

A mutex (short for mutual exclusion) is a synchronization primitive that allows only one thread to access a resource at a time. It ensures that only the thread that acquires the mutex lock can access the critical section of code, preventing other threads from entering until the lock is released.
In Java, mutexes are typically implemented using the synchronized keyword or the ReentrantLock class from the java.util.concurrent.locks package.
Mutexes are binary in nature, meaning they have only two states: locked and unlocked.
Mutexes are often used to protect critical sections of code or shared resources that can only be accessed by one thread at a time.


Semaphore: (Mutex(lock) + Count construct)


A semaphore is a synchronization primitive that controls access to a shared resource by maintaining a set of permits. Threads can acquire permits from the semaphore before accessing the resource, and release them when they are done.
Unlike mutexes, semaphores can allow multiple threads to access the resource concurrently, up to a specified limit defined by the number of permits available.
Semaphores can be used in scenarios where a resource has limited capacity or to control the number of threads accessing a resource simultaneously.
In Java, semaphores are implemented using the Semaphore class from the java.util.concurrent package.
In summary, the main difference between Mutex and Semaphore lies in their concurrency control mechanisms: Mutex allows only one thread to access a resource at a time, while Semaphore allows multiple threads to access the resource concurrently, up to a defined limit. The choice between them depends on the specific requirements of the application and the level of concurrency needed.


- A Mutex, short for "mutual exclusion," is a synchronization primitive used in concurrent programming to control access to shared resources. In Java, a Mutex typically refers to the concept of mutual exclusion achieved through various mechanisms such as the synchronized keyword or the Lock interface.

Here's an introduction to Java Mutex:

Purpose:

The primary purpose of a Mutex is to ensure that only one thread can access a resource or critical section of code at a time. It prevents concurrent access to shared resources, which could lead to data corruption or inconsistency.
Mechanism:

In Java, Mutexes are implemented using synchronization constructs such as the synchronized keyword, which provides intrinsic locking, or the Lock interface and its various implementations like ReentrantLock. These mechanisms allow threads to acquire and release locks to control access to critical sections of code or shared resources.
synchronized Keyword:

The synchronized keyword in Java provides built-in support for Mutexes. It allows methods or blocks of code to be synchronized, ensuring that only one thread can execute the synchronized portion at a time. When a thread enters a synchronized block or method, it acquires the intrinsic lock associated with the object or class and releases it when the block or method completes.
Lock Interface:

The Lock interface in the java.util.concurrent.locks package provides a more flexible alternative to intrinsic locks. It defines methods for acquiring and releasing locks explicitly, allowing finer-grained control over locking behavior. Implementations of the Lock interface, such as ReentrantLock, support features like lock interruption, timeout-based locking, and non-blocking try-lock operations.
Usage:

Mutexes are commonly used in multi-threaded Java applications to protect critical sections of code or shared resources from concurrent access. They ensure thread safety by enforcing mutual exclusion, preventing race conditions, and maintaining data integrity.
Mutexes are especially useful in scenarios where multiple threads need to access shared data structures, perform I/O operations, or execute critical sections of code that are not thread-safe.
Benefits:

Mutexes provide a simple and effective mechanism for achieving thread safety and preventing data corruption in concurrent programs.
They allow developers to coordinate access to shared resources and ensure that only one thread can modify the resource at any given time, reducing the risk of concurrency bugs and data inconsistencies.
In summary, a Mutex in Java is a synchronization primitive used to enforce mutual exclusion and control access to shared resources in multi-threaded applications. It plays a crucial role in ensuring thread safety and maintaining data integrity in concurrent programming environments. 


# JAVA Collections and Generics 
- https://www.geeksforgeeks.org/how-to-learn-java-collections-a-complete-guide/
- https://medium.com/@codecraftclub/generics-in-java-was-never-this-easy-a-complete-beginners-guide-c888c7263426 
- https://www.geeksforgeeks.org/collections-in-java-2/
## Generics 
- create classes, methods, and interfaces that can work with different data types while ensuring type safety - with "type parameters" (labels in looking same closed jars) 
- these type parameters specify what type of data each jar can hold 
- without Generics, for each data type, you need to be creating different classes
- Generics come to the rescue, allowing you to create a single, versatile container that can hold various types of data, just like those labeled jars help keep your kitchen organized. 
### Type Parameters and Representation
In Java, generics use type parameters, which are placeholders for specific data types. These type parameters can be represented in two common ways:

**Single Letter Convention**: Typically, single uppercase letters are used to distinguish from regular class or interface names. The most commonly used parameters are
E - Element (used extensively by the Java Collections Framework)
K - Key
N - Number
T - Type
V - Value
They don't carry any special meaning; they're just placeholders.
For example, the class java.util.HashMap<K, V> has two type parameters, K and V, representing the type of the keys and values, respectively, stored in the map. The interface java.util.List<E> has a single type parameter E representing the type of the elements stored in the list.

**Descriptive Names**: Sometimes, more descriptive names like KeyType or ValueType are used for type parameters, especially when clarity is important, just as you might use labels with descriptive names for your jars.

Syntax of a Generic Class -

class ClassName<T1, T2, ..., Tn> {
    // block of code
}

Here, T1, T2, …, Tn are the comma-separated type variables.
Let’s understand with an example:

class Box<T> {
    private T contents;

    public Box(T contents) {
        this.contents = contents;
    }

    public void printDataType() {
        System.out.println("Type: " + this.contents.getClass().getSimpleName());
    }
}

class Main{
   public static void main(String[] args) {
    Box<Integer> integerBox = new Box<>(42);
  integerBox.printDataType();

    Box<String> stringBox = new Box<>("Hello, Generics!");
  stringBox.printDataType();
}
}

// Output:
// Type: Integer
// Type: String

- Ramki: Box being a class, you can hold sugar in it, books in it, clothes in it; you will know this only when you create an object out of Box 
- at that time based on what you pass between <>, decides what type of object inside the box, run time decision 
### Generic Methods
- Syntax
<T1, T2, ..., Tn> returnType methodName(parameters) {
    // block of code
}

// Example Syntax -

  //Example 1
  public <T> void methodName(T obj) {
      // block of code
  }
  
  //Example 2
  public static <T, N> T methodName(T obj, N num) {
      // block of code
  }
  
  Example
  

### Generic Interfaces
- Syntax of a Generic Interface:

interface InterfaceName<T1, T2, ..., Tn> {
    // block of code
}

class ClassName<T1, T2, ..., Tn> implements InterfaceName<T1, T2, ..., Tn> {
    // block of code
}



// Example Syntax -

interface Pair<K, V> {
    K getKey();
    V getValue();
}  

### Bounded Types
- imagine if you wanted to limit the types that can be used with generics, just like specifying that a jar is for storing only chocolates. This is where bounded types come in.
Syntax of a Bounded Types:

<T extends A>

class NumberContainer<T extends Number> {
    private T value;

    public NumberContainer(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

class Main{
  public static void main(String[] args) {
    NumberContainer<Integer> intContainer = new NumberContainer<>(42);
    Integer intValue = intContainer.getValue(); // Works fine
    System.out.println(intValue);

    NumberContainer<Double> doubleContainer = new NumberContainer<>(3.14);
    Double doubleValue = doubleContainer.getValue(); // Works fine
    System.out.println(doubleValue);
    }
}

// Output -
// 42
// 3.14


## Java Collections 
- https://stackoverflow.com/questions/3047474/java-and-different-types-of-stacks 
- https://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist-in-java 
- https://www.baeldung.com/java-synchronized-collections **IMPORTANT TO LEARN**
- A stack is an abstract data type characterized by LIFO behaviour or push/pop operations
A list is an abstract data type characterized by having its elemets accessible through a numerical index.
An array is a low-level implementation of a list
java.util.List is the list type represented as a Java interface
java.util.Deque is a Java interface that provides both LIFO and FIFO queue behaviour (and thus stack behaviour as a subset)
java.util.Vector is an obsolete implementation of a list (based on an auto-resizing array) that should not be used anymore
java.util.ArrayList is its modernized replacement
java.util.Stack is an obsolete implementation of a stack that consists of adding some stack-like methods to a Vector, which is not a good way to do it.
java.util.ArrayDeque is a modern implementation of the Deque interface
java.util.LinkedList is a different implementation of a list (that also implements the Deque interface) that has a number of big disadvantages and should only be used in very specific cases (it is better when you need to insert or remove elements in the list very often).
Basically, if you want a stack, use the Deque interface and ArrayDeque as implementation class (except in the rare case where LinkedList is better). If you want a list, use ArrayList

Note the Vector and Stack are obsolete because all operations are synchronized. The newer implementations are not synchronized and it's up to the user to synchronize as necessary or wrap the list with a synchronized wrapper class (see java.util.Collections.synchronizedList()).


- Hierarchy of Interfaces and Concrete Classes implementing those interfaces 
- Interfaces: Iterable <extended by> Collection - extended by <List, Queue, Set> 
   -- Queue interface is extended by another interface Deque 
   -- Set interface extended by Sorted Set interface
### List interface - ArrayList is most useful data structure; others are not recommended much

## Synchronized Java Collections 
- https://www.baeldung.com/java-synchronized-collections 
    -- https://stackoverflow.com/questions/56776073/differences-between-concurrent-and-synchronized-collections-in-java
- NOTE: Synchronized Collecctions and Concurrent Collection in Java are two different things 
  -- Synchronized collections achieve thread-safety through intrinsic locking, and the entire collections are locked. Intrinsic locking is implemented via synchronized blocks within the wrapped collection’s methods. 
  -- Concurrent collections (e.g. ConcurrentHashMap), achieve thread-safety by dividing their data into segments. In a ConcurrentHashMap, for example, different threads can acquire locks on each segment, so multiple threads can access the Map at the same time (a.k.a. concurrent access). 
  -- 

## Java Concurrent Data Collections (chatgpt)
Java Concurrent Collections provide high-performance, thread-safe implementations of various collection types in Java. These collections are designed to be used in multi-threaded environments where multiple threads might concurrently access and modify the collections. Java Concurrent Collections are part of the java.util.concurrent package.

Here are some of the commonly used Java Concurrent Data Collections
ConcurrentHashMap: ConcurrentHashMap is a thread-safe implementation of the Map interface. It allows multiple threads to read and write concurrently without blocking each other. It achieves this through a technique called lock striping, where the map is divided into smaller segments, and locks are applied to each segment rather than the entire map.

ConcurrentSkipListMap: ConcurrentSkipListMap is a concurrent, sorted map implementation. It uses a skip list data structure, which allows for efficient concurrent access and provides logarithmic time complexity for most operations.

ConcurrentLinkedQueue: ConcurrentLinkedQueue is a thread-safe implementation of the Queue interface. It is based on a non-blocking, linked node structure, making it suitable for high-concurrency scenarios where multiple threads may concurrently enqueue and dequeue elements.

ConcurrentLinkedDeque: ConcurrentLinkedDeque is similar to ConcurrentLinkedQueue but implements the Deque interface, allowing elements to be added or removed from both ends of the deque. It provides similar concurrency guarantees as ConcurrentLinkedQueue.

CopyOnWriteArrayList: CopyOnWriteArrayList is a thread-safe variant of ArrayList. It creates a new copy of the underlying array whenever an element is added, removed, or modified, ensuring that iteration over the list is thread-safe and does not throw ConcurrentModificationException. This makes it suitable for scenarios where iteration is more common than modification.

CopyOnWriteArraySet: CopyOnWriteArraySet is a thread-safe variant of HashSet. It internally uses CopyOnWriteArrayList to store elements, ensuring thread safety during iteration and modification.

These collections provide various concurrency guarantees, such as thread safety, non-blocking behavior, and efficient concurrent access. However, developers should carefully choose the appropriate collection based on their specific concurrency requirements and performance considerations. Additionally, while these collections provide thread safety for individual operations, compound operations may still require external synchronization to maintain consistency.



# SOLID PRINCIPLES - basic coding style  

# Design Patterns 
- https://dzone.com/articles/java-singletons-using-enum 
- https://refactoring.guru/design-patterns/singleton 
- https://staff.cs.utu.fi/~jounsmed/doos_06/material/DesignPrinciplesAndPatterns.pdf 

- 
- Shared Vocabulary (problems at creation of objects)
- **Types of Design Patterns : 1. Creational 2. Structural 3. Behavioural** 
- https://www.baeldung.com/java-composite-pattern 
- https://medium.com/javarevisited/design-patterns-101-factory-vs-builder-vs-fluent-builder-da2babf42113 
   -- creating objects using new ContructorName(arg1, arg2, ...) everywhere has inherent design problems and complexity issues 
   -- creational patterns (templates) helps in location all object creation in one place 
   -- Factory or Builder 
   -- 
## Creational Design Patterns:  creation of objects  
- deal with problems at the creation of objects 
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


# PREPARATION TIPS
Week 1 : 
Topics
Abstraction 
Encapsulation
Classes and Objects
Class creation
Object creation
Access Modifiers
Constructors
Default Constructor 
Copy Constructor
Constructor Overloading
Deep copy vs Shallow copy
Pass by Reference vs Pass by Value
Inheritance
Constructor chaining
Polymorphism
Runtime Polymorphism
Compile Time polymorphism
Method overloading
Method overriding
Interfaces
Abstract class
Static 
Static methods
Final
Final method
Final Variable
Final class

Week 2 : 

Topics
Process Vs Thread
Multicore systems
Concurrency vs Parallelism
Context switching
Coding a Multi threaded program
Thread creation 
start()
wait()
sleep()
Thread pool
Thread lifecycle
Executors 
Runnable and Callables
Futures
Volatile keyword
Synchronization
Synchronization Issue (Adder / Subtractor Example)
Reasons of Issue
Properties of Best solution
Mutex
Synchronized keyword
Synchronized methods
Semaphores
Concurrent Data Structures
Atomic data types




Week 3 :

Topics
Collections 
Collection framework
Hierarchy of Collection Framework
List
Set
Queue
HashSet vs HashMap
TreeMap 
LinkedHashMap
Vector
ConcurrentHashmap
Generics
Function Interface
Lambda Functions
Streams
Terminal vs Intermediate methods
Parallel Streams
Functional Programming using Java
Exception Handling
Strings in Java
Garbage collection
Memory Management in Java


# Java 8
- https://medium.com/@fullstacktips/java-8s-game-changer-functional-interfaces-and-more-e6689213650d 
- https://stackoverflow.com/questions/5543216/java-interface-with-method-that-returns-called-object 
- https://www.baeldung.com/java-static-default-methods 
- In Java 8, interfaces gained the ability to have static methods. 
These methods are defined within the interface itself and can be called without needing an instance of the interface. 
**One interesting feature about static methods in interfaces is that they can have a return type that matches the interface name,**
**even if the actual return value is of a different type.**
- https://www.baeldung.com/java-strategy-pattern
- public interface Discounter {
    BigDecimal applyDiscount(BigDecimal amount);

    static Discounter christmasDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(0.9));
    }

    static Discounter newYearDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(0.8));
    }

    static Discounter easterDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(0.5));
    }
}
