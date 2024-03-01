package com.ramki.javaconcurrency;
import java.util.concurrent.locks.Lock;

//sharedValueObj is the data shared among threads; any manipulation of it using multiple threads at the same time is critical section
//lock is an interface type

public class AdderWithReentrantLock implements Runnable {
    
    private ValueForDataSync sharedValueObj;
    private Lock lock;
    
    public AdderWithReentrantLock(ValueForDataSync sharedValueObj, Lock lock) {
        this.sharedValueObj = sharedValueObj;
        this.lock = lock;
    }
    
    @Override
    public void run() {
        for(int i=1; i<=50; i++) {
            lock.lock();
            System.out.println("AdderWithReentrantLock obj acquired the lock!!!!");
            this.sharedValueObj.add(i);
            lock.unlock();
        }
    }
}
