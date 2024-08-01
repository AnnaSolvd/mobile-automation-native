package com.solvd.swaglabs.gui.pages.ios;

import com.solvd.reddit.gui.components.Post;
import com.solvd.reddit.gui.pages.common.PostDetailPageBase;
import com.solvd.swaglabs.gui.components.SwagLabsProduct;
import com.solvd.swaglabs.gui.pages.common.HomePageIOSBase;
import com.solvd.swaglabs.gui.pages.common.ProductPageIOSBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageIOSBase.class)
public class HomePageIOS extends HomePageIOSBase {

    private static final Logger logger = LoggerFactory.getLogger(HomePageIOS.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Cart'`]/XCUIElementTypeOther")
    private ExtendedWebElement cartButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Menu'`]")
    private ExtendedWebElement menuButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeScrollView/XCUIElementTypeOther[contains(@name, 'Sauce Labs')]")
    private List<SwagLabsProduct> productList;

    private SwagLabsProduct selectedProduct;

    public HomePageIOS(WebDriver driver) {
        super(driver);
    }

    private SwagLabsProduct selectProduct() {
        if (!productList.isEmpty()) {
            Random random = new Random();
            selectedProduct = productList.get(random.nextInt(productList.size()));
            logger.info("Selected post title: {}", selectedProduct.getTitle());
            return selectedProduct;
        }
        return null;
    }

    @Override
    public boolean isCartButtonPresent() {
        return cartButton.isVisible();
    }

    @Override
    public SwagLabsProduct getRandomProduct() {
        return selectProduct();
    }

    @Override
    public ProductPageIOSBase clickRandomProduct() {
        SwagLabsProduct product = getRandomProduct();
        product.clickProduct();
        return initPage(getDriver(), ProductPageIOSBase.class);
    }

}
