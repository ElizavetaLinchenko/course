import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.HomePage;

public class NovostyTest {
    @Test
    void checkUrl() {
        String expectedURL = "https://myfin.by/stati?utm_source=myfin&utm_medium=organic&utm_campaign=menu";
        new HomePage()
                .navigateTo("https://myfin.by/")
                .clickNovostyBtn();
        String currentURL = WebDriverRunner.url();
        Assertions.assertEquals(expectedURL, currentURL);
    }
}