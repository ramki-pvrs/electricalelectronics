package com.ramki.electricalelectronics;

public class Television extends Electronics implements BuyerMethods {
    
    public static int tvsCount = 0;
    
    //association relation - Composition in specific - tight coupling; Screen Belongs to TV
    private int tvSerialNumber;
    private Screen screen;
    private String screenResolution;
    private int currentChannel; 
    private boolean tvON; 
    
    

    public boolean isTvON() {
        return tvON;
    }

    public void setTvON(boolean tvON) {
        this.tvON = tvON;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(int currentChannel) {
        this.currentChannel = currentChannel;
    }

    //constructor ONE
    public Television(String itemTypeName, String itemSubTypeName, String itemBrandName, String itemMeasurementUnitType) {
        super(itemTypeName, itemSubTypeName, itemBrandName, itemMeasurementUnitType);
        this.tvsCount++;
        this.tvSerialNumber++;
    }
    
  //constructor TWO
    public Television(String itemTypeName, String itemSubTypeName, String itemBrandName, String itemMeasurementUnitType, Screen screen, String screenResolution, int currentChannel) {
        this(itemTypeName, itemSubTypeName, itemBrandName, itemMeasurementUnitType);
        // TODO Auto-generated constructor stub
        //this.tvsCount++; //because you have used this Constructor call to run constructor ONE, dont increment here
        this.screen = screen;
        this.screenResolution = screenResolution;
        this.currentChannel = currentChannel;
    }
    
    //deep copy constructor because Screen is an object type attribute and requires new object inside this constructor
    //observe Television tvObj is passed as constructor parameter
    //this here refers to the target TV object getting copied from source "origTVObj"
    public Television(Television origTVObj, int newScreenID) {
        this(origTVObj.getItemType(), origTVObj.getItemSubType(), origTVObj.getBrandName(), origTVObj.getItemMeasurementUnitType());
        Screen newScreen = new Screen(origTVObj.getScreen().getScreenType(), newScreenID); //for deep copy, you need a new Screen object; DO NOT FORGET getScreen() in origTVObj to get Screen properties
        this.screen = newScreen;
        this.screenResolution = origTVObj.getScreenResolution();
        this.currentChannel = -1;
    }

    @Override
    public float getOrderValue(int orderNumber, int multiplyRupeeFactor) {
        // return some random value
        return (float) ((Math.random() * (2000000 - 20000)) + 20000);
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

    @Override
    public int buySingleItem(String itemMeasurementUnitType, String itemType, String itemBrand) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String returnSingleItem(int itemNumber) {
        // TODO Auto-generated method stub
        return "Item with serial number " + itemNumber + " returned.";
    }

}
