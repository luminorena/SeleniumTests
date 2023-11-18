package selenium.practice.helpers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import selenium.practice.seleniumtests.pages.WebTablesPage;
import selenium.practice.seleniumtests.TestBase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.qameta.allure.Allure.step;

public class GetElementsHelper extends TestBase {
   // public WebDriver driver;
    WebTablesPage webTablesPage;
    public Integer getElementsBlockItem(String input) {

        //todo map string and web-element
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "Text Box");
        map.put(1, "Check Box");
        map.put(2, "Radio Button");
        map.put(3, "Web Tables");
        map.put(4, "Buttons");
        map.put(5, "Links");
        map.put(6, "Broken Links - Images");
        map.put(7, "Upload and Download");
        map.put(8, "Dynamic Properties");

        return map.entrySet().stream().filter(x -> x.getValue()
                .equals(input))
                .map(Map.Entry::getKey).findFirst().orElse(null);

//       Фантазии тока на это хватило :)
//        List<WebElement> webElements = driver.findElements(By.className("text"));
//        js.executeScript("window.scrollBy(0,700)", "");
//        webElements.get(8).click();

    }

    @Test
    public void test() throws IOException {
        webTablesPage = new WebTablesPage(driver);
        step("Перейти в блок 'Elements' и выбрать 'Links'", () -> {
            webTablesPage.openWebPage();
            Assertions.assertEquals("Web Tables",
                    webTablesPage.getGetTitle().getText());
            driver.navigate().refresh();
        });
    }

    public static void main(String[] args) {
        GetElementsHelper getElementsHelper = new GetElementsHelper();
        System.out.println(getElementsHelper.getElementsBlockItem("Buttons"));

    }
}
