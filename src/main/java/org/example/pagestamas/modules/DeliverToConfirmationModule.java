package org.example.pagestamas.modules;

import org.example.pagestamas.BasePage;
import org.example.pagestamas.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.PageObjects.CONTINUE_BUTTON;

public class DeliverToConfirmationModule extends BasePage {
    public DeliverToConfirmationModule(WebDriver driver) {
        super(driver);
    }

    public HomePage confirm(){
        WebElement continueButton = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(CONTINUE_BUTTON));
        continueButton.click();
        return new HomePage(driver);
    }
}
