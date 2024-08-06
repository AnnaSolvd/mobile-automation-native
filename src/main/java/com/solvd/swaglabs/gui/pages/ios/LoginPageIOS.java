package com.solvd.swaglabs.gui.pages.ios;

import com.solvd.swaglabs.gui.pages.common.HomePageIOSBase;
import com.solvd.swaglabs.gui.pages.common.LoginPageIOSBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageIOSBase.class)
public class LoginPageIOS extends LoginPageIOSBase {

    private static final Logger logger = LoggerFactory.getLogger(LoginPageIOS.class);

    @ExtendedFindBy(iosPredicate = "name == 'test-Username'")
    private ExtendedWebElement usernameInput;

    @ExtendedFindBy(iosPredicate = "name == 'test-Password'")
    private ExtendedWebElement passwordInput;

    @ExtendedFindBy(iosPredicate = "name == 'test-LOGIN'")
    private ExtendedWebElement loginButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Error message'`]")
    private ExtendedWebElement invalidCredentialsMessage;

    public LoginPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(passwordInput);
        logger.info("LoginPage open");
    }

    @Override
    public void typeInForm(String username, String password) {
        usernameInput.type(username);
        passwordInput.type(password);
    }

    @Override
    public HomePageIOSBase clickLoginButton() {
        loginButton.click();
        return initPage(getDriver(), HomePageIOSBase.class);
    }

    @Override
    public boolean isLogInButtonVisible() {
        return loginButton.isVisible();
    }

    @Override
    public boolean isErrorMessagePresent() {
        return invalidCredentialsMessage.isVisible();
    }

}
