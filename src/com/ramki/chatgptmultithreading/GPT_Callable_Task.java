package com.ramki.chatgptmultithreading;

import java.util.concurrent.Callable;

public class GPT_Callable_Task implements Callable<String> {

    private String taskName;
    
    public GPT_Callable_Task(String taskName) {
        this.taskName = taskName;
    }
    
    
    
    
    @Override
    public String call() {
        try {
            System.out.println("Started task " + this.taskName);
            
            for (int i = 0; i < 5; i++) {
                if(i==3) {
                    throw new RuntimeException("Simulated RuntimeException when i == " + i + " for taskName = " + this.taskName);
                }
                System.out.println("Perform callable task for step i = " + i + " for taskName = " + this.taskName);
                Thread.sleep(100);
            }
            
            
            //being callable implementation, return is expected; Future in main will receive this return
            return "Completed task " + this.taskName;
            
            
        } catch(RuntimeException e) {
            return "Callable RuntimeException for taskName = " + this.taskName;
        } catch(InterruptedException e) {
            return "Callable InterruptedException for taskName = " + this.taskName;
        }
    }

}
