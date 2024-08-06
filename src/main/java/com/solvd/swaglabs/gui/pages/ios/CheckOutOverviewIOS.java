package com.solvd.swaglabs.gui.pages.ios;

import com.solvd.swaglabs.gui.components.ProductCart;
import com.solvd.swaglabs.gui.pages.common.CheckOutCompleteIOSBase;
import com.solvd.swaglabs.gui.pages.common.CheckOutOverviewIOSBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckOutOverviewIOSBase.class)
public class CheckOutOverviewIOS extends CheckOutOverviewIOSBase {

    private static final Logger logger = LoggerFactory.getLogger(CheckOutOverviewIOS.class);

    @ExtendedFindBy(iosPredicate = "name == 'CHECKOUT: OVERVIEW'")
    private ExtendedWebElement pageTitle;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Item'`]")
    private List<ProductCart> productList;

    @ExtendedFindBy(iosPredicate = "name == 'test-FINISH'")
    private ExtendedWebElement finishButton;

    public CheckOutOverviewIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(pageTitle);
        logger.info("CheckOutOverviewIOS open");
    }

    @Override
    public boolean isPageTitlePresent() {
        return pageTitle.isPresent();
    }

    @Override
    public boolean isProductPresent(String productTitle) {
        productList.forEach(p -> logger.info(p.getTitle()));
        return productList.stream()
                .anyMatch(p -> p.getTitle().contains(productTitle));
    }

    @Override
    public CheckOutCompleteIOSBase clickFinishButton() {
        finishButton.click();
        return initPage(getDriver(), CheckOutCompleteIOSBase.class);
    }

}
