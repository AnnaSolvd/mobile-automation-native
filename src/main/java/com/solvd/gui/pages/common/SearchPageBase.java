package com.solvd.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SearchPageBase extends AbstractPage implements IMobileUtils {

    protected SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeSearchInput(String searchText);
}
