package com.solvd.ios;

import com.solvd.swaglabs.gui.components.SwagLabsProduct;
import com.solvd.swaglabs.gui.pages.common.CartPageIOSBase;
import com.solvd.swaglabs.gui.pages.common.HomePageIOSBase;
import com.solvd.swaglabs.gui.pages.common.LoginPageIOSBase;
import com.zebrunner.agent.core.registrar.Screenshot;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.invoke.MethodHandles;

public abstract class IOSBaseTest implements IAbstractTest, IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

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

    protected void captureScreenshot(){
        try{
            byte[] screenshotBytes = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            long capturedAtMillis = System.currentTimeMillis();
            Screenshot.upload(screenshotBytes, capturedAtMillis);
        } catch (Exception e) {
                LOGGER.error("Failed to capture or upload screenshot");
        }
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
