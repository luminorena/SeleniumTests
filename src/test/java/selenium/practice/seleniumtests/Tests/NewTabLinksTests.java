package selenium.practice.seleniumtests.Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.practice.seleniumtests.Pages.LinksPage;

import static io.qameta.allure.Allure.step;

public class NewTabLinksTests extends TestBase{
    LinksPage linksPage;


    @DisplayName("Проверка названий блока")
    @Test
    void blockNameTests(){
        linksPage = new LinksPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Links'", () -> {
            linksPage.openLinksPage(js);
        });

        step("Проверка названия блока", () -> {
            Assertions.assertEquals("Following links will open new tab",
                    linksPage.getTitle().get(0).getText());
            Assertions.assertEquals("Following links will send an api call",
                    linksPage.getTitle().get(1).getText());
        });

    }

    @DisplayName("Проверка ссылки 'Home'")
    @Test
    void homeLinkTests(){
        linksPage = new LinksPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Links'", () -> {
            linksPage.openLinksPage(js);
        });

        step("Нажать на ссылку 'Home'", () -> {
            linksPage.clickHomeLink(driver);
        });

        step("Проверить, что ссылка 'Home' открывает страницу в новой вкладке", () -> {
            Assertions.assertEquals(linksPage.getBaseUrl(),linksPage.getNodeUrl());
            Assertions.assertEquals(linksPage.getBaseUrl() + "links",
                    linksPage.getCurrentUrl());
        });

    }

    @DisplayName("Проверка динамической ссылки")
    @Test
    void dynamicLinkTests() {
        linksPage = new LinksPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Links'", () -> {
            linksPage.openLinksPage(js);
        });

        step("Нажать на динамическую ссылку", () -> {
            linksPage.clickHomeDynamic(driver);
        });

        step("Проверить, что ссылка динамическая ссылка открывает " +
                "страницу в новой вкладке", () -> {
            Assertions.assertEquals(linksPage.getBaseUrl(),linksPage.getNodeUrl());
            Assertions.assertEquals(linksPage.getBaseUrl() + "links",
                    linksPage.getCurrentUrl());
        });

    }

}
