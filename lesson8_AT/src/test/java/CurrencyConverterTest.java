import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import page.MainPage;

import java.util.stream.Stream;

public class CurrencyConverterTest extends BaseTest {

    public static Stream<Object[]> getCurrencies() {
        return Stream.of(
                new Object[]{"usd", 200},
                new Object[]{"byn", 2040},
                new Object[]{"rub", 70777},
                new Object[]{"cny", 256},
                new Object[]{"pln", 888},
                new Object[]{"eur", 270}
        );
    }

    @ParameterizedTest
    @MethodSource("getCurrencies")
    public void testingCurrencyConversion(String currency, int value) {
        String usdValue = new MainPage(getDriver())
                .navigateTo("https://myfin.by/")
                .clickKursyValutBtn()
                .clickConverterBtn()
                .setCurrencyValue(currency, value)
                .getUsdFieldValue();
        Assertions.assertEquals(usdValue, String.valueOf(value));
    }
}