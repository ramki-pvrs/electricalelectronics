package com.ramki.javaconcurrency;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Store {
    
    private int maxSize;
    private ConcurrentLinkedDeque<Object> items;
    //concurrent DS
    
    public Store(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ConcurrentLinkedDeque<>();
    }
    
    public int getMaxSize() {
        return maxSize;
    }
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
    public ConcurrentLinkedDeque<Object> getItems() {
        return items;
    }
    public void setItems(ConcurrentLinkedDeque<Object> items) {
        this.items = items;
    }
    
    
    public void addItem() {
        System.out.println("Product production step; current size = " + this.items.size());
        this.items.add(new Object());
    }
    
    public void removeItem() {
        System.out.println("Consumer consuming step: current size = " + this.items.size());
        this.items.remove();
    }

}
