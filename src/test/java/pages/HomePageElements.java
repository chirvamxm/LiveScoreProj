package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageElements extends BasePage {

    public HomePageElements(WebDriver driver) {
        super(driver);
    }

    private static final String CLOSE_COOKIE_BAR = "//button[@id='simpleCookieBarCloseButton']";
    private static final String SAT_JUL_22 = "//a[@data-testid='3__match-calendar-link']";
    private static final String EVENT_ENG_HAI = "//span[@id='0-837818__match-row__status-or-time']";
    private static final String MENU = "//span[@id='burger-menu-open']";
    private static final String SETTINGS = "//a[@id='burger-menu__settings']";

    public WebElement getCloseCookieBarBtn() {
        return waitClickableElementByXpath(CLOSE_COOKIE_BAR);
    }

    public WebElement getSaturdayBtn() {
        return waitClickableElementByXpath(SAT_JUL_22);
    }

    public WebElement getEventEngHai() {
        return waitClickableElementByXpath(EVENT_ENG_HAI);
    }

    public WebElement getMenuBtn() {
        return waitClickableElementByXpath(MENU);
    }

    public WebElement getSettingsBtn() {
        return waitClickableElementByXpath(SETTINGS);
    }
}