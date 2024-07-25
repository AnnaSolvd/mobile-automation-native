package com.solvd;

import com.solvd.gui.pages.common.*;
import com.zebrunner.carina.utils.resources.L10N;
import org.testng.annotations.Test;

import static com.zebrunner.carina.utils.R.CONFIG;


public class MobileSampleTest extends BaseTest {

    @Test(description = "TC-05")
    public void verifyJoiningCommunity() {
        CONFIG.put("locale", "fr_FR", true);
        L10N.load();

        CommunityPageBase communityPage = initPage(driver, CommunityPageBase.class);
        communityPage.isPageOpened();
        communityPage.clickJoinButton();
        L10N.flush();
    }

//    @Test(description = "TC-05")
//    public void verifyRecentlyVisitedSection() {
//        HomePageBase homePage = initPage(driver, HomePageBase.class);
//        homePage.isPageOpened();
//
//        //homePage.clickRandomPost();
//    }

}
