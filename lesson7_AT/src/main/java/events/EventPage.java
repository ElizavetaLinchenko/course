package events;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[contains(@href, 'trial_registrations/new')][contains(text(), 'Get Free Trial')]")
    private WebElement title;

    public EventPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getTitle() {
        return title;
    }
}