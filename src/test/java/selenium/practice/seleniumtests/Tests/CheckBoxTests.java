package selenium.practice.seleniumtests.Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.practice.seleniumtests.Pages.CheckBoxPage;

import static io.qameta.allure.Allure.step;

public class CheckBoxTests extends TestBase {
    CheckBoxPage checkBoxPage;


    @DisplayName("Проверка блока CheckBox")
    @Test
    public void checkboxTests() {
        checkBoxPage = new CheckBoxPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'CheckBox'", () -> {
            checkBoxPage.openCheckBoxPage(js);
        });

        step("Проверка кнопки 'Expand All'", () -> {
            checkBoxPage.checkExpandAll();
        });

        step("Проверка кнопки 'Collapse All'", () -> {
            checkBoxPage.checkCollapseAll();
        });

        step("Нажать на ссылку открытия всего дерева чекбоксов", () -> {
            checkBoxPage.openAllCheckBoxTree();
        });

        step("Нажать на корневой чекбокс и проверить его состояние 'checked'", () -> {
            checkBoxPage.checkRootCheckBox();
        });

        step("Нажать на все чекбоксы и проверить, что они в состоянии 'checked' ", () -> {
            checkBoxPage.checkAllCheckBoxes(driver, actions);
        });

        step("Получить лейблы чекбосов и сравнить с выводом в блоке 'You have selected'", () -> {
                    checkBoxPage.takeAllLabels();

                }
        );

    }

}













