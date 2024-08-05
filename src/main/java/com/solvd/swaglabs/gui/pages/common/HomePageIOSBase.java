package com.solvd.swaglabs.gui.pages.common;

import com.solvd.swaglabs.gui.components.FilterModal;
import com.solvd.swaglabs.gui.components.LeftNavigationSidebar;
import com.solvd.swaglabs.gui.components.SwagLabsProduct;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageIOSBase extends AbstractPage implements IMobileUtils {

    protected HomePageIOSBase(WebDriver driver) {
        super(driver);
    }

    public abstract FilterModal clickFilterButton();

    public abstract boolean isCartButtonVisible();

    public abstract CartPageIOSBase clickCartButton();

    public abstract LeftNavigationSidebar clickMenuButton();

    public abstract boolean checkFirstProductPrice(String price);

    public abstract SwagLabsProduct getRandomProduct();

    public abstract ProductPageIOSBase clickRandomProduct();
}
