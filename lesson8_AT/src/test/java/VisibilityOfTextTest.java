import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.MainPage;

public class VisibilityOfTextTest extends BaseTest {

    @Test
    void checkIfTextVisible() {
        String text = new MainPage(getDriver())
                .navigateTo("https://myfin.by/")
                .clickVkladyBtn()
                .findKolebaniyaStavokTitle();
        Assertions.assertEquals(text, "Колебания ставок на вклады");
    }
}