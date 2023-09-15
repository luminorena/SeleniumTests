package selenium.practice.seleniumtests.Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ButtonsPage {

    public JavascriptExecutor js;
    public WebDriver driver;
    public Actions actions;
    @FindBy(className = "card-body")
    private WebElement elements;

    @FindBy(className = "text")
    private List<WebElement> textBox;

    @FindBy(id = "doubleClickBtn")
    private WebElement doubleClickElement;

    @FindBy(id = "doubleClickMessage")
    private WebElement doubleClickValidation;

    @FindBy(id = "rightClickBtn")
    private WebElement rightClickElement;

    @FindBy(id = "rightClickMessage")
    private WebElement contextMenuValidation;

    @FindBy(css = ".btn.btn-primary")
    private List<WebElement> clickElement;

    @FindBy(id = "dynamicClickMessage")
    private WebElement clickValidation;

    public void openButtonsPage(JavascriptExecutor js){
        this.js = js;
        js.executeScript("window.scrollBy(0,350)", "");
        elements.click();
        js.executeScript("window.scrollBy(0, 200)", "");
        textBox.get(4).click();
    }

    public void checkDoubleClick(Actions actions){
        actions.doubleClick(doubleClickElement).perform();
        Assertions.assertEquals(doubleClickValidation.getText(),
                "You have done a double click");
    }

    public void checkRightClick(Actions actions){
        actions.contextClick(rightClickElement).perform();
        Assertions.assertEquals(contextMenuValidation.getText(),
                "You have done a right click");
    }

    public void checkClickMe(){
        clickElement.get(2).click();
        Assertions.assertEquals(clickValidation.getText(),
                "You have done a dynamic click");
    }



    public ButtonsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
