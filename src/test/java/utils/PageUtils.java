package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;

public class PageUtils {

    public void click(WebElement pageElement, String logMessage) {
        try {
            pageElement.click();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void hoverAndClick(WebElement we) {
        WebDriver driver = null;

        try {
            Actions action = new Actions(driver);
            action.moveToElement(we).click(we).build().perform();
        } catch (RuntimeException e) {
            String errorMessage = "error while performing hoverAndClick operation - " + e;
            throw e;
        }
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement we, int timeout) {

        try {

            Duration timeOut = Duration.ofSeconds(timeout);
            WebElement wt = new FluentWait<WebDriver>(driver).withTimeout(timeOut)
                    .pollingEvery(Constants.POLLING_FREQUENCY).ignoring(Throwable.class)
                    .until(ExpectedConditions.visibilityOfElementLocated((By) we));
            return wt;
        } catch (RuntimeException e) {
            return null;
        }
    }

    public static void switchToTab(WebDriver driver) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
}
