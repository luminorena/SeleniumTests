package selenium.practice.seleniumtests.Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;


public class RadioButtonPage {
    public WebDriver driver;
    public JavascriptExecutor js;

    @FindBy(className = "card-body")
    private WebElement elements;

    @FindBy(className = "text")
    private List<WebElement> textBox;

    @FindBy(id = "yesRadio")
    private WebElement yesRadioButton;

    @FindBy(id = "impressiveRadio")
    private WebElement impressiveRadio;

    @FindBy(className = "text-success")
    private List<WebElement> successResult;

    @FindBy(id = "noRadio")
    private WebElement noRadio;

    public void openRadioButtonPage (JavascriptExecutor js) {
        this.js = js;
        js.executeScript("window.scrollBy(0,350)", "");
        elements.click();
        js.executeScript("window.scrollBy(0,-350)", "");
        textBox.get(2).click();
    }

    public void checkYesRadioButton(WebDriver driver, Actions actions) {
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(3));
        actions.moveToElement(yesRadioButton).click().perform();
        Assertions.assertEquals("Yes", successResult.get(0).getText());

    }

    public void checkImpressiveButton(WebDriver driver, Actions actions) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        actions.moveToElement(impressiveRadio).click().perform();
        Assertions.assertEquals("Impressive", successResult.get(0).getText());
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
