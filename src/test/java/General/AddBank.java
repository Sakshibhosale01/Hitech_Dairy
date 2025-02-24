package General;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base_Class.Base;
import POM_Classes.Bank;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddBank{

	WebDriver driver; 
	
	@BeforeClass  // Runs before any test methods in this class
    public void setDriver() {
        driver = Login.driver;
   }

	@Test(priority = 1)
	public void registerBank() throws InterruptedException {
		Thread.sleep(3000);
	    Bank b = new Bank(driver);
		b.addBank();
		b.enterBankName();
		b.Submit();
	}
	
	
}
