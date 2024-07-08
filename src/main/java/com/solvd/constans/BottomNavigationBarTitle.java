package com.solvd.constans;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BottomNavigationBarTitle {
    HOME("Home"),
    COMMUNITIES("Communities"),
    CREATE("Create"),
    CHAT("Chat"),
    INBOX("Inbox");

    private String title;
}
