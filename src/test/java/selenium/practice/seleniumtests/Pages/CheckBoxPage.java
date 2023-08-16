package selenium.practice.seleniumtests.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckBoxPage {
    @FindBy(className = "card-body")
    public WebElement elements;

    @FindBy(className = "text")
    public List<WebElement> textBox;

    @FindBy(className = "rct-icon-expand-all")
    public WebElement expandAll;

    @FindBy(className = "rct-icon-expand-open")
    public WebElement expandAllVisible;

    @FindBy(className = "rct-icon-collapse-all")
    public WebElement collapseAll;

    @FindBy(className = "rct-node-collapsed")
    public WebElement collapseAllVisible;

    public CheckBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
