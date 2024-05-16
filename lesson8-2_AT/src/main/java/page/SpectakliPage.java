package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpectakliPage {
    private WebDriver driver;

    public SpectakliPage(WebDriver driver) {
        this.driver = driver;
    }

    public SpectakliPage clickSpectakliPageSubMenu(String btn) {
        By afishaBtn = By.xpath(String.format("//a[contains(@href, 'https://afisha.relax.by/theatre/minsk/') and contains(text(), '%s')]", btn));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnFromAfisha = wait.until(ExpectedConditions.elementToBeClickable(afishaBtn));
        btnFromAfisha.click();
        return this;
    }

    public String getTitleFromSpectakliPage(String text) {
        WebElement textValue = driver.findElement(By.xpath(String.format("//h1[contains(text(), '%s')]", text)));
        return textValue.getText();
    }
}
