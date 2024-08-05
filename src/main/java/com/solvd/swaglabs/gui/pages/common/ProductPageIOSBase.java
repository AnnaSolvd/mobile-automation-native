package com.solvd.swaglabs.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageIOSBase extends AbstractPage implements IMobileUtils {

    protected ProductPageIOSBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean checkProductTitle(String title);

    public abstract boolean checkProductPrice(String price);

    public abstract void clickAddToCart();

}
