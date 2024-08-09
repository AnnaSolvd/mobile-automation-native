package com.solvd.reddit.gui.pages.android;

import com.solvd.reddit.gui.pages.common.CommunityPageBase;
import com.solvd.reddit.gui.pages.common.CreatePostPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CreatePostPageBase.class)
public class CreatePostPage extends CreatePostPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//android.widget.EditText[@resource-id='post_title']")
    private ExtendedWebElement postTitle;

    @FindBy(xpath= "//android.widget.EditText[@resource-id='post_body']")
    private ExtendedWebElement postBody;

    @FindBy(xpath = "//android.view.View[@resource-id='action_button']/android.view.View/android.view.View/android.widget.Button")
    private ExtendedWebElement postButton;

    @FindBy(xpath= "//android.widget.ImageButton[@content-desc='Back']")
    private ExtendedWebElement returnButton;

    public CreatePostPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(postTitle);
        LOGGER.info("CreatePostPage open");
    }

    @Override
    public boolean checkPostTitleButtonVisibility() {
        return postTitle.isVisible() && postTitle.isClickable();
    }

    @Override
    public boolean checkPostBodyButtonVisibility() {
        return postBody.isVisible() && postBody.isClickable();
    }

    @Override
    public void typePostTitle(String text) {
        postTitle.type(text);
        hideKeyboard();
    }

    @Override
    public void typePostBody(String text) {
        postBody.type(text);
        hideKeyboard();
    }

    @Override
    public CommunityPageBase clickPostButton() {
        postButton.click();
        LOGGER.info("Post button clicked");
        return initPage(getDriver(), CommunityPageBase.class);
    }
}
