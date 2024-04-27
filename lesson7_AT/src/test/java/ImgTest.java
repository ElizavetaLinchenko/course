import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.MainPage;

import java.util.List;

public class ImgTest extends BaseTest {

    @Test
    void checkImgExtension() {
        List<String> srcList = new MainPage(getDriver())
                .navigateTo("https://about.gitlab.com/")
                .getImages();
        Assertions.assertEquals(3, srcList.size());
        for (String src : srcList) {
            Assertions.assertTrue(src.endsWith("svg"));
        }
    }
}