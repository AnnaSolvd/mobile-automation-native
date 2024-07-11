package com.solvd.gui.pages.common;

import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SearchPageBase extends AbstractPage implements IAndroidUtils {

    protected SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SearchResultPageBase typeSearchInput(String searchText);
}
