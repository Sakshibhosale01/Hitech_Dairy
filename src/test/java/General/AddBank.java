package General;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base_Class.BaseClass1;
import POM_Classes.Bank;
import POM_Classes.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BankRegister {

	WebDriver driver;

	@BeforeClass
	public void Launch_Login() throws InterruptedException {
		BaseClass1 base = new BaseClass1();
	    driver = base.getDriver("chrome");
		Login lp = new Login(driver);
		lp.enterUsername();
		lp.enterPassword();
		lp.clickOnCaptcha();
		lp.clickOnSubmit();
	}

	@Test
	public void registerBank() throws InterruptedException {
	    Bank b = new Bank(driver);
		b.addBank();
		b.enterBankName();
		b.Submit();
	}
}
