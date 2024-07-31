package com.solvd.reddit.gui.pages.common;

import com.solvd.reddit.gui.components.DropDownMenu;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PostDetailPageBase extends AbstractPage{

    protected PostDetailPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract DropDownMenu clickDropDownMenuButton();

    public abstract HomePageBase clickReturnButton();

    public abstract String getPostTitle();

    public abstract String getPostCommunity();

    public abstract boolean areCommentsPresent();
}
