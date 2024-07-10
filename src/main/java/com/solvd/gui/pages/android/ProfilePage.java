package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.EditProfilePageBase;
import com.solvd.gui.pages.common.ProfilePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    //TODO: fix locators
    @FindBy(xpath = "//android.widget.TextView[@resource-id='title']")
    private ExtendedWebElement usernameText;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='com.reddit.frontpage:id/profile_pager_header'" +
            "]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.Button")
    private ExtendedWebElement editButton;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='com.reddit.frontpage:id/profile_pager_header']" +
            "//android.view.View[contains(@content-desc, 'karma')];")
    private ExtendedWebElement accountInformationHeader;

    public ProfilePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(usernameText);
    }

    @Override
    public EditProfilePageBase clickEditButton() {
        editButton.click();
        return initPage(EditProfilePageBase.class, getDriver());
    }

    @Override
    public boolean isCorrectTextInBiographySection(String aboutUserText) {
        return accountInformationHeader.getAttribute("content-desc").contains(aboutUserText);
    }

}
