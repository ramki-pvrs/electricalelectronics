# References Used



# Java Basics  

## Keywords  
- Class, Object, Attribute, Method, Constructor, Access Modifier, Non-Access Modifier, Interface, Association, Composition, Aggregation  
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
    -- Encapsulation is used to provide privacy and maintain control over transparency of data(getters and setters; immutable objects)
- Inheritance: Sub-class extending Parent Class
- Polymorphism:
   -- Compile Time Polymorphism (Early Binding): Method Overloading - same method name but different number of args or different type of args
   -- Run Time Polymorphism (Late Binding): Method Overriding - sub-class over-riding parent class  
   
## Randoms  
- As Grady Booch put it, "An object has state, behavior, and identity". 
 

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

## Interfaces  
- Interfaces abstract behavior of objects
- Class implements one or more Interfaces; csv of interfaces
- Class which implements an interface must implement all methods defined in that interface
-   




# Java Concurrency


# SOLID - basic coding style


