package demo.testing_purpose;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

//import com.aventstack.extentreports.utils.FileUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class learning{
	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	@BeforeClass
	public void launchBrowser(){
			
		reports = new ExtentReports(System.getProperty("user.dir") +"/ExecutionReports/"+"Demo_Report.html" ,true);
		
		System.out.println(System.getProperty("user.dir") +"/ExecutionReports"+"Demo_Report");
		
		System.setProperty("webdriver.ie.driver", "C:\\QC_Batch\\testing_purpose\\IEDriverServer.exe");
		driver= new InternetExplorerDriver();
		//test.log(LogStatus.PASS,"Launch the Browser");
	}
	
	@Test
	public void openURL(){
		
		String UserName = "admin";
		String Password = "advance";
		
		test=reports.startTest("Lanching the IE Browser");
		test.log(LogStatus.PASS,"Launch the Browser");
		driver.get("http://192.168.2.203/cc/adminIndex.do");
		test.log(LogStatus.PASS,"Launch the URL");
		driver.findElement(By.name("loginRequestBean.userId")).sendKeys(UserName);

		test.log(LogStatus.PASS, "Username is entered: "+UserName); 

		driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);

		test.log(LogStatus.PASS, "Password is entered: "+Password); 

		//Click Login Button

		driver.findElement(By.name("login")).click();

		test.log(LogStatus.PASS, "Clicked on Submit button");
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.quit();
	}
	
	 @AfterMethod
	    public void getResult(ITestResult result) throws Exception {
	        if(result.getStatus() == ITestResult.FAILURE) {
	        	test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
	        	String screenshotPath = getScreenhot(driver, result.getName());
				// To add it in the extent report
				test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS) {
	        	test.log(LogStatus.PASS, result.getName() + " Test Case is Passed");;
	        }
	        else if (result.getStatus() == ITestResult.SKIP) {
				test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
	        }
	    }
	 	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
			String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

			File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

			String destination = System.getProperty("user.dir") + "/ExecutionReports/FailedTestsScreenshots/"
					+ screenshotName + dateName + ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		}
	    @AfterTest
	    public void tearDown() {
	    	//to write or update test information to reporter
	    	reports.flush();
	    	//reports.close();
	    }
	
}