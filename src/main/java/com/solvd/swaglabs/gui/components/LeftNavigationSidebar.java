package com.solvd.swaglabs.gui.components;

import com.solvd.swaglabs.gui.pages.common.GeoLocationPageIOSBase;
import com.solvd.swaglabs.gui.pages.common.LoginPageIOSBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LeftNavigationSidebar extends AbstractUIObject implements ICustomTypePageFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-LOGOUT'`]")
    private ExtendedWebElement logOutButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-GEO LOCATION'`]")
    private ExtendedWebElement geoLocationButton;

    public LeftNavigationSidebar(WebDriver driver) {
        super(driver);
    }

    protected LeftNavigationSidebar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginPageIOSBase clickLogOutButton() {
        logOutButton.click();
        LOGGER.info("Logout button clicked");
        return initPage(getDriver(), LoginPageIOSBase.class);
    }

    public GeoLocationPageIOSBase clickGeoLocationButton() {
        geoLocationButton.click();
        LOGGER.info("Geolocation button clicked");
        return initPage(getDriver(), GeoLocationPageIOSBase.class);
    }

}
