package com.solvd.reddit.gui.pages.android;

import com.solvd.reddit.gui.components.PreviewPost;
import com.solvd.reddit.gui.pages.common.SavedPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SavedPageBase.class)
public class SavedPage extends SavedPageBase {

    private static final Logger logger = LoggerFactory.getLogger(SavedPage.class);

    @FindBy(xpath = "//android.widget.TextView[@text='{L10N:SavedPage.pageTitle}']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.reddit.frontpage:id/link_list']")
    private List<PreviewPost> postList;

    public SavedPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(pageTitle);
        logger.info("SavedPage open");
    }

//    public boolean isPostPresent(String postTitle) {
//        postList.stream()
//                .filter(p -> p.getPostTitle().contains(postTitle)).
//    }

}
