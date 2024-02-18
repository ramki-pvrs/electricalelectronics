package com.ramki.electricalelectronics;

public class Screen {
    private String screenType; //LED, LCD...
    private int screenID;

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public int getScreenID() {
        return screenID;
    }

    public void setScreenID(int screenID) {
        this.screenID = screenID;
    }
    
    public Screen(String screenType, int screenID) {
        this.screenType = screenType;
        this.screenID = screenID;
    }
}
