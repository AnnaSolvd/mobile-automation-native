package com.solvd.reddit.constans;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SideMenuTitle {
    PROFILE("Profile"),
    CREATE_A_COMMUNITY("Create a community"),
    CONTRIBUTOR_PROGRAM("Contributor Program"),
    VAULT("Vault"),
    REDDIT_PREMIUM("Reddit Premium"),
    SAVED("Saved"),
    HISTORY("History"),
    SETTINGS("Settings");

    private String title;
}
