package selenium.practice.seleniumtests.Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LinksPage  {
    public WebDriver driver;
    public JavascriptExecutor js;
    public Actions actions;

    @FindBy(xpath = "//*[@id=\"linkWrapper\"]/h5/strong")
    private List<WebElement> title;

    @FindBy(className = "card-body")
    private WebElement elements;

    @FindBy(className = "text")
    private List<WebElement> textBox;

    @FindBy(id = "simpleLink")
    private WebElement homeLink;

    @FindBy(id = "dynamicLink")
    private WebElement dynamicLink;

    @FindBy(id = "created")
    private WebElement created;

    @FindBy(id = "no-content")
    private WebElement noContent;

    @FindBy(id = "moved")
    private WebElement moved;

    @FindBy(id = "bad-request")
    private WebElement badRequest;

    @FindBy(id = "unauthorized")
    private WebElement unauthorized;

    @FindBy(id = "forbidden")
    private WebElement forbidden;

    @FindBy(id = "invalid-url")
    private WebElement notFound;

    @FindBy(css = "p#linkResponse")
    private WebElement linkResponse;



    private String nodeUrl = "";
    private String currentUrl = "";


    public void checkTabName() {
        Assertions.assertEquals("Following links will open new tab",
                title.get(0).getText());
    }

    public void checkApiName() {
        Assertions.assertEquals("Following links will send an api call",
                title.get(1).getText());
    }

    public void checkHomeLink(WebDriver driver) {
        homeLink.click();
        clickLink(driver);
        Assertions.assertEquals("https://demoqa.com/",nodeUrl);
        Assertions.assertEquals("https://demoqa.com/links", currentUrl);
    }

    public void checkHomeQoPPa(WebDriver driver){
        dynamicLink.click();
        clickLink(driver);
        Assertions.assertEquals("https://demoqa.com/",nodeUrl);
        Assertions.assertEquals("https://demoqa.com/links", currentUrl);
    }

    public void checkCreated(Actions actions) {
        this.actions = actions;
        created.click();
        actions.moveToElement(linkResponse).click().perform();
        Assertions.assertEquals("Link has responded with staus 201 and status text Created",
                linkResponse.getText());
    }

    public void checkNoContent() {
        noContent.click();
        actions.moveToElement(linkResponse).click().perform();
        Assertions.assertEquals("Link has responded with staus 204 and status text No Content",
               linkResponse.getText());
    }

    public void checkMoved(Actions actions){
        this.actions = actions;
        moved.click();
        actions.moveToElement(linkResponse).click().perform();
        Assertions.assertEquals("Link has responded with staus 301 and status text Moved Permanently",
                linkResponse.getText());
    }

    public void checkBadRequest(Actions actions) {
        this.actions = actions;
        badRequest.click();
        actions.moveToElement(linkResponse).click().perform();
        Assertions.assertEquals("Link has responded with staus 400 and status text Bad Request",
                linkResponse.getText());
    }

    public void checkUnauthorized(Actions actions){
        this.actions = actions;
        unauthorized.click();
        actions.moveToElement(linkResponse).click().perform();
        Assertions.assertEquals("Link has responded with staus 401 and status text Unauthorized",
                linkResponse.getText());
    }

    public void checkForbidden (Actions actions){
        this.actions = actions;
        forbidden.click();
        actions.moveToElement(linkResponse).click().perform();
        Assertions.assertEquals("Link has responded with staus 403 and status text Forbidden",
               linkResponse.getText());
    }

    public void checkNotFound(Actions actions){
        this.actions = actions;
        notFound.click();
        actions.moveToElement(linkResponse).click().perform();
        Assertions.assertEquals("Link has responded with staus 404 and status text Not Found",
                linkResponse.getText());
    }

    public List<String> clickLink(WebDriver driver) {
        this.driver = driver;
      //  js = (JavascriptExecutor) driver;

        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        List<String> results = new ArrayList<>();

        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                nodeUrl = driver.getCurrentUrl();
                results.add(nodeUrl);
                driver.switchTo().window(mainWindowHandle);
                currentUrl = driver.getCurrentUrl();
                results.add(currentUrl);
            }

        }

        return results;
    }

    public void openLinksPage(JavascriptExecutor js) {
        this.js = js;
        js.executeScript("window.scrollBy(0,350)", "");
        elements.click();
        js.executeScript("window.scrollBy(0, 200)", "");
        textBox.get(5).click();
    }



    public LinksPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
