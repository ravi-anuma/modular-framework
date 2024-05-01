package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.LoggerUtil;

import java.util.List;

public class CoreProductSixersPage {
    public BaseTest baseTest = new BaseTest();

    @Test
    public void verifySldesCountAndDuration() {
        try {
            LoggerUtil.logInfo("Test Started");
            WebDriver driver = baseTest.setUp();
            HomePage homePage = new HomePage(driver);
            LoggerUtil.logInfo("goToTicketsMenu");
            homePage.goToTicketsMenu();

            // Count number of slides
            int slideCount = homePage.countSlides();
            LoggerUtil.logInfo("slideCount:"+slideCount);

            // Get titles and durations of slides
            List<WebElement> slideTitles = homePage.getSlideTitles();
            List<WebElement> slideDurations = homePage.getSlideDurations();

            // Validate titles and durations
            homePage.validateDuration(slideCount, slideTitles, slideDurations);
            // Close the browser
            driver.quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // Close the browser
            baseTest.quit();
        }
    }
}
