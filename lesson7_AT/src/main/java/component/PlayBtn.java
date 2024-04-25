package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlayBtn {
    private WebDriver driver;
    private By playBtn = By.xpath("//button[contains(@class, 'PlayButton_module_playButton')]");

    public PauseBtn clickPlayBtn() {
        driver.findElement(playBtn).click();
        return new PauseBtn(driver);
    }
}