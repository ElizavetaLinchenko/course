import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Tests {

    private static ChromeOptions options;
    private WebDriver driver;


    private String urlDevTools = "https://www.jetbrains.com/";
    private By devToolsBtn = By.xpath("//button[@aria-label=\"Developer Tools: Open submenu\" and @data-test=\"main-menu-item-action\"]");
    private By ideThemesBtn = By.xpath("//div[contains(@class, 'main-submenu__column') and contains(@class, '_mainSubmenu')]//a[contains(., 'IDE Themes')]");
    private By searchField = By.xpath("//input[@placeholder='Search']");
    private By draculaThemes = By.xpath("//span[contains(text(), 'Zihan Ma')]");
    private By rating = By.xpath("//main[contains(@id, \"mp-layout-content\")]//span[contains(@class, '_starWrapper') and contains(@class, '_themeDark')]");
    private By mpsBtn = By.xpath("//div[contains(@class, 'main-submenu__column') and h5[@data-test='main-submenu-column-title' and text()='LANGUAGES & FRAMEWORKS']]//a[contains(@href, '/mps/')]");
    private By watchVideo = By.xpath("//div[@id=\"mps-overview-page\"]/section//div/button[contains(text(), 'Watch Video')]");
    private By iFrameLocator = By.xpath("//iframe[contains(@class, 'wt-youtube-player__player')]");
    private By videoTitleLocator = By.xpath("//a[contains(@class, 'ytp-title-link') and contains(@href, 'https://www.youtube.com/watch?v')]");
    private By scalaBtn = By.xpath("//div[contains(@class, 'main-submenu') and contains(@class, '_mainSubmenu')]//h5[contains(text(), 'PLUGINS & SERVICES')]/following-sibling::div//a[contains(@href, 'scala')]");
    private By imgLocator = By.xpath("//img[contains(@src, \"pluginIcon.svg\")]");


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

    void clickingDevelopersTools() {
        driver.manage().window().maximize();
        driver.get(urlDevTools);
        driver.findElement(devToolsBtn).click();
    }

    @Test
    void testingIdeThemes() {
        clickingDevelopersTools();
        driver.findElement(ideThemesBtn).click();
        driver.findElement(searchField).sendKeys("Dracula Theme");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement draculaThemesElement = wait.until(ExpectedConditions.elementToBeClickable(draculaThemes));
        draculaThemesElement.click();
        List<WebElement> ratingStars = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(rating));
        Assertions.assertEquals(5, ratingStars.size());
    }

    @Test
    void testingVideo() {
        clickingDevelopersTools();
        driver.findElement(mpsBtn).click();
        driver.findElement(watchVideo).click();

        WebElement iFrame = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(iFrameLocator));
        driver.switchTo().frame(iFrame);
        WebElement videoTitle = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(videoTitleLocator));

        Assertions.assertEquals("Intro Video of JetBrains MPS", videoTitle.getText());
    }

    @Test
    void testingLogoScala() {
        clickingDevelopersTools();
        driver.findElement(scalaBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement logo = wait.until(ExpectedConditions.presenceOfElementLocated(imgLocator));
        driver.findElement(imgLocator).getAttribute("src");
        String imgLink = logo.getAttribute("src");
        Assertions.assertTrue(imgLink.endsWith(".svg"));
    }
}