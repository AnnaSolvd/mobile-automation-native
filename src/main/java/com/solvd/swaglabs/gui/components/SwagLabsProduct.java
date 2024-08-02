package com.solvd.swaglabs.gui.components;

import com.solvd.swaglabs.gui.pages.ios.HomePageIOS;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.postgresql.replication.fluent.physical.PhysicalReplicationOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SwagLabsProduct extends AbstractUIObject {

    private static final Logger logger = LoggerFactory.getLogger(SwagLabsProduct.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'test-Item title'`][1]")
    private ExtendedWebElement productTitle;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'test-Price'`][1]")
    private ExtendedWebElement productPrice;

    @ExtendedFindBy(iosClassChain = " **/XCUIElementTypeOther[contains(@name, 'test-ADD TO CART')]")
    private ExtendedWebElement addToCartButton;

    public SwagLabsProduct(WebDriver driver) {
        super(driver);
    }

    public SwagLabsProduct(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitle() {
        logger.info(String.valueOf(productTitle));
        return productTitle.getText();
    }

    public String getPrice() {
        logger.info(String.valueOf(productPrice));
        return productPrice.getText();
    }

    public void addProductToCart() {
        addToCartButton.click();
    }

    public void clickProduct() {
        productTitle.click();
    }

}
