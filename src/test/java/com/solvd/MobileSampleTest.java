package com.solvd;

import com.solvd.gui.pages.common.*;
import org.testng.annotations.Test;

public class MobileSampleTest extends BaseTest {

    @Test(description = "TC-01")
    public void verifyThatUserCanUpdateProfileBio() {
        ProfilePageBase profilePage = initPage(driver, ProfilePageBase.class);
        profilePage.isPageOpened();

        profilePage.clickEditButton();
        EditProfilePageBase editProfilePage = profilePage.clickEditButton();

        editProfilePage.typeAboutField(aboutUser);
        editProfilePage.clickSaveButton();
    }

}
