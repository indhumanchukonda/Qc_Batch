package tests;

import org.testng.annotations.Test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*import Pages.LendNationCSR;
import Pages.LendNationFinancialInformation;
import Pages.LendNationLogin;
import Pages.LendNationPersonalInformation;
import Pages.LendNationRegistration;
import Pages.LendNationRepaymentInformation;
import Pages.LendNationSignContract;
import Pages.LendNationSubmitApplication;*/
//import Utilities.ExtentReports.Excel;
//import Utilities.ExtentReports.Excel;

import tests.LendNationRegistration;




import tests.ExcelNew;

public class LendNation {
	
	public static WebDriverWait wait;	
	public static WebDriver driver;	
	public static com.relevantcodes.extentreports.ExtentReports reports;
	public static com.relevantcodes.extentreports.ExtentTest test;
	String appUrl;
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());

	public static Properties prop;
	public static String loan_number;
	
	
  @Test(priority=0, groups = "Janaki")
  public static void LendNation() throws Exception {
	  
	 try{ 
	  String FileName= prop.getProperty("file_name");
		ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  
	  test=reports.startTest("Lend Nation Smoke_testing","Lend Nation Application test report");		 
		int lastrow=TestData.getLastRow("Start");
		String sheetName="Start";
		//int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			
			
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
		if(RunFlag.equals("Y"))
		{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				String Funding = TestData.getCellData(sheetName,"Funding",row);
				System.out.println(AppURL);
				
				//loan_number="10781891";
				
				System.out.println(loan_number);
				
				LendNationRegistration.registration(SSN, AppURL);
				LendNationPersonalInformation.personalInformation(SSN, AppURL);
			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);
			    LendNationLoanDecision.loandecision(SSN, AppURL);
			    LoginLogout.onlineLogout(SSN, AppURL);
			    
			    LendNationCSR.lendNationCSR(SSN, AppURL);
			    LoginLogout.onlineLogin(SSN, AppURL);
			    LendNationSignContract.signContract(SSN, AppURL);
			    LoginLogout.onlineLogout(SSN, AppURL);
			    if(Funding.equalsIgnoreCase("ACH / Electronic Bank Transfer")){
			    	
			    	LendNationCSR.LoanApprovement(SSN, AppURL);
				  }
				  else if(Funding.equalsIgnoreCase("Cash At Store")){
					  	
					  LoginLogout.csrLogin(SSN, AppURL);
						LendNationLoanApprovement.cashAtStore(SSN, AppURL);
						LoginLogout.csrLogout(SSN, AppURL);
				  }
				
				
				break;
		
				
  }
  }
	 }catch(Exception e){
			
		System.out.println(e);	
		}
  }
  
 
  @BeforeClass
  public void setup() throws IOException {	
		
		String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
		//Date D = new Date();		
		String filename="LendNation_"+timestamp+".html";
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
		
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/IEDriverServer.exe");
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/geckodriver.exe");

		//driver = new InternetExplorerDriver();	
		//driver = new FirefoxDriver();	
		/*driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5000);*/	
		
	
		BufferedReader reader;
		String propertyFilePath=("user.dir")+"/Objects.properties";
		
		
		try {
			
			reader = new BufferedReader(new FileReader("C:/QC_Batch/QC_LendNation/src/test/java/tests/Objects.properties"));

			prop = new Properties();
						try {
							prop.load(reader);
							reader.close();
						} 
						catch (IOException e) {
							e.printStackTrace();
							}
		  }
			catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
			}
		reports = new ExtentReports(System.getProperty("user.dir") +prop.getProperty("extent_report_path")+filename, true);
	
		}
		
  
  public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/LendNation/FailedTestsScreenshots/"
				+ screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	//@BeforeMethod
	 public void killProcess() throws Exception{
	 
           try{
    
        Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f"); 

        Thread.sleep(5000); //Allow OS to kill the process
        System.out.println("killed the process");
        //break;
        
     }
	 catch(Exception e)
        {
		//break;
		// continue;
        }   
	    }
	 @AfterMethod
	 public void getResult(ITestResult result) throws Exception{
	 if(result.getStatus() == ITestResult.FAILURE){
		 test.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
		 test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
	 //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
	                        //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method. 
	                        //String screenshotPath = getScreenhot(driver, result.getName());
	 //To add it in the extent report 
	                        
 //Commented this
 //test.log(LogStatus.FAIL, test.addScreenCaptureFromPath(screenshotPath));
	 }else if(result.getStatus() == ITestResult.SKIP){
		 test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	 }else if(result.getStatus() == ITestResult.SUCCESS){
		 test.log(LogStatus.PASS, result.getName()+" Test Case is Passed");}
	// reports.endTest(test);
    // reports.flush();
    // extent.flush();

 	 }			
	 @AfterTest
	 
	 public void endReport(){
	 
		// reports.endTest(test);
	     reports.flush();
	                
	               // extent.flush();
	                //driver.quit();
	         
	               
	    }
	 
	 public static By locator(String obj)
		{
			
			String loctype=null;
			String locname=null;
			 By locator=null;
			 String[] locobj=obj.split("%%"); 
			 loctype=locobj[0];
			 locname=locobj[1];
			// System.out.println("startign of switch case");
			// System.out.println(obj);
			 /*switch(loctype)
			 {
			 case "id": 
				 locator=By.id(locname);
				break;
			 case "name": 
				 locator=By.name(locname);
				break;
			 case "linkText": 
				 locator=By.linkText(locname);
				break;
			 case "xpath": 
				 locator=By.xpath(locname);
				break;
			 }*/
			 
			 if(loctype.equalsIgnoreCase("id"))
				 return locator=By.id(locname);
			 else if(loctype.equalsIgnoreCase("name"))
				 return locator=By.name(locname);
			 else if(loctype.equalsIgnoreCase("linkText"))
				 return locator=By.linkText(locname);
			 else if(loctype.equalsIgnoreCase("xpath"))
				 return locator=By.xpath(locname);
			return locator;
			 
			 
			 
			 
			 
			 
			// System.out.println(locator);
			// return locator;
			
			
			 }
			
}
