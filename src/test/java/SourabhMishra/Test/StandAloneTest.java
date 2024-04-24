package SourabhMishra.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SourabhMishra.TestComponants.BaseTest;
import SourabhMishra.pageobjects.cartPage;
import SourabhMishra.pageobjects.catelouguePage;
import SourabhMishra.pageobjects.checkOutPage;
import SourabhMishra.pageobjects.confirmationPage;
import SourabhMishra.pageobjects.lendingPage;
import SourabhMishra.pageobjects.orderPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseTest {
	String productName = "ADIDAS ORIGINAL";

	@Test(dataProvider = "getData", groups = { "purchase" })
	public void StandAloneTest(HashMap<String, String> input) throws IOException, InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		catelouguePage CatelouguePage = lendingPage.login(input.get("email"), input.get("password"));
		List<WebElement> products = CatelouguePage.getProductList();
		CatelouguePage.addProducttoCart(input.get("productName"));
		cartPage CartPage = CatelouguePage.goToCartPage();
		Boolean match = CartPage.verifyCartProduct(input.get("productName"));
		Assert.assertTrue(match);
		checkOutPage checkoutpage = CartPage.goToCheckoutPage();
		checkoutpage.selectcountry("india");
		confirmationPage confirmationpage = checkoutpage.submit();
		String finalPage = confirmationpage.gettext();

		Assert.assertTrue(finalPage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "StandAloneTest" })
	public void orderHistoryTest() {
		// ADIDAS ORIGINAL
		catelouguePage CatelouguePage = lendingPage.login("mishraji@gmail.com", "Smneeraj8@");
		orderPage orderPage = CatelouguePage.goToOrdersPage();
		Assert.assertTrue(orderPage.verifyOrderProduct(productName));

	}

	public String getScreenshot(String testCaseName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJesonDataToMap(
				"C:\\Software\\eclips_workspace\\seleniumMavenFrameworkDesign\\src\\test\\java\\SourabhMishra\\data\\purchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
//HashMap<String , String> map = new HashMap<String , String>();
//map.put("email","mishraji@gmail.com");
//map.put("password","Smneeraj8@");
//map.put("productName","ADIDAS ORIGINAL");		
//HashMap<String , String> map1 = new HashMap<String , String>();
//map1.put("email","sourabh0@gmail.com");
//map1.put("password","Smneeraj9@");
//map1.put("productName","ZARA COAT 3");