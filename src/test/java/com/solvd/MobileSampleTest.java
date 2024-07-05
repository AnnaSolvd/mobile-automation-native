package com.solvd;

import com.solvd.constans.SideMenuTitle;
import com.solvd.gui.components.SideMenu;
import com.solvd.gui.pages.common.EditProfilePageBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.ProfilePageBase;
import com.solvd.gui.pages.common.SearchPageBase;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

import static org.testng.Assert.assertTrue;

public class MobileSampleTest implements IAbstractTest, IMobileUtils {

//    @Test(description = "TC-01")
//    public void verifyThatUserCanUpdateProfileBio() {
//        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
//        homePage.open();
//
//        boolean isIconVisible = homePage.isProfileIconVisible();
//        assertTrue(isIconVisible, "Profile icon should be present in home page");
//
//        SideMenu menu =  homePage.clickProfileIcon();
//        boolean isButtonPresent =  menu.checkPresenceOfButton(SideMenuTitle.PROFILE.getTitle());
//        assertTrue(isButtonPresent, "Profile button should be present in side menu");
//
//        ProfilePageBase profilePage =  menu.clickMenuButtonByName(SideMenuTitle.PROFILE.getTitle());
//        //assertTrue(, "Correct username should be present on profile page");
//
//        EditProfilePageBase editProfilePage = profilePage.clickEditButton();
//        //assertTrue(, "Edit profile text should be present on page");
//        editProfilePage.typeToAboutYouField(R.TESTDATA.get("user.biography_text"));
//
//        editProfilePage.clickSaveButton();
//        //profilePage.isCorrectTextInBiographySection(R.TESTDATA.get("user.biography_text"));
//    }

    @Test(description = "TC-02")
    public void verifyThatUserCanSearchFunctionality() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();

//        SearchPageBase searchPage = homePage.clickSearchButton();
//        searchPage.typeSearchInput(R.TESTDATA.get("search_text"));
        homePage.clickOnFirstPost();
    }


}
