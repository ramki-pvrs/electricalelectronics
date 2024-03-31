package com.ramki.javacollections;


//Learn Queue - PriorityQueue - urgency here is message urgency
//1 is Very Urgent, 2 is Low Urgent, 3 is Medium urgent
//when you remove() message from priorityqueue, it will remove in that order


public class Message {
    
    private String content;
    private int urgency;
    
    //constructor
    public Message(String content, int urgency) {
        this.content = content;
        this.urgency = urgency;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUrgency() {
        return urgency;
    }

    public void setUrgency(int urgency) {
        this.urgency = urgency;
    }
}
