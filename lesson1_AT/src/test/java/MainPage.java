import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void siteUrl() {
        driver.get("https://ru.selenide.org/index.html");
    }
}