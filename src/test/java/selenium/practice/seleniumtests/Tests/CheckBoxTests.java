package selenium.practice.seleniumtests.Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.practice.seleniumtests.Pages.CheckBoxPage;


import static io.qameta.allure.Allure.step;

public class CheckBoxTests extends TestBase{
    CheckBoxPage checkBoxPage;


    @Test
    public void checkboxTests() {
        checkBoxPage = new CheckBoxPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'CheckBox'", () -> {
            js.executeScript("window.scrollBy(0,350)", "");
            checkBoxPage.elements.click();
            js.executeScript("window.scrollBy(0,-350)", "");
            checkBoxPage.textBox.get(1).click();
        });

        step("Проверка кнопки 'Expand All'", () -> {
            checkBoxPage.expandAll.click();
            boolean displayed = checkBoxPage.expandAllVisible.isDisplayed();
            Assertions.assertTrue(displayed);
        });

        step("Проверка кнопки 'Collapse All'", () -> {
            checkBoxPage.collapseAll.click();
            boolean displayed = checkBoxPage.collapseAllVisible.isDisplayed();
            Assertions.assertTrue(displayed);
        });




    }

}
