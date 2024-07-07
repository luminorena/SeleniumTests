package selenium.practice.seleniumtests.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.practice.seleniumtests.pages.RadioButtonPage;
import selenium.practice.seleniumtests.TestBase;

import java.io.IOException;

import static io.qameta.allure.Allure.step;


public class RadioButtonTests extends TestBase {
    RadioButtonPage radioButtonPage;

    @Test
    @DisplayName("Проверка радиокнопки 'Yes'")
    public void radioButtonYesTest() throws IOException {
        radioButtonPage = new RadioButtonPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'RadioButton'", () -> {
            radioButtonPage.openRadioButtonsPage(driver);
            driver.navigate().refresh();
        });

        step("Нажать на радиокнопку 'Yes'", () -> {
            radioButtonPage.clickYesRadioButton(driver, actions);
        });

        step("Проверить отображение радиокнопки 'Yes'", () -> {
            Assertions.assertEquals("Yes",
                    radioButtonPage.getSuccessResult().getText());
        });

    }


    @DisplayName("Проверка радиокнопки 'Impressive'")
    @Test
    public void radioButtonImpressiveTest() throws IOException {
        radioButtonPage = new RadioButtonPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'RadioButton'", () -> {
            radioButtonPage.openRadioButtonsPage(driver);
        });

        step("Нажать на радиокнопку 'Impressive'", () -> {
            radioButtonPage.clickImpressiveButton(driver, actions);
        });

        step("Проверить отображение радиокнопки 'Impressive'", () -> {
            Assertions.assertEquals("Impressive",
                    radioButtonPage.getSuccessResult().getText());
        });
    }

    @Test
    @DisplayName("Проверка радиокнопки 'No'")
    public void radioButtonNoTest() throws IOException {
        radioButtonPage = new RadioButtonPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'RadioButton'", () -> {
            radioButtonPage.openRadioButtonsPage(driver);
        });

        step("Нажать на радиокнопку 'No'", () -> {
           radioButtonPage.clickNoButton(driver, actions);
        });

        step("Проверить отображение радиокнопки 'No'", () -> {
            Assertions.assertFalse(radioButtonPage.isEnabled());
        });
    }
}
