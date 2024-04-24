package SourabhMishra.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReporterNg {
	
	public static ExtentReports getReportObject() {
		
	      String path =  System.getProperty("user.dir")+"//reports//index.html";
	      ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	      reporter.config().setReportName("WebAutomation Report By Sourabh Mishra");
	      reporter.config().setDocumentTitle("Test Result");
	       
	      ExtentReports extend  = new ExtentReports();
	      extend.attachReporter(reporter);
	      extend.setSystemInfo("Tester", "Sourabh Mishra");
	      return extend;
	      
	      
	      
	}

}
