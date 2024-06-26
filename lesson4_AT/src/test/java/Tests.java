import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Tests {
    private static ChromeOptions options;
    private WebDriver driver;

    private String urlJenkins = "https://www.jenkins.io/";
    private String urlRest = "https://rest-assured.io/";
    private String checkingUrlGettingStarted = "https://github.com/rest-assured/rest-assured/wiki/GettingStarted";
    private String checkingUrlDownloads = "https://github.com/rest-assured/rest-assured/wiki/Downloads";

    private By imgLocator = By.xpath("//div[contains(@id, \"ProjectCarousel_\")]//div/a/img");
    private By docsBtn = By.xpath("//ul//a[@href= \"#docs\"]");
    private By gettingStartedBtn = By.xpath("//li//a[@href= \"https://github.com/rest-assured/rest-assured/wiki/GettingStarted\"]");
    private By gettingStartedText = By.xpath("//div[@id=\"wiki-wrapper\"]/div/h1");
    private By downloadsBtn = By.xpath("//li//a[@href= \"https://github.com/rest-assured/rest-assured/wiki/Downloads\"]");
    private By downloadsText = By.xpath("//div[@id=\"wiki-wrapper\"]/div/h1");
    private By tableColumnsLocator = By.xpath("//div[@id='wiki-body']//table//th");
    private By tableRowLocator = By.xpath("//div[@id=\"wiki-body\"]/div/table/tbody//tr");

    @BeforeAll
    static void downloadDriver() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    @BeforeEach
    void openBrowser() {
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void closeBrowser() {
        driver.close();
    }

    @Test
    void checkImageFormat() {
        driver.manage().window().maximize();
        driver.get(urlJenkins);
        List<WebElement> jenkinsImage = driver.findElements(imgLocator);
        Assertions.assertEquals(5, jenkinsImage.size());
        for (WebElement element : jenkinsImage) {
            String srcLink = element.getAttribute("src");
            Assertions.assertTrue(srcLink.endsWith("png"));
        }
    }

    void clickingDocs() {
        driver.manage().window().maximize();
        driver.get(urlRest);
        driver.findElement(docsBtn).click();
    }

    @Test
    void checkingURL() {
        clickingDocs();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement gettingStartedElement = driver.findElement(gettingStartedBtn);
        js.executeScript("arguments[0].click();", gettingStartedElement);
        WebElement gettingStarted = driver.findElement(gettingStartedText);
        Assertions.assertTrue(gettingStarted.isDisplayed());
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(checkingUrlGettingStarted, currentUrl);
    }

    @Test
    void checkingTable() {
        clickingDocs();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement downloadsElement = driver.findElement(downloadsBtn);
        js.executeScript("arguments[0].click();", downloadsElement);
        WebElement downloads = driver.findElement(downloadsText);
        Assertions.assertTrue(downloads.isDisplayed());
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(checkingUrlDownloads, currentUrl);
        List<WebElement> columns = driver.findElements(tableColumnsLocator);
        Assertions.assertEquals(2, columns.size());
        List<WebElement> rows = driver.findElements(tableRowLocator);
        Assertions.assertEquals(8, rows.size());
    }
}