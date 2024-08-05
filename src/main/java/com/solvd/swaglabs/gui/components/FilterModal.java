package com.solvd.swaglabs.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class FilterModal extends AbstractUIObject {

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
    }
}
