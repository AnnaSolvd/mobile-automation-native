package com.solvd.swaglabs.gui.pages.common;

import com.solvd.swaglabs.gui.components.SwagLabsProduct;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageIOSBase extends AbstractPage implements IMobileUtils {

    protected HomePageIOSBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCartButtonVisible();

    public abstract CartPageIOSBase clickCartButton();

    public abstract LeftMenuPageIOSBase clickMenuButton();

    public abstract SwagLabsProduct getRandomProduct();

    public abstract ProductPageIOSBase clickRandomProduct();
}
