package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.SearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPage.class)
public class SearchPage extends SearchPageBase {

    @FindBy(id = "search")
    private ExtendedWebElement searchInput;

    protected SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeSearchInput(String searchText) {
        searchInput.type(searchText);
    }
}
