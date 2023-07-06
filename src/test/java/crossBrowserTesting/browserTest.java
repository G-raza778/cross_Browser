package crossBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browserTest {
	WebDriver driver;
	FirefoxOptions firefoxOptions = new FirefoxOptions();
	ChromeOptions chromeOptions = new ChromeOptions();
	EdgeOptions edgeOptions = new EdgeOptions();
	
	@Parameters("browser")
	@BeforeTest
	public void intialise(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("firefox is launched");
		} else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome is launched");
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("edge is launched");
		}
	}

	@Test
	public void google() {
		driver.get("https://www.google.com");
		String actual = driver.getTitle();
		String expected = "google";
		Assert.assertEquals(actual.contains("google"), expected.contains("google"));

	}

	@AfterTest
	public void finalise() {
		driver.quit();
	}
}
