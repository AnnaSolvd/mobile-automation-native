package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.CommunityPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CommunityPageBase.class)
public class CommunityPage extends CommunityPageBase {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='subreddit_header_title']")
    private ExtendedWebElement communityTitle;

    @FindBy(id = "subreddit_join_button")
    private ExtendedWebElement subredditJoinButton;

    public CommunityPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(communityTitle);
    }

    @Override
    public boolean isCommunityTitlePresent() {
        return communityTitle.isPresent();
    }

    @Override
    public void clickJoinButton() {
        subredditJoinButton.click();
    }


}
