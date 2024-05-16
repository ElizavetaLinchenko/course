package page;

import com.codeborne.selenide.WebDriverRunner;

public class SearchPage {
    public String getCurrentUrl() {
        return WebDriverRunner.url();
    }
}
