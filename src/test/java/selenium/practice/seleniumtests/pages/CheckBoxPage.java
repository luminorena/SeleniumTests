package selenium.practice.seleniumtests.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.practice.seleniumtests.TestBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.openqa.selenium.By.cssSelector;

public class CheckBoxPage extends TestBase {
    private final String URL_WEBPAGE = getBaseUrl() + "checkbox";
    public WebDriver driver;

    private ArrayList<String> allSelectedLabels = new ArrayList<>();
    private ArrayList<String> listOfResultLabels = new ArrayList<>();

    public ArrayList<String> getAllSelectedLabels() {
        return allSelectedLabels;
    }

    public ArrayList<String> getListOfResultLabels() {
        return listOfResultLabels;
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
    private WebElement mainCheckBox;

    public WebElement getMainCheckBox() {
        return mainCheckBox;
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
    private List<WebElement> checkboxList;

    public List<WebElement> getCheckboxList() {
        return checkboxList;
    }

    @Step("Open web-page")
    public void openWebPage(WebDriver driver) {
        try {
            System.out.println(URL_WEBPAGE);
            driver.get(URL_WEBPAGE);
        } catch (NoSuchElementException e) {
            // add to allure
            System.out.println("WebPage is not open");
        }
    }

    public void clickExpandAllCheckBox() {
        expandAll.click();
    }

    public void clickCollapseAllCheckBox() {
        collapseAll.click();
    }

    public void openAllCheckBoxTree() {
        collapseButton.click();
    }

    public void clickRootCheckBox() {
        mainCheckbox.click();
    }

    public void checkAllCheckBoxes(WebDriver driver, Actions actions) {

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
        for (String labs : allSelectedLabels) {
            allSelectedLabels.add(labs.toLowerCase()
                    .replace(".doc", "")
                    .replace(" ", ""));
        }

        for (String res : listOfResultLabels) {
            listOfResultLabels.add(res.toLowerCase());
        }
    }

    public CheckBoxPage(WebDriver driver) throws IOException {
        PageFactory.initElements(driver, this);
    }

}
