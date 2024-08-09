package com.solvd.reddit.gui.pages.android;

import com.solvd.reddit.gui.pages.common.CommunityPageBase;
import com.solvd.reddit.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.checkerframework.checker.i18n.qual.Localized;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CommunityPageBase.class)
public class CommunityPage extends CommunityPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//android.widget.TextView[@resource-id='subreddit_header_title']")
    private ExtendedWebElement communityTitle;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Back']")
    private ExtendedWebElement returnButton;

    @Localized
    @FindBy(xpath = "//android.widget.Button[contains(@content-desc,'{L10N:CommunityPage.joinButtonText}')]")
    private ExtendedWebElement subredditJoinButton;

    @Localized
    @FindBy(xpath = "//android.widget.Button[contains(@content-desc,'{L10N:CommunityPage.leaveButtonText}')]")
    private ExtendedWebElement subredditLeaveButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private ExtendedWebElement leaveButton;

    public CommunityPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(communityTitle);
        LOGGER.info("CommunityPage opens");
    }

    @Override
    public boolean isCommunityTitlePresent() {
        return communityTitle.isPresent();
    }

    @Override
    public String getCommunityTitle() {
        return communityTitle.getAttribute("text");
    }

    @Override
    public HomePageBase clickReturnButton() {
        returnButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public void clickJoinButton() {
        if (subredditJoinButton.isElementPresent()) {
            subredditJoinButton.click();
            LOGGER.info("Click join button");
        } else if (subredditLeaveButton.isElementPresent()) {
            subredditLeaveButton.click();
            leaveButton.click();
            LOGGER.info("Click leave button");
        } else {
            LOGGER.error("Neither join nor leave button is present");
        }
    }

    @Override
    public boolean hasJoinedState() {
        if (subredditLeaveButton.isElementPresent()) {
            return true;
        } else if (subredditJoinButton.isElementPresent()){
           return false;
        } else {
            LOGGER.error("Neither join nor leave button is present");
        }
        return false;
    }

}
