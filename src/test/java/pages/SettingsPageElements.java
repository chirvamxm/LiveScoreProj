package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingsPageElements extends BasePage {

    public SettingsPageElements(WebDriver driver) {
        super(driver);
    }

    private static final String TIMEZONE_DROPDOWN_MENU = "//div[@id='TZ_SELECT-select-wrapper']";
    private static final String UTC = "//div[contains(@id,'TZ_SELECT__')and contains(text(),'%s')]";
    private static final String APPLY = "//div[@id='settings-modal-apply-wrapper']";

    public WebElement getTimezoneDropdownMenuBtn() {
        return waitClickableElementByXpath(TIMEZONE_DROPDOWN_MENU);
    }

    public WebElement getUTSBtn(String utc) {
        return waitClickableElementByXpath(String.format(UTC, utc));
    }

    public WebElement getApplyBtn() {
        return waitClickableElementByXpath(APPLY);
    }
}