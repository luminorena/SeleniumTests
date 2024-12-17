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
// todo look at actions instead of JavaScriptExecutor

public class RadioButtonPage extends TestBase {
    private final String URL_WEBPAGE = getBaseUrl() + "radio-button";
    public WebDriver driver;
   // public JavascriptExecutor js;

    private Actions actions;

    @FindBy(className = "mb-3")
    private WebElement doYouLikeTheSiteString;

    @FindBy(className = "card-body")
    private WebElement elements;

    @FindBy(className = "text")
    private List<WebElement> textBox;

    @FindBy(className = "text-success")
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

    // todo change into actions and move to testutils
    public void openRadioButtonPage (JavascriptExecutor js) {
        js.executeScript("window.scrollBy(0,350)");
        elements.click();
        js.executeScript("window.scrollBy(0,-350)");
        textBox.get(getElementsHelper.getElementsBlockItem("Radio Button")).click();
    }

    public void openRadioButtonsPage(WebDriver driver){
        super.openWebPage(driver, URL_WEBPAGE, doYouLikeTheSiteString);
    }

    public void clickYesRadioButton(WebDriver driver, Actions actions) {
        WebElement yesRadioButton = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions
                .presenceOfElementLocated(By.id("yesRadio")));
        actions.moveToElement(yesRadioButton).click().perform();
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

    }


    public RadioButtonPage(WebDriver driver) throws IOException {
        PageFactory.initElements(driver, this);
    }


}
