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

    protected String aboutUser;

    @BeforeClass
    public void setUp() {
        username = R.TESTDATA.get("user.username");
        aboutUser = R.TESTDATA.get("user.biography_text");
    }

    @BeforeMethod
    public void setupTestMethod(Method method) {
        String deeplink = null;
        switch (method.getName()) {
            case "verifyThatUserCanUpdateProfileBio":
                deeplink = R.TESTDATA.get("deeplink.profile") + username;
                break;
            case "verifyUserPostingOnCommunity":
                deeplink = R.TESTDATA.get("deeplink.community");
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
