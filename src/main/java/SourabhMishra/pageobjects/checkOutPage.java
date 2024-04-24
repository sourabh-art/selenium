package SourabhMishra.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SourabhMishra.AbstractComponants.abstractComponants;

public class  checkOutPage extends abstractComponants {
	WebDriver driver;

	public checkOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement Country;
	@FindBy(css = ".ta-item:nth-child(3)")
	WebElement selectCountry;
	@FindBy(css = ".action__submit")
	WebElement Submit;
	By results = By.cssSelector(".ta-results");
   public void selectcountry(String countryName) throws InterruptedException  {
	  
	  
	   Actions a = new Actions(driver);
		a.sendKeys(Country, countryName).build().perform();
		 waitForElementtoAppear(results);
//		 selectCountry.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,820)");
		Thread.sleep(1000);
		selectCountry.click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(results));
//		waitForElementtoDisappear(Country);
   }
   public confirmationPage submit() {
	 
	   Submit.click();
	  return new confirmationPage(driver);
   }
}
