package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.PostDetailPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PostDetailPageBase.class)
public class PostDetailPage extends PostDetailPageBase {

    @FindBy(xpath = "//android.view.View[@content-desc='Home feed']")
    private ExtendedWebElement dropDownMenuButton;

    public PostDetailPage(WebDriver driver) {
        super(driver);
    }
}
