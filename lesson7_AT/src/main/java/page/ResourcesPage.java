package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResourcesPage {
    private WebDriver driver;
    private By resourcesBtn = By.xpath("//li[@class='navigation-item']//div[@class='navigation-dropdown']//button[@name='Resources']");
    private By quickStartGuides = By.xpath("//a[contains(@class, 'navigation-dropdown__popover-link') and contains(@href, '/get-started/') and contains(., 'Quick start guides')]");

    public ResourcesPage(WebDriver driver) {
        this.driver = driver;
    }

    public ResourcesPage clickResourcesBtn() {
        driver.findElement(resourcesBtn).click();
        return new ResourcesPage(driver);
    }

    public WatchDemoPage clickQuickStartGuidesBtn() {
        driver.findElement(quickStartGuides).click();
        return new WatchDemoPage(driver);
    }
}