package mobile.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import mobile.gui.pages.common.HomePageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
