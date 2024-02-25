package com.ramki.electricalelectronics;

public class TestTVByImplementingRunnable implements Runnable {
    
    private Television tvObj;
    private int newChannel;
    private int tvObjIndex; //only for testing; no real meaning

    public TestTVByImplementingRunnable(Television tvObj, int tvObjIndex) {
        super();
        this.tvObj = tvObj;
        this.tvObjIndex = tvObjIndex;
    }


    @Override
    public void run() {
        // TODO Auto-generated method stub
        
        try {
            Thread.sleep(100);
            this.tvObj.setCurrentChannel(newChannel);
            System.out.println("implements Runnable loop iterator = " + this.tvObjIndex); //random order printed
            if(this.tvObj.getCurrentChannel() == this.newChannel) {
                System.out.print("Test TV by implements Runnable: set current channel PASSed" + "\n");
            } else {
                System.out.print("Test TV by implements Runnable: set current channel FAILed" + "\n");
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
