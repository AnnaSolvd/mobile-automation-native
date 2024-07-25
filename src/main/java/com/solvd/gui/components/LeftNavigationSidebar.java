package com.solvd.gui.components;

import com.solvd.gui.pages.android.CreatePostPage;
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

public class LeftNavigationSidebar extends AbstractUIObject implements ICustomTypePageFactory {

    private static final Logger logger = LoggerFactory.getLogger(LeftNavigationSidebar.class);

    @FindBy(xpath = "//android.view.View[@resource-id='recently_visited']")
    private ExtendedWebElement recentlyVisitedSectionText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='see_all']")
    private ExtendedWebElement seeAllButton;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.reddit.frontpage:id/items_list']")
    private List<ExtendedWebElement> recentlyVisitedSectionList;

    public LeftNavigationSidebar(WebDriver driver) {
        super(driver);
    }

    protected LeftNavigationSidebar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean checkPresenceOfCommunity(String buttonName) {
        boolean isPresent = recentlyVisitedSectionList.stream()
                .anyMatch(viewGroup -> {
                    List<ExtendedWebElement> buttons = viewGroup.findExtendedWebElements(By.xpath(".//android.widget.TextView"));
                    return buttons.stream().anyMatch(button -> {
                        String description = button.getAttribute("text");
                        logger.info("Button title: {}", description);
                        return description != null && description.contains(buttonName);
                    });
                });
        logger.info("Checking presence of button: {} - Found: {}", buttonName, isPresent);
        return isPresent;
    }

    public void clickSeeAllButton() {
        seeAllButton.click();
    }
}
