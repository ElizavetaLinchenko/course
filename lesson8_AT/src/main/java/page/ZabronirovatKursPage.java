package page;

import custom.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ExtendedFieldDecorator;

import java.time.Duration;

public class ZabronirovatKursPage {
    private WebDriver driver;
    private By yMenyaEstField = By.xpath("//input[contains(@class, \"active\") and contains(@id, \"userHave\")]");
    private By zabronirovatKurs = By.xpath("//a[contains(@class, \"btn-primary\") and contains(@href, \"zabronirovat-kurs\")]");
    private By converter = By.xpath("//a[contains(@class, \"chip\") and contains(@href, \"/converter\")]");

    @FindBy(xpath = "//div[contains(@id, \"step1\")]")
    private Button dalee;

    public ZabronirovatKursPage(WebDriver driver) {
        PageFactory.initElements(new ExtendedFieldDecorator(driver), this);
        this.driver = driver;
    }

    public ZabronirovatKursPage clickZabronirovatKursBtn() {
        driver.findElement(zabronirovatKurs).click();
        return new ZabronirovatKursPage(driver);
    }

    public CurrencyPage clickConverterBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement converterButton = wait.until(ExpectedConditions.elementToBeClickable(converter));
        converterButton.click();
        return new CurrencyPage(driver);
    }

    public ZabronirovatKursPage setYMenyaEstField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(yMenyaEstField))).sendKeys("200");
        return new ZabronirovatKursPage(driver);
    }

    public Button daleeBtn() {
        return daleeBtn();
    }
}