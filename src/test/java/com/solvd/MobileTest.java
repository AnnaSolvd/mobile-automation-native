package com.solvd;

import com.solvd.constans.BottomNavigationBarTitle;
import com.solvd.gui.components.BottomNavigationBar;
import com.solvd.gui.pages.common.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class MobileTest extends BaseTest {

    //TODO: problem with edit button on profile page
    @Test(description = "TC-01")
    public void verifyThatUserCanUpdateProfileBio() {
        SoftAssert softAssert = new SoftAssert();

        ProfilePageBase profilePage = initPage(driver, ProfilePageBase.class);
        profilePage.isPageOpened();
        softAssert.assertTrue(profilePage.isCorrectUsernameOnProfilePage(username));

        profilePage.clickEditButton();
        EditProfilePageBase editProfilePage = profilePage.clickEditButton();
        editProfilePage.isPageOpened();
        //editProfilePage.typeAboutField(aboutUserText);
        //editProfilePage.clickSaveButton();

        //boolean isTextOnProfileMatching = profilePage.isCorrectTextInBiographySection(aboutUserText);
        //assertTrue(isTextOnProfileMatching, "Text from about user section don't match text on profile");
        softAssert.assertAll();
    }

    //TODO: work but sometimes is not stable, add wait
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
    public void verifyJoiningCommunityAndYourCommunitiesSection() {
        SoftAssert softAssert = new SoftAssert();

        CommunityPageBase communityPage = initPage(driver, CommunityPageBase.class);
        communityPage.isPageOpened();
        //softAssert.assertTrue(communityPage.isIconVisible(), "");

        communityPage.clickJoinButton();
        boolean isJoinedState = communityPage.hasJoinedState();
        softAssert.assertTrue(isJoinedState, "Button text don't change from join to joined");

        BottomNavigationBar bottomNavigationBar = new BottomNavigationBar(driver);
        bottomNavigationBar.clickMenuButtonByName(BottomNavigationBarTitle.HOME.getTitle());

        softAssert.assertAll();
    }
}
