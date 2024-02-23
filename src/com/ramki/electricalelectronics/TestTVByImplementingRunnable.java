package com.ramki.electricalelectronics;

public class TestTVByImplementingRunnable implements Runnable {
    
    private Television tvObj;
    private int currentChannel;
    private int loopIterator; //only for testing; no real meaning

    public TestTVByImplementingRunnable(Television tvObj, int currentChannel, int loopIterator) {
        super();
        this.tvObj = tvObj;
        this.currentChannel = currentChannel;
        this.loopIterator = loopIterator;
    }


    @Override
    public void run() {
        // TODO Auto-generated method stub
        
        try {
            Thread.sleep(100);
            this.tvObj.setCurrentChannel(currentChannel);
            System.out.println("implements Runnable loop iterator = " + this.loopIterator); //random order printed
            if(this.tvObj.getCurrentChannel() == this.currentChannel) {
                System.out.print("Test TV: set current channel PASSed" + "\n");
            } else {
                System.out.print("Test TV: set current channel FAILed" + "\n");
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
