package mobile.gui.components;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import mobile.gui.pages.common.ProfilePageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class SideMenu extends AbstractUIObject implements ICustomTypePageFactory {

    private static final Logger logger = LoggerFactory.getLogger(SideMenu.class);

    //TODO: improve locator
    @FindBy(xpath = "//android.widget.ScrollView[@resource-id='com.reddit.frontpage:id/drawer_nav_items_scroll_view']//android.widget.Button")
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

        logger.info("Clicked on the button: {}", buttonName);
        return initPage(driver, ProfilePageBase.class);
    }

    public boolean checkPresenceOfButton(String buttonName) {
        boolean isPresent = sideMenuButtons.stream()
                .anyMatch(button -> button.getText().equalsIgnoreCase(buttonName));

        logger.info("Checking presence of button: {} - Found: {}", buttonName, isPresent);
        return isPresent;
    }

}
