package org.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.example.SearchFieldFunctionality.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchFieldFunctionalityTest {

    WebDriver driver;

    @BeforeMethod
    public void setUpDriver() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Paula_Girdea\\IdeaProjects\\selenium_ht\\src\\test\\resources\\webdriver\\chromedriver.exe");

        driver = new ChromeDriver();
    }

    @Test
    public void checkNoResultsForIncorrectInfoInSearchField() {
        driver.get("https://www.amazon.com/");
        driver.findElement(searchField).sendKeys(impossibleToFindEvenOnAmazon + Keys.ENTER);

        WebElement noResults = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(noResultsElement));

        assertEquals(noResultsVisibleText, noResults.getText(), "The text should contain: No results for");
    }


    @Test
    public void checkResultsForCorrectInfoInSearchField() {
        driver.get("https://www.amazon.com/");
        driver.findElement(searchField).sendKeys(typeOfProductToBeFound + Keys.ENTER);

        WebElement foundResults = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(resultForProductToBeFound));

        assertEquals('"' + typeOfProductToBeFound + '"', foundResults.getText(), "The text should contain: 'laptop'");
    }

    @Test
    public void checkFoundElementsContainSearchedInfo() {
        driver.get("https://www.amazon.com/");
        driver.findElement(searchField).sendKeys(typeOfProductToBeFound + Keys.ENTER);

        List<WebElement> actualResults = driver.findElements(foundResults);

               assertTrue(actualResults.stream()
                .filter(webElement -> webElement.getText().contains("Laptop")).toList().size()>=1);
    }


    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}
