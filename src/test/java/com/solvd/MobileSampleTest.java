package com.solvd;

import com.solvd.gui.pages.common.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class MobileSampleTest extends BaseTest {

    @Test(description = "TC-04")
    public void verifyJoiningCommunityAndYourCommunitiesSection() {
        SoftAssert softAssert = new SoftAssert();

        CommunityPageBase communityPage = initPage(driver, CommunityPageBase.class);
        communityPage.isPageOpened();
        //softAssert.assertTrue(communityPage.isIconVisible(), "");





        softAssert.assertAll();
    }

}
