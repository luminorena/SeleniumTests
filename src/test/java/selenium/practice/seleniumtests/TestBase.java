package selenium.practice.seleniumtests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

public class TestBase {
    public static Logger logger;
    public WebDriver driver;
    public Actions actions;
    public JavascriptExecutor js;

    //todo after all/before all

    @BeforeEach
    public void setUp() throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--headless", "--disable-gpu");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        driver.manage().window().setSize(new Dimension(1440, 900));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(getBaseUrl());
    }

    public String getBaseUrl() throws IOException {
        ClassLoader cl = TestBase.class.getClassLoader();
        InputStream is = cl.getResourceAsStream("data.properties");
        Properties properties = new Properties();
        properties.load(is);
        return properties.getProperty("baseUrl");
    }

    @AfterEach
    public void tearDown() {
        //todo изменить на одну
        driver.close();
        driver.quit();
    }
}
