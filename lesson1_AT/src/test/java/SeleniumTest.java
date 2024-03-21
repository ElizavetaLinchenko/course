import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {
    private static ChromeOptions options;
    private ChromeDriver chromeDriver;
    private MainPage mainPage;

    @BeforeAll
    static void downloadDriver() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    @BeforeEach
    void openBrowser() {
        chromeDriver = new ChromeDriver(options);
        mainPage = new MainPage(chromeDriver);
    }

    @Test
    void getCurrentUrlTest() {
        mainPage.siteUrl();
        String currentUrl = chromeDriver.getCurrentUrl();
        Assertions.assertEquals("https://ru.selenide.org/index.html", currentUrl);
    }
    @Test
    void getIncorrectUrlTest() {
        mainPage.siteUrl();
        String currentUrl = chromeDriver.getCurrentUrl();
        Assertions.assertEquals("https://selenide.org/index.html", currentUrl);
    }

    @AfterEach
    void closeBrowser() {
        chromeDriver.close();
    }

    @AfterAll
    static void close() {
    }
}