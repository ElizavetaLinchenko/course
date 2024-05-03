package custom;

import org.openqa.selenium.WebElement;

public class ButtonImpl extends AbstractElement implements Button {

    public ButtonImpl(final WebElement wrapperElement) {
        super(wrapperElement);
    }

    @Override
    public boolean isDisplayed() {
        return wrapperElement.isDisplayed();
    }
}