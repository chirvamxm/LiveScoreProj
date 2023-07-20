package tests;

import base.TestInit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EventPageHelper;
import pages.HomePageHelper;
import pages.SettingsPageHelper;

public class TimeZoneChangingTest extends TestInit {

    public final String pageUrl = "https://www.livescore.com/en/";

    @DataProvider(name = "timeZones")
    public static Object[][] timeZones() {
        return new Object[][]{
                {"UTC +07:00"},
                // Add more time zones for testing
        };
    }

    @Test(dataProvider = "timeZones")
    public void checkTimeZoneAfterChanging(String timezone) {
        HomePageHelper homePage = new HomePageHelper(driver);
        EventPageHelper eventPage = new EventPageHelper(driver);
        SettingsPageHelper settingsPage = new SettingsPageHelper(driver);

        goToSite(pageUrl);
        homePage
                .clickCloseCookieBarBtn()
                .clickSaturdayBtn()
                .clickEventEngHai();

        String dateBeforeChangingTimezone = eventPage.getTimeAndDate();
        homePage
                .openSettings();
        settingsPage
                .changeTimeZone(timezone);

        String dateInTestedTimeZone = eventPage.convertDateToSpecificTimezone(timezone);
        String dateAfterChangingTimezone = eventPage.getTimeAndDate();

        Assert.assertNotEquals(dateBeforeChangingTimezone, dateAfterChangingTimezone, "Timezone is not changed");
        Assert.assertEquals(dateInTestedTimeZone, dateAfterChangingTimezone, "Timezone identified incorrectly");
    }
}
