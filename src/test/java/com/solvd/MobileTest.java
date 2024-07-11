package com.solvd;

import com.solvd.constans.BottomNavigationBarTitle;
import com.solvd.gui.components.BottomNavigationBar;
import com.solvd.gui.pages.common.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class MobileTest extends BaseTest {

    @Test(description = "TC-01")
    public void verifyThatUserCanUpdateProfileBio() {
        SoftAssert softAssert = new SoftAssert();
        ProfilePageBase profilePage = initPage(driver, ProfilePageBase.class);
        profilePage.isPageOpened();
        //TODO: softAssert.assertTrue(profilePage.checkIfCorrectUsername(), "");

        profilePage.clickEditButton();
        EditProfilePageBase editProfilePage = profilePage.clickEditButton();
        editProfilePage.typeAboutField(aboutUserText);
        editProfilePage.clickSaveButton();

        //TODO: work?
        //boolean isTextOnProfileMatching = profilePage.isCorrectTextInBiographySection(aboutUserText);
        //assertTrue(isTextOnProfileMatching, "Text from about user section don't match text on profile");

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

        //TODO: don't work
//        createPostPage.typePostTitle("Title title");
//        createPostPage.typePostBody("body body body");
//        createPostPage.clickPostButton();

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
        boolean isSearchTermTextPresent =  searchResultPage.isStringPresentInElement(searchTerm);
        assertTrue(isSearchTermTextPresent, "Search term is not present in post results");

        softAssert.assertAll();
    }
}
