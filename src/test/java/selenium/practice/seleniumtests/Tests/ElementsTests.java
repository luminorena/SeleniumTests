package selenium.practice.seleniumtests.Tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.practice.seleniumtests.Pages.ElementsPage;

import static io.qameta.allure.Allure.step;


public class ElementsTests extends TestBase {
    ElementsPage elementsPage;


    @DisplayName("Проверка блока TextBox")
    @Test
    public void textBoxTests() {
        elementsPage = new ElementsPage(driver);

        step("Перейти в блок 'Elements' и выбрать 'TextBox'", () -> {
           elementsPage.clickTextBox(js);
        });

        step("Заполнить форму и проверить правильность введённых данных", () -> {
            elementsPage.fillForm(js);
        });

    }



}
