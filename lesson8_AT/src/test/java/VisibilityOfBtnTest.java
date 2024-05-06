import custom.Button;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import page.MainPage;

public class VisibilityOfBtnTest extends BaseTest {

    @Test
    void checkIfDaleeBtnVisible() {
        Button daleeButton = new MainPage(getDriver())
                .navigateTo("https://myfin.by/")
                .clickKursyValutBtn()
                .clickZabronirovatKursBtn()
                .setYMenyaEstField("200")
                .daleeBtn();
        Assertions.assertTrue(daleeButton.isDisplayed());
    }
}