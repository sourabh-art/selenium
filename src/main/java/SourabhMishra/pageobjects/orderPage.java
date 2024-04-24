package SourabhMishra.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SourabhMishra.AbstractComponants.abstractComponants;

public class orderPage extends abstractComponants {

	WebDriver driver;

	public orderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//	WebElement useremail = driver.findElement(By.id("userEmail"));
	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> productNames;
	@FindBy(css = ".totalRow button")
	WebElement checkOutEle;

	public boolean verifyOrderProduct(String productName) {

		Boolean match = productNames.stream()
				.anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return (match);
	}

	public checkOutPage goToCheckoutPage() {

		checkOutEle.click();
		checkOutPage checkoutpage = new checkOutPage(driver);
		return checkoutpage;
	}

}
