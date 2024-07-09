package com.solvd.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CreatePostPageBase extends AbstractPage implements IMobileUtils {

    protected CreatePostPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typePostTitle(String text);

    public abstract void typePostBody(String text);

    public abstract CommunityPageBase clickPostButton();

    public abstract boolean checkPostTitleButtonVisibility();

    public abstract boolean checkPostBodyButtonVisibility();
}
