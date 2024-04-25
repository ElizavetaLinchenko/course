package component;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PauseBtn {
    private WebDriver driver;
    private By pauseBtn = By.xpath("//*[contains(@class, 'PlayButton_module_pauseIcon')]");

    public PauseBtn(WebDriver driver) {
        this.driver = driver;
    }

    public void checkVisabilityOfPauseBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pauseButton = wait.until(ExpectedConditions.visibilityOfElementLocated(pauseBtn));
        Assertions.assertTrue(pauseButton.isDisplayed());
    }
}