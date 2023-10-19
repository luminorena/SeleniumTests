package selenium.practice.seleniumtests.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.practice.helpers.GetElementsHelper;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class CheckBoxPage {
    public WebDriver driver;
    public JavascriptExecutor js;
    public Actions actions;

    private ArrayList<String> allActiveLabels = new ArrayList<>();
    private ArrayList<String> searchPanel = new ArrayList<>();

    public WebDriver getDriver() {
        return driver;
    }

    public ArrayList<String> getAllActiveLabels() {
        return allActiveLabels;
    }

    public ArrayList<String> getSearchPanel() {
        return searchPanel;
    }

    @FindBy(className = "card-body")
    private WebElement elements;

    @FindBy(className = "text")
    private List<WebElement> textBox;

    @FindBy(className = "rct-icon-expand-all")
    private WebElement expandAll;

    @FindBy(className = "rct-icon-expand-open")
    private WebElement expandAllVisible;

    public WebElement getExpandAllVisible() {
        return expandAllVisible;
    }

    @FindBy(className = "rct-icon-collapse-all")
    private WebElement collapseAll;

    @FindBy(className = "rct-node-collapsed")
    private WebElement collapseAllVisible;

    public WebElement getCollapseAllVisible() {
        return collapseAllVisible;
    }

    @FindBy(className = "rct-collapse-btn")
    private WebElement collapseButton;

    @FindBy(css = "span.rct-checkbox")
    private WebElement mainCheckbox;

    @FindBy(css = ".rct-icon.rct-icon-check")
    private WebElement mainCheckBoxIsChecked;

    public WebElement getMainCheckBoxIsChecked() {
        return mainCheckBoxIsChecked;
    }

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

    public List<WebElement> getCheckboxCount() {
        return checkboxCount;
    }

    GetElementsHelper getElementsHelper = new GetElementsHelper();

    public void openCheckBoxPage(JavascriptExecutor js) {
        js.executeScript("window.scrollBy(0,350)", "");
        elements.click();
        js.executeScript("window.scrollBy(0,-350)", "");
        textBox.get(getElementsHelper.getElementsBlockItem("Check Box")).click();
    }



    public void checkExpandAllCheckBox(){
        expandAll.click();
    }



    public void checkCollapseAllCheckBox() {
        collapseAll.click();
    }

    public void openAllCheckBoxTree() {
        collapseButton.click();
    }

    public void checkRootCheckBox() {
        mainCheckbox.click();
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

    }



    public void takeAllLabels() {
        //ArrayList<String> allActiveLabels = new ArrayList<>();

        for (String labs : allActiveLabels) {
            allActiveLabels.add(labs.toLowerCase()
                    .replace(".doc", "")
                    .replace(" ", ""));


        }

//        ArrayList<String> searchPanel = new ArrayList<>();

        for (String res : searchPanel) {
            searchPanel.add(res.toLowerCase());
        }

       // Assertions.assertEquals(allActiveLabels, searchPanel);

    }


    public CheckBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
