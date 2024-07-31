package com.solvd.reddit.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class BasePage extends AbstractPage {

    @FindBy(id = "com.reddit.frontpage:id/link_list")
    private List<ExtendedWebElement> postList;

    protected BasePage(WebDriver driver) {
        super(driver);
    }

    public String getFirstSavedPostTitle() {
        if (!postList.isEmpty()) {
            ExtendedWebElement firstPost = postList.get(0);
            ExtendedWebElement titleElement = firstPost.findExtendedWebElement(By.id("com.reddit.frontpage:id/title"));
            titleElement.getText();
        } else {
            throw new RuntimeException("Post list is empty");
        }
        return "";
    }
}
