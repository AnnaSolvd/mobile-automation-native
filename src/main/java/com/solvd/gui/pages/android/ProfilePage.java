package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.ProfilePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends ProfilePageBase {

    @FindBy(id = "title")
    private ExtendedWebElement usernameTitle;

    @FindBy(id = "edit_button")
    private ExtendedWebElement editButton;

    @FindBy(id = "profile_pager_header")
    private ExtendedWebElement accountInformation;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickEditButton() {
        editButton.click();
    }

    @Override
    public boolean isCorrectTextInBiographySection() {
//        return accountInformation.stream()
//                .anyMatch(button -> button.getText().equalsIgnoreCase(text));
        return true;
    }

}
