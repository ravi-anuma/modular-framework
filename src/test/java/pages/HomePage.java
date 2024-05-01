package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LoggerUtil;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    private By ticketsMenu = By.xpath("//a[@href='/tickets']");
    private By slideTitles = By.xpath("//div[contains(@class,'slick-slide')]//h3");
    private By slideDurations = By.xpath("//div[contains(@class,'slick-slide')]//span[contains(@class,'slide-duration')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public int countSlides() {
        return driver.findElements(slideTitles).size();
    }

    public List<WebElement> getSlideTitles() {
        return driver.findElements(slideTitles);
    }

    public List<WebElement> getSlideDurations() {
        return driver.findElements(slideDurations);
    }

    public void goToTicketsMenu() {
        driver.findElement(ticketsMenu).click();
    }

   public void  validateDuration(int slideCount, List<WebElement> slideTitles,List<WebElement> slideDurations){
        for (int i = 0; i < slideCount; i++) {
            String expectedTitle = "Expected Title " + (i + 1);
            String actualTitle = slideTitles.get(i).getText();
            if (expectedTitle.equals(actualTitle)) {
                LoggerUtil.logInfo("Title of Slide " + (i + 1) + " matches expected title.");
            } else {
                LoggerUtil.logInfo("Title of Slide " + (i + 1) + " does not match expected title.");
            }

            String expectedDuration = "Expected Duration " + (i + 1);
            String actualDuration = slideDurations.get(i).getText();
            if (expectedDuration.equals(actualDuration)) {
                LoggerUtil.logInfo("Duration of Slide " + (i + 1) + " matches expected duration.");
            } else {
                LoggerUtil.logInfo("Duration of Slide " + (i + 1) + " does not match expected duration.");
            }
        }

    }
}
