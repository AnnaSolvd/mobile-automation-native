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

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CreatePostPageBase.class)
public class CreatePostPage extends CreatePostPageBase {

    private static final Logger logger = LoggerFactory.getLogger(CreatePostPage.class);

    @FindBy(id = "post_title")
    private ExtendedWebElement postTitle;

    @FindBy(id = "post_body")
    private ExtendedWebElement postBody;

    @FindBy(xpath = "//android.view.View[@resource-id='action_button']/android.view.View/android.view.View" +
            "/android.widget.Button")
    private ExtendedWebElement postButton;

    public CreatePostPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(postTitle);
        logger.info("CreatePage open");
    }

    @Override
    public boolean checkPostTitleButtonVisibility() {
        return postTitle.isVisible() && postTitle.isClickable();
    }

    @Override
    public void typePostTitle(String text) {
        postTitle.click();
        postTitle.type(text);
        logger.info("Enter text into post title");
        hideKeyboard();
    }

    @Override
    public boolean checkPostBodyButtonVisibility() {
        return postBody.isVisible() && postBody.isClickable();
    }

    @Override
    public void typePostBody(String text) {
        postBody.click();
        postBody.type(text);
        logger.info("Enter text into post body");
        hideKeyboard();
    }

    @Override
    public CommunityPageBase clickPostButton() {
        postButton.click();
        logger.info("Click post button");
        return initPage(getDriver(), CommunityPageBase.class);
    }
}
