package selenium.practice.seleniumtests.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.practice.helpers.LinksStatuses;
import selenium.practice.seleniumtests.pages.LinksPage;
import selenium.practice.seleniumtests.TestBase;

import static io.qameta.allure.Allure.step;

public class ApiCallsLinksTests extends TestBase {
    LinksPage linksPage;

    //todo make parametrized test

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

        step("Проверка отображения вывода текста " +
                "после нажатия на ссылку 'Created'", () -> {
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
            linksPage.clickNoContentApiLink();
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
            linksPage.clickMovedApiLink();
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
            linksPage.clickBadRequestApiLink();
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
            linksPage.clickUnauthorizedApiLink();
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
            linksPage.clickForbiddenApiLink();
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
            linksPage.clickNotFoundApiLink();
        });

        step("Проверка отображения вывода текста после нажатия на ссылку" +
                " 'Not found'", () -> {
            Assertions.assertEquals(LinksStatuses.STATUS_404.description,
                    linksPage.getLinkResponse().getText());
        });
    }
}
