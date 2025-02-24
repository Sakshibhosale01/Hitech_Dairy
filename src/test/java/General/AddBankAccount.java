package General;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base_Class.Base;
import POM_Classes.BankAcc;
import POM_Classes.Designation;
import POM_Classes.UserLogin;

public class AddBankAccount {

 WebDriver driver; // Declare as a class-level variable

	@BeforeClass  // Runs before any test methods in this class
    public void setDriver() {
        driver = Login.driver;
   }

	@Test(priority = 1)
	public void registerBankAccount() throws InterruptedException {
		Thread.sleep(3000);
		BankAcc b = new BankAcc(driver);
		b.navigateToBankAccRegister();
		b.selectUnitName();
		b.selectBankName();
		b.enterBankDetails();
		b.enterAccountNoName();
		b.clickSubmitButton();
	}
	
}
