package com.solvd.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProfilePageBase extends AbstractPage implements IMobileUtils {

    public ProfilePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCorrectUsernameOnProfilePage(String username);

    public abstract EditProfilePageBase clickEditButton();

    public abstract boolean isCorrectTextInBiographySection(String aboutUserText);
}
