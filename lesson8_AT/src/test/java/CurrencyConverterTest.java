import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import page.MainPage;

import java.util.stream.Stream;

public class CurrencyConverterTest extends BaseTest {

    public static Stream<Arguments> getCurrencies() {
        return Stream.of(
                Arguments.of("usd", 200),
                Arguments.of("byn", 2040),
                Arguments.of("rub", 70777),
                Arguments.of("cny", 256),
                Arguments.of("pln", 888),
                Arguments.of("eur", 270)
        );
    }

    @ParameterizedTest
    @MethodSource("getCurrencies")
    public void testingCurrencyConversion(String currency, int value) {
        String currencyValue = new MainPage(getDriver())
                .navigateTo("https://myfin.by/")
                .clickKursyValutBtn()
                .clickConverterBtn()
                .setCurrencyValue(currency, value)
                .getFieldValue(currency);
        Assertions.assertEquals(currencyValue, String.valueOf(value));
    }
}