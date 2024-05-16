import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.HomePage;

public class UrlTest {
    @Test
    void testingUrl() {
        HomePage homePage = new HomePage();
        String currentUrl = homePage.navigateTo("https://devby.io/")
                .clickMenuBtn()
                .setValueInSearchFieldAndClick("selenium")
                .getCurrentUrl();
        Assertions.assertTrue(currentUrl.startsWith("https://cse.google.com/"));
    }
}