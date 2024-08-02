package com.solvd.swaglabs.constans;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LeftNavigationSidebarTitle {
    ALL_ITEMS("ALL ITEMS"),
    WEBVIEW("WEBVIEW"),
    QR_CODE_SCANNER("QR CODE SCANNER"),
    GEO_LOCATION("GEO LOCATION"),
    DRAWING("DRAWING"),
    ABOUT("ABOUT"),
    LOGOUT("LOGOUT"),
    RESET_APP_STATE("RESET APP STATE");

    private String title;
}
