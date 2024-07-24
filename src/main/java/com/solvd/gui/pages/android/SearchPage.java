package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.SearchPageBase;
import com.solvd.gui.pages.common.SearchResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase {

    private static final Logger logger = LoggerFactory.getLogger(SearchPage.class);

    //TODO: make better locators
    @FindBy(id = "com.reddit.frontpage:id/search")
    private ExtendedWebElement searchInput;

    public SearchPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchInput);
        logger.info("SearchPage open");
    }

    @Override
    public SearchResultPageBase typeSearchInput(String searchText) {
        searchInput.type(searchText);
        pressKeyboardKey(AndroidKey.ENTER);
        return initPage(getDriver(), SearchResultPageBase.class);
    }
}
