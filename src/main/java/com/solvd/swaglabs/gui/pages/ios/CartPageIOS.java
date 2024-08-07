package com.solvd.swaglabs.gui.pages.ios;

import com.solvd.swaglabs.gui.components.ProductCart;
import com.solvd.swaglabs.gui.pages.common.CartPageIOSBase;

import com.solvd.swaglabs.gui.pages.common.CheckOutInformationIOSBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageIOSBase.class)
public class CartPageIOS extends CartPageIOSBase {

    private static final Logger logger = LoggerFactory.getLogger(CartPageIOS.class);

    @ExtendedFindBy(iosPredicate = "name == 'YOUR CART'")
    private ExtendedWebElement pageTitle;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Item'`]")
    private List<ProductCart> productList;

    @ExtendedFindBy(iosPredicate = "name == 'test-CHECKOUT'")
    private ExtendedWebElement checkOutButton;

    public CartPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(pageTitle);
        logger.info("CartPageIOS open");
    }

    @Override
    public boolean isProductPresentInCart(String productTitle) {
        productList.forEach(p -> logger.info(p.getTitle()));
        return productList.stream()
                .anyMatch(p -> p.getTitle().contains(productTitle));
    }

    @Override
    public void removeProductFromCart(String productTitle) {
        productList.forEach(p -> logger.info(p.getTitle()));
        productList.stream()
                .filter(p -> p.getTitle().contains(productTitle))
                .forEach(ProductCart::clickRemoveButton);
    }

    @Override
    public CheckOutInformationIOSBase clickCheckOutButton() {
        checkOutButton.click();
        return initPage(getDriver(), CheckOutInformationIOSBase.class);
    }

}
