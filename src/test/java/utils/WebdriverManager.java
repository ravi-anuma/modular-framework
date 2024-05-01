package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.HashMap;

public class WebdriverManager {
    public WebDriver driver;
    public DriverType driverType;
    public ConfigFileReader configFileReader;

    public WebdriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
    }

    public static WebDriver createChromeDriver() {
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        String downloadFilepath = System.getProperty(Constants.USER_DIRECTORY) + "\\SampleDownloadFiles";
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        return new ChromeDriver(options);
    }

    public void closeDriver() {
        driver.quit();
        driver = null;
    }

    public WebDriver createLocalDriver() throws InterruptedException {
        switch (driverType) {
            case FIREFOX:
                driver = createFirefoxDriver();
                break;
            case CHROME:
                driver = createChromeDriver();
                break;
            case EDGE:
                driver = createEDGEDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.get(new ConfigFileReader().getApplicationUrl());
        driver.manage().window().maximize();
        Thread.sleep(5000);
        return driver;
    }

    private WebDriver createEDGEDriver() {
        WebDriverManager.edgedriver().setup();
        String downloadFilepath = System.getProperty(Constants.USER_DIRECTORY) + File.separator
                + Constants.SAMPLE_DOWNLAOD_FILES;
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.valueOf("eager"));
        WebDriver driver = new EdgeDriver(options);
        return driver;
    }

    public static WebDriver createFirefoxDriver() {
        io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
        String downloadFilepath = System.getProperty(Constants.USER_DIRECTORY) + File.separator
                + Constants.SAMPLE_DOWNLAOD_FILES;

        FirefoxProfile profile = new FirefoxProfile();
        // Set Location to store files after downloading
        profile.setPreference("browser.download.dir", downloadFilepath);
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        return new FirefoxDriver(options);
    }

}
