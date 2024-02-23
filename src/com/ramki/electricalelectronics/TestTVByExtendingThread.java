package com.ramki.electricalelectronics;

public class TestTVByExtendingThread extends Thread {
    
    private Television tvObj;
    private int currentChannel;
    private int loopIterator; //only for testing; no real meaning

    public TestTVByExtendingThread(Television tvObj, int currentChannel, int loopIterator) {
        super();
        this.tvObj = tvObj;
        this.currentChannel = currentChannel;
        this.loopIterator = loopIterator;
    }


    @Override
    public void run() {
        // TODO Auto-generated method stub
        //System.out.print("Test TV: before setting currenctChannel; currenctChannle = " + this.tvObj.getCurrentChannel() + "\n");
        this.tvObj.setCurrentChannel(currentChannel);
        //System.out.print("Test TV: after setting currenctChannel; currenctChannle = " + this.tvObj.getCurrentChannel() + "\n");
        
        /*
        if(loopIterator%2 == 0) {
            try {
                Thread.sleep(1000);
                if(this.tvObj.getCurrentChannel() == this.currentChannel) {
                    System.out.print("Test TV: set current channel PASSed" + "\n");
                } else {
                    System.out.print("Test TV: set current channel FAILed" + "\n");
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            if(this.tvObj.getCurrentChannel() == this.currentChannel) {
                System.out.print("Test TV: set current channel PASSed" + "\n");
            } else {
                System.out.print("Test TV: set current channel FAILed" + "\n");
            }
        }
        */
        
        try {
            Thread.sleep(100);
            System.out.println("extends Thread loop iterator = " + this.loopIterator); //random order printed
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
