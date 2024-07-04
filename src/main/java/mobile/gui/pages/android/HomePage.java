package mobile.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import mobile.gui.components.SideMenu;
import mobile.gui.pages.common.HomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(id = "inner_peeking_snoovatar")
    private ExtendedWebElement profileButton;

    @FindBy(id = "feed_control_search_icon")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//android.widget.Button[@text='Continue with Google']")
    private ExtendedWebElement logInGoogleLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //TODO: resolve issue if user is logged in or not
    @Override
    public SideMenu clickProfileIcon() {
        profileButton.click();
        return new SideMenu(getDriver());
    }

    @Override
    public boolean isProfileIconVisible() {
        return profileButton.isVisible();
    }

    @Override
    public void clickSearchButton() {
        searchButton.click();
    }

}
