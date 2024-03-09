# Java Design Patterns 
- **Three types Creational, Structural and Behavioral** 
- https://www.geeksforgeeks.org/design-patterns-understand-the-importance-with-real-life-examples/ 
- https://www.geeksforgeeks.org/gang-of-four-gof-design-patterns/
- https://medium.com/@TechiesSpot/a-comprehensive-guide-to-design-patterns-in-java-c273ad7ebd94
- https://medium.com/javarevisited/builder-design-pattern-in-java-3b3bfee438d9
- https://medium.com/javarevisited/design-patterns-101-factory-vs-builder-vs-fluent-builder-da2babf42113 
- https://www.baeldung.com/cs/builder-pattern-vs-factory-pattern 
- https://stackoverflow.com/questions/328496/when-would-you-use-the-builder-pattern/329194#329194
- https://www.baeldung.com/java-composite-pattern 
- https://www.baeldung.com/java-immutable-object 
- https://www.geeksforgeeks.org/nested-classes-java/ 

- https://stackabuse.com/creational-design-patterns-in-java/
- https://stackabuse.com/structural-design-patterns-in-java/

# Requirements for design patterns 
- The basic form of object creation (the new operator calling constructors) everywhere result in design problems and add complexity.
- common vocabulary for developers to talk about software solutions 
- design patterns are just **templates** that give a proper flow, linking, and structure to your code 
- Computing researchers and practitioners developed a variety of organizational concepts and methodologies for designing quality object-oriented software that is concise, correct, and reusable, which describes a solution to a “typical” software design problem. A pattern provides a general template for a solution that can be applied in many different situations. You can use these templates million of times to solve some specific types of problems. 
- Patterns don’t provide solutions, they inspire solutions.

## Creational - Factory and Abstract Factory Method 
- ElectronicsFactory in our ElectricalElectronics Project?? 
- assemble() (createProduct() equivalent ??), testit(), boxit() are methods required by most electronics items like TV, Mobile Phone, DVD Player; or different types of TVs like LCD, LED, OLED and different sizes
  -- being methods they belong to one or more interfaces 
  -- it could be that TV Factory is different from Mobile Phone Factory; then ElectronicsFactory could be abstract factory and TVFactory or MobfileFactory could be concrete factory pattern 
  -- that means ElectronicsFactroy will produce TVFactory or MobileFactory based on whether TV or Mobile is passed as factory type
- one TV creation in factory is a single method (remember single conveyer belt with all TV parts available inside production line) 
- same for Mobile Phone, DVD Player...

- https://medium.com/javarevisited/design-patterns-101-factory-vs-builder-vs-fluent-builder-da2babf42113
- A factory is an object for creating other objects. The Factory is a wrapper for a constructor, i.e., it is used to build one entire object in a single method call 

## Creational - Builder Design Pattern
- https://medium.com/javarevisited/builder-design-pattern-in-java-3b3bfee438d9
- https://medium.com/javarevisited/design-patterns-101-factory-vs-builder-vs-fluent-builder-da2babf42113 
- https://medium.com/@TechiesSpot/a-comprehensive-guide-to-design-patterns-in-java-c273ad7ebd94

- when there are large number of attributes for a single object, many mandatory and many optional attributes, if all of the attribute values are not available in one go to create the object 
  -- also getting the attribute values itself could be a complex process 
  -- you may have to construct the object step by step, you can use Builder design pattern 
  -- on negative side, if you have to use the Constructors for the same use case, it will be numerous constructors to be overloaded and error prone
  -- Builder is like an intermediate step to collect all required to produce the product, then produce the product
- a Builder of an object is wrapper for that object, used when the object has to be constructed with large attributes step by step and those attribute values are not available in one go 
  -- Builder isolates Product's internal representation from steps to construct the product (meaning after steps are followed, in one go represent the internal structure of the product)
  -- Use the Builder pattern to get rid of many constructors which provides default values for the product state 
  -- Builder creates the product like Factory pattern but in Factory creating is one step, whereas in Builder it is multiple setValue calls before finally Product is created
  -- each Builder-setValue call adds a new part to the product 
  -- When the Builder has been provided with everything needed, its method get() can be called to assemble the new Product with the elements that Builder received before.
  -- lets say you are making a 4 door wardrobe at home, Builder is like collecting all required items one by one in 10 days keep all of them in Garage 
      -- you may have to travel 10 km to get the wood panels - a complex process to get one part (attribute) of the product (object)
  -- .get() is like assemble all of them in one day to get the final 4 door wardrobe
  -- Factory to produce such wardrobes, Godrej factory - all items are already present in inventory and you start assembling each wardrobe in one go 
- When obtaining each attribute value itself a very complex process, a Director class between Client (main) and Builder interface would help, 
  -- Director will direct collection and processing of attributes
  
## OBSOLETE DESIGN PATTERNS
- https://dev.to/tylerwbrown/obsolete-design-patterns-command-pattern-4ijf