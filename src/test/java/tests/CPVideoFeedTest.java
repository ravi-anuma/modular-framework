package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.CPVideoFeedPage;
import utils.LoggerUtil;

public class CPVideoFeedTest {
    public BaseTest baseTest = new BaseTest();

    @Test
    public void verifyCoreProductVideoFeedCount() throws InterruptedException {
        try {
            //Driver launch
            LoggerUtil.logInfo("Test Started");
            WebDriver driver = baseTest.setUp();
            CPVideoFeedPage feedPage = new CPVideoFeedPage();

            feedPage.clickMenu(driver);
            String newsXpath = "//a[contains(@href,'/warriors/news/')]/parent::div/..//time";
            feedPage.getVideoFeedCount(driver, newsXpath);
            String videosXpath = "//a[contains(@href,'/warriors/videos/')and contains(@class,'TileArticle_tileLink')]/parent::div/..//time";
            feedPage.getVideoFeedCount(driver, videosXpath);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Close the browser
            baseTest.quit();
        }
    }
}
