package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.PostDetailPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PostDetailPage extends PostDetailPageBase {

    @FindBy(xpath = "(//android.view.View[@resource-id='post_header'])[1]/android.view.View[2]")
    private ExtendedWebElement communityTitle;

    protected PostDetailPage(WebDriver driver) {
        super(driver);
    }
}
