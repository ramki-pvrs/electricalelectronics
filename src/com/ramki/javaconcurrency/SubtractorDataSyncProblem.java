package com.ramki.javaconcurrency;

public class SubtractorDataSyncProblem implements Runnable {
    
   private ValueForDataSync sharedValueObj;
    
    public SubtractorDataSyncProblem(ValueForDataSync sharedValueObj) {
        this.sharedValueObj = sharedValueObj;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            this.sharedValueObj.subtract(i);
            //System.out.println("sharedValue1 AFTER subtraction = " + sharedValueObj.getSharedValue());
        }   
    }
}
