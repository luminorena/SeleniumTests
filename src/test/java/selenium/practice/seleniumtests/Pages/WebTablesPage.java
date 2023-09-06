package selenium.practice.seleniumtests.Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import selenium.practice.seleniumtests.Data.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;


public class WebTablesPage {
    public WebDriver driver;
    public JavascriptExecutor js;
    public Actions actions;
    Person person = new Person();


    @FindBy(xpath = "//*[@id=\"linkWrapper\"]/h5/strong")
    public List<WebElement> title;
    // todo change public to private
    // todo should I create  getters/setters?

    @FindBy(className = "card-body")
    public WebElement elements;

    @FindBy(className = "text")
    public List<WebElement> textBox;

    @FindBy(className = "main-header")
    public WebElement getTitle;

    @FindBy(id = "addNewRecordButton")
    public WebElement addBtn;

    @FindBy(id = "registration-form-modal")
    public WebElement regFormTitle;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(id = "age")
    public WebElement age;

    @FindBy(id = "salary")
    public WebElement salary;

    @FindBy(id = "department")
    public WebElement department;

    @FindBy(id = "submit")
    public WebElement submit;

    @FindBy(css = "div.rt-tr-group .rt-td")
    public List<WebElement> webTableRow;

    @FindBy(css = ".rt-tr .rt-td")
    public List<WebElement> rowElement;

    @FindBy(className = "modal-open")
    public List<WebElement> titleForm;

    @FindBy(id = "edit-record-1")
    public WebElement editFirstGridRecord;

    @FindBy(id = "delete-record-1")
    public WebElement deleteFirstGridRecord;

    @FindBy(id = "searchBox")
    public WebElement searchInput;

    @FindBy(className = "input-group-append")
    public WebElement searchButton;

    @FindBy(tagName = "select")
    public WebElement selectRow;

    @FindBy(css = "div.-next")
    public WebElement nextBtn;


    public void fillForm(WebDriver driver) {
        int initialCount = countRows();
        firstName.sendKeys(person.name);
        lastName.sendKeys(person.lastName);
        userEmail.sendKeys(person.email);
        age.sendKeys(person.age);
        salary.sendKeys(person.salary);
        department.sendKeys(person.department);
        submit.click();
        int resultCount = countRows();
        int rowData = rowDataCount(rowElement);
        Assertions.assertEquals(initialCount + rowData, resultCount);
    }


    public void clearForm(WebDriver driver) {
        firstName.clear();
        lastName.clear();
        age.clear();
        salary.clear();
        department.clear();
    }


    public void fillFormAfterClean(WebDriver driver) {
        firstName.sendKeys(person.name);
        lastName.sendKeys(person.lastName);
        age.sendKeys(person.age);
        salary.sendKeys(person.salary);
        department.sendKeys(person.department);
        submit.click();
    }

    private int rowDataCount(List<WebElement> element) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (WebElement test : element) {
            if (Objects.equals(test.getText(), "")) {
                break;
            }
            arrayList.add(test.getText());
        }
        return arrayList.size();
    }

    private int countRows() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (WebElement rowsElement : webTableRow) {
            if (!Objects.equals(rowsElement.getText(), "")
                    && !Objects.equals(rowsElement.getText(), null)
                    && !Objects.equals(rowsElement.getText(), " ")) {
                arrayList.add(rowsElement.getText());
            }
        }
        return arrayList.size();
    }


    public void openLinksPage(JavascriptExecutor js) {
        this.js = js;
        js.executeScript("window.scrollBy(0,350)", "");
        elements.click();
        js.executeScript("window.scrollBy(0, 200)", "");
        textBox.get(3).click();
        Assertions.assertEquals("Web Tables", getTitle.getText());
    }

    public void editFirstRecord() {
        editFirstGridRecord.click();
        clearForm(driver);
        fillFormAfterClean(driver);
        boolean closedModal = !titleForm.isEmpty();
        Assertions.assertTrue(closedModal);
    }

    public void deleteFirstRecord() {
        int initialCount = countRows();
        deleteFirstGridRecord.click();
        int resultCount = countRows();
        int rowData = rowDataCount(rowElement);
        Assertions.assertEquals(initialCount - rowData, resultCount);

    }

    public void searchRecord() {
        ArrayList<String> arrayList;
        searchInput.sendKeys("Alden");
        searchButton.click();
        arrayList = showRows();
        System.out.println(arrayList);
        assertThat(arrayList, hasItem("Alden"));
    }

    private ArrayList<String> showRows() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (WebElement rowsElement : webTableRow) {
            if (!Objects.equals(rowsElement.getText(), "")
                    && !Objects.equals(rowsElement.getText(), null)
                    && !Objects.equals(rowsElement.getText(), " ")) {
                arrayList.add(rowsElement.getText());
            }
        }
        return arrayList;
    }

    public void clickAddButton(WebDriver driver) {
        actions = new Actions(driver);
        actions.moveToElement(addBtn).click().perform();
        driver.manage().timeouts().getScriptTimeout();
        // todo fluky test: вот тут периодически падает
        Assertions.assertEquals("Registration Form",
               regFormTitle.getText());
    }

    public void fillFormSeveralTimes(WebDriver driver) {
        for (int i = 0; i < 4; i ++) {
            clickAddButton(driver);
            fillForm(driver);
        }

        Select dropRow = new Select(selectRow);
        dropRow.selectByValue("5");
        nextBtn.click();

        int rowData = rowDataCount(rowElement);
        Assertions.assertEquals(5, rowData - 1);

    }

    public WebTablesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
