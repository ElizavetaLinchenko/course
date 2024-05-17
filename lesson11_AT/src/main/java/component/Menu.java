package component;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import page.CompaniiPage;
import page.OProektePage;
import page.SearchPage;

import static com.codeborne.selenide.Selenide.$x;

public class Menu {
    private SelenideElement companiiBtn = $x("//a[contains(@href, 'companies.devby.io')]");
    private SelenideElement oProekteBtn = $x("//a[contains(@class, 'menu__footer-item') and contains(@href, 'devby.io/pages/about')]");
    private SelenideElement searchField = $x("//input[contains(@placeholder, 'Поиск')]");
    private SelenideElement search = $x("//img[contains(@alt, 'Search')]");

    public CompaniiPage clickCompaniiBtn() {
        companiiBtn.click();
        return Selenide.page(CompaniiPage.class);
    }

    public OProektePage clickOProekteBtn() {
        oProekteBtn.click();
        return Selenide.page(OProektePage.class);
    }

    public SearchPage setValueInSearchFieldAndClick(String value) {
        searchField.setValue(value);
        search.click();
        return Selenide.page(SearchPage.class);
    }
}