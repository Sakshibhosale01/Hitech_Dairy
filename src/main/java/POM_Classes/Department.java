package POM_Classes;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

public class Department {

	private WebDriver driver;
	Faker faker = new Faker();

	@FindBy(xpath = "//a[@id=\"tab0\"]")
	private WebElement General_Module;

	@FindBy(xpath = "//div[@id=\"accordion00\"]")
	private WebElement navigateToMaster;

	@FindBy(xpath = "//a[@id=\"Department Register\"]")
	private WebElement clickDepartmentRegister;

	@FindBy(xpath = "//button[@id='department_register']")
	private WebElement addDepartment;

	@FindBy(xpath = "//input[@id='deptName']")
	private WebElement DepartmentName;

	@FindBy(xpath = "//button[@id='deptSubmit']")
	private WebElement SubmitBtn;

	public Department(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize the elements
	}

	public void navigatetoDepartmentRegister() throws InterruptedException {
		Thread.sleep(1000);
		Actions action = new Actions(driver); // Performing the mouse hover action on the target element.
		action.moveToElement(General_Module).perform();
		Thread.sleep(1000);
		navigateToMaster.click();
		Thread.sleep(3000);
		clickDepartmentRegister.click();
	}

	public void addDepartment() throws InterruptedException {
		Thread.sleep(2000);
		// to add the new department click on add department
		addDepartment.click();
		Thread.sleep(2000);
		DepartmentName.click();
		Thread.sleep(2000);
		/*
		String randomDepartmentName = faker.company().name();
		// Alternatively, if you want a list of typical department names:
		String[] departments = { "HR", "Marketing", "Engineering", "Finance", "Sales", "IT", "Operations" };
		String randomDept = departments[faker.random().nextInt(departments.length)];
		// Simulate entering the department name into a web form
		DepartmentName.sendKeys(randomDept); // Assuming DepartmentName is a WebElement
		System.out.println("Random Department Name: " + randomDept);*/
		
		String randomName = faker.name().fullName();
		DepartmentName.sendKeys(randomName);
		// DepartmentName.sendKeys("STPL Technical Team");
	}

	public void Submit() throws InterruptedException {
		Thread.sleep(2000);
		// CancleBtn.click(); //Cancle the record
		SubmitBtn.click(); // add bank name
	}
}
