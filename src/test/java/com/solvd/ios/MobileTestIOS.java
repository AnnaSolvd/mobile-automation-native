package com.solvd.ios;

import com.solvd.swaglabs.gui.components.FilterModal;
import com.solvd.swaglabs.gui.components.LeftNavigationSidebar;
import com.solvd.swaglabs.gui.components.SwagLabsProduct;
import com.solvd.swaglabs.gui.pages.common.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.solvd.service.DataGeneratorService.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class MobileTestIOS extends IOSBaseTest {

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
        loginPage.typeInForm(generateRandomData(3), generateRandomData(3));
        loginPage.clickLoginButton();
        boolean isMessagePresent = loginPage.isErrorMessagePresent();
        assertTrue(isMessagePresent, "After invalid login, alert should be visible");
    }


    @Test(description = "TC-03")
    public void verifyLogOut() {
        HomePageIOSBase homePage = logInUser();
        LeftNavigationSidebar leftMenuPage = homePage.clickMenuButton();
        LoginPageIOSBase loginPage = leftMenuPage.clickLogOutButton();
        assertTrue(loginPage.isLogInButtonVisible(), "Login button should be visible after log out");
    }


    @Test(description = "TC-04")
    public void checkProductDetails() {
        HomePageIOSBase homePage = logInUser();
        SwagLabsProduct product = homePage.getRandomProduct();
        String title = product.getTitle();
        String price = product.getPrice();
        ProductPageIOSBase productPage = product.clickProduct();
        boolean isProductTitleMatching = productPage.checkProductTitle(title);
        boolean isProductPriceMatching = productPage.checkProductPrice(price);
        assertTrue(isProductTitleMatching, "Product title doesn't match");
        assertTrue(isProductPriceMatching, "Product price doesn't match");
    }


    @Test(description = "TC-05")
    public void verifyCart() {
        SoftAssert softAssert = new SoftAssert();
        HomePageIOSBase homePage = logInUser();
        SwagLabsProduct product = homePage.getRandomProduct();
        String productTitle = product.getTitle();
        product.addProductToCart();
        softAssert.assertTrue(homePage.isCartButtonVisible(), "Cart button should be visible");
        CartPageIOSBase cartPage = homePage.clickCartButton();
        boolean isPresent = cartPage.isProductPresentInCart(productTitle);
        assertTrue(isPresent, "Product is not present in cart");
        softAssert.assertAll();
    }


    @Test(description = "TC-06")
    public void verifyRemoveProductFromCart() {
        SoftAssert softAssert = new SoftAssert();
        HomePageIOSBase homePage = logInUser();
        SwagLabsProduct product = homePage.getRandomProduct();
        String productTitle = product.getTitle();
        product.addProductToCart();
        softAssert.assertTrue(homePage.isCartButtonVisible(), "Cart button should be visible");
        CartPageIOSBase cartPage = homePage.clickCartButton();

        boolean isPresent = cartPage.isProductPresentInCart(productTitle);
        assertTrue(isPresent, "Product is not present in cart");
        cartPage.removeProductFromCart(productTitle);

        boolean isPresentAfterRemove = cartPage.isProductPresentInCart(productTitle);
        assertFalse(isPresentAfterRemove, "Product is present in cart after removing it");
        softAssert.assertAll();
    }


    @Test(description = "TC-07")
    public void verifyCheckOutForm() {
        CartPageIOSBase cartPage = addProductToCart();
        CheckOutInformationIOSBase checkOutInfoPage = cartPage.clickCheckOutButton();
        checkOutInfoPage.fillFormWithData(generateRandomData(3), generateRandomData(3),
                generateRandomData(3));
        CheckOutOverviewIOSBase checkOutOverviewPage = checkOutInfoPage.clickCheckOutButton();
        boolean isPresent = checkOutOverviewPage.isPageTitlePresent();
        assertTrue(isPresent, "Checkout overview page doesn't open");
    }


    @Test(description = "TC-08")
    public void verifyCheckOverview() {
        CartPageIOSBase cartPage = addProductToCart();
        CheckOutInformationIOSBase checkOutInfoPage = cartPage.clickCheckOutButton();
        checkOutInfoPage.fillFormWithData(generateRandomData(3), generateRandomData(3),
                generateRandomData(3));
        CheckOutOverviewIOSBase checkOutOverviewPage = checkOutInfoPage.clickCheckOutButton();
        boolean isPresent = checkOutOverviewPage.isPageTitlePresent();
        assertTrue(isPresent, "Checkout overview page doesn't open");
        CheckOutCompleteIOSBase checkOutCompletePage = checkOutOverviewPage.clickFinishButton();
        HomePageIOSBase homePage = checkOutCompletePage.clickBackHomeButton();
        homePage.assertPageOpened();
        boolean isCartButtonPresent = homePage.isCartButtonVisible();
        assertTrue(isCartButtonPresent, "Home page doesn't open");
    }


    @Test(description = "TC-09")
    public void verifySortFunctionality() {
        String expectedPrice = "7.99";
        HomePageIOSBase homePage = logInUser();
        FilterModal filterModal = homePage.clickFilterButton();
        filterModal.clickLowToHighFilterButton();
        boolean isMatching = homePage.checkFirstProductPrice(expectedPrice);
        assertTrue(isMatching, "Product price doesn't match lowest price in catalog");
    }


    @Test(description = "TC-10")
    public void verifyShowingGeoLocation() {
        String expectedLatitude = " ";
        String expectedLongitude = " ";

        HomePageIOSBase homePage = logInUser();
        LeftNavigationSidebar leftMenu = homePage.clickMenuButton();
        GeoLocationPageIOSBase geoLocationPage = leftMenu.clickGeoLocationButton();

        boolean isMatchingLatitude = geoLocationPage.checkLatitude(expectedLatitude);
        boolean isMatchingLongitude = geoLocationPage.checkLongitude(expectedLongitude);
        assertTrue(isMatchingLatitude, "Latitude is not equal to location");
        assertTrue(isMatchingLongitude , "Longitude is not equal to location");
    }

}
