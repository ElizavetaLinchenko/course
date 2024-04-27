package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WatchDemoPage {
    private WebDriver driver;
    private By watchDemo = By.xpath("//a[@href='https://about.gitlab.com/demo/']");

    public WatchDemoPage(WebDriver driver) {
        this.driver = driver;
    }

    public VideoFrame clickWatchDemoBtn() {
        driver.findElement(watchDemo).click();
        return new VideoFrame(driver);
    }
}