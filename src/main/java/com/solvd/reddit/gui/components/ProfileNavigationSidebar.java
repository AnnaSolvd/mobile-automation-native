package com.solvd.reddit.gui.components;

import com.solvd.reddit.gui.pages.common.HistoryPageBase;
import com.solvd.reddit.gui.pages.common.SavedPageBase;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
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


public class ProfileNavigationSidebar extends AbstractUIObject implements ICustomTypePageFactory, IAndroidUtils{

    private static final Logger logger = LoggerFactory.getLogger(ProfileNavigationSidebar.class);

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.reddit.frontpage:id/drawer_nav_items_container']//android.widget.Button")
    private List<ExtendedWebElement> buttonList;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.reddit.frontpage:id/drawer_nav_item_title' and @text='History']")
    private ExtendedWebElement historyButton;

    public ProfileNavigationSidebar(WebDriver driver) {
        super(driver);
    }

    protected ProfileNavigationSidebar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    private void getButtonByName(String buttonName) {
        buttonList.forEach(button -> logger.info("Button: {}", button));

        buttonList.stream()
                //TODO: change to .findAny.ifPresent
                .filter(button -> {
                    List<ExtendedWebElement> textViews = button.findExtendedWebElements(By.xpath(".//android.widget.TextView"));
                    return textViews.stream().anyMatch(textView -> textView.getText().equalsIgnoreCase(buttonName));
                })
                .findFirst()
                .ifPresent(ExtendedWebElement::click);
        logger.info("Clicked on the button: {}", buttonName);
    }

    private void swipeToBottom() {
        historyButton.scrollTo();
    }

    public <T extends AbstractPage> T clickButtonByName(String buttonName, Class<T> pageClass) {
        swipeToBottom();
        getButtonByName(buttonName);
        return initPage(driver, pageClass);
    }

}
