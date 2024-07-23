package com.solvd.utils;

import com.solvd.gui.pages.android.SearchResultPage;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeepLinkManager {

    private static final Logger logger = LoggerFactory.getLogger(DeepLinkManager.class);

    private final WebDriver driver;
    private static final String publicCommunity;
    private static final String testingCommunity;
    private static final String username;

    static {
        publicCommunity = R.TESTDATA.get("community.public");
        testingCommunity = R.TESTDATA.get("community.testing");
        username = R.TESTDATA.get("user.username");
    }

    public DeepLinkManager(WebDriver driver) {
        this.driver = driver;
    }

    public void setupDeepLink(String methodName) {
        logger.info("Method name: {}", methodName);
        String deepLink = createDeepLink(methodName);
        logger.info("Deeplink: {}", deepLink);
        driver.get(deepLink);
    }

    private String createDeepLink(String methodName) {
        return switch (methodName) {
            case "verifySearchFunctionality" -> R.TESTDATA.get("deeplink.home");
            case "verifyThatUserCanUpdateProfileBio" -> R.TESTDATA.get("deeplink.profile") + username;
            case "verifyUserPostingOnCommunity" -> R.TESTDATA.get("deeplink.community") + testingCommunity;
            case "verifyJoiningCommunityAndYourCommunitiesSection" -> R.TESTDATA.get("deeplink.community") + publicCommunity;
            default -> throw new IllegalArgumentException("Invalid method name: " + methodName);
        };
    }
}
