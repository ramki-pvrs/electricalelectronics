package com.ramki.chatgptmultithreading;

public class GPTSharedResource_IncrementThread implements Runnable{
    
    private GPTSharedResource sharedResource;
    
    public GPTSharedResource_IncrementThread(GPTSharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for(int i = 0; i <=5; i++) {
            try {
                this.sharedResource.increment();
                Thread.sleep(100);
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        
    }

}
