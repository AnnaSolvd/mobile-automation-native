package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.SearchResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchResultPageBase.class)
public class SearchResultPage extends SearchResultPageBase{

    public SearchResultPage(WebDriver driver) {
        super(driver);
//        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
//        setUiLoadedMarker(searchInput);
    }
}
