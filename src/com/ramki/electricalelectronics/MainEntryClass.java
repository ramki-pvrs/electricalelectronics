package com.ramki.electricalelectronics;


import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

//user package classes from other package
import com.ramki.javaconcurrency.AdderDataSyncProblem;
import com.ramki.javaconcurrency.SubtractorDataSyncProblem;
import com.ramki.javaconcurrency.ValueForDataSync;


public class MainEntryClass {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        
        System.out.println("Entry into Electrical Electronics Project");
        
        List<String> brands = java.util.List.of("Panasonic", "LG", "Samsung", "Sony", "Redmi", "OnePlus", "Acer", "Apple", "TCL", "VUE", "Philips");
        
        List<String> screenResolutions = java.util.List.of("720P", "1080P", "1440P", "4K", "8K", "OLED", "Full HD", "Half HD");
        
        List<String> screenTypes = java.util.List.of("Plasma", "LCD", "LED", "OLED");
       
        //https://www.baeldung.com/java-enum-values

        System.out.println(ItemType.E1.type);
        System.out.println(ItemType.TV.type);
        System.out.println(ItemType.valueOf("E1"));
        
         
        
        
        //Java 9: use interface static method directly without object association
        System.out.println(ConvertCurrency.getUSDValue(100));
        
        System.out.println("START OOPS ======================================================");
            //Television(String itemTypeName, String itemSubTypeName, String itemBrandName, String itemMeasurementUnitType)
            Television tv1 = new Television("Electronics", "TV", "Panasonic", "Count");
            //Television(String itemTypeName, String itemSubTypeName, String itemBrandName, String itemMeasurementUnitType, Screen screen, String screenResolution, int currentChannel)
            Screen screen2 = new Screen("LED", 1000);
            Television tv2 = new Television("Electronics", "TV", "Panasonic", "Count", screen2, "OLED", -1);
            
            System.out.println("tv1 screenResolution = " + tv1.getScreenResolution()); //null because screen resolution is not in params for tv1; 
            System.out.println("tv2 screenResolution = " + tv2.getScreenResolution());
            
            System.out.println("screen2 screen type = " + screen2.getScreenType());
            
            System.out.println("BEFORE setTvON: tv2 on status = " + tv2.isTvON());
            tv2.setTvON(true);
            System.out.println("AFTER setTvON: tv2 on status = " + tv2.isTvON());
            
            //String randBrand = brands.get(new Random().nextInt(brands.size()));
            //String randResoln = screenResolutions.get(new Random().nextInt(screenResolutions.size()));
            
            //System.out.println("Random brand name = " + randBrand);
            
          //COPY CONSTRUCTOR; create new TV object using already created tv object
            
            Television tv3 = new Television(tv2, 1002);
            //DO NOT FORGET getScreen() to get Screen properties
            System.out.println("Orig tv object test; get screen type = " + tv2.getScreen().getScreenType());
            System.out.println("Targt tv object test; get screen type = " + tv3.getScreen().getScreenType());
            
            
            //Create array of objects
            int sizeOfTVObjList = 10;
            Screen screenObjList[] = new Screen[sizeOfTVObjList];
            Television tvObjsList[] = new Television[sizeOfTVObjList];
            
            System.out.println("tvObjsList size = " + tvObjsList.length);
            
            //Create multiple Television objects for testing purpose
            String randScreenType = "";
            String randBrand = "";
            String randResoln = "";
            
            for(int i = 0; i < tvObjsList.length; i++) {
                //System.out.println("Loop iterator i = " + i);
                
                randScreenType = screenTypes.get(new Random().nextInt(screenTypes.size()));
                randBrand = brands.get(new Random().nextInt(brands.size()));
                randResoln = screenResolutions.get(new Random().nextInt(screenResolutions.size()));
                
                //Screen(String screenType, int screenID)
                screenObjList[i] = new Screen(randScreenType, (int) ((Math.random() * (1000000 - 10000)) + 10000));
                tvObjsList[i] = new Television("Electronics", "TV", randBrand, "Count", screenObjList[i], randResoln, -1);
            }
            
            
            System.out.println("Brand name of TV from list of TV objects " + tvObjsList[3].getBrandName()); //prints random brand name
            System.out.println("TV objects count = " + Television.tvsCount); //tv1, tv2 and 100 tv objects in tvObjsList
            
            
            //Association: Composition
            ElectronicsStore rtnagar_store = new ElectronicsStore("RT Nagar Store", "Bangalore");
            Set<Television> televisions = new HashSet<>();
            televisions.add(tv1);
            televisions.add(tv2);
            for(int i = 0; i < tvObjsList.length; i++) {
                televisions.add(tvObjsList[i]);
            }
            
            //one store may have many televisions - so one to many relation 
            //uni-directional association; Store has a TVs, not the other way round (TV does not "has a" store)
            rtnagar_store.setTelevisions(televisions);
            System.out.println("Association Composition televisions in store = " + rtnagar_store.getTelevisions());
            //[com.ramki.electricalelectronicsproject.Television@edf4efb, com.ramki.electricalelectronicsproject.Television@566776ad, com.ramki.electricalelectronicsproject.Television@2f7a2457]
            
            
            
            
            

            
        System.out.println("END OOPS ======================================================");
        
        System.out.println("START Interfaces ======================================================");
        
        int currentYear = Year.now().getValue();
        System.out.println("Current Year = " + currentYear);
        
        //using interface static method without object reference
        //placeOrder(String itemMeasurementUnitType, String itemSubType, int unitPrice, int requiredQuantity)
        int tvOrder1 = BuyerMethods.placeOrder("Count", "TV", 1000, 50);
        
        System.out.println("tvOrder1 Order Number = " + tvOrder1);
        
        
        System.out.println("END Interfaces ======================================================");
        
        //https://www.baeldung.com/java-start-thread
        
        System.out.println("START extends Thread ======================================================");
        
        //THINK IN TERMS OF TASKS AND NOT THREADS
        
        //sample code for not preferred extend Thread approach
        //SAY YOU WANT TO TEST ALL 100 TVS (created in above code block - tvObjsList) WHETHER THEY ARE WORKING; 
        //the task is set the currentChannel to 402 in all of them, get the currentChannel and check it is 402
        
        
        TestTVByExtendingThread testTV1 = new TestTVByExtendingThread(tv1, 0);
        testTV1.start();
        
        for(int i = 0; i < tvObjsList.length; i++) {            
            TestTVByExtendingThread testTV = new TestTVByExtendingThread(tvObjsList[i], i);
            testTV.start();
        }
        
        
        System.out.println("END Thread ======================================================");
        
        System.out.println("START implements Runnable ======================================================");
        
        for(int i = 0; i < tvObjsList.length; i++) {            
            TestTVByImplementingRunnable testTV2 = new TestTVByImplementingRunnable(tvObjsList[i], i);
            Thread thread1 = new Thread(testTV2, "Test TV thread " + i); //object, threadName as string passed
            thread1.start();
            //System.out.println("Runnable thread name = " + thread1.getName());
        }
        
        
        System.out.println("END implements Runnable ======================================================");
        
        System.out.println("START Executors ThreadPool; use same TestTVByImplementingRunnable ======================================================");
        
        //Executor is an interface; Executors is a util class
        //Executor uses Runnable task, so you don't need to start() the thread, executor will do it for you
        //Task Submission and Running the task are decoupled
        Executor executor = Executors.newSingleThreadExecutor();
        
        
        
        //ExecutorService testTV_threadPool = Executors.newFixedThreadPool(MAX_THREADS); 
        
        for(int i = 0; i < tvObjsList.length; i++) {            
            Runnable testTV3 = new TestTVByImplementingRunnable(tvObjsList[i], i);
            executor.execute(testTV3);
        }
        
        //ExecutorService: 
        int MAX_THREADS = 10;
        
        //https://javainfinite.com/java/callable-and-runnable-examples-executorservice/
        ExecutorService testTV_threadPool = Executors.newFixedThreadPool(MAX_THREADS); 
        
        for(int i = 0; i < tvObjsList.length; i++) {            
            Callable<String> testTV4 = new TestTVByImplementingCallable(tvObjsList[i], i);
            Future<String> testTV_future = testTV_threadPool.submit(testTV4);
            
            try {
                
                String testTV_result = testTV_future.get();
                System.out.println("TV ON test result = " + testTV_result);
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        System.out.println("END Executors ThreadPool; use same TestTVByImplementingRunnable ======================================================");
        
        System.out.println("START Data Sync Issue Adder-Subtractor ======================================================");
        //https://medium.com/@codecraftclub/mutex-race-conditions-in-java-multi-threading-made-so-simple-with-real-life-analogies-705fb1697c10
        
        ValueForDataSync sharedValue1 = new ValueForDataSync();
        
        System.out.println("sharedValue1 BEFORE threads run = " + sharedValue1.getSharedValue());
        
        AdderDataSyncProblem adder1 = new AdderDataSyncProblem(sharedValue1);
        SubtractorDataSyncProblem subtractor1 = new SubtractorDataSyncProblem(sharedValue1);
        
        //if you implement Runnable (AdderDataSyncProblem and SubtractorDataSyncProblem), you need Threads to run them
        //ERROR: The method start() is undefined for the type Runnable
        //https://stackoverflow.com/questions/66666839/the-method-start-is-undefined-for-the-type-runnable
        /*
            That's because you need to start Threads - but you only need to run Runnables/ 
            A thread makes it run in parallel (kind of) to the currently executing thread. A runnable just runs in the current thread. 
            You can pre-populate a Thread with a runnable when you create it and then run it - the start() method in the Thread will call run().
            You can simply go Test t = new Test(); t.run(); and it will execute in the current Thread.
         */
        Thread adderThread1 = new Thread(adder1);
        Thread subtractorThread1 = new Thread(subtractor1);
        
        adderThread1.start();
        subtractorThread1.start();
        
        try {
            adderThread1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            subtractorThread1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("sharedValue1 AFTER threads run = " + sharedValue1.getSharedValue());
        
        
        System.out.println("END Data Sync Issue Adder-Subtractor ======================================================");
        
        System.out.println("START Non-Synchronized/Synchronized Summation ======================================================");
        //https://www.baeldung.com/java-synchronized
        
        ExecutorService es1 = Executors.newFixedThreadPool(3);
        ValueForDataSync sharedValue2Obj = new ValueForDataSync();
        
        IntStream.range(0, 1000).forEach(count -> es1.submit(sharedValue2Obj::nonSync_calculateSumOf_sharedValue2));
        es1.awaitTermination(1000, TimeUnit.MILLISECONDS);
        System.out.println("Non Sync Summation Expected 1000: " + sharedValue2Obj.getSharedValue2()); //not 1000 always; 973, 986...
        
        
        ExecutorService es2 = Executors.newFixedThreadPool(3);
        ValueForDataSync sharedValue2Obj2 = new ValueForDataSync();
        
        IntStream.range(0, 1000).forEach(count -> es2.submit(sharedValue2Obj2::synchronized_calculateSumOf_sharedValue2));
        es2.awaitTermination(1000, TimeUnit.MILLISECONDS);
        System.out.println("synchronized keyword Summation Expected 1000: " + sharedValue2Obj2.getSharedValue2()); //always 1000
        
        
        System.out.println("END Non-Synchronized/Synchronized Summation ======================================================");
        
        

    }

}
