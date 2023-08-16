package selenium.practice.seleniumtests.Tests;

import org.junit.jupiter.api.Assertions;
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
            js.executeScript("window.scrollBy(0,350)", "");
            radioButtonPage.elements.click();
            js.executeScript("window.scrollBy(0,-350)", "");
            radioButtonPage.textBox.get(2).click();
        });

        step("Нажать на радиокнопку 'Yes'", () -> {
            actions.moveToElement(radioButtonPage.yesRadioButton).click().perform();
        });

        step("Проверить, что при нажати на радиокнопку 'Yes' верно отображатеся её название", () -> {
            Assertions.assertEquals("Yes", radioButtonPage.successResultYesRadio.getText());
        });

    }


    @DisplayName("Проверка радиокнопки 'Impressive'")
    @Test
    public void radioButtonImpressiveTest() {
        radioButtonPage = new RadioButtonPage(driver);

        step("Перейти в блок 'Elements' и выбрать 'TextBox'", () -> {
            js.executeScript("window.scrollBy(0,350)", "");
            radioButtonPage.elements.click();
            js.executeScript("window.scrollBy(0,-350)", "");
            radioButtonPage.textBox.get(2).click();
        });

        step("Нажать на радиокнопку 'Impressive'", () -> {

            actions.moveToElement(radioButtonPage.impressiveRadio).click().perform();
        });

        step("Проверить, что при нажати на радиокнопку 'Impressive' верно отображатеся её название", () -> {
            Assertions.assertEquals("Impressive", radioButtonPage.successResultImpressive.getText());
        });

    }

    @Test
    @DisplayName("Проверка радиокнопки 'No'")
    public void radioButtonNoTest() {
        radioButtonPage = new RadioButtonPage(driver);

        step("Перейти в блок 'Elements' и выбрать 'TextBox'", () -> {
            js.executeScript("window.scrollBy(0,350)", "");
            radioButtonPage.elements.click();
            js.executeScript("window.scrollBy(0,-350)", "");
            radioButtonPage.textBox.get(2).click();
        });

        step("Нажать на радиокнопку 'No'", () -> {
            actions.moveToElement(radioButtonPage.noRadio).click().perform();
        });

        step("Проверить, что при нажати на радиокнопку 'No' она задизейблена", () -> {
            boolean enabled = radioButtonPage.noRadio.isEnabled();
            Assertions.assertFalse(enabled);
        });
    }
}
