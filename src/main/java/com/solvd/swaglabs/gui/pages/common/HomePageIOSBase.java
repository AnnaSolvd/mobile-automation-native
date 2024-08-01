package com.solvd.swaglabs.gui.pages.common;

import com.solvd.swaglabs.gui.components.SwagLabsProduct;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageIOSBase extends AbstractPage {

    protected HomePageIOSBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCartButtonPresent();

    public abstract SwagLabsProduct getRandomProduct();

    public abstract ProductPageIOSBase clickRandomProduct();
}
