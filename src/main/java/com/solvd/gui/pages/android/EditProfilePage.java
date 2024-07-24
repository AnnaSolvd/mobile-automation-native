package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.EditProfilePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.solvd.gui.pages.common.ProfilePageBase;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = EditProfilePageBase.class)
public class EditProfilePage extends EditProfilePageBase {

    private static final Logger logger = LoggerFactory.getLogger(EditProfilePage.class);

    //TODO: make better locators
    @FindBy(xpath = "//android.widget.EditText[@resource-id='about_field']")
    private ExtendedWebElement aboutFieldInput;

    @FindBy(xpath = "//android.view.View[@resource-id='save_button']/android.view.View/android.view.View/android.widget.Button")
    private ExtendedWebElement saveButton;

    public EditProfilePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(aboutFieldInput);
        logger.info("EditProfilePage open");
    }

    @Override
    public void typeAboutField(String aboutUserText) {
        aboutFieldInput.click();
        logger.info("About field clicked");
        aboutFieldInput.type(aboutUserText);
        logger.info("Type text to field");
        hideKeyboard();
    }

    @Override
    public ProfilePageBase clickSaveButton() {
        saveButton.click();
        logger.info("Save button clicked");
        return initPage(getDriver(), ProfilePageBase.class);
    }

}
