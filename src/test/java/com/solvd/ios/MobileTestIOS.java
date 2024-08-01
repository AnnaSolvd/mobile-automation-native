package com.solvd.ios;

import com.solvd.reddit.gui.components.Post;
import com.solvd.reddit.gui.pages.common.PostDetailPageBase;
import com.solvd.swaglabs.gui.components.SwagLabsProduct;
import com.solvd.swaglabs.gui.pages.common.HomePageIOSBase;
import com.solvd.swaglabs.gui.pages.common.LoginPageIOSBase;
import com.solvd.swaglabs.gui.pages.common.ProductPageIOSBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.solvd.service.DataGeneratorService.generateRandomUser;
import static org.testng.Assert.assertFalse;
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
        boolean isCartPresent = homePage.isCartButtonPresent();
        assertTrue(isCartPresent, "After successful login, cart button should be present");
    }

    @Test(description = "TC-02")
    public void verifyInvalidLogIn() {
        LoginPageIOSBase loginPage = initPage(getDriver(), LoginPageIOSBase.class);
        loginPage.assertPageOpened();
        loginPage.typeInForm(generateRandomUser(3), generateRandomUser(3));
        boolean isAlertPresent = loginPage.isAlertPresent();
        assertTrue(isAlertPresent, "After invalid login, alert should be visible");
    }

    @Test(description = "TC-03")
    public void checkProductDetails() {
        //TODO: Move to another method
        SoftAssert softAssert = new SoftAssert();
        LoginPageIOSBase loginPage = initPage(getDriver(), LoginPageIOSBase.class);
        loginPage.assertPageOpened();
        loginPage.typeInForm(username, password);
        HomePageIOSBase homePage = loginPage.clickLoginButton();
        boolean isCartPresent = homePage.isCartButtonPresent();
        softAssert.assertTrue(isCartPresent, "After successful login, cart button should be present");
        //------------------------------------------------------
        SwagLabsProduct product = homePage.getRandomProduct();
        String title = product.getTitle();
        String price = product.getPrice();
        logger.info("Product details from home page: {}, {}", title, price);

        ProductPageIOSBase productPage = homePage.clickRandomProduct();
        String productTitle = productPage.getProductTitle();
        String productPrice = productPage.getProductPrice();
        logger.info("Post details from post detail page: {}, {}", productTitle, productPrice);

        assertEquals(productTitle, title, "Product title doesn't match");
        assertEquals(productPrice, price, "Product price doesn't match");

        //------------------------------------------------------
        softAssert.assertAll();
        //------------------------------------------------------
    }

    @Test(description = "TC-04")
    public void verifyCart() {
        //TODO: Move to another method
        SoftAssert softAssert = new SoftAssert();
        LoginPageIOSBase loginPage = initPage(getDriver(), LoginPageIOSBase.class);
        loginPage.assertPageOpened();
        loginPage.typeInForm(username, password);
        HomePageIOSBase homePage = loginPage.clickLoginButton();
        boolean isCartPresent = homePage.isCartButtonPresent();
        softAssert.assertTrue(isCartPresent, "After successful login, cart button should be present");
        //------------------------------------------------------


        //------------------------------------------------------
        softAssert.assertAll();
        //------------------------------------------------------
    }


}
