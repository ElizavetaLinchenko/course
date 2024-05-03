package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrencyPage {
    private WebDriver driver;

    public CurrencyPage(WebDriver driver) {
        this.driver = driver;
    }

    public CurrencyPage setCurrencyValue(String currency, int value) {
        By currencyField = By.xpath(String.format("//input[contains(@class, 'input_calc') and @id='nbrb_%s']", currency));
        WebElement currencyInput = driver.findElement(currencyField);
        currencyInput.clear();
        currencyInput.sendKeys(String.valueOf(value));
        return this;
    }

    public String getFieldValue(String currency) {
        WebElement currencyInput = driver.findElement(By.xpath(String.format("//input[contains(@class, 'input_calc') and @id='nbrb_%s']", currency)));
        return currencyInput.getAttribute("value");
    }
}