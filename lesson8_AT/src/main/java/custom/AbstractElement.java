package custom;

import org.openqa.selenium.WebElement;

public abstract class AbstractElement implements Element {
    protected WebElement wrapperElement;

    protected AbstractElement(final WebElement wrapperElement) {
        this.wrapperElement = wrapperElement;
    }
}