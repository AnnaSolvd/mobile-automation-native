package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SearchPageBase extends AbstractPage {

    protected SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeSearchInput(String searchText);
}
