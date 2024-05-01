package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private static final String PROPERTY_FILE_PATH = "resources\\configs\\config.properties";

	public ConfigFileReader() {
		try (FileReader fileReader = new FileReader(PROPERTY_FILE_PATH)) {
			try (BufferedReader reader = new BufferedReader(fileReader)) {
				loadProperties(reader);
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException=" + e);
		} catch (IOException e) {
			System.out.println("IOException = " + e);
		}

	}

	public ConfigFileReader(String configFilePath) {
		try (FileReader fileReader = new FileReader(configFilePath)) {
			try (BufferedReader reader = new BufferedReader(fileReader)) {
				loadProperties(reader);
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException=" + e);
		} catch (IOException e) {
			System.out.println("IOException = " + e);
		}
	}

	private void loadProperties(BufferedReader reader) {
		properties = new Properties();
		try {
			properties.load(reader);
		} catch (IOException e) {
			System.out.println("IOException = " + e);
			throw new RuntimeException(e);
		}
	}

	public String getUsername() {
		String username = System.getProperty("username");
		if (username == null) {
			username = properties.getProperty("username");
		}
		if (username == null) {
			throw new RuntimeException("username not specified in the config.properties file / maven command.");
		}
		return username;
	}

	public DriverType getBrowser() {
		String browserName = System.getProperty("browser");

		if (browserName == null) {
			browserName = properties.getProperty("browser");
		}
		if (browserName == null) {
			throw new RuntimeException("browserName not specified in the config.properties file / maven command.");
		}
		return getDriverType(browserName);
	}

	private static DriverType getDriverType(String browserName) {
		DriverType browserDriverType = null;
		switch (browserName.toLowerCase(Locale.getDefault())) {
		case "firefox":
			browserDriverType = DriverType.FIREFOX;
			break;
		default:
			browserDriverType = DriverType.CHROME;
			break;
		}
		return browserDriverType;
	}

	public String getApplicationUrl() {
		String url = System.getProperty("url");
		if (url == null) {
			url = properties.getProperty("url");
		}
		if (url == null) {
			throw new RuntimeException("url not specified in the config.properties file / maven command.");
		}
		return url;
	}
}