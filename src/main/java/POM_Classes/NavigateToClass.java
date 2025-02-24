package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigateToClass {
     WebDriver driver;

	@FindBy (xpath="//a[@id=\"tab0\"]")
	private WebElement General_Module;
	
	@FindBy (xpath="//div[@id=\"accordion00\"]")
	private WebElement navigateToMaster;
	
	//@FindBy (xpath="//a[contains(text(), 'Designation Register')]") //a[contains(text(), 'Designation Register')]
	//private WebElement clickDesignationtRegister;
	
	public NavigateToClass(WebDriver driver)
	{
		   this.driver = driver;
	        PageFactory.initElements(driver, this); // Initialize the elements
	}
	
	
	public void navigateToPage() throws InterruptedException
	{
		Thread.sleep(1000);
		Actions action = new Actions(driver);         //Performing the mouse hover action on the target element.
		action.moveToElement(General_Module).perform();
		Thread.sleep(1000);
		navigateToMaster.click();
		Thread.sleep(2000);
		//clickDesignationtRegister.click();
		//Thread.sleep(2000);
	
	}
}
