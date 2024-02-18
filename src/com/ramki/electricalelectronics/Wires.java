package com.ramki.electricalelectronics;

public class Wires extends Electricals {

    public Wires(String itemTypeName, String itemSubTypeName, String itemBrandName, String itemMeasurementUnitType) {
        super(itemTypeName, itemSubTypeName, itemBrandName, itemMeasurementUnitType);
    }

    @Override
    public int calculateProductionCost(String itemMeasurementUnitType, int productionQuantity, int unitCost) {
        // itemMeasurementUnitType will be length; 1000 meters and 10 rupees per meter
        return  productionQuantity * unitCost;
    }

}
