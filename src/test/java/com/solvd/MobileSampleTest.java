package com.solvd;

import com.solvd.gui.components.LeftNavigationSidebar;
import com.solvd.gui.pages.common.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class MobileSampleTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(MobileSampleTest.class);

    @Test(description = "TC-05")
    public void verifyRecentlyVisitedSection() {
        SoftAssert softAssert = new SoftAssert();
        HomePageBase homePage = initPage(driver, HomePageBase.class);
        homePage.isPageOpened();

        CommunityPageBase communityPage = homePage.clickRandomPostCommunity();
        String communityTitle = communityPage.getCommunityTitle();
        logger.info("Community title: {}", communityTitle);

        softAssert.assertTrue(communityPage.isCommunityTitlePresent(), "Community title is not present");

        homePage = communityPage.clickReturnButton();
        LeftNavigationSidebar navigationSidebar = homePage.clickLeftNavigationBar();
        navigationSidebar.clickSeeAllButton();
        assertTrue(navigationSidebar.checkPresenceOfCommunity(communityTitle),
                "The recently clicked community should be present in Recently Visited section");
        softAssert.assertAll();
    }

}
