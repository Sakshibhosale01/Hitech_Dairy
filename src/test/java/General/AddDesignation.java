package General;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base_Class.BaseClass1;
import POM_Classes.Department;
import POM_Classes.Designation;
import POM_Classes.Login;

public class Designation_Register {

	private WebDriver driver; // Declare as a class-level variable

	@BeforeClass
	public void LoginUser() throws InterruptedException {
		BaseClass1 base = new BaseClass1();
		driver = base.getDriver("Chrome"); // Initialize the driver using getDriver
		Login login = new Login(driver); // Pass the initialized driver to the Login class
		login.enterUsername();
		login.enterPassword();
		login.clickOnCaptcha();
		login.clickOnSubmit();
		System.out.println("Login successful");
		// driver.quit(); // Optional: Close the browser after the test
	}

	@Test(priority = 1)
	public void registerDesignation() throws InterruptedException {
		Designation d = new Designation(driver);
		d.navigatetoDepartmentRegister();
		d.selectDepartment();
		d.enterDesignation();
		d.Submit();
	}
}
