package step;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class TestClass extends BaseTest {

    private static final String url = "https://www.jetbrains.com/";

    private By devToolsBtn = By.xpath("//button[@aria-label=\"Developer Tools: Open submenu\" and @data-test=\"main-menu-item-action\"]");

    private By intellijIdeaBtn = By.xpath("//div[contains(@class, 'main-submenu__column') and contains(@class, '_mainSubmenu')]//a[contains(., 'IntelliJ')]");

    private By cookieBanner = By.xpath("//div[contains(@class, 'jetbrains-cookies-banner')]//div[contains(@class, 'text-content')]");
    private By aquaBtn = By.xpath("//div[contains(@class, 'main-submenu__column') and contains(@class, '_mainSubmenu')]//a[contains(., 'Aqua')]");
    private By documentationBtn = By.xpath("//div[@id=\"js-menu-second-desktop\"]//a[contains(@href, '/help/aqua') and contains(., 'Documentation')]");
    private By overviewPanel = By.xpath("//div[@id=\"webhelp-root\"]//div//a[@href='about-aqua-ide.html' and contains(., 'Overview')]");
    private By userInterface = By.xpath("//li[@data-test='toc-node' and a[@data-test='internal-link toc-item' and text()='User Interface']]");
    private By imgLocator = By.xpath("//img[@src='https://resources.jetbrains.com/help/img/idea/aqua_ide_editor_dark.png']");
    private By teamToolsBtn = By.xpath("//button[@data-test='main-menu-item-action' and text()='Team Tools']");
    private By dataloreBtn = By.xpath("//div[contains(@class, 'main-submenu__column') and contains(@class, '_mainSubmenu')]//a[contains(., 'A collaborative data science platform')]");
    private By watchOverview = By.xpath("//button[@data-test='button' and contains(text(), 'Watch overview')]");
    private By iFrameLocator = By.xpath("//iframe[contains(@class, 'wt-youtube-player__player')]");
    private By videoTitleLocator = By.xpath("//div[@class='ytp-title-text']//a[contains(@href, 'https://www.youtube.com/watch')]");

    public void openDevTools() {
        driver.get(url);
        driver.findElement(devToolsBtn).click();
    }

    @Test
    public void testingCookie() {
        openDevTools();
        driver.findElement(intellijIdeaBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement banner = wait.until(ExpectedConditions.presenceOfElementLocated(cookieBanner));
        String text = banner.getText();
        Assertions.assertEquals("Our website uses some cookies and records your IP address for the purposes of " +
                "accessibility, security, and managing your access to the telecommunication network. You can disable data " +
                "collection and cookies by changing your browser settings, but it may affect how this website functions. " +
                "Learn more.\n" +
                "With your consent, JetBrains may also use cookies and your IP address to collect individual statistics " +
                "and provide you with personalized offers and ads subject to the Privacy Policy and the Terms of Use. " +
                "JetBrains may use third-party services for this purpose. You can adjust or withdraw your consent at any " +
                "time by visiting the Opt-Out page.", text);
    }

    @Test
    public void testingVideo() {
        driver.get(url);
        driver.findElement(teamToolsBtn).click();
        driver.findElement(dataloreBtn).click();
        driver.findElement(watchOverview).click();
        WebElement iFrame = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(iFrameLocator));
        driver.switchTo().frame(iFrame);
        WebElement videoTitle = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(videoTitleLocator));
        Assertions.assertEquals("Datalore Overview (2024) – The Collaborative Data Science Platform for Teams", videoTitle.getText());
    }

    @Test
    public void testingImg() {
        openDevTools();
        driver.findElement(aquaBtn).click();
        driver.findElement(documentationBtn).click();
        driver.findElement(overviewPanel).click();
        driver.findElement(userInterface).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement imageElement = wait.until(ExpectedConditions.visibilityOf(driver.findElement(imgLocator)));
        long realWidth = (Long) ((JavascriptExecutor) driver).executeScript("return arguments[0].naturalWidth", imageElement);
        long realHeight = (Long) ((JavascriptExecutor) driver).executeScript("return arguments[0].naturalHeight", imageElement);
        Assert.assertEquals(3008, realWidth);
        Assert.assertEquals(1406, realHeight);
    }
}