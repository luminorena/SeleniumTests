package selenium.practice.seleniumtests.Pages;

import org.junit.jupiter.api.Assertions;
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

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.sleep;


public class RadioButtonPage {
    public WebDriver driver;
    public JavascriptExecutor js;

    @FindBy(className = "card-body")
    private WebElement elements;

    @FindBy(className = "text")
    private List<WebElement> textBox;

    @FindBy(id = "yesRadio")
    private WebElement yesRadioButton;

    @FindBy(css = "#impressiveRadio")
    private WebElement impressiveRadio;

    @FindBy(xpath = "//span[@class='text-success']")
    private WebElement successResult;

    @FindBy(id = "noRadio")
    private WebElement noRadio;


    GetElementsHelper getElementsHelper = new GetElementsHelper();

    public void openRadioButtonPage (JavascriptExecutor js) {
        js.executeScript("window.scrollBy(0,350)");
        elements.click();
        js.executeScript("window.scrollBy(0,-350)");
        textBox.get(getElementsHelper.getElementsBlockItem("Radio Button")).click();
    }

    public void checkYesRadioButton(WebDriver driver, Actions actions) {
        WebElement yesRadioButton = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions
                .presenceOfElementLocated(By.id("yesRadioButton")));
        actions.moveToElement(yesRadioButton).click().perform();
        Assertions.assertEquals("Yes",
                successResult.getText());

    }

    public void checkImpressiveButton(WebDriver driver, Actions actions) {
        WebElement impressiveRadio = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions
                .presenceOfElementLocated(By.id("impressiveRadio")));
        actions.moveToElement(impressiveRadio).click().perform();
        Assertions.assertEquals("Impressive",
                successResult.getText());
    }

    public void checkNoButton(WebDriver driver, Actions actions) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        actions.moveToElement(noRadio).click().perform();
        boolean enabled = noRadio.isEnabled();
        Assertions.assertFalse(enabled);
    }


    public RadioButtonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
