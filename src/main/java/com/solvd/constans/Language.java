package com.solvd.constans;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Language {
    ENGLISH("English"),
    FRENCH("Français");

    private String title;
}
