import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import page.MainPage;

public class PlayBtnTest extends BaseTest {

    @Test
    void checkIfPauseBtnVisible() {
        WebElement pauseButton = new MainPage(getDriver())
                .navigateTo("https://about.gitlab.com/")
                .clickResourcesBtn()
                .clickQuickStartGuidesBtn()
                .clickWatchDemoBtn()
                .clickPlayBtn()
                .findPauseBtn();
        Assertions.assertTrue(pauseButton.isDisplayed());
    }
}