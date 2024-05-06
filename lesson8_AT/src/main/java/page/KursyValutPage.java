package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KursyValutPage {
    private WebDriver driver;
    private By converter = By.xpath("//a[contains(@class, \"chip\") and contains(@href, \"/converter\")]");
    private By zabronirovatKurs = By.xpath("//a[contains(@class, \"btn-primary\") and contains(@href, \"zabronirovat-kurs\")]");

    public KursyValutPage(WebDriver driver) {
        this.driver = driver;
    }

    public CurrencyPage clickConverterBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement converterButton = wait.until(ExpectedConditions.elementToBeClickable(converter));
        converterButton.click();
        return new CurrencyPage(driver);
    }

    public ZabronirovatKursPage clickZabronirovatKursBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement zabronirovatKursBtn = wait.until(ExpectedConditions.elementToBeClickable(zabronirovatKurs));
        zabronirovatKursBtn.click();
        return new ZabronirovatKursPage(driver);
    }
}