package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.WarriorsHomePage;

import java.util.List;

public class NBAWarriorsTest extends BaseTest {

    public BaseTest baseTest = new BaseTest();
    @Test
    public void NBAWarriorsTests() throws InterruptedException {
        try {
            WebDriver driver = baseTest.setUp();

            // Initialize page object
            WarriorsHomePage homePage = new WarriorsHomePage(driver);

            //Close Model
            homePage.closeModel();

            // Navigate to the Shop Menu -> Men’s
            homePage.navigateToMensCategory();

            // Find all jackets (from all paginated pages)
            List<WebElement> jacketElements = homePage.getAllJackets(driver);

            homePage.writeIntoTextFile(jacketElements);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Close the browser
            baseTest.quit();
        }
    }
}
