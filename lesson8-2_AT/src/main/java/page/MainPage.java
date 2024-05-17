package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    private By afishaIKinoBtn = By.xpath("//a[contains(@href, 'afisha.relax.by') and contains(@class, 'CategoriesMainMenu__item')]");
    private By imgLocator = By.xpath("//div[contains(@class, 'CategoriesMainMenu__itemIcon') and contains(@style, 'background-image:url(https://static.relax.by/images/common/tree/f8561c485aabebae9f3bdb46c59973e4.svg)')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage navigateTo(String url) {
        driver.get(url);
        return this;
    }

    public VsyaAfishaPage clickAfishaIKino() {
        driver.findElement(afishaIKinoBtn).click();
        return new VsyaAfishaPage(driver);
    }
    public List<String> getFotoOtchetyImg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        List<WebElement> imgs = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(imgLocator));
        List<String> styleList = new ArrayList<>();
        for (WebElement img : imgs) {
            String url = img.getAttribute("style").substring(0,img.getAttribute("style").length()-3);
            styleList.add(url);
        }
        return styleList;
    }
}
