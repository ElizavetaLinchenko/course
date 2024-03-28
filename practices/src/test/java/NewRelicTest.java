import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NewRelicTest {
    private static ChromeOptions options;
    private ChromeDriver chromeDriver;

    private By nameFieldLocator = By.xpath("//input[@name='name']");
    private By companyEmailFieldLocator = By.xpath("//input[@name='email']");
    private By getStartedFreeFieldLocator = By.xpath("//input[@type='submit']");

    @BeforeAll
    static void downloadDriver() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    @BeforeEach
    void openBrowser() {
        chromeDriver = new ChromeDriver(options);
    }

    @Test
    void testMethod() {
        chromeDriver.get("https://newrelic.com/");


    }

    @AfterEach
    void closeBrowser() {
        chromeDriver.close();
    }
}
