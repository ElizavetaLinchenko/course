package page;

import custom.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ExtendedFieldDecorator;

import java.time.Duration;

public class ZabronirovatKursPage {
    private WebDriver driver;
    private By yMenyaEstField = By.xpath("//input[@name='currency_rate_from']");

    @FindBy(xpath = "//div[contains(@id, \"step1\")]")
    private Button dalee;

    public ZabronirovatKursPage(WebDriver driver) {
        PageFactory.initElements(new ExtendedFieldDecorator(driver), this);
        this.driver = driver;
    }

    public ZabronirovatKursPage setYMenyaEstField(String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(yMenyaEstField)).sendKeys(value);
        return new ZabronirovatKursPage(driver);
    }

    public Button daleeBtn() {
        return dalee;
    }
}