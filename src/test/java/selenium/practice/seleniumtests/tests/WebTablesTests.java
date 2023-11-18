package selenium.practice.seleniumtests.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.practice.seleniumtests.pages.WebTablesPage;
import selenium.practice.seleniumtests.TestBase;

import java.io.IOException;
import java.time.Duration;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class WebTablesTests extends TestBase {
    WebTablesPage webTablesPage;

    @DisplayName("Проверить редактирование грида")
    @Test
    void checkEditForm() throws IOException {
        webTablesPage = new WebTablesPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Links'", () -> {
            webTablesPage.openWebPage();
            Assertions.assertEquals("Web Tables",
                    webTablesPage.getGetTitle().getText());
            driver.navigate().refresh();
        });

        step("Отредактировать первую строчку грида, открыть модальное окно", () -> {
            webTablesPage.editFirstRecord(driver);
        });

        step("Проверить закрытие модального окна", () -> {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions
                            .elementToBeClickable(webTablesPage.getMainHeader()));
            Assertions.assertTrue(webTablesPage.getMainHeader().isDisplayed());
        });
    }

    @DisplayName("Нажать на кнопку 'Add' и проверить открытие модального окна")
    @Test
    void checkModelWindowOpen() throws IOException {
        webTablesPage = new WebTablesPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Links'", () -> {
            webTablesPage.openWebPage();
            Assertions.assertEquals("Web Tables",
                    webTablesPage.getGetTitle().getText());
            driver.navigate().refresh();
        });

        step("Нажать на кнопку 'Add'", () -> {
            driver.navigate().refresh();
            webTablesPage.clickButtonAdd(driver, actions);
        });

        step("Проверить открытие модального окна", () -> {
            Assertions.assertEquals("Registration Form",
                    webTablesPage.getRegFormTitle().getText());
        });

    }


    @DisplayName("Проверить удаление элементов")
    @Test
    void checkElementIsDeleted() throws IOException {
        webTablesPage = new WebTablesPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Links'", () -> {
            webTablesPage.openWebPage();
            Assertions.assertEquals("Web Tables",
                    webTablesPage.getGetTitle().getText());
            driver.navigate().refresh();
        });

        step("Удалить первую строчку грида", () -> {
            driver.navigate().refresh();
            webTablesPage.deleteFirstRecord();
            System.out.println("111111111111111111111111111" + webTablesPage.getBaseUrl());
        });

        step("Проверить, что элемент отсутствует в гриде после удаления", () -> {
            Assertions.assertEquals(webTablesPage.getDeleteInitialCount()
                            - webTablesPage.getDeletedCellsCount(),
                    webTablesPage.getDeleteResultCount());
        });

    }

    @DisplayName("Проверить поиск элементов")
    @Test
    void checkElementIsFound() throws IOException {
        webTablesPage = new WebTablesPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Links'", () -> {
            webTablesPage.openWebPage();
            Assertions.assertEquals("Web Tables",
                    webTablesPage.getGetTitle().getText());
            driver.navigate().refresh();
        });

        step("Найти элемент в гриде", () -> {
            webTablesPage.searchRecord();
            assertThat(webTablesPage.getSearchArrayList(), hasItem("Alden"));
        });
    }

    @DisplayName("Проверить работу пейджинга")
    @Test
    void checkPaging() throws IOException {
        webTablesPage = new WebTablesPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Links'", () -> {
            webTablesPage.openWebPage();
            Assertions.assertEquals("Web Tables",
                    webTablesPage.getGetTitle().getText());
            driver.navigate().refresh();
        });

        step("Заполнить форму несколько раз и проверить переход пейджинга", () -> {
            webTablesPage.fillFormSeveralTimes(driver, 5);
            Assertions.assertEquals(5, webTablesPage.getRowData() - 1);
        });
    }
}
