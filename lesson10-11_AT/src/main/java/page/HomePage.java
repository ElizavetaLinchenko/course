package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private SelenideElement novostyBtn = $x("//a[contains(@class, 'main-nav_link') and contains(@href, 'campaign=menu') and text() = 'Новости']");
    private SelenideElement cookie = $x("//button[contains(@class, \"btn\") and normalize-space()=\"Принять\"]");

    public HomePage navigateTo(String url) {
        Selenide.open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        return this;
    }

    public SelenideElement clickNovostyBtn() {
        if (cookie.isDisplayed()) {
            cookie.click();
        }
        novostyBtn.click();
        return novostyBtn;
    }
}