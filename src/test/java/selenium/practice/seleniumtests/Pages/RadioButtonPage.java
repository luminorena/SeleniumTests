package selenium.practice.seleniumtests.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButtonPage {

    @FindBy(className = "card-body")
    public WebElement elements;

    @FindBy(className = "text")
    public List<WebElement> textBox;

    @FindBy(id = "yesRadio")
    public WebElement yesRadioButton;

    @FindBy(className = "text-success")
    public WebElement successResultYesRadio;

    @FindBy(id = "impressiveRadio")
    public WebElement impressiveRadio;

    @FindBy(className = "text-success")
    public WebElement successResultImpressive;

    @FindBy(id = "noRadio")
    public WebElement noRadio;


    public RadioButtonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
