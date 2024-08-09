package com.solvd.reddit.gui.pages.android;

import com.solvd.reddit.gui.pages.common.HistoryPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.checkerframework.checker.i18n.qual.Localized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HistoryPageBase.class)
public class HistoryPage extends HistoryPageBase {

    private static final Logger logger = LoggerFactory.getLogger(HistoryPage.class);

    @FindBy(xpath = "//android.widget.TextView[@text='{L10N:HistoryPage.pageTitle}']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.reddit.frontpage:id/link_list']/android.widget.LinearLayout")
    private List<ExtendedWebElement> postList;

    public HistoryPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(pageTitle);
        logger.info("HistoryPage open");
    }

    @Override
    public boolean isPostTitlePresent(String expectedTitle) {
        return postList.stream()
                .map(postElement -> postElement.findExtendedWebElement(By.xpath(".//android.widget.TextView[@resource-id='com.reddit.frontpage:id/title']")))
                .map(ExtendedWebElement::getText)
                .anyMatch(expectedTitle::equalsIgnoreCase);
    }
}
