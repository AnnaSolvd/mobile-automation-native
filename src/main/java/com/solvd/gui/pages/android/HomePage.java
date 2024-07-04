package com.solvd.gui.pages.android;

import com.solvd.gui.components.Post;
import com.solvd.gui.components.SideMenu;
import com.solvd.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(id = "inner_peeking_snoovatar")
    private ExtendedWebElement profileButton;

    @FindBy(id = "feed_control_search_icon")
    private ExtendedWebElement searchButton;

    @FindBy(id = "feed_control_search_icon")
    private List<Post> postList;

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
