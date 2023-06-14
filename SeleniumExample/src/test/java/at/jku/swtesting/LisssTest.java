package at.jku.swtesting;

import at.jku.swtesting.pageobjects.ResultsPage;
import at.jku.swtesting.pageobjects.SearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LisssTest {

    private static WebDriver driver;
    private static final DriverManagerType DRIVER_TYPE = DriverManagerType.CHROME;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.getInstance(DRIVER_TYPE).setup();
        driver = new ChromeDriver();
        // driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    void testSearch() {
        // Go to the page https://lisss.jku.at/primo-explore/search?vid=ULI&lang=en_US
        // Perform a search for the string "software testing"
        // Check the title of the results page and the number of found titles
        // Note: Create a new Web driver instance opening the browser window in setup (@BeforeAll) and
        // close the driver in the corresponding teardown. Use a suitable driver for Chrome, Firefox, etc.

        driver.get("https://lisss.jku.at/primo-explore/search?vid=ULI&lang=en_US");
        WebElement searchField = driver.findElement(By.id("searchBar"));
        searchField.clear();
        searchField.sendKeys("software testing");
        searchField.submit();
        // Short delay as website needs some time to load
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals("JKU | LISSS - software testing", driver.getTitle());
//        WebElement results = driver.findElement(By.cssSelector("select_value_label_29 > span:nth-child(1)"));
//        assertEquals("1-10 of 4,253 Results", results.getText());
        WebElement test = driver.findElement(By.id("mainResults"));
        WebElement resultRange = test.findElement(By.tagName("PRM-SEARCH-RESULT-PAGE-RANGE"));
//        List <WebElement> spans = resultRange.findElements(By.tagName("span"));
//        assertEquals("1-10 of 4,253 Results", resultRange.getText());
    }
}
