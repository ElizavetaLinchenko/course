package page;

import custom.Button;
import custom.ButtonImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ExtendedFieldDecorator;

import java.time.Duration;

public class ZabronirovatKursPage {
    private WebDriver driver;
    private By yMenyaEstField = By.xpath("//input[contains(@id, \"userHave\") and @type=\"text\" " +
            "and @inputmode=\"tel\" and @value=\"\" and @name=\"currency_rate_from\" and @placeholder=\"\" and @data-error=\"\"]");

    @FindBy(xpath = "//div[contains(@class, \"btn\") and contains(@data-currency-booking-form-btn, \"next\") and contains(@id, \"step1\") and normalize-space()=\"Далее\"]")
    private WebElement dalee;

    public ZabronirovatKursPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ZabronirovatKursPage setYMenyaEstField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(yMenyaEstField))).sendKeys("200");
        return new ZabronirovatKursPage(driver);
    }

    public WebElement daleeBtn() {
        Actions actions = new Actions(driver);
        actions.moveToElement(dalee).perform();
        return dalee;
    }
}