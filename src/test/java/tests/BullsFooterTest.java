package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BullsFooterPage;
import utils.LoggerUtil;

import java.util.List;

public class BullsFooterTest {
    public BaseTest baseTest = new BaseTest();

    @Test
    public void verifyFooterLinksCountAndWriteIntoCSV() {
        try {
            LoggerUtil.logInfo("Test Started");
            WebDriver driver = baseTest.setUp();
            BullsFooterPage footerPage = new BullsFooterPage(driver);

            // Get all footer links
            List<String> footerLinks = footerPage.getFooterLinks();
            LoggerUtil.logInfo("footerLinks:"+footerLinks);

            footerPage.writeIntoCSVFile(footerLinks);
            LoggerUtil.logInfo("Links are saved into CSV");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Close the browser
            baseTest.quit();
        }
    }
}
