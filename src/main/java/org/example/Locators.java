package org.example;

import org.openqa.selenium.By;

public class Locators {
    public static By searchBarLocator = By.id("twotabsearchtextbox");
    public static By sonyLocator = By.xpath("//*[contains(@class, 'a-size-base') and text() = 'Sony']");
    public static By searchResultsLocator = By.xpath("//span[contains(@class, ' a-size-mini')][contains(@class, 'a-spacing-none')][contains(@class, 'a-color-base')][contains(@class, 's-line-clamp-2')]");
    public static By priceLocator = By.xpath("//*[contains(text(),'$200 & Above')]");
    public static By searchResultsAccordingToPriceLocator = By.className("a-price-whole");
    public static By sortLocator = By.className("a-dropdown-label");
    public static By sortFromLowToHighLocator = By.xpath("//*[@id=\"s-result-sort-select_1\"]");
    public static By assertionElementLocator = By.className("a-dropdown-prompt");

}
