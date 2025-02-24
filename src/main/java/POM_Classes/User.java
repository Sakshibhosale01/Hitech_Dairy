package POM_Classes;

import java.time.Duration;
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
import com.github.javafaker.Faker;
import Base_Class.Data_Generator;

public class User {
	
	    WebDriver driver;
	    Faker faker = new Faker(); // Instantiate Faker for random data generation

	    // Locators for the form fields


		@FindBy (xpath="//a[@id=\"tab0\"]")
		private WebElement General_Module;
		
		@FindBy (xpath="//div[@id=\"accordion00\"]")
		private WebElement navigateToMaster;
		
		@FindBy(xpath = "//a[contains(text(), 'User Register')]") // a[contains(text(), 'Designation Register')]
		private WebElement clickUserRegister;

		@FindBy(xpath = "//span[text()='Add User ']") 
		private WebElement clickaddUserButton; 
		
	    @FindBy(xpath = "//input[@formcontrolname='name']")
	    private WebElement nameField;

	    @FindBy(xpath = "//input[@formcontrolname='mobileNo']")
	    private WebElement mobileNoField;

	    @FindBy(xpath = "//input[@formcontrolname='emailId']")
	    private WebElement emailField;

	    @FindBy(xpath = "//*[@id=\"mat-mdc-form-field-label-24\"]/mat-label")//mat-select[@formcontrolname='userType']
	    private WebElement userTypeDropdown;

	    @FindBy(xpath = "//div[@id='mat-select-value-11']")
	    private WebElement departmentDropdown;

	    @FindBy(xpath = "//mat-select[@id=\"mat-select-12\"]")
	    private WebElement designationDropdown;

	    @FindBy(xpath = "//input[@formcontrolname='userName']")
	    private WebElement usernameField;

	    @FindBy(xpath = "//input[@formcontrolname='password']")
	    private WebElement passwordField;

	    @FindBy(xpath = "//input[@id='mat-mdc-checkbox-1-input']")
	    private WebElement isUnitRequiredCheckbox;

	    @FindBy(xpath = "//label[@id=\"mat-mdc-form-field-label-36\"]")//mat-option//span[text()='Branch Unit 1']
	    private WebElement unitNameDropdown;
	   
	    @FindBy(xpath = "//input[@id=\"mat-radio-2-input\"]")
	    private WebElement activeStatusRadio;

	    @FindBy(xpath = "//textarea[@formcontrolname='address']")
	    private WebElement addressField;

	    @FindBy(xpath = "//button[normalize-space()='Submit']")
	    private WebElement submitButton;
	    
	    public User(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void navigateAddUser() throws InterruptedException
		{
			Thread.sleep(500);
			Actions action = new Actions(driver);         //Performing the mouse hover action on the target element.
			action.moveToElement(General_Module).perform();
			Thread.sleep(500);
			navigateToMaster.click();
			Thread.sleep(1000);
			clickUserRegister.click();
			Thread.sleep(1000);
			clickaddUserButton.click();
			//Thread.sleep(2000);
		}
	  
	    // Methods to fill fields with random data
	    public void enterRandomName() {
	        String randomName = faker.name().fullName();
	        nameField.sendKeys(randomName);
	    }

	    public void enterRandomMobileNo() {
	        String randomMobileNo = "6" + String.format("%09d", (long) (Math.random() * 1000000000L));
	        mobileNoField.sendKeys(randomMobileNo);
	    }

	    public void enterRandomEmail() {
	        String randomEmail = faker.internet().emailAddress();
	        emailField.sendKeys(randomEmail);
	    }

	    public void selectUserType() throws InterruptedException {
	    	Thread.sleep(500);
	    	userTypeDropdown.click();
	        WebElement staffOption = driver.findElement(By.xpath("//mat-option[@id=\"mat-option-26\"]")); // Example value staff
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", staffOption);
	    }

	    public void selectDepartment() throws InterruptedException {
	    	Thread.sleep(500);
	        departmentDropdown.click();
	        Thread.sleep(500);
	        WebElement StplDept = driver.findElement(By.xpath("//mat-option[@id=\"mat-option-39\"]"));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", StplDept);
	        StplDept.click();
	    }

	    public void selectDesignation() throws InterruptedException {
	    	Thread.sleep(2000);
	    	Actions actions = new Actions(driver);
	    	actions.moveToElement(designationDropdown).click().perform();
	        Thread.sleep(1000);
	        WebElement DevDesignation = driver.findElement(By.xpath("//mat-option[@id=\"mat-option-42\"]"));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", DevDesignation);
	       // DevDesignation.click();
	        Thread.sleep(500); 
	    }
 
	    public void enterRandomUsername$Pass() {
	    	Data_Generator g= new Data_Generator();
	        usernameField.sendKeys(g.generateRandomUsername());
	        passwordField.sendKeys(g.generateRandomPassword());
	    }

	    public void toggleIsUnitRequired() {
	        isUnitRequiredCheckbox.click();
 }

	    public void selectUnitName() throws InterruptedException {
	    	Thread.sleep(1000);
    		unitNameDropdown.click();
    		Thread.sleep(1000);
	        driver.findElement(org.openqa.selenium.By.xpath("//span[text()= ' Branch Unit 1 ']")).click(); // Example value
	    }

	    public void selectStatus(boolean active) {
	        if (active) {
	            activeStatusRadio.click();
	        }
	    }

	    public void enterRandomAddress() {
	        String randomAddress = faker.address().fullAddress();
	        addressField.sendKeys(randomAddress);
	    }

	    public void clickSubmit() {
	        submitButton.click();
	    }

	    // Method to fill the entire form with random data
	    public void fillFormWithRandomData() throws InterruptedException {
	    	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop cdk-overlay-dark-backdrop cdk-overlay-backdrop-showing")));
	        enterRandomName();
	        enterRandomMobileNo();
	        enterRandomEmail();
	        Thread.sleep(1000);
	        selectUserType();
	        selectDepartment();
	        selectDesignation();
	        enterRandomUsername$Pass();
	        toggleIsUnitRequired();
	        selectUnitName();
	        selectStatus(true); // Select "Active"
	        //enterRandomAddress();
	    }
	

}
