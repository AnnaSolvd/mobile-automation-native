package com.solvd;

import com.solvd.constans.SideMenuTitle;
import com.solvd.gui.components.DropDownMenu;
import com.solvd.gui.components.LeftNavigationSidebar;
import com.solvd.gui.components.ProfileNavigationSidebar;
import com.solvd.gui.pages.common.*;
import com.zebrunner.carina.utils.resources.L10N;
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

        PostDetailPageBase postDetailPage = homePage.clickRandomPostTitle();
        //TODO: assert that something is visible on site

        DropDownMenu menu =  postDetailPage.clickDropDownMenuButton();
        menu.clickSaveButton();
        postDetailPage.clickReturnButton();
        assertTrue(homePage.isRedditIconVisible(), "Reddit icon is not visible after return from post page");

        ProfileNavigationSidebar sidebar = homePage.clickProfileIcon();
        assertTrue(sidebar.checkPresenceOfButton(SideMenuTitle.SAVED.getTitle()), "Saved button is not visible");
        sidebar.clickMenuButtonByName(SideMenuTitle.SAVED.getTitle());


        softAssert.assertAll();
    }

}
