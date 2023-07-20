package pages;

import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class EventPageHelper extends EventPageElements {

    public EventPageHelper(WebDriver driver) {
        super(driver);
    }

    Date date;

    public String getTimeAndDate() {
        String timeAndDate = getTime().getText() + " " + getDate().getText();
        SimpleDateFormat datePattern = new SimpleDateFormat("HH:mm dd MMM");

        try {
            date = datePattern.parse(timeAndDate);
        } catch (ParseException e) {
            System.out.println("Error parsing the date: " + e.getMessage());
        }
        return datePattern.format(date);
    }

    public String convertDateToSpecificTimezone(String targetTimezone) {
        Instant instant = date.toInstant();

        // Create a ZonedDateTime object with the specified time zone
        ZoneId targetZoneId = ZoneId.of(targetTimezone.replace(" ", ""));
        ZonedDateTime zonedDateTime = instant.atZone(targetZoneId);

        // Format the ZonedDateTime to display the date and time in the desired time zone
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd MMM");
        return zonedDateTime.format(formatter);
    }
}