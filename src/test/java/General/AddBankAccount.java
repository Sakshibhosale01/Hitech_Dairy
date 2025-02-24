package General;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base_Class.BaseClass1;
import POM_Classes.BankAcc;
import POM_Classes.Designation;
import POM_Classes.Login;

public class BankAccountRegister {

	private WebDriver driver; // Declare as a class-level variable

	@BeforeClass
	public void LoginUser() throws InterruptedException {
		BaseClass1 base = new BaseClass1();
		driver = base.getDriver("Chrome"); // Initialize the driver using getDriver
		Login login = new Login(driver); // Pass the initialized driver to the Login class
		login.enterUsername();
		login.enterPassword();
		//login.clickOnCaptcha();
		login.clickOnSubmit();
		System.out.println("Login successful");
		// driver.quit(); // Optional: Close the browser after the test
	}

	@Test(priority = 1)
	public void registerBank() throws InterruptedException {
		BankAcc b = new BankAcc(driver);
		b.navigateToBankAccRegister();
		b.selectUnitName();
		b.selectBankName();
		b.enterBankDetails();
		b.enterAccountNoName();
		b.clickSubmitButton();
	
	}
	
}
