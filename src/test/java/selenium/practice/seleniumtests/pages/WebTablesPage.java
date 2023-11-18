package selenium.practice.seleniumtests.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.practice.seleniumtests.data.Person;
import selenium.practice.seleniumtests.TestBase;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;


public class WebTablesPage extends TestBase {

    private final String URL_WEBPAGE = getBaseUrl() + "webtables";
    public WebDriver driver;
    public JavascriptExecutor js;
    public Actions actions;
    Person person = new Person();
    int rowData = 0;
    private int deleteInitialCount = 0;
    private int deleteResultCount = 0;
    private int deletedCellsCount = 0;
    private ArrayList<String> searchArrayList;
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
    private List<WebElement> listOfCells;
    @FindBy(className = "main-header")
    private WebElement mainHeader;
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
    @FindBy(className = "web-tables-wrapper")
    private WebElement webTable;

    public WebTablesPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ArrayList<String> getSearchArrayList() {
        return searchArrayList;
    }

    public int getDeleteInitialCount() {
        return deleteInitialCount;
    }

    public int getDeleteResultCount() {
        return deleteResultCount;
    }

    public int getDeletedCellsCount() {
        return deletedCellsCount;
    }

    public WebElement getGetTitle() {
        return getTitle;
    }

    public WebElement getRegFormTitle() {
        return regFormTitle;
    }

    public WebElement getMainHeader() {
        return mainHeader;
    }

    public int getRowData() {
        return rowData;
    }

    @Step("Open web-page")
    public void openWebPage() {
        try {
            driver.get(URL_WEBPAGE);
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions
                            .visibilityOf(webTable));
        } catch (NoSuchElementException e) {
            // add to allure
            System.out.println("WebPage is not open");
        }
    }


    public void fillFormAndCheck(WebDriver driver) {
        int initialCount = countFilledCells();
        firstName.sendKeys(person.name);
        lastName.sendKeys(person.lastName);
        userEmail.sendKeys(person.email);
        age.sendKeys(person.age);
        salary.sendKeys(person.salary);
        department.sendKeys(person.department);
        submit.click();
        int resultCount = countFilledCells();
        int rowData = countCellsInOneLine(listOfCells);
        Assertions.assertEquals(initialCount + rowData, resultCount);
    }


    public void clearForm() {
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


    private int countCellsInOneLine(List<WebElement> listOfCells) {
        /*
        проходить в цикле до тех пор, пока не упрёмся в пустую ячейку,
        счиатая элементы с текстом. Цикл без break
         */
        //  ArrayList<String> arrayList = new ArrayList<>();
        int countElement = 0;
        for (WebElement cell : listOfCells) {
            if (Objects.equals(cell.getText(), "")) {
                break;
            }
            countElement++;
        }
        return countElement;
    }

    private int countFilledCells() {
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

    public void editFirstRecord(WebDriver driver) {
        editFirstGridRecord.click();
        clearForm();
        fillFormAfterClean(driver);
    }

    public void deleteFirstRecord() {
        deleteInitialCount = countFilledCells();
        deleteFirstGridRecord.click();
        deleteResultCount = countFilledCells();
        deletedCellsCount = countCellsInOneLine(listOfCells);
    }

    public void searchRecord() {
        searchInput.sendKeys("Alden");
        searchButton.click();
        searchArrayList = showRows();
        System.out.println(searchArrayList);
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

    public void clickButtonAdd(WebDriver driver, Actions actions) {
        addBtn.click();
        // crete new method from this
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.id("registration-form-modal")));
    }

    public void fillFormSeveralTimes(WebDriver driver, int rowsToFill) {
        for (int i = 0; i < rowsToFill - 1; i++) {
            clickButtonAdd(driver, actions);
            fillFormAndCheck(driver);
        }
        // выбор мультиселекта
        Select dropRow = new Select(selectRow);
        dropRow.selectByValue(String.valueOf(rowsToFill));
        nextBtn.click();
        rowData = countCellsInOneLine(listOfCells);

    }


}
