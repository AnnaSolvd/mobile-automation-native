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

public class LeftNavigationSidebar extends AbstractUIObject implements ICustomTypePageFactory {

    private static final Logger logger = LoggerFactory.getLogger(LeftNavigationSidebar.class);

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
        return initPage(getDriver(), LoginPageIOSBase.class);
    }

    public GeoLocationPageIOSBase clickGeoLocationButton() {
        geoLocationButton.click();
        return initPage(getDriver(), GeoLocationPageIOSBase.class);
    }

}
