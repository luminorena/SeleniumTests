package selenium.practice.seleniumtests.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import selenium.practice.helpers.ApiLinksEnum;
import selenium.practice.helpers.LinksStatuses;
import selenium.practice.seleniumtests.pages.LinksPage;
import selenium.practice.seleniumtests.TestBase;

import java.io.IOException;

import static io.qameta.allure.Allure.step;

public class ApiCallsLinksTests extends TestBase {
    LinksPage linksPage;

    // todo по айди параметризацию делать, айди = строка и подставляем в WebElement

    @DisplayName("param")
    @EnumSource(ApiLinksEnum.class)
    @ParameterizedTest(name = "param")
    void test() throws IOException {
        linksPage = new LinksPage(driver);
        step("Перейти на страницу 'Links'", () -> {
            linksPage.openLinksPage(driver);
        });
        step("Нажать на ссылку 'Created'", () -> {
            linksPage.clickCreatedApiLink(actions);
        });

    }

    @DisplayName("Проверка отображения результатов нажатия на ссылку 'Created'")
    @Test
    void createdLinkWebViewTests() throws IOException {
        linksPage = new LinksPage(driver);
        step("Перейти на страницу 'Links'", () -> {
            linksPage.openLinksPage(driver);
        });
        step("Нажать на ссылку 'Created'", () -> {
            linksPage.clickCreatedApiLink(actions);
        });
        step("Проверка отображения вывода текста " +
                "после нажатия на ссылку 'Created'", () -> {
            Assertions.assertEquals(LinksStatuses.STATUS_201.description, linksPage.getLinkResponse().getText());
        });
    }
    @DisplayName("Проверка отображения результатов нажатия на ссылку 'No Content'")
    @Test
    void noContentLinkWebViewTests() throws IOException {
        linksPage = new LinksPage(driver);
        step("Перейти на страницу 'Links'", () -> {
            linksPage.openLinksPage(driver);
        });
        step("Нажать на ссылку 'No Content'", () -> {
            linksPage.clickNoContentApiLink();
        });
        step("Проверка отображения вывода текста после нажатия на ссылку" +
                " 'No Content'", () -> {
            Assertions.assertEquals(LinksStatuses.STATUS_204.description, linksPage.getLinkResponse().getText());
        });
    }

    @DisplayName("Проверка отображения результатов нажатия на ссылку 'Moved'")
    @Test
    void movedLinkWebViewTests() throws IOException {
        linksPage = new LinksPage(driver);
        step("Перейти на страницу 'Links'", () -> {
            linksPage.openLinksPage(driver);
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
    void badRequestLinkWebViewTests() throws IOException {
        linksPage = new LinksPage(driver);
        step("Перейти на страницу 'Links'", () -> {
            linksPage.openLinksPage(driver);
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
    void unauthorizedLinkWebViewTests() throws IOException {
        linksPage = new LinksPage(driver);
        step("Перейти на страницу 'Links'", () -> {
            linksPage.openLinksPage(driver);
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
    void forbiddenLinkWebViewTests() throws IOException {
        linksPage = new LinksPage(driver);
        step("Перейти на страницу 'Links'", () -> {
            linksPage.openLinksPage(driver);
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
    void notFoundLinkWebViewTests() throws IOException {
        linksPage = new LinksPage(driver);
        step("Перейти на страницу 'Links'", () -> {
            linksPage.openLinksPage(driver);
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
