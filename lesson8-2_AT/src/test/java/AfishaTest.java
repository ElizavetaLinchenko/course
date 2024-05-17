import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import page.MainPage;

import java.util.stream.Stream;

public class AfishaTest extends BaseTest {

    public static Stream<Arguments> getAfishaRazvlecheniya() {
        return Stream.of(
                Arguments.of("Мюзикл", "Мюзикл в Минске"),
                Arguments.of("Балет", "Балет в Минске"),
                Arguments.of("Комедия", "Спектакль-комедия в Минске")
        );
    }

    @ParameterizedTest
    @MethodSource("getAfishaRazvlecheniya")
    public void testingAfishaRazvlecheniya(String btn, String value) {
        String location = System.getProperty("location");
        checklocation(location);
        String textAssertion = new MainPage(getDriver())
                .navigateTo("https://www.relax.by/")
                .clickAfishaIKino()
                .clickSpectakli()
                .clickSpectakliPageSubMenu(btn)
                .getTitleFromSpectakliPage(value);
        Assertions.assertEquals(textAssertion, value);
    }
}