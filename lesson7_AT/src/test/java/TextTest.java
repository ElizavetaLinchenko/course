import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.MainPage;

public class TextTest extends BaseTest {
    @Test
    void checkIfTextVisible() {
        String getFreeTrialText = new MainPage(getDriver())
                .navigateTo("https://about.gitlab.com/")
                .clickPlatformBtn()
                .getTitle()
                .getText();
        Assertions.assertEquals("Get Free Trial", getFreeTrialText);
    }
}