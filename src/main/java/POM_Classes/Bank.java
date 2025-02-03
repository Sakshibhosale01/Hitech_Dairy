package POM_Classes;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Bank {
	
	WebDriver driver;

	@FindBy (xpath="//a[@id=\"v-pills-general-tab\"]")
	private WebElement General_Module;

	@FindBy (xpath="//a[text()=\"Bank Registration\"]")
	private WebElement Bank_Regi_Page;
	
	@FindBy (xpath="//button[@class=\"btn-main mdc-button mdc-button--unelevated mat-mdc-unelevated-button mat-primary mat-mdc-button-base\"]")
	private WebElement AddBank;
	
	@FindBy (xpath="//input[@id=\"mat-input-5\"]")
	private WebElement BankName;
	
	@FindBy (xpath="//span[text()=\"Cancel\"]")
	private WebElement CancleBtn;
	
	@FindBy (xpath="//span[text()=\"Submit\"]")
	private WebElement SubmitBtn;
	
	public Bank(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickOnGeneralModule() throws InterruptedException
	{
		Thread.sleep(1000);
		//General_Module.click();
	    WebElement ele = driver.findElement(By.xpath("//a[@class=\"nav-link active\"]"));
		//Creating object of an Actions class
		Actions action = new Actions(driver);
		//Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		//this.to('www.anifarm.com');
	}

	public void clickOnBankRegiPage() throws InterruptedException
	{
		Thread.sleep(2000);
		Bank_Regi_Page.click();
	}
	
	public void clickOnAddBank() throws InterruptedException
	{
		Thread.sleep(2000);
		AddBank.click();
	}
	
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
		Thread.sleep(2000);
		//CancleBtn.click();  //Cancle the record 
		SubmitBtn.click();    // add bank name 
	}
	
}
