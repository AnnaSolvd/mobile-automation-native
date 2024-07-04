package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.CommunityPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CommunityPageBase.class)
public class CommunityPage extends CommunityPageBase {

    @FindBy(id = "subreddit_header_title")
    private ExtendedWebElement communityTitle;

    @FindBy(id = "subreddit_toolbar_back_button")
    private ExtendedWebElement backButton;

    public CommunityPage(WebDriver driver) {
        super(driver);
    }
}
