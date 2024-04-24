package SourabhMishra.AbstractComponants;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SourabhMishra.pageobjects.cartPage;
import SourabhMishra.pageobjects.orderPage;

public class abstractComponants {
	WebDriver driver;
	public abstractComponants(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy( css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy( css = "[routerlink*='myorders']")
	WebElement orderHeader;
	
	public void waitForElementtoAppear(By findBy) {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForWebElementtoAppear(WebElement findBy) {
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	public cartPage goToCartPage() {
		
		cartHeader.click();
		cartPage CartPage  = new cartPage(driver);
		return CartPage;
	}
public orderPage goToOrdersPage() {
		
		orderHeader.click();
		orderPage orderPage  = new orderPage(driver);
		return orderPage;
	}
	
	
	
	public void waitForElementtoDisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
}
