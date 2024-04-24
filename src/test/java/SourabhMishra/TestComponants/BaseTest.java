package SourabhMishra.TestComponants;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import java.util.Properties;
//import org.bouncycastle.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SourabhMishra.pageobjects.lendingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public lendingPage lendingPage ;

	public WebDriver intializeDriver() throws IOException {
		//		propertiesclass

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Software\\eclips_workspace\\seleniumMavenFrameworkDesign\\src\\main\\java\\SourabhMishra\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");

			
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
				options.addArguments("headless");

			}
			driver = new ChromeDriver(options);
//			ChromeOptions options = new ChromeOptions();
//			WebDriver driver = new ChromeDriver(options);
//			options.addArguments("--remote-allow-origins=*");
//			options.addArguments("start-maximized");
			driver.manage().window().setSize(new Dimension(1440, 900));
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "edge.exe");
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Software\\geckodriver.exe\\");
			driver = new FirefoxDriver();
		}    

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	public  List<HashMap<String, String>> getJesonDataToMap(String filePath) throws IOException {
		//read json to string

		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});

		return data;
	}
	public String getScreenshot(String testCaseName, WebDriver driver ) throws IOException {

		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}

	@BeforeMethod(alwaysRun=true)
	public lendingPage launchApplication() throws IOException {

		driver = intializeDriver();
		lendingPage = new lendingPage(driver);
		lendingPage.goTo();
		return lendingPage;

	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}
}
