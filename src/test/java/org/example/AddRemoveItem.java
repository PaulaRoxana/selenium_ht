package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class AddRemoveItem {
    private WebDriver driver;
    @BeforeMethod
    public void openAmazonWebsite(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Tamas_Demeny\\IdeaProjects\\selenium_ht\\src\\test\\resources\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        WebElement keyboardCategory = driver.findElement(
                By.xpath("//img[@alt=\"Keyboards\"]"));
        keyboardCategory.click();

        WebElement selectedKeyboard = driver.findElement(
                By.xpath("//img[starts-with(@alt,\"Redragon S101\")]"));
        selectedKeyboard.click();

        WebElement addToCart = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@id=\"add-to-cart-button\"]")));
        addToCart.click();
    }

    @Test
    public void addToCartFunctionality(){
        WebElement addedToCartMessage = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[contains(text(),\"Added to Cart\")]")));
        Assert.assertEquals(addedToCartMessage.getText(),"Added to Cart",
                "The message \"Added to Cart\" did not appear!");

        WebElement amountOfProductInCart = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@id=\"nav-cart-count\"]")));
        Assert.assertEquals(amountOfProductInCart.getText(), "1",
                "The amount of products in cart should be 1!");
    }

    @Test
    public void removeFromCart(){
        WebElement amountOfProductInCart = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@id=\"nav-cart-count\"]")));
        amountOfProductInCart.click();

        WebElement deleteFromCartButton = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@value=\"Delete\"]")));
        deleteFromCartButton.click();

        WebElement cartEmptyMessage = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h1[contains(text(),\"Your Amazon Cart is empty.\")]")));
        Assert.assertEquals(cartEmptyMessage.getText(), "Your Amazon Cart is empty.",
                "The message \"Your Amazon Cart is empty.\" did not appear!");

        WebElement priceIsZero = driver.findElement(
                By.xpath("//span[contains(text(),\"$0.00\")]"));
        Assert.assertEquals(priceIsZero.getText(), "$0.00",
                "The payable amount did not go down to $0!");
    }

    @AfterMethod
    public void closeAmazonWebsite(){
        driver.quit();
    }
}
