package org.example.pagestamas.productpages;

import org.example.pagestamas.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.example.PageObjects.*;

public class FiodioKeyboard extends BasePage {
    public FiodioKeyboard(WebDriver driver) {
        super(driver);
    }

    public String shippingDestination(){
        WebElement shipToPoland = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(SHIPPING_DESTINATION));
        return shipToPoland.getText();
    }
}
