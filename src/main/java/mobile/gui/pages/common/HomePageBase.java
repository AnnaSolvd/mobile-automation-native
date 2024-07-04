package mobile.gui.pages.common;

import mobile.gui.components.SideMenu;
import mobile.gui.pages.BasePage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends BasePage {

    protected HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SideMenu clickProfileIcon();

    public abstract boolean isProfileIconVisible();

    public abstract void clickSearchButton();

}
