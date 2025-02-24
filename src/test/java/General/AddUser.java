package General;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM_Classes.User;

public class UserRegister {

	    public static void main(String[] args) {
	        // Setup WebDriver
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("http://example.com/user-registration"); // Replace with actual URL

	        // Instantiate POM
	       // User userRegistration = new User(driver);

	        // Fill the form with random data
	        //userRegistration.fillFormWithRandomData();

	        // Submit the form
	        //userRegistration.clickSubmit();

	        // Close browser
	        driver.quit();
	    }
	

}
