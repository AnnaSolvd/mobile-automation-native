package com.solvd.ios;

import com.solvd.swaglabs.gui.components.SwagLabsProduct;
import com.solvd.swaglabs.gui.pages.common.CartPageIOSBase;
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

    public HomePageIOSBase logInUser() {
        LoginPageIOSBase loginPage = initPage(getDriver(), LoginPageIOSBase.class);
        loginPage.assertPageOpened();
        loginPage.typeInForm(username, password);
        return loginPage.clickLoginButton();
    }

    public CartPageIOSBase addProductToCart() {
        HomePageIOSBase homePage = logInUser();
        SwagLabsProduct product = homePage.getRandomProduct();
        product.addProductToCart();
        return homePage.clickCartButton();
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
