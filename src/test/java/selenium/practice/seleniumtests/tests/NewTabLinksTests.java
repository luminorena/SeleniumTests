package selenium.practice.seleniumtests.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.practice.seleniumtests.pages.LinksPage;
import selenium.practice.seleniumtests.TestBase;

import java.io.IOException;

import static io.qameta.allure.Allure.step;

public class NewTabLinksTests extends TestBase {
    LinksPage linksPage;

    @DisplayName("Проверка названий блока")
    @Test
    void blockNameTests() throws IOException {
        linksPage = new LinksPage(driver);
        step("Перейти на страницу 'Links'", () -> {
            linksPage.openLinksPage(driver);
        });

        step("Проверка открытия блока для нового таба", () -> {
            Assertions.assertEquals("Following links will open new tab",
                    linksPage.getListOfTitles().get(0).getText());
        });

        step("Проверка названия блока для api вызова", () -> {
            Assertions.assertEquals("Following links will send an api call",
                    linksPage.getListOfTitles().get(1).getText());
        });

    }

    @DisplayName("Проверка ссылки 'Home'")
    @Test
    void homeLinkTests() throws IOException {
        linksPage = new LinksPage(driver);
        step("Перейти на страницу 'Links'", () -> {
            linksPage.openLinksPage(driver);
        });

        step("Нажать на ссылку 'Home'", () -> {
            linksPage.clickHomeLink(driver);
        });

        step("Проверить, что ссылка 'Home' открывает страницу в новой вкладке", () -> {
            Assertions.assertEquals(linksPage.getBaseUrl(), linksPage.getNodeUrl());
        });

        step("", () -> {
            Assertions.assertEquals(linksPage.getUrlWebPage(), linksPage.getCurrentUrl());
        });

    }

    @DisplayName("Проверка динамической ссылки")
    @Test
    void dynamicLinkTests() throws IOException {
        linksPage = new LinksPage(driver);
        step("Перейти на страницу 'Links'", () -> {
            linksPage.openLinksPage(driver);
        });

        step("Нажать на динамическую ссылку", () -> {
            linksPage.clickHomeDynamic(driver);
        });

        step("Проверить, что ссылка динамическая ссылка открывает " +
                "страницу в новой вкладке", () -> {
            Assertions.assertEquals(linksPage.getBaseUrl(), linksPage.getNodeUrl());

        });

        step("", () -> {
            Assertions.assertEquals(linksPage.getUrlWebPage(), linksPage.getCurrentUrl());
        });
    }

}
