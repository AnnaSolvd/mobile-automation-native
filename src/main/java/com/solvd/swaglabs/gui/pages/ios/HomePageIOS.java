package com.solvd.swaglabs.gui.pages.ios;

import com.solvd.swaglabs.gui.components.FilterModal;
import com.solvd.swaglabs.gui.components.LeftNavigationSidebar;
import com.solvd.swaglabs.gui.components.SwagLabsProduct;
import com.solvd.swaglabs.gui.pages.common.CartPageIOSBase;
import com.solvd.swaglabs.gui.pages.common.HomePageIOSBase;
import com.solvd.swaglabs.gui.pages.common.ProductPageIOSBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageIOSBase.class)
public class HomePageIOS extends HomePageIOSBase {

    private static final Logger logger = LoggerFactory.getLogger(HomePageIOS.class);

    //TODO: Move to Header component
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Cart'`]")
    private ExtendedWebElement cartButton;

    //TODO: Move to Header component
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Menu'`]")
    private ExtendedWebElement menuButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Item'`]")
    private List<SwagLabsProduct> productList;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Modal Selector Button'`]/XCUIElementTypeOther" +
            "/XCUIElementTypeOther")
    private ExtendedWebElement filterButton;

    private SwagLabsProduct selectedProduct;

    public HomePageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(cartButton);
        logger.info("HomePageIOS open");
        selectedProduct = selectProduct();
    }

    private SwagLabsProduct selectProduct() {
        productList.forEach(p -> logger.info(p.getTitle()));

        if (productList.isEmpty()) {
            logger.error("Product list is empty");
        }
        Random random = new Random();
        selectedProduct = productList.get(random.nextInt(productList.size()));
        logger.info("Selected product: {}", selectedProduct.getTitle());
        return selectedProduct;
    }

    private void clickButton(ExtendedWebElement element) {
        Point point = element.getLocation();
        Dimension size = element.getSize();
        tap(point.getX() + size.getWidth() / 2, point.getY() + size.getHeight() / 2 + 4);
    }

    @Override
    public FilterModal clickFilterButton() {
        filterButton.click();
        return new FilterModal(getDriver());
    }

    @Override
    public boolean isCartButtonVisible() {
        return cartButton.isVisible();
    }

    @Override
    public CartPageIOSBase clickCartButton() {
        clickButton(cartButton);
        logger.info("Click cart button");
        return initPage(getDriver(), CartPageIOSBase.class);
    }

    @Override
    public LeftNavigationSidebar clickMenuButton() {
        clickButton(menuButton);
        logger.info("Click menu button");
        return new LeftNavigationSidebar(getDriver());
    }

    @Override
    public boolean checkFirstProductPrice(String price) {
        String productPrice = productList.get(0).getPrice();
        String cleanedPrice = price.replaceAll("[^\\d.]", "");
        logger.info("Product price: {}", cleanedPrice);
        return productPrice.contains(price);
    }

    @Override
    public SwagLabsProduct getRandomProduct() {
        return selectedProduct;
    }

    @Override
    public ProductPageIOSBase clickRandomProduct() {
        if (selectedProduct == null){
            selectedProduct = getRandomProduct();
        }
        selectedProduct.clickProduct();
        logger.info("Click product {}", selectedProduct);
        return initPage(getDriver(), ProductPageIOSBase.class);
    }

}
