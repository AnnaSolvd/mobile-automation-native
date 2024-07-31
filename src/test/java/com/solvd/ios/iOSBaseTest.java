package com.solvd.ios;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class iOSBaseTest implements IAbstractTest {

    protected WebDriver driver;
    protected String username;
    protected String password;
//    protected String searchTerm;

    @BeforeClass
    public void setUp() {
        username = R.TESTDATA.get("ios.username");
        password = R.TESTDATA.get("ios.password");
//        searchTerm = R.TESTDATA.get("search_term");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
