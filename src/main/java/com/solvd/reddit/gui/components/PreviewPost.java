package com.solvd.reddit.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PreviewPost extends AbstractUIObject {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.reddit.frontpage:id/title']")
    private ExtendedWebElement postTitle;

    public PreviewPost(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public PreviewPost(WebDriver driver) {
        super(driver);
    }

    public String getPostTitle() {
        return postTitle.getText();
    }
}
