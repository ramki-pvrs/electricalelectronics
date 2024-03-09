package com.ramki.designpatterns;

public interface MyInterface {
    
    void abstractMethod(int n); // Abstract method
    
    static MyInterface create() {
        return n -> {
            System.out.println("Executing abstractMethod with parameter: " + n);
            // Additional logic here
        };
    }

}
