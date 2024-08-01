package com.solvd.swaglabs.gui.pages.ios;

import com.solvd.swaglabs.gui.pages.common.ProductPageIOSBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public class ProductPageIOS extends ProductPageIOSBase {

    @ExtendedFindBy(iosClassChain = " **/XCUIElementTypeStaticText[contains(@name, 'Sauce Labs Backpack')]")
    private ExtendedWebElement productTitle;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'test-Price'`]")
    private ExtendedWebElement productPrice;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-ADD TO CART'`]")
    private ExtendedWebElement addToCartButton;

    public ProductPageIOS(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getProductTitle() {
        return productTitle.getText();
    }

    @Override
    public String getProductPrice() {
        return productPrice.getText();
    }

    @Override
    public void clickAddToCart() {
        addToCartButton.click();
    }
}
