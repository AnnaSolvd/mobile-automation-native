package com.solvd;

import com.solvd.gui.pages.common.*;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;

public class MobileSampleTest extends BaseTest {

    @Test(description = "TC-01")
    public void verifySearchFunctionality() {
        //SoftAssert sa = new SoftAssert();
        HomePageBase homePage = initPage(driver, HomePageBase.class);
        homePage.isPageOpened();
        //TODO: soft assert -> homePage.checkIfCorrectSomething()

        SearchPageBase searchPage =  homePage.clickSearchButton();
        searchPage.typeSearchInput(R.TESTDATA.get("search_term"));

        //sa.assertAll();
    }

}
