package com.solvd.swaglabs.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageIOSBase extends AbstractPage {

    protected CartPageIOSBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProductPresentInCart(String productTitle);

    public abstract void removeProductFromCart(String productTitle);

    public abstract CheckOutInformationIOSBase clickCheckOutButton();

}
