package com.solvd;

import com.solvd.constans.BottomNavigationBarTitle;
import com.solvd.gui.components.BottomNavigationBar;
import com.solvd.gui.pages.android.HomePage;
import com.solvd.gui.pages.common.CommunityPageBase;
import com.solvd.gui.pages.common.CreatePostPageBase;
import com.solvd.gui.pages.common.EditProfilePageBase;
import com.solvd.gui.pages.common.ProfilePageBase;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

import static org.testng.Assert.assertTrue;


public class MobileSampleTest implements IAbstractTest, IMobileUtils {

    private static final Logger logger = LoggerFactory.getLogger(MobileSampleTest.class);
//
//    @Test(description = "TC-01")
//    public void verifyThatUserCanUpdateProfileBio() {
//        String deeplink = R.TESTDATA.get("deeplink.url.profile_page");
//        String  username = R.TESTDATA.get("user.username");
//        String url = deeplink + username;
//
//        WebDriver driver = getDriver(url);
//        driver.get(url);
//        ProfilePageBase profilePage = initPage(driver, ProfilePageBase.class);
//        //profilePage.checkIfCorrectUsername();
//
//        profilePage.clickEditButton();
//        EditProfilePageBase editProfilePage = profilePage.clickEditButton();
//        editProfilePage.typeAboutField(R.TESTDATA.get("user.biography_text"));
//        editProfilePage.clickSaveButton();
//
//        //TODO: don't work
////        boolean isTextOnProfileMatching = profilePage.isCorrectTextInBiographySection(
////                R.TESTDATA.get("user.biography_text"));
////        assertTrue(isTextOnProfileMatching, "");
//    }

    @Test(description = "TC-02")
    public void verifyUserPostingOnCommunity() {
        WebDriver driver = getDriver();
        driver.get(R.TESTDATA.get("deeplink.url.community"));
        CommunityPageBase communityPage = initPage(driver, CommunityPageBase.class);

        boolean isElementPresent = communityPage.isCommunityTitlePresent();
        assertTrue(isElementPresent, "Community title is not present on screen");
        BottomNavigationBar bottomNavigationBar = new BottomNavigationBar(getDriver());

        CreatePostPageBase createPostPageBase = bottomNavigationBar
                .clickMenuButtonByName(BottomNavigationBarTitle.CREATE.getTitle());
        createPostPageBase.typePostTitle();
        createPostPageBase.typePostBody();
        createPostPageBase.clickPostButton();
    }

}
