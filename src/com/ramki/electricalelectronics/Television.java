package com.ramki.electricalelectronics;

public class Television extends Electronics implements BuyerMethods {

    public Television(String itemTypeName, String itemSubTypeName, String itemBrandName, String itemMeasurementUnitType) {
        super(itemTypeName, itemSubTypeName, itemBrandName, itemMeasurementUnitType);
        // TODO Auto-generated constructor stub
    }

    @Override
    public float getOrderValue(int orderNumber, int multiplyRupeeFactor) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int placeOrder(String itemMeasurementUnitType, int unitPrice, int requiredQuantity) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String cancelOrder(int orderNumber) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getOrderValue(int orderNumber) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int calculateProductionCost(String itemMeasurementUnitType, int productionQuantity, int unitCost) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int calculateProductionCost(String itemMeasurementUnitType, int productionQuantity, int unitCost, int overHeadCostPerUnit) {
        // TODO Auto-generated method stub
        return 0;
    }

}
