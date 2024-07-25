package com.solvd.util;

import com.zebrunner.carina.utils.R;

public class DeepLinkFactory {

    private static final String USERNAME;
    private static final String PUBLIC_COMMUNITY;
    private static final String TESTING_COMMUNITY;

    static {
        USERNAME = R.TESTDATA.get("user.username");
        PUBLIC_COMMUNITY = R.TESTDATA.get("community.public");
        TESTING_COMMUNITY = R.TESTDATA.get("community.testing");
    }

    public String createDeepLink(String methodName) {
        return switch (methodName) {
            //TODO: duplication
            case "verifySearchFunctionality" -> R.TESTDATA.get("deeplink.home");
            case "verifyRecentlyVisitedSection" -> R.TESTDATA.get("deeplink.home");

            case "verifyThatUserCanUpdateProfileBio" -> R.TESTDATA.get("deeplink.profile") + USERNAME;
            case "verifyUserPostingOnCommunity" -> R.TESTDATA.get("deeplink.community") + TESTING_COMMUNITY;
            case "verifyJoiningCommunity" -> R.TESTDATA.get("deeplink.community") + PUBLIC_COMMUNITY;
            default -> throw new IllegalArgumentException("Unsupported method: " + methodName);
        };
    }
}
