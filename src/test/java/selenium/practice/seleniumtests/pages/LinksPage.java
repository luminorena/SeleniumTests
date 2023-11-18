package selenium.practice.seleniumtests.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.practice.helpers.GetElementsHelper;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LinksPage  {
    public WebDriver driver;
    public JavascriptExecutor js;
    public Actions actions;
    private String nodeUrl = "";
    private String currentUrl = "";

    GetElementsHelper getElementsHelper = new GetElementsHelper();
    private final String BASE_URL = "https://demoqa.com/";

    @FindBy(xpath = "//*[@id=\"linkWrapper\"]/h5/strong")
    private List<WebElement> listOfTitles;

    public List<WebElement> getListOfTitles() {
        return listOfTitles;
    }

    //todo structure
    @FindBy(className = "card-body")
    private WebElement elements;

    //todo structure
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

    public String getNodeUrl() {
        return nodeUrl;
    }

    public String getCurrentUrl() {
        return currentUrl;
    }

    public String getBaseUrl() {
        return BASE_URL;
    }

    public void clickHomeLink(WebDriver driver) {
        homeLink.click();
        initializeUrls(driver);
    }

    public void clickHomeDynamic(WebDriver driver){
        dynamicLink.click();
        initializeUrls(driver);
    }

    public void clickCreatedApiLink(Actions actions) {
        created.click();
    }

    public void clickNoContentApiLink() {
        noContent.click();
    }

    public void clickMovedApiLink(){
        moved.click();
    }

    public void clickBadRequestApiLink() {
        badRequest.click();
    }

    public void clickUnauthorizedApiLink(){
        unauthorized.click();
    }

    public void clickForbiddenApiLink(){
        forbidden.click();
    }

    public void clickNotFoundApiLink() {
        notFound.click();
    }

    public void initializeUrls(WebDriver driver) {
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                nodeUrl = driver.getCurrentUrl();

                driver.switchTo().window(mainWindowHandle);
                currentUrl = driver.getCurrentUrl();
            }
        }
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
