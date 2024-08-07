package com.solvd.android;

import com.solvd.reddit.constans.BottomNavigationBarTitle;
import com.solvd.reddit.constans.SideMenuTitle;
import com.solvd.reddit.gui.components.*;
import com.solvd.reddit.gui.pages.common.*;
import com.solvd.service.DataGeneratorService;
import com.zebrunner.carina.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.solvd.service.DataGeneratorService.generateRandomData;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class MobileTestAndroid extends AndroidBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(MobileTestAndroid.class);

    @Test(description = "TCA-01 - Verify user can update the about you section on their profile")
    public void verifyThatUserCanUpdateProfileBio() {
        SoftAssert softAssert = new SoftAssert();
        openDeepLinkWithIntent(R.TESTDATA.get("android.profile"));

        ProfilePageBase profilePage = initPage(getDriver(), ProfilePageBase.class);
        profilePage.assertPageOpened();
        softAssert.assertTrue(profilePage.isCorrectUsernameOnProfilePage(username));

        EditProfilePageBase editProfilePage = profilePage.clickEditButton();
        editProfilePage.assertPageOpened();

        String bioText = DataGeneratorService.generateRandomData(10);
        editProfilePage.typeAboutField(bioText);
        editProfilePage.clickSaveButton();

        boolean isTextOnProfileMatching = profilePage.isCorrectTextInBiographySection(bioText);
        assertTrue(isTextOnProfileMatching, "Text from about user section don't match text on profile");
        softAssert.assertAll();
    }


    @Test(description = "TC-02")
    public void verifyUserPostingOnCommunity() {
        SoftAssert softAssert = new SoftAssert();
        openDeepLinkWithIntent(R.TESTDATA.get("android.community.testing"));
        CommunityPageBase communityPage = initPage(getDriver(), CommunityPageBase.class);
        communityPage.assertPageOpened();

        boolean isElementPresent = communityPage.isCommunityTitlePresent();
        softAssert.assertTrue(isElementPresent, "Community title is not present on screen");
        BottomNavigationBar bottomNavigationBar = new BottomNavigationBar(getDriver());

        CreatePostPageBase createPostPage = bottomNavigationBar
                .clickMenuButtonByName(BottomNavigationBarTitle.CREATE.getTitle());

        softAssert.assertTrue(createPostPage.checkPostBodyButtonVisibility(), "Post body is not visible");
        softAssert.assertTrue(createPostPage.checkPostTitleButtonVisibility(), "Post title is not visible");

        createPostPage.typePostTitle(generateRandomData(8));
        createPostPage.typePostBody(generateRandomData(20));
        createPostPage.clickPostButton();
        communityPage.open();

        /*TODO: problem with delay in adding post
            1. click go back
            2. check first post title and body */
        softAssert.assertAll();
    }


    @Test(description = "TC-03")
    public void verifySearchFunctionality() {
        SoftAssert softAssert = new SoftAssert();

        openDeepLinkWithIntent(R.TESTDATA.get("android.home"));
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.assertPageOpened();
        softAssert.assertTrue(homePage.isRedditIconVisible(), "Reddit icon is not visible");

        SearchPageBase searchPage = homePage.clickSearchButton();
        SearchResultPageBase searchResultPage = searchPage.typeSearchInput(searchTerm);

        boolean isSearchTermTextPresent = searchResultPage.isTermPresentInSearchPostsList(searchTerm);
        assertTrue(isSearchTermTextPresent, "Search term is not present in post results");
        softAssert.assertAll();
    }


    @Test(description = "TC-04")
    public void verifyJoiningCommunity() {
        SoftAssert softAssert = new SoftAssert();
        openDeepLinkWithIntent(R.TESTDATA.get("android.community.public"));
        CommunityPageBase communityPage = initPage(getDriver(), CommunityPageBase.class);
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


    @Test(description = "TCA-05 - Verify user can see recently visited communities")
    public void verifyRecentlyVisitedSection() {
        SoftAssert softAssert = new SoftAssert();

        openDeepLinkWithIntent(R.TESTDATA.get("android.home"));
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.assertPageOpened();

        CommunityPageBase communityPage = homePage.getRandomPost().clickPostCommunity();
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
    public void verifySavedPostSection() {
        SoftAssert softAssert = new SoftAssert();
        openDeepLinkWithIntent(R.TESTDATA.get("android.home"));
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.assertPageOpened();

        PostDetailPageBase postDetailPage = homePage.getRandomPost().clickPostTitle();
        String postTitle = postDetailPage.getPostTitle();
        DropDownMenu menu = postDetailPage.clickDropDownMenuButton();
        menu.clickSaveButton();

        //TODO: Decrease time of regression: Remove steps and go straight to saved post page
        postDetailPage.clickReturnButton();
        ProfileNavigationSidebar sidebar = homePage.clickProfileIcon();

        SavedPageBase savedPostPage = sidebar.clickButtonByName(SideMenuTitle.SAVED.getTitle(), SavedPageBase.class);
        boolean isPresent = savedPostPage.isPostTitlePresent(postTitle);
        assertTrue(isPresent, "Post title from detail page and saved page don't match");
        softAssert.assertAll();
    }


    @Test(description = "TC-07")
    public void verifyHistorySection(){
        SoftAssert softAssert = new SoftAssert();
        openDeepLinkWithIntent(R.TESTDATA.get("android.home"));
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.assertPageOpened();

        PostDetailPageBase postDetailPage = homePage.getRandomPost().clickPostTitle();
        String postTitle = postDetailPage.getPostTitle();

        //TODO: Decrease time of regression: Remove steps and go straight to saved post page?
        postDetailPage.clickReturnButton();
        ProfileNavigationSidebar sidebar = homePage.clickProfileIcon();

        HistoryPageBase historyPage = sidebar.clickButtonByName(SideMenuTitle.HISTORY.getTitle(), HistoryPageBase.class);
        //boolean isPresent = historyPage.isPostTitlePresent(postTitle);
        //assertTrue(isPresent, "Post title from detail page and saved page don't match");
        softAssert.assertAll();
    }


    @Test(description = "TC-08")
    public void verifyPost() {
        SoftAssert softAssert = new SoftAssert();
        openDeepLinkWithIntent(R.TESTDATA.get("android.home"));
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.assertPageOpened();

        Post randomPost = homePage.getRandomPost();
        String title = randomPost.getTitle();
        String community = randomPost.getCommunity();
        logger.info("Post details from home page: {}, {}", title, community);

        PostDetailPageBase postDetailPage = randomPost.clickPostTitle();
        String postTitle = postDetailPage.getPostTitle();
        String postCommunity = postDetailPage.getPostCommunity();
        logger.info("Post details from post detail page: {}, {}", postTitle, postCommunity);

        assertEquals(postTitle, title, "Post title doesn't match");
        assertEquals(postCommunity, community, "Post community doesn't match");

        softAssert.assertAll();
    }


    @Test(description = "TCA-09 - Verify comments are visible on the post detail page")
    public void testVisibilityOfComments() {
        SoftAssert softAssert = new SoftAssert();
        openDeepLinkWithIntent(R.TESTDATA.get("android.home"));
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.assertPageOpened();
        PostDetailPageBase postDetailPage = homePage.getRandomPost().clickPostTitle();
        boolean areCommentsPresent = postDetailPage.areCommentsPresent();
        assertTrue(areCommentsPresent, "Comments should be visible");
        softAssert.assertAll();
    }


    //TC-10 - implement i18n test in French language

}
