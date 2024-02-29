package com.ramki.electricalelectronics;

import java.util.concurrent.Callable;

//test multiple TV objects by switching on them
//each tv takes time to switch on, so wait on the result by Future
//check tv on status
//pass or fail

public class TestTVByImplementingCallable implements Callable<String> {
    
    private Television tvObj;
    private int tvObjIndex; //only for testing; no real meaning

    public TestTVByImplementingCallable(Television tvObj, int tvObjIndex) {
        super();
        this.tvObj = tvObj;
        this.tvObjIndex = tvObjIndex;
    }

    @Override
    public String call() throws Exception {
        
        this.tvObj.setTvON(true);
        
        //TV takes time to switch on; so delay
        //TimeUnit.MILLISECONDS.sleep(100);
        //Thread.sleep(1000);
        
        if(this.tvObj.isTvON()) {
            System.out.println(this.tvObjIndex + ": TV ON " + Thread.currentThread().getName());
            return this.tvObjIndex + " TV is ON";
        } else {
            System.out.println(this.tvObjIndex + ": TV OFF " + Thread.currentThread().getName());
            return this.tvObjIndex + " TV is OFF";
        }
    }

}
