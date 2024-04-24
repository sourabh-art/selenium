package SourabhMishra.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SourabhMishra.AbstractComponants.abstractComponants;

public class lendingPage extends abstractComponants{
	WebDriver driver;

	public lendingPage(WebDriver driver) {
		super (driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//	WebElement useremail = driver.findElement(By.id("userEmail"));
	@FindBy(id = "userEmail")
	WebElement usermail;
	@FindBy(id = "userPassword")
	WebElement userPassword;
	@FindBy(id = "login")
	WebElement login;
	//div[@class='ng-tns-c4-4 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error']
	@FindBy(css = "[class*= 'flyInOut']")
	WebElement errormsg;

	public catelouguePage login(String useremail, String password) {
		usermail.sendKeys(useremail);
		userPassword.sendKeys(password);
		login.click();
		catelouguePage CatelouguePage = new catelouguePage(driver);
		return CatelouguePage;
	}
	public String getErrorMsg() {
		waitForWebElementtoAppear(errormsg);
		return errormsg.getText();
	}

	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client/");
	}

}
