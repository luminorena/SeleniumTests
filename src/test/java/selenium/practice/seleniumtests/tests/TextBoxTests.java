package selenium.practice.seleniumtests.tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.practice.seleniumtests.pages.ElementsPage;
import selenium.practice.seleniumtests.TestBase;

import java.io.IOException;

import static io.qameta.allure.Allure.step;


public class TextBoxTests extends TestBase {
    ElementsPage elementsPage;

    //todo разобраться со структурой тестов и страниц

    @DisplayName("Проверка блока TextBox - нашлась бага в орфографии")
    @Test
    public void textBoxTests() throws IOException {
        elementsPage = new ElementsPage(driver);

        step("Перейти в блок 'Elements' и выбрать 'TextBox'", () -> {
           elementsPage.openTextBoxPage(driver);
        });

        step("Заполнить форму и проверить правильность введённых данных", () -> {
            elementsPage.fillForm(js);
        });





    }
}
