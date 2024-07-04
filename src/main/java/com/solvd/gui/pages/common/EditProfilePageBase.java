package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class EditProfilePageBase extends AbstractPage {

    public EditProfilePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeToAboutYouField(String text);

    public abstract ProfilePageBase clickSaveButton();
}
