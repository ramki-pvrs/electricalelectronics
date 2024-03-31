package com.ramki.electricalelectronics;

@FunctionalInterface
public interface ElectricalPowerUnitCalculator {
    
    //only one abstract method is allowed
    //abstract keyword is optional in functional interface
    double calculatePowerUnits(Integer operationDuration);
    
   //ERROR Invalid '@FunctionalInterface' annotation; ElectricalPowerUnitCalculator is not a functional interface
    //double calculatePowerUnits2(Integer operationDuration);
    
    default String doSomething() {
        return "did something";
    }
    
    
    static String doSomethingStatic() {
        return "did something static";
    }

}
