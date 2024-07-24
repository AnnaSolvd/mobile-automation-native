package com.solvd;

import com.solvd.gui.pages.common.*;
import org.testng.annotations.Test;

public class MobileSampleTest extends BaseTest {

    @Test(description = "TC-04")
    public void verifyJoiningCommunity() {
        CommunityPageBase communityPage = initPage(driver, CommunityPageBase.class);
        communityPage.isPageOpened();
        communityPage.clickJoinButton();
    }

}
