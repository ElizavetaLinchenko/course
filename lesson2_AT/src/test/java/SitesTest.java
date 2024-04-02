import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SitesTest {
    private static final String baseUrl1 = "https://www.apple.com/";
    private static final String baseUrl2 = "https://www.microsoft.com/";
    private static final String baseUrl3 = "https://www.ikea.com/";
    private static ChromeOptions options;
    private ChromeDriver chromeDriver;
    private MainPage mainPage;

    @BeforeAll
    static void downloadDriver() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    @BeforeEach
    void openBrowser() {
        chromeDriver = new ChromeDriver(options);
        mainPage = new MainPage(chromeDriver);
    }

    @AfterEach
    void closeBrowser() {
        chromeDriver.close();
    }

    @Test
    void checkUrl() throws ParserConfigurationException, IOException, SAXException {
        EmployeeParsing employeeParsing = new EmployeeParsing();
        List<String> siteList = new ArrayList<>();
        siteList.addAll(employeeParsing.task2());

        for (int i = 0; i < siteList.size(); i++) {

            if (i == 0) {
                mainPage.navigateTo(baseUrl1);
                Assertions.assertEquals(baseUrl1, siteList.get(i));

            } else if (i == 1) {
                mainPage.navigateTo(baseUrl2);
                Assertions.assertEquals(baseUrl2, siteList.get(i));

            } else if (i == 2) {
                mainPage.navigateTo(baseUrl3);
                Assertions.assertEquals(baseUrl3, siteList.get(i));
            }
        }
    }

    private void navigateToURL(String url) {
        chromeDriver.get(url);
    }

    @Test
    public void test1ForCompanyPageHandler() throws ParserConfigurationException, IOException, SAXException {
        CompanyPageTest companyPageTest = new CompanyPageTest();
        List<String> companySiteList = companyPageTest.task1();
        navigateToURL(companySiteList.get(0));
        String pageTitle = chromeDriver.getTitle();
        Assertions.assertFalse(pageTitle.isEmpty(), "Empty");
    }

    @Test
    public void test2ForCompanyPageHandler() throws ParserConfigurationException, IOException, SAXException {
        CompanyPageTest companyPageTest = new CompanyPageTest();
        List<String> companySiteList = companyPageTest.task1();
        navigateToURL(companySiteList.get(1));
        String pageTitle = chromeDriver.getTitle();
        Assertions.assertFalse(pageTitle.isEmpty(), "Empty");
    }

    @Test
    public void test3ForCompanyPageHandler() throws ParserConfigurationException, IOException, SAXException {
        CompanyPageTest companyPageTest = new CompanyPageTest();
        List<String> companySiteList = companyPageTest.task1();
        navigateToURL(companySiteList.get(2));
        String pageTitle = chromeDriver.getTitle();
        Assertions.assertFalse(pageTitle.isEmpty(), "Empty");
    }
}