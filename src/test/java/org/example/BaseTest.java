package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void openAmazonWebsite() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\\\Users\\\\Anca_Sava\\\\web_driver_practice\\\\src\\\\test\\\\resources\\\\webdriver\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
    }

    @AfterMethod
    public void closeAmazonWebsite() {
        driver.close();
        driver.quit();
    }
}