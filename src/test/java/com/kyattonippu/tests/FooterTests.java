package com.kyattonippu.tests;

import com.kyattonippu.pages.MainPage;
import com.kyattonippu.utils.Footer;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Selenide.open;
import static com.kyattonippu.pages.MainPage.baseUrl;

@Tag("UI")
@Feature("Footer")
@Owner("kyattonippu")
public class FooterTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Step("Открыть главную страницу")
    @BeforeEach
    public void beforeEach() {
        open(baseUrl());
    }

    @Test
    @Tag("remote")
    @DisplayName("Проверка видимости контактов в Footer")
    void checkHeaderLinksVisibilityTest() {
        mainPage.checkVkLinkVisibility();
        mainPage.checkTgLinkVisibility();
    }

    @ParameterizedTest(name = "{arguments}")
    @Tag("remote")
    @EnumSource(Footer.class)
    @DisplayName("Проверка открытия ссылок в Footer")
    void checkFooterLinksOpeningTest(Footer footer) {
        Allure.getLifecycle().updateTestCase(test ->
                test.setName("Возможность открытия ссылок: [Footer]"));

        mainPage.checkFooterPageIsOpen(footer);

    }
}
