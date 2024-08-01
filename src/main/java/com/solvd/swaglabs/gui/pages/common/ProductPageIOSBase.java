package com.solvd.swaglabs.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageIOSBase extends AbstractPage implements IMobileUtils {

    protected ProductPageIOSBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getProductTitle();

    public abstract String getProductPrice();

    public abstract void clickAddToCart();

}
