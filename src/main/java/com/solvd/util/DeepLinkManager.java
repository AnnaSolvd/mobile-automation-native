package com.solvd.util;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeepLinkManager {

    private static final Logger logger = LoggerFactory.getLogger(DeepLinkManager.class);

    private final WebDriver driver;
    private final DeepLinkFactory deepLinkFactory;

    public DeepLinkManager(WebDriver driver, DeepLinkFactory deepLinkFactory) {
        this.driver = driver;
        this.deepLinkFactory = deepLinkFactory;
    }

    public void setupDeepLink(String methodName) {
        logger.info("Deep link for method: {}", methodName);
        try {
            String deepLink = deepLinkFactory.createDeepLink(methodName);
            logger.info("Navigating to deep link: {}", deepLink);
            driver.get(deepLink);
        }
        catch (IllegalArgumentException e) {
            logger.error("Error setting up deep link: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

