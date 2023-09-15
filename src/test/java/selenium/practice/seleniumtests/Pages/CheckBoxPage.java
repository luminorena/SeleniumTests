package selenium.practice.seleniumtests.Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class CheckBoxPage {
    public WebDriver driver;
    public JavascriptExecutor js;
    public Actions actions;
    @FindBy(className = "card-body")
    private WebElement elements;

    @FindBy(className = "text")
    private List<WebElement> textBox;

    @FindBy(className = "rct-icon-expand-all")
    private WebElement expandAll;

    @FindBy(className = "rct-icon-expand-open")
    private WebElement expandAllVisible;

    @FindBy(className = "rct-icon-collapse-all")
    private WebElement collapseAll;

    @FindBy(className = "rct-node-collapsed")
    private WebElement collapseAllVisible;

    @FindBy(className = "rct-collapse-btn")
    private WebElement collapseButton;

    @FindBy(css = "span.rct-checkbox")
    private WebElement mainCheckbox;

    @FindBy(css = ".rct-icon.rct-icon-check")
    private WebElement mainCheckBoxIsChecked;

    @FindBy(css = ".rct-node.rct-node-parent.rct-node-collapsed")
    private List<WebElement> nodeCheckBoxes;

    @FindBy(css = ".rct-icon.rct-icon-expand-close")
    private List<WebElement> nodeButtons;


    @FindBy(css = "svg.rct-icon.rct-icon-expand-close > path")
    private List<WebElement> innerNodeButtons;
    @FindBy(css = "svg.rct-icon.rct-icon-expand-close > path")
    private WebElement innerNode;

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkboxCount;

    @FindBy(className = "rct-title")
    private List<WebElement> allActiveLabels;

    @FindBy(xpath = "//span[@class='text-success']")
    private List<WebElement> searchPanel;

    public void openCheckBoxPage(JavascriptExecutor js) {
        this.js = js;
        js.executeScript("window.scrollBy(0,350)", "");
        elements.click();
        js.executeScript("window.scrollBy(0,-350)", "");
        textBox.get(1).click();
    }

    public void checkExpandAll() {
        expandAll.click();
        boolean displayed = expandAllVisible.isDisplayed();
        Assertions.assertTrue(displayed);
    }

    public void checkCollapseAll() {
        collapseAll.click();
        boolean displayed = collapseAllVisible.isDisplayed();
        Assertions.assertTrue(displayed);
    }

    public void openAllCheckBoxTree() {
        collapseButton.click();
    }

    public void checkRootCheckBox() {
        mainCheckbox.click();
        Assertions.assertTrue(mainCheckBoxIsChecked.isDisplayed());
    }

    public void checkAllCheckBoxes(WebDriver driver, Actions actions) {
        this.driver = driver;
        this.actions = actions;

        for (int i = 0; i < 3; i++) {
            nodeCheckBoxes.get(i).click();
        }

        List<WebElement> innerOpenList = driver
                .findElements(cssSelector(".rct-icon.rct-icon-expand-close"));

        innerOpenList.get(0).click();
        innerOpenList.get(1).click();
        innerOpenList.get(2).click();

        actions.moveToElement(innerNodeButtons.get(1)).click().perform();
        actions.moveToElement(innerNode).click().build().perform();

        for (WebElement w : checkboxCount) {
            Assertions.assertTrue(w.isSelected());
        }
    }

    public void takeAllLabels() {
        ArrayList<String> allActiveLabels = new ArrayList<>();

        for (String labs : allActiveLabels) {
            allActiveLabels.add(labs.toLowerCase()
                    .replace(".doc", "")
                    .replace(" ", ""));


        }

        ArrayList<String> searchPanel = new ArrayList<>();

        for (String res : searchPanel) {
            searchPanel.add(res.toLowerCase());
        }

        Assertions.assertEquals(allActiveLabels, searchPanel);

    }


    public CheckBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
