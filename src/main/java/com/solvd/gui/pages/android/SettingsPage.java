package com.solvd.gui.pages.android;

import com.solvd.gui.components.LanguageModal;
import com.solvd.gui.pages.common.SettingsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SettingsPageBase.class)
public class SettingsPage extends SettingsPageBase {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/title' and @text='Language']")
    private ExtendedWebElement languageButton;

    public SettingsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(languageButton);
    }

    @Override
    public LanguageModal clickLanguageButton() {
        languageButton.click();
        return new LanguageModal(getDriver());
    }

}
