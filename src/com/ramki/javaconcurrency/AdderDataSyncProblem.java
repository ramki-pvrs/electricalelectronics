package com.ramki.javaconcurrency;

public class AdderDataSyncProblem implements Runnable {
    
    private ValueForDataSync sharedValueObj;
    
    public AdderDataSyncProblem(ValueForDataSync sharedValueObj) {
        this.sharedValueObj = sharedValueObj;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 5000; i++) {
            this.sharedValueObj.add(i);
        }
    }
}
