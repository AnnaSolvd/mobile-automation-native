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

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckOutInformationIOSBase.class)
public class CheckOutInformationIOS extends CheckOutInformationIOSBase {

    private static final Logger logger = LoggerFactory.getLogger(CheckOutInformationIOS.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == 'test-First Name'`]")
    private ExtendedWebElement firstNameInput;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == 'test-Last Name'`]")
    private ExtendedWebElement lastNameInput;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == 'test-Zip/Postal Code'`]")
    private ExtendedWebElement zipCodeInput;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-CONTINUE'`]")
    private ExtendedWebElement continueButton;

    public CheckOutInformationIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(firstNameInput);
        logger.info("CheckOutInformationIOS open");
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
        return initPage(getDriver(), CheckOutOverviewIOSBase.class);
    }

}
