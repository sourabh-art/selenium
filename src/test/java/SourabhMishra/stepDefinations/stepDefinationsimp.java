package SourabhMishra.stepDefinations;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SourabhMishra.TestComponants.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import SourabhMishra.pageobjects.cartPage;
import SourabhMishra.pageobjects.catelouguePage;
import SourabhMishra.pageobjects.checkOutPage;
import SourabhMishra.pageobjects.confirmationPage;
import SourabhMishra.pageobjects.lendingPage;

public class stepDefinationsimp extends BaseTest {
	public lendingPage lendingPage;
	public catelouguePage CatelouguePage;
	public confirmationPage confirmationpage;

	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException{
		lendingPage = launchApplication();
		
	}
	@Given("^Logged in with Username(.+) and Password(.+)$")
	public void logged_in_with_username_and_password(String Username,String Password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 CatelouguePage = lendingPage.login(Username , Password);
		 
	}
	@When("^I add product(.+)to cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException {
	
		List<WebElement> products = CatelouguePage.getProductList();
	
		CatelouguePage.addProducttoCart(productName);
	}
	@When("^Checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String productName) throws InterruptedException {
		cartPage CartPage = CatelouguePage.goToCartPage();
		Boolean match = CartPage.verifyCartProduct(productName);
		Assert.assertTrue(match);
		checkOutPage checkoutpage = CartPage.goToCheckoutPage();
		checkoutpage.selectcountry("india");
		 confirmationpage = checkoutpage.submit();
		}
	@Then("{string} message is displayed on the confirmationPage")
	public void message_is_displayed_on_the_confirmationPage(String string) {
		String finalPage = confirmationpage.gettext();
 
		Assert.assertTrue(finalPage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
}
