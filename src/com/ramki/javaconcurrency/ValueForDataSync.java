package com.ramki.javaconcurrency;


//Adder and Subtractor threads adding and subtracting to/from this sharedValue is critical section
//doing so at the same time is Race Condition, expectation of final output is 0 but you get some random value (when no sync solution is applied)
public class ValueForDataSync {
    
    private int sharedValue = 0;
    
    private int sharedValue2 = 0;
    
    public int getSharedValue() {
        return sharedValue;
    }

    public void add(int someNumber) {
        this.sharedValue += someNumber;
    }
    
    public void subtract(int someNumber) {
        this.sharedValue -= someNumber;
    }
    
    
    public int getSharedValue2() {
        return sharedValue2;
    }

    public void setSharedValue2(int sharedValue2) {
        this.sharedValue2 = sharedValue2;
    }
    
    public void nonSync_calculateSumOf_sharedValue2() {
        this.setSharedValue2(this.getSharedValue2() + 1);
    }
    
    //When a thread enters a synchronized block or method, 
    //it acquires the intrinsic lock associated with the object or class 
    //and releases it when the block or method completes.
    public synchronized  void synchronized_calculateSumOf_sharedValue2() {
        this.setSharedValue2(this.getSharedValue2() + 1);
    }
    
}
