package com.solvd.swaglabs.gui.pages.ios;

import com.solvd.swaglabs.gui.pages.common.LeftMenuPageIOSBase;
import com.solvd.swaglabs.gui.components.SwagLabsProduct;
import com.solvd.swaglabs.gui.pages.common.CartPageIOSBase;
import com.solvd.swaglabs.gui.pages.common.HomePageIOSBase;
import com.solvd.swaglabs.gui.pages.common.ProductPageIOSBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
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

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Item'`]")
    private List<SwagLabsProduct> productList;

    //TODO: Move to Header component
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Cart'`]")
    private ExtendedWebElement cartButton;

    //TODO: Move to Header component
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Menu'`]")
    private ExtendedWebElement menuButton;

    private SwagLabsProduct selectedProduct;

    public HomePageIOS(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(cartButton);
        logger.info("HomePageIOS open");
    }

    private SwagLabsProduct selectProduct() {
        logger.info("Product list: {}", productList);
        if (productList.isEmpty()) {
            logger.error("Product list is empty");
        }
        Random random = new Random();
        selectedProduct = productList.get(random.nextInt(productList.size()));
        logger.info("Selected post: {}", selectedProduct);
        return selectedProduct;
    }

    private void clickButton(ExtendedWebElement element) {
        Point point = element.getLocation();
        Dimension size = element.getSize();
        tap(point.getX() + size.getWidth() / 2, point.getY() + size.getHeight() / 2 + 4);
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
    public LeftMenuPageIOSBase clickMenuButton() {
        clickButton(menuButton);
        logger.info("Click menu button");
        return new LeftMenuPageIOSBase(getDriver());
    }

    @Override
    public SwagLabsProduct getRandomProduct() {
        return selectProduct();
    }

    @Override
    public ProductPageIOSBase clickRandomProduct() {
        SwagLabsProduct product = getRandomProduct();
        product.clickProduct();
        logger.info("Click product");
        return initPage(getDriver(), ProductPageIOSBase.class);
    }

}
