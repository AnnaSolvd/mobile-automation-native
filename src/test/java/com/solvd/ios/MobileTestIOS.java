package com.solvd.ios;

import com.solvd.swaglabs.gui.pages.common.LeftMenuPageIOSBase;
import com.solvd.swaglabs.gui.components.SwagLabsProduct;
import com.solvd.swaglabs.gui.pages.common.CartPageIOSBase;
import com.solvd.swaglabs.gui.pages.common.HomePageIOSBase;
import com.solvd.swaglabs.gui.pages.common.LoginPageIOSBase;
import com.solvd.swaglabs.gui.pages.common.ProductPageIOSBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.solvd.service.DataGeneratorService.*;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class MobileTestIOS extends IOSBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(MobileTestIOS.class);

    @Test(description = "TC-01")
    public void verifySuccessfulLogIn() {
        LoginPageIOSBase loginPage = initPage(getDriver(), LoginPageIOSBase.class);
        loginPage.assertPageOpened();
        loginPage.typeInForm(username, password);
        HomePageIOSBase homePage = loginPage.clickLoginButton();
        boolean isCartPresent = homePage.isCartButtonVisible();
        assertTrue(isCartPresent, "After successful login, cart button should be present");
    }

    @Test(description = "TC-02")
    public void verifyInvalidLogIn() {
        LoginPageIOSBase loginPage = initPage(getDriver(), LoginPageIOSBase.class);
        loginPage.assertPageOpened();
        loginPage.typeInForm(generateUserData(3), generateUserData(3));
        loginPage.clickLoginButton();
        boolean isMessagePresent = loginPage.isErrorMessagePresent();
        assertTrue(isMessagePresent, "After invalid login, alert should be visible");
    }

    @Test(description = "TC-03")
    public void verifyLogOut() {
        HomePageIOSBase homePage = logInUser();
        LeftMenuPageIOSBase leftMenuPage = homePage.clickMenuButton();
        LoginPageIOSBase loginPage = leftMenuPage.clickLogOutButton();
        assertTrue(loginPage.isLogInButtonVisible(), "Login button should be visible after log out");
    }

    @Test(description = "TC-04")
    public void checkProductDetails() {
        HomePageIOSBase homePage = logInUser();

        SwagLabsProduct product = homePage.getRandomProduct();
        String title = product.getTitle();
        String price = product.getPrice();
        logger.info("Product details from home page: {}, {}", title, price);

        ProductPageIOSBase productPage = homePage.clickRandomProduct();
        String productTitle = productPage.getProductTitle();
        String productPrice = productPage.getProductPrice();
        logger.info("Product details from product page: {}, {}", productTitle, productPrice);

        assertEquals(productTitle, title, "Product title doesn't match");
        assertEquals(productPrice, price, "Product price doesn't match");
    }

    @Test(description = "TC-05")
    public void verifyCart() {
        SoftAssert softAssert = new SoftAssert();

        HomePageIOSBase homePage = logInUser();
        SwagLabsProduct product = homePage.getRandomProduct();
        String title = product.getTitle();
        product.addProductToCart();

        softAssert.assertTrue(homePage.isCartButtonVisible(), "Cart button should be visible");
        CartPageIOSBase cartPage = homePage.clickCartButton();

        softAssert.assertAll();
    }

    @Test(description = "TC-06")
    public void verifyCheckOut() {

    }
//
//    @Test(description = "TC-07")
//    public void verifyCheckOut2() {
//    }
//
//    @Test(description = "TC-08")
//    public void verifyCheckOut3() {
//    }
//
//    @Test(description = "TC-09")
//    public void verifyCheckOut4() {
//    }
//
//    @Test(description = "TC-10")
//    public void verifyCheckOut() {
//    }

}
