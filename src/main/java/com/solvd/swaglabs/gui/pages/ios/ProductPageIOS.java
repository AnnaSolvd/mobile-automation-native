package com.solvd.swaglabs.gui.pages.ios;

import com.solvd.swaglabs.gui.pages.common.ProductPageIOSBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPageIOSBase.class)
public class ProductPageIOS extends ProductPageIOSBase {

    private static final Logger logger = LoggerFactory.getLogger(ProductPageIOS.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[@contains(name,'Sauce Labs')]")
    private ExtendedWebElement productTitle;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'test-Price'`]")
    private ExtendedWebElement productPrice;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-ADD TO CART'`]")
    private ExtendedWebElement addToCartButton;

    public ProductPageIOS(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productTitle);
        logger.info("ProductPageIOS open");
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
