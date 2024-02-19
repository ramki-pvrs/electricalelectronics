package com.ramki.electricalelectronics;

public interface BuyerMethods extends ConvertCurrency{
    
    //by default all interface attributes are public static final
    String currency = "Rupee";
    
    //class implementing BuyerMethods shoud also implement all methods from ConvertCurrency
    
    //by default all methods are public abstract
    //must be implemented by classes using this interface
    int buySingleItem(String itemMeasurementUnitType, String itemType, String itemBrand);
    String returnSingleItem(int itemNumber);

    //Java 9: static methods; can be accessed without object reference
    static int placeOrder(String itemMeasurementUnitType, String itemSubType, int unitPrice, int requiredQuantity) {
        // for testing, return some random number as order number
        return (int) ((Math.random() * (1000000 - 10000)) + 10000);
    }
    
    static String cancelOrder(int orderNumber) {
        return "Cancelled order " + orderNumber;
    }
    
    static int getOrderValue(int orderNumber) {
        // return some random value
        return (int) ((Math.random() * (2000000 - 20000)) + 20000);
    }
    
    //Java 8: default interface method
    //classes implementing this BuyerMethods interface inherits this method automatically
    //no implementation is required in class for queryOrderOwner method
    default String queryOrderOwner(int orderNumber) {
        return "xyz"; //for learning; return based on orderNumber can be implemented later
    }
    
    
}
