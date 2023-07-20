package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EventPageElements extends BasePage {

    public EventPageElements(WebDriver driver) {
        super(driver);
    }

    private static final String TIME = "//span[@id='score-or-time']";
    private static final String DATE = "//span[@id='SEV__status']";

    public WebElement getTime() {
        return waitClickableElementByXpath(TIME);
    }

    public WebElement getDate() {
        return waitClickableElementByXpath(DATE);
    }
}
