package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LoggerUtil;
import utils.PageUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WarriorsHomePage extends BaseTest {
    private WebDriver driver;

    // Constructor
    public WarriorsHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to the shop menu -> men’s
    public void navigateToMensCategory() {
        WebElement shopMenu = driver.findElement(
                By.xpath("//ul[@role='menubar']//span[text()='Shop']/parent::a[@href='https://shop.warriors.com/']"));
        shopMenu.click();
        WebElement mensCategory = driver.findElement(By.xpath("(//a[contains(@title,'Men') and contains(@href, 'https://shop.warriors.com/golden-state-warriors-men')])[1]"));
        PageUtils.waitForElementToBeVisible(driver, mensCategory, 10);
        mensCategory.click();
        LoggerUtil.logInfo("navigate To MensCategory");
    }

    // Method to get all jacket elements
    public List<WebElement> getAllJackets(WebDriver driver) {
        PageUtils.switchToTab(driver);
        return driver.findElements(By.xpath("//div[@class='product-card-title']//a[contains(@href,'golden-state-warriors')]"));
    }

    //close the model
    public void closeModel() throws InterruptedException {
        Thread.sleep(4000);
        WebElement closeModel = driver.findElement(
                By.xpath("//div[contains(@class,'InsiderPopup_modal')]//div[text()='x']"));
        closeModel.click();
    }


    public void writeIntoTextFile(List<WebElement> jacketElements) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("jackets_info.txt"))) {
            // Iterate through each jacket
            for (WebElement jacket : jacketElements) {
                // Extract jacket information
                String title = jacket.getAttribute("title");
                String price = jacket.findElement(By.className("price")).getText();
                String topSeller = jacket.findElement(By.className("top-seller")).getText();

                // Write jacket information to text file
                writer.write("Title: " + title + "\n");
                writer.write("Price: " + price + "\n");
                writer.write("Top Seller: " + topSeller + "\n\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LoggerUtil.logInfo("Test");
    }
}
