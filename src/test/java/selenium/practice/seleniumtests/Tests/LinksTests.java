package selenium.practice.seleniumtests.Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.practice.seleniumtests.Pages.LinksPage;

import static io.qameta.allure.Allure.step;

public class LinksTests extends TestBase{
    LinksPage linksPage;

    @DisplayName("Проверка блока 'New Web Tabs'")
    @Test
    void newWebTabTests() {
        linksPage = new LinksPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Links'", () -> {
            linksPage.openLinksPage(js);
        });

        step("Проверка названия блока", () -> {
           linksPage.checkTabName();
        });

        step("Проверка открытия ссылки 'Home'", () -> {
            linksPage.checkHomeLink(driver);
        });

        step("Проверка ссылки 'HomeQoPPa'", () -> {
            linksPage.checkHomeQoPPa(driver);
        });

    }


    @DisplayName("Проверка блока 'Api calls'")
    @Test
    void apiCallsLinksTest() {
         linksPage = new LinksPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Links'", () -> {
            linksPage.openLinksPage(js);
        });

        step("Проверка названия блока", () -> {
           linksPage.checkApiName();
        });

        step("Проверка ссылки 'Created'", () -> {
            linksPage.checkCreated(actions);
        });


        step("Проверка ссылки 'No Content'", () -> {
           linksPage.checkNoContent();
        });

        step("Проверка ссылки 'Moved'", () -> {
           linksPage.checkMoved(actions);
        });

        step("Проверка ссылки 'Bad request'", () -> {
           linksPage.checkBadRequest(actions);
        });

        step("Проверка ссылки 'Unauthorized'", () -> {
           linksPage.checkUnauthorized(actions);
        });

        step("Проверка ссылки 'Forbidden'", () -> {
           linksPage.checkForbidden(actions);
        });

        step("Проверка ссылки 'Not found'", () -> {
           linksPage.checkNotFound(actions);
        });

    }
}
