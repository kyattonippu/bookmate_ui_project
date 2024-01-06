package com.kyattonippu.tests;

import com.kyattonippu.pages.SearchPage;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.open;
import static com.kyattonippu.pages.MainPage.baseUrl;

@Tag("UI")
@Feature("Search")
@Owner("kyattonippu")
public class SearchTests {

    SearchPage searchPage = new SearchPage();

    @BeforeEach
    @Step("Открыть страницу поиска")
    public void beforeEach() {
        open(baseUrl() + "/search");
    }

    @CsvSource(value = {
            "Книги | Краткие ответы на большие вопросы",
            "Аудиокниги | Антихрупкость",
            "Комиксы | Sapiens. Графическая история",
            "Серии | Песнь Льда и Пламени",
            "Авторы | Виктор Пелевин",
            "Полки | Нобелевская премия",
    }, delimiter = '|')

    @ParameterizedTest(name = "{arguments}")
    @DisplayName("Поиск элемента по фильтру:")
    void checkSearchWithFilter(String itemType, String itemName) {
        Allure.getLifecycle().updateTestCase(test ->
                test.setName("Поиск элемента по фильтру: [Filter, Search text]"));

        searchPage.performSearch(itemName)
                .selectFilter(itemType)
                .checkItemIsInResults(itemName);
    }
}
