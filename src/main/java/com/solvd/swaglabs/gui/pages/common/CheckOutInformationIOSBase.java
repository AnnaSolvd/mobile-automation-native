package com.solvd.swaglabs.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckOutInformationIOSBase extends AbstractPage {

    protected CheckOutInformationIOSBase(WebDriver driver) {
        super(driver);
    }

    public abstract void fillFormWithData(String firstName, String lastName, String zipCode);

    public abstract CheckOutOverviewIOSBase clickCheckOutButton();

}
