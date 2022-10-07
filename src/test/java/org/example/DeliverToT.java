package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DeliverToT {
    private WebDriver driver;
    @BeforeMethod
    public void openAmazonWebsite(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Tamas_Demeny\\IdeaProjects\\selenium_ht\\src\\test\\resources\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        WebElement deliverToButton = driver.findElement(
                By.xpath("//span[contains(text(),\"Deliver to\")]"));
        deliverToButton.click();
    }

    @Test
    public void deliverToZipCode(){

        WebElement zipCodeField = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@id=\"GLUXZipUpdateInput\"]")));
        zipCodeField.sendKeys("06103");

        WebElement applyButton = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@data-action=\"GLUXPostalUpdateAction\"]")));
        applyButton.click();


        WebElement continueButton = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class=\"a-popover-footer\"]//input")));
        continueButton.click();

        WebElement newLocation = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[contains(text(),\"Hartford 06103\u200C\")]")));
        Assert.assertEquals(newLocation.getText(), "Hartford 06103\u200C");
    }

    @Test
    public void deliverToPoland(){
        WebElement listDropDown = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@role=\"radiogroup\"]")));
        listDropDown.click();

        WebElement polandOption = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id=\"GLUXCountryList_178\"]")));
        Assert.assertEquals(polandOption.getText(), "Poland", "Poland was not found!");

        polandOption.click();
        driver.findElement(By.xpath("//button[@name=\"glowDoneButton\"]")).click();

        WebElement polandDeliverChanged= new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@id=\"glow-ingress-line2\"]")));

        while(!polandDeliverChanged.getText().contains("Poland")){
            polandDeliverChanged = new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//span[@id=\"glow-ingress-line2\"]")));
        }

        WebElement keyboardCategory = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[text()='Keyboards']")));
        keyboardCategory.click();

        WebElement keyboard = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//img[starts-with(@alt,\"Sponsored Ad - Fiodio R\")]")));
        keyboard.click();

        WebElement shipToPoland = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[contains(text(),\"No \")]")));
        Assert.assertTrue(shipToPoland.getText().contains("Poland"),
                "Result is false, which means that the shipping is not to Poland");
    }

    @AfterMethod
    public void closeAmazonWebsite(){
        driver.quit();
    }
}