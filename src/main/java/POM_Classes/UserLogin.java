package POM_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogin {

    WebDriver driver;

	@FindBy(xpath = "//input[@id='mat-input-0']")
	private WebElement Username;

	@FindBy(xpath = "//input[@id='mat-input-1']")
	private WebElement Password;

	@FindBy(xpath = "//input[@id='mat-input-2']")
	private WebElement Captcha;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;

	public UserLogin(WebDriver driver) {
		PageFactory.initElements(driver, this); // Initialize the elements
		this.driver = driver;
	}

	public void enterUsername() throws InterruptedException {
		Username.sendKeys("ShauryaTechnosoftPvt");
		Thread.sleep(500);
	}

	public void enterPassword() throws InterruptedException {
		Password.sendKeys("Stpl@123");
		Thread.sleep(500);
	}

	public void clickOnCaptcha() throws InterruptedException {
		Captcha.click();
		Thread.sleep(5000); // Simulating captcha interaction (replace with real logic if applicable)
	}

	public void clickOnSubmit() throws InterruptedException {
		submit.click();
		Thread.sleep(500);
	}
}
