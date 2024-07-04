package com.solvd;

import com.solvd.constans.SideMenuTitle;
import com.solvd.gui.components.SideMenu;
import com.solvd.gui.pages.common.HomePageBase;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

import static org.testng.Assert.assertTrue;

public class MobileSampleTest implements IAbstractTest, IMobileUtils {

    @Test()
    public void testStart() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();

        boolean isIconVisible = homePage.isProfileIconVisible();
        assertTrue(isIconVisible, "User should see profile icon on home page");

        SideMenu menu =  homePage.clickProfileIcon();
        boolean isProfileButtonPresent = menu.checkPresenceOfButton(String.valueOf(SideMenuTitle.PROFILE));
        assertTrue(isProfileButtonPresent, "User should see profile button in side menu");
    }

}
