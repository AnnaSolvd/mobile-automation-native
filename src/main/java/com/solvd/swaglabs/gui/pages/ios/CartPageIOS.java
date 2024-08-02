package com.solvd.swaglabs.gui.pages.ios;

import com.solvd.swaglabs.gui.pages.common.CartPageIOSBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageIOSBase.class)
public class CartPageIOS extends CartPageIOSBase {

    private static final Logger logger = LoggerFactory.getLogger(CartPageIOS.class);

    public CartPageIOS(WebDriver driver) {
        super(driver);
//        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
//        setUiLoadedMarker(cartButton);
//        logger.info("CartPageIOS open");
    }
}
