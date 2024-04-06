package com.ramki.chatgptmultithreading;

public class GPTSharedResource_DecrementThread implements Runnable {
    
    private GPTSharedResource sharedResource;
    
    public GPTSharedResource_DecrementThread(GPTSharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for(int i = 0; i <= 5; i++) {
            try {
                this.sharedResource.decrement();
                Thread.sleep(100);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
