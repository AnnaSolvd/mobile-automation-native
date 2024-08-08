package com.solvd.swaglabs.gui.pages.ios;

import com.solvd.swaglabs.gui.pages.common.CheckOutInformationIOSBase;
import com.solvd.swaglabs.gui.pages.common.CheckOutOverviewIOSBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckOutInformationIOSBase.class)
public class CheckOutInformationIOS extends CheckOutInformationIOSBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ExtendedFindBy(iosPredicate = "name == 'test-First Name'")
    private ExtendedWebElement firstNameInput;

    @ExtendedFindBy(iosPredicate = "name == 'test-Last Name'")
    private ExtendedWebElement lastNameInput;

    @ExtendedFindBy(iosPredicate = "name == 'test-Zip/Postal Code'")
    private ExtendedWebElement zipCodeInput;

    @ExtendedFindBy(iosPredicate = "name == 'test-CONTINUE'")
    private ExtendedWebElement continueButton;

    public CheckOutInformationIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(firstNameInput);
        LOGGER.info("CheckOutInformationIOS open");
    }

    @Override
    public void fillFormWithData(String firstName, String lastName, String zipCode) {
        firstNameInput.type(firstName);
        lastNameInput.type(lastName);
        zipCodeInput.type(zipCode);
    }

    @Override
    public CheckOutOverviewIOSBase clickCheckOutButton() {
        continueButton.click();
        LOGGER.info("Continue button clicked");
        return initPage(getDriver(), CheckOutOverviewIOSBase.class);
    }

}
