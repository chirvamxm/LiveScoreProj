package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends HomePageElements {

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public HomePageHelper clickCloseCookieBarBtn() {
        getCloseCookieBarBtn().click();
        return this;
    }

    public HomePageHelper clickSaturdayBtn() {
        getSaturdayBtn().click();
        return this;
    }

    public HomePageHelper clickEventEngHai() {
        getEventEngHai().click();
        return this;
    }

    public HomePageHelper openSettings() {
        getMenuBtn().click();
        getSettingsBtn().click();
        return this;
    }
}
