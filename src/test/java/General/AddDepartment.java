package General;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base_Class.Base;
import POM_Classes.Department;
import POM_Classes.UserLogin;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddDepartment {

private WebDriver driver; // Declare as a class-level variable
	
	@BeforeClass
    public void LoginUser() throws InterruptedException{
		Base base1 = new Base();
		driver = base1.getDriver();     // Initialize the driver using getDriver
        UserLogin login = new UserLogin(driver); // Pass the initialized driver to the Login class
        login.enterUsername();
        login.enterPassword();
        //login.clickOnCaptcha();
        login.clickOnSubmit();
        System.out.println("Login successful");
       // driver.quit();       // Optional: Close the browser after the test
}
	@Test(priority = 1)
	public void registerDepartment() throws InterruptedException
	{
		Department d= new Department(driver);
		d.navigatetoDepartmentRegister();
		Thread.sleep(2000);
		d.addDepartment();
		d.Submit();
	}
}
