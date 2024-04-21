package step;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private static ChromeOptions options;
    public WebDriver driver;

    @BeforeClass
    public void downloadDriver() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}