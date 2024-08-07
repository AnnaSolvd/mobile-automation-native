package com.solvd.reddit.gui.pages.android;

import com.solvd.reddit.gui.pages.common.EditProfilePageBase;
import com.solvd.reddit.gui.pages.common.ProfilePageBase;
import com.zebrunner.carina.utils.R;
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

    @FindBy(xpath = "//android.widget.TextView[@resource-id='title']")
    private ExtendedWebElement usernameText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='edit_button']")
    private ExtendedWebElement editButton;

    @FindBy(xpath = "//android.view.View[contains(@content-desc, 'karma')]")
    private ExtendedWebElement accountInformationHeader;

    public ProfilePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(editButton);
        logger.info("ProfilePage open");
    }

    @Override
    public boolean isCorrectUsernameOnProfilePage(String username) {
        return usernameText.getText().contains(username);
    }

    @Override
    public EditProfilePageBase clickEditButton() {
        editButton.click();
        logger.info("Click edit button");
        return initPage(getDriver(), EditProfilePageBase.class);
    }

    @Override
    public boolean isCorrectTextInBiographySection(String aboutUserText) {
        return accountInformationHeader.getAttribute("content-desc").contains(aboutUserText);
    }

}
