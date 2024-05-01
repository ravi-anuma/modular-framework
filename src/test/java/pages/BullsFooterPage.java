package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.JsonUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BullsFooterPage {
    private WebDriver driver;
    String footerLinkXpath= JsonUtils.readJsonData("footerLinks");
    private By footerLinks = By.xpath(footerLinkXpath);

    public BullsFooterPage(WebDriver driver) {
        this.driver = driver;
    }
    public BullsFooterPage() {
    }

    public List<String> getFooterLinks() {
        List<String> links = new ArrayList<>();
        List<WebElement> linkElements = driver.findElements(footerLinks);
        for (WebElement element : linkElements) {
            String link = element.getAttribute("href");
            if (link != null && !link.isEmpty()) {
                links.add(link);
            }
        }
        return links;
    }

    public void writeIntoCSVFile(List<String> footerLinks) {
        // Check for duplicate links
        Set<String> uniqueLinks = new HashSet<>();
        Set<String> duplicateLinks = new HashSet<>();
        for (String link : footerLinks) {
            if (!uniqueLinks.add(link)) {
                duplicateLinks.add(link);
            }
        }

        // Write footer links to CSV file
        try (FileWriter writer = new FileWriter("footer_links.csv")) {
            writer.write("Link\n");
            for (String link : footerLinks) {
                writer.write(link + "\n");
            }
            System.out.println("Footer links written to footer_links.csv");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        // Report duplicate links
        if (!duplicateLinks.isEmpty()) {
            System.out.println("Duplicate links found:");
            for (String link : duplicateLinks) {
                System.out.println(link);
            }
        } else {
            System.out.println("No duplicate links found.");
        }
    }
}
