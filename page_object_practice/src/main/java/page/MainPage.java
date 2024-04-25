package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private By documentationBtn = By.xpath("//li[contains(@class, 'nav-item') and .//a[span[text()='Documentation']]]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage navigateTo(String url) {
        driver.get(url);
        return this;
    }

    public IeDriverServerPage clickDocumentationPage() {
        driver.findElement(documentationBtn).click();
        return new IeDriverServerPage(driver);
    }
}
