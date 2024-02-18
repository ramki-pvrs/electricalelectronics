package com.ramki.electricalelectronics;

public class Television extends Electronics implements BuyerMethods {
    
    private static int tvsCount = 0;
    
    //association relation - Composition in specific - tight coupling; Screen Belongs to TV
    private Screen screen;
    private int screenResolution;
    private int currentChannel; 
    
    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public int getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(int screenResolution) {
        this.screenResolution = screenResolution;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(int currentChannel) {
        this.currentChannel = currentChannel;
    }

    public Television(String itemTypeName, String itemSubTypeName, String itemBrandName, String itemMeasurementUnitType) {
        super(itemTypeName, itemSubTypeName, itemBrandName, itemMeasurementUnitType);
        this.tvsCount++;
    }
    
    
    public Television(String itemTypeName, String itemSubTypeName, String itemBrandName, String itemMeasurementUnitType, Screen screen, int screenResolution, int currentChannel) {
        this(itemTypeName, itemSubTypeName, itemBrandName, itemMeasurementUnitType);
        // TODO Auto-generated constructor stub
        this.tvsCount++;
        this.screen = screen;
        this.screenResolution = screenResolution;
        this.currentChannel = currentChannel;
    }

    @Override
    public float getOrderValue(int orderNumber, int multiplyRupeeFactor) {
        // return some random value
        return (float) ((Math.random() * (2000000 - 20000)) + 20000);
    }

    @Override
    public int placeOrder(String itemMeasurementUnitType, int unitPrice, int requiredQuantity) {
        // for testing, return some random number as order number
        return (int) ((Math.random() * (1000000 - 10000)) + 10000);
    }

    @Override
    public String cancelOrder(int orderNumber) {
        
        return "Cancelled order " + orderNumber;
    }

    @Override
    public int getOrderValue(int orderNumber) {
        // return some random value
        return (int) ((Math.random() * (2000000 - 20000)) + 20000);
    }

    @Override
    public int calculateProductionCost(String itemMeasurementUnitType, int productionQuantity, int unitCost) {
        return  productionQuantity * unitCost;
    }

    @Override
    public int calculateProductionCost(String itemMeasurementUnitType, int productionQuantity, int unitCost, int overHeadCostPerUnit) {
        return  productionQuantity * (unitCost + overHeadCostPerUnit);
    }
    
    
    public String switchMeOn() {
        return "I am ON!";
    }
    
    //if Off, expecting no response from this method call, so void
    public void switchMeOff() {
        this.setCurrentChannel(-1); //on switching off, setting the current channel to -1, assuming -1 is invalid channel; 
        //order matters here; first setCurrentChannel and then setMyOnStatus
        this.setMyOnStatus(false);
    }

}
