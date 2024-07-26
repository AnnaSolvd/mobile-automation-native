package com.solvd.gui.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class DropDownMenu extends AbstractUIObject {

    protected DropDownMenu(WebDriver driver) {
        super(driver);
    }

    protected DropDownMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
