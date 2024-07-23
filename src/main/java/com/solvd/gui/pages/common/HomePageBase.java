package com.solvd.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage implements IMobileUtils {

    protected HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isRedditIconVisible();

    public abstract SearchPageBase clickSearchButton();

    public abstract void clickRandomPost();
}
