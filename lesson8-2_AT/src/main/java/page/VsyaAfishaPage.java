package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VsyaAfishaPage {
    private WebDriver driver;
    private By spectakliBtn = By.xpath("//li[contains(div/a/text(), 'Спектакли')]");

    public VsyaAfishaPage(WebDriver driver) {
        this.driver = driver;
    }

    public SpectakliPage clickSpectakli() {
        driver.findElement(spectakliBtn).click();
        return new SpectakliPage(driver);
    }
}