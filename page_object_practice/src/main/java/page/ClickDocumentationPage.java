package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickDocumentationPage {

    private WebDriver driver;
    private By documentationBtn = By.xpath("//li[contains(@class, 'nav-item') and .//a[span[text()='Documentation']]]");

    public ClickDocumentationPage(WebDriver driver) {
        this.driver = driver;
    }

    public IeDriverServerPage ClickDocumentationPage() {
        driver.findElement(documentationBtn).click();
        return new IeDriverServerPage(driver);
    }
}
