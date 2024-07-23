package com.solvd;

import com.solvd.constans.BottomNavigationBarTitle;
import com.solvd.gui.components.BottomNavigationBar;
import com.solvd.gui.pages.common.*;
import com.solvd.service.PostService;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class MobileSampleTest extends BaseTest {

    @Test(description = "TC-02")
    public void verifyUserPostingOnCommunity() {
        SoftAssert softAssert = new SoftAssert();
        CommunityPageBase communityPage = initPage(driver, CommunityPageBase.class);

        boolean isElementPresent = communityPage.isCommunityTitlePresent();
        softAssert.assertTrue(isElementPresent, "Community title is not present on screen");
        BottomNavigationBar bottomNavigationBar = new BottomNavigationBar(getDriver());

        CreatePostPageBase createPostPage = bottomNavigationBar
                .clickMenuButtonByName(BottomNavigationBarTitle.CREATE.getTitle());

        assertTrue(createPostPage.checkPostBodyButtonVisibility(), "Post body is not visible");
        assertTrue(createPostPage.checkPostTitleButtonVisibility(), "Post title is not visible");

        createPostPage.typePostTitle(PostService.generateRandomPostTitle());
        createPostPage.typePostBody(PostService.generateRandomPostBody());
        createPostPage.clickPostButton();

        //TODO:
        // click go back
        // check first post title and body

        softAssert.assertAll();
    }

}
