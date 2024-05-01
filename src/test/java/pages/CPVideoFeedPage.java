package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LoggerUtil;
import utils.PageUtils;

import java.util.List;

public class CPVideoFeedPage {

    public void clickMenu(WebDriver driver) {
        WebElement menuItem = driver.findElement(By.xpath("//span[text()='...']/parent::a[@href='/warriors/news']"));
        PageUtils.hoverAndClick(menuItem);
        WebElement newAndFeatures = driver.findElement(By.xpath("(//li[@data-testid='nav-item-https://community.warriors.com/']/preceding::li[@data-testid='nav-item-/warriors/news'])[1]"));
        newAndFeatures.click();
    }

    public int getVideoFeedCount(WebDriver driver, String xpath) {
        // Identify video feed elements
        List<WebElement> newsFeed = driver.findElements(By.xpath(xpath));

        // Count total number of new feeds
        int totalnewsFeeds = newsFeed.size();
        LoggerUtil.logInfo("Total number of feeds: " + totalnewsFeeds);

        // Initialize count for video feeds published within the last three days
        int recentVideoFeedsCount = 0;

        // Iterate through each video feed
        for (WebElement we : newsFeed) {
            // Get the publication date of the video feed
            String publicationDateString = we.getText();

            // Check if the duration is greater than or equal to 3 days
            if (publicationDateString.contains("d")) {
                int days = Integer.parseInt(publicationDateString.replaceAll("\\D", ""));
                if (days >= 3) {
                    recentVideoFeedsCount++;
                }
            }
        }
        LoggerUtil.logInfo("Number of video feeds published within the last three days: " + recentVideoFeedsCount);

        return recentVideoFeedsCount;
    }
}
