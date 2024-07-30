package com.solvd;

import com.solvd.constans.BottomNavigationBarTitle;
import com.solvd.constans.SideMenuTitle;
import com.solvd.gui.components.*;
import com.solvd.gui.pages.common.*;
import com.solvd.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class MobileTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(MobileTest.class);

    @Test(description = "TC-01")
    public void verifyThatUserCanUpdateProfileBio() {
        SoftAssert softAssert = new SoftAssert();

        ProfilePageBase profilePage = initPage(driver, ProfilePageBase.class);
        profilePage.isPageOpened();
        softAssert.assertTrue(profilePage.isCorrectUsernameOnProfilePage(username));

        EditProfilePageBase editProfilePage = profilePage.clickEditButton();
        editProfilePage.isPageOpened();
        editProfilePage.typeAboutField(aboutUserText);
        editProfilePage.clickSaveButton();

        boolean isTextOnProfileMatching = profilePage.isCorrectTextInBiographySection(aboutUserText);
        assertTrue(isTextOnProfileMatching, "Text from about user section don't match text on profile");
        softAssert.assertAll();
    }


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

        /*TODO: problem with delay in adding post
            1. click go back
            2. check first post title and body */
        softAssert.assertAll();
    }


    @Test(description = "TC-03")
    public void verifySearchFunctionality() {
        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = initPage(driver, HomePageBase.class);
        homePage.isPageOpened();
        softAssert.assertTrue(homePage.isRedditIconVisible(), "Reddit icon is not visible on page");

        SearchPageBase searchPage = homePage.clickSearchButton();
        SearchResultPageBase searchResultPage = searchPage.typeSearchInput(searchTerm);

        boolean isSearchTermTextPresent =  searchResultPage.isTermPresentInSearchPostsList(searchTerm);
        assertTrue(isSearchTermTextPresent, "Search term is not present in post results");

        softAssert.assertAll();
    }

    @Test(description = "TC-04")
    public void verifyJoiningCommunity() {
        SoftAssert softAssert = new SoftAssert();

        CommunityPageBase communityPage = initPage(driver, CommunityPageBase.class);
        communityPage.isPageOpened();
        softAssert.assertTrue(communityPage.isCommunityTitlePresent(), "Community title is not present");

        boolean isJoinedState = communityPage.hasJoinedState();
        if(!isJoinedState){
            communityPage.clickJoinButton();
            isJoinedState = communityPage.hasJoinedState();
            assertTrue(isJoinedState, "Button text don't change from join to joined");
        } else {
            communityPage.clickJoinButton();
            boolean isUnJoinedState = communityPage.hasJoinedState();
            assertFalse(isUnJoinedState, "Button text should change from joined to join");
        }
        softAssert.assertAll();
    }

    @Test(description = "TC-05")
    public void verifyRecentlyVisitedSection() {
        SoftAssert softAssert = new SoftAssert();
        HomePageBase homePage = initPage(driver, HomePageBase.class);
        homePage.isPageOpened();
        assertTrue(homePage.isRedditIconVisible(), "Reddit icon is not visible");

        CommunityPageBase communityPage = homePage.clickRandomPostCommunity();
        String communityTitle = communityPage.getCommunityTitle();
        softAssert.assertTrue(communityPage.isCommunityTitlePresent(), "Community title is not present");

        communityPage.clickReturnButton();
        LeftNavigationSidebar navigationSidebar = homePage.clickLeftNavigationBar();
        navigationSidebar.clickSeeAllButton();
        assertTrue(navigationSidebar.checkPresenceOfCommunity(communityTitle),
                "The recently clicked community should be present in Recently Visited section");
        softAssert.assertAll();
    }

    @Test(description = "TC-06")
    public void verifySavedPostsSection() {
        SoftAssert softAssert = new SoftAssert();
        HomePageBase homePage = initPage(driver, HomePageBase.class);
        homePage.isPageOpened();
        softAssert.assertTrue(homePage.isRedditIconVisible(), "Reddit icon is not visible");

        PostDetailPageBase postDetailPage = homePage.clickRandomPostTitle();
        //TODO: assert that something is visible on site
        String postTitle = postDetailPage.getPostTitle();

        DropDownMenu menu = postDetailPage.clickDropDownMenuButton();
        menu.clickSaveButton();

        //TODO: Decrease time of regression: Remove steps and go straight to saved post page?
        postDetailPage.clickReturnButton();
        softAssert.assertTrue(homePage.isRedditIconVisible(),
                "Reddit icon is not visible after return from post page");
        ProfileNavigationSidebar sidebar = homePage.clickProfileIcon();
        assertTrue(sidebar.checkPresenceOfButton(SideMenuTitle.SAVED.getTitle()),
                "Saved button is not visible");

        //SavedPostPageBase savedPostPage = sidebar.clickMenuButtonByName(SideMenuTitle.SAVED.getTitle());
        /*TODO:
            1. SavedPostPageBase savedPostPage = sidebar.clickMenuButtonByName(SideMenuTitle.SAVED.getTitle());
            2. String savedPostTitle =  savedPostPage.getFirstSavedPostTitle();
            3. assertEquals(savedPostTitle, postTitle);
        */
        softAssert.assertAll();
    }

    @Test(description = "TC-07")
    public void verifyHistorySection(){

    }


    @Test(description = "TC-08")
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

    @Test(description = "TC-09")
    public void testVisibilityOfComments() {
        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = initPage(driver, HomePageBase.class);
        homePage.isPageOpened();
        softAssert.assertTrue(homePage.isRedditIconVisible(), "Reddit icon is not visible");

        PostDetailPageBase postDetailPage = homePage.clickRandomPostTitle();
        boolean areCommentsPresent = postDetailPage.areCommentsPresent();
        assertTrue(areCommentsPresent, "Comments should be visible");

        softAssert.assertAll();
    }

    //TC-10 - implement i18n test in French language

}
