package com.solvd.swaglabs.gui.pages.common;

import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageIOSBase extends AbstractPage implements IMobileUtils {

    protected LoginPageIOSBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeInForm(String username, String password);

    public abstract HomePageIOSBase clickLoginButton();

    public abstract boolean isAlertPresent();
}
