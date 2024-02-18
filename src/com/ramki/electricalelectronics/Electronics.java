package com.ramki.electricalelectronics;

public abstract class Electronics extends Electricals {
    
    public static final String myAadhi2 = "Electronics"; //final means cannot changee
    
    private int currentRating; //in Amperes
    private boolean myOnStatus; //default is false
    private int myWarrantyPeriod;
    private String screenType; //applicable only for TV, Mobile kind 
    private boolean batteryOperated; //battery chargeable or requires wall outlet; 
    
    //getters and setters for private attributes
    public int getCurrentRating() {
        return currentRating;
    }
    
    public void setCurrentRating(int currentRating) {
        this.currentRating = currentRating;
    }

    public boolean isMyOnStatus() {
        return myOnStatus;
    }

    public void setMyOnStatus(boolean myOnStatus) {
        this.myOnStatus = myOnStatus;
    }

    public int getMyWarrantyPeriod() {
        return myWarrantyPeriod;
    }

    public void setMyWarrantyPeriod(int myWarrantyPeriod) {
        this.myWarrantyPeriod = myWarrantyPeriod;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public boolean isBatteryOperated() {
        return batteryOperated;
    }

    public void setBatteryOperated(boolean batteryOperated) {
        this.batteryOperated = batteryOperated;
    }

    //constructor ONE; using parent Electricals constructor by super(...)
    public Electronics(String itemTypeName, String itemSubTypeName, String itemBrandName, String itemMeasurementUnitType) {
        //constructor call
        super(itemTypeName, itemSubTypeName, itemBrandName, itemMeasurementUnitType);
        // TODO Auto-generated constructor stub
    }
    
    //overloaded constructor TWO; this(...) calls above constructor ONE
    public Electronics(String itemTypeName, String itemSubTypeName, String itemBrandName, String itemMeasurementUnitType, int currentRating) {
        //constructor call
        this(itemTypeName, itemSubTypeName, itemBrandName, itemMeasurementUnitType);
        this.currentRating = currentRating;
    }
    
    //overloaded constructor THREE; this(...) calls constructor TWO; to show constructor chaining
    public Electronics(String itemTypeName, String itemSubTypeName, String itemBrandName, String itemMeasurementUnitType, int currentRating, String screenType) {
        //constructor call
        this(itemTypeName, itemSubTypeName, itemBrandName, itemMeasurementUnitType, currentRating);
        this.screenType = screenType;
    }
    
    //@Override to notify this sub-class is over-riding parent method
    //should maintain same method signature (name, parameter and return type) as parent Electricals (else compile error)
    @Override
    public abstract int calculateProductionCost(String itemMeasurementUnitType, int productionQuantity, int unitCost); 
    
    //overloaded abstract method
    public abstract int calculateProductionCost(String itemMeasurementUnitType, int productionQuantity, int unitCost, int overHeadCostPerUnit);
    
    
    //method over-load from parent
    public boolean needPower(String powerRequired, boolean batteryOperated) {
        //if not battery operated, power required = Yes
        return (powerRequired == "Yes" && !batteryOperated) ? true : false;
    }
    
    

}
