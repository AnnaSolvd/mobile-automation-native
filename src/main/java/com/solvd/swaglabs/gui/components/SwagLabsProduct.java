package com.solvd.swaglabs.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class SwagLabsProduct extends AbstractUIObject {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[contains(@name, 'Item title')]")
    private ExtendedWebElement productTitle;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[contains(@name, 'test-Price')]")
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
        return productTitle.getText();
    }

    public String getPrice() {
        return productPrice.getText();
    }

    public void addProductToCart() {
        addToCartButton.click();
    }

    public void clickProduct() {
        productTitle.click();
    }

}
