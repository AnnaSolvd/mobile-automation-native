package com.solvd.gui.components;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigationSidebar extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = "")
    private List<ExtendedWebElement> recentlyVisitedSectionList;

    @FindBy(xpath = "")
    private List<ExtendedWebElement> moderatingSectionList;

    @FindBy(xpath = "")
    private List<ExtendedWebElement> yourCommunitiesSectionList;

    protected NavigationSidebar(WebDriver driver) {
        super(driver);
    }

    protected NavigationSidebar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
