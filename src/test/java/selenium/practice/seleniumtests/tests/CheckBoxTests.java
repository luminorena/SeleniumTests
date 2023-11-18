package selenium.practice.seleniumtests.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import selenium.practice.seleniumtests.pages.CheckBoxPage;
import selenium.practice.seleniumtests.TestBase;

import java.io.IOException;

import static io.qameta.allure.Allure.step;

public class CheckBoxTests extends TestBase {
    CheckBoxPage checkBoxPage;

    @DisplayName("Проверить блок чек-боксов 'Expand All'")
    @Test
    void expandAllCheckBoxTest() throws IOException {
        checkBoxPage = new CheckBoxPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'CheckBox'", () -> {
            checkBoxPage.openWebPage(driver);
            driver.navigate().refresh();
        });

        step("Нажать на чек-бокс 'Expand All'", () -> {
            checkBoxPage.clickExpandAllCheckBox();
        });

        step("Проверка чек-бокса 'Expand All'", () -> {
            boolean displayed = checkBoxPage.getExpandAllVisible().isDisplayed();
            Assertions.assertTrue(displayed);
        });
    }

    @DisplayName("Проверить блок чекбоксов 'Collapse All'")
    @Test
    void collapseAllCheckBoxTest() throws IOException {
        checkBoxPage = new CheckBoxPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'CheckBox'", () -> {
            checkBoxPage.openWebPage(driver);
            driver.navigate().refresh();
        });

        step("Нажать на чек-бокс 'Collapse All'", () -> {
            checkBoxPage.clickCollapseAllCheckBox();
        });

        step("Проверка чек-бокса 'Collapse All'", () -> {
            Assertions.assertTrue(checkBoxPage.getCollapseAllVisible().isDisplayed());
        });
    }

    @DisplayName("Проверить выбор корневого чек-бокса")
    @Test
    void allCheckBoxesAreCheckedTest() throws IOException {
        checkBoxPage = new CheckBoxPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'CheckBox'", () -> {
            checkBoxPage.openWebPage(driver);
            driver.navigate().refresh();
        });

        step("Нажать на ссылку открытия всего дерева чек-боксов", () -> {
            checkBoxPage.openAllCheckBoxTree();
        });

        step("Нажать на корневой чек-бокс", () -> {
            checkBoxPage.clickRootCheckBox();
        });

        step("Проверить, что корневой чек-бокс находится в состоянии 'checked'", () -> {
            Assertions.assertTrue(checkBoxPage.getMainCheckBox().isDisplayed());
        });
    }

    @DisplayName("Проверить выбор всех чек-боксов")
    @Test
    void checkAllCheckBoxesState() throws IOException {
        checkBoxPage = new CheckBoxPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'CheckBox'", () -> {
            checkBoxPage.openWebPage(driver);
            driver.navigate().refresh();
        });

        step("Нажать на ссылку открытия всего дерева чек-боксов", () -> {
            checkBoxPage.openAllCheckBoxTree();
        });

        step("Нажать на корневой чекбокс", () -> {
            checkBoxPage.clickRootCheckBox();
        });

        step("Нажать на все чек-боксы", () -> {
            checkBoxPage.checkAllCheckBoxes(driver, actions);
        });

        step("Проверить, что все чек-боксы в состоянии 'checked' ", () -> {
            for (WebElement checkbox : checkBoxPage.getCheckboxList()) {
                Assertions.assertTrue(checkbox.isSelected());
            }
        });
    }

    @DisplayName("Проверить отображение лейблов чек-боксов")
    @Test
    void checkLabelsView() throws IOException {
        checkBoxPage = new CheckBoxPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'CheckBox'", () -> {
            checkBoxPage.openWebPage(driver);
            driver.navigate().refresh();
        });

        step("Нажать на ссылку открытия всего дерева чек-боксов", () -> {
            checkBoxPage.openAllCheckBoxTree();
        });

        step("Нажать на корневой чек-бокс", () -> {
            checkBoxPage.clickRootCheckBox();
        });

        step("Нажать на все чек-боксы", () -> {
            checkBoxPage.checkAllCheckBoxes(driver, actions);
        });

        step("Получить лейблы чек-босов", () -> {
            checkBoxPage.takeAllLabels();
        });

        step("Сравнить полученные лейблы с выводом в блоке 'You have selected'", () -> {
            Assertions.assertEquals(checkBoxPage.getAllSelectedLabels(),
                    checkBoxPage.getListOfResultLabels());
        });
    }
}
