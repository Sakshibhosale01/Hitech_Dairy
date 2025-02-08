package Base_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {

	 private WebDriver driver; // Declare WebDriver as an instance variable

	    public WebDriver getDriver(String browser) throws InterruptedException {
	        if (browser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	        }

	        driver.get("https://demo.hitechdairy.in/login");
	        Thread.sleep(2000);
	        driver.manage().window().maximize();
	        return driver;
	    }
}