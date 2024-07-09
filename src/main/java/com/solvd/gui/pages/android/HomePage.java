package com.solvd.gui.pages.android;

import com.solvd.gui.components.Post;
import com.solvd.gui.components.SideMenu;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.SearchPageBase;
import com.solvd.gui.pages.common.SearchResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    @FindBy(id = "inner_peeking_snoovatar")
    private ExtendedWebElement profileButton;

    @FindBy(id = "feed_control_search_icon")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//android.view.View[@resource-id='feed_lazy_column']/android.view.View[contains(@resource-id, 'post_unit') " +
            "or contains(@resource-id, 'promoted_post_unit')]")
    private List<ExtendedWebElement> postComponentsList;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(profileButton);
    }

    @Override
    public boolean isProfileIconVisible() {
        return profileButton.isVisible();
    }

    @Override
    public SearchPageBase clickSearchButton() {
        searchButton.click();
        return initPage(SearchPageBase.class, getDriver());
    }

}
