package com.solvd.reddit.gui.pages.common;

import com.solvd.reddit.gui.components.LeftNavigationSidebar;
import com.solvd.reddit.gui.components.Post;
import com.solvd.reddit.gui.components.ProfileNavigationSidebar;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage implements IMobileUtils {

    protected HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isRedditIconVisible();

    public abstract ProfileNavigationSidebar clickProfileIcon();

    public abstract SearchPageBase clickSearchButton();

    public abstract CommunityPageBase clickRandomPostCommunity();

    public abstract PostDetailPageBase clickRandomPostTitle();

    public abstract LeftNavigationSidebar clickLeftNavigationBar();

    public abstract Post getRandomPost();
}
