package com.ramki.javaconcurrency;

import java.util.concurrent.locks.Lock;

public class SubtractorWithReentrantLock implements Runnable {

    private ValueForDataSync sharedValueObj;
    private Lock lock;
    
    public SubtractorWithReentrantLock(ValueForDataSync sharedValueObj, Lock lock) {
        this.sharedValueObj = sharedValueObj;
        this.lock = lock;
    }
    
    @Override
    public void run() {
        for(int i=1; i<=50; i++) {
            lock.lock();
            System.out.println("SubtractorWithReentrantLock obj acquired the lock!!!!");
            this.sharedValueObj.subtract(i);
            lock.unlock();
        }
    }

}
