package org.example;

import org.example.pagestamas.HomePage;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static org.example.PageObjects.*;

public class DeliverToT extends BaseTest {
    @Test
    public void deliverToZipCode() {
        HomePage homePage = new HomePage(driver);
        String newLocation = homePage.clickDeliverTo()
                .deliverToUSAZip()
                .confirm()
                .deliverToLocation();

        Assert.assertEquals(newLocation, "Hartford 06103\u200C");
    }

    @Test
    public void deliverToPoland() {
        HomePage homePage = new HomePage(driver);
        homePage.clickDeliverTo()
                .deliverToCountry(POLAND_OPTION);

        //wait for the page to update
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(UPDATED_DELIVER_TO));

        String shippingDestination = homePage.clickKeyboardCategory()
                .clickFiodio()
                .shippingDestination();

        Assert.assertTrue(shippingDestination.contains("Poland"),
                "Result is false, which means that the shipping is not to Poland");
    }
}