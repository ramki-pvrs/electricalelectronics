package com.ramki.chatgptmultithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GPTSharedResource {
    
    private int counter = 0;
    private Lock lock = new ReentrantLock();
    
    
    
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void increment() {
        
        try {
            lock.lock();
            counter++;
            System.out.println("Incremented counter = " + this.counter);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            lock.unlock();
        }
        
    }
    
    public void decrement() {
        
        try {
            lock.lock();
            counter--;
            System.out.println("Decremented counter = " + this.counter);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            lock.unlock();
        }
        
    }

    
}
