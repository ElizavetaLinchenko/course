import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import page.MainPage;

public class SeleniumTitleTest extends BaseTest {
    @Test
    void checkIEDriverServer() {
        String text = new MainPage(getDriver())
                .navigateTo("https://www.selenium.dev/")
                .clickDocumentationPage()
                .clickfindIeDriver()
                .findIeDriverTitle();
        Assertions.assertEquals(text, "IE Driver Server");
    }
}
