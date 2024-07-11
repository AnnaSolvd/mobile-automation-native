package com.solvd.gui.components;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WelcomeCommunityModal extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(id = "nav_user_name")
    private ExtendedWebElement noThanksButton;

    protected WelcomeCommunityModal(WebDriver driver) {
        super(driver);
    }

    protected WelcomeCommunityModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
