package com.solvd.reddit.gui.pages.android;

import com.solvd.reddit.gui.components.LeftNavigationSidebar;
import com.solvd.reddit.gui.components.Post;
import com.solvd.reddit.gui.components.ProfileNavigationSidebar;
import com.solvd.reddit.gui.pages.common.CommunityPageBase;
import com.solvd.reddit.gui.pages.common.HomePageBase;
import com.solvd.reddit.gui.pages.common.PostDetailPageBase;
import com.solvd.reddit.gui.pages.common.SearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    @FindBy(xpath = "//android.view.View[@content-desc='Home feed']")
    private ExtendedWebElement redditIcon;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.reddit.frontpage:id/inner_peeking_snoovatar']")
    private ExtendedWebElement profileIcon;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Search']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//android.view.View[@resource-id='community_menu_button']/android.view.View/android.view.View/" +
            "android.widget.Button")
    private ExtendedWebElement leftNavigationBarButton;

    @FindBy(xpath = "//android.view.View[@resource-id='feed_lazy_column']/" +
            "android.view.View[contains(@resource-id, 'post_unit') and not(contains(@resource-id, 'promoted'))]")
    private List<Post> postList;

    public HomePage(WebDriver driver) {
        super(driver);
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
    public LeftNavigationSidebar clickLeftNavigationBar() {
        leftNavigationBarButton.click();
        logger.info("Click navigation bar button");
        return new LeftNavigationSidebar(getDriver());
    }

    @Override
    public Post getRandomPost() {
        postList.forEach(p -> logger.info(p.getTitle()));

        if (postList.isEmpty()) {
            throw new NoSuchElementException("Product list is empty");
        }

        Random random = new Random();
        Post selectedPost = postList.get(random.nextInt(postList.size()));
        logger.info("Selected post title: {}", selectedPost.getTitle());
        return selectedPost;
    }

}
