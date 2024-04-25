import org.junit.jupiter.api.Test;
import page.MainPage;

public class ImgTest extends BaseTest {

    @Test
    void checkImgExtension() {
        new MainPage(getDriver())
                .navigateTo("https://about.gitlab.com/")
                .testingImg();
    }
}