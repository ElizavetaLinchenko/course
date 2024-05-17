package page;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import component.Menu;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private SelenideElement menuBtn = $x("//div[contains(@class, 'navbar__toggler')]");

    public HomePage navigateTo(String url) {
        Configuration.headless = true;
        Selenide.open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        return this;
    }

    public Menu clickMenuBtn() {
        menuBtn.click();
        return Selenide.page(Menu.class);
    }
}