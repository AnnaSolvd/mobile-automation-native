package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.SearchResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchResultPageBase.class)
public class SearchResultPage extends SearchResultPageBase{

    private static final Logger logger = LoggerFactory.getLogger(SearchResultPage.class);

    @FindBy(xpath = " //android.view.View[@resource-id='tab_unit'])[1]/android.view.View")
    private ExtendedWebElement postTabButton;

    @FindBy(xpath = "//android.view.View[@resource-id='search_post_section']")
    private List<ExtendedWebElement> postList;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(postTabButton);
    }

    @Override
    public boolean isStringPresentInElement(String searchString) {
        logger.info(postList.toString());
        return postList.stream()
                .anyMatch(post -> {
                    String contentDesc = post.getAttribute("content-desc");
                    String text = post.getAttribute("text");
                    return contentDesc.contains(searchString) || text.contains(searchString);
                });
    }

}
