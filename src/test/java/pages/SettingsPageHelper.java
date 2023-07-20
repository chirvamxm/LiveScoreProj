package pages;

import org.openqa.selenium.WebDriver;

public class SettingsPageHelper extends SettingsPageElements {

    public SettingsPageHelper(WebDriver driver) {
        super(driver);
    }

    public SettingsPageHelper changeTimeZone(String utc) {
        getTimezoneDropdownMenuBtn().click();
        getUTSBtn(utc).click();
        getApplyBtn().click();
        return this;
    }
}
