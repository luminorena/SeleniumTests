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

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Thread.sleep;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;


public class WebTablesPage {
    public WebDriver driver;
    public JavascriptExecutor js;
    public Actions actions;
    Person person = new Person();


//    @FindBy(xpath = "//*[@id=\"linkWrapper\"]/h5/strong")
//    private List<WebElement> title;


    @FindBy(className = "card-body")
    private WebElement elements;

    @FindBy(className = "text")
    private List<WebElement> textBox;

    @FindBy(className = "main-header")
    private WebElement getTitle;

    @FindBy(id = "addNewRecordButton")
    private WebElement addBtn;

    @FindBy(id = "registration-form-modal")
    private WebElement regFormTitle;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "age")
    private WebElement age;

    @FindBy(id = "salary")
    private WebElement salary;

    @FindBy(id = "department")
    private WebElement department;

    @FindBy(id = "submit")
    private WebElement submit;

    @FindBy(css = "div.rt-tr-group .rt-td")
    private List<WebElement> webTableRow;

    @FindBy(css = ".rt-tr .rt-td")
    private List<WebElement> rowElement;

    @FindBy(className = "modal-open")
    private List<WebElement> titleForm;

    @FindBy(id = "edit-record-1")
    private WebElement editFirstGridRecord;

    @FindBy(id = "delete-record-1")
    private WebElement deleteFirstGridRecord;

    @FindBy(id = "searchBox")
    private WebElement searchInput;

    @FindBy(className = "input-group-append")
    private WebElement searchButton;

    @FindBy(tagName = "select")
    private WebElement selectRow;

    @FindBy(css = "div.-next")
    private WebElement nextBtn;


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

    public void editFirstRecord(WebDriver driver) {
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

    public void clickAddButton(WebDriver driver, Actions actions) throws InterruptedException {
        this.actions = actions;
        actions.moveToElement(addBtn).click().perform();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        sleep(3000);

        // todo fluky test: вот тут периодически падает
        // todo add logs and photos to debug it
        Assertions.assertEquals("Registration Form",
               regFormTitle.getText());
    }

    public void fillFormSeveralTimes(WebDriver driver) throws InterruptedException {
        for (int i = 0; i < 4; i ++) {
            clickAddButton(driver, actions);
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
