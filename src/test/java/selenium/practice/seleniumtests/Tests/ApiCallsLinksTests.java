package selenium.practice.seleniumtests.Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.practice.helpers.LinksStatuses;
import selenium.practice.seleniumtests.Pages.LinksPage;

import static io.qameta.allure.Allure.step;

public class ApiCallsLinksTests extends TestBase{
    LinksPage linksPage;

    @DisplayName("Проверка отображения результатов нажатия на ссылку 'Created'")
    @Test
    void createdLinkWebViewTests() {
        linksPage = new LinksPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Links'", () -> {
            linksPage.openLinksPage(js);
        });

        step("Нажать на ссылку 'Created'", () -> {
            linksPage.clickCreatedApiLink(actions);
        });

        step("Проверка отображения вывода текста после нажатия на ссылку" +
                " 'Created'", () -> {
            Assertions.assertEquals(LinksStatuses.STATUS_201.description,
                    linksPage.getLinkResponse().getText());
        });

    }

    @DisplayName("Проверка отображения результатов нажатия на ссылку 'No Content'")
    @Test
    void noContentLinkWebViewTests() {
        linksPage = new LinksPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Links'", () -> {
            linksPage.openLinksPage(js);
        });

        step("Нажать на ссылку 'No Content'", () -> {
            linksPage.clickNoContentApiLink(actions);
        });

        step("Проверка отображения вывода текста после нажатия на ссылку" +
                " 'No Content'", () -> {
            Assertions.assertEquals(LinksStatuses.STATUS_204.description,
                    linksPage.getLinkResponse().getText());
        });

    }

    @DisplayName("Проверка отображения результатов нажатия на ссылку 'Moved'")
    @Test
    void movedLinkWebViewTests() {
        linksPage = new LinksPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Links'", () -> {
            linksPage.openLinksPage(js);
        });

        step("Нажать на ссылку 'Moved'", () -> {
            linksPage.clickMovedApiLink(actions);
        });

        step("Проверка отображения вывода текста после нажатия на ссылку" +
                " 'Moved'", () -> {
            Assertions.assertEquals(LinksStatuses.STATUS_301.description,
                    linksPage.getLinkResponse().getText());
        });

    }


    @DisplayName("Проверка отображения результатов нажатия на ссылку 'Bad request'")
    @Test
    void badRequestLinkWebViewTests() {
        linksPage = new LinksPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Links'", () -> {
            linksPage.openLinksPage(js);
        });

        step("Нажать на ссылку 'Bad request'", () -> {
            linksPage.clickBadRequestApiLink(actions);
        });

        step("Проверка отображения вывода текста после нажатия на ссылку" +
                " 'Bad request'", () -> {
            Assertions.assertEquals(LinksStatuses.STATUS_400.description,
                    linksPage.getLinkResponse().getText());
        });
    }


    @DisplayName("Проверка отображения результатов нажатия на ссылку 'Unauthorized'")
    @Test
    void unauthorizedLinkWebViewTests() {
        linksPage = new LinksPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Links'", () -> {
            linksPage.openLinksPage(js);
        });

        step("Нажать на ссылку 'Unauthorized'", () -> {
            linksPage.clickUnauthorizedApiLink(actions);
        });

        step("Проверка отображения вывода текста после нажатия на ссылку" +
                " 'Unauthorized'", () -> {
            Assertions.assertEquals(LinksStatuses.STATUS_401.description,
                    linksPage.getLinkResponse().getText());
        });
    }

    @DisplayName("Проверка отображения результатов нажатия на ссылку 'Forbidden'")
    @Test
    void forbiddenLinkWebViewTests() {
        linksPage = new LinksPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Links'", () -> {
            linksPage.openLinksPage(js);
        });

        step("Нажать на ссылку 'Forbidden'", () -> {
            linksPage.clickForbiddenApiLink(actions);
        });

        step("Проверка отображения вывода текста после нажатия на ссылку" +
                " 'Forbidden'", () -> {
            Assertions.assertEquals(LinksStatuses.STATUS_403.description,
                    linksPage.getLinkResponse().getText());
        });
    }

    @DisplayName("Проверка отображения результатов нажатия на ссылку 'Not found'")
    @Test
    void notFoundLinkWebViewTests() {
        linksPage = new LinksPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Links'", () -> {
            linksPage.openLinksPage(js);
        });

        step("Нажать на ссылку 'Not found'", () -> {
            linksPage.clickNotFoundApiLink(actions);
        });

        step("Проверка отображения вывода текста после нажатия на ссылку" +
                " 'Not found'", () -> {
            Assertions.assertEquals(LinksStatuses.STATUS_404.description,
                    linksPage.getLinkResponse().getText());
        });
    }

}
