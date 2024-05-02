package custom;

import org.openqa.selenium.WebElement;

public class ButtonImpl extends AbstractElement implements Button {

    protected ButtonImpl(final WebElement wrapperElement) {
        super(wrapperElement);
    }

    @Override
    public void hover() {
        System.out.println("Button hover is called");
    }

    @Override
    public void click() {
        System.out.println("Click is called");
        wrapperElement.click();
    }

    @Override
    public boolean isDisplayed() {
        return wrapperElement.isDisplayed();
    }
}