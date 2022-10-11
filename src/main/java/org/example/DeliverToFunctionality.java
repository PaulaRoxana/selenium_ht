package org.example;

import org.openqa.selenium.By;

public class DeliverToFunctionality {

 public static final By deliverToButton = By.cssSelector("#glow-ingress-line1");
 public static final By zipCodeField = By.id("GLUXZipUpdateInput");
 public static final By applyButton = By.xpath("//span[@id = 'GLUXZipUpdate']//input");
  public static final String zipCode = "85001";
 public static final By continueButton = By.xpath("//div[@class='a-popover-footer']//input");
 public static final By destinationButton = By.xpath("//span[contains(text(), 'Phoenix 85001\u200C')]");
 public static final String updatedDestination = "Phoenix 85001\u200C";
 //checkCountriesListContainsPoland
 public static final By dropdownButton = By.xpath("//span[@role='radiogroup']");
 public static final By Poland = By.xpath("//a[@id='GLUXCountryList_178']");

 public static final String shipToCountry = "Poland";
 public static final By doneButton = By.xpath("//button[@name='glowDoneButton']");
 //public static final By doneButton = By.xpath("//span//button[text()= 'Done']");

 public static final By shipToDestination =  By.xpath("//span[@id='glow-ingress-line2'][contains(text(),'Poland')]");

 public static final By productsCategory = By.xpath("//span[text()='Keyboards']");

 public static final By aProductToShip = By.xpath("(//span[contains(text(), 'Fiodio Mechanical Gaming Keyboard')])[1]");

 public  static final By shippingDestination = By.xpath("(//span[contains(text(), 'Shipping to Poland')])[1]");

}
