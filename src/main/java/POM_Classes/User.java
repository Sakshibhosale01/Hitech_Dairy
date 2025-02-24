package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

public class User {
	
	    WebDriver driver;
	    Faker faker = new Faker(); // Instantiate Faker for random data generation

	    // Locators for the form fields
	    @FindBy(xpath = "//input[@formcontrolname='name']")
	    private WebElement nameField;

	    @FindBy(xpath = "//input[@formcontrolname='mobileNo']")
	    private WebElement mobileNoField;

	    @FindBy(xpath = "//input[@formcontrolname='email']")
	    private WebElement emailField;

	    @FindBy(xpath = "//mat-select[@formcontrolname='userType']")
	    private WebElement userTypeDropdown;

	    @FindBy(xpath = "//mat-select[@formcontrolname='department']")
	    private WebElement departmentDropdown;

	    @FindBy(xpath = "//mat-select[@formcontrolname='designation']")
	    private WebElement designationDropdown;

	    @FindBy(xpath = "//input[@formcontrolname='username']")
	    private WebElement usernameField;

	    @FindBy(xpath = "//input[@formcontrolname='password']")
	    private WebElement passwordField;

	    @FindBy(xpath = "//mat-checkbox[@formcontrolname='isUnitRequired']")
	    private WebElement isUnitRequiredCheckbox;

	    @FindBy(xpath = "//mat-select[@formcontrolname='unitName']")
	    private WebElement unitNameDropdown;

	    @FindBy(xpath = "//mat-radio-button[@formcontrolname='status'][.//div[contains(text(),'Active')]]")
	    private WebElement activeStatusRadio;

	    @FindBy(xpath = "//textarea[@formcontrolname='address']")
	    private WebElement addressField;

	    @FindBy(xpath = "//button[normalize-space()='Submit']")
	    private WebElement submitButton;
	    
	    public User(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    // Methods to fill fields with random data
	    public void enterRandomName() {
	        String randomName = faker.name().fullName();
	        nameField.sendKeys(randomName);
	    }

	    public void enterRandomMobileNo() {
	        String randomMobileNo = faker.phoneNumber().cellPhone().replaceAll("[^0-9]", "").substring(0, 10);
	        mobileNoField.sendKeys(randomMobileNo);
	    }

	    public void enterRandomEmail() {
	        String randomEmail = faker.internet().emailAddress();
	        emailField.sendKeys(randomEmail);
	    }

	    public void selectRandomUserType() {
	        userTypeDropdown.click();
	        driver.findElement(org.openqa.selenium.By.xpath("//span[text()='Admin']")).click(); // Example value
	    }

	    public void selectRandomDepartment() {
	        departmentDropdown.click();
	        driver.findElement(org.openqa.selenium.By.xpath("//span[text()='Admin']")).click(); // Example value
	    }

	    public void selectRandomDesignation() {
	        designationDropdown.click();
	        driver.findElement(org.openqa.selenium.By.xpath("//span[text()='Organization Admin']")).click(); // Example value
	    }

	    public void enterRandomUsername() {
	        String randomUsername = faker.name().username();
	        usernameField.sendKeys(randomUsername);
	    }

	    public void enterRandomPassword() {
	        String randomPassword = faker.internet().password();
	        passwordField.sendKeys(randomPassword);
	    }

	    public void toggleIsUnitRequired() {
	        isUnitRequiredCheckbox.click();
	    }

	    public void selectRandomUnitName() {
	        unitNameDropdown.click();
	        driver.findElement(org.openqa.selenium.By.xpath("//span[text()='Branch Unit 1']")).click(); // Example value
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
	    public void fillFormWithRandomData() {
	        enterRandomName();
	        enterRandomMobileNo();
	        enterRandomEmail();
	        selectRandomUserType();
	        selectRandomDepartment();
	        selectRandomDesignation();
	        enterRandomUsername();
	        enterRandomPassword();
	        toggleIsUnitRequired();
	        selectRandomUnitName();
	        selectStatus(true); // Select "Active"
	        enterRandomAddress();
	    }
	

}
