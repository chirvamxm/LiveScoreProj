package listeners;

import base.TestInit;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pages.HomePageHelper;

import java.io.File;

public class TestListener implements ITestListener {

    private static Logger log = Logger.getLogger(HomePageHelper.class.getName());

    public void onTestSuccess(ITestResult tr) {
        String str = "Test " + tr.getMethod().getMethodName() + " success";
        log.info("*----------------------* " + str + " *----------------------*");
    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = ((TestInit) result.getInstance()).getDriver();
        screen(driver);
        String str = "Test " + result.getMethod().getMethodName() + " failure";
        String str1 = "Failed because of - " + result.getThrowable();
        log.info("*----------------------* " + str + " *----------------------*");
        log.info("*----------------------* " + str1 + " *----------------------*");
    }

    @SneakyThrows
    private void screen(WebDriver driver) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("target/screen//" + scrFile.getName()));
    }

    @SneakyThrows
    @Override
    public void onTestSkipped(ITestResult result) {
        WebDriver driver = ((TestInit) result.getInstance()).getDriver();
        screenAfterSkip(driver);
        String str = "Test " + result.getMethod().getMethodName() + " skipped";
        String str1 = "Skipped because of - " + result.getThrowable();
        log.info("*----------------------* " + str + " *----------------------*");
        log.info("*----------------------* " + str1 + " *----------------------*");
    }

    @SneakyThrows
    private void screenAfterSkip(WebDriver driver) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("target/allure-results/screen//" + scrFile.getName()));
    }
}
