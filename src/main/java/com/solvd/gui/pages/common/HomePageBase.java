package com.solvd.gui.pages.common;

import com.solvd.gui.components.SideMenu;
import com.solvd.gui.pages.BasePage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends BasePage {

    protected HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SideMenu clickProfileIcon();

    public abstract boolean isProfileIconVisible();

    public abstract void clickSearchButton();

}
