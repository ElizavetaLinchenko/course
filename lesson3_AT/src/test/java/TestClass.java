import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TestClass {
    private final static String url = "file:///" + System.getProperty("user.dir") + "/src/test/resources/homework.html";
    private static ChromeOptions options;
    private WebDriver driver;

    private String login = "000000000000000000000000000000123";
    private String password = "password";
    private String documentTitle = "Variant 4";
    private String testUrl = "https://metanit.com/web/html5/5.1.php";

    @BeforeAll
    static void downloadDriver() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    @BeforeEach
    void openBrowser() {
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void closeBrowser() {
        driver.close();
    }

    private static void fillField(WebElement field, String value) {
        field.sendKeys(value);
    }

    @Test
    void firstTest() {
        driver.get(url);

        WebElement fieldLogin = driver.findElement(By.xpath("//input[@id='login']"));
        fillField(fieldLogin, login);
        Assertions.assertEquals(30, fieldLogin.getAttribute("value").length());

        WebElement fieldPassword = driver.findElement(By.xpath("//input[@id='password']"));
        fillField(fieldPassword, password);
        Assertions.assertEquals(password, fieldPassword.getAttribute("value"));
        Assertions.assertEquals("password", fieldPassword.getAttribute("type"));
    }

    @Test
    void secondTest() {
        driver.get(url);

        String pageTitle = driver.getTitle();
        Assertions.assertEquals(documentTitle, pageTitle);

        WebElement loginLabel = driver.findElement(By.xpath("//label[@for='login']"));
        WebElement passwordLabel = driver.findElement(By.xpath("//label[@for='password']"));
        Assertions.assertEquals("Login", loginLabel.getText());
        Assertions.assertEquals("Password", passwordLabel.getText());

        WebElement redirectButton = driver.findElement(By.xpath("/html/body/button"));
        String btnStyle = redirectButton.getAttribute("style");
        Assertions.assertTrue(btnStyle.contains("color: blue"));

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        Assertions.assertEquals(5, checkboxes.size());

        WebElement firstCheckbox = checkboxes.get(0);
        WebElement lastCheckbox = checkboxes.get(checkboxes.size() - 1);
        WebElement penultimateCheckbox = checkboxes.get(checkboxes.size() - 2);
        Assertions.assertTrue(firstCheckbox.isSelected());
        Assertions.assertTrue(lastCheckbox.isSelected());
        Assertions.assertTrue(penultimateCheckbox.isSelected());
    }

    @Test
    void thirdTest() {
        driver.get(url);

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        fillField(passwordField, password);

        WebElement loginField = driver.findElement(By.xpath("//input[@id='login']"));
        Assertions.assertEquals(password, passwordField.getAttribute("value"));
        Assertions.assertEquals("", loginField.getAttribute("value"));

        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        WebElement dateField = driver.findElement(By.xpath("//input[@id='date']"));
        fillField(dateField, formattedDate);

        WebElement submitButton = driver.findElement(By.xpath("/html/body/button"));
        submitButton.click();

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(testUrl, currentUrl);
    }
}