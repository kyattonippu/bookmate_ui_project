package com.kyattonippu.pages;

import com.codeborne.selenide.SelenideElement;
import com.kyattonippu.utils.Footer;
import com.kyattonippu.utils.Header;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverRunner.driver;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPage {

    public static String baseUrl() {
        return "https://bookmate.ru/";
    }
    private final SelenideElement headerTabsSection = $(".Header_header__9Wxwt");
    private final SelenideElement footerTabsSection = $(".footer-contacts_links__f_QVR");

    public SelenideElement allBooksLink = $(byText("Главное")),
    audioBooksLink = $(byText("Аудио")),
    comicBooksLink = $(byText("Комиксы")),
    childrensLink = $(byText("Детям")),
    searchLink = $("[href='/search']"),
    plusLink = $(byText("Оформить подписку")),
    loginLink = $(byText("Войти")),
    vkLink = $("[href='https://vk.com/bookmate_ru']"),
    tgLink = $("[href='https://t.me/bookmate_ru']");

    @Step("Открыть {header}")
    public MainPage openHeader(Header header) {
        headerTabsSection.$(withText(header.name)).click();
        return this;
    }

    @Step("Открыть {footer}")
    public MainPage openFooter(Footer footer) {
        footerTabsSection.scrollTo();
        footerTabsSection.$(withText(footer.name)).click();

        return this;
    }

    @Step("Проверить, что страница {url} открыта")
    public MainPage checkPageIsOpen(String url) {
        webdriver().shouldHave(url(url));

        return this;
    }

    @Step("Проверить, что страница {url} открыта")
    public MainPage checkFooterPageIsOpen(String url) {
        webdriver().shouldHave(url(url));

        return this;
    }

    @Step("Проверить, что кнопка 'Главное' видна")
    public MainPage checkAllBooksLinkVisibility() {
        allBooksLink.shouldBe(visible);

        return this;
    }

    @Step("Проверить, что кнопка 'Аудио' видна")
    public MainPage checkAudioBooksLinkVisibility() {
        audioBooksLink.shouldBe(visible);

        return this;
    }

    @Step("Проверить, что кнопка 'Комиксы' видна")
    public MainPage checkComicBooksLinkVisibility() {
        comicBooksLink.shouldBe(visible);

        return this;
    }

    @Step("Проверить, что кнопка 'Детям' видна")
    public MainPage checkChildrensBooksLinkVisibility() {
        childrensLink.shouldBe(visible);

        return this;
    }

    @Step("Проверить, что кнопка 'Поиск' видна")
    public MainPage checkSearchLinkVisibility() {
        searchLink.shouldBe(visible);

        return this;
    }

    @Step("Проверить, что кнопка 'Оформить подписку' видна")
    public MainPage checkPlusLinkVisibility() {
        plusLink.shouldBe(visible);

        return this;
    }

    @Step("Проверить, что кнопка 'Войти' видна")
    public MainPage checkLoginLinkVisibility() {
        loginLink.shouldBe(visible);

        return this;
    }

    @Step("Проверить, что кнопка Vk видна в контактах")
    public MainPage checkVkLinkVisibility() {
        vkLink.shouldBe(visible);

        return this;
    }

    @Step("Проверить, что кнопка Telegram видна в контактах")
    public MainPage checkTgLinkVisibility() {
        tgLink.shouldBe(visible);

        return this;
    }

}
