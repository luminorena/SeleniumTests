package selenium.practice.seleniumtests.Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.practice.seleniumtests.Pages.ButtonsPage;

import static io.qameta.allure.Allure.step;

public class ButtonsTests extends TestBase{
    ButtonsPage buttonsPage;

    @DisplayName("Проверка блока Buttons")
    @Test
    void buttonsTest(){
        buttonsPage = new ButtonsPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Buttons'", () -> {
          buttonsPage.openButtonsPage(js);
        });

        step("Проверка кнопки 'Double Click Me'", () -> {
            buttonsPage.checkDoubleClick(actions);

        });

        step("Проверка кнопки 'Right Click Me'", () -> {
            buttonsPage.checkRightClick(actions);

        });

        step("Проверка кнопки 'Click Me'", () -> {
            buttonsPage.checkClickMe();

        });

    }
}
