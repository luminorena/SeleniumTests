package selenium.practice.seleniumtests.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementsPage {

    @FindBy(id = "app")
    public WebElement link;

    @FindBy(className = "card-body")
    public WebElement elements;

    @FindBy(className = "text")
    public WebElement textBox;

    @FindBy(id = "userName")
    public WebElement userName;

    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddress;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "output")
    public WebElement textContainer;

    @FindBy(id = "name")
    public WebElement nameResultField;

    @FindBy(id = "email")
    public WebElement emailResultField;

    @FindBy(id = "currentAddress")
    public List<WebElement> currentAddressResultField;

    @FindBy(id = "permanentAddress")
    public List<WebElement> permanentAddressResultField;


    public ElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }





}
