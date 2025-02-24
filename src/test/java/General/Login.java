package General;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base_Class.BaseClass1;
import Listeners.Class_listerner;
import POM_Classes.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Page {

	private WebDriver driver; // Declare as a class-level variable
	
	  public Login_Page(WebDriver driver) { // Accept WebDriver in constructor
	        this.driver = driver;
	    }
	
	@Test(priority = 0)
    public void LoginUser() throws InterruptedException{
        BaseClass1 base = new BaseClass1();     
        driver = base.getDriver("Chrome");       // Initialize the driver using getDriver
        Login login = new Login(driver); // Pass the initialized driver to the Login class
        login.enterUsername();
        login.enterPassword();
        login.clickOnCaptcha();
        login.clickOnSubmit();
        Thread.sleep(2000);
        System.out.println("Login successful");
       // driver.quit();       // Optional: Close the browser after the test
}
}