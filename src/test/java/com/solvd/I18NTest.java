package com.solvd;

import com.solvd.gui.pages.common.CommunityPageBase;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import com.zebrunner.carina.utils.resources.L10N;

import static com.zebrunner.carina.utils.R.CONFIG;

public class I18NTest extends BaseTest {

    @Test(description = "TC-05")
    public void verifyJoiningCommunity() {
        CommunityPageBase communityPage = initPage(driver, CommunityPageBase.class);
        communityPage.isPageOpened();
        communityPage.clickJoinButton();

        L10N.flush();
    }
}
