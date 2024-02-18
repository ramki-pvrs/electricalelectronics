package com.ramki.electricalelectronics;

public abstract class Electricals {
    
    //"Access Modifier" "Non Access Modifiers" "Data Type" "Attribute Name" = "Default Value"
    //static attributes belongs to this class and not objects
    
    public static String myAadhi = "Electricals"; //Aadhi means the root here; from any object (from classes extended from Electricals or its children) you can find this root class by using this attribute
    
    public static final String COUNTRY = "India"; //init on declaration
    public static final int MIN_INPUT_VOLTAGE = 220;
    private static final int MAX_INPUT_VOLTAGE = 240; //NOTE private static; possible and restricted only to this class
    public static final int MIN_INPUT_FREQUENCY = 49;
    public static final int MAX_INPUT_FREQUENCY = 51;
    
   //instance attributes
    private String itemType; //Electrical or Electronics
    private String itemSubType; //TV, Fridge, Mixer, Grinder ...
    private String brandName; //Samsung, Sony, Apple...
    private String itemMeasurementUnitType; //Count or Length; TV or Wire item
    
    //getters and setters (or accessors and mutators)
    public String getItemType() {
        return itemType;
    }
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    public String getItemSubType() {
        return itemSubType;
    }
    public void setItemSubType(String itemSubType) {
        this.itemSubType = itemSubType;
    }
    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public String getItemMeasurementUnitType() {
        return itemMeasurementUnitType;
    }
    public void setItemMeasurementUnitType(String itemMeasurementUnitType) {
        this.itemMeasurementUnitType = itemMeasurementUnitType;
    }
    
    //Constructor
    public Electricals(String itemTypeName, String itemSubTypeName, String itemBrandName, String itemMeasurementUnitType) {
        this.itemType = itemTypeName;
        this.itemSubType = itemSubTypeName;
        this.brandName = itemBrandName;
        this.itemMeasurementUnitType = itemMeasurementUnitType;
    };
    
    //abstract method; concrete sub-class should implement; itemMeasurementUnitType Count or Length
    public abstract int calculateProductionCost(String itemMeasurementUnitType, int productionQuantity, int unitCost); 
    
    //static method; cannot override in subclasses
    public static int calculatePowerConsumption(int currentRating) {
        return MAX_INPUT_VOLTAGE * currentRating;
    }; //wattage like 1200watts mixer

    
    //non-abstract method in abstract class
    public boolean needPower(String powerRequired) {
        return (powerRequired == "Yes") ? true : false;
    }

}
