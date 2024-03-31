package com.ramki.javacollections;

public class SomeTask {
    
    private String taskName;
    private int taskDeadlineInDays; //deadline 1 is higher priority compared to deadline 2 because you have 2 days to complete
    
    public SomeTask(String taskName, int taskDeadlineInDays) {
        this.taskName = taskName;
        this.taskDeadlineInDays = taskDeadlineInDays;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskDeadlineInDays() {
        return taskDeadlineInDays;
    }

    public void setTaskDeadlineInDays(int taskDeadlineInDays) {
        this.taskDeadlineInDays = taskDeadlineInDays;
    }
    
    

}
