package com.solvd.android;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.resources.L10N;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;

import static com.zebrunner.carina.utils.R.CONFIG;

public abstract class AndroidBaseTest implements IAbstractTest {

    private static final Logger logger = LoggerFactory.getLogger(AndroidBaseTest.class);

    protected WebDriver driver;
    protected String username;
    protected String aboutUserText;
    protected String searchTerm;
    protected String publicCommunity;
    protected String privateTestingCommunity;

    //TODO: deeplinks redirect to webview
    protected void openDeepLinkWithIntent(String deepLinkUrl) {
        String command = String.format("adb shell am start -a android.intent.action.VIEW -d \"%s\" com.reddit.frontpage", deepLinkUrl);
        try {
            Runtime.getRuntime().exec(command);
            logger.info("Opened deep link using intent: " + deepLinkUrl);
        } catch (IOException e) {
            logger.error("Failed to execute ADB command for deep link: " + e.getMessage());
        }
    }

    @BeforeClass
    public void setUp() {
        username = R.TESTDATA.get("android.username");
        aboutUserText = R.TESTDATA.get("android.about_text");
        searchTerm = R.TESTDATA.get("android.search_term");
        publicCommunity = R.TESTDATA.get("android.community.public");
        privateTestingCommunity = R.TESTDATA.get("android.community.testing");
    }

    @BeforeMethod
    public void setUpTestMethod(Method method) {
        L10N.setLocale(CONFIG.get("locale"));
        L10N.load();
        driver = getDriver();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

}