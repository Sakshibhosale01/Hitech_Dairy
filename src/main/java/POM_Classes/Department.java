package POM_Classes;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Department {

	private WebDriver driver;

	@FindBy (xpath="//a[@id=\"tab0\"]")
	private WebElement General_Module;
	
	@FindBy (xpath="//div[@id=\"accordion00\"]")
	private WebElement navigateToMaster;
	
	@FindBy (xpath="//a[text()=\" Department Register \"]")
	private WebElement clickDepartmentRegister;
	
	@FindBy (xpath="//span[@class=\"mdc-button__label\"]")
	private WebElement addDepartment;

	@FindBy (xpath="//input[@id=\"mat-input-5\"]")
	private WebElement DepartmentName;
	
	@FindBy (xpath="//span[text()=\"Submit\"]")
	private WebElement SubmitBtn;
	
	public Department(WebDriver driver)
	{
		   this.driver = driver;
	        PageFactory.initElements(driver, this); // Initialize the elements
	}
	
	public void navigatetoDepartmentRegister() throws InterruptedException
	{
		Thread.sleep(1000);
		//General_Module.click();
	    //WebElement ele = driver.findElement(By.xpath("//a[@id=\"tab0\"]"));
		//Creating object of an Actions class
		Actions action = new Actions(driver);         //Performing the mouse hover action on the target element.
		action.moveToElement(General_Module).perform();
		Thread.sleep(1000);
		navigateToMaster.click();
		Thread.sleep(2000);
		clickDepartmentRegister.click();
	}

	public void addDepartment() throws InterruptedException {
		Thread.sleep(2000);
        //to add the new department click on add department
		addDepartment.click();
		Thread.sleep(2000);
		DepartmentName.click();
		Thread.sleep(2000);
		DepartmentName.sendKeys("STPL Technical Team");
	}
	
	public void Submit() throws InterruptedException
	{
		Thread.sleep(2000);
		//CancleBtn.click();  //Cancle the record 
		SubmitBtn.click();    // add bank name 
	}
}
