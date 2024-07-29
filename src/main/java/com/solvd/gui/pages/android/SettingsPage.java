package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.SettingsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SettingsPageBase.class)
public class SettingsPage extends SettingsPageBase {

    private static final Logger logger = LoggerFactory.getLogger(SettingsPage.class);

    @FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/title' and @text='Language']")
    private ExtendedWebElement languageButton;

    public SettingsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(languageButton);
        logger.info("SettingsPage open");
    }
}



