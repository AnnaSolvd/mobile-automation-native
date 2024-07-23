package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.EditProfilePageBase;
import com.solvd.gui.pages.common.ProfilePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    private static final Logger logger = LoggerFactory.getLogger(ProfilePage.class);

    //TODO: make better locators
    @FindBy(xpath = "//android.widget.TextView[@resource-id='title']")
    private ExtendedWebElement usernameText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='edit_button']")
    private ExtendedWebElement editButton;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='com.reddit.frontpage:id/profile_pager_header']" +
            "//android.view.View[contains(@content-desc, 'karma')];")
    private ExtendedWebElement accountInformationHeader;

    public ProfilePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(usernameText);
        logger.info("ProfilePage open");
    }

    @Override
    public boolean isCorrectUsernameOnProfilePage(String username) {
        return usernameText.getText().contains(username);
    }

    @Override
    public EditProfilePageBase clickEditButton() {
        editButton.click();
        logger.info("Edit button clicked");
        return initPage(EditProfilePageBase.class, getDriver());
    }

    @Override
    public boolean isCorrectTextInBiographySection(String aboutUserText) {
        return accountInformationHeader.getAttribute("content-desc").contains(aboutUserText);
    }

}
