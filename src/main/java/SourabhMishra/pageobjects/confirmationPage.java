package SourabhMishra.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SourabhMishra.AbstractComponants.abstractComponants;

public class confirmationPage extends abstractComponants {
	WebDriver driver;

	public confirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = (".hero-primary"))
	WebElement getText;
	
	public String gettext() {
		
		return getText.getText();
	}
	
	
}
