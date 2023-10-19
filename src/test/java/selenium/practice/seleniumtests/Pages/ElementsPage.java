package selenium.practice.seleniumtests.Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.practice.helpers.GetElementsHelper;
import selenium.practice.seleniumtests.Data.Person;

import java.util.List;

public class ElementsPage {
    public WebDriver driver;
    public JavascriptExecutor js;
    public Actions actions;
    Person person = new Person();

    @FindBy(id = "app")
    private WebElement link;

    @FindBy(className = "card-body")
    private WebElement elements;

    @FindBy(className = "text")
    private List<WebElement> textBox;

    @FindBy(id = "userName")
    private WebElement userName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "currentAddress")
    private WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddress;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "output")
    private WebElement textContainer;

    @FindBy(id = "name")
    private WebElement nameResultField;

    @FindBy(id = "email")
    private WebElement emailResultField;

    @FindBy(id = "currentAddress")
    private List<WebElement> currentAddressResultField;

    @FindBy(id = "permanentAddress")
    private List<WebElement> permanentAddressResultField;

    GetElementsHelper getElementsHelper = new GetElementsHelper();

    public void clickTextBox(JavascriptExecutor js) {
        link.click();
        js.executeScript("window.scrollBy(0,350)", "");
        elements.click();
        textBox.get(getElementsHelper.getElementsBlockItem("Text Box")).click();
    }

    public void fillForm(JavascriptExecutor js) {
        userName.sendKeys(person.name);
        userEmail.sendKeys(person.email);
        currentAddress.sendKeys(person.firstAddress);
        js.executeScript("window.scrollBy(0,350)", "");
        permanentAddress.sendKeys(person.secondAddress);
        submitButton.click();
        textContainer.isDisplayed();

        Assertions.assertEquals("Name:" + person.name, nameResultField.getText());
        Assertions.assertEquals("Email:" + person.email, emailResultField.getText());
        Assertions.assertEquals("Current Address :" + person.firstAddress, currentAddressResultField.get(1).getText());
        Assertions.assertEquals("Permanent Address :" + person.secondAddress, permanentAddressResultField.get(1).getText());
    }


    public ElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }





}
