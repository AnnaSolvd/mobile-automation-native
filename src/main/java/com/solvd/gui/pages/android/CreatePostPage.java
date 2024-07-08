package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.CommunityPageBase;
import com.solvd.gui.pages.common.CreatePostPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CreatePostPageBase.class)
public class CreatePostPage extends CreatePostPageBase {

    //TODO: better locators
    @FindBy(xpath = "//android.widget.EditText[@resource-id='post_title']/android.view.View[2]")
    private ExtendedWebElement postTitle;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='post_body']")
    private ExtendedWebElement postBody;

    @FindBy(xpath = "//android.view.View[@resource-id='action_button']/android.view.View/android.view.View/android.widget.Button")
    private ExtendedWebElement postButton;

    protected CreatePostPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typePostTitle(String text) {
        postTitle.click();
        postTitle.type(text);
        hideKeyboard();
    }

    @Override
    public void typePostBody(String text) {
        postBody.click();
        postBody.type(text);
        hideKeyboard();
    }

    @Override
    public CommunityPageBase clickPostButton() {
        postButton.click();
        return initPage(getDriver(), CommunityPageBase.class);
    }
}
