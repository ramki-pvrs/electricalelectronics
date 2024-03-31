package com.ramki.javacollections;

//https://www.geeksforgeeks.org/how-to-learn-java-collections-a-complete-guide/
//https://www.geeksforgeeks.org/collections-in-java-2/
//https://beginnersbook.com/java-collections-tutorials/
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LearnCollections {
    
       //https://www.geeksforgeeks.org/iterators-in-java/
    
       //you iterate a collection object (which is already having data elements in it)
       //iterators are cursors (cursor has a specific meaning, once a row is handled it can only move forward and no reference to previous rows or data items; at a time cursor points to current object (element or row) only)
       //Java Cursors extended by Iterator, ListIterator and Enumeration (older)
       //Iterator and ListIterator are the ones to be used in new apps; 
       
       //ListIterator is specific to only List collections and not like for Set or Queue collections
   
    
       //Iterator itr = c.iterator(); 
       
       //initially iterator cursor points to the empty before the first element in collection
       //Iterator and ListIterator are interfaces so you apply their method (iterator() or listiterator()) on a collection object 
       //and that method has a Inner Class which will create an internal object and returns it to your itr variable (now itr is an object of type of that Inner Class, not visible to you)
       
       //Iterator methods are hasNext() next() and remove(); remove() requirs call to next() before it
       //ListIterator has Iterator methods + more methods like nextIndex(), previousIndex(), hasPrevious(), previous(), set(), add()
       //set(Object obj): Replaces the last element returned by next() or previous() with the specified element.
           //public void set(Object obj);
       //add(Object obj): Inserts the specified element into the list at the position before the element that would be returned by next()
           //public void add(Object obj);
    
    
      
    
       public void learnListInterface() {
           //https://www.geeksforgeeks.org/list-interface-java-examples/
           System.out.println("List is an interface in java.util package; import java.util.List; List extends Collection interface which inturn extends Iterator interface; It is a factory of the ListIterator interface.");
           System.out.println("List is implemented by ArrayList, LinkedList, Vector, Stack (Stack is child of Vector class) classes; Vector is deprecated in Java 5");
           System.out.println("List is ordered collection of objects, maintains insertion order, elements are accessed by index (positional access); 0 indexed");
           System.out.println("List being an interface, you cannot create an object of type List; you need one of the concrete classes like ArrayList;");
           System.out.println("List<String> firstNamesList = new ArrayList<String>(); OR List<Integer> someNumbers = new ArrayList<Integer>();");
       }
       
       public void learnArrayList() {
        
        //ArrayList is a concrete class implementing List interface
        //ArrayList resides within Java Core Libraries import java.util.ArrayList;
           //https://www.geeksforgeeks.org/array-vs-arraylist-in-java/?ref=rp
        //Array is primitive data structure; ArrayList is part of Java Collections
           //Array is fixed size whereas ArrayList is dynamic 
           //int arr[] = new int[10]; Simple fixed-sized arrays 
           //int arr [100] ; Dynamically sized arrays
           //access array element as arr[0]
           //Arraylist<Type> al = new ArrayList<Type>(); 
           //accessArrayList element with a1.get(2);
           // The array is a fixed-size data structure while ArrayList is not. One need not mention the size of the ArrayList while creating its object. Even if we specify some initial capacity, we can add more elements.
        
        /*
            List represents an ordered sequence of values where some value may occur more than one time.
            
            ArrayList is one of the List implementations built atop an array, which is able to dynamically grow and shrink as you add/remove elements. 
            Elements could be easily accessed by their indexes starting from zero. This implementation has the following properties:
            
            Random access takes O(1) time
            Adding element takes amortized constant time O(1)
            Inserting/Deleting takes O(n) time
            Searching takes O(n) time for unsorted array and O(log n) for a sorted one
         */
        
        //ArrayList being a concrete class, it has many constructors
        //Constructor with No Argument: empty ArrayList List<String> list = new ArrayList<>();
        //Constructor with initial size of arrayList List<String> list = new ArrayList<>(20);
        //Constructor with collection as arg: collection items are set as ArrayList elements
        
        
        List<String> listOfStrings1 = new ArrayList<>(); //with empty <> on RHS, whatever the LHS generic type, same is assumed on RHS side also
        List<String> listOfStrings2 = new ArrayList<String>(20);
        
        //List<String> list = new LinkedList<String>();
        
        Collection<Long> someLongNumbers = new ArrayList<>();
        
        System.out.println("LearnCollections- learnArrayList: Collections listOfStrings2 = " + listOfStrings2.toString() + " and size = " + listOfStrings2.size());
        
        Collection<Integer> someNumbers = IntStream.range(0, 10).boxed().collect(Collectors.toSet());
        
        System.out.println("LearnCollections: Collections someNumbers = " + someNumbers.toString());
        
        List<Long> someLongNumbers2 = new ArrayList<>();
        someLongNumbers2.add(1L); //L at the end of number indicates it is Long, Java notation
        someLongNumbers2.add(2L); 
        someLongNumbers2.add(23548556L); 
        
        System.out.println("LearnCollections - learnArrayList: Collections someLongNumbers2 = " + someLongNumbers2.toString());
        
        //https://www.geeksforgeeks.org/listiterator-in-java/
        //You can iterate ArrayList
        //You can add/remove from ArrayList
        //You can search ArrayList
        
        //Interesting Fact about ListIterator
        //ListIterator is an interface extends Iterator interface: it is a Cursor
        //There is no current element in ListIterator. Its cursor always lies between the previous and next elements. 
        //The previous() will return to the previous elements and the next() will return to the next element. 
        //Therefore, for a list of n length, there are n+1 possible cursors.
        
        ListIterator<Long> it = someLongNumbers2.listIterator(someLongNumbers2.size());

        while (it.hasPrevious()) {
            System.out.println("LearnCollections - learnArrayList: Collections listiterator = " + it.previous());
        }
        
        //https://www.baeldung.com/java-convert-iterator-to-list Java 8 appproach
        
        List<Integer> someIntegers1 = new ArrayList<Integer>();
        
        //lets say you have an Array of numbers and you want to add them to someIntegers1; using Java 8 Iterator.forEachRemaining
        Iterator<Integer> integerIterator = Arrays.asList(1,2,3,4,5,6).iterator(); //NOTE: .iterator() in Iterator interface has an inner class which returns an object
        
        integerIterator.forEachRemaining(someIntegers1::add);
        
        System.out.println("Convert Iterator to List someIntegers1 = " + someIntegers1.toString());
        //prints Convert Iterator to List someIntegers1 = [1, 2, 3, 4, 5, 6]
        
        //lets try set method on someIntegers1
        //if you are using ListIterator, remember you have to iterate through the someIntegers1, and on some condition you have to use set
        
        
        //how to set the last element
        //https://www.geeksforgeeks.org/replace-an-element-from-arraylist-using-java-listiterator/
        
        
        
        
        
    }
       
    public void learnSetInterfaceImplementations() {
        System.out.println("Set interface implementations (concrete classes) are HashSet, LinkedHashSet, TreeSet");
        //HashSet - a concrete class which implements Set interface (from Collections)
            //HashSet extends java.util.AbstractSet abstract class which in turn extends java.util.AbstractCollection abstract class
        //HashSet - stores uniq elements, allows nulls; internally a HashMap; does NOT maintain insertion order; NOT THREAD-SAFE
        //when internal is a Map (key-value pair), the item added to Set becomes key of the map and Java adds a constant as value to all keys (value can be same, only key should be unique then)
        //Critical Methods: .add(), .contains(), .remove(), .clear(), .size(), .isEmpty()
        //.iterator() - returns an iterator; The elements are visited in no particular order and iterators are fail-fast.
        //Fail-Fast iterators immediately throw ConcurrentModificationException if there is structural modification of the collection. 
        //Structural modification means adding, removing any element from collection while a thread is iterating over that collection. 
        //Iterator on ArrayList, HashMap classes are some examples of fail-fast Iterator.
        
        //How HashSet Maintains Uniqueness?
        //When we put an object into a HashSet, it uses the object’s hashcode value to determine if an element is not in the set already.
        //Each hash code value corresponds to a certain bucket location which can contain various elements, 
        //for which the calculated hash value is the same. But two objects with the same hashCode might not be equal.
        //Performance of Hashset: The performance of a HashSet is affected mainly by two parameters – its Initial Capacity and the Load Factor.
        //A low initial capacity reduces space complexity but increases the frequency of rehashing which is an expensive process.
        
        System.out.println("Set interface implementation HashSet");
        
        Set<String> someHashSet = new HashSet<>(); //Set is an interface and HashSet is implementation of Set
        
        ////Critical Methods: .add(), .contains(), .remove(), .clear(), .size(), .isEmpty()
        
        someHashSet.add("Ramki");
        someHashSet.add("Suni");
        someHashSet.add("Teju");
        someHashSet.add("Shammu");
        someHashSet.add("Sudhir");
        someHashSet.add("Ritu");
        someHashSet.add("Ritu");
        someHashSet.add(null); //null is possible
        someHashSet.add(null); //2nd null igonored anyway because HashSet is unique elements
        
        System.out.println("LearnCollections - learnHashSet after some add ops = " + someHashSet.toString());
        //prints [Shammu, Suni, Teju, Ramki, Sudhir, Ritu]; OBSERVE: not in insertion order; also Ritu is present only once even though added twics
        
        Set<String> someHashSet2 = new HashSet<>();
        someHashSet2.add("Ramki");
        someHashSet2.add("Suni");
        someHashSet2.add("Teju");
        someHashSet2.add("Shammu");
        someHashSet2.add("Sudhir");
        someHashSet2.add("Ritu");
        someHashSet2.add("Ritu");
        someHashSet2.add(null); //null is possible
        
        System.out.println("HashSet compare with equals() " + someHashSet.equals(someHashSet2)); //true
        System.out.println("HashSet hascode = " + someHashSet.hashCode()); //754115909
        
        
        Set<String> someHashSet3 = new HashSet<>();
        someHashSet3.addAll(someHashSet2);
        
        System.out.println("HashSet BEFORE remvoeAll someHashSet3 = " + someHashSet3.toString()); //[Shammu, Suni, Teju, Ramki, Sudhir, Ritu];
        someHashSet3.removeAll(someHashSet3);
        System.out.println("HashSet AFTER remvoeAll someHashSet3 = " + someHashSet3.toString());  //[]
        
        
        
        //HashSet methods 
        //equals()
        
        
        System.out.println("LearnCollections - learnLinkedHashSet");
        //The LinkedHashSet is an ordered version of HashSet that maintains a doubly-linked List across all elements. 
        //When the iteration order is needed to be maintained this class is used. 
        //When iterating through a HashSet the order is unpredictable, 
        //while a LinkedHashSet lets us iterate through the elements in the order in which they were inserted.
        
        //If you do not need the insertion order maintained, it is recommended to use the lighter-weight HashSet and HashMap instead.
        
        
        
        //All Implemented Interfaces are as listed below:
        //Serializable
        //Cloneable,
        //Iterable<E> ***
        //Collection<E> ****
        //Set<E>
        
        LinkedHashSet<String> someLinkedHashSet = new LinkedHashSet<>();
        someLinkedHashSet.add("Ramki");
        someLinkedHashSet.add("Suni");
        someLinkedHashSet.add("Teju");
        someLinkedHashSet.add("Shammu");
        someLinkedHashSet.add("Sudhir");
        someLinkedHashSet.add("Ritu");
        someLinkedHashSet.add("Ritu");
        someLinkedHashSet.add(null); //null value possible
        
        System.out.println("LearnCollections - learnLinkedHashSet after some add ops = " + someLinkedHashSet.toString());
        //prints [Ramki, Suni, Teju, Shammu, Sudhir, Ritu] : OBSERVE unique and insertion order maintained
        
        System.out.println("LearnCollections - learnTreeSet");
        /*
         the TreeSet is a sorted collection that extends the AbstractSet class and implements the NavigableSet interface.

            Here’s a quick summary of the most important aspects of this implementation:
            
            It stores unique elements
            It doesn’t preserve the insertion order of the elements
            It sorts the elements in ascending order
            It’s not thread-safe
            In this implementation, objects are sorted and stored in ascending order according to their natural order. 
            The TreeSet uses a self-balancing binary search tree, more specifically a Red-Black tree.
            
            Simply put, being a self-balancing binary search tree, each node of the binary tree comprises of an extra bit, 
            which is used to identify the color of the node which is either red or black. 
            During subsequent insertions and deletions, these “color” bits helps in ensuring that the tree remains more or less balanced.


         */
        
        Set<String> someTreeSet = new TreeSet<>();
        
        someTreeSet.add("Ramki");
        someTreeSet.add("Suni");
        someTreeSet.add("Teju");
        someTreeSet.add("Shammu");
        someTreeSet.add("Sudhir");
        someTreeSet.add("Ritu");
        someTreeSet.add("Ritu");
        //someTreeSet.add(null); TreeSet cannot have null; HashSet and LinkedHashSet can have null  as value
        
        
        System.out.println("LearnCollections - learnTreeSet after some add ops = " + someTreeSet.toString());
        //prints [Ramki, Ritu, Shammu, Sudhir, Suni, Teju]; OBSERVE unique, sorted 
        
        //TreeSet: first() This method returns the first element from a TreeSet if it’s not empty. Otherwise, it throws a NoSuchElementException.
        //TreeSet: last() Analogously to the above example, this method will return the last element if the set is not empty:
        //TreeSet subSet() This method will return the elements ranging from fromElement to toElement. Note that fromElement is inclusive and toElement is exclusive:
        //TreeSet headSet() This method will return elements of TreeSet which are smaller than the specified element:
        //TreeSet tailSet() This method will return the elements of a TreeSet which are greater than or equal to the specified element:

        //https://www.baeldung.com/java-tree-set
    }
    
    public void learnQueueImplementation() {
        System.out.println("Queue is an interface; implemented by PriorityQueue concrete class; Deque is interface which extends Queue interface; ");
        
        /*
         Priority Queue:
           - .remove() removes highest priority
           - highest priority means for example if you insert numbers and dont set any comparator for ordering, natural ASC ordering
           - so .remove() will remove lowest number
           
            When you remove an element from a PriorityQueue, 
            it removes the element that is considered the highest priority according to the ordering defined by the elements' natural ordering 
            or a Comparator provided during initialization.
         */
        
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(); //empty <> means type is assumed from Left Hand Side
        
        pq1.add(10);
        pq1.add(20);
        pq1.add(2);
        pq1.add(200);
        
        System.out.println("Priority Queue pq1 = " + pq1); 
        //prints Priority Queue pq1 = [2, 20, 10, 200]
        
        pq1.remove();
        
        System.out.println("Priority Queue pq1 after remove() = " + pq1); 
        //prints Priority Queue pq1 after remove() = [10, 20, 200] //due natural ASC order for Integers, 2 is removed, highest priority is 2
        
        /*
         In this example, pq.remove() removes the element with the highest priority, 
         which is the smallest number in this case because integers are naturally ordered. 
         You can remove any element from the PriorityQueue, 
         but it will always remove the element with the highest priority according to the defined ordering.
         
         In the context of Java's PriorityQueue, the term "Priority" refers to the concept that elements are retrieved in a specific order based on their priority 
         or some defined ordering criterion.

         The PriorityQueue class in Java is a data structure implementation that orders its elements according to their natural ordering 
         (if they implement the Comparable interface) or by a Comparator provided at the queue's construction time. 
         Elements with a higher priority (i.e., those that compare as "less than" other elements) 
         are dequeued before elements with lower priority.

         The term "priority" implies that certain elements have precedence over others based on some criteria. 
         This can vary depending on the application. For example, in a task scheduler, 
         tasks with earlier deadlines might have higher priority. 
         In a messaging system, messages marked as urgent might have higher priority.

          So, when we call it a "PriorityQueue," it signifies that elements are stored and retrieved based on their priority, 
          ensuring that elements with higher priority are dequeued before elements with lower priority.
         */
        
        //you can pass custom comparator to PriorityQueue
        //for that first lets create custom comparator
        //inside angle bracket, it is type passed to Comparator interface which has generic type inside
        
        /*
        the below Comparator section
        The syntax you're referring to is an example of an anonymous class in Java. In this context, it's specifically used to implement the Comparator interface by defining its compare() method.

        Here's the breakdown of the syntax:
        
        1. `new Comparator<Message>() { ... }: This part creates an instance of an anonymous class that implements the Comparator interface for the Message class. 
        It's anonymous because it doesn't have a specific name like a named class would.
        
        2. @Override: This annotation indicates that the compare() method is overriding a method defined in the Comparator interface. 
        It helps catch errors at compile time if the method signature doesn't match any method in the interface.
        
        3. public int compare(Message m1, Message m2) { ... }: This is the implementation of the compare() method required by the Comparator interface. 
        Within this method, you specify the logic for comparing two Message objects based on their urgencies.
        
        4. Anonymous classes are useful when you need a quick, one-off implementation of an interface or a subclass of a class without creating a separate named class. 
        They're commonly used for event listeners, thread creation, and implementations of interfaces with a single method, like Comparator, 
        where you need to provide the implementation inline.

        */
        
        
        Comparator<Message> messageCustomComparator = new Comparator<Message>() {
            @Override
            //Higher urgency messages should have higher priority that means their integer should be lower that other message 1 is High Priority and 2 is low priogrity
            public int compare(Message m1, Message m2) {
                return Integer.compare(m1.getUrgency(), m2.getUrgency());
            }
        };
        
        PriorityQueue<Message> messageQueue = new PriorityQueue<Message>(messageCustomComparator);
        
        messageQueue.add(new Message("High Priority Message", 2));
        messageQueue.add(new Message("Highest Priority Message", 1));
        messageQueue.add(new Message("Low Priority Message", 3));
        messageQueue.add(new Message("Medium Priority Message", 4));
        /*
         prints 
         Message = Highest Priority Message and its urgency = 1
         Message = High Priority Message and its urgency = 2
         Message = Low Priority Message and its urgency = 3
         Message = Medium Priority Message and its urgency = 4
         
         In this example:

            We define a Message class with fields for content and urgency.
            We create a custom Comparator to compare Message objects based on their urgency.
            We initialize a PriorityQueue for Message objects with the custom comparator.
            We add messages with different urgencies to the queue.
            When we retrieve messages from the queue using poll(), they are retrieved in order of urgency, with higher urgency messages dequeued first.
            
         */
        
        while(!messageQueue.isEmpty()) {
            Message msg = messageQueue.poll(); //poll() will remove highest priority item first
            System.out.println("Message = " + msg.getContent() + " and its urgency = " + msg.getUrgency());
        }
        
       
        //Anonymous class after new Comparator<SomeTask>() {Anonymous class and its instance is immediate}
        Comparator<SomeTask> taskCustomComparator = new Comparator<SomeTask>() {

            @Override
            public int compare(SomeTask t1, SomeTask t2) {
                return Integer.compare(t1.getTaskDeadlineInDays(), t2.getTaskDeadlineInDays());
            }
            
        };
        
        PriorityQueue<SomeTask> tasksWithDeadline = new PriorityQueue<SomeTask>(taskCustomComparator);
        
        /*
         When two messages have the same urgency in a PriorityQueue with a custom comparator, 
         the order in which they are dequeued from the queue 
         might not be deterministic unless the comparator considers additional factors for comparison.
         */
        tasksWithDeadline.add(new SomeTask("Task 2", 10));
        tasksWithDeadline.add(new SomeTask("Task 1", 10));
        tasksWithDeadline.add(new SomeTask("Task 3", 20));
        tasksWithDeadline.add(new SomeTask("Task 4", 30));
        
        while(!tasksWithDeadline.isEmpty()) {
            SomeTask t = tasksWithDeadline.remove();
            System.out.println("Some Task t = " + t.getTaskName() + " and this task deadline in days = " + t.getTaskDeadlineInDays());
        }
        
        
        
        
    }
    
    public void learnMAPImplementations() {
        System.out.println("Map implementations are HashMap, HashTable, LinkedHashMap, HashTreeMap");
        /*
         * 
         * Map - generic interface with Map<K, V> Key Value
         Map - key - value; keys are unique
         from a Map, you can get key Set, key-value pairs, collection of only values
         mappings are stored based on the key part of the map, similar to Sets
         key - hashCode storage
         
         
         HashMap implements Map interface
         -- for every entry in HashMap as hashCode is computed and each key-value pair is inserted in HashMap with hashCode as its index (to remember 3 columns, hashCode, Key, Value which is a unique row)
         -- HashMap has constant time performance for basic retrieval, insertion, deletion, and manipulation operations
         -- The two most important factors that affect the performance of a HashMap are initial capacity and load factor
         https://www.geeksforgeeks.org/differences-between-hashmap-and-hashtable-in-java/
         
         Interfaces: Map, SortedMap
         Classes: HashMap, HashTable, LinkedHashMap (insertion order), TreeMap (natural order or Comparator order)
         Abstract Classes: AbstractMap
         
         */
        
          //car objects stored with their vin as key
          Map<String, Car> carsMap = new HashMap<String, Car>();
          
          
          Car vw = new Car("227H54", "1997 Volkswagen");
          Car mustang = new Car("448A69", "1965 Mustang");
          Car porsche = new Car("453B55", "2007 Porsche");
          Car bmw = new Car("177R60", "1980 BMW");
          
          
          //vin is the key and Car is the value (happens to be Car object)
          //so if you get by vin (key), you are getting the Car object
          
          carsMap.put(vw.getVin(), vw);
          carsMap.put(mustang.getVin(), mustang);
          carsMap.put(porsche.getVin(), porsche);
          carsMap.put(bmw.getVin(), bmw);
          
          Car getMustangCar = carsMap.get(mustang.getVin());
          
          //you can get all keys as Set
          Set<String> carsVins = carsMap.keySet();
          
          //you can get all Values (Car objects)
          Collection<Car> cars1 = carsMap.values();
          
          //Map is a generic interface
          //from carsMap you can get Set of Map.Entry of items
          //each entry is a key and value
          
          
          Set<Map.Entry<String, Car>> carEntries = carsMap.entrySet();
          //how do you iterate such entries
          for(Map.Entry<String, Car> carEntry : carEntries) {
              System.out.println("Key = " + carEntry.getKey());
              System.out.println("Value = " + carEntry.getValue());
              
          }

    }
    
    

}
