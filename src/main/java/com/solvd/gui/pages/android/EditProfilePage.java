package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.EditProfilePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.solvd.gui.pages.common.ProfilePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends EditProfilePageBase {

    @FindBy(id = "about_field")
    private ExtendedWebElement aboutFieldInput;

    @FindBy(id = "save_button")
    private ExtendedWebElement saveButton;

    public EditProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeToAboutYouField(String text) {
        aboutFieldInput.type(text);
    }

    @Override
    public ProfilePageBase clickSaveButton() {
        saveButton.click();
        return initPage(driver, ProfilePageBase.class);
    }

}
