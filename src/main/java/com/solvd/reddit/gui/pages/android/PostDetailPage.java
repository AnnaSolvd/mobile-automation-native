package com.solvd.reddit.gui.pages.android;

import com.solvd.reddit.gui.components.DropDownMenu;
import com.solvd.reddit.gui.pages.common.HomePageBase;
import com.solvd.reddit.gui.pages.common.PostDetailPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.checkerframework.checker.i18n.qual.Localized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PostDetailPageBase.class)
public class PostDetailPage extends PostDetailPageBase {

    private static final Logger logger = LoggerFactory.getLogger(PostDetailPage.class);

    @Localized
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='{L10N:PostDetailPage.dropDownMenuButtonText}']")
    private ExtendedWebElement dropDownMenuButton;

    @Localized
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='{L10N:PostDetailPage.returnButtonText}']")
    private ExtendedWebElement returnButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.reddit.frontpage:id/link_title']")
    private ExtendedWebElement postTitle;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.reddit.frontpage:id/detail_subreddit_name']")
    private ExtendedWebElement postCommunity;

    @FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, 'comment by')]")
    private List<ExtendedWebElement> commentList;

    public PostDetailPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(dropDownMenuButton);
        logger.info("PostDetailPage open");
    }

    @Override
    public DropDownMenu clickDropDownMenuButton() {
        dropDownMenuButton.click();
        return new DropDownMenu(getDriver());
    }

    @Override
    public HomePageBase clickReturnButton() {
        returnButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public String getPostTitle() {
        return postTitle.getAttribute("text");
    }

    @Override
    public String getPostCommunity() {
        return postCommunity.getAttribute("text");
    }

    public boolean areCommentsPresent() {
        return !commentList.isEmpty();
    }
}
