package General;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import POM_Classes.Bank;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BankRegister {

	WebDriver driver;

	@BeforeClass
	public void Launch_Login() throws InterruptedException {
		Login_Page lp = new Login_Page();
		lp.LoginUser();
		//lp.LoginUser();
	}

	@Test
	public void registerBank() throws InterruptedException {
		Thread.sleep(5000);
		Bank b = new Bank(driver);
		b.clickOnGeneralModule();
		//b.clickOnBankRegiPage();
		//b.clickOnAddBank();
	}
}
