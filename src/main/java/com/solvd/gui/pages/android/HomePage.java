package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.SearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    //TODO: make better locators
    @ExtendedFindBy(accessibilityId = "Home feed")
    private ExtendedWebElement redditIcon;

    @ExtendedFindBy(accessibilityId = "Search")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//android.view.View[@resource-id='feed_lazy_column']/android.view.View[contains(@resource-id, 'post_unit') " +
            "or contains(@resource-id, 'promoted_post_unit')]")
    private List<ExtendedWebElement> postComponentsList;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(redditIcon);
        logger.info("HomePage open");
    }

    @Override
    public boolean isRedditIconVisible() {
        return redditIcon.isVisible();
    }

    @Override
    public SearchPageBase clickSearchButton() {
        searchButton.click();
        logger.info("Click search button");
        return initPage(getDriver(), SearchPageBase.class);
    }

    @Override
    public void clickRandomPost() {}

}
