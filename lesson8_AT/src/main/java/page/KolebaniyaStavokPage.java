package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KolebaniyaStavokPage {
    private WebDriver driver;

    public KolebaniyaStavokPage(WebDriver driver) {
        this.driver = driver;
    }

    public String findKolebaniyaStavokTitle() {
        return driver.findElement(By.xpath("//span[contains(@class, \"fake-link\") and normalize-space()=\"Колебания ставок на вклады\"]")).getText();
    }
}