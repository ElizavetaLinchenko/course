import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import page.CompaniiPage;
import page.HomePage;

import java.util.List;
import java.util.stream.Stream;

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
        CompaniiPage companiiPage = homePage.navigateTo("https://devby.io/")
                .clickMenuBtn()
                .clickCompaniiBtn();

        List<Integer> countWorkers = companiiPage.getTableDataAfterSearch(value, name);

        countWorkers.forEach(countWorker -> {
            Assertions.assertTrue(companiiPage.isCompanyDisplayed(name));
            Assertions.assertTrue(countWorker > 0);
        });
    }
}