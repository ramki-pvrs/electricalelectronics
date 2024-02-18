# Electricals is an Abstract class
# Electronics is an abstract class, extends Electricals
# Television is concrete class extends Electronics; implements interface ConvertCurrency
# Wire is concrete class extends Electricals
# ConvertCurrency is an interface  
   - has a static method getUSDValue(int rupees) 
# BuyerMethods is an interface extending ConvertCurrency 
  -- Television implements BuyerMethods and in turn ConvertCurrency - interface chain
# ElectronicStore is for Composition 
  - Store "has a"  Televisions (don't go by English grammar; "has a" is a association relationship; one store many TVs)

# Assumptions:  
- Country = India  
- Min Input Voltage = 220 Volts
- Max Input Voldate = 240 Volts  
- Min Input Frequency = 49 Hz
- Max Input Frequency = 51 Hz