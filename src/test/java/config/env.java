package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class env {
	static WebDriver driver = null;

	public static WebDriver CreateWebDriver(String browser) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		System.out.println("Browser: " + browser);

		switch (browser.toLowerCase()) {
		case "ff":
		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "ch":
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "ie":
		case "internetexplorer":
			driver = new InternetExplorerDriver();
			break;

		default:
			System.out.println("Invalid browser name " + browser);
			System.exit(0);
			break;
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
	}

}
