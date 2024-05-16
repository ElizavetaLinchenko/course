import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.MainPage;

import java.util.List;

public class ImgFormatTest extends BaseTest {
    @Test
    void checkImgExtension() {
        String location = System.getProperty("location");
        List<String> styleList = new MainPage(getDriver())
                .navigateTo("https://www.relax.by/")
                .getFotoOtchetyImg();
        Assertions.assertEquals(1, styleList.size());
        for (String src : styleList) {
            Assertions.assertTrue(src.endsWith("svg"));
        }
    }
}