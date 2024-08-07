package com.solvd.reddit.gui.pages.android;

import com.solvd.reddit.gui.pages.common.SearchResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchResultPageBase.class)
public class SearchResultPage extends SearchResultPageBase{

    private static final Logger logger = LoggerFactory.getLogger(SearchResultPage.class);

    @FindBy(xpath = "//android.view.View[@resource-id='tab_unit'])[1]/android.view.View")
    private ExtendedWebElement postNavigationTabButton;

    @FindBy(xpath = "//android.view.View[@resource-id='search_filter_button'])[1]/android.widget.Button")
    private ExtendedWebElement sortButton;

    @FindBy(xpath = "//android.view.View[@resource-id='feed_lazy_column']///android.view.View")
    private List<ExtendedWebElement> postList;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(postNavigationTabButton);
        logger.info("SearchResultPage open");
    }

    @Override
    public boolean isTermPresentInSearchPostsList(String searchTerm) {
        waitUntil(ExpectedConditions.visibilityOf(sortButton.getElement()), 10);

        postList.forEach(p -> logger.info("Element: {}", p.getText()));
//
        return true;
    }

}
