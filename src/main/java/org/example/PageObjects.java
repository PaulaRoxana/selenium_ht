package org.example;

import org.openqa.selenium.By;

public class PageObjects {
    public static final By ZIP_CODE_FIELD = By.xpath("//input[@id=\"GLUXZipUpdateInput\"]");
    public static final By APPLY_BUTTON = By.xpath("//span[@data-action=\"GLUXPostalUpdateAction\"]");
    public static final By CONTINUE_BUTTON = By.xpath("//div[@class=\"a-popover-footer\"]//input");
    public static final By NEW_LOCATION = By.xpath("//span[contains(text(),\"Hartford 06103\u200C\")]");
    public static final By LIST_DROP_DOWN = By.xpath("//span[@role=\"radiogroup\"]");
    public static final By POLAND_OPTION = By.xpath("//*[@id=\"GLUXCountryList_178\"]");
    public static final By DONE = By.xpath("//button[@name=\"glowDoneButton\"]");
    public static final By UPDATED_DELIVER_TO = By.xpath("//span[@id=\"glow-ingress-line2\"][contains(text(),\"Poland\")]");
    public static final By FIODIO_KEYBOARD = By.xpath("//img[starts-with(@alt,\"Sponsored Ad - Fiodio R\")]");
    public static final By SHIPPING_DESTINATION = By.xpath("//span[contains(text(),\"No \")]");
    public static final By ADD_TO_CART = By.xpath("//input[@id=\"add-to-cart-button\"]");
    public static final By ADDED_TO_CART_MESSAGE = By.xpath("//span[contains(text(),\"Added to Cart\")]");
    public static final By AMOUNT_OF_PRODUCT_IN_CART = By.xpath("//span[@id=\"nav-cart-count\"]");
    public static final By DELETE_FROM_CART_BUTTON = By.xpath("//input[@value=\"Delete\"]");
    public static final By CART_EMPTY_MESSAGE = By.xpath("//h1[contains(text(),\"Your Amazon Cart is empty.\")]");
}
