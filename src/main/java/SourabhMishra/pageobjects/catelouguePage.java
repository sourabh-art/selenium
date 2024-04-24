package SourabhMishra.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SourabhMishra.AbstractComponants.abstractComponants;

public class catelouguePage extends abstractComponants {

	WebDriver driver;

	public catelouguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//	WebElement useremail = driver.findElement(By.id("userEmail"));
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	By productsby = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastmsg = By.cssSelector("#toast-container");
	By disappear = By.cssSelector(".ng-animating");

	public List<WebElement> getProductList() {
		waitForElementtoAppear(productsby);
		return products;

	}
	
	public WebElement getProductByName(String productName) {
		
		
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void addProducttoCart(String productName) throws InterruptedException {

		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementtoAppear(toastmsg);
		waitForElementtoDisappear(spinner);
		
	}
}
 