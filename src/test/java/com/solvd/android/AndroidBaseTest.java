package com.solvd.android;

import com.solvd.reddit.gui.pages.common.HomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.resources.L10N;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.lang.reflect.Method;

import static com.zebrunner.carina.utils.R.CONFIG;

public abstract class AndroidBaseTest implements IAbstractTest {

    private static final Logger logger = LoggerFactory.getLogger(AndroidBaseTest.class);

    protected String username;

    protected String searchTerm;

    protected void openDeepLinkWithIntent(String deepLinkUrl) {
        logger.info("Deeplink: {}", deepLinkUrl);
        String command = String.format("adb shell am start -a android.intent.action.VIEW -d \"%s\" com.reddit.frontpage", deepLinkUrl);
        try {
            Runtime.getRuntime().exec(command);
            logger.info("Opened deep link using intent: " + deepLinkUrl);
        } catch (IOException e) {
            logger.error("Failed to execute ADB command for deep link: " + e.getMessage());
        }
    }

//    protected HomePageBase getHomePage() {
//        SoftAssert softAssert = new SoftAssert();
//        openDeepLinkWithIntent(R.TESTDATA.get("android.home"));
//        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
//        homePage.assertPageOpened();
//        softAssert.assertTrue(homePage.isRedditIconVisible(), "Reddit icon is not visible");
//        softAssert.assertAll();
//        return homePage;
//    }

    @BeforeClass
    public void setUp() {
        username = R.TESTDATA.get("android.username");
        searchTerm = R.TESTDATA.get("android.search_term");
    }

    @BeforeMethod
    public void setUpTestMethod(Method method) {
        L10N.setLocale(CONFIG.get("locale"));
        L10N.load();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

}