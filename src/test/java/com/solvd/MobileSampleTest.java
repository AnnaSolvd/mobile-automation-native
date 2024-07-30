package com.solvd;

import com.solvd.gui.components.Post;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.PostDetailPageBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertEquals;

public class MobileSampleTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(MobileSampleTest.class);

    @Test(description = "TC-07")
    public void verifyPost() {
        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = initPage(driver, HomePageBase.class);
        homePage.isPageOpened();
        softAssert.assertTrue(homePage.isRedditIconVisible(), "Reddit icon is not visible");

        Post randomPost = homePage.getRandomPost();
        String title = randomPost.getTitle();
        String community = randomPost.getCommunity();
        logger.info("Post details from home page: {}, {} \n", title, community);

        PostDetailPageBase postDetailPage = homePage.clickRandomPostTitle();
        String postTitle = postDetailPage.getPostTitle();
        String postCommunity = postDetailPage.getPostCommunity();
        logger.info("Post details from post detail page: {}, {} \n", postTitle, postCommunity);

        assertEquals(postTitle, title, "Post title doesn't match");
        assertEquals(postCommunity, community, "Post community doesn't match");

        softAssert.assertAll();
    }

}
