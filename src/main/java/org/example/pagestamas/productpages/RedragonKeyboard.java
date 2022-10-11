package org.example.pagestamas.productpages;

import org.example.pagestamas.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.PageObjects.ADD_TO_CART;

public class RedragonKeyboard extends BasePage {
    private WebElement addedToCartMessage;
    public RedragonKeyboard(WebDriver driver) {
        super(driver);
    }

    public ConfirmationMessage addToCart(){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CART))
                .click();
        return new ConfirmationMessage(driver);
    }
}
