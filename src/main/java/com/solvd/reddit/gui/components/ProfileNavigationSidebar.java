package com.solvd.reddit.gui.components;

import com.solvd.reddit.gui.pages.common.HistoryPageBase;
import com.solvd.reddit.gui.pages.common.SavedPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProfileNavigationSidebar extends AbstractUIObject implements ICustomTypePageFactory {

    private static final Logger logger = LoggerFactory.getLogger(ProfileNavigationSidebar.class);

    //TODO: better locator
    @FindBy(xpath = "//android.widget.ScrollView[@resource-id='com.reddit.frontpage:id/drawer_nav_items_scroll_view']" +
            "//android.widget.LinearLayout[@resource-id='com.reddit.frontpage:id/drawer_nav_items_container']" +
            "//android.widget.Button")
    private List<ExtendedWebElement> sideMenuButtonsList;

    @FindBy(id = "nav_user_name")
    private ExtendedWebElement usernameText;

    public ProfileNavigationSidebar(WebDriver driver) {
        super(driver);

    }

    protected ProfileNavigationSidebar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    private void getButtonByName(String buttonName) {
        sideMenuButtonsList.stream()
                .filter(button -> { List<ExtendedWebElement> textViews = button.findExtendedWebElements(By.xpath(".//android.widget.TextView"));
                    return textViews.stream().anyMatch(textView -> textView.getText().equalsIgnoreCase(buttonName));
                })
                .findFirst()
                .ifPresent(ExtendedWebElement::click);
        logger.info("Clicked on the button: {}", buttonName);
    }

    public <T extends AbstractPage> T clickButtonByName(String buttonName, Class<T> pageClass) {
        getButtonByName(buttonName);
        return initPage(driver, pageClass);
    }

    public boolean checkPresenceOfButton(String buttonName) {
        boolean isPresent = sideMenuButtonsList.stream()
                .anyMatch(button -> { List<ExtendedWebElement> textViews = button.findExtendedWebElements(By.xpath(".//android.widget.TextView"));
                    return textViews.stream().anyMatch(textView -> textView.getText().equalsIgnoreCase(buttonName));
                });
        logger.info("Checking presence of button: {} - Found: {}", buttonName, isPresent);
        return isPresent;
    }


//    public HistoryPageBase clickHistoryButton(String buttonName) {
//        sideMenuButtonsList.stream()
//                .filter(button -> {
//                    List<ExtendedWebElement> textViews = button.findExtendedWebElements(By.xpath(".//android.widget.TextView"));
//                    return textViews.stream().anyMatch(textView -> textView.getText().equalsIgnoreCase(buttonName));
//                })
//                .findFirst()
//                .ifPresent(ExtendedWebElement::click);
//        logger.info("Clicked on the button: {}", buttonName);
//        return initPage(driver, HistoryPageBase.class);
//    }
//
//    public boolean checkPresenceOfButton(String buttonName) {
//        boolean isPresent = sideMenuButtonsList.stream()
//                .anyMatch(button -> { List<ExtendedWebElement>
//                        textViews = button.findExtendedWebElements(By.xpath(".//android.widget.TextView"));
//                    return textViews.stream().anyMatch(textView -> textView.getText().equalsIgnoreCase(buttonName));
//                });
//        logger.info("Checking presence of button: {} - Found: {}", buttonName, isPresent);
//        return isPresent;
//    }

}
