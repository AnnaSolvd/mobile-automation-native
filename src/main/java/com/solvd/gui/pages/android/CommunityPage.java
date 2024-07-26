package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.CommunityPageBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.checkerframework.checker.i18n.qual.Localized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CommunityPageBase.class)
public class CommunityPage extends CommunityPageBase {

    private static final Logger logger = LoggerFactory.getLogger(CommunityPage.class);

    @FindBy(xpath = "//android.widget.TextView[@resource-id='subreddit_header_title']")
    private ExtendedWebElement communityTitle;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Back']")
    private ExtendedWebElement returnButton;

//    @FindBy(xpath = "//android.widget.Button[contains(@content-desc,'Join')]")
//    private ExtendedWebElement subredditJoinButton;
//
//    @FindBy(xpath = "//android.widget.Button[contains(@content-desc,'Leave')]")
//    private ExtendedWebElement subredditLeaveButton;

    @Localized
    @FindBy(xpath = "//android.widget.Button[contains(@content-desc,'{L10N:CommunityPage.joinButtonText}')]")
    private ExtendedWebElement subredditJoinButton;

    @Localized
    @FindBy(xpath = "//android.widget.Button[contains(@content-desc,'{L10N:CommunityPage.leaveButtonText}')]")
    private ExtendedWebElement subredditLeaveButton;

    public CommunityPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(communityTitle);
        logger.info("CommunityPage open");
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
        subredditJoinButton.click();
        logger.info("Click join button");
        pressKeyboardKey(AndroidKey.ENTER);
    }

    @Override
    public boolean hasJoinedState() {
        String contentDesc = subredditJoinButton.getAttribute("content-desc");
        return contentDesc.contains("Leave");
    }

}
