package com.solvd.swaglabs.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductCart extends AbstractUIObject {

    private static final Logger logger = LoggerFactory.getLogger(SwagLabsProduct.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Description'`]/XCUIElementTypeStaticText")
    private ExtendedWebElement productTitle;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Price'`]/XCUIElementTypeStaticText")
    private ExtendedWebElement productPrice;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'REMOVE'`]")
    private ExtendedWebElement removeProductButton;

    public ProductCart(WebDriver driver) {
        super(driver);
    }

    public ProductCart(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitle() {
        return productTitle.getText();
    }

    public String getPrice() {
        return productPrice.getText();
    }

    public void clickRemoveButton() {
        removeProductButton.click();
    }

}
