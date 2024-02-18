package com.ramki.electricalelectronics;
//https://www.baeldung.com/java-enum-values

public enum ItemType {
    E1("Electrical"),
    TV("Electronics"),
    Wire("Electrical"),
    E2("Electronics");
    
    public final String type;
    
    private ItemType(String type) {
        this.type = type;
    }
}
