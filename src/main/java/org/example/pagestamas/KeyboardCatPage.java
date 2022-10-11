package org.example.pagestamas;

import org.example.pagestamas.productpages.FiodioKeyboard;
import org.example.pagestamas.productpages.RedragonKeyboard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.PageObjects.FIODIO_KEYBOARD;

public class KeyboardCatPage extends BasePage{
    @FindBy(xpath = "//img[starts-with(@alt,\"Redragon S101\")]")
    private WebElement REDRAGON_KEYBOARD;
    public KeyboardCatPage(WebDriver driver) {
        super(driver);
    }

    public RedragonKeyboard clickRedragon(){
        REDRAGON_KEYBOARD.click();
        return new RedragonKeyboard(driver);
    }

    public FiodioKeyboard clickFiodio(){
        WebElement keyboard = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(FIODIO_KEYBOARD));
        keyboard.click();
        return new FiodioKeyboard(driver);
    }
}
