package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HeadphonesPage extends BasePage {
    public HeadphonesPage(WebDriver myDriver) {
        super(myDriver);
    }

    @FindBy(xpath = "//*[contains(@class, 'a-size-base') and text() = 'Sony']")
    public WebElement pageObjectSonyLocator;
    @FindBy(xpath = "//span[contains(@class, 'a-size-mini')][contains(@class, 'a-spacing-none')][contains(@class, 'a-color-base')][contains(@class, 's-line-clamp-2')]")
    private List<WebElement> pageObjectSearchResultsForSonyLocator;
    @FindBy(xpath = "//*[contains(text(),'$200 & Above')]")
    private WebElement priceLocator;
    @FindBy(xpath = "//div[contains(@class,'puis-include-cont')]//span[contains(@class,'a-price-whole')]")
    private List<WebElement> searchResultsAccordingToPriceLocator;
    @FindBy(className = "a-dropdown-label")
    private WebElement sortLocator;
    @FindBy(xpath = "//*[@id=\"s-result-sort-select_1\"]")
    private WebElement sortFromLowToHighLocator;
    @FindBy(className="a-dropdown-prompt")
    private WebElement assertionElementAfterSorting;

    public void clickOnSony(){
        WebElement sonyLocator = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'a-size-base')][text() = 'Sony']//preceding-sibling::*")));
       sonyLocator.click();
    }
    public List<WebElement> returnSearchResultsForSony(){
            return pageObjectSearchResultsForSonyLocator;
    }
    public HeadphonesPage clickOnPriceRangeOption(){

        priceLocator.click();
        return new HeadphonesPage(driver);
    }
    public List<WebElement> returnSearchResultsForPriceRangeOption(){

        return searchResultsAccordingToPriceLocator;
    }
    public void clickOnSort(){
        sortLocator.click();
    }
    public void clickOnSortFromLowToHigh(){
        sortFromLowToHighLocator.click();
    }
    public String getTextOfAssertionElementAfterSorting(){
        return assertionElementAfterSorting.getText();
    }

}
