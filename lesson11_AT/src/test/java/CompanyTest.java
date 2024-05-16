import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import page.HomePage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$x;

public class CompanyTest {
    public static Stream<Arguments> сompanies() {
        return Stream.of(
                Arguments.of("bit", "Fitbit"),
                Arguments.of("solution", "BIMSOLUTIONS")
        );
    }

    @ParameterizedTest
    @MethodSource("сompanies")
    public void testCompanySearch(String value, String name) {
        HomePage homePage = new HomePage();
        homePage.navigateTo("https://devby.io/")
                .clickMenuBtn()
                .clickCompaniiBtn()
                .getTableDataAfterSearch(value, name).forEach(
                        countWorker -> {
                            Assertions.assertTrue($x(String.format("//a[contains(text(), '%s')]", name)).isDisplayed());
                            Assertions.assertTrue(countWorker > 0);
                        }
                );
    }
}
