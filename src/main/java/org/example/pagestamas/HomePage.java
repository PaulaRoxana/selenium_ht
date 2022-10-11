package org.example.pagestamas;

import org.example.pagestamas.modules.DeliverToModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.PageObjects.*;

public class HomePage extends BasePage{
    @FindBy(xpath = "//span[text()='Keyboards']")
    private WebElement KEYBOARD_CATEGORY;
    @FindBy(xpath = "//span[contains(text(),\"Deliver to\")]")
    private WebElement DELIVER_TO_BUTTON;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public KeyboardCatPage clickKeyboardCategory(){
        KEYBOARD_CATEGORY.click();
        return new KeyboardCatPage(driver);
    }

    public DeliverToModule clickDeliverTo(){
        DELIVER_TO_BUTTON.click();
        return new DeliverToModule(driver);
    }

    public String deliverToLocation(){
        return new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(NEW_LOCATION)).getText();
    }
}
