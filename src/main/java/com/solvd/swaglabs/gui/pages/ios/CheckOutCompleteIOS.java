package com.solvd.swaglabs.gui.pages.ios;

import com.solvd.swaglabs.gui.pages.common.CheckOutCompleteIOSBase;
import com.solvd.swaglabs.gui.pages.common.HomePageIOSBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckOutCompleteIOSBase.class)
public class CheckOutCompleteIOS extends CheckOutCompleteIOSBase {

    private static final Logger logger = LoggerFactory.getLogger(CheckOutCompleteIOS.class);

    @ExtendedFindBy(iosPredicate = "name == 'test-BACK HOME'")
    private ExtendedWebElement backHomeButton;

    public CheckOutCompleteIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(backHomeButton);
        logger.info("CheckOutCompleteIOS open");
    }

    @Override
    public boolean isClickBackHomeButton() {
        return backHomeButton.isVisible();
    }

    @Override
    public HomePageIOSBase clickBackHomeButton() {
        backHomeButton.click();
        return initPage(getDriver(), HomePageIOSBase.class);
    }

}
