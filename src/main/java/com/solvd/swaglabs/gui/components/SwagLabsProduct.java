package com.solvd.swaglabs.gui.components;

import com.solvd.swaglabs.gui.pages.common.ProductPageIOSBase;
import com.solvd.swaglabs.gui.pages.ios.HomePageIOS;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class SwagLabsProduct extends AbstractUIObject implements ICustomTypePageFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'test-Item title'`]")
    private ExtendedWebElement productTitle;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'test-Price'`]")
    private ExtendedWebElement productPrice;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-ADD TO CART'`]")
    private ExtendedWebElement addToCartButton;

    public SwagLabsProduct(WebDriver driver) {
        super(driver);
    }

    public SwagLabsProduct(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitle() {
        return productTitle.getText();
    }

    public String getPrice() {
        return productPrice.getText();
    }

    public void addProductToCart() {
        addToCartButton.click();
        LOGGER.info("Add to cart button clicked");
    }

    public ProductPageIOSBase clickProduct() {
        productTitle.click();
        LOGGER.info("Product clicked: {}", productTitle);
        return initPage(getDriver(), ProductPageIOSBase.class);
    }

}
