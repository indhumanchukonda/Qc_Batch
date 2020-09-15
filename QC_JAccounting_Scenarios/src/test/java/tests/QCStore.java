package tests;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//This  is an executable class file.(Execution starts from here)
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QCStore {

	public static WebDriverWait wait;
	public static WebDriver driver;
	public static WebDriver driver1;
	String appUrl;
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());

	public static Properties prop;
	public static Properties Jprop;
	public static Properties Rprop;
	public static Properties Aprop;
	public static Properties Vprop;
	//public static String loan_number;
	public static ExtentReports reports;
	public static ExtentReports Breports;
	public static ExtentReports Jreports;
	public static ExtentReports Rreports;
	public static ExtentReports Areports;
	public static ExtentTest test;
	// public static ExtentReports reports;
	// public static ExtentTest test;
	// static ExtentHtmlReporter htmlReporter;
	// static ExtentReports extent;
	public static String Eankey = null;
	public static String encryption_store_no = null;
	public static String encryption_transaction_nbr = null;
	public static String FileName;
	public static ExcelNew TestData;

	//public static String loan_nbr;
	public static String loan_nbr;
	public static String NextDueDate;
	//public static String AppURL = AppURL;/*"https://qclocalreg.qfund.net/cc/demoIndex.do";*/
	public static String AppURL;
	public static String business_date;
	public static String No_of_Installments;
	public static String transaction_date;
	public static String last4cheknum;
	public static String ESign_CheckNbr;
	public static String Password;
	public static String ESign_CollateralType;
	public static String appdate;
	public static String Date1;
	public static String Date2;
	public static String Date3;
	public static String Str_date;
	public static String customer_number;
	public static String Waive_Type;
	public static String ESign_Preference;
	public static String ESign_CourtesyCallConsent;
	public static String Statementdate;
	public static String Duedate_confirm_text3;

	public static String Drawer_OverShort_Amount;

	public static String Due_Date1;
	public static String Due_Date2;
	public static String Due_Date3;
	public static String passwrd;
	public static String FirstName;

	public static String AdminURL;

	public static String csr_url;
	public static String csrloginpage;
	public static String Tran_Nbr;
	public static String DepositType;
	public static String TenderAmount;

	
	
//================================  Jyothi PDL Accounting Scenarios  ====================================================

	             // ---------------- Accounting Scenarios Starts ----------------

     
	 @Test(priority = 1, groups = "Jyothi_PDL_Accounting1")
     public static void QC_Full_Buyback_Txn() throws Exception {
			try {
				test = reports.startTest(("QC_Full_Buyback_Txn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_Full_Buyback_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						  //String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						
					   /* VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						   //VQCCSRBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);*/
						
						VQCSRLoginLogout.login(SSN, AppURL);
					
						VQCCSRNewLoan_LOC.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);												
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
													       	
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						
						VQCSRWaiveFee.WaiveFeeFull(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRBuyBack.buyback(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						/*VQCSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);*/
						

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Full_Buyback_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}	
      @Test(priority = 2, groups = "Jyothi_PDL_Accounting")
       public static void QC_Full_BuybackVoid_Txn() throws Exception {
			try {
				test = reports.startTest(("QC_Full_BuybackVoid_Txn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_Full_BuybackVoid_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						String AppURL="https://qclocalauto.qfund.net/cc/demoIndex.do";
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						    //VQCCSRBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);	
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRNewLoan_LOC.newLoan(SSN, SSN);
						//QCCSRNewLoan.newLoan(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);												
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
													       	
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRWaiveFee.WaiveFeeFull(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRBuyBack.buyback(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRBuyBackVoid.buybackvoid(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);*/
						

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Full_Buyback_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}
 
  @Test(priority = 3, groups = "Jyothi_PDL_Accounting")
     public static void QC_Partial_Buyback_Txn() throws Exception {
			try {
				test = reports.startTest(("QC_Partial_Buyback_Txn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_Partial_Buyback_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						       //VQCCSRBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);	
						
						VQCSRLoginLogout.login(SSN, AppURL);
						//QCCSRNewLoan.newLoan(SSN, AppURL);
						VQCCSRNewLoan_LOC.newLoan(SSN, SSN);					
						VQCSRLoginLogout.logout(SSN, AppURL);												
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
													       	
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRWaiveFee.WaiveFeePartial(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRBuyBack.buyback(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
					/*	VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);*/
						

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Full_Buyback_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}	
     
	
  @Test(priority = 4, groups = "Jyothi_PDL_Accounting")
      public static void QC_Partial_BuybackVoid_Txn() throws Exception {
			try {
				test = reports.startTest(("QC_Partial_BuybackVoid_Txn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_Partial_BuybackVoid_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						      //String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						       //VQCCSRBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);	
						
						VQCSRLoginLogout.login(SSN, AppURL);
						//QCCSRNewLoan.newLoan(SSN, AppURL);
						VQCCSRNewLoan_LOC.newLoan(SSN, SSN);				
						VQCSRLoginLogout.logout(SSN, AppURL);												
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
													       	
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
					    VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRWaiveFee.WaiveFeePartial(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRBuyBack.buyback(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRBuyBackVoid.buybackvoid(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);*/
						

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Full_Buyback_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}	
    
  @Test(priority = 5, groups = "Jyothi_PDL_Accounting")
     public static void QC_Full_Refinance_Txn() throws Exception {
			try {
				test = reports.startTest(("QC_Full_Refinance_Txn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_Full_Refinance_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						       //VQCCSRBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);	
						
						VQCSRLoginLogout.login(SSN, AppURL);
						//QCCSRNewLoan.newLoan(SSN, AppURL);
						VQCCSRNewLoan_LOC.newLoan(SSN, SSN);					
						VQCSRLoginLogout.logout(SSN, AppURL);												
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
													       	
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRWaiveFee.WaiveFeeFull(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRRefinanace.payment(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
					/*	VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);*/
						

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Full_Buyback_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}	
		
  @Test(priority = 6, groups = "Jyothi_PDL_Accounting")
     public static void QC_Full_RefinanceVoid_Txn() throws Exception {
			try {
				test = reports.startTest(("QC_Full_RefinanceVoid_Txn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_Full_RefinanceVoid_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
				        VQCSRLoginLogout.login(SSN, AppURL);
						//VQCCSRBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);	
						
						VQCSRLoginLogout.login(SSN, AppURL);
						//QCCSRNewLoan.newLoan(SSN, AppURL);
						VQCCSRNewLoan_LOC.newLoan(SSN, SSN);						
						VQCSRLoginLogout.logout(SSN, AppURL);												
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
													       	
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRWaiveFee.WaiveFeeFull(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRRefinanace.payment(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRVoid.Refinancevoid(SSN, AppURL);
						//VQCCSRVoid_ILP.Refinancevoid(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Full_RefinanceVoid_Txn_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}
    
    
  @Test(priority = 7, groups = "Jyothi_PDL_Accounting")
     public static void QC_Partial_Refinance_Txn() throws Exception {
			try {
				test = reports.startTest(("QC_Partial_Refinance_Txn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_Partial_Refinance_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						
						VQCSRLoginLogout.logout(SSN, AppURL);	
						
						VQCSRLoginLogout.login(SSN, AppURL);
						//QCCSRNewLoan.newLoan(SSN, AppURL);
						VQCCSRNewLoan_LOC.newLoan(SSN, AppURL);						
						VQCSRLoginLogout.logout(SSN, AppURL);												
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
													       	
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRWaiveFee.WaiveFeePartial(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRRefinanace.payment(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
					/*	VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);*/
						

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Full_Buyback_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}	
		
   @Test(priority = 8, groups = "Jyothi_PDL_Accounting")
     public static void QC_Partial_RefinanceVoid_Txn() throws Exception {
			try {
				test = reports.startTest(("QC_Partial_RefinanceVoid_Txn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_Partial_RefinanceVoid_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						//VQCCSRBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);	
						
						VQCSRLoginLogout.login(SSN, AppURL);
						//QCCSRNewLoan.newLoan(SSN, AppURL);
						VQCCSRNewLoan_LOC.newLoan(SSN, AppURL);						
						VQCSRLoginLogout.logout(SSN, AppURL);												
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
													       	
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRWaiveFee.WaiveFeePartial(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRRefinanace.payment(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRVoid.Refinancevoid(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Full_RefinanceVoid_Txn_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}
    
     
 @Test(priority = 16, groups = "Jyothi_PDL_Accounting")
     public static void QC_Deposit_Returnposting_RedepositTxn() throws Exception {
			try {
				test = reports.startTest(("QC_Deposit_Returnposting_RedepositTxn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_Deposit_Returnposting_RedepositTxn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						
						VQCSRLoginLogout.logout(SSN, AppURL);	
						
						VQCSRLoginLogout.login(SSN, AppURL);
						
						VQCCSRNewLoan_LOC.newLoan(SSN, AppURL);						
						VQCSRLoginLogout.logout(SSN, AppURL);												
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);							       	
						VQCCSRDepositDropdown.depositDropDown(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRInternalTransfer.internalTransfer(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCCSRAdminLoginLogout.login(SSN, AppURL);
						
						VQCCSRReturnPosting.ReturnPosting(SSN, AppURL);
						VQCCSRAdminLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						AQC_Redeposit.redeposit(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Full_RefinanceVoid_Txn_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}   
 @Test(priority = 10, groups = "Jyothi_PDL_Accounting")
     public static void QC_RefinanceVoid_NSF_ReturnTxn() throws Exception {
			try {
				test = reports.startTest(("QC_RefinanceVoid_NSF_ReturnTxn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_RefinanceVoid_NSF_ReturnTxn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						//VQCCSRBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);	
						
						VQCSRLoginLogout.login(SSN, AppURL);
						//QCCSRNewLoan.newLoan(SSN, AppURL);
						VQCCSRNewLoan_LOC.newLoan(SSN, AppURL);						
						VQCSRLoginLogout.logout(SSN, AppURL);												
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);							       	
						VQCCSRDepositDropdown.depositDropDown(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRInternalTransfer.internalTransfer(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCCSRAdminLoginLogout.login(SSN, AppURL);
						//VQCCSRReturnCheck.qcRturn(SSN, AppURL);
						VQCCSRReturnPosting.ReturnPosting(SSN, AppURL);
						
						VQCCSRAdminLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRWaiveFee.WaiveFeeFull(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRRefinanaceII.payment(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRVoid.Refinancevoid(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Full_RefinanceVoid_Txn_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}
        
  @Test(priority = 11, groups = "Jyothi_PDL_Accounting")
     public static void QC_Full_BuybackReturn_NSF_PaymentTxn() throws Exception {
			try {
				test = reports.startTest(("QC_Full_BuybackReturn_NSF_Payment_Txn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_Full_BuybackReturn_NSF_Payment_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						String AppURL="https://qclocalauto.qfund.net/cc/demoIndex.do";
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						     
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);	
						
						VQCSRLoginLogout.login(SSN, AppURL);
						//QCCSRNewLoan.newLoan(SSN, AppURL);
						VQCCSRNewLoan_LOC.newLoan(SSN, AppURL);						
						VQCSRLoginLogout.logout(SSN, AppURL);												
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
													       	
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRWaiveFee.WaiveFeeFull(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRBuyBack.buyback(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRInternalTransfer.internalTransfer(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRCashMgmtDepositccMo.cashmgmtDeposit(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						
						VQCAdminCCKReturn.cckreturn(SSN, AppURL);
						
						 VQCSRLoginLogout.login(SSN, AppURL);
					     AQC_NSFPayment.nsfpayment(SSN, SSN);
					     VQCSRLoginLogout.logout(SSN, AppURL);
						
						
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);*/
						

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Full_Buyback_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}	
   
@Test(priority = 16, groups = "Jyothi_PDL_Accounting")
     public static void QC_Full_BuybackReturn_NSF_PaymentVoidTxn() throws Exception {
			try {
				test = reports.startTest(("QC_Full_BuybackReturn_NSF_PaymentVoid_Txn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_Full_BuybackReturn_NSF_PaymentVoid_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						String AppURL="https://qclocalauto.qfund.net/cc/demoIndex.do";
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						     
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);	
						
						VQCSRLoginLogout.login(SSN, AppURL);
						//QCCSRNewLoan.newLoan(SSN, AppURL);
						VQCCSRNewLoan_LOC.newLoan(SSN, AppURL);						
						VQCSRLoginLogout.logout(SSN, AppURL);												
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
													       	
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRWaiveFee.WaiveFeeFull(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRBuyBack.buyback(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRInternalTransfer.internalTransfer(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRCashMgmtDepositccMo.cashmgmtDeposit(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCAdminCCKReturn.cckreturn(SSN, AppURL);
						
						 VQCSRLoginLogout.login(SSN, AppURL);
					     AQC_NSFPayment.nsfpayment(SSN, SSN);
					     VQCSRLoginLogout.logout(SSN, AppURL);
						
						 VQCSRLoginLogout.login(SSN, AppURL);
						 VQCCSRVoid.Refinancevoid(SSN, AppURL);
						 
						 VQCSRLoginLogout.logout(SSN, AppURL);
						
						
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);*/
						

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Full_Buyback_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}	
     

   @Test(priority = 12, groups = "Jyothi_PDL_Accounting")
     public static void QC_Deposit_ReturnPaymentTxn() throws Exception {
			try {
				test = reports.startTest(("QC_Deposit_ReturnPaymentTxn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_Deposit_ReturnPaymentTxn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);	
						
						VQCSRLoginLogout.login(SSN, AppURL);
						//QCCSRNewLoan.newLoan(SSN, AppURL);
						VQCCSRNewLoan_LOC.newLoan(SSN, AppURL);						
						VQCSRLoginLogout.logout(SSN, AppURL);												
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);							       	
				        VQCCSRDepositDropdown.depositDropDown(SSN, AppURL);
				                                              //VQCCSR_Deposit.deposit(SSN, SSN);
				        VQCSRLoginLogout.logout(SSN, AppURL);
						
				             //VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRAdminLoginLogout.login(SSN, AppURL);
				        QCCSRReturnPosting.returnposting(SSN, AppURL);
				        VQCSRLoginLogout.logout(SSN, AppURL);
				        
				        VQCCSRAdminLoginLogout.login(SSN, AppURL);
				        QCAdminACHReturn.achreturn(SSN, AppURL);
				        
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRWaiveFee.WaiveFeePartial(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
				        AQC_ACHPayment.ACHPayment(SSN, SSN);
				        VQCSRLoginLogout.logout(SSN, AppURL);
						
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Full_RefinanceVoid_Txn_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}
           
   @Test(priority = 13, groups = "Jyothi_PDL_Accounting")
     public static void QC_Deposit_Return_RefinanceTxn() throws Exception {
			try {
				test = reports.startTest(("QC_Deposit_Return_RefinanceTxn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_Deposit_Return_Refinance_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);	
						
						VQCSRLoginLogout.login(SSN, AppURL);
						//QCCSRNewLoan.newLoan(SSN, AppURL);
						VQCCSRNewLoan_LOC.newLoan(SSN, AppURL);						
						VQCSRLoginLogout.logout(SSN, AppURL);												
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);      
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);							       	
				        VQCCSRDepositDropdown.depositDropDown(SSN, AppURL);
				                                              //VQCCSR_Deposit.deposit(SSN, SSN);
				        VQCSRLoginLogout.logout(SSN, AppURL);
						
				             //VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRAdminLoginLogout.login(SSN, AppURL);
				        QCCSRReturnPosting.returnposting(SSN, AppURL);
				        VQCSRLoginLogout.logout(SSN, AppURL);
				        
				        VQCCSRAdminLoginLogout.login(SSN, AppURL);
				        QCAdminACHReturn.achreturn(SSN, AppURL);
				        
				        VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRRefinanaceII.payment(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
				        
						
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);*/
						

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Deposit_Return_RefinanceTxn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}
  
   @Test(priority = 14, groups = "Jyothi_PDL_Accounting")
     public static void QC_Deposit_Return_RefinanceVoidTxn() throws Exception {
			try {
				test = reports.startTest(("QC_Deposit_Return_RefinanceVoidTxn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_Deposit_Return_RefinanceVoid_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);	
						
						VQCSRLoginLogout.login(SSN, AppURL);
						//QCCSRNewLoan.newLoan(SSN, AppURL);
						VQCCSRNewLoan_LOC.newLoan(SSN, AppURL);						
						VQCSRLoginLogout.logout(SSN, AppURL);												
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);      
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);							       	
				        VQCCSRDepositDropdown.depositDropDown(SSN, AppURL);
				                                              //VQCCSR_Deposit.deposit(SSN, SSN);
				        VQCSRLoginLogout.logout(SSN, AppURL);
						
				        //VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRAdminLoginLogout.login(SSN, AppURL);
				        QCCSRReturnPosting.returnposting(SSN, AppURL);
				        VQCSRLoginLogout.logout(SSN, AppURL);
				        
				        VQCCSRAdminLoginLogout.login(SSN, AppURL);
				        QCAdminACHReturn.achreturn(SSN, AppURL);
				        
				        VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRRefinanaceII.payment(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRVoid.Refinancevoid(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
				        
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Deposit_Return_RefinanceVoidTxn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}

  @Test(priority = 15, groups = "Jyothi_PDL_Accounting")
     public static void QC_EPP_Return_NSFpaymentTxn() throws Exception {
			try {
				test = reports.startTest(("QC_EPP_Return_NSFpaymentTxn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_EPP_Return_NSFpaymentTxn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);	
						
						VQCSRLoginLogout.login(SSN, AppURL);
						//QCCSRNewLoan.newLoan(SSN, SSN); 
						JQCCSRNewLoan.newLoan(SSN, SSN);
						//VQCCSRNewLoan_LOC.newLoan(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);												
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCStoreEPP.epp(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
					
						
						VQCSRLoginLogout.login(SSN, AppURL);							       	
				        VQCCSRDepositDropdown.depositDropDown(SSN, AppURL);
				                                              //VQCCSR_Deposit.deposit(SSN, SSN);
				        VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCCSRAdminLoginLogout.login(SSN, AppURL);
				        QCCSRReturnPosting.returnposting(SSN, AppURL);
				        VQCSRLoginLogout.logout(SSN, AppURL);
				        
				        VQCCSRAdminLoginLogout.login(SSN, AppURL);
				        QCAdminACHReturn.achreturn(SSN, AppURL);
				        
				        VQCSRLoginLogout.login(SSN, AppURL);
				        AQC_NSFPayment.nsfpayment(SSN, SSN);
				        VQCSRLoginLogout.logout(SSN, AppURL);
				       
				        
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Deposit_Return_RefinanceVoidTxn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}
     
     
     
     
      @Test(priority = 21, groups = "Jyothi_PDL_Accounting")
     public static void QC_PDL_Conversion() throws Exception {
			try {
				test = reports.startTest(("QC_PDL_ConversionTxn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_PDL_Conversion_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						
						/*VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);      
						VQCSRLoginLogout.logout(SSN, AppURL);*/
						
					    VQCSRLoginLogout.login(SSN, AppURL);
						QCCSRILPConversion.conversion(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						/*VQCSRLoginLogout.login(SSN, AppURL);
						//VQCCSRVoid_ILP.Refinancevoid(SSN, AppURL);
						VQCCSRVoid.Refinancevoid(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);*/
					
						
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);*/
						 

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Deposit_Return_RefinanceVoidTxn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}

     /// Issue Reported
  @Test(priority = 22, groups = "Jyothi_PDL_Accounting")
     public static void QC_PDL_Conversion_CK() throws Exception {
			try {
				test = reports.startTest(("QC_PDL_Conversion_CKTxn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_PDL_Conversion_CK_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);      
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCCSRILPConversion.conversion(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRVoid_ILP.Refinancevoid(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);*/
						

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Deposit_Return_RefinanceVoidTxn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}
 
    @Test(priority = 23, groups = "Jyothi_PDL_Accounting")
     public static void QC_PDL_Conversion_CKOT() throws Exception {
			try {
				test = reports.startTest(("QC_PDL_Conversion_CKOT"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_PDL_Conversion_CKOT_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);      
						VQCSRLoginLogout.logout(SSN, AppURL); 
						VQCSRLoginLogout.login(SSN, AppURL);
						QCCSRILPConversion.conversion(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);			
						
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Deposit_Return_RefinanceVoidTxn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}
 
    @Test(priority = 24, groups = "Jyothi_PDL_Accounting")
     public static void QC_PDL_Conversion_Refinance() throws Exception {
			try {
				test = reports.startTest(("QC_PDL_Conversion_Refinance_Txn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_PDL_Conversion_Refinance_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						/*VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);      
						VQCSRLoginLogout.logout(SSN, AppURL);*/ 
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRRefinanace.payment(SSN, AppURL);
						
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRVoid_ILPRef.Refinancevoid(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Deposit_Return_RefinanceVoidTxn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}
 
     @Test(priority = 25, groups = "Jyothi_PDL_Accounting")
     public static void QC_TwoPDL_Conversion_ChangeAmt() throws Exception {
			try {
				test = reports.startTest(("QC_TwoPDL_Conversion_ChangeAmt_Txn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_TwoPDL_Conversion_ChangeAmt_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, SSN);
						//JQCCSRNewLoan2.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);      
						VQCSRLoginLogout.logout(SSN, AppURL); 
						VQCSRLoginLogout.login(SSN, AppURL);
						QCCSRILPConversion.conversion(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						
						QCPaymentChangeAmt.payment(SSN, SSN);
						    
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRVoid_PDL.payment(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Deposit_Return_RefinanceVoidTxn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}
 

     @Test(priority = 26, groups = "Jyothi_PDL_Accounting")
     public static void QC_TwoPDL_Conversion_ChangeAmtdisbCK() throws Exception {
			try {
				test = reports.startTest(("QC_TwoPDL_Conversion_ChangeAmtdisbCK_Txn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_TwoPDL_Conversion_ChangeAmtdisbCK_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
					    VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						//QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, SSN);
						
						//JQCCSRNewLoan2.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);      
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						
						VQCSRLoginLogout.login(SSN, AppURL);						
						QCCSRILPConversion.conversion(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						
						QCPaymentChangeAmt.payment(SSN, SSN);
						    
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRVoid_PDL.payment(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Deposit_Return_RefinanceVoidTxn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}
 
    @Test(priority = 27, groups = "Jyothi_PDL_Accounting")
   
     public static void QC_TwoPDL_Conversion_ChangeAmtdisbCash() throws Exception {
			try {
				test = reports.startTest(("QC_TwoPDL_Conversion_ChangeAmtdisbCash_Txn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_TwoPDL_Conversion_ChangeAmtdisbCash_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						/*VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);*/
						/*VQCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						//JQCCSRNewLoan2.newLoan(SSN, SSN);
						JQCCSRNewLoan.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);      
						VQCSRLoginLogout.logout(SSN, AppURL); 
						VQCSRLoginLogout.login(SSN, AppURL);
						QCCSRILPConversion.conversion(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);*/
						
						VQCSRLoginLogout.login(SSN, AppURL);
						
						QCPaymentChangeAmt.payment(SSN, SSN);
						    
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRVoid_PDL.payment(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Deposit_Return_RefinanceVoidTxn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		} 
     
    @Test(priority = 28, groups = "Jyothi_PDL_Accounting")
     public static void QC_TwoPDL_Conversion_disbCashDC() throws Exception {
			try {
				test = reports.startTest(("QC_TwoPDL_Conversion_disbCashDC_Txn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_TwoPDL_Conversion_disbCashDC_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
					
						VQCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						//JQCCSRNewLoan2.newLoan(SSN, SSN);
						JQCCSRNewLoan.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);      
						VQCSRLoginLogout.logout(SSN, AppURL); 
						VQCSRLoginLogout.login(SSN, AppURL);
						QCCSRILPConversion.conversion(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						//QCPaymentChangeAmt.payment(SSN, SSN);
						QCPayment.payment(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Deposit_Return_RefinanceVoidTxn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		} 
     
     @Test(priority = 29, groups = "Jyothi_PDL_Accounting")
     public static void QC_TwoPDL_Conversion_disbCashDCVoid() throws Exception {
			try {
				test = reports.startTest(("QC_TwoPDL_Conversion_disbCashDCVoid_Txn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_TwoPDL_Conversion_disbCashDCVoid_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						//JQCCSRNewLoan2.newLoan(SSN, SSN);
						JQCCSRNewLoan.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);      
						VQCSRLoginLogout.logout(SSN, AppURL); 
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCCSRILPConversion.conversion(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCPayment.payment(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRVoid_DC.payment(SSN, SSN);
						//VQCCSRVoid_ILP.Refinancevoid(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Deposit_Return_RefinanceVoidTxn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		} 
     
     @Test(priority = 30, groups = "Jyothi_PDL_Accounting")
     public static void QC_TwoPDL_Con_multidisbDCVoid_cash() throws Exception {
			try {
				test = reports.startTest(("QC_TwoPDL_Con_multidisbDCVoid_cash_Txn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_TwoPDL_Con_multidisbDCVoid_cash_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						//JQCCSRNewLoan2.newLoan(SSN, SSN);
						JQCCSRNewLoan.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);      
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCCSRILPConversion.conversionwithmultipledisb(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRVoid_ILP.Refinancevoid(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
		
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Deposit_Return_RefinanceVoidTxn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		} 
     
     @Test(priority = 31, groups = "Jyothi_PDL_Accounting")
     public static void QC_TwoPDL_Con_multidisbDCVoid_DC() throws Exception {
			try {
				test = reports.startTest(("QC_TwoPDL_Conversion_RefinanceDCVoid_DC_Txn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_TwoPDL_Con_multidisbDCVoid_DC_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						//JQCCSRNewLoan2.newLoan(SSN, SSN);
						JQCCSRNewLoan.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);      
						VQCSRLoginLogout.logout(SSN, AppURL); 
						VQCSRLoginLogout.login(SSN, AppURL);
						QCCSRILPConversion.conversionwithmultipledisb(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRVoid_ILP.Refinancevoid(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
		
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Deposit_Return_RefinanceVoidTxn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		} 
    @Test(priority = 20, groups = "Jyothi_PDL_Accounting")
      public static void QC_PDL_DCPayment_RescindEK() throws Exception {
			try {
				test = reports.startTest(("QC_PDL_DC Payment_RescindEKTxn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_PDL_DC Payment_RescindEKTxn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						JQCPayment.payment(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);      
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						ACSRRescindLoan.rescind(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Deposit_Return_RefinanceVoidTxn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}  
    @Test(priority = 18, groups = "Jyothi_PDL_Accounting")
     public static void QC_ILP_DCPayment_Bankruptcy() throws Exception {
			try {
				test = reports.startTest(("QC_ILP_DCPayment_BankruptcyTxn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_ILP_DCPayment_Bankruptcy_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						
					    VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan_ILP.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCDCPayment.payment(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRBankruptcy.bankruptcy(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VAdminLoginForBankruptcy.bankruptcy(driver, SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						Chargeback.chargeback(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Deposit_Return_RefinanceVoidTxn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}
  @Test(priority = 17, groups = "Jyothi_PDL_Accounting")
     public static void QC_ILP_DCPayment_ChargeBack() throws Exception {
			try {
				test = reports.startTest(("QC_ ILP_DC Payment_ChargeBackTxn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_ ILP_DC Payment_ChargeBackTxn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan_ILP.newLoan(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCDCPayment.payment(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						Chargeback.chargeback(SSN, SSN);
						VQCSRLoginLogout.logout(SSN, AppURL);
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Deposit_Return_RefinanceVoidTxn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}

    @Test(priority = 19, groups = "Jyothi_PDL_Accounting")
     public static void QC_PDL_DCPayment_Rescind() throws Exception {
		try {
			test = reports.startTest(("QC_PDL_DC Payment_RescindTxn"),

					
		    "CSR Login->Borrower Registration-->NewLoan-->");
			String FileName = "QC_PDL_DC Payment_RescindTxn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);
					VQCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					VQCSRLoginLogout.logout(SSN, AppURL);
					
					VQCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, SSN);
					//VQCCSRNewLoan_LOC.newLoan(SSN, AppURL);
					VQCSRLoginLogout.logout(SSN, AppURL);
					VQCSRLoginLogout.login(SSN, AppURL);
					JQCPayment.payment(SSN, SSN);
					VQCSRLoginLogout.logout(SSN, AppURL);
					VQCSRLoginLogout.login(SSN, AppURL);
					      //JQCRescind.Rescind(SSN, SSN);
					ACSRRescindLoan.rescind(SSN, SSN);
					VQCSRLoginLogout.logout(SSN, AppURL);
					/*VQCSRLoginLogout.login(SSN, AppURL);
					VQCCSRHistory.history(SSN, AppURL);
					VQCSRLoginLogout.logout(SSN, AppURL);
					*/

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Deposit_Return_RefinanceVoidTxn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");
			

		}
	}
 
  @Test(priority = 9, groups = "Jyothi_PDL_Accounting")
    public static void QC_Refinance_NSF_ReturnTxn() throws Exception {
			try {
				test = reports.startTest(("QC_Refinance_NSF_ReturnTxn"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->");
				String FileName = "QC_Refinance_NSF_ReturnTxn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						VQCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						//VQCCSRBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);	
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRNewLoan_LOC.newLoan(SSN, AppURL);						
						VQCSRLoginLogout.logout(SSN, AppURL);												
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);							       	
						VQCCSRDepositDropdown.depositDropDown(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRInternalTransfer.internalTransfer(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCCSRAdminLoginLogout.login(SSN, AppURL);
						         //VQCCSRReturnCheck.qcRturn(SSN, AppURL);
						VQCCSRReturnPosting.ReturnPosting(SSN, AppURL);
						VQCCSRAdminLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRWaiveFee.WaiveFeeFull(SSN, AppURL);       
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						VQCSRLoginLogout.login(SSN, AppURL);
						VQCSRRefinanaceII.payment(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						
						
						/*VQCSRLoginLogout.login(SSN, AppURL);
						VQCCSRHistory.history(SSN, AppURL);
						VQCSRLoginLogout.logout(SSN, AppURL);
						*/

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Full_RefinanceVoid_Txn_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				

			}
		}
       

//============================================================================================================
	


	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException {

		try {

			BufferedReader reader;
			BufferedReader Jreader;
			BufferedReader Rreader;
			BufferedReader Areader;
			BufferedReader Vreader;

			

			try {
				Vreader = new BufferedReader(

						new FileReader("C:/QC_Batch11/QC_JAccounting_Scenarios/src/test/java/tests/VObjects.properties"));
				                       
				Vprop = new Properties();
				Vprop = new Properties();
				Vprop.load(Vreader);
				Vreader.close();
				csr_url = Vprop.getProperty("CSR_URL");
				csrloginpage = Vprop.getProperty("Login_Page");
				AdminURL = Vprop.getProperty("ADMIN_CSR_URL");
				
				
				String Vfilename = Vprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Vprop.getProperty("QC_Store_extent_report_path") + Vfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

		

			//System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");

		//}
//		try {
//			reader = new BufferedReader(
//
//					new FileReader("C:/QC_Batch/QC_Accounting_Scenarios/src/test/java/tests/VObjects.properties"));
//			                       
//			prop = new Properties();
//			prop = new Properties();
//			prop.load(reader);
//			reader.close();
//			csr_url = prop.getProperty("CSR_URL");
//			csrloginpage = prop.getProperty("login_page");
//			AdminURL = prop.getProperty("ADMIN_URL");
//			
//			
//			String filename = prop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";
//
//			reports = new ExtentReports(
//					System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") + filename,
//					true);
//
//		}
//
//		catch (Exception e) {
//
//			System.out.println("Object proprties file not found");
//		}

	

		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");

	}


		catch (Exception e) {

			test.log(LogStatus.ERROR, "Unable to setup for the QC Store ");

		}

	}

	@BeforeMethod(alwaysRun = true)

	public void killProcess() throws Exception {

		try {

			//Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

			//Thread.sleep(5000); // Allow OS to kill the process
			System.out.println("killed the process PDL scenarios");
			// break;

		} catch (Exception e) {
			// break;
			// continue;
		}
	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/QCStore/PDL/FailedTestsScreenshots/"
				+ screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterMethod(alwaysRun = true)

	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			// test.log(LogStatus.FAIL, "Test Case Failed is
			// "+result.getThrowable());

			String screenshotPath = getScreenhot(driver, result.getName());
			// To add it in the extent report
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " Test Case is Passed");
		}
		reports.flush();
		driver.quit();

	}

	@AfterMethod(alwaysRun = true)

	public void endReport() {

		// reports.endTest(test);
		// reports.flush();

		// driver.quit();
		// extent.flush();

	}

	public static By locator(String obj) {

		String loctype = null;
		String locname = null;
		By locator = null;
		String[] locobj = obj.split("%%");
		loctype = locobj[0];
		locname = locobj[1];
		

		if (loctype.equalsIgnoreCase("id"))
			return locator = By.id(locname);
		else if (loctype.equalsIgnoreCase("name"))
			return locator = By.name(locname);
		else if (loctype.equalsIgnoreCase("linkText"))
			return locator = By.linkText(locname);
		else if (loctype.equalsIgnoreCase("partialLinkText"))
			return locator = By.partialLinkText(locname);
		else if (loctype.equalsIgnoreCase("xpath"))
			return locator = By.xpath(locname);
		else if (loctype.equalsIgnoreCase("cssSelector"))
			return locator = By.cssSelector(locname);
		return locator;

		// System.out.println(locator);
		// return locator;

	}

}
