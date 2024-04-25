import org.junit.jupiter.api.Test;
import page.MainPage;

public class PlayBtnTest extends BaseTest {

    @Test
    void checkIfPauseBtnVisible() {
        new MainPage(getDriver())
                .navigateTo("https://about.gitlab.com/")
                .clickResourcesBtn()
                .clickQuickStartGuidesBtn()
                .clickWatchDemoBtn()
                .clickPlayBtn()
                .checkVisabilityOfPauseBtn();
    }
}