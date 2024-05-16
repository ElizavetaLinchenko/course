import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import page.HomePage;

public class TitleTest {
    @Test
    void checkIfTextVisible() {
        HomePage homePage = new HomePage();
        homePage.navigateTo("https://devby.io/")
                .clickMenuBtn()
                .clickOProekteBtn()
                .getTitle()
                .shouldHave(Condition.text("О проекте"));
    }
}
