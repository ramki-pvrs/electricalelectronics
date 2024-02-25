package com.ramki.electricalelectronics;

public class TestTVByExtendingThread extends Thread {
    
    private Television tvObj;
    private int newChannel;
    private int tvObjIndex; //only for testing; no real meaning

    public TestTVByExtendingThread(Television tvObj, int tvObjIndex) {
        super();
        this.tvObj = tvObj;
        this.tvObjIndex = tvObjIndex;
    }


    @Override
    public void run() {
        // TODO Auto-generated method stub
        //System.out.print("Test TV: before setting currenctChannel; currenctChannle = " + this.tvObj.getCurrentChannel() + "\n");
        //this.tvObj.setCurrentChannel(newChannel);
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
            this.tvObj.setCurrentChannel(newChannel);
            System.out.println("extends Thread loop iterator = " + this.tvObjIndex); //random order printed
            if(this.tvObj.getCurrentChannel() == this.newChannel) {
                System.out.print("Test TV by extends Thread: set current channel PASSed" + "\n");
            } else {
                System.out.print("Test TV by extends Thread: set current channel FAILed" + "\n");
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
