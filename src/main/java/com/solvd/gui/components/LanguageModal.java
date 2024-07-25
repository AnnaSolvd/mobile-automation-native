package com.solvd.gui.components;

import com.solvd.gui.pages.common.ProfilePageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LanguageModal extends AbstractUIObject implements ICustomTypePageFactory {

    private static final Logger logger = LoggerFactory.getLogger(LanguageModal.class);

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.reddit.frontpage:id/bottomsheet_recycler_view']")
    private List<ExtendedWebElement> languageButtonsList;

    public LanguageModal(WebDriver driver) {
        super(driver);
    }

    protected LanguageModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ProfilePageBase clickMenuButtonByName(String buttonName) {
        languageButtonsList.stream()
                .filter(button -> {
                    List<ExtendedWebElement> textViews = button.findExtendedWebElements(By.xpath(".//android.widget.TextView"));
                    return textViews.stream().anyMatch(textView -> textView.getText().equalsIgnoreCase(buttonName));
                })
                .findFirst()
                .ifPresent(ExtendedWebElement::click);

        logger.info("Clicked on the button: {}", buttonName);
        return initPage(driver, ProfilePageBase.class);
    }
}
