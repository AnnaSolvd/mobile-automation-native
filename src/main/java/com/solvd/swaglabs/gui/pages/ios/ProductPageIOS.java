package com.solvd.swaglabs.gui.pages.ios;

import com.solvd.swaglabs.gui.pages.common.ProductPageIOSBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPageIOSBase.class)
public class ProductPageIOS extends ProductPageIOSBase {

    private static final Logger logger = LoggerFactory.getLogger(ProductPageIOS.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Description'`]/XCUIElementTypeStaticText[1]")
    private ExtendedWebElement productTitleText;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'test-Price'`]")
    private ExtendedWebElement productPriceText;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-ADD TO CART'`]")
    private ExtendedWebElement addToCartButton;

    public ProductPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(productTitleText);
        logger.info("ProductPageIOS open");
    }

    @Override
    public boolean checkProductTitle(String title) {
        String productTitle = productTitleText.getText();
        return productTitle.contains(title);
    }

    @Override
    public boolean checkProductPrice(String price) {
        String productPrice = productPriceText.getText();
        return productPrice.contains(price);
    }

    @Override
    public void clickAddToCart() {
        addToCartButton.click();
    }

}
