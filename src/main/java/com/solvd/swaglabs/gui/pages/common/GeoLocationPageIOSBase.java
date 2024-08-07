package com.solvd.swaglabs.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class GeoLocationPageIOSBase extends AbstractPage {

    protected GeoLocationPageIOSBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean checkLatitude(String expectedLatitude);

    public abstract boolean checkLongitude(String expectedLongitude);
}
