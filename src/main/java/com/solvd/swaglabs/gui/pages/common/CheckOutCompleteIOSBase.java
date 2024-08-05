package com.solvd.swaglabs.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckOutCompleteIOSBase extends AbstractPage {

    protected CheckOutCompleteIOSBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isClickBackHomeButton();

    public abstract HomePageIOSBase clickBackHomeButton();

}
