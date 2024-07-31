package com.solvd.reddit.gui.pages.android;

import com.solvd.reddit.gui.pages.common.SearchResultPageBase;
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
    private ExtendedWebElement postsNavigationTabButton;

    @FindBy(xpath = "//android.view.View[@resource-id='search_post_section']")
    private List<ExtendedWebElement> postList;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(postsNavigationTabButton);
        logger.info("SearchResultPage open");
    }

    @Override
    public boolean isTermPresentInSearchPostsList(String searchTerm) {
//        WebDriverWait wait = new WebDriverWait(driver, driver.manage().timeouts().getImplicitWaitTimeout());
//        wait.until(ExpectedConditions.invisibilityOf(postList.get(0).getElement()));
        return postList.stream()
                .anyMatch(post -> {
                    String contentDesc = post.getAttribute("content-desc");
                    return contentDesc.contains(searchTerm);
                });
    }

}
