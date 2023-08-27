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

    @FindBy(className = "rct-collapse-btn")
    public WebElement collapseButton;

    @FindBy(css = "span.rct-checkbox")
    public WebElement mainCheckbox;

    @FindBy(css = ".rct-icon.rct-icon-check")
    public WebElement mainCheckBoxIsChecked;

    @FindBy(css = ".rct-node.rct-node-parent.rct-node-collapsed")
    public List<WebElement> nodeCheckBoxes;

    @FindBy(css = ".rct-icon.rct-icon-expand-close")
    public List<WebElement> nodeButtons;


    @FindBy (css = "svg.rct-icon.rct-icon-expand-close > path")
    public List<WebElement> innerNodeButtons;
    @FindBy (css = "svg.rct-icon.rct-icon-expand-close > path")
    public WebElement innerNode;

    @FindBy (xpath = "//input[@type='checkbox']")
    public List<WebElement> checkboxCount;

    @FindBy (className = "rct-title")
    public List<WebElement> allActiveLabels;

    @FindBy (xpath = "//span[@class='text-success']")
    public List<WebElement> searchPanel;



    public CheckBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
