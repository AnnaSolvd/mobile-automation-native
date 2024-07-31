package com.solvd.android;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.resources.L10N;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

import static com.zebrunner.carina.utils.R.CONFIG;

public abstract class AndroidBaseTest implements IAbstractTest {

    protected WebDriver driver;
    protected String username;
    protected String aboutUserText;
    protected String searchTerm;
    protected String publicCommunity;
    protected String privateTestingCommunity;

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

        WebDriver driver = getDriver();

        if (method.getName().equals("verifySearchFunctionality")){
            driver.get(R.TESTDATA.get("android.home"));
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}