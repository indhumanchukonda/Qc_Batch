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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QCStore {

	public static WebDriverWait wait;
	public static WebDriver driver;
	public static WebDriver driver1;
	String appUrl;
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());

	public static Properties Jprop;
	public static String loan_number;
	public static ExtentReports reports;
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
	public static String loan_nbr;
	public static String business_date;
	public static String AppURL;
	
	public static String AdminURL;
	public static String csrloginpage;
	public static String csr_url;

	public static String FirstName;
	public static String passwrd;
	public static String report_filename;
	public static String LastName;
	public static String ESign_CheckNbr;
	public static String ESign_CollateralType;

	public static String NextDueDate;
	public static String customer_number;

	// Janaki scenarios

	@Test(priority = 1, enabled = true, groups = "Janaki")

	public static void JQC_PDL_To_ILP_Loan_Conversion_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("PDL_To_ILP_Loan_Conversion_Txn")),
					"Login -> Borrower Registratino with PDL ->New Loan with PDL -> PDL To ILP Loan Conversion");

			FileName = Jprop.getProperty("PDL_To_ILP_Loan_Conversion_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					//10510288
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPDLBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPDLCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);	
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCConversion.ILPConversion(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("JQC_PDL_To_ILP_Loan_Conversion_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "JQC_PDL_To_ILP_Loan_Conversion_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario JQC_PDL_To_ILP_Loan_Conversion_Txn ");

		}
	}

	@Test(priority = 2, enabled = true, groups = "Indhu12")

	public static void JQC_ILP_To_TLPConversion_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("ILP_TLP_Conversion")),
					"Login -> Borrower Registratino with ILP ->New Loan with ILP -> Gracedays -> ILP To TLP Loan Conversion");

			FileName = Jprop.getProperty("ILP_TLP_Conversion_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPCSRNewLoan.newLoan(SSN, AppURL);
					//JQCILPCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);	
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ilpageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCTLPConversion.TLPConversion(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("ILP_TLP_Conversion");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "ILP_TLP_Conversion");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario ILP_TLP_Conversion ");

		}
	}
	
	
	@Test(priority = 3, enabled= true, groups = "Janaki")

	public static void JQC_ILPWithILPLoan_PDLLoan_To_ILPConversion_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("ILPWithILPLoan_PDLLoan_To_ILPConversion_Txn")),
					"Login -> Borrower Registratino with ILP ->New Loan with ILP -> Again New Loan with PDL -> PDL To ILP Loan Conversion");

			FileName = Jprop.getProperty("ILPWithILPLoan_PDLLoan_To_ILPConversion_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);	
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPDLCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCConversion.ILPSignatureConversion(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("ILPWithILPLoan_PDLLoan_To_ILPConversion_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "ILPWithILPLoan_PDLLoan_To_ILPConversion_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario ILPWithILPLoan_PDLLoan_To_ILPConversion_Txn ");

		}
	}
	
	@Test(priority = 4, enabled = true, groups = "Janaki1")

	public static void JQC_ILPDefaultLoan_PDLLoan_To_ILPConversion_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("ILPDefaultLoan_PDLLoan_To_ILPConversion_Txn")),
					"Login -> Borrower Registratino with ILP ->New Loan with ILP ->Manual Default -> Again New Loan with PDL -> PDL To ILP Loan Conversion");

			FileName = Jprop.getProperty("ILPDefaultLoan_PDLLoan_To_ILPConversion_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPDLCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
					//JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCConversion.ILPSignatureConversion(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					

				}
			}
		}

		catch (Exception e) {
			System.out.println("ILPWithILPLoan_PDLLoan_To_ILPConversion_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "ILPWithILPLoan_PDLLoan_To_ILPConversion_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario ILPWithILPLoan_PDLLoan_To_ILPConversion_Txn ");

		}
	}

	@Test(priority = 5, enabled = true, groups = "Janaki")

	public static void JQC_ILPHeldLoan_PDLWriteOffLoan_PDLLoan_To_ILPConversion_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("ILPHeldLoan_PDLWriteOffLoan_PDLLoan_To_ILPConversion_Txn")),
					"Login -> Borrower Registratino with ILP ->New Loan with ILP ->Manual Default -> Again New Loan with PDL -> PDL To ILP Loan Conversion");

			FileName = Jprop.getProperty("ILPHeldLoan_PDLWriteOffLoan_PDLLoan_To_ILPConversion_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				if (RunFlag.equals("Y")) {

					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPDLCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPDLCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositDropdown.depositDropDown(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					if (ESign_CollateralType.equalsIgnoreCase("ACH")) {
						JQCAdminLoginLogout.login(SSN, NextDueDate);
						JQCACHProcessing.ACHProcess(SSN, NextDueDate);
						JQCAdminLoginLogout.logout(SSN, NextDueDate);
						/*JQCCSRLoginLogout.login(SSN, AppURL);
						JQCACHReturn.ACHReturn(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);*/
						JQCAdminLoginLogout.login(SSN, AppURL);
						AQCAdminACHReturn.achreturn(SSN, AppURL);
						JQCAdminLoginLogout.logout(SSN, AppURL);
					} else if (ESign_CollateralType.equalsIgnoreCase("CHECK")) {
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCInternalTransfer.InternalTransfer(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCmgDeposit.CmgDeposit(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCAdminLoginLogout.login(SSN, AppURL);
						JQCCSRReturnPosting.ReturnPosting(SSN, AppURL);
						JQCAdminLoginLogout.logout(SSN, AppURL);
					}
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRWriteOff.writeoff(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCConversion.ILPNotEligibleConversion(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					

				}
			}
		}

		catch (Exception e) {
			System.out.println("ILPHeldLoan_PDLWriteOffLoan_PDLLoan_To_ILPConversion");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "ILPHeldLoan_PDLWriteOffLoan_PDLLoan_To_ILPConversion");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario ILPHeldLoan_PDLWriteOffLoan_PDLLoan_To_ILPConversion ");

		}
	}
	
	@Test(priority = 6, enabled = true, groups = "Janaki")
	public static void JQC_TwoPDLLoan_PDLLoan_To_ILPConversion_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("TwoPDLLoan_PDLLoan_To_ILPConversion_Txn")),
					"Login -> Borrower Registratino with PDL ->Two New Loan with PDL -> PDL To ILP Loan Conversion");

			FileName = Jprop.getProperty("TwoPDLLoan_PDLLoan_To_ILPConversion_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPDLBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPDLCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPDLCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCConversion.PDLILPConversion(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
				}
			}
		}

		catch (Exception e) {
			System.out.println("ILPWithILPLoan_PDLLoan_To_ILPConversion_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "ILPWithILPLoan_PDLLoan_To_ILPConversion_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario ILPWithILPLoan_PDLLoan_To_ILPConversion_Txn ");

		}
	}
	
	@Test(priority = 7, enabled = true, groups = "Janaki")
	public static void JQC_PDLWithPDLLoan_ManualDefault_PDL_To_ILPConversion_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("PDLWithPDLLoan_ManualDefault_PDL_To_ILPConversion_Txn")),
					"Login -> Borrower Registratino with PDL -> New Loan with PDL -> Manual Default -> PDL To ILP Loan Conversion");

			FileName = Jprop.getProperty("PDLWithPDLLoan_ManualDefault_PDL_To_ILPConversion_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPDLBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPDLCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
					//JQCCSRLoginLogout.logout(SSN, AppURL);					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCConversion.PDLDefaultNotEligibleConversion(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					

				}
			}
		}

		catch (Exception e) {
			System.out.println("PDLWithPDLLoan_ManualDefault_PDL_To_ILPConversion");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "PDLWithPDLLoan_ManualDefault_PDL_To_ILPConversion_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario PDLWithPDLLoan_ManualDefault_PDL_To_ILPConversion_Txn ");

		}
	}
	
	@Test(priority = 9, enabled = true, groups = "Janaki")
	public static void JQC_PDLWithPDLLoan_ILPLoan_PDL_To_ILPConversion_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("PDLWithPDLLoan_ILPLoan_PDL_To_ILPConversion_Txn")),
					"Login -> Borrower Registratino with PDL -> New Loan with PDL -> New Loan with ILP -> PDL To ILP Loan Conversion");

			FileName = Jprop.getProperty("PDLWithPDLLoan_ILPLoan_PDL_To_ILPConversion_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPDLBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPDLCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCConversion.PDLNotEligibleConversion(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					

				}
			}
		}

		catch (Exception e) {
			System.out.println("PDLWithPDLLoan_ILPLoan_PDL_To_ILPConversion");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "PDLWithPDLLoan_ILPLoan_PDL_To_ILPConversion_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario PDLWithPDLLoan_ILPLoan_PDL_To_ILPConversion_Txn ");

		}
	}

	@Test(priority = 8, enabled = true, groups = "Janaki")
	public static void JQC_PDLWithPDLLoan_ILPLoan_ILP_To_ILPConversion_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("PDLWithPDLLoan_ILPLoan_ILP_To_ILPConversion_Txn")),
					"Login -> Borrower Registratino with PDL -> New Loan with PDL -> New Loan with ILP -> ILP To ILP Loan Conversion");

			FileName = Jprop.getProperty("PDLWithPDLLoan_ILPLoan_ILP_To_ILPConversion_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPDLBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPDLCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCConversion.ILPILPConversion(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					

				}
			}
		}

		catch (Exception e) {
			System.out.println("PDLWithPDLLoan_ILPLoan_ILP_To_ILPConversion_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "PDLWithPDLLoan_ILPLoan_ILP_To_ILPConversion_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario PDLWithPDLLoan_ILPLoan_ILP_To_ILPConversion_Txn ");

		}
	}
	
	@Test(priority = 3, enabled = true, groups = "Indhu")
	public static void QC_ILPDefaultLoan_TLPLoan_to_ILPCOnversion() throws Exception {
		try {
			test = reports.startTest("ILPDefaultLoan_TLPLoan_to_ILPCOnversion","Borrower Registration-->New Loan with TLP-->TLPtoILP conversion");

			FileName = "ILPDefaultLoan_TLPLoan_To_ILPCOnversion.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCTLPCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCConversion.ILPSignatureConversion(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			//System.out.println("TLP_To_ILPConversion");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_ILPDefaultLoan_TLPLoan_to_ILPCOnversion_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QC_ILPDefaultLoan_TLPLoan_to_ILPCOnversion_Txn ");

		}
	}
	
	@Test(priority = 2, enabled = true, groups = "Indhu")
	public static void QC_ILPLoan_TLPLoan_to_ILPCOnversion() throws Exception {
		try {
			test = reports.startTest("ILPLoan_TLPLoan_to_ILPCOnversion","Borrower Registration-->New Loan with TLP-->TLPtoILP conversion");

			FileName = "ILPLoan_TLPLoan_To_ILPConversion.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCTLPCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCConversion.ILPSignatureConversion(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			//System.out.println("TLP_To_ILPConversion");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_ILPLoan_TLPLoan_to_ILPCOnversion_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QC_ILPLoan_TLPLoan_to_ILPCOnversion_Txn ");

		}
	}
	
	@Test(priority = 5, enabled = true, groups = "Indhu") //fail
	public static void QC_ILPLoan_ILP_Conversion() throws Exception {
		try {
			test = reports.startTest("ILPLoan_ILP_Conversion","Borrower Registration-->New Loan with TLP-->TLPtoILP conversion");

			FileName = "ILPLoan_ILP_Conversion.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCConversion.ILPSignatureConversion(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			//System.out.println("TLP_To_ILPConversion");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_ILPLoan_ILP_Conversion_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QC_ILPLoan_ILP_Conversion_Txn ");

		}
	}
	
	@Test(priority = 8, enabled = true, groups = "Indhu")//fail
	public static void QC_ILPLoan_TLPLoan_TLPtoILPConversion() throws Exception {
		try {
			test = reports.startTest("ILPLoan_TLPLoan_TLPtoILPConversion","Borrower Registration-->New Loan with TLP-->TLPtoILP conversion");

			FileName = "ILPLoan_TLPLoan_TLPtoILPConversion.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCTLPCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCConversion.TLPILPConversion(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			//System.out.println("TLP_To_ILPConversion");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_ILPLoan_TLPLoan_TLPtoILPConversion_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QC_ILPLoan_TLPLoan_TLPtoILPConversion_Txn ");

		}
	}
	

	
	@Test(priority = 10, enabled = true, groups = "Indhu")
	public static void QC_TLP_ILP_Conversion() throws Exception {
		try {
			test = reports.startTest("TLP_ILP_Conversion","Borrower Registration-->New Loan with TLP-->TLPtoILP conversion");

			FileName = "TLP_ILP_Conversion.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCTLPCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCConversion.ILPConversion(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

					
				}
			}
		}

		catch (Exception e) {
			System.out.println("TLP_ILP_Conversion");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "TLP_ILP_Conversion_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario TLP_ILP_Conversion_Txn ");

		}
	}
	
	@Test(priority = 14, enabled = true, groups = "Indhu")
	public static void QC_ILPLoan_TLPLoan_ILptoTLPwithpayment_Conversion() throws Exception {
		try {
			test = reports.startTest("ILPLoan_TLPLoan_ILptoTLPwithpayment_Conversion","Borrower Registration-->New Loan with TLP-->TLPtoILP conversion");

			FileName = "ILPLoan_TLPLoan_ILptoTLPwithpayment_Conversion.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					/*JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);	
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCTLPCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);*/
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCConversion.ILPConversion(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

					
				}
			}
		}

		catch (Exception e) {
			//System.out.println("TLP_ILP_Conversion");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "ILPLoan_TLPLoan_ILptoTLPwithpayment_Conversion_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario ILPLoan_TLPLoan_ILptoTLPwithpayment_Conversion_Txn ");

		}
	}
	
	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException {

		try {

			// prop=prop.getProperty("user.dir")+"/Tests/Objects.properties";	
			BufferedReader Jreader;
			
			try {
				Jreader = new BufferedReader(
						new FileReader("C:/QC_Batch11/QC_CONVERSION/src/test/java/tests/JObjects.properties"));
				Jprop = new Properties();
				Jprop.load(Jreader);
				Jreader.close();
				String Jfilename = Jprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				csr_url = Jprop.getProperty("csr_url");
				csrloginpage = Jprop.getProperty("Login_Page");
				
				AdminURL = Jprop.getProperty("AdminURL");
				
				reports = new ExtentReports(
						System.getProperty("user.dir") + Jprop.getProperty("QC_Store_extent_report_path") + Jfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");

		}

		catch (Exception e) {

			test.log(LogStatus.ERROR, "Unable to setup for the QC Store ");

		}

	}

	@BeforeMethod(alwaysRun = true)
	public void killProcess() throws Exception {

		try {

			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

			Thread.sleep(5000); // Allow OS to kill the process
			System.out.println("killed the process");
			// break;

		} catch (Exception e) {
			// break;
			// continue;
		}
	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/QCStore/FailedTestsScreenshots/"
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

	// @AfterMethod(alwaysRun=true)

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
		// System.out.println("startign of switch case");
		// System.out.println(obj);
		/*
		 * switch(loctype) { case "id": locator=By.id(locname); break; case
		 * "name": locator=By.name(locname); break; case "linkText":
		 * locator=By.linkText(locname); break; case "xpath":
		 * locator=By.xpath(locname); case "cssSelector":
		 * locator=By.cssSelector(locname); break; }
		 */

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
