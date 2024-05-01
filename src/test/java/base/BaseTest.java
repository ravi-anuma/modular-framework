package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import utils.WebdriverManager;

public class BaseTest {
    public WebDriver driver;
    private WebdriverManager manager = new WebdriverManager();

    public WebDriver setUp() throws InterruptedException {
       WebDriver driver= manager.createLocalDriver();
       return driver;
    }

    @AfterSuite
    public void quit(){
        driver.quit();
    }


}
