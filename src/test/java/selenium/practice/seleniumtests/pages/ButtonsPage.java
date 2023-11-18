package selenium.practice.seleniumtests.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.practice.helpers.GetElementsHelper;

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

    public JavascriptExecutor getJs() {
        return js;
    }

    public WebElement getContextMenuValidation() {
        return contextMenuValidation;
    }

    public WebElement getClickValidation() {
        return clickValidation;
    }

    public WebElement getDoubleClickValidation() {
        return doubleClickValidation;
    }

    GetElementsHelper getElementsHelper = new GetElementsHelper();

    //todo вынести в BasePage через super вызывать метод

    public void openButtonsPage(JavascriptExecutor js){
        js.executeScript("window.scrollBy(0,350)");
        elements.click();
        js.executeScript("window.scrollBy(0, 200)");
        textBox.get(getElementsHelper.getElementsBlockItem("Buttons")).click();
    }

    public void clickDouble(Actions actions) {
        actions.doubleClick(doubleClickElement).perform();
    }

    public void clickRight(Actions actions) {
        actions.contextClick(rightClickElement).perform();
    }

    public void clickClickMe(){
        clickElement.get(2).click();
    }

    public ButtonsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
