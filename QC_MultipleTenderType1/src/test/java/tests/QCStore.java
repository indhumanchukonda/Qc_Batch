package tests;

import java.io.BufferedReader;
import java.io.File;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
@Listeners(tests.TestListeners.class)
public class QCStore {

	public static WebDriverWait wait;
	public static WebDriver driver;
	public static WebDriver driver1;
	String appUrl;
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
	public static Properties prop;
	public static Properties Aprop;
	public static Properties Jprop;
	public static String loan_number;
	public static ExtentReports reports;
	public static ExtentTest test;	
	public static String Eankey = null;
	public static String encryption_store_no = null;
	public static String encryption_transaction_nbr = null;
	public static String FileName;
	public static ExcelNew TestData;
	public static String loan_nbr;
	public static String business_date;
	public static String AppURL;
	public static String AdminURL;
	public static String FirstName;
	public static String passwrd;
	public static String report_filename;
	public static String LastName;
	public static String ESign_CheckNbr;
	public static String ESign_CollateralType;
	public static int lastrow;
	public static String NextDueDate;
	

	
	// Anoop scenarios
	
	@Test(priority = 22, enabled=true, groups ="Anoop")

	public void AQC_EPP_Redeposit() throws Exception {

		FileName = "QC_EPP_Redeposit.xls";
		test = reports.startTest("QC_EPP_Redeposit", "EPP --> EPP payment ---> Deposit-->Return-->Redeposit");
		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPPayment.epppayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();

				AQCAdminLoginLogout.login(SSN, AppURL);
				AQC_EPP_Return.qcReturn(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_Redeposit.redeposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "*************Test Scenario for EPP Redeposit is pass *************");
			}
		}
	}

	@Test(priority = 21, enabled=true, groups = "Anoop")

	public void AQC_EPP_nsfPayment() throws Exception {

		FileName = "QC_EPP_nsfPayment.xls";
		test = reports.startTest("QC_EPP_nsfPayment", "EPP --> EPP payment ---> Deposit-->Return-->NsfPayment");
		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPPayment.epppayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();

				AQCAdminLoginLogout.login(SSN, AppURL);
				AQC_EPP_Return.qcReturn(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_NSFPayment.nsfpayment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				test.log(LogStatus.INFO, "*************Test Scenario for EPP Nsf Payment is pass *************");
			}
		}
	}

	@Test(priority = 20, enabled=true, groups = "Anoop")

	public void AQC_EPP_Return() throws Exception {

		FileName = "QC_EPP_Prepayment_Return.xls";
		test = reports.startTest("QC_EPP_Prepay_Return", "EPP --> EPP payment ---> Deposit--> prepayment --> Return");
		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPPayment.epppayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_Prepayment.Prepayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();

				AQCAdminLoginLogout.login(SSN, AppURL);
				AQC_EPP_Return.qcReturn(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for EPP Return is pass******");
			}
		}
	}

	@Test(priority = 19, enabled=true, groups = "Anoop")

	public void AQC_EPP_refund() throws Exception {

		FileName = "QC_EPP_Refund.xls";
		test = reports.startTest("QC_EPP_Refund", "EPP --> EPP payment ---> Deposit--> prepayment --> clear--> refund");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPPayment.epppayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_Prepayment.Prepayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AEPPClearOnly.eppClear(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPRefund.qcRefund(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for EPP refund is pass******");
			}
		}
	}

	@Test(priority = 18, enabled=true, groups = "Anoop")

	public void AQC_EPP_clear() throws Exception {

		FileName = "QC_EPP_Clear.xls";
		test = reports.startTest("QC_EPP_DepositClear", "EPP -->EPP payment-->Deposit--> clear");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPClear.eppClear(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "************Test Scenario for EPP Clear is pass**************");
			}
		}
	}

	@Test(priority = 17, enabled=true, groups = "Anoop")

	public void AQC_EPP_Prepayment() throws Exception {

		FileName = "QC_EPP_Prepayment.xls";
		test = reports.startTest("QC_EPP_Prepayment", "EPP -->EPP payment--> Deposit---> prepayment");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_Prepayment.Prepayment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for EPP Prepayment is pass******");
			}
		}
	}

	@Test(priority = 16, enabled=true, groups = "Anoop")

	public void AQC_EPPDeposit() throws Exception {

		FileName = "QC_EPPDeposit.xls";
		test = reports.startTest("QC_EPPDeposit", "Loan-EPP--> age the store upto 1st installment --> perform Deposit");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.scheduler();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				test.log(LogStatus.INFO, "****Test Scenario for EPP deposit is pass******");
			}
		}
	}
	//TLP MultiTendertype
	@Test(priority = 13, enabled=true, groups = "Anoop1")
	public void borrowregNewloan_TLP() throws Exception {
		FileName = "QC_TLP_MultiTender_Type.xls";
		test = reports.startTest("QC_TLP_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->Payment with multiple tenders");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
			
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_TLP_CSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ATLP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
						
			}
		}
	}
	//ILP MultiTendertype
	@Test(priority = 13, enabled=true, groups = "Anoop")
	public void borrowregNewloan_ILP() throws Exception {
		FileName = "ILP_QC_BorrowerRegistration_NewLoan.xls";
		test = reports.startTest("QC_ILP_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->Payment with multiple tenders");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
						
			}
		}
	}
	//PDL MultiTendertype
	@Test(priority = 13, enabled=true, groups = "Anoop")
	public void PDL_borrowregNewloan() throws Exception {
		FileName = "QC_BorrowerRegistration_NewLoan.xls";
		test = reports.startTest("QC_PDL_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->Payment with multiple tenders");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		//String RunFlag = TestData.getCellData(sheetName, "Run", 4);
		
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			//System.out.println();

			if (RunFlag.equals("Y")) {
				//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				

			
			}
		}
	}
	
	@Test(priority = 2, enabled=true, groups = "Anoop")
	public void inactiveNewloan() throws Exception {
		FileName = "QC_NewLoan_InactiveCustomer.xls";
		test = reports.startTest("QC_NewLoan_InactiveCustomer", "Login-->Home Screen-->In active customer-->New Loan");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanInactivecust.newLoanInact(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority = 6, enabled=true, groups = "Anoop")

	public void maxloanCount() throws Exception {
		FileName = "QC_MaxLoanCount_Testdata.xls";
		test = reports.startTest("QC_MaxLoanCount", "Login-->Borrower-->Max loan count");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				ACSRLoginLogout.login(SSN, AppURL);
				Thread.sleep(2000);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();

				for (int i = 1; i <= 11; i++) {

					ACSRLoginLogout.login(SSN, AppURL);
					AMaxLoanCount.maxLoan(SSN, AppURL);
					//ACSRLoginLogout.logout();
					if (!(i == 11)) {
						test.log(LogStatus.INFO, "******Customer loan Number " + i + "is approved successfully*****");
					} else {
						test.log(LogStatus.INFO, "******Customer loan Number " + i + "is denied*****");
						break;
					}
				}
			}
		}
	}

	@Test(priority = 4, enabled=true, groups = "Anoop")

	public void rescindloan() throws Exception {
		test = reports.startTest("QC_NewLoan_Rescind", "BorrowerRegistration-->New Loan->Rescind");
		FileName = "QC_BorrowerReg_NewLoan_Rescind_Txn_Testdata.xls";

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.rescind(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for  loan rescind  is pass******");

			}
		}
	}

	@Test(priority = 5, enabled=true, groups = "Anoop")

	public void agerescindtest() throws Exception {
		test = reports.startTest("QC_NewLoan_AgeStore_Rescind", "Login-->Age the loan to rescind days--->Rescind loan");
		FileName = "QC_BorrowerReg_NewLoan_AgeRescind_Txn_Testdata.xls";

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.rescind(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for age to store loan rescind  is pass******");

			}
		}
	}	
	@Test(priority = 3, enabled=true, groups = "Anoop")
	public void Achdeposit() throws Exception {
		test = reports.startTest("QC_NewLoan_Deposit", "Login-->Age the stote up to due date--->Perform deposit");
		FileName = "QC_BorrowerReg_NewLoan_AchDeposit_Txn_Testdata.xls";

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.achDeposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Ach Deposit  is pass******");
			}
		}
	}

	
	@Test(priority = 0, enabled=true, groups = "Anoop")
	public void middayDeposit() throws Exception {
		FileName = "QC_BorrowerReg_NewLoan_MidDayDeposit_Txn_Testdata.xls";
		test = reports.startTest("QC_NewLoan_MiddayDeposit",
				"Login-->Age the stote up to due date--->Perform Mid day deposit");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				/*AQCAdminLoginLogout.login(SSN, AppURL);
				AAdminStartDate.toStartdate(SSN, SSN);
				AAdminStartDate.toStartdateNV(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);
				AProc1.proc();*/
				
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRMidDayDeposit.middeposit();
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for MidDay Deposit  is pass******");
			}
		}
	}

	
	@Test(priority = 7, enabled=true, groups = "Anoop")

	public void GracedaysMiddayDeposit() throws Exception {

		FileName = "QC_AgeStoretoduedate+Gracedays_MiddayDeposit.xls";
		test = reports.startTest("QC_NewLoan_AgeStore_MiddayDeposit",
				"Login-->Age the stote up to due date+Gracedays--->Perform Mid day deposit");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();	
				ACSRLoginLogout.login(SSN, AppURL);
				ARunschedulerGracedays.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRMidDayDeposit.middeposit();
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for GraceDays MidDay Deposit  is pass******");
			}
		}
	}

	
	@Test(priority = 8, enabled=true, groups = "Anoop")

	public void GracedaysDepositMenu() throws Exception {

		FileName = "QC_AgeStoretoduedate+Gracedays_DepositMenu.xls";
		test = reports.startTest("QC_NewLoan_AgeStore_DepositMenu",
				"Login-->Age the stote up to due date+Gracedays--->Perform DepositMenu");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			
			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ARunschedulerGracedays.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_CSRDepositMenu.depositMenu(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for GraceDays DepositMenu  is pass******");
			}
		}
	}

	
	@Test(priority = 9, enabled=true, groups = "Anoop_NV")

	public void RefinanceStepup() throws Exception {

		FileName = "QC_AgeStore_payment_AgetoDuedate_RefinanceStepUp.xls";
		test = reports.startTest("QC_Refinanace StepUp",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance Stepup");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ARefinanceStepup.StepUp(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Refinance Stepup  is pass******");
			}
		}
	}

	
	@Test(priority = 10, enabled=true, groups = "Anoop_NV")

	public void RefinanceStepSame() throws Exception {

		FileName = "QC_AgeStore_payment_AgetoDuedate_RefinanceStepSame.xls";
		test = reports.startTest("QC_Refinanace StepSame",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance StepSame");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ARefinanceStepSame.StepSame(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Refinance StepSame  is pass******");
			}
		}
	}

	@Test(priority = 11, enabled=true, groups = "Anoop_NV")

	public void RefinanceStepupVoid() throws Exception {

		FileName = "QC_RefinanceStepup_void.xls";
		test = reports.startTest("QC_RefinanceStepup_void",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance Stepup-->void");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ARefinanceStepup.StepUp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Refinance Step up Void  is pass******");
			}
		}
	}

	@Test(priority = 12, enabled=true, groups = "Anoop_NV")

	public void RefinanceStepSameVoid() throws Exception {

		FileName = "QC_RefinanceStep_Same_void.xls";
		test = reports.startTest("QC_RefinanceStep_Same_void",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance StepSame void");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ARefinanceStepSame.StepSame(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Refinance Step Same void is pass******");
			}
		}
	}

	
	@Test(priority = 1, enabled=true, groups = "Anoop")
	public void futureMidayDeposit() throws Exception {
		FileName = "QC_AgeStoretoduedate_FutureDeposit_MiddayDeposit.xls";
		test = reports.startTest("QC_Future MidDay Deposit",
				"Loan-->Age the store upto duedate--> perform future deposit—->age the store uptofuture deposit date--->perform Deposit(Mid Day)");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRFutureDeposit.futureDeposit(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ARunschedulerGracedays.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRMidDayDeposit.middeposit();
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for future MidDay Deposit  is pass*****");
			}
		}
	}

	@Test(priority = 14, enabled=true, groups = "Anoop_NV")

	public void rebateStepup() throws Exception {

		FileName = "QC__RefinanceStepUp_rebate.xls";
		test = reports.startTest("QC_RefinanceStepUp_rebate",
				"Loan-Age the store--make a payment -- age the store-->do refinance(step up)(loan should be under rebate period)");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AUnderRebateAge.agerescind();
				ACSRLoginLogout.login(SSN, AppURL);
				AUnderRebateStepup.StepUp(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO,
						"****Test Scenario for Refinance Stepup loan under rebate period  is pass******");
			}
		}
	}

	@Test(priority = 15, enabled=true, groups = "Anoop_NV")

	public void rebateStepupVoid() throws Exception {

		FileName = "QC__RefinanceStepUp_rebate_Void.xls";
		test = reports.startTest("QC_RefinanceStepUp_rebate_Void",
				"Loan-Age the store--make a payment -- age the store-->do refinance(step up)(loan should be under rebate period)-->Void");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AUnderRebateAge.agerescind();
				ACSRLoginLogout.login(SSN, AppURL);
				AUnderRebateStepup.StepUp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO,
						"****Test Scenario for Refinance Stepup loan under rebate period and void is pass******");
			}
		}
	}

	
	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException {

		try {

		
		
			BufferedReader Areader;
			

			try {
				Areader = new BufferedReader(
						
						new FileReader("C:/QC_Batch11/QC_MultipleTenderType/src/test/java/tests/AObjects.properties"));
				Aprop = new Properties();
				Aprop.load(Areader);
				Areader.close();
				String Afilename = Aprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Aprop.getProperty("QC_Store_extent_report_path") + Afilename,
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

			Thread.sleep(1000); // Allow OS to kill the process
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
			test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());

			String screenshotPath =getScreenhot(driver, result.getName());
			// To add it in the extent report
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
			
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		} 
		else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " Test Case is Passed");
		}
		
		
		reports.flush();
		driver.quit();

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


	}

}