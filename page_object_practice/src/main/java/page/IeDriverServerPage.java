package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IeDriverServerPage {

    private WebDriver driver;
    private By ieDriver = By.xpath("//a[contains(@href, '/documentation/ie_driver_server/') and span[text()='IE Driver Server']]");

    public IeDriverServerPage(WebDriver driver) {
        this.driver = driver;
    }
    public IeDriverServerTitlePage clickfindIeDriver() {
        driver.findElement(ieDriver).click();
        return new IeDriverServerTitlePage(driver);
    }
}
