package com.solvd.reddit.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SearchResultPageBase extends AbstractPage implements IMobileUtils {

    public SearchResultPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isTermPresentInSearchPostsList(String searchTerm);
}
