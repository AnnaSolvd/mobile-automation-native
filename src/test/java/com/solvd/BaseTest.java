package com.solvd;

import com.solvd.util.DeepLinkFactory;
import com.solvd.util.DeepLinkManager;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.resources.L10N;
import com.zebrunner.carina.webdriver.config.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.utils.config.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Locale;

import static org.testng.AssertJUnit.assertEquals;

public abstract class BaseTest implements IAbstractTest {

    protected WebDriver driver;
    protected String username;
    protected String aboutUserText;
    protected String searchTerm;
    protected DeepLinkManager deepLinkManager;
    protected DeepLinkFactory deepLinkFactory;

    @BeforeClass
    public void setUp() {
        username = R.TESTDATA.get("user.username");
        aboutUserText = R.TESTDATA.get("user.about_text");
        searchTerm = R.TESTDATA.get("search_term");

        Locale locale = L10N.getLocale();
        String loadedLocale = locale.getLanguage() + "_" + locale.getCountry();
        String configLocale = Configuration.getRequired(WebDriverConfiguration.Parameter.LOCALE);
        assertEquals(loadedLocale, configLocale);
    }

    @BeforeMethod
    public void setupTestMethod(Method method) {
        driver = getDriver();
        deepLinkFactory = new DeepLinkFactory();
        deepLinkManager = new DeepLinkManager(driver, deepLinkFactory);
        deepLinkManager.setupDeepLink(method.getName());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
