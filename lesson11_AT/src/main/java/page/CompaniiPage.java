package page;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$x;

public class CompaniiPage {
    private SelenideElement nazvanieField = $x("//input[contains(@placeholder, 'Название')]");
    private SelenideElement table = $x("//tbody[contains(@aria-relevant, 'all')]");

    public List<Integer> getTableDataAfterSearch(String searchQuery, String name) {
        Integer index = null;
        List<String> otherCompany = new ArrayList<>();
        List<Integer> countWorkerOtherCompany = new ArrayList<>();
        nazvanieField.setValue(searchQuery);
        List<String> tableList =
                table.$$x("./tr").stream()
                        .map(SelenideElement::getText)
                        .collect(Collectors.toList());

        for (int i = 0; i < tableList.size(); i++) {
            if (tableList.get(i).contains(name)) {
                index = i;
            }
        }
        if (index != null) {
            otherCompany.add(tableList.get(index - 1));
            otherCompany.add(tableList.get(index + 1));

            otherCompany.forEach(str -> {
                int startIndex = str.indexOf("0.0 0.0") + "0.0 0.0".length();
                int endIndex = str.indexOf("↗");

                if (startIndex >= 0 && endIndex >= 0) {
                    String arr = str.substring(startIndex, endIndex).trim();
                    countWorkerOtherCompany.add(new Integer(arr));
                }
            });
            return countWorkerOtherCompany;
        } else {
            throw new RuntimeException("Company was not found");
        }
    }

    public boolean isCompanyDisplayed(String name) {
        return $x(String.format("//a[contains(text(), '%s')]", name)).isDisplayed();
    }
}