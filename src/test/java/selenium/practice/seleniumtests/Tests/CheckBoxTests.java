package selenium.practice.seleniumtests.Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import selenium.practice.seleniumtests.Pages.CheckBoxPage;

import java.util.ArrayList;
import java.util.List;

import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.cssSelector;

public class CheckBoxTests extends TestBase {
    CheckBoxPage checkBoxPage;


    @DisplayName("Проверка блока CheckBox")
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

        step("Нажать на ссылку открытия всего дерева чекбоксов", () -> {
            checkBoxPage.collapseButton.click();
        });

        step("Нажать на корневой чекбокс и проверить его состояние 'checked'", () -> {
            checkBoxPage.mainCheckbox.click();
            Assertions.assertTrue(checkBoxPage.mainCheckBoxIsChecked.isDisplayed());
        });

        step("Нажать на все чекбоксы и проверить, что они в состоянии 'checked' ", () -> {

            for (int i = 0; i < 3; i++) {
                checkBoxPage.nodeCheckBoxes.get(i).click();
            }

            List<WebElement> innerOpenList = driver
                    .findElements(cssSelector(".rct-icon.rct-icon-expand-close"));

            innerOpenList.get(0).click();
            innerOpenList.get(1).click();
            innerOpenList.get(2).click();

            actions.moveToElement(checkBoxPage.innerNodeButtons.get(1)).click().perform();
            actions.moveToElement(checkBoxPage.innerNode).click().build().perform();

            for (WebElement w : checkBoxPage.checkboxCount) {
                Assertions.assertTrue(w.isSelected());
            }


        });

        step("Получить лейблы чекбосов и сравнить с выводом в блоке 'You have selected'", () -> {

            ArrayList<String> allActiveLabels = new ArrayList<>();

            for (WebElement labs : checkBoxPage.allActiveLabels) {
                allActiveLabels.add(labs.getText().toLowerCase().replace(".doc", "").replace(" ", ""));
            }

            ArrayList<String> searchPanel = new ArrayList<>();

            for (WebElement res : checkBoxPage.searchPanel) {
                searchPanel.add(res.getText().toLowerCase());
            }

            Assertions.assertEquals(allActiveLabels, searchPanel);

        });

    }

}













