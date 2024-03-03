package com.ramki.javaconcurrency;

import java.util.concurrent.Semaphore;

public class ConsumerSemaphore implements Runnable {
    
    private Store store;
    private Semaphore producerSema;
    private Semaphore consumerSema;
    
    public ConsumerSemaphore(Store store, Semaphore producerSema, Semaphore consumerSema) {
        super();
        this.store = store;
        this.producerSema = producerSema;
        this.consumerSema = consumerSema;
    }

    @Override
    public void run() {
        int i = 10;
        while (i < 10) {
            try {
                consumerSema.acquire(); //decrement Thread-Permit
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            store.removeItem(); //only after Consumer has a permit, he can consume
            producerSema.release(); //increment Thread-Permit
            i--;
        }
    }

}
