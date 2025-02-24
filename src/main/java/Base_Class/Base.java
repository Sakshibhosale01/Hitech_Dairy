package Base_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	private static WebDriver driver; // Declare WebDriver as an instance variable

	public WebDriver getDriver() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.hitechdairy.in/login");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		return driver;
	}
	/*
	 * private static WebDriver driver; // Shared WebDriver instance
	 * 
	 * @BeforeSuite // Runs before all tests public void setup() { if (driver ==
	 * null) { // Initialize WebDriver only once
	 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
	 * driver.manage().window().maximize();
	 * driver.get("https://demo.hitechdairy.in/login"); } }
	 * 
	 * public WebDriver getDriver() { return driver; // Return existing driver
	 * instance }
	 * 
	 * @AfterSuite // Runs after all tests public void tearDown() { if (driver !=
	 * null) { driver.quit(); // Close browser driver = null; // Reset driver }
	 */
}