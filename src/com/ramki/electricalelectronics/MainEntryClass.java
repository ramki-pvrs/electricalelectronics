package com.ramki.electricalelectronics;

import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainEntryClass {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        System.out.println("Entry into Electrical Electronics Project");
        
        List<String> brands = java.util.List.of("Panasonic", "LG", "Samsung", "Sony", "Redmi", "OnePlus", "Acer", "Apple", "TCL", "VUE", "Philips");
        
        List<String> screenResolutions = java.util.List.of("720P", "1080P", "1440P", "4K", "8K", "OLED", "Full HD", "Half HD");
        
        List<String> screenTypes = java.util.List.of("Plasma", "LCD", "LED", "OLED");
       
        //https://www.baeldung.com/java-enum-values

        System.out.println(ItemType.E1.type);
        System.out.println(ItemType.TV.type);
        System.out.println(ItemType.valueOf("E1"));
        
        
        //Java 9: use interface static method directly without object association
        System.out.println(ConvertCurrency.getUSDValue(100));
        
        System.out.println("START OOPS ======================================================");
            //Television(String itemTypeName, String itemSubTypeName, String itemBrandName, String itemMeasurementUnitType)
            Television tv1 = new Television("Electronics", "TV", "Panasonic", "Count");
            //Television(String itemTypeName, String itemSubTypeName, String itemBrandName, String itemMeasurementUnitType, Screen screen, String screenResolution, int currentChannel)
            Screen screen1 = new Screen("LED", 1000);
            Television tv2 = new Television("Electronics", "TV", "Panasonic", "Count", screen1, "OLED", -1);
            
            System.out.println("tv1 screenResolution = " + tv1.getScreenResolution()); //null because screen resolution is not in params for tv1; 
            System.out.println("tv2 screenResolution = " + tv2.getScreenResolution());
            
            System.out.println("BEFORE setTvON: tv2 on status = " + tv2.isTvON());
            tv2.setTvON(true);
            System.out.println("AFTER setTvON: tv2 on status = " + tv2.isTvON());
            
            //String randBrand = brands.get(new Random().nextInt(brands.size()));
            //String randResoln = screenResolutions.get(new Random().nextInt(screenResolutions.size()));
            
            //System.out.println("Random brand name = " + randBrand);
            
            //Create array of objects
            int sizeOfTVObjList = 100;
            Screen screenObjList[] = new Screen[sizeOfTVObjList];
            Television tvObjsList[] = new Television[sizeOfTVObjList];
            
            System.out.println("tvObjsList size = " + tvObjsList.length);
            
            //Create multiple Television objects for testing purpose
            String randScreenType = "";
            String randBrand = "";
            String randResoln = "";
            
            for(int i = 0; i < tvObjsList.length; i++) {
                //System.out.println("Loop iterator i = " + i);
                
                randScreenType = screenTypes.get(new Random().nextInt(screenTypes.size()));
                randBrand = brands.get(new Random().nextInt(brands.size()));
                randResoln = screenResolutions.get(new Random().nextInt(screenResolutions.size()));
                
                //Screen(String screenType, int screenID)
                screenObjList[i] = new Screen(randScreenType, (int) ((Math.random() * (1000000 - 10000)) + 10000));
                tvObjsList[i] = new Television("Electronics", "TV", randBrand, "Count", screenObjList[i], randResoln, -1);
            }
            
            
            System.out.println("Brand name of TV from list of TV objects " + tvObjsList[3].getBrandName()); //prints random brand name
            System.out.println("TV objects count = " + Television.tvsCount); //tv1, tv2 and 100 tv objects in tvObjsList
            
            
            //Association: Composition
            ElectronicsStore rtnagar_store = new ElectronicsStore("RT Nagar Store", "Bangalore");
            Set<Television> televisions = new HashSet<>();
            televisions.add(tv1);
            televisions.add(tv2);
            for(int i = 0; i < tvObjsList.length; i++) {
                televisions.add(tvObjsList[i]);
            }
            
            //one store may have many televisions - so one to many relation 
            //uni-directional association; Store has a TVs, not the other way round (TV does not "has a" store)
            rtnagar_store.setTelevisions(televisions);
            System.out.println("Association Composition televisions in store = " + rtnagar_store.getTelevisions());
            //[com.ramki.electricalelectronicsproject.Television@edf4efb, com.ramki.electricalelectronicsproject.Television@566776ad, com.ramki.electricalelectronicsproject.Television@2f7a2457]

            
        System.out.println("END OOPS ======================================================");
        
        System.out.println("START Interfaces ======================================================");
        
        int currentYear = Year.now().getValue();
        System.out.println("Current Year = " + currentYear);
        
        //using interface static method without object reference
        //placeOrder(String itemMeasurementUnitType, String itemSubType, int unitPrice, int requiredQuantity)
        int tvOrder1 = BuyerMethods.placeOrder("Count", "TV", 1000, 50);
        
        System.out.println("tvOrder1 Order Number = " + tvOrder1);
        
        
        System.out.println("END Interfaces ======================================================");

    }

}
