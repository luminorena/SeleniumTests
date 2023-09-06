package selenium.practice.seleniumtests.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LinksPage  {
    public WebDriver driver;
    public JavascriptExecutor js;

    @FindBy(xpath = "//*[@id=\"linkWrapper\"]/h5/strong")
    public List<WebElement> title;

    @FindBy(className = "card-body")
    public WebElement elements;

    @FindBy(className = "text")
    public List<WebElement> textBox;

    @FindBy(id = "simpleLink")
    public WebElement homeLink;

    @FindBy(id = "dynamicLink")
    public WebElement dynamicLink;

    @FindBy(id = "created")
    public WebElement created;

    @FindBy(id = "no-content")
    public WebElement noContent;

    @FindBy(id = "moved")
    public WebElement moved;

    @FindBy(id = "bad-request")
    public WebElement badRequest;

    @FindBy(id = "unauthorized")
    public WebElement unauthorized;

    @FindBy(id = "forbidden")
    public WebElement forbidden;

    @FindBy(id = "invalid-url")
    public WebElement notFound;

    @FindBy(css = "p#linkResponse")
    public WebElement linkResponse;



    public String nodeUrl = "";
    public String currentUrl = "";

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
