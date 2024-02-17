package com.kyattonippu.utils;

public enum Footer {

    AGREEMENT("Пользовательское соглашение", "https://yandex.ru/legal/bookmate_termsofuse/?campaign_name=footer"),
    CONDITIONS("Условия подписки", "https://yandex.ru/legal/yandex_plus_conditions/?campaign_name=footer"),
    RULES("Правила рекомендаций",  "https://bookmate.ru/legal/recommendations/ru/?force-web=true&campaign_name=footer"),
    HELP("Справка", "https://yandex.ru/support/bookmate/?campaign_name=footer" ),
    FORUM("Форум пожеланий", "https://yandexbookmate.userecho.com/?campaign_name=footer");

    public final String name;
    public final String url;

    Footer(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
