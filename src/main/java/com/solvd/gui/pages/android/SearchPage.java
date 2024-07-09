package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.SearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPage.class)
public class SearchPage extends SearchPageBase {

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.reddit.frontpage:id/search']")
    private ExtendedWebElement searchInput;

    public SearchPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchInput);
    }

    @Override
    public void typeSearchInput(String searchText) {
        searchInput.click();
        searchInput.type(searchText);
        hideKeyboard();
    }
}
