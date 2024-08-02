package com.solvd.swaglabs.gui.pages.ios;

import com.solvd.swaglabs.gui.pages.common.LoginPageIOSBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeftMenuPageIOS extends AbstractUIObject implements ICustomTypePageFactory {

    private static final Logger logger = LoggerFactory.getLogger(LeftMenuPageIOS.class);

    //TODO: create list of buttons
//    @ExtendedFindBy(iosClassChain = "")
//    private List<ExtendedWebElement> sideMenuButtonsList;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-LOGOUT'`]")
    private ExtendedWebElement logOutButton;

    public LeftMenuPageIOS(WebDriver driver) {
        super(driver);
    }

    protected LeftMenuPageIOS(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginPageIOSBase clickLogOutButton() {
        logOutButton.click();
        return initPage(getDriver(), LoginPageIOSBase.class);
    }

}
