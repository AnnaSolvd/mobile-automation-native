package com.solvd.gui.components;

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
        String cleanString = cleanButtonNameFromCodePoints(buttonName);
        return recentlyVisitedSectionList.stream()
                .anyMatch(viewGroup -> {
                    List<ExtendedWebElement> buttons = viewGroup
                            .findExtendedWebElements(By.xpath(".//android.widget.TextView"));

                    return buttons.stream().anyMatch(button -> {
                        String description = button.getAttribute("text");
                        return description != null && description.equals(cleanString);
                    });
                });
    }

    public void clickSeeAllButton() {
        seeAllButton.click();
    }

    private String cleanButtonNameFromCodePoints(String buttonName) {
        return buttonName.replaceAll("\\p{C}", "");
    }
}
