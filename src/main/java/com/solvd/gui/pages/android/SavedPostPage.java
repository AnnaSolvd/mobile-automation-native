package com.solvd.gui.pages.android;

import com.solvd.gui.components.Post;
import com.solvd.gui.pages.common.SavedPostPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.checkerframework.checker.i18n.qual.Localized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SavedPostPage.class)
public class SavedPostPage extends SavedPostPageBase {

    private static final Logger logger = LoggerFactory.getLogger(SavedPostPage.class);

    @Localized
    @FindBy(xpath = "//android.widget.TextView[@text='{L10N:SavedPostPage.pageTitle}']")
    private ExtendedWebElement pageTitle;

    @FindBy(id = "com.reddit.frontpage:id/link_list")
    private List<Post> postList;

    public SavedPostPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
        logger.info("SavedPostPage open");
    }
}
