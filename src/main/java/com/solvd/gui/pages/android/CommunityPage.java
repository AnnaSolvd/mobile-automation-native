package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.CommunityPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CommunityPageBase.class)
public class CommunityPage extends CommunityPageBase {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='subreddit_header_title']")
    private ExtendedWebElement communityTitle;

    @FindBy(xpath = "//android.widget.Button[contains(@content-desc,'Join')]")
    private ExtendedWebElement subredditJoinButton;

    @FindBy(xpath = "//android.widget.Button[contains(@content-desc,'Leave')]")
    private ExtendedWebElement subredditLeaveButton;

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
        pressKeyboardKey(AndroidKey.ENTER);
    }

    @Override
    public boolean hasJoinedState() {
        String contentDesc = subredditJoinButton.getAttribute("content-desc");
        return contentDesc.contains("Leave");
    }


}
