package selenium.practice.seleniumtests.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ButtonsPage {
    @FindBy(className = "card-body")
    public WebElement elements;

    @FindBy(className = "text")
    public List<WebElement> textBox;

    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickElement;

    @FindBy(id = "doubleClickMessage")
    public WebElement doubleClickValidation;

    @FindBy(id = "rightClickBtn")
    public WebElement rightClickElement;

    @FindBy(id = "rightClickMessage")
    public WebElement contextMenuValidation;

    @FindBy(css = ".btn.btn-primary")
    public List<WebElement> clickElement;

    @FindBy(id = "dynamicClickMessage")
    public WebElement clickValidation;



    public ButtonsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
