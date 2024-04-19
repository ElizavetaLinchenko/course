package step;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public static WebDriver getDriver() {
        return driver.get();
    }

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Before
    public void downloadDriver() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver.set(new ChromeDriver(options));
        driver.get().manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        driver.get().close();
    }
}