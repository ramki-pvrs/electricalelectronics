package com.ramki.electricalelectronics;

public interface ConvertCurrency {

  //to get dollar value from rupee, send the multiplyRupeeFactor = 1/85, Rupee to USD converter
  public float getOrderValue(int orderNumber, int multiplyRupeeFactor);
  
  public static float getUSDValue(int rupees) {
      return (float) rupees/85;
  }
}
