package com.solvd.ios;

import com.solvd.swaglabs.gui.pages.common.HomePageIOSBase;
import com.solvd.swaglabs.gui.pages.common.LoginPageIOSBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public abstract class IOSBaseTest implements IAbstractTest {

    protected String username;
    protected String password;

    protected HomePageIOSBase logInUser() {
        SoftAssert softAssert = new SoftAssert();
        LoginPageIOSBase loginPage = initPage(getDriver(), LoginPageIOSBase.class);
        loginPage.assertPageOpened();
        loginPage.typeInForm(username, password);

        HomePageIOSBase homePage = loginPage.clickLoginButton();
        boolean isCartPresent = homePage.isCartButtonVisible();
        softAssert.assertTrue(isCartPresent, "After successful login, cart button should be present");
        softAssert.assertAll();

        return homePage;
    }

    @BeforeClass
    public void setUp() {
        username = R.TESTDATA.get("ios.username");
        password = R.TESTDATA.get("ios.password");
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
}
