package base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.fail;

public abstract class BasePage extends Base {
    private static Logger log = Logger.getLogger(BasePage.class.getName());

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final Logger logger;


    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(20000));
        this.logger = LogManager.getLogger(this.getClass());
    }

    protected WebElement waitClickableElementByXpath(String locator) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        } catch (WebDriverException e) {
            logger.error("No clickable element: " + locator);
            fail("No clickable element: " + locator);
            return null;
        }
    }
}
