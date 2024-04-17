package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;


public class TestingStepDefinition {
    private WebDriver driver;

    @Given("Open browser and maximize window")
    public void openBrowserAndMaximizeWindow() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @When("Navigate to the {string}")
    public void navigateToUrl(String url) {
        driver.get(url);
    }

    @Then("Verify that the current img has .png format")
    public void verifyThatCurrentImgIs() {
        List<WebElement> jenkinsImage = driver.findElements(By.xpath("//div[contains(@id, \"ProjectCarousel_\")]//div/a/img"));
        Assertions.assertEquals(5, jenkinsImage.size());
        for (WebElement element : jenkinsImage) {
            String srcLink = element.getAttribute("src");
            Assertions.assertTrue(srcLink.endsWith("png"));
        }
    }

    @And("Click to the DOCS tab")
    public void clickToTheDocsTab() {
        driver.findElement(By.xpath("//ul//a[@href= \"#docs\"]")).click();
    }

    @And("Click to the GettingStarted tab")
    public void clickToTheGettingStartedTab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement gettingStartedElement = driver.findElement(By.xpath("//li//a[@href= \"https://github.com/rest-assured/rest-assured/wiki/GettingStarted\"]"));
        js.executeScript("arguments[0].click();", gettingStartedElement);
    }

    @Then("Verify that the GettingStarted text is shown")
    public void verifyThatTheGettingStartedTextIsShown() {
        WebElement gettingStarted = driver.findElement(By.xpath("//div[@id=\"wiki-wrapper\"]/div/h1"));
        Assertions.assertTrue(gettingStarted.isDisplayed());
    }

    @Then("Verify that the current URL is {string}")
    public void testingCurrentUrl(String url) {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(url, currentUrl);
    }

    @And("Click to the Downloads tab")
    public void clickToTheDownloadsTab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement downloadsElement = driver.findElement(By.xpath("//li//a[@href= \"https://github.com/rest-assured/rest-assured/wiki/Downloads\"]"));
        js.executeScript("arguments[0].click();", downloadsElement);
    }

    @Then("Verify that the Downloads text is shown")
    public void verifyThatTheDownloadsTextIsShown() {
        WebElement downloads = driver.findElement(By.xpath("//div[@id=\"wiki-wrapper\"]/div/h1"));
        Assertions.assertTrue(downloads.isDisplayed());
    }

    @Then("Verify that the table has two columns and eight rows")
    public void verifyThatTheTableHasTwoColumnsAndEightRows() {
        List<WebElement> columns = driver.findElements(By.xpath("//div[@id='wiki-body']//table//th"));
        Assertions.assertEquals(2, columns.size());
        List<WebElement> rows = driver.findElements(By.xpath("//div[@id=\"wiki-body\"]/div/table/tbody//tr"));
        Assertions.assertEquals(8, rows.size());
    }
}