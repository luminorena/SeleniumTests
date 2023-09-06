package selenium.practice.seleniumtests.Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


import java.time.Duration;
import java.util.logging.Logger;

public class TestBase {
    public WebDriver driver;
    public Actions actions;
    public JavascriptExecutor js;
    public static Logger logger;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments( "--headless", "--disable-gpu");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        driver.manage().window().setSize(new Dimension(1440, 900));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();

    }



}
