# Classes and Interfaces  
- Electricals is an Abstract class  
- Electronics is an abstract class, extends Electricals  
- Television is concrete class extends Electronics; implements interface ConvertCurrency  
   -- contains one deep copy constructor
- Wire is concrete class extends Electricals  
- ConvertCurrency is an interface  
- BuyerMethods is an interface extending ConvertCurrency  
  -- Television implements BuyerMethods and in turn ConvertCurrency - interface chain  
- ElectronicStore is for Association-Composition  
  -- Store "has a"  Televisions (don't go by English grammar; "has a" is a association relationship; one store many TVs)

# Assumptions:  
- Country = India  
- Min Input Voltage = 220 Volts
- Max Input Voldate = 240 Volts  
- Min Input Frequency = 49 Hz
- Max Input Frequency = 51 Hz