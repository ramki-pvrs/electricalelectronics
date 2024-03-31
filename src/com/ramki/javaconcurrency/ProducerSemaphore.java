package com.ramki.javaconcurrency;

import java.util.concurrent.Semaphore;

//acquire -> count 
   //acquire means, from available Semaphore permits, 
   //you have acquired one; so now available permits are less one
//release -> count ++; 
   //release means what you have acquired earlier, 
   //you are letting go one Semaphore permit so now available permits are plus one
//prodSema = 5
//prodSema = 5 - 1 = 4
//consSema = 0
//consSema = 0 + 1 = 1
public class ProducerSemaphore implements Runnable {
    
    private Store store;
    private Semaphore producerSema;
    private Semaphore consumerSema;
    
    public ProducerSemaphore(Store store, Semaphore producerSema, Semaphore consumerSema) {
        this.store = store;
        this.producerSema = producerSema;
        this.consumerSema = consumerSema;
    }

    @Override
    public void run() {
        //continuously producing
        int i = 10;
        while (i < 10) {
            try {
                producerSema.acquire(); //decrement Permit by one
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            store.addItem(); //after Producer acquiring a thread-permit only he can add item to the shelf
            consumerSema.release(); //increment Permit by one
            i--;
        }
    }

}
