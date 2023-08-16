package selenium.practice.seleniumtests.Tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.practice.seleniumtests.Data.Person;
import selenium.practice.seleniumtests.Pages.ElementsPage;

import static io.qameta.allure.Allure.step;


public class ElementsTests extends TestBase {
    ElementsPage elementsPage;
    Person person = new Person();

    @DisplayName("Проверка блока TextBox")
    @Test
    public void textBoxTests() {
        elementsPage = new ElementsPage(driver);

        step("Нажать на ссылку 'Tools QA'", () -> {
            elementsPage.link.click();
        });

        step("Просколить на середину страницы", () -> {
            js.executeScript("window.scrollBy(0,350)", "");
        });

        step("Перейти в блок 'Elements' и выбрать 'TextBox'", () -> {
            elementsPage.elements.click();
            elementsPage.textBox.click();
        });

        step("Ввести данные в поле ввода: Full Name", () -> {
            elementsPage.userName.sendKeys(person.name);
        });

        step("Ввести данные в поле ввода: Email", () -> {
            elementsPage.userEmail.sendKeys(person.email);
        });

        step("Ввести данные в поле ввода: Current Address", () -> {
            elementsPage.currentAddress.sendKeys(person.firstAddress);
        });

        step("Просколить на середину страницы", () -> {
            js.executeScript("window.scrollBy(0,350)", "");
        });

        step("Ввести данные в поле ввода: Permanent Address", () -> {
            elementsPage.permanentAddress.sendKeys(person.secondAddress);
        });

        step("Нажать на кнопку 'Submit'", () -> {
            elementsPage.submitButton.click();
        });

        step("Проверить, что блок с заполненными данными выводится", () -> {
            elementsPage.textContainer.isDisplayed();
        });

        step("Проверить, что поля формы заполнены корректно", () -> {
            Assertions.assertEquals("Name:" + person.name, elementsPage.nameResultField.getText());
            Assertions.assertEquals("Email:" + person.email, elementsPage.emailResultField.getText());
            Assertions.assertEquals("Current Address :" + person.firstAddress, elementsPage.currentAddressResultField.get(1).getText());
            Assertions.assertEquals("Permananet Address :" + person.secondAddress, elementsPage.permanentAddressResultField.get(1).getText());
        });

    }



}
