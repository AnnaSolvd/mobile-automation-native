package com.solvd.constans;

import lombok.Getter;

@Getter
public enum BottomNavigationBarTitle {
    HOME("Home"),
    COMMUNITIES("Communities"),
    CREATE("Create"),
    CHAT("Chat"),
    INBOX("Inbox");

    private String title;

    BottomNavigationBarTitle(String title) {
        this.title = title;
    }
}
