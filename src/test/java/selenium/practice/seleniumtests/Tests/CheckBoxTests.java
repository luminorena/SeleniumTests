package selenium.practice.seleniumtests.Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import selenium.practice.seleniumtests.Pages.CheckBoxPage;

import static io.qameta.allure.Allure.step;

public class CheckBoxTests extends TestBase {
    CheckBoxPage checkBoxPage;

    @DisplayName("Проверить блок чекбоксов 'Expand All'")
    @Test
    void expandAllCheckBoxTest() {
        checkBoxPage = new CheckBoxPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'CheckBox'", () -> {
            checkBoxPage.openCheckBoxPage(js);
            driver.navigate().refresh();
        });

        step("Нажать на чекбокс 'Expand All'", () -> {
            checkBoxPage.checkExpandAllCheckBox();
        });

        step("Проверка чекбокса 'Expand All'", () -> {
            boolean displayed = checkBoxPage.getExpandAllVisible().isDisplayed();
            Assertions.assertTrue(displayed);
        });
    }


    @DisplayName("Проверить блок чекбоксов 'Collapse All'")
    @Test
    void collapseAllCheckBoxTest() {
        checkBoxPage = new CheckBoxPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'CheckBox'", () -> {
            checkBoxPage.openCheckBoxPage(js);
            driver.navigate().refresh();
        });

        step("Нажать на чекбокс 'Collapse All'", () -> {
            checkBoxPage.checkCollapseAllCheckBox();
        });

        step("Проверка чекбокса 'Collapse All'", () -> {
            boolean displayed = checkBoxPage.getCollapseAllVisible().isDisplayed();
            Assertions.assertTrue(displayed);
        });
    }


    @DisplayName("Проверить выбор корневого чекбокса")
    @Test
    void allCheckBoxesAreCheckedTest() {
        checkBoxPage = new CheckBoxPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'CheckBox'", () -> {
            checkBoxPage.openCheckBoxPage(js);
            driver.navigate().refresh();
        });

        step("Нажать на ссылку открытия всего дерева чекбоксов", () -> {
            checkBoxPage.openAllCheckBoxTree();
        });

        step("Нажать на корневой чекбокс", () -> {
            checkBoxPage.checkRootCheckBox();
        });

        step("Проверить, что корневой чекбокс находится в состоянии 'checked'", () -> {
            Assertions.assertTrue(checkBoxPage.getMainCheckBoxIsChecked().isDisplayed());
        });
    }


    @DisplayName("Проверить выбор всех чекбоксов")
    @Test
    void checkAllCheckBoxesState() {
        checkBoxPage = new CheckBoxPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'CheckBox'", () -> {
            checkBoxPage.openCheckBoxPage(js);
            driver.navigate().refresh();
        });

        step("Нажать на ссылку открытия всего дерева чекбоксов", () -> {
            checkBoxPage.openAllCheckBoxTree();
        });

        step("Нажать на корневой чекбокс", () -> {
            checkBoxPage.checkRootCheckBox();
        });

        step("Нажать на все чекбоксы", () -> {
            checkBoxPage.checkAllCheckBoxes(driver, actions);
        });

        step("Проверить, что все чекбоксы в состоянии 'checked' ", () -> {
            for (WebElement w : checkBoxPage.getCheckboxCount()) {
                Assertions.assertTrue(w.isSelected());
            }
        });
    }

    @DisplayName("Проверить отображение лейблов чекбоксов")
    @Test
    void checkLabelsView() {
        checkBoxPage = new CheckBoxPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'CheckBox'", () -> {
            checkBoxPage.openCheckBoxPage(js);
            driver.navigate().refresh();
        });

        step("Нажать на ссылку открытия всего дерева чекбоксов", () -> {
            checkBoxPage.openAllCheckBoxTree();
        });

        step("Нажать на корневой чекбокс", () -> {
            checkBoxPage.checkRootCheckBox();
        });

        step("Нажать на все чекбоксы", () -> {
            checkBoxPage.checkAllCheckBoxes(driver, actions);
        });

        step("Получить лейблы чекбосов", () -> {
            checkBoxPage.takeAllLabels();
        });

        step("Сравнить полученные лейблы с выводом в блоке 'You have selected'", () -> {
            Assertions.assertEquals(checkBoxPage.getAllActiveLabels(),
                    checkBoxPage.getSearchPanel());
        });
    }

}













