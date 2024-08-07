package com.solvd.ios;

import com.solvd.reddit.gui.pages.common.HomePageBase;
import com.solvd.swaglabs.gui.components.SwagLabsProduct;
import com.solvd.swaglabs.gui.pages.common.CartPageIOSBase;
import com.solvd.swaglabs.gui.pages.common.HomePageIOSBase;
import com.solvd.swaglabs.gui.pages.common.LoginPageIOSBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class IOSBaseTest implements IAbstractTest, IMobileUtils {

    protected String username;
    protected String password;
    protected String lowestPrice;
    protected String expectedLatitude;
    protected String expectedLongitude;

    protected HomePageIOSBase logInUser() {
        LoginPageIOSBase loginPage = initPage(getDriver(), LoginPageIOSBase.class);
        loginPage.assertPageOpened();
        loginPage.typeInForm(username, password);
        return loginPage.clickLoginButton();
    }

    protected CartPageIOSBase addProductToCart() {
        HomePageIOSBase homePage = logInUser();
        SwagLabsProduct product = homePage.getRandomProduct();
        product.addProductToCart();
        return homePage.clickCartButton();
    }

    @BeforeMethod
    public void setUp() {
        username = R.TESTDATA.get("ios.username");
        password = R.TESTDATA.get("ios.password");
        lowestPrice = R.TESTDATA.get("ios.lowest_price");
        expectedLatitude = R.TESTDATA.get("ios.latitude");
        expectedLongitude = R.TESTDATA.get("ios.longitude");

        startApp(R.CONFIG.get("bundleId"));
    }

    @AfterMethod
    public void tearDown() {
        HomePageIOSBase homePage = initPage(getDriver(), HomePageIOSBase.class);
        homePage.terminateApp(R.CONFIG.get("bundleId"));
        getDriver().quit();
    }
}
