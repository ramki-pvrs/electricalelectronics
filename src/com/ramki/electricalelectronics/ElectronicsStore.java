package com.ramki.electricalelectronics;

import java.util.Set;

//ElectronicsStore 
public class ElectronicsStore {
    private String storeName;
    private String storeCity;
    private Set<Television> televisions; //store "has a" television (it can be multiple TVs,)
    
    
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreCity() {
        return storeCity;
    }

    public void setStoreCity(String storeCity) {
        this.storeCity = storeCity;
    }
    
    public Set<Television> getTelevisions() {
        return televisions;
    }

    public void setTelevisions(Set<Television> televisions) {
        this.televisions = televisions;
    }
    
    //Constructor of ElectronicsStore
    public ElectronicsStore(String storeName, String storeCity) {
        this.storeName = storeName;
        this.storeCity = storeCity;
    }

}
