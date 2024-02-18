package com.ramki.electricalelectronics;

import java.util.List;

public class MainEntryClass {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        System.out.println("Entry into Electrical Electronics Project");
        
        List<String> brands = java.util.List.of("Panasonic", "LG", "Samsung", "Sony", "Redmi", "OnePlus", "Acer");
        
        //https://www.baeldung.com/java-enum-values

        System.out.println(ItemType.E1.type);
        System.out.println(ItemType.TV.type);
        System.out.println(ItemType.valueOf("E1"));
        
        
        //Java 9: use interface static method directly without object association
        System.out.println(ConvertCurrency.getUSDValue(100));

    }

}
