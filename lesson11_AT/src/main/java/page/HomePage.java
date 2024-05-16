package page;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private SelenideElement menuBtn = $x("//div[contains(@class, 'navbar__toggler')]");
    private SelenideElement companiiBtn = $x("//a[contains(@href, 'companies.devby.io')]");
    private SelenideElement oProekteBtn = $x("//a[contains(@class, 'menu__footer-item') and contains(@href, 'devby.io/pages/about')]");
    private SelenideElement searchField = $x("//input[contains(@placeholder, 'Поиск')]");
    private SelenideElement search = $x("//img[contains(@alt, 'Search')]");

    public HomePage navigateTo(String url) {
        Configuration.headless = true;
        Selenide.open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        return this;
    }

    public HomePage clickMenuBtn() {
        menuBtn.click();
        return Selenide.page(HomePage.class);
    }

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
