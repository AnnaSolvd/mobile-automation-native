package com.solvd;

import com.solvd.constans.BottomNavigationBarTitle;
import com.solvd.gui.components.BottomNavigationBar;
import com.solvd.gui.pages.common.CommunityPageBase;
import com.solvd.gui.pages.common.CreatePostPageBase;
import com.solvd.gui.pages.common.EditProfilePageBase;
import com.solvd.gui.pages.common.ProfilePageBase;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MobileTest extends BaseTest {

    @Test(description = "TC-01")
    public void verifyThatUserCanUpdateProfileBio() {
        //SoftAssert sa = new SoftAssert();
        ProfilePageBase profilePage = initPage(driver, ProfilePageBase.class);
        profilePage.isPageOpened();
        //TODO: soft assert -> profilePage.checkIfCorrectUsername();

        profilePage.clickEditButton();
        EditProfilePageBase editProfilePage = profilePage.clickEditButton();

        editProfilePage.typeAboutField(R.TESTDATA.get("user.biography_text"));
        editProfilePage.clickSaveButton();

        //TODO: don't work
//        boolean isTextOnProfileMatching = profilePage.isCorrectTextInBiographySection(
//                R.TESTDATA.get("user.biography_text"));
//        assertTrue(isTextOnProfileMatching, "");

        //sa.assertAll();
    }

    @Test(description = "TC-02")
    public void verifyUserPostingOnCommunity() {
        WebDriver driver = getDriver();
        driver.get(R.TESTDATA.get("deeplink.url.community"));
        CommunityPageBase communityPage = initPage(driver, CommunityPageBase.class);

        boolean isElementPresent = communityPage.isCommunityTitlePresent();
        assertTrue(isElementPresent, "Community title is not present on screen");
        BottomNavigationBar bottomNavigationBar = new BottomNavigationBar(getDriver());

        CreatePostPageBase createPostPage = bottomNavigationBar
                .clickMenuButtonByName(BottomNavigationBarTitle.CREATE.getTitle());

        assertTrue(createPostPage.checkPostBodyButtonVisibility(), "Post body  is not visible");
        assertTrue(createPostPage.checkPostTitleButtonVisibility(), "Post title is not visible");

        //TODO: don't work
//        createPostPage.typePostTitle("Title title");
//        createPostPage.typePostBody("body body body");
//        createPostPage.clickPostButton();
    }
}
