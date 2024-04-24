package SourabhMishra.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import SourabhMishra.TestComponants.BaseTest;
import SourabhMishra.pageobjects.cartPage;
import SourabhMishra.pageobjects.catelouguePage;
import SourabhMishra.pageobjects.checkOutPage;
import SourabhMishra.pageobjects.confirmationPage;

public class ErrorValidations extends BaseTest {

	@Test 
	public void loginErrorValidation() throws IOException, InterruptedException {
		String productName = "ADIDAS ORIGINAL";
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		lendingPage.login("mishraji@gmail.com", "Smneeraj@");
		Assert.assertEquals("Incorrect email  password.", lendingPage.getErrorMsg());
		//div[@aria-label='Incorrect email or password.']

	}
	@Test (groups= {"errorHandling"})
	public void productErrorValidation() throws IOException, InterruptedException {
		String productName = "ADIDAS ORIGINAL";
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		catelouguePage	CatelouguePage = lendingPage.login("mishraji@gmail.com", "Smneeraj8@");
		List<WebElement> products = CatelouguePage.getProductList();
		CatelouguePage.addProducttoCart(productName);	
		cartPage CartPage  = CatelouguePage.goToCartPage();
		Boolean match = CartPage.verifyCartProduct("ABIDAS ORIGINAL");
		Assert.assertFalse(match);
	}
}