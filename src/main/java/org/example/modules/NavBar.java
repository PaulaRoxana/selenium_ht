package org.example.modules;

import org.example.BasePage;
import org.example.HeadphonesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBar extends BasePage {
    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBar;

    public NavBar(WebDriver driver) {
        super(driver);
    }

    public HeadphonesPage searchMethod(String searchedElement) {
        searchBar.sendKeys(searchedElement);
        searchBar.submit();
        return new HeadphonesPage(driver);

    }

}
