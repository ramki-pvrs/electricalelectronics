package com.ramki.chatgptmultithreading;


//this GPT_Task is the one which you want to be executing in mutiple threads
//each object of this GPT_Task is the minimal execution you want in your program-process

//because it implements Runnable, you need to implement run() method
public class GPT_Runnable_Task implements Runnable {
    
    private String taskName;
    
    public GPT_Runnable_Task(String taskName) {
        this.taskName = taskName;
    }
    
    //this GPT_Task object does one task which is to print Performing task line i times
    //if main program calls this GPT_Task objects in a loop, then n * i time Performing tasks are printed
    @Override
    public void run() {
        try {
            System.out.println("Starting task....");
            
            //Perform some task
            for(int i = 1; i < 100; i++) {
                
                //96 to 99 will not be executed then because at 95, exception thrown each time this task is run ( a task to print Performing task i times
                if(i == 95) {
                    throw new RuntimeException("Simulated RuntimeException in " + i + " step. for taskName " + taskName);
                }
                System.out.println("Performig task " + i + " taskName = " + taskName);
                Thread.sleep(100);
            }
                        
            System.out.println("Completed task....");
        } catch(RuntimeException e) {
            System.out.println("Exception occurred in task: " + taskName + " - " + e.getMessage());
        } catch(InterruptedException e) {
            System.out.println("Thread interrupted while executing task: " + taskName);
        }
    }//END of public void run()
    

}
