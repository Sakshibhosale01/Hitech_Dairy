package General;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base_Class.Base;
import Listeners.Class_listerner;
import POM_Classes.UserLogin;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	static WebDriver driver; // Shared WebDriver instance

	@BeforeClass // Runs once before any test methods in this class
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.hitechdairy.in/login");
		Thread.sleep(2000);
	}

	@Test(priority = 0)
	public void LoginUser() throws InterruptedException {
		UserLogin login = new UserLogin(driver); // Pass the initialized driver to the Login class
		login.enterUsername();
		login.enterPassword();
		login.clickOnSubmit();
		System.out.println("Login successful");
	}
}