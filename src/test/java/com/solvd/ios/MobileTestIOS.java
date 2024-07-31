package com.solvd.ios;

import com.solvd.android.AndroidBaseTest;
import com.solvd.reddit.constans.BottomNavigationBarTitle;
import com.solvd.reddit.constans.SideMenuTitle;
import com.solvd.reddit.gui.components.*;
import com.solvd.reddit.gui.pages.common.*;
import com.solvd.service.PostService;
import com.solvd.swaglabs.gui.pages.common.LoginPageBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class MobileTestIOS extends AndroidBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(MobileTestIOS.class);

    @Test(description = "TC-01")
    public void verifyLogIn() {
        LoginPageBase profilePage = initPage(getDriver(), LoginPageBase.class);
        profilePage.open();
        profilePage.isPageOpened();
    }

}
