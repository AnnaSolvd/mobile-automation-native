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

    @Test(description = "TC-06")
    public void verifySavedPostsSection() {
        SoftAssert softAssert = new SoftAssert();
        HomePageBase homePage = initPage(driver, HomePageBase.class);
        homePage.isPageOpened();
        assertTrue(homePage.isRedditIconVisible(), "Reddit icon is not visible");

        PostDetailPageBase postDetailPage = homePage.cli


        softAssert.assertAll();
    }

}
