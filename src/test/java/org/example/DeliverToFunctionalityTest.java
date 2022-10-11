package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.example.DeliverToFunctionality.*;

public class DeliverToFunctionalityTest {

    WebDriver driver;


    @BeforeMethod
    public void setUpDriver() {//initialize our web-driver
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Paula_Girdea\\IdeaProjects\\selenium_ht\\src\\test\\resources\\webdriver\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
    }


    @Test
    public void verifyThatDeliverToValueIsUpdated() {
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        driver.findElement(deliverToButton).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(zipCodeField)).sendKeys(zipCode);
        driver.findElement(applyButton).click();

        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(continueButton))
                .click();

        WebElement destinationBtn = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(destinationButton));

        Assert.assertEquals(destinationBtn.getText(), updatedDestination,
                "The new destination should be Phoenix 85001");
    }

    @Test
    public void checkCountriesListContainsPoland() {

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        driver.findElement(deliverToButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(dropdownButton))
                .click();

        List<WebElement> countriesList = driver.findElements
                (By.xpath("//div[contains(@class, 'a-popover-inner')][contains(@class, 'a-lgtbox-vertical-scroll')]//a"));

        List<String> countriesNames = countriesList
                .stream()
                .map(WebElement::getText)
                .filter(s -> s.equals("Poland"))
                .toList();


        Assert.assertTrue(countriesNames.contains("Poland"));
    }


    @Test
    public void checkShippingToCountry() throws InterruptedException /*throws InterruptedException */ {

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        driver.findElement(deliverToButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(dropdownButton))
                .click();

        WebElement polandOption = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(Poland));
        polandOption.click();

        driver.findElement(doneButton).click();
        WebElement shippingDestinationBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(shipToDestination));
        System.out.println(shippingDestinationBtn.getText());


        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(productsCategory))
                .click();

        driver.findElement(aProductToShip).click();
        Assert.assertTrue(driver.findElement(shippingDestination).getText().contains(shipToCountry));
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }

}
