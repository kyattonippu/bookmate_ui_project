package com.kyattonippu.tests;

import com.kyattonippu.pages.MainPage;
import com.kyattonippu.utils.Header;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Selenide.open;
import static com.kyattonippu.pages.MainPage.baseUrl;

@Tag("UI")
@Feature("Header")
@Owner("kyattonippu")
public class HeaderTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Step("Открыть главную страницу")
    @BeforeEach
    public void beforeEach() {
        open(baseUrl());
    }

    @Test
    @Tag("remote")
    @DisplayName("Проверка видимости ссылок в Header")
    void checkHeaderLinksVisibility() {

        mainPage.checkAllBooksLinkVisibility();
        mainPage.checkAudioBooksLinkVisibility();
        mainPage.checkComicBooksLinkVisibility();
        mainPage.checkChildrensBooksLinkVisibility();
        mainPage.checkSearchLinkVisibility();
        mainPage.checkPlusLinkVisibility();
        mainPage.checkLoginLinkVisibility();

    }

    @ParameterizedTest(name = "{arguments}")
    @EnumSource(Header.class)
    @DisplayName("Проверка открытия вкладок в Header")
    void checkHeaderLinksOpening(Header header) {
        Allure.getLifecycle().updateTestCase(test ->
                test.setName("Возможность открытия вкладок: [Header]"));

        mainPage.openHeader(header)
                .checkPageIsOpen(header.url);
    }
}
