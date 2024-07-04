package mobile.gui.components;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import mobile.gui.pages.common.ProfilePageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SideMenu extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(id = "drawer_nav_items_container")
    private List<ExtendedWebElement> sideMenuButtons;

    @FindBy(id = "nav_user_name")
    private ExtendedWebElement usernameText;

    public SideMenu(WebDriver driver) {
        super(driver);
    }

    protected SideMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ProfilePageBase clickMenuButtonByName(String buttonName) {
        sideMenuButtons.stream()
                .filter(button -> button.getText().equalsIgnoreCase(buttonName))
                .findFirst()
                .ifPresent(ExtendedWebElement::click);

        return initPage(driver, ProfilePageBase.class);
    }

    public boolean checkPresenceOfButton(String buttonName) {
        return sideMenuButtons.stream()
                .anyMatch(button -> button.getText().equalsIgnoreCase(buttonName));
    }
}
