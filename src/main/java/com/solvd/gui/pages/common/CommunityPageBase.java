package com.solvd.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CommunityPageBase extends AbstractPage implements IMobileUtils {

    public CommunityPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCommunityTitlePresent();
}
