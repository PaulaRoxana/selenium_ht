package org.example.pagestamas.modules;

import org.example.pagestamas.BasePage;
import org.example.pagestamas.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.PageObjects.*;

public class DeliverToModule extends BasePage {
    public DeliverToModule(WebDriver driver) {
        super(driver);
    }

    public DeliverToConfirmationModule deliverToUSAZip(){
        WebElement zipCodeField = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(ZIP_CODE_FIELD));
        zipCodeField.sendKeys("06103");

        WebElement applyButton = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(APPLY_BUTTON));
        applyButton.click();
        return new DeliverToConfirmationModule(driver);
    }

    public HomePage deliverToCountry(By countryPath){
        WebElement listDropDown = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(LIST_DROP_DOWN));
        listDropDown.click();
        WebElement countryOption = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(countryPath));
        countryOption.click();
        driver.findElement(DONE).click();

        return new HomePage(driver);
    }
}
