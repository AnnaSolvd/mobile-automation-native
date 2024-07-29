package com.solvd.gui.pages.android;

import com.solvd.gui.components.LeftNavigationSidebar;
import com.solvd.gui.components.Post;
import com.solvd.gui.components.ProfileNavigationSidebar;
import com.solvd.gui.pages.common.CommunityPageBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.PostDetailPageBase;
import com.solvd.gui.pages.common.SearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.checkerframework.checker.i18n.qual.Localized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.function.Function;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    @Localized
    @FindBy(xpath = "//android.view.View[@content-desc='{L10N:HomePage.redditIconText}']")
    private ExtendedWebElement redditIcon;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.reddit.frontpage:id/inner_peeking_snoovatar']]")
    private ExtendedWebElement profileIcon;

    @Localized
    @ExtendedFindBy(accessibilityId = "{L10N:HomePage.searchButtonText}")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//android.view.View[@resource-id='community_menu_button']/android.view.View/android.view.View/" +
            "android.widget.Button")
    private ExtendedWebElement leftNavigationBarButton;

    @FindBy(xpath = "//android.view.View[@resource-id='feed_lazy_column']/" +
            "android.view.View[contains(@resource-id, 'post_unit') and not(contains(@resource-id, 'promoted'))]")
    private List<Post> postList;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(redditIcon);
        logger.info("HomePage open");
    }

    @Override
    public boolean isRedditIconVisible() {
        return redditIcon.isVisible();
    }

    @Override
    public ProfileNavigationSidebar clickProfileIcon() {
        profileIcon.click();
        return new ProfileNavigationSidebar(getDriver());
    }

    @Override
    public SearchPageBase clickSearchButton() {
        searchButton.click();
        logger.info("Click search button");
        return initPage(getDriver(), SearchPageBase.class);
    }

    @Override
    public CommunityPageBase clickRandomPostCommunity() {
        return clickRandomPost(post -> {
            post.clickCommunityTitle();
            return initPage(getDriver(), CommunityPageBase.class);
        });
    }

    @Override
    public PostDetailPageBase clickRandomPostTitle() {
        return clickRandomPost(post -> {
            post.clickPostTitle();
            return initPage(getDriver(), PostDetailPageBase.class);
        });
    }

    @Override
    public LeftNavigationSidebar clickLeftNavigationBar() {
        leftNavigationBarButton.click();
        logger.info("Click navigation bar button");
        return new LeftNavigationSidebar(getDriver());
    }

    private Post getRandomPost(List<Post> posts) {
        Random random = new Random();
        return posts.get(random.nextInt(posts.size()));
    }

    private <T> T clickRandomPost(Function<Post, T> action) {
        logger.info("Post list size: {}", postList.size());
        Post randomPost = getRandomPost(postList);
        return action.apply(randomPost);
    }

}
