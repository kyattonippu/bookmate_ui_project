package com.kyattonippu.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {

    public static final SelenideElement searchInput = $(".SearchInputDesktop_input__9AXId");
    public static final ElementsCollection searchResults = $$(".SearchLayout_content__3pDkt");
    public static final SelenideElement searchFiltersBox = $(".SearchTabs_container__mFoCl");

    @Step("Выполнить поиск по: {searchText}")
    public SearchPage performSearch(String searchText) {
        searchInput.click();
        searchInput.setValue(searchText);
        return this;
    }

    @Step("Выбрать фильтр {itemType} для результатов поиска")
    public SearchPage selectFilter(String itemType) {
        searchFiltersBox.$(byText(itemType)).click();
        return this;
    }

    @Step("Проверить, что элемент {expectedText} находится в результатах поиска")
    public SearchPage checkItemIsInResults(String expectedText) {
        searchResults.shouldHave(texts(expectedText));

        return this;
    }
}
