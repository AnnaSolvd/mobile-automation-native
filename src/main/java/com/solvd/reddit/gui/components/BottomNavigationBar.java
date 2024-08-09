package com.solvd.reddit.gui.components;

import com.solvd.reddit.gui.pages.common.CreatePostPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BottomNavigationBar extends AbstractUIObject implements ICustomTypePageFactory {

    private static final Logger logger = LoggerFactory.getLogger(BottomNavigationBar.class);

    //TODO: better locator
    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.reddit.frontpage:id/bottom_nav_compose']")
    private List<ExtendedWebElement> navigationBarButtonsList;

    public BottomNavigationBar(WebDriver driver) {
        super(driver);
    }

    protected BottomNavigationBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CreatePostPageBase clickMenuButtonByName(String buttonName) {
        navigationBarButtonsList.stream()
                .filter(button -> {
                    List<ExtendedWebElement> textViews = button.findExtendedWebElements(By.xpath(".//android.widget.TextView"));
                    return textViews.stream().anyMatch(textView -> textView.getText().equalsIgnoreCase(buttonName));
                })
                .findFirst()
                .ifPresent(ExtendedWebElement::click);

        logger.info("Clicked on the button: {}", buttonName);
        return initPage(getDriver(), CreatePostPageBase.class);
    }
}
