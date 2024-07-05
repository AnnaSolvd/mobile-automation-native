package com.solvd.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class EditProfilePageBase extends AbstractPage implements IMobileUtils {

    public EditProfilePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeAboutField(String text);

    public abstract ProfilePageBase clickSaveButton();
}
