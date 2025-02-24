package General;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base_Class.Base;
import POM_Classes.Bank;
import POM_Classes.BankAcc;
import POM_Classes.Department;
import POM_Classes.Designation;
import POM_Classes.User;
import POM_Classes.UserLogin;

public class General_Data {
	private WebDriver driver; // Declare as a class-level variable

	@BeforeClass
	public void LoginUser() throws InterruptedException {
		Base base1 = new Base();
		driver = base1.getDriver(); // Initialize the driver using getDriver
		UserLogin login = new UserLogin(driver); // Pass the initialized driver to the Login class
		login.enterUsername();
		login.enterPassword();
		login.clickOnSubmit();
	}
	
	@Test(priority = 0)
	public void registerDepartment() throws InterruptedException
	{
		Department d= new Department(driver);
		d.navigatetoDepartmentRegister();
		d.addDepartment();
		d.Submit();
	}
	
	@Test(priority = 1, dependsOnMethods = "registerDepartment")
	public void registerDesignation() throws InterruptedException {
		Designation d = new Designation(driver);
		Thread.sleep(1000);
		d.navigatetoDesignationRegister();
		d.selectDepartment();
		d.enterDesignation();
		d.Submit();
	}
	/*
	@Test(priority = 2 , dependsOnMethods="registerDesignation")
	public void registerBank() throws InterruptedException {
		Thread.sleep(3000);
	    Bank b = new Bank(driver);
		b.addBank();
		Thread.sleep(3000);
		b.enterBankName();
		b.Submit();
	}
	
	@Test(priority = 3 ,  dependsOnMethods="registerBank")
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
	
	@Test(priority = 4  , dependsOnMethods ="registerBankAccount")
	public void registerUser() throws InterruptedException {
		User user = new User(driver);
		user.navigateAddUser();
		user.fillFormWithRandomData();
		user.clickSubmit();	
	}
	
	@AfterClass
	public void closeDriver()
	{
		//driver.quit();
	}*/
}
