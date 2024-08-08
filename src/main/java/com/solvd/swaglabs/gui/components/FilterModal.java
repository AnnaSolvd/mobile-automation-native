package com.solvd.swaglabs.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class FilterModal extends AbstractUIObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-LOGOUT'`]")
    private ExtendedWebElement geoLocationButton;

    @ExtendedFindBy(accessibilityId = "Price (low to high)")
    private ExtendedWebElement lowToHighFilterButton;

    public FilterModal(WebDriver driver) {
        super(driver);
    }

    public FilterModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickLowToHighFilterButton() {
        lowToHighFilterButton.click();
        LOGGER.info("Sort from low to high price button clicked");
    }
}
