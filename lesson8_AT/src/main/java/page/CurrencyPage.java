package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrencyPage {
    private WebDriver driver;

    private By usdField = By.xpath("//input[contains(@class, \"input_calc\") and @id=\"nbrb_usd\"]");
    private By bynField = By.xpath("//input[contains(@class, \"input_calc\") and @id=\"nbrb_byn\"]");
    private By rubField = By.xpath("//input[contains(@class, \"input_calc\") and @id=\"nbrb_rub\"]");
    private By cnyField = By.xpath("//input[contains(@class, \"input_calc\") and @id=\"nbrb_cny\"]");
    private By plnField = By.xpath("//input[contains(@class, \"input_calc\") and @id=\"nbrb_pln\"]");
    private By eurField = By.xpath("//input[contains(@class, \"input_calc\") and @id=\"nbrb_eur\"]");

    public CurrencyPage(WebDriver driver) {
        this.driver = driver;
    }

    public CurrencyPage setCurrencyValue(String currency, int value) {
        By currencyField = getCurrencyFieldLocator(currency);
        WebElement currencyInput = driver.findElement(currencyField);
        currencyInput.clear();
        currencyInput.sendKeys(String.valueOf(value));
        return this;
    }

    public String getUsdFieldValue() {
        WebElement usdInput = driver.findElement(usdField);
        return usdInput.getAttribute("value");
    }

    private By getCurrencyFieldLocator(String currency) {
        switch (currency) {
            case "usd":
                return usdField;
            case "byn":
                return bynField;
            case "rub":
                return rubField;
            case "cny":
                return cnyField;
            case "pln":
                return plnField;
            case "eur":
                return eurField;
            default:
                throw new IllegalArgumentException("Invalid currency: " + currency);
        }
    }
}