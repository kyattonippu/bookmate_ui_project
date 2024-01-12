package com.kyattonippu.utils;

import com.kyattonippu.pages.MainPage;

public enum Header {

    BOOKS("Главное", MainPage.baseUrl() + "books"),
    AUDIOBOOKS("Аудио", MainPage.baseUrl() + "audiobooks"),
    COMICS("Комиксы", MainPage.baseUrl() + "comicbooks"),
    CHILDERNS("Детям", MainPage.baseUrl() + "library/t-detyam-ru" );

    public final String name;
    public final String url;

    Header(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
