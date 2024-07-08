package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.EditProfilePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.solvd.gui.pages.common.ProfilePageBase;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = EditProfilePageBase.class)
public class EditProfilePage extends EditProfilePageBase {

    //TODO: better locator
    @FindBy(xpath = "//android.widget.EditText[@resource-id='about_field']")
    private ExtendedWebElement aboutFieldInput;

    //TODO: better locator
    @FindBy(xpath = "//android.view.View[@resource-id='save_button']/android.view.View/android.view.View/android.widget.Button")
    private ExtendedWebElement saveButton;

    public EditProfilePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(aboutFieldInput);
    }

    @Override
    public void typeAboutField(String text) {
        aboutFieldInput.click();
        aboutFieldInput.type(text);
        hideKeyboard();
    }

    @Override
    public ProfilePageBase clickSaveButton() {
        saveButton.click();
        return initPage(driver, ProfilePageBase.class);
    }

}
