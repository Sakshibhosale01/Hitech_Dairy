package POM_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import com.github.javafaker.Faker;

public class Employee {
	WebDriver driver;
	WebDriverWait wait;
	Faker faker = new Faker();

	@FindBy(xpath = "//a[@id='tab6']")
	private WebElement HRMS_Module;

	@FindBy(xpath = "//button[@aria-controls='#accordion-tab61']")  //div[@id='accordion-tab61']")
	private WebElement navigateToMaster;

	@FindBy(xpath = "//a[contains(text(), 'Employee Register')]")
	private WebElement clickEmployeeRegister;

	@FindBy(xpath = "//span[contains(text(), ' Add Employee')]")//span[text()='Add Employee']
	private WebElement clickAddEmployeeButton;

	@FindBy(xpath = "//input[@formcontrolname='empId']")
	private WebElement empIdField;

	@FindBy(xpath = "//mat-select[text()='Prefix']")
	private WebElement prefixDropdown;

	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	private WebElement firstNameField;

	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	private WebElement lastNameField;

	@FindBy(xpath = "//input[@formcontrolname='dob']")
	private WebElement dobField;

	@FindBy(xpath = "//input[@formcontrolname='contactNumber']")
	private WebElement contactNumberField;

	@FindBy(xpath = "//textarea[@formcontrolname='address1']")
	private WebElement addressField;

	@FindBy(xpath = "//input[@id='permanentAddressCheckbox']")
	private WebElement permanentAddressCheckbox;

	@FindBy(xpath = "//mat-select[text()='Organization Name']")
	private WebElement organizationDropdown;

	@FindBy(xpath = "//input[@id='unitRequiredCheckbox']")
	private WebElement unitRequiredCheckbox;

	@FindBy(xpath = "//mat-select[text()='Unit Name']")
	private WebElement unitNameDropdown;

	@FindBy(xpath = "//mat-select[text()='Department Name']")
	private WebElement departmentDropdown;

	@FindBy(xpath = "//mat-select[text()='Designation Name']")
	private WebElement designationDropdown;

	@FindBy(xpath = "//mat-select[text()='Employee Type']")
	private WebElement employeeTypeDropdown;

	@FindBy(xpath = "//input[@formcontrolname='doj']")
	private WebElement dojField;

	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancelButton;

	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitButton;

	public Employee(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";")); // Wait for page
																									// load
	}

	public void navigateAddEmployee() throws InterruptedException {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		// Performing the mouse hover action on the target element.
		action.moveToElement(HRMS_Module).perform();
		Thread.sleep(2000);
		HRMS_Module.click();
		Thread.sleep(2000);
		navigateToMaster.click();
		
		/* JavascriptExecutor js = (JavascriptExecutor) driver;
		// Step 2: Wait for "Master" submenu to be visible and click it
	    WebElement masterMenu = wait.until(ExpectedConditions.visibilityOf(navigateToMaster));
	    // Scroll into view if needed
	    js.executeScript("arguments[0].scrollIntoView(true);", navigateToMaster);
	    Thread.sleep(2000); // Allow UI to update
	    try {
	        masterMenu.click();  // Attempt normal click
	    } catch (ElementClickInterceptedException e) {
	        js.executeScript("arguments[0].click();", navigateToMaster);  // Fallback to JS click
	    }

	    // Step 3: Wait for "Employee Register" option and click it
	    WebElement employeeRegister = wait.until(ExpectedConditions.elementToBeClickable(clickEmployeeRegister));
	    
	    // Scroll into view if needed
	    js.executeScript("arguments[0].scrollIntoView(true);", clickEmployeeRegister);
	    Thread.sleep(2000);

	    try {
	        employeeRegister.click();
	    } catch (ElementClickInterceptedException e) {
	        js.executeScript("arguments[0].click();", clickEmployeeRegister);
	    }*/
		Thread.sleep(2000);
		clickEmployeeRegister.click();
		Thread.sleep(2000);
		clickAddEmployeeButton.click();
		/*wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("navigateToMaster")));
		wait.until(ExpectedConditions.visibilityOf(navigateToMaster)).click();
		wait.until(ExpectedConditions.visibilityOf(clickEmployeeRegister)).click();
		wait.until(ExpectedConditions.visibilityOf(clickAddEmployeeButton)).click();*/
	}

	public void empDetails() {
		wait.until(ExpectedConditions.visibilityOf(empIdField)).sendKeys("EMP" + faker.number().digits(5));
		wait.until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys(faker.name().firstName());
		wait.until(ExpectedConditions.visibilityOf(lastNameField)).sendKeys(faker.name().lastName());
		String randomContact = "7" + String.format("%09d", (long) (Math.random() * 1000000000L));
		wait.until(ExpectedConditions.visibilityOf(contactNumberField)).sendKeys(randomContact);
		wait.until(ExpectedConditions.visibilityOf(addressField)).sendKeys(faker.address().streetAddress());
	}

	public void checkPermanentAddress() {
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(permanentAddressCheckbox));
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
	}

	public void employementDetails() {
		wait.until(ExpectedConditions.elementToBeClickable(organizationDropdown)).click();
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(unitRequiredCheckbox));
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(unitNameDropdown)).click();
		wait.until(ExpectedConditions.elementToBeClickable(departmentDropdown)).click();
		wait.until(ExpectedConditions.elementToBeClickable(designationDropdown)).click();
		wait.until(ExpectedConditions.elementToBeClickable(employeeTypeDropdown)).click();
	}

	public void enterRandomDateOfJoining() {
		wait.until(ExpectedConditions.visibilityOf(dojField)).sendKeys("01/01/2023");
	}
}
