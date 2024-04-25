package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuickStartGuidesPage {
    private WebDriver driver;
    private By quickStartGuides = By.xpath("//a[contains(@class, 'navigation-dropdown__popover-link') and contains(@href, '/get-started/') and contains(., 'Quick start guides')]");

    public QuickStartGuidesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WatchDemoPage clickQuickStartGuides() {
        driver.findElement(quickStartGuides).click();
        return new WatchDemoPage(driver);
    }
}