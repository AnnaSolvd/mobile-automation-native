package com.solvd.gui.components;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Post extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = "//android.view.View[@resource-id='post_header'])[2]/android.view.View[2]")
    private ExtendedWebElement postCommunityTitle;

    @FindBy(xpath = "post_join_button")
    private ExtendedWebElement joinButton;

    public Post(WebDriver driver) {
        super(driver);
    }

    public Post(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickPostCommunityTitle() {
        postCommunityTitle.click();
    }
}
