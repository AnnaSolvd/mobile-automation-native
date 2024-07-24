package com.solvd;

import com.solvd.gui.pages.common.*;
import com.zebrunner.carina.utils.resources.L10N;
import org.testng.annotations.Test;

public class MobileSampleTest extends BaseTest {

    @Test(description = "TC-05")
    public void verifyJoiningCommunity() {
        L10N.setLocale("en_US");
        L10N.load();

        CommunityPageBase communityPage = initPage(driver, CommunityPageBase.class);
        communityPage.open();

        communityPage.isPageOpened();
        communityPage.clickJoinButton();
    }

}
