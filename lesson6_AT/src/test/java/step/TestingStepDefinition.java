package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;


public class TestingStepDefinition {

    @When("Navigate to the {string}")
    public void navigateToUrl(String url) {
        BaseTest.getDriver().get(url);
    }

    @Then("Verify that the current img has .png format")
    public void verifyThatCurrentImgIs() {
        List<WebElement> jenkinsImage = BaseTest.getDriver().findElements(By.xpath("//div[contains(@id, \"ProjectCarousel_\")]//div/a/img"));
        Assertions.assertEquals(5, jenkinsImage.size());
        for (WebElement element : jenkinsImage) {
            String srcLink = element.getAttribute("src");
            Assertions.assertTrue(srcLink.endsWith("png"));
        }
    }

    @And("Click to the DOCS tab")
    public void clickToTheDocsTab() {
        BaseTest.getDriver().findElement(By.xpath("//ul//a[@href= \"#docs\"]")).click();
    }

    @And("Click to the GettingStarted tab")
    public void clickToTheGettingStartedTab() {
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.getDriver();
        WebElement gettingStartedElement = BaseTest.getDriver().findElement(By.xpath("//li//a[@href= \"https://github.com/rest-assured/rest-assured/wiki/GettingStarted\"]"));
        js.executeScript("arguments[0].click();", gettingStartedElement);
    }

    @Then("Verify that the GettingStarted text is shown")
    public void verifyThatTheGettingStartedTextIsShown() {
        WebElement gettingStarted = BaseTest.getDriver().findElement(By.xpath("//div[@id=\"wiki-wrapper\"]/div/h1"));
        Assertions.assertTrue(gettingStarted.isDisplayed());
    }

    @Then("Verify that the current URL is {string}")
    public void testingCurrentUrl(String url) {
        String currentUrl = BaseTest.getDriver().getCurrentUrl();
        Assertions.assertEquals(url, currentUrl);
    }

    @And("Click to the Downloads tab")
    public void clickToTheDownloadsTab() {
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.getDriver();
        WebElement downloadsElement = BaseTest.getDriver().findElement(By.xpath("//li//a[@href= \"https://github.com/rest-assured/rest-assured/wiki/Downloads\"]"));
        js.executeScript("arguments[0].click();", downloadsElement);
    }

    @Then("Verify that the Downloads text is shown")
    public void verifyThatTheDownloadsTextIsShown() {
        WebElement downloads = BaseTest.getDriver().findElement(By.xpath("//div[@id=\"wiki-wrapper\"]/div/h1"));
        Assertions.assertTrue(downloads.isDisplayed());
    }

    @Then("Verify that the table has two columns and eight rows")
    public void verifyThatTheTableHasTwoColumnsAndEightRows() {
        List<WebElement> columns = BaseTest.getDriver().findElements(By.xpath("//div[@id='wiki-body']//table//th"));
        Assertions.assertEquals(2, columns.size());
        List<WebElement> rows = BaseTest.getDriver().findElements(By.xpath("//div[@id=\"wiki-body\"]/div/table/tbody//tr"));
        Assertions.assertEquals(8, rows.size());
    }
}