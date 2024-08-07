package com.solvd.reddit.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.checkerframework.checker.i18n.qual.Localized;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DropDownMenu extends AbstractUIObject {

    @Localized
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.reddit.frontpage:id/title' and " +
            "@text='{L10N:DropDownMenu.saveButtonText}']")
    private ExtendedWebElement saveButton;

    public DropDownMenu(WebDriver driver) {
        super(driver);
    }

    public DropDownMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickSaveButton() {
        saveButton.click();
    }
}
