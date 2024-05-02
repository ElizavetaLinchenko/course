package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
    private WebDriver driver;
    private By kursyValut = By.xpath("//a[contains(@class, \"main-nav_link\") and contains(@href, \"campaign=menu\") and normalize-space()=\"Курсы валют\"]");
    private By converter = By.xpath("//a[contains(@href, \"campaign=currency_button\") and contains(normalize-space(), \"Конвертер\")]");
    private By cookie = By.xpath("//button[contains(@class, \"btn\") and contains(@class, \"btn-big\") and contains(@class, \"btn-default\") and normalize-space()=\"Принять\"]");
    private By vkladyBtn = By.xpath("//a[contains(@class, \"main-nav_link\") and contains(@href, \"/vklady\") and contains(normalize-space(), \"Вклады\")]");

    private By zabronirovatKurs = By.xpath("//a[contains(@class, \"btn\") and contains(@class, \"btn-primary\") and contains(@href, \"zabronirovat-kurs\") and normalize-space()=\"Забронировать курс\"]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage navigateTo(String url) {
        driver.get(url);
        return this;
    }

    public MainPage clickKursyValutBtn() {
        driver.findElement(cookie).click();
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

        return new MainPage(driver);
    }

    public CurrencyPage clickConverterBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement converterButton = wait.until(ExpectedConditions.elementToBeClickable(converter));
        converterButton.click();
        return new CurrencyPage(driver);
    }

    public KolebaniyaStavokPage clickVkladyBtn() {
        driver.findElement(cookie).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement vkladyButton = wait.until(ExpectedConditions.elementToBeClickable(vkladyBtn));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", vkladyButton);
        return new KolebaniyaStavokPage(driver);
    }

    public ZabronirovatKursPage clickZabronirovatKursBtn() {
        driver.findElement(zabronirovatKurs).click();
        return new ZabronirovatKursPage(driver);
    }
}