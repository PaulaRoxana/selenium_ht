package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static org.example.PageObjects.*;

public class DeliverToT {
    private WebDriver driver;
    @BeforeMethod
    public void openAmazonWebsite(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Tamas_Demeny\\IdeaProjects\\selenium_ht\\src\\test\\resources\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.findElement(DELIVER_TO_BUTTON).click();
    }

    @Test
    public void deliverToZipCode(){

        WebElement zipCodeField = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(ZIP_CODE_FIELD));
        zipCodeField.sendKeys("06103");

        WebElement applyButton = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(APPLY_BUTTON));
        applyButton.click();

        WebElement continueButton = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(CONTINUE_BUTTON));
        continueButton.click();

        WebElement newLocation = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(NEW_LOCATION));
        Assert.assertEquals(newLocation.getText(), "Hartford 06103\u200C");
    }

    @Test
    public void deliverToPoland(){
        WebElement listDropDown = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(LIST_DROP_DOWN));
        listDropDown.click();

        WebElement polandOption = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(POLAND_OPTION));
        Assert.assertEquals(polandOption.getText(), "Poland", "Poland was not found!");

        polandOption.click();
        driver.findElement(DONE).click();

        //wait for the page to update
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(UPDATED_DELIVER_TO));

        WebElement keyboardCategory = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(KEYBOARD_CATEGORY));
        keyboardCategory.click();

        WebElement keyboard = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(FIODIO_KEYBOARD));
        keyboard.click();

        WebElement shipToPoland = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(SHIP_TO_POLAND));
        Assert.assertTrue(shipToPoland.getText().contains("Poland"),
                "Result is false, which means that the shipping is not to Poland");
    }

    @AfterMethod
    public void closeAmazonWebsite(){
        driver.quit();
    }
}