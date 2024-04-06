package com.ramki.java8features;

//only one abstract method
public interface FunctionalInterface1 {
    
    //Functioanal Interfaces cannot have data members like int num1 = 0;
    
    //abstract method; abstract keyword is optional
    //abstract void abstractFun(int x);
    //that means default and static functions in this interface must have those key words
    
    void abstractFun(int x);
    
    default void someDefaultMethod(String myName) {
        System.out.println("Hello Dear, " + myName);
    }
    
    
    default void someDefaultMethod(String myName, String title) {
        System.out.println("Hello " + title + ". Dear, " + myName);
    }
    
    static void someStaticMethod() {
        System.out.println("Nothing to do in this someStaticMethod in interface FunctionalInterface1");
    }
    
    static void someStaticMethod(String printMeString) {
        System.out.println("from someStaticMethod in interface FunctionalInterface1 printing printMeString " + printMeString);
    }
    
}
