package selenium.practice.seleniumtests.Pages;

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
import selenium.practice.helpers.GetElementsHelper;
import selenium.practice.seleniumtests.Data.Person;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import static java.lang.Thread.sleep;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.in;


public class WebTablesPage {
    public WebDriver driver;
    public JavascriptExecutor js;
    public Actions actions;

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

    @FindBy(className = "web-tables-wrapper")
    private WebElement webTable;

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    Person person = new Person();

    private final String URL_WEBPAGE = "https://demoqa.com/webtables";

    GetElementsHelper getElementsHelper = new GetElementsHelper();

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


    public void checkOpenLinksPage(JavascriptExecutor js) {
        js.executeScript("window.scrollBy(0,350)", "");
        elements.click();
        js.executeScript("window.scrollBy(0, 200)", "");
        textBox.get(getElementsHelper.getElementsBlockItem("Web Tables")).click();
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
        int initialCount = countFilledCells();
        deleteFirstGridRecord.click();
        int resultCount = countFilledCells();
        int deletedCellsCount = countCellsInOneLine(listOfCells);
        System.out.println("initialCount " + initialCount);
        System.out.println("deletedCellsCount " + deletedCellsCount);
        System.out.println("resultCount " + resultCount);
        Assertions.assertEquals(initialCount - deletedCellsCount, resultCount);

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

    public void checkButtonAdd(WebDriver driver, Actions actions) {
        addBtn.click();
        // crete new method from this
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                .presenceOfElementLocated(By.id("registration-form-modal")));
        Assertions.assertEquals("Registration Form",
               regFormTitle.getText());
    }

    public void fillFormSeveralTimes(WebDriver driver, int rowsToFill) {
        for (int i = 0; i < rowsToFill - 1; i ++) {
            checkButtonAdd(driver, actions);
            fillFormAndCheck(driver);
        }

        Select dropRow = new Select(selectRow);
        dropRow.selectByValue(String.valueOf(rowsToFill));
        nextBtn.click();

        int rowData = countCellsInOneLine(listOfCells);
        Assertions.assertEquals(rowsToFill, rowData - 1);

    }




}
