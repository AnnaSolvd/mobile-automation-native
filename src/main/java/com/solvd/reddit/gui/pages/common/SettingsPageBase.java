package com.solvd.reddit.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SettingsPageBase extends AbstractPage implements IMobileUtils {

    protected SettingsPageBase(WebDriver driver) {
        super(driver);
    }

}
