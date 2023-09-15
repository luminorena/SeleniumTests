package selenium.practice.seleniumtests.Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.practice.seleniumtests.Pages.RadioButtonPage;

import static io.qameta.allure.Allure.step;


public class RadioButtonTests extends TestBase {
    RadioButtonPage radioButtonPage;

    @Test
    @DisplayName("Проверка радиокнопки 'Yes'")
    public void radioButtonYesTest() {
        radioButtonPage = new RadioButtonPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'RadioButton'", () -> {
          radioButtonPage.openRadioButtonPage(js);
        });

        step("Нажать на радиокнопку 'Yes' и проверить её отображение", () -> {
            radioButtonPage.checkYesRadioButton(driver, actions);
        });
    }


    @DisplayName("Проверка радиокнопки 'Impressive'")
    @Test
    public void radioButtonImpressiveTest() {
        radioButtonPage = new RadioButtonPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'RadioButton'", () -> {
            radioButtonPage.openRadioButtonPage(js);
        });

        step("Нажать на радиокнопку 'Impressive' и проверить её отображение", () -> {
            radioButtonPage.checkImpressiveButton(driver, actions);
        });
    }

    @Test
    @DisplayName("Проверка радиокнопки 'No'")
    public void radioButtonNoTest() {
        radioButtonPage = new RadioButtonPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'RadioButton'", () -> {
            radioButtonPage.openRadioButtonPage(js);
        });

        step("Нажать на радиокнопку 'No' и проверить её отображение", () -> {
           radioButtonPage.checkNoButton(driver, actions);
        });
    }
}
