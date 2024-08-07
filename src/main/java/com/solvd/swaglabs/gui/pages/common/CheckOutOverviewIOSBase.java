package com.solvd.swaglabs.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckOutOverviewIOSBase extends AbstractPage {

    protected CheckOutOverviewIOSBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageTitlePresent();

    public abstract boolean isProductPresent(String productTitle);

    public abstract CheckOutCompleteIOSBase clickFinishButton();
}
