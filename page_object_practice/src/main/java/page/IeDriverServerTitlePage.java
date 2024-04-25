package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IeDriverServerTitlePage {
    private WebDriver driver;

    public IeDriverServerTitlePage(WebDriver driver) {
        this.driver = driver;
    }

    public String findIeDriverTitle() {
        return driver.findElement(By.xpath("//h1[text()='IE Driver Server']")).getText();
    }
}
