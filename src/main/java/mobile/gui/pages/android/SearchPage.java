package mobile.gui.pages.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import mobile.gui.pages.common.SearchPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

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
