package org.example;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void openAmazonWebsite(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Tamas_Demeny\\IdeaProjects\\selenium_ht\\src\\test\\resources\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
    }

    @AfterMethod
    public void closeAmazonWebsite(){
        driver.close();
        driver.quit();
    }
}
