package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class OProektePage {
    private SelenideElement oProekteTitle = $x("//h1[contains(@class, 'article__title')]");

    public SelenideElement getTitle() {
        oProekteTitle.shouldBe(visible);
        return oProekteTitle;
    }
}
