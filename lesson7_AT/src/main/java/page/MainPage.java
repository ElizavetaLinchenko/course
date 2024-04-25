package page;

import events.EventPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    private By resourcesBtn = By.xpath("//li[@class='navigation-item']//div[@class='navigation-dropdown']//button[@name='Resources']");
    private By platformBtn = By.xpath("//a[contains(@class, 'navigation-dropdown__button') and text()='Platform']");
    private By imgLocator = By.xpath("//img[contains(@src, 'hero')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage navigateTo(String url) {
        driver.get(url);
        return this;
    }

    public ResourcesPage clickResourcesBtn() {
        driver.findElement(resourcesBtn).click();
        return new ResourcesPage(driver);
    }

    public EventPage clickPlatformBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(platformBtn)).click();
        return new EventPage(driver);
    }

    public List<String> testingImgExtension() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        List<WebElement> imgs = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(imgLocator));
        List<String> srcList = new ArrayList<>();
        for (WebElement img : imgs) {
            srcList.add(img.getAttribute("src"));
        }
        return srcList;
    }
}