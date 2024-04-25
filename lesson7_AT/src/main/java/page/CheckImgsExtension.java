package page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckImgsExtension {
    private WebDriver driver;
    private By imgLocator = By.xpath("//img[contains(@src, 'hero')]");

    public CheckImgsExtension(WebDriver driver) {
        this.driver = driver;
}
        public void checkingImgExtension() {
            List<WebElement> gitLabImgs = driver.findElements(imgLocator);
            Assertions.assertEquals(3, gitLabImgs.size());
            for (WebElement element : gitLabImgs) {
                String srcLink = element.getAttribute("src");
                Assertions.assertTrue(srcLink.endsWith("png"));
            }
        }
    }

