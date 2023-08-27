package selenium.practice.seleniumtests.Tests;

import org.junit.jupiter.api.Assertions;
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
            Assertions.assertEquals("Following links will open new tab",
                    linksPage.title.get(0).getText());
        });

        step("Проверка ссылки 'Home'", () -> {
            linksPage.homeLink.click();
            linksPage.clickLink(driver);
            Assertions.assertEquals("https://demoqa.com/",linksPage.nodeUrl);
            Assertions.assertEquals("https://demoqa.com/links", linksPage.currentUrl);
        });

        step("Проверка ссылки 'HomeQoPPa'", () -> {
            linksPage.dynamicLink.click();
            linksPage.clickLink(driver);
            Assertions.assertEquals("https://demoqa.com/",linksPage.nodeUrl);
            Assertions.assertEquals("https://demoqa.com/links", linksPage.currentUrl);
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
            Assertions.assertEquals("Following links will send an api call",
                    linksPage.title.get(1).getText());
        });

        step("Проверка ссылки 'Created'", () -> {
            linksPage.created.click();
            actions.moveToElement(linksPage.linkResponse).click().perform();
            Assertions.assertEquals("Link has responded with staus 201 and status text Created",
                    linksPage.linkResponse.getText());
        });


        step("Проверка ссылки 'No Content'", () -> {
            linksPage.noContent.click();
            actions.moveToElement(linksPage.linkResponse).click().perform();
            Assertions.assertEquals("Link has responded with staus 204 and status text No Content",
                    linksPage.linkResponse.getText());
        });

        step("Проверка ссылки 'Moved'", () -> {
            linksPage.moved.click();
            actions.moveToElement(linksPage.linkResponse).click().perform();
            Assertions.assertEquals("Link has responded with staus 301 and status text Moved Permanently",
                    linksPage.linkResponse.getText());
        });

        step("Проверка ссылки 'Bad request'", () -> {
            linksPage.badRequest.click();
            actions.moveToElement(linksPage.linkResponse).click().perform();
            Assertions.assertEquals("Link has responded with staus 400 and status text Bad Request",
                    linksPage.linkResponse.getText());
        });

        step("Проверка ссылки 'Unauthorized'", () -> {
            linksPage.unauthorized.click();
            actions.moveToElement(linksPage.linkResponse).click().perform();
            Assertions.assertEquals("Link has responded with staus 401 and status text Unauthorized",
                    linksPage.linkResponse.getText());
        });

        step("Проверка ссылки 'Forbidden'", () -> {
            linksPage.forbidden.click();
            actions.moveToElement(linksPage.linkResponse).click().perform();
            Assertions.assertEquals("Link has responded with staus 403 and status text Forbidden",
                    linksPage.linkResponse.getText());
        });

        step("Проверка ссылки 'Not found'", () -> {
            linksPage.notFound.click();
            actions.moveToElement(linksPage.linkResponse).click().perform();
            Assertions.assertEquals("Link has responded with staus 404 and status text Not Found",
                    linksPage.linkResponse.getText());
        });

    }
}
