package selenium.practice.seleniumtests.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.practice.seleniumtests.pages.ButtonsPage;
import selenium.practice.seleniumtests.TestBase;

import static io.qameta.allure.Allure.step;

public class ButtonsTests extends TestBase {
    ButtonsPage buttonsPage;
    @DisplayName("Проверка нажатия кнопки 'Double Click Me'")
    @Test
    void doubleClickButtonTest() {
        buttonsPage = new ButtonsPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Buttons'", () -> {
            buttonsPage.openButtonsPage(js);
        });

        step("Нажать на кнопку 'Double Click Me'", () -> {
            buttonsPage.clickDouble(actions);
        });

        step("Проверить кнопку 'Double Click Me'", () -> {
            Assertions.assertEquals(buttonsPage.getDoubleClickValidation().getText(),
                    "You have done a double click");
        });
    }

    @DisplayName("Проверка нажатия кнопки 'Right Click Me'")
    @Test
    void rightClickButtonTest() {
        buttonsPage = new ButtonsPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Buttons'", () -> {
            buttonsPage.openButtonsPage(js);
        });

        step("Нажать на кнопку 'Right Click Me'", () -> {
            buttonsPage.clickRight(actions);
        });

        step("Проверить кнопку 'Right Click Me'", () -> {
            Assertions.assertEquals(buttonsPage.getContextMenuValidation().getText(),
                    "You have done a right click");
        });
    }

    @DisplayName("Проверка нажатия кнопки 'Click Me'")
    @Test
    void clickMeButtonTest() {
        buttonsPage = new ButtonsPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Buttons'", () -> {
            buttonsPage.openButtonsPage(js);
        });

        step("Нажать на кнопку 'Click Me'", () -> {
            buttonsPage.clickClickMe();
        });

        step("Проверить кнопку 'Click Me'", () -> {
            Assertions.assertEquals(buttonsPage.getClickValidation().getText(),
                    "You have done a dynamic click");
        });
    }
}
