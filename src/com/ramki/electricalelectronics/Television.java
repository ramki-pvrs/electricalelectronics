package com.ramki.electricalelectronics;

public class Television extends Electronics implements BuyerMethods, ElectricalPowerUnitCalculator {
    
    //to test Nested Class - Anonymous class, lets create a interface inside this Television class
    interface changeConnectionStatus {
        public String enableBluetoothConnection(Television tv);
        public String enableWifiConnection(Television tv);
    }
    
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
        this(itemTypeName, itemSubTypeName, itemBrandName, itemMeasurementUnitType); //calls constructor ONE
        //this.tvsCount++; //because you have used this Constructor call to run constructor ONE, don't increment here
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
    
    
    //Functional Interface abstract method
    //some dummy calc of multiplying operation duration in hours with 0.2
    
    @Override 
    public double calculatePowerUnits(Integer operationDuration) {
        return operationDuration * 0.2;
    }
    
    //Static Nested class - tvPowerCordClass - you dont need a Television object to use this class
    //you need a class inside a class - nested (inside Television class)
    //but that nested  class does not need to access Television object's members, then
    //you make that nested class as static class
    //this means all Television objects can be access by this nested class
    //let us say you want to compute power consumption, switch on status, bluetooth connectivity status (Green LED blinking continuously)
    //like some utilities for Television, but not associated with specific Television object, you create a static class 
    //- that means you are not access tv object properties at all from this TVUtils class
    
    //TVUtils is a Nested static class
    //from Television static tvsCount you know number of TVs produced
    //lets say you multiply that by 10000 rupees as average production cost, you will get some production cost
    
    static class TVUtils {
        
        public int calculateCostOfProduction() {
            return tvsCount * 10000;
        }
        
        
    }//END static class TVUtils
    
    
    //Nested Class: Local Inner Class - you need a TV Object for this to work; tightly coupled with objects
    class TVConnectionStatus {
        
        private String bluetoothConnectionStatus;
        private String wifiConnectionStatus;
        
        //DO NOT worry about the logic, dummy example
        //inner local class constructor
        public TVConnectionStatus(String bluetoothConnectionStatus, String wifiConnectionStatus) {
            this.bluetoothConnectionStatus = bluetoothConnectionStatus;
            this.wifiConnectionStatus = wifiConnectionStatus;
        }
        
        public String getBluetoothConnectionStatus() {
            return bluetoothConnectionStatus;
        }
        public void setBluetoothConnectionStatus(String bluetoothConnectionStatus) {
            this.bluetoothConnectionStatus = bluetoothConnectionStatus;
        }
        public String getWifiConnectionStatus() {
            return wifiConnectionStatus;
        }
        public void setWifiConnectionStatus(String wifiConnectionStatus) {
            this.wifiConnectionStatus = wifiConnectionStatus;
        }
    } //END class TVConnectionStatus
    
    //Nested Class - Inner Anonymous class
    
    //typically interface is used for Anonymous class
    
    changeConnectionStatus thisTVConnectionStatus = new changeConnectionStatus() {
        @Override
        public String enableBluetoothConnection(Television tv) {
            Television.TVConnectionStatus tvConnStatus = tv.new TVConnectionStatus("Bluetooth On", "Dummy wifi");
            return tvConnStatus.getBluetoothConnectionStatus();
        }
        
        @Override
        public String enableWifiConnection(Television tv) {
            Television.TVConnectionStatus tvConnStatus = tv.new TVConnectionStatus("Dummy Bluetooth", "Wifi ON");
            return tvConnStatus.getWifiConnectionStatus();
        }
        
        
    };
    
    

}
