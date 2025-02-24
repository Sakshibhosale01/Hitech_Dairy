package POM_Classes;
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

    @FindBy(xpath = "//div[@id='accordion-tab61']")
    private WebElement navigateToMaster;

    @FindBy(xpath = "//a[contains(text(), 'Employee Register')]")
    private WebElement clickEmployeeRegister;

    @FindBy(xpath = "//span[text()='Add Employee']")
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
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";")); // Wait for page load
    }

    public void navigateAddEmployee() {
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
		action.moveToElement(HRMS_Module);
        action.moveToElement(wait.until(ExpectedConditions.visibilityOf(HRMS_Module))).click();
        wait.until(ExpectedConditions.elementToBeClickable(navigateToMaster)).click();
        wait.until(ExpectedConditions.elementToBeClickable(clickEmployeeRegister)).click();
        wait.until(ExpectedConditions.elementToBeClickable(clickAddEmployeeButton)).click();
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



