package com.solvd;

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

    @BeforeClass
    public void setUp() {
        username = R.TESTDATA.get("user.username");
        aboutUserText = R.TESTDATA.get("user.about_text");
        searchTerm = R.TESTDATA.get("search_term");
    }

    @BeforeMethod
    public void setupTestMethod(Method method) {
        String deeplink = null;
        switch (method.getName()) {
            case "verifySearchFunctionality":
                deeplink = R.TESTDATA.get("deeplink.home");
                break;
            case "verifyThatUserCanUpdateProfileBio":
                deeplink = R.TESTDATA.get("deeplink.profile") + username;
                break;
            case "verifyUserPostingOnCommunity":
                deeplink = R.TESTDATA.get("deeplink.community") + "testing_android";
                break;
            case "verifyJoiningCommunityAndYourCommunitiesSection":
                deeplink = R.TESTDATA.get("deeplink.community") + "Android";
                break;
            case "testInternationalization":
                deeplink = R.TESTDATA.get("deeplink.settings");
                break;
        }
        if (deeplink != null) {
            setupDriverWithDeeplink(deeplink);
        }
    }

    private void setupDriverWithDeeplink(String deeplink) {
        this.driver = getDriver();
        this.driver.get(deeplink);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
