package com.solvd.utils;

import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;

public class DeepLinkManager {

    private WebDriver driver;

    public DeepLinkManager(WebDriver driver) {
        this.driver = driver;
    }

    public void setupDeepLink(String methodName, String username, String publicCommunity, String testingCommunity) {
        String deeplink = null;
        switch (methodName) {
            case "verifySearchFunctionality":
                deeplink = R.TESTDATA.get("deeplink.home");
                break;
            case "verifyThatUserCanUpdateProfileBio":
                deeplink = R.TESTDATA.get("deeplink.profile") + username;
                break;
            case "verifyUserPostingOnCommunity":
                deeplink = R.TESTDATA.get("deeplink.community") + testingCommunity;
                break;
            case "verifyJoiningCommunityAndYourCommunitiesSection":
                deeplink = R.TESTDATA.get("deeplink.community") + publicCommunity;
                break;
            case "testInternationalization":
                deeplink = R.TESTDATA.get("deeplink.settings");
                break;
        }
        if (deeplink != null) {
            driver.get(deeplink);
        }
    }
}
