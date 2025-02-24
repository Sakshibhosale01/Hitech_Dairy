package POM_Classes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankAcc {

	WebDriver driver;

	@FindBy(xpath = "//a[@id=\"tab0\"]")
	private WebElement General_Module;

	@FindBy(xpath = "//div[@id=\"accordion00\"]")
	private WebElement navigateToMaster;
	//a[text()=\" Bank Register \"]//a[contains(text(), 'Bank Account Register')]
	@FindBy(xpath = "//a[text()=\" Bank Account Register \"]") // a[contains(text(), 'Designation Register')]
	private WebElement clickBankAccRegister;

	@FindBy(xpath = "//span[@class=\"mdc-button__label\"]")
	private WebElement addBankAccount;

	@FindBy(xpath = "//mat-select[@id=\"mat-select-2\"]")
	private WebElement selectUnitName;

	@FindBy(xpath = "//mat-option//span[text()='Branch Unit 1']")
	private WebElement selectBranchUnitName;

	@FindBy(xpath = "//input[@value='Bank Account']")
	private WebElement bankAccountRadioButton;

	@FindBy(xpath = "//input[@value='Cash Account']")
	private WebElement cashAccountRadioButton;

	@FindBy(xpath = "//mat-select[@id=\"mat-select-4\"]")
	private WebElement selectBankName;

	@FindBy(xpath = "//mat-option//span[text()='HDFC']")
	private WebElement selectHDFCBank;

	@FindBy(xpath = "//input[@id=\"mat-input-5\"]")
	private WebElement enterBranchName;

	@FindBy(xpath = "//input[@id=\"mat-input-6\"]")
	private WebElement enterIFSCCode;

	@FindBy(xpath = "//input[@id=\"mat-input-7\"]")
	private WebElement enterAccountNo;
	//input[@formcontrolname="accountNo"]
	//input[@id=\"mat-input-7\"]
	
	@FindBy(xpath = "//input[@id=\"mat-input-4\"]")
	private WebElement enterAccountHolderName;
	//input[@id=\"mat-input-4\"]
	
	@FindBy(xpath = "//button[@text()='Clear']")
	private WebElement clearButton;

	//@FindBy(xpath = "//button[contains(text(),'Submit')]\")")
	//private WebElement submitButton;


	@FindBy (xpath="//span[text()=\" Submit\"]")
	private WebElement submitButton;
	
	// Constructor
	public BankAcc(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToBankAccRegister() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the sidebar menu to be visible
        WebElement sidebarMenu = wait.until(ExpectedConditions.visibilityOf(General_Module));
        Actions action = new Actions(driver); // Performing the mouse hover action on the target element.
		action.moveToElement(General_Module).perform();

        // Scroll into view (if necessary)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", navigateToMaster);

        // Wait until the element is clickable
        wait.until(ExpectedConditions.elementToBeClickable(sidebarMenu)).click();

		//Actions action = new Actions(driver); // Performing the mouse hover action on the target element.
		//action.moveToElement(General_Module).perform();
		Thread.sleep(2000);
		navigateToMaster.click();
		Thread.sleep(2000);
		clickBankAccRegister.click();
		Thread.sleep(2000);
		addBankAccount.click();
	}

	// Actions/Methods for Interacting with the Page Elements

	public void selectUnitName() throws InterruptedException {
		Thread.sleep(1000);
		selectUnitName.click();
		Thread.sleep(1000);
		selectBranchUnitName.click();
		// Select select = new Select(selectUnitName);
		// Select by visible text
		// WebElement option =
		// driver.findElement(By.xpath("//mat-option//span[text()='Branch Unit 1']"));
		
		// select.selectByVisibleText("Branch Unit 1");
	}

	public void selectBankAccountType(String accountType) {
		if (accountType.equalsIgnoreCase("Bank Account")) {
			bankAccountRadioButton.click();
		} else if (accountType.equalsIgnoreCase("Cash Account")) {
			cashAccountRadioButton.click();
		}
	}

	public void selectBankName() throws InterruptedException {
		selectBankName.click();
		Thread.sleep(1000);
		// Select select = new Select(selectBankName);
		Thread.sleep(1000);
		selectHDFCBank.click();
		// select.selectByVisibleText("HDFC");
	}

	public void enterBankDetails() throws InterruptedException {
		enterBranchName.click();
		Thread.sleep(1000);
		enterBranchName.sendKeys("Pune");
		enterIFSCCode.click();
		Thread.sleep(1000);
		enterIFSCCode.sendKeys("PUNE0545456");
		Thread.sleep(1000);
		System.out.println("IFSC Entered");
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Ensure the element is visible
		wait.until(ExpectedConditions.visibilityOf(enterAccountNo));
		// Scroll into view if necessary
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", enterAccountNo);*/
	}

	public void enterIFSCCode() {
		enterIFSCCode.click();
		enterIFSCCode.sendKeys("PUNE054545");
	}

	public void enterAccountNoName() throws InterruptedException {
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Ensure the element is visible
		wait.until(ExpectedConditions.visibilityOf(enterAccountNo));
		enterAccountNo.click();
		// Scroll into view if necessary
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", enterAccountNo);
		
		enterAccountNo.sendKeys("654654654654");
		Thread.sleep(2000);
		
		try {
		     Wait until the element is visible
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOf(enterAccountNo));

		    // Scroll to the element
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView(true);", enterAccountNo);

		    // Click on the element using JavaScript (to avoid interception issues)
		    js.executeScript("arguments[0].click();", enterAccountNo);

		    // Send input value using JavaScript
		    js.executeScript("arguments[0].value='654654654654';", enterAccountNo);

		    // Optional: Verify the input value
		   // String value = enterAccountNo.getAttribute("value");
		   // System.out.println("Entered value: " + value);

		} catch (ElementNotInteractableException e) {
		    System.out.println("Element is not interactable: " + e.getMessage());
		} catch (NoSuchElementException e) {
		    System.out.println("Element not found: " + e.getMessage());
		} catch (Exception e) {
		    System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		*/
		
		//WebElement matLabel = driver.findElement(By.cssSelector("mat-label.ng-tns-c1205077789-18"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", matLabel);

		Thread.sleep(2000);
		enterAccountNo.sendKeys("654654654654");
		    Thread.sleep(2000);
		enterAccountHolderName.click();
		Thread.sleep(2000);
		enterAccountHolderName.sendKeys("Branch Unit Pune Account");
	}

	public void enterAccountHolderName() {
		enterAccountHolderName.click();
		enterAccountHolderName.sendKeys("Branch Unit Pune Account");
	}

	public void clickClearButton() {
		clearButton.click();
	}

	public void clickSubmitButton() throws InterruptedException {
		Thread.sleep(2000);
		submitButton.click();
	}

}
