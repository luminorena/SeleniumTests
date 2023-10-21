package selenium.practice.seleniumtests.Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.practice.helpers.GetElementsHelper;

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

    public List<WebElement> getTitle() {
        return title;
    }

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

    public WebElement getLinkResponse() {
        return linkResponse;
    }

    private String nodeUrl = "";
    private String currentUrl = "";

    public String getNodeUrl() {
        return nodeUrl;
    }

    public String getCurrentUrl() {
        return currentUrl;
    }

    private final String baseUrl = "https://demoqa.com/";

    public String getBaseUrl() {
        return baseUrl;
    }

    GetElementsHelper getElementsHelper = new GetElementsHelper();




    public void checkApiName() {
        Assertions.assertEquals("Following links will send an api call",
                title.get(1).getText());
        System.out.println("-------" + title.get(1).getText());
    }



    public void clickHomeLink(WebDriver driver) {
        homeLink.click();
        getListOfLinks(driver);
    }



    public void clickHomeDynamic(WebDriver driver){
        dynamicLink.click();
        getListOfLinks(driver);

    }

    public void clickCreatedApiLink(Actions actions) {
        this.actions = actions;
        created.click();
        actions.moveToElement(linkResponse).click().perform();
    }

    public void clickNoContentApiLink(Actions actions) {
        this.actions = actions;
        noContent.click();
        actions.moveToElement(linkResponse).click().perform();

    }

    public void clickMovedApiLink(Actions actions){
        this.actions = actions;
        moved.click();
        actions.moveToElement(linkResponse).click().perform();

    }

    public void clickBadRequestApiLink(Actions actions) {
        this.actions = actions;
        badRequest.click();
        actions.moveToElement(linkResponse).click().perform();
    }

    public void clickUnauthorizedApiLink(Actions actions){
        this.actions = actions;
        unauthorized.click();
        actions.moveToElement(linkResponse).click().perform();

    }

    public void clickForbiddenApiLink(Actions actions){
        this.actions = actions;
        forbidden.click();
        actions.moveToElement(linkResponse).click().perform();
    }

    public void clickNotFoundApiLink(Actions actions){
        this.actions = actions;
        notFound.click();
        actions.moveToElement(linkResponse).click().perform();
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
