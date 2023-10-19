package selenium.practice.seleniumtests.Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.practice.seleniumtests.Pages.WebTablesPage;

import static io.qameta.allure.Allure.step;

public class WebTablesTests extends TestBase {
    WebTablesPage webTablesPage;

    @Test
    void webTablesTests()  {
        webTablesPage = new WebTablesPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Links'", () -> {
            webTablesPage.checkOpenLinksPage(js);
        });

        step("Нажать на кнопку 'Add' и проверить открытие окна", () -> {
            webTablesPage.checkButtonAdd(driver, actions);
        });

        step("Заполнить форму и проверить добавление новой строки", () -> {
           webTablesPage.fillFormAndCheck(driver);
        });

        step("Отредактировать первую строчку грида", () -> {
            webTablesPage.editFirstRecord(driver);
        });

        step("Удалить первую строчку грида", () -> {
            webTablesPage.deleteFirstRecord();
        });

        step("Найти элемент в гриде", () -> {
            webTablesPage.searchRecord();
        });

        step("Заполнить форму несколько раз и проверить выбор дропдауна", () -> {
            driver.navigate().refresh();
            webTablesPage.fillFormSeveralTimes(driver, 4);
        });

    }


    @Test
    @DisplayName("Нажать на кнопку 'Add' и проверить открытие окна")
    void testButtonClick() {
        webTablesPage = new WebTablesPage(driver);
        webTablesPage.openWebPage();
        webTablesPage.checkButtonAdd(driver, actions);
    }
}
