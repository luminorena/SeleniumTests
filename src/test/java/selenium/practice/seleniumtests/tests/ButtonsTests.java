package selenium.practice.seleniumtests.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.practice.seleniumtests.pages.ButtonsPage;
import selenium.practice.seleniumtests.TestBase;

import java.io.IOException;
import java.time.Duration;

import static io.qameta.allure.Allure.step;

public class ButtonsTests extends TestBase {
    ButtonsPage buttonsPage;
    @DisplayName("Проверка нажатия кнопки 'Double Click Me'")
    @Test
    void doubleClickButtonTest() throws IOException {
        buttonsPage = new ButtonsPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Buttons'", () -> {
            buttonsPage.openButtonsPage(driver);
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
    void rightClickButtonTest() throws IOException {
        buttonsPage = new ButtonsPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Buttons'", () -> {
            buttonsPage.openButtonsPage(driver);
        });

        step("Нажать на кнопку 'Right Click Me'", () -> {
            buttonsPage.clickRight(actions);
        });

        step("Проверить кнопку 'Right Click Me'", () -> {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions
                                    .visibilityOf(buttonsPage.getContextMenuValidation()));
            Assertions.assertEquals(buttonsPage.getContextMenuValidation().getText(),
                    "You have done a right click");

        });
    }

    @DisplayName("Проверка нажатия кнопки 'Click Me'")
    @Test
    void clickMeButtonTest() throws IOException {
        buttonsPage = new ButtonsPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Buttons'", () -> {
            buttonsPage.openButtonsPage(driver);
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
