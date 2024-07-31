package com.solvd.reddit.gui.pages.common;

import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CommunityPageBase extends AbstractPage implements IAndroidUtils {

    public CommunityPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCommunityTitlePresent();

    public abstract HomePageBase clickReturnButton();

    public abstract void clickJoinButton();

    public abstract boolean hasJoinedState();

    public abstract String getCommunityTitle();
}
