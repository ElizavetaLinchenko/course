import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import page.MainPage;

public class VisibilityOfBtnTest extends BaseTest {

    @Test
    void checkIfDaleeBtnVisible() {
        WebElement daleeButton = new MainPage(getDriver())
                .navigateTo("https://myfin.by/")
                .clickKursyValutBtn()
                .clickZabronirovatKursBtn()
                .setYMenyaEstField()
                .daleeBtn();
        Assertions.assertTrue(daleeButton.isDisplayed());
    }
}