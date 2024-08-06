package com.solvd.swaglabs.gui.pages.ios;

import com.solvd.swaglabs.gui.components.SwagLabsProduct;
import com.solvd.swaglabs.gui.pages.common.GeoLocationPageIOSBase;
import com.solvd.swaglabs.gui.pages.common.HomePageIOSBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = GeoLocationPageIOSBase.class)
public class GeoLocationPageIOS extends GeoLocationPageIOSBase {

    private static final Logger logger = LoggerFactory.getLogger(GeoLocationPageIOS.class);

    @ExtendedFindBy(iosPredicate = "name == 'test-latitude'")
    private ExtendedWebElement latitudeText;

    @ExtendedFindBy(iosPredicate = "name == 'test-longitude'")
    private ExtendedWebElement longitudeText;

    public GeoLocationPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(latitudeText);
        logger.info("GeoLocationPageIOS open");
    }

    @Override
    public boolean checkLatitude(String expectedLatitude) {
        String latitude = latitudeText.getText();
        return latitude.contains(expectedLatitude);
    }

    @Override
    public boolean checkLongitude(String expectedLongitude) {
        String longitude = longitudeText.getText();
        return longitude.contains(expectedLongitude);
    }

}
