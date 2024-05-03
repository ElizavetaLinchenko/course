package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
    private WebDriver driver;
    private By kursyValut = By.xpath("//a[contains(@data-bubble, \"currency\") and contains(@href, \"/currency/minsk\")]");
    private By cookie = By.xpath("//button[contains(@class, \"btn\") and normalize-space()=\"Принять\"]");
    private By vkladyBtn = By.xpath("//a[contains(@class, \"main-nav_link\") and contains(@href, \"/vklady\")]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage navigateTo(String url) {
        driver.get(url);
        return this;
    }

    public ZabronirovatKursPage clickKursyValutBtn() {
        WebElement cookieElement = driver.findElement(cookie);
        if (cookieElement.isDisplayed()) {
            cookieElement.click();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        int maxAttempts = 3;
        int attempts = 0;
        boolean clicked = false;

        while (attempts < maxAttempts && !clicked) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(kursyValut)).click();
                clicked = true;
            } catch (StaleElementReferenceException e) {
                attempts++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
            }
        }

        return new ZabronirovatKursPage(driver);
    }

    public KolebaniyaStavokPage clickVkladyBtn() {
        WebElement cookieElement = driver.findElement(cookie);
        if (cookieElement.isDisplayed()) {
            cookieElement.click();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement vkladyButton = wait.until(ExpectedConditions.elementToBeClickable(vkladyBtn));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", vkladyButton);
        return new KolebaniyaStavokPage(driver);
    }
}