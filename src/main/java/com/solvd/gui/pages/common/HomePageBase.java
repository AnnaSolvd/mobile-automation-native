package com.solvd.gui.pages.common;

import com.solvd.gui.pages.BasePage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends BasePage implements IMobileUtils {

    protected HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isRedditIconVisible();

    public abstract SearchPageBase clickSearchButton();

    public abstract void clickRandomPost();
}
