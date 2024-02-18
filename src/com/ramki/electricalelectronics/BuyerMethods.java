package com.ramki.electricalelectronics;

public interface BuyerMethods extends ConvertCurrency{
    
    //class implementing BuyerMethods shoud also implement all methods from ConvertCurrency
    
    //by default all attributes are public static final
    String currency = "Rupee";
    
    //by default all methods are public abstract
    //must be implemented by classes using this interface
    int placeOrder(String itemMeasurementUnitType, int unitPrice, int requiredQuantity);
    String cancelOrder(int orderNumber);
    int getOrderValue(int orderNumber);
    
    //Java 9
    //classes implementing this BuyerMethods interface inherits this method automatically
    //no implementation is required in class for queryOrderOwner method
    default String queryOrderOwner(int orderNumber) {
        return "xyz"; //for learning; return based on orderNumber can be implemented later
    }

}
