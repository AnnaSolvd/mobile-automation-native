package com.solvd.swaglabs.gui.pages.common;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeftMenuPageIOSBase extends AbstractUIObject implements ICustomTypePageFactory {

    private static final Logger logger = LoggerFactory.getLogger(LeftMenuPageIOSBase.class);

    //TODO: create list of buttons
//    @ExtendedFindBy(iosClassChain = "")
//    private List<ExtendedWebElement> sideMenuButtonsList;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-LOGOUT'`]")
    private ExtendedWebElement logOutButton;

    public LeftMenuPageIOSBase(WebDriver driver) {
        super(driver);
    }

    protected LeftMenuPageIOSBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginPageIOSBase clickLogOutButton() {
        logOutButton.click();
        return initPage(getDriver(), LoginPageIOSBase.class);
    }

}
