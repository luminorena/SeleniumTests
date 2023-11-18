package selenium.practice.seleniumtests.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.practice.helpers.GetElementsHelper;
import selenium.practice.seleniumtests.TestBase;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;


public class RadioButtonPage extends TestBase {
    private final String URL_WEBPAGE = getBaseUrl() + "radio-button";
    public WebDriver driver;
   // public JavascriptExecutor js;

    @FindBy(className = "mb-3")
    private WebElement doYouLikeTheSiteString;

    @FindBy(className = "card-body")
    private WebElement elements;

    @FindBy(className = "text")
    private List<WebElement> textBox;

    @FindBy(xpath = "//span[@class='text-success']")
    private WebElement successResult;

    public WebElement getSuccessResult() {
        return successResult;
    }

    @FindBy(id = "noRadio")
    private WebElement noRadio;

    boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    GetElementsHelper getElementsHelper = new GetElementsHelper();

    public void openRadioButtonPage (JavascriptExecutor js) {
        js.executeScript("window.scrollBy(0,350)");
        elements.click();
        js.executeScript("window.scrollBy(0,-350)");
        textBox.get(getElementsHelper.getElementsBlockItem("Radio Button")).click();
    }

    @Step("Open web-page")
    public void openWebPage(WebDriver driver) {
        try {
            System.out.println(URL_WEBPAGE);
            driver.get(URL_WEBPAGE);
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions
                            .visibilityOf(doYouLikeTheSiteString));
        } catch (NoSuchElementException e) {
            // add to allure
            System.out.println("WebPage is not open");
        }
    }

    public void clickYesRadioButton(WebDriver driver, Actions actions) {
        WebElement yesRadioButton = (new WebDriverWait(driver, Duration.ofSeconds(2)))
                .until(ExpectedConditions
                .presenceOfElementLocated(By.id("yesRadio")));

        //todo check different browsers

       for (int i = 0; i < 3 || yesRadioButton.isSelected(); i++) {
           actions.moveToElement(yesRadioButton).click().perform();
       }
    }

    public void clickImpressiveButton(WebDriver driver, Actions actions) {
        WebElement impressiveRadio = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions
                .presenceOfElementLocated(By.id("impressiveRadio")));
        actions.moveToElement(impressiveRadio).click().perform();
    }

    public void clickNoButton(WebDriver driver, Actions actions) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        actions.moveToElement(noRadio).click().perform();
        enabled = noRadio.isEnabled();
        //todo check disabled properties
    }


    public RadioButtonPage(WebDriver driver) throws IOException {
        PageFactory.initElements(driver, this);
    }


}
