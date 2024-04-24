package SourabhMishra.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SourabhMishra.AbstractComponants.abstractComponants;

public class cartPage extends abstractComponants {

	WebDriver driver;

	public cartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//	WebElement useremail = driver.findElement(By.id("userEmail"));
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	@FindBy(css = ".totalRow button")
	WebElement checkOutEle;

	public boolean verifyCartProduct(String productName) {

		Boolean match = cartProducts.stream()
				.anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productName));
		return (match);
	}

	public checkOutPage goToCheckoutPage() {

		checkOutEle.click();
		checkOutPage checkoutpage = new checkOutPage(driver);
		return checkoutpage;
	}

}
