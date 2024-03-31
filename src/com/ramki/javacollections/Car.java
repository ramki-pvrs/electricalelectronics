package com.ramki.javacollections;

public class Car {
    
    public String vin; //Vechicle id number
    public String description;
    
    
    
    
    //default equals checks whether some internal struct maps
    //here we are overriding equals method such that
    //the comparison is made between your object and other object
    //using Car vin number only, lower case
    //when you start, if the object is not Car at all, you return false
    
    //since user may pass any type of object to equals, 
    //here we are not setting Car as specific parameter type
    //later in the else condition, you type cast to car and compare to vin
    
    public String getVin() {
        return vin;
    }


    public void setVin(String vin) {
        this.vin = vin;
    }


    public boolean equals(Object other) {
        if(!(other instanceof Car)) {
            return false;
        } else {
            return vin.equalsIgnoreCase(((Car)other).vin);
        }
    }
    
    
    //hashCode also may come from Object, the aadhi
    public int hashCode() {
        return vin.hashCode(); //Depends on vin only
    }
    
    
    //Car Constructor; pass Vin and description
    public Car(String vin, String description) {
        this.vin = vin;
        this.description = description;
    }
    
    //Override toString() method on Car object
    public String toString() {
        return this.vin + " " + this.description;
    }

}
