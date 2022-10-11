package org.example;

import org.example.pagestamas.CartPage;
import org.example.pagestamas.HomePage;
import org.example.pagestamas.productpages.ConfirmationMessage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveItem extends BaseTest {
    @Test
    public void addToCartFunctionality() {
        HomePage homePage = new HomePage(driver);
        ConfirmationMessage addedToCartPage = homePage
                .clickKeyboardCategory()
                .clickRedragon()
                .addToCart();

        String addedToCartMessage = addedToCartPage.addedToCartMessage();
        Assert.assertEquals(addedToCartMessage, "Added to Cart",
                "The message \"Added to Cart\" did not appear!");

        String amountOfProductInCart = addedToCartPage.amountOfProductInCart();
        Assert.assertEquals(amountOfProductInCart, "1",
                "The amount of products in cart should be 1!");
    }

    @Test
    public void removeFromCart() {
        HomePage homePage = new HomePage(driver);
        CartPage cartEmptyPage = homePage
                .clickKeyboardCategory()
                .clickRedragon()
                .addToCart()
                .openCart()
                .deleteFromCartButton();

        Assert.assertEquals(cartEmptyPage.cartEmptyMessage(), "Your Amazon Cart is empty.",
                "The message \"Your Amazon Cart is empty.\" did not appear!");

        Assert.assertEquals(cartEmptyPage.cartSum(), "$0.00",
                "The payable amount did not go down to $0!");
    }
}
