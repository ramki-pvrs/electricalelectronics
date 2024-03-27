package com.ramki.javacollections;

//https://www.geeksforgeeks.org/collections-in-java-2/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
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
            In this implementation, objects are sorted and stored in ascending order according to their natural order. The TreeSet uses a self-balancing binary search tree, more specifically a Red-Black tree.
            
            Simply put, being a self-balancing binary search tree, each node of the binary tree comprises of an extra bit, which is used to identify the color of the node which is either red or black. During subsequent insertions and deletions, these “color” bits helps in ensuring that the tree remains more or less balanced.


         */
        
        Set<String> someTreeSet = new TreeSet<>();
        
        someTreeSet.add("Ramki");
        someTreeSet.add("Suni");
        someTreeSet.add("Teju");
        someTreeSet.add("Shammu");
        someTreeSet.add("Sudhir");
        someTreeSet.add("Ritu");
        someTreeSet.add("Ritu");
        
        
        System.out.println("LearnCollections - learnTreeSet after some add ops = " + someTreeSet.toString());
        //prints [Ramki, Ritu, Shammu, Sudhir, Suni, Teju]; OBSERVE unique, sorted 
        
        //TreeSet: first() This method returns the first element from a TreeSet if it’s not empty. Otherwise, it throws a NoSuchElementException.
        //TreeSet: last() Analogously to the above example, this method will return the last element if the set is not empty:
        //TreeSet subSet() This method will return the elements ranging from fromElement to toElement. Note that fromElement is inclusive and toElement is exclusive:
        //TreeSet headSet() This method will return elements of TreeSet which are smaller than the specified element:
        //TreeSet tailSet() This method will return the elements of a TreeSet which are greater than or equal to the specified element:

        //https://www.baeldung.com/java-tree-set
    }
    
    public void learnMAPImplementations() {
        System.out.println("Map implementations are HashMap, HashTable, LinkedHashMap, HashTreeMap");
    }
    
    

}
