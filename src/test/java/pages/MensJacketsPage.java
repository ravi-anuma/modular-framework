package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MensJacketsPage {
	private WebDriver driver;
	private By jacketElements = By.cssSelector("div[class*='jacket']");

	public MensJacketsPage(WebDriver driver) {
		this.driver = driver;
	}

	public List<Jacket> getJackets() {
		List<Jacket> jackets = new ArrayList<>();
		List<WebElement> jacketElements = driver.findElements(this.jacketElements);

		for (WebElement element : jacketElements) {
			String title = element.findElement(By.cssSelector("h3")).getText();
			String price = element.findElement(By.cssSelector("span[class*='price']")).getText();
			String topSellerMessage = element.findElement(By.cssSelector("span[class*='top-seller']")).getText();
			jackets.add(new Jacket(title, price, topSellerMessage));
		}

		return jackets;
	}
}
