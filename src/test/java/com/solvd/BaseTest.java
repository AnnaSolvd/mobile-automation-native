package com.solvd;

import com.solvd.utils.DeepLinkManager;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public abstract class BaseTest implements IAbstractTest {

    protected WebDriver driver;

    protected String username;

    protected String aboutUserText;

    protected String searchTerm;

    protected String publicCommunity;

    protected String testingCommunity;

    protected DeepLinkManager deepLinkManager;

    @BeforeClass
    public void setUp() {
        username = R.TESTDATA.get("user.username");
        aboutUserText = R.TESTDATA.get("user.about_text");
        searchTerm = R.TESTDATA.get("search_term");
        publicCommunity = R.TESTDATA.get("community.public");
        testingCommunity = R.TESTDATA.get("community.testing");
    }

    @BeforeMethod
    public void setupTestMethod(Method method) {
        driver = getDriver();
        deepLinkManager = new DeepLinkManager(driver);
        deepLinkManager.setupDeepLink(method.getName(), username, publicCommunity, testingCommunity);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
