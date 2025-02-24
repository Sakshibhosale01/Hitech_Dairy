package POM_Classes;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base_Class.Base;

public class Bank extends Base {
	
    WebDriver driver;
	
	@FindBy (xpath="//a[@id=\"tab0\"]")
	private WebElement General_Module;
	
	@FindBy (xpath="//div[@id=\"accordion00\"]")
	private WebElement navigateToMaster;
	
	//@FindBy (xpath="//a[@class=\"list-group-item list-group-item-action active ng-star-inserted\"]")
	//private WebElement clickBankRegister;
	
	@FindBy (xpath="//a[text()=\" Bank Register \"]")
	private WebElement clickBankRegister;
	
	@FindBy (xpath="//span[@class=\"mdc-button__label\"]")
	private WebElement AddBank;
	int i =5;
	
	@FindBy (xpath="//input[@id=\"mat-input-5\"]")//input[@id="mat-input-6"]
	private WebElement BankName;
	
	@FindBy (xpath="//span[text()=\"Cancel\"]")
	private WebElement CancleBtn;
	
	@FindBy (xpath="//span[text()=\"Submit\"]")
	private WebElement SubmitBtn;
	
	public Bank(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	public void addBank() throws InterruptedException
	{
		Thread.sleep(5000);
		Actions action = new Actions(driver);         //Performing the mouse hover action on the target element.
		action.moveToElement(General_Module).perform();
		Thread.sleep(1000);
		navigateToMaster.click();
		Thread.sleep(2000);
		clickBankRegister.click();
		Thread.sleep(2000);
		AddBank.click();
	}

/*	public void clickOnBankRegiPage() throws InterruptedException
	{
		Thread.sleep(2000);
		clickBankRegister.click();
	}
	
	public void clickOnAddBank() throws InterruptedException
	{
		Thread.sleep(2000);
		AddBank.click();
	}*/
	
	public void selectOrg()
	{
		Select select = new Select(driver.findElement(By.xpath("//mat-select[@id=\"mat-select-20\"]")));
		// Get all the options of the dropdown
		List<WebElement> options = select.getOptions();
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		select.selectByValue("6");//Select option with value "6"
		select.selectByVisibleText("");//Deselect option with text "abc"
	}
	
	public void enterBankName() throws InterruptedException
	{
		Thread.sleep(2000);
		BankName.click();
		BankName.sendKeys("DCC");
	}
	
	public void Submit() throws InterruptedException
	{
		Thread.sleep(1000);
		//CancleBtn.click();  //cancel the record 
		SubmitBtn.click();    // add bank name 
	}
	
}
