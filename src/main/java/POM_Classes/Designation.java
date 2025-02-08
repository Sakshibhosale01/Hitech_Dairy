package POM_Classes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Designation {

	private WebDriver driver;

	@FindBy (xpath="//a[@id=\"tab0\"]")
	private WebElement General_Module;
	
	@FindBy (xpath="//div[@id=\"accordion00\"]")
	private WebElement navigateToMaster;
	
	@FindBy (xpath="//a[contains(text(), 'Designation Register')]") //a[contains(text(), 'Designation Register')]
	private WebElement clickDesignationtRegister;
	
	@FindBy (xpath="//span[@class=\"mdc-button__label\"]")
	private WebElement addDesignation;

	@FindBy (xpath="//mat-select[@id=\"mat-select-4\"]")
	private WebElement selectDepartment;
	
	@FindBy (xpath="//input[@id=\"mat-input-5\"]")
	private WebElement enterDesinationName;
	
	@FindBy (xpath="//span[text()=\"Submit\"]")
	private WebElement SubmitBtn;
	
	public Designation(WebDriver driver)
	{
		   this.driver = driver;
	        PageFactory.initElements(driver, this); // Initialize the elements
	}
	
	public void navigatetoDepartmentRegister() throws InterruptedException
	{
		Thread.sleep(1000);
		Actions action = new Actions(driver);         //Performing the mouse hover action on the target element.
		action.moveToElement(General_Module).perform();
		Thread.sleep(1000);
		navigateToMaster.click();
		Thread.sleep(2000);
		clickDesignationtRegister.click();
		Thread.sleep(2000);
		addDesignation.click();
	}

	public void selectDepartment() throws InterruptedException {	
		selectDepartment.click();
	    // Wait for the dropdown options to appear
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    List<WebElement> options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//mat-option")));
	    // Scroll through the options and fetch their text
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    boolean isFound = false;

	    for (WebElement option : options) {
	        // Scroll to the option
	        js.executeScript("arguments[0].scrollIntoView(true);", option);
	        Thread.sleep(500); // Optional wait for smooth scrolling

	        // Fetch the text of the option
	        String optionText = option.getText();
	        System.out.println("Option: " + optionText);

	        // Check if it matches the desired department
	        if (optionText.equalsIgnoreCase("STPL Technical Team")) 
	        {
	            option.click(); // Select the option
	            isFound = true;
	        }
	        
	}}
	
	public void enterDesignation() throws InterruptedException
	{
		enterDesinationName.click();
		enterDesinationName.sendKeys("Development");
	}
	
	public void Submit() throws InterruptedException
	{
		//CancleBtn.click();  //Cancel the record 
		SubmitBtn.click();    // add designation name 
	}
}
