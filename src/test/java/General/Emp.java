package General;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base_Class.Base;
import POM_Classes.Employee;
import POM_Classes.User;
import POM_Classes.UserLogin;

public class Emp {
	
	WebDriver driver;
    
	@BeforeClass
	public void setup() throws InterruptedException {
		Base base1 = new Base();
		driver = base1.getDriver();  // Initialize the driver using getDriver
		UserLogin login = new UserLogin(driver); // Pass the initialized driver to the Login class
		login.enterUsername();
		login.enterPassword();
		//login.clickOnCaptcha();
		login.clickOnSubmit();
		System.out.println("Login successful");
		// driver.quit(); // Optional: Close the browser after the test
	}

	@Test(priority = 1)
	public void registerUser() throws InterruptedException {
		Employee e = new Employee(driver);
		e.navigateAddEmployee();
		e.empDetails();
		e.checkPermanentAddress();
		e.employementDetails();
		e.enterRandomDateOfJoining();
	}
}
