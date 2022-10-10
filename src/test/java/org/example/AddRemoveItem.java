package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static org.example.PageObjects.*;

public class AddRemoveItem {
    private WebDriver driver;
    @BeforeMethod
    public void openAmazonWebsite(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Tamas_Demeny\\IdeaProjects\\selenium_ht\\src\\test\\resources\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        driver.findElement(KEYBOARD_CATEGORY).click();

        driver.findElement(REDRAGON_KEYBOARD).click();

        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CART))
                .click();
    }

    @Test
    public void addToCartFunctionality(){
        WebElement addedToCartMessage = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(ADDED_TO_CART_MESSAGE));
        Assert.assertEquals(addedToCartMessage.getText(),"Added to Cart",
                "The message \"Added to Cart\" did not appear!");

        WebElement amountOfProductInCart = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(AMOUNT_OF_PRODUCT_IN_CART));
        Assert.assertEquals(amountOfProductInCart.getText(), "1",
                "The amount of products in cart should be 1!");
    }

    @Test
    public void removeFromCart(){
        WebElement amountOfProductInCart = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(AMOUNT_OF_PRODUCT_IN_CART));
        amountOfProductInCart.click();

        WebElement deleteFromCartButton = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(DELETE_FROM_CART_BUTTON));
        deleteFromCartButton.click();

        WebElement cartEmptyMessage = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(CART_EMPTY_MESSAGE));
        Assert.assertEquals(cartEmptyMessage.getText(), "Your Amazon Cart is empty.",
                "The message \"Your Amazon Cart is empty.\" did not appear!");

        Assert.assertEquals(driver.findElement(PRICE_IS_ZERO).getText(),"$0.00",
                "The payable amount did not go down to $0!");
    }

    @AfterMethod
    public void closeAmazonWebsite(){
        driver.quit();
    }
}
