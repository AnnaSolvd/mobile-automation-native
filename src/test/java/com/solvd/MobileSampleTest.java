package com.solvd;

import mobile.gui.pages.common.HomePageBase;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

public class MobileSampleTest implements IAbstractTest, IMobileUtils {

    @Test()
    public void testStart() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
    }

}
