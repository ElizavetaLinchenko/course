package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VideoFrame {
    private WebDriver driver;
    private By video = By.xpath("//iframe[@title='GitLab Video']");
    private By playBtn = By.xpath("//button[contains(@class, 'PlayButton_module_playButton')]");
    private By pauseBtn = By.xpath("//*[contains(@class, 'PlayButton_module_pauseIcon')]");
    public VideoFrame(WebDriver driver) {
        this.driver = driver;
    }

    public VideoFrame clickPlayBtn() {
        WebElement iFrame = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(video));
        driver.switchTo().frame(iFrame);
        driver.findElement(playBtn).click();
        return new VideoFrame(driver);
    }
    public WebElement findPauseBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pauseButton = wait.until(ExpectedConditions.visibilityOfElementLocated(pauseBtn));
        return pauseButton;
    }
}