package com.solvd.reddit.gui.components;

import com.solvd.reddit.gui.pages.common.CommunityPageBase;
import com.solvd.reddit.gui.pages.common.PostDetailPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Post extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = "(//android.view.View[@resource-id='post_header'])[1]/android.view.View[2]")
    private ExtendedWebElement postCommunity;

    @FindBy(xpath = "//android.view.View[@resource-id='post_join_button']")
    private ExtendedWebElement joinButton;

    @FindBy(xpath = "//android.view.View[@resource-id='post_unit']/android.view.View[4]")
    private ExtendedWebElement postTitle;

    public Post(WebDriver driver) {
        super(driver);
    }

    public Post(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public PostDetailPageBase clickPostTitle() {
        postTitle.click();
        return initPage(getDriver(), PostDetailPageBase.class);
    }

    public CommunityPageBase clickPostCommunity() {
        postCommunity.click();
        return initPage(getDriver(), CommunityPageBase.class);
    }

    public String getTitle() {
        return postTitle.getText();
    }

    public String getCommunity() {
        return postCommunity.getText();
    }

}
