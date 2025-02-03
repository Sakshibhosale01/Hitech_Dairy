package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankBranch {
      
	WebDriver driver;

	@FindBy (xpath="")
	private WebElement abc;

	@FindBy (xpath="")
	private WebElement abcd;
	
	@FindBy (xpath="")
	private WebElement abcde;
	
	public BankBranch(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickOnRegister() throws InterruptedException
	{
		Thread.sleep(2000);
	    abc.click();
	}
}
