package selenium.practice.seleniumtests.Tests;

import org.junit.jupiter.api.Assertions;
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
            js.executeScript("window.scrollBy(0,350)", "");
            buttonsPage.elements.click();
            js.executeScript("window.scrollBy(0, 200)", "");
            buttonsPage.textBox.get(4).click();
        });

        step("Проверка кнопки 'Double Click Me'", () -> {
            actions.doubleClick(buttonsPage.doubleClickElement).perform();
            Assertions.assertEquals(buttonsPage.doubleClickValidation.getText(),
                    "You have done a double click");

        });

        step("Проверка кнопки 'Right Click Me'", () -> {
            actions.contextClick(buttonsPage.rightClickElement).perform();
            Assertions.assertEquals(buttonsPage.contextMenuValidation.getText(),
                    "You have done a right click");

        });

        step("Проверка кнопки 'Click Me'", () -> {
            buttonsPage.clickElement.get(2).click();
            Assertions.assertEquals(buttonsPage.clickValidation.getText(),
                    "You have done a dynamic click");

        });

    }
}
