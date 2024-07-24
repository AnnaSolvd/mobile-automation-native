package com.solvd;

import com.solvd.gui.pages.common.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MobileSampleTest extends BaseTest {

    @Test(description = "TC-04")
    public void verifyJoiningCommunity() {
        SoftAssert softAssert = new SoftAssert();

        CommunityPageBase communityPage = initPage(driver, CommunityPageBase.class);
        communityPage.isPageOpened();
        softAssert.assertTrue(communityPage.isCommunityTitlePresent(), "Community title is not present");

        communityPage.clickJoinButton();
        boolean isJoinedState = communityPage.hasJoinedState();
        softAssert.assertTrue(isJoinedState, "Button text don't change from join to joined");

        //TODO: problem with welcome community modal
        //BottomNavigationBar bottomNavigationBar = new BottomNavigationBar(driver);
        //bottomNavigationBar.clickMenuButtonByName(BottomNavigationBarTitle.HOME.getTitle());

        softAssert.assertAll();
    }

}
