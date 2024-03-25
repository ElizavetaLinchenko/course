import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.opentest4j.AssertionFailedError;

public class SeleniumTest {

    private static final String baseUrl = "https://ru.selenide.org/index.html";
    private static final String incorrectUrl = "https://selenide.org/index.html";
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
        mainPage.navigateTo(baseUrl);
        String currentUrl = chromeDriver.getCurrentUrl();
        Assertions.assertEquals(baseUrl, currentUrl);
    }

    @Test
    void getIncorrectUrlTest() {
        try {
            mainPage.navigateTo(baseUrl);
            String currentUrl = chromeDriver.getCurrentUrl();
            Assertions.assertEquals(incorrectUrl, currentUrl);
        } catch (AssertionFailedError e) {

        } finally {
            mainPage.navigateTo(incorrectUrl);
            String currentUrl = chromeDriver.getCurrentUrl();
            Assertions.assertEquals(incorrectUrl, currentUrl);
        }
    }

    @AfterEach
    void closeBrowser() {
        chromeDriver.close();
    }
}