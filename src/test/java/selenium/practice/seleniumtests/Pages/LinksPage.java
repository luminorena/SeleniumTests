package selenium.practice.seleniumtests.Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.practice.helpers.GetElementsHelper;
import selenium.practice.helpers.LinksStatuses;

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

    private final String baseUrl = "https://demoqa.com/";

    GetElementsHelper getElementsHelper = new GetElementsHelper();


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
        getListOfLinks(driver);
        Assertions.assertEquals(baseUrl,nodeUrl);
        Assertions.assertEquals(baseUrl + "links", currentUrl);
    }

    public void checkHomeDynamic(WebDriver driver){
        dynamicLink.click();
        getListOfLinks(driver);
        Assertions.assertEquals(baseUrl,nodeUrl);
        Assertions.assertEquals(baseUrl + "links", currentUrl);
    }

    public void checkCreated(Actions actions) {
        this.actions = actions;
        created.click();
        actions.moveToElement(linkResponse).click().perform();
        Assertions.assertEquals(LinksStatuses.STATUS_201.description,
                linkResponse.getText());
    }

    public void checkNoContent() {
        noContent.click();
        actions.moveToElement(linkResponse).click().perform();
        Assertions.assertEquals(LinksStatuses.STATUS_204.description,
               linkResponse.getText());
    }

    public void checkMoved(Actions actions){
        this.actions = actions;
        moved.click();
        actions.moveToElement(linkResponse).click().perform();
        Assertions.assertEquals(LinksStatuses.STATUS_301.description,
                linkResponse.getText());
    }

    public void checkBadRequest(Actions actions) {
        this.actions = actions;
        badRequest.click();
        actions.moveToElement(linkResponse).click().perform();
        Assertions.assertEquals(LinksStatuses.STATUS_400.description,
                linkResponse.getText());
    }

    public void checkUnauthorized(Actions actions){
        this.actions = actions;
        unauthorized.click();
        actions.moveToElement(linkResponse).click().perform();
        Assertions.assertEquals(LinksStatuses.STATUS_401.description,
                linkResponse.getText());
    }

    public void checkForbidden (Actions actions){
        this.actions = actions;
        forbidden.click();
        actions.moveToElement(linkResponse).click().perform();
        Assertions.assertEquals(LinksStatuses.STATUS_403.description,
               linkResponse.getText());
    }

    public void checkNotFound(Actions actions){
        this.actions = actions;
        notFound.click();
        actions.moveToElement(linkResponse).click().perform();
        Assertions.assertEquals(LinksStatuses.STATUS_404.description,
                linkResponse.getText());
    }

    public List<String> getListOfLinks(WebDriver driver) {
        this.driver = driver;
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        List<String> listOfLinks = new ArrayList<>();

        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                nodeUrl = driver.getCurrentUrl();
                listOfLinks.add(nodeUrl);
                driver.switchTo().window(mainWindowHandle);
                currentUrl = driver.getCurrentUrl();
                listOfLinks.add(currentUrl);
            }

        }

        return listOfLinks;
    }

    public void openLinksPage(JavascriptExecutor js) {
        js.executeScript("window.scrollBy(0,350)", "");
        elements.click();
        js.executeScript("window.scrollBy(0, 200)", "");
        textBox.get(getElementsHelper.getElementsBlockItem("Links")).click();
    }

    public LinksPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
