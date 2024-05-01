/*
package utils;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AssertionsLibrary {

	public void assertElementVisibility(WebElement element) {
		Assert.assertTrue(element.isDisplayed(), "Element is not visible");
	}

	public static void assertIsTrue(boolean actual, String inputValue, String logMessage) {

		try {
			Assertions.assertThat(actual).isTrue();

		} catch (AssertionError assertionErr) {
			throw assertionErr;
		}

	}

	public static void assertContains(String expected, String actual, String inputValue, String logMessage) {
		try {
			Assertions.assertThat(actual).isNotBlank().contains(expected);
		} catch (AssertionError assertionErr) {
			throw assertionErr;
		}
	}

	public static void assertFail(String failureMessage) {
		Assertions.fail(failureMessage);
	}

	public static void assertEquals(String actual, String expected) {
		try {
			Assertions.assertThat(actual).isNotNull().isEqualTo(expected);
		} catch (AssertionError assertionError) {
			throw assertionError;
		}
	}

}
*/
