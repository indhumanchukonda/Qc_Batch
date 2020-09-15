package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
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
	public static String loan_number;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static String LOCamount;
	public static String Statementdate;
	
	public static String Due_Date1;
	public static String Due_Date2;
	public static String Due_Date3;
	public static String Duedate_confirm_text3;
	
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
	public static String bo_code;
	
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
	public static String SecondNextDueDate;
	public static String thridNextDueDate;
	public static String fourthNextDueDate;
	public static String FirstPmtDate;
	public static String customer_number;
	
	public static String lateFee;
	public static ResultSet bocode;
	
	public static float CSOFeeInt;
	public static float CouponValueInt;
	public static String Coupon_Code;
	public static String Tender_Amt;
	public static String Payment_Inst;
	public static String Payment_cso;
	public static float NSF_FeeiNT;
	public static String CSOFeeNewLoan;
	

	// Janaki scenarios

	@Test(priority = 1, enabled = true, groups = "Janaki")

	public static void JQC_ILP_Deposit_Return_OtherPayment_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_ILP_Deposit_Return_OtherPayment_Txn")),
					"Login -> Borrower_Registration ->New_Loan -> AgeStore_To_Duedate -> Deposit -> Internal_Transfer -> CmgDeposit -> Return -> Other_Payment");

			FileName = Jprop.getProperty("QC_ILP_Deposit_Return_OtherPayment_file_name") + ".xls";

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
					JQCILPBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCILPCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositDropdown.depositDropDown(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCInternalTransfer.InternalTransfer(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCmgDeposit.CmgDeposit(SSN, AppURL);					
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCAdminLoginLogout.login(SSN, AppURL);
					QCReturnCheck.qcRturn(SSN, SSN);

					JQCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCNSFHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					
				}
			}
		}

		catch (Exception e) {
			System.out.println("JQC_ILP_Deposit_Return_OtherPayment_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "JQC_ILP_Deposit_Return_OtherPayment_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario JQC_ILP_Deposit_Return_OtherPayment_Txn ");

		}
	}
	
	@Test(priority = 2, enabled = true, groups = "Janaki")

	public static void JQC_LOC_SignatureLoan_Run2Statements_WaiveFee_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_LOC_SignatureLoan_Run2Statements_WaiveFee_Txn")),
					"Login -> Borrower_Registration ->Signature_New_Loan -> AgeStore_To_Duedate -> AgeStore_To_GraceDays -> AgeStore_To_Duedate -> Waive Fee");

			FileName = Jprop.getProperty("QC_LOC_SignatureLoan_Run2Statements_WaiveFee_Txn_file_name") + ".xls";

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
					JQCLOCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);										

					JQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRSignatureLoan.signatureloan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCLOCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCLOCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCWaiveFee.waive(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCWaiveHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
									
				}
			}
		}

		catch (Exception e) {
			System.out.println("JQC_LOC_SignatureLoan_Run2Statements_WaiveFee_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "JQC_LOC_SignatureLoan_Run2Statements_WaiveFee_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario JQC_LOC_SignatureLoan_Run2Statements_WaiveFee_Txn ");

		}
	}
	
	@Test(priority = 3, enabled = true, groups = "Janaki")

	public static void JQC_LOC_SignatureLoan_Run2Statements_PartialWaiveFee_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_LOC_SignatureLoan_Run2Statements_PartialWaiveFee_Txn")),
					"Login -> Borrower_Registration ->Signature_New_Loan -> AgeStore_To_Duedate -> AgeStore_To_GraceDays -> AgeStore_To_Duedate -> Partial Waive Fee");

			FileName = Jprop.getProperty("QC_LOC_SignatureLoan_Run2Statements_PartialWaiveFee_Txn_file_name") + ".xls";

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
					JQCLOCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);										

					JQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRSignatureLoan.signatureloan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCLOCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCLOCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCWaiveFee.waive(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCWaiveHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
									
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_LOC_SignatureLoan_Run2Statements_PartialWaiveFee_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_LOC_SignatureLoan_Run2Statements_PartialWaiveFee_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QC_LOC_SignatureLoan_Run2Statements_PartialWaiveFee_Txn ");

		}
	}
//----------------
   @Test(priority = 4, enabled = true, groups = "Janaki")

	public static void JQC_LOC_SignatureLoan_Run2Statements_Default_PartialWaiveFee_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_LOC_SignatureLoan_Run2Statements_Default_PartialWaiveFee_Txn")),
					"Login -> Borrower_Registration ->Signature_New_Loan -> AgeStore_To_Duedate -> AgeStore_To_GraceDays -> AgeStore_To_Duedate -> Default -> Partial Waive Fee");

			FileName = Jprop.getProperty("QC_LOC_SignatureLoan_Run2Statements_Default_PartialWaiveFee_Txn_file_name") + ".xls";

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
					JQCLOCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);										

					JQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRSignatureLoan.signatureloan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
				//	--
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCLOCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCLOCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				//	---
					/*JQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
					//JQCCSRLoginLogout.logout(SSN, AppURL);
*/					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCWaiveFee.waive(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCWaiveHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
									
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_LOC_SignatureLoan_Run2Statements_Default_PartialWaiveFee_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_LOC_SignatureLoan_Run2Statements_Default_PartialWaiveFee_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QC_LOC_SignatureLoan_Run2Statements_Default_PartialWaiveFee_Txn ");

		}
	}
	
	@Test(priority = 5, enabled = true, groups = "Janaki")
	public static void JQC_LOC_SignatureLoan_Run2Statements_Default_WaiveFee_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_LOC_SignatureLoan_Run2Statements_Default_WaiveFee_Txn")),
					"Login -> Borrower_Registration ->Signature_New_Loan -> AgeStore_To_Duedate -> AgeStore_To_GraceDays -> AgeStore_To_Duedate -> Default -> Waive Fee");

			FileName = Jprop.getProperty("QC_LOC_SignatureLoan_Run2Statements_Default_WaiveFee_Txn_file_name") + ".xls";

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
					JQCLOCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);										

					JQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRSignatureLoan.signatureloan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCLOCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCLOCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					//manual default not required
				/*	JQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
					
					//JQCCSRLoginLogout.logout(SSN, AppURL);
*/					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCWaiveFee.waive(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCWaiveHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
									
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_LOC_SignatureLoan_Run2Statements_Default_WaiveFee_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_LOC_SignatureLoan_Run2Statements_Default_WaiveFee_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QC_LOC_SignatureLoan_Run2Statements_Default_WaiveFee_Txn ");

		}
	}
//--------------------

	@Test(priority = 6, enabled = true, groups = "Janaki")

	public static void JQC_TLP_DCDeposit_Decline_2ndDeposit_Decline_Default_Repo_Redeposit_Decline_Txn() throws Exception {
		
			test = reports.startTest("QC_TLP_DCDeposit_Decline_2ndDeposit_Decline_Default_Repo_Redeposit_Decline_Txn","Login -> Borrower_Registration -> New_Loan -> AgeStore_To_Duedate -> DCDeposit -> ");

			FileName ="QC_TLP_DCDeposit_Decline_2ndDeposit_Decline_Default_Repo_Redeposit_Decline_Txn" + ".xls";
			TestData= new ExcelNew(System.getProperty("user.dir")+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			
			//TestData= new ExcelNew(System.getProperty("user.dir")+ "/TestData/QCStore/ACCOUNTING/" + FileName);
			
			
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
					JQCTLPBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);										

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCTLPCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCTLPAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositDropdown.depositDropDown(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					DBReturn.FirstInstproc();
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRDefault.sdefault(SSN, AppURL);					
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositDropdown.depositDropDown(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					DBReturn.SecondInstproc();
													
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					Default_Status.Verify(SSN, AppURL);
													
					JQCAdminLoginLogout.login(SSN, AppURL);
					RepoReqDenied.repoProcess(SSN, AppURL);
					JQCAdminLoginLogout.logout(SSN, AppURL);
					JQCAdminLoginLogout.login(SSN, AppURL);
					RepoReqDenied.repoApprovalInbox(SSN, AppURL);
					JQCAdminLoginLogout.logout(SSN, AppURL);	

					DBReturn.Redepositproc();
				
					JQCCSRLoginLogout.login(SSN, AppURL);
					TLP_Redeposit.redeposit(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCReDepositHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
				}
			}
		}

		
	

	@Test(priority = 7, enabled = true, groups = "Janaki")

	public static void JQC_TXMPDL_Newloan_Lessthan_CSOFee_Gracedays_Payment_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_TXMPDL_Newloan_Lessthan_CSOFee_Gracedays_Payment_Txn")),
					"Login -> Borrower_Registration -> New_Loan Apply Coupon lessthan CSOFee-> AgeStore_To_GraceDays -> Instal Payment -> ");

			FileName = Jprop.getProperty("QC_TXMPDL_Newloan_Lessthan_CSOFee_Gracedays_Payment_Txn_file_name") + ".xls";

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
					QCTXBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);										
					JQCCSRLoginLogout.login(SSN, AppURL);
					QCTXCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCTXMPDLPrincipalHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
				
					
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_TXMPDL_Newloan_Lessthan_CSOFee_Gracedays_Payment_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_TXMPDL_Newloan_Lessthan_CSOFee_Gracedays_Payment_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QC_TXMPDL_Newloan_Lessthan_CSOFee_Gracedays_Payment_Txn ");

		}
	}
	
	@Test(priority = 8, enabled = true, groups = "Janaki")
	public static void JQC_TXMPDL_Newloan_Lessthan_CSOFee_Duedate_Payment_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_TXMPDL_Newloan_Lessthan_CSOFee_Duedate_Payment_Txn")),
					"Login -> Borrower_Registration -> New_Loan Apply Coupon lessthan CSOFee-> AgeStore_To_Duedate -> Instal Payment -> ");

			FileName = Jprop.getProperty("QC_TXMPDL_Newloan_Lessthan_CSOFee_Duedate_Payment_Txn_file_name") + ".xls";

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
					QCTXBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);										

					JQCCSRLoginLogout.login(SSN, AppURL);
					QCTXCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCTXMPDLPrincipalHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
				
					
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_TXMPDL_Newloan_Lessthan_CSOFee_Gracedays_Payment_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_TXMPDL_Newloan_Lessthan_CSOFee_Duedate_Payment_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QC_TXMPDL_Newloan_Lessthan_CSOFee_Duedate_Payment_Txn ");

		}
	}

	@Test(priority = 9, enabled = true, groups = "Janaki")
	public static void JQC_TXMPDL_Newloan_Greaterthan_CSOFee_Gracedays_Payment_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_TXMPDL_Newloan_Greaterthan_CSOFee_Gracedays_Payment_Txn")),
					"Login -> Borrower_Registration -> New_Loan Apply Coupon Greaterthan CSOFee-> AgeStore_To_PaymentDate-> AgeStore_To_Gracedays -> Instal Payment -> ");

			FileName = Jprop.getProperty("QC_TXMPDL_Newloan_Greaterthan_CSOFee_Gracedays_Payment_Txn_file_name") + ".xls";

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
					QCTXBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);										

					JQCCSRLoginLogout.login(SSN, AppURL);
					QCTXCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStore1stPmtDate(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCTXMPDLPrincipalHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
				
					
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_TXMPDL_Newloan_Greaterthan_CSOFee_Gracedays_Payment_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_TXMPDL_Newloan_Greaterthan_CSOFee_Gracedays_Payment_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QC_TXMPDL_Newloan_Greaterthan_CSOFee_Gracedays_Payment_Txn ");

		}
	}
	
	@Test(priority = 10, enabled = true, groups = "Janaki")
	public static void JQC_TXMPDL_Newloan_Greaterthan_CSOFee_Duedate_1stInstPayment_Gracedays_2ndInstalPayment_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_TXMPDL_Newloan_Greaterthan_CSOFee_Duedate_1stInstPayment_Gracedays_2ndInstalPayment_Txn")),
					"Login -> Borrower_Registration -> New_Loan Apply Coupon Greaterthan CSOFee-> AgeStore_To_DueDate-> 1st Instal Payment -> AgeStore_To_Gracedays -> 2nd Instal Payment -> ");

			FileName = Jprop.getProperty("QC_TXMPDL_Newloan_Greaterthan_CSOFee_Duedate_1stInstPayment_Gracedays_2ndInstalPayment_Txn_file_name") + ".xls";

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
					QCTXBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);										

					JQCCSRLoginLogout.login(SSN, AppURL);
					QCTXCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCTXMPDLPrincipalHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);			
					
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_TXMPDL_Newloan_Greaterthan_CSOFee_Duedate_1stInstPayment_Gracedays_2ndInstalPayment_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_TXMPDL_Newloan_Greaterthan_CSOFee_Duedate_1stInstPayment_Gracedays_2ndInstalPayment_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QC_TXMPDL_Newloan_Greaterthan_CSOFee_Duedate_1stInstPayment_Gracedays_2ndInstalPayment_Txn ");

		}
	}

	@Test(priority = 11, enabled = true, groups = "Janaki")
	public static void JQC_TXMPDLACH_Newloan_Deposit2_5instand6_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_TXMPDL(ACH)_Newloan_Deposit2_5instand6_Txn")),
					"Login -> Borrower_Registration -> New_Loan With 1000 Loan Amount(26th Mar 2019 and Due date 20th Apr)-> AgeStore_To_DueDate-> 1st Instal Payment -> AgeStore_To_Gracedays -> 2nd Instal Payment -> ");

			FileName = Jprop.getProperty("QC_TXMPDL(ACH)_Newloan_Deposit2_5instand6_Txn_file_name") + ".xls";

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
					QCTXBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);										

					JQCCSRLoginLogout.login(SSN, AppURL);
					QCTXCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.paymentTwice(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositDropdown.depositDropDown(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCTXMPDLHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);		
					
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_TXMPDLACH_Newloan_Deposit2_5instand6_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_TXMPDLACH_Newloan_Deposit2_5instand6_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QC_TXMPDLACH_Newloan_Deposit2_5instand6_Txn ");

		}
	}
	
	@Test(priority = 12, enabled = true, groups = "Janaki")
	public static void JQC_TXMPDLDC_Newloan_Deposit2_5instand6_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_TXMPDL(DC)_Newloan_Deposit2_5instand6_Txn")),
					"Login -> Borrower_Registration -> New_Loan With 1000 Loan Amount(26th Mar 2019 and Due date 20th Apr)-> AgeStore_To_DueDate-> 1st Instal Payment -> AgeStore_To_Gracedays -> 2nd Instal Payment -> ");

			FileName = Jprop.getProperty("QC_TXMPDL(DC)_Newloan_Deposit2_5instand6_Txn_file_name") + ".xls";
			//FileName ="QC_TXMPDL(DC)_Newloan_Deposit2_5instand6_Txn.xls";
			
			
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
					QCTXBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);										

					JQCCSRLoginLogout.login(SSN, AppURL);
					QCTXCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.paymentTwice(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositDropdown.depositDropDown(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCTXMPDLHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);		
					
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_TXMPDLDC_Newloan_Deposit2_5instand6_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_TXMPDLDC_Newloan_Deposit2_5instand6_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QC_TXMPDLDC_Newloan_Deposit2_5instand6_Txn");

		}
	}
		
	@Test(priority = 13, enabled = true, groups = "Janaki")
	public static void JQC_ILP_Newloan_Deposit_Return_Deposit_Txn() throws Exception {
			try {
				test = reports.startTest((Jprop.getProperty("QC_ILP_Deposit_Return_Payment_Deposit_Txn")),
						"Login -> Borrower_Registration -> New_Loan With 200 Loan Amount(15th July 2019 and Due date 4th Aug)-> AgeStore_To_DueDate-> 1st Inst Deposit --> Return --> AgeStore_To_GraceDays-> Payment(on 18th Aug 2019) ->AgeStore_To_DueDate(1st sep 2019)-> 3rd Inst Deposit ");

				FileName = Jprop.getProperty("QC_ILP_Deposit_Return_Payment_Deposit_Txn_file_name") + ".xls";

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
						JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCDepositDropdown.depositDropDown(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCInternalTransfer.InternalTransfer(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCmgDeposit.CmgDeposit(SSN, AppURL);					
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCAdminLoginLogout.login(SSN, AppURL);
						QCReturnCheck.qcRturn(SSN, SSN);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						QCPayment.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStore3rdDueDate(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCDepositDropdown.depositDropDown(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCPaymentNSFDepositHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
							
						
					}
				}
			}

			catch (Exception e) {
				System.out.println("QC_ILP_Newloan_Deposit_Return_Deposit_Txn");
				// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
				// start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_ILP_Newloan_Deposit_Return_Deposit_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QC_ILP_Newloan_Deposit_Return_Deposit_Txn");

			}
		}
	
	//-----------------
	@Test(priority = 14, enabled = true, groups = "Janaki")
	public static void JQC_ILP_Newloan_Deposit_Return_Deposit_Deposit_Txn() throws Exception {
			try {
				test = reports.startTest((Jprop.getProperty("QC_ILP_Deposit_Return_Payment_Deposit_Deposit_Txn")),
						"Login -> Borrower_Registration -> New_Loan With 200 Loan Amount(15th July 2019 and Due date 4th Aug)-> AgeStore_To_DueDate-> 1st Inst Deposit --> Return --> AgeStore_To_GraceDays-> Payment(on 18th Aug 2019) ->AgeStore_To_DueDate(1st sep 2019)-> 3rd Inst Deposit ");

				FileName = Jprop.getProperty("QC_ILP_Deposit_Return_Payment_Deposit_Deposit_Txn") + ".xls";

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
						JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCDepositDropdown.depositDropDown(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCInternalTransfer.InternalTransfer(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCmgDeposit.CmgDeposit(SSN, AppURL);					
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCAdminLoginLogout.login(SSN, AppURL);
						QCReturnCheck.qcRturn(SSN, SSN);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						QCPayment.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStore3rdDueDate(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCDepositDropdown.depositDropDown(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStore4thDueDate(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCDepositDropdown.depositDropDown(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCPaymentNSFDepositHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
							
						
					}
				}
			}

			catch (Exception e) {
				System.out.println("QC_ILP_Deposit_Return_Payment_Deposit_Deposit_Txn");
				// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
				// start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_ILP_Deposit_Return_Payment_Deposit_Deposit_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QC_ILP_Deposit_Return_Payment_Deposit_Deposit_Txn");

			}
		}
	
	@Test(priority = 15, enabled = true, groups = "Janaki")
	public static void JQC_ILP_Newloan_ThreeDeposit_ThreeReturn_Default_NoCashOutRefinance_Txn() throws Exception {
			try {
				test = reports.startTest((Jprop.getProperty("QC_ILP_ThreeDeposit_ThreeReturn_Default_Refinance(NO)_Txn")),
						"Login -> Borrower_Registration -> New_Loan -> AgeStore_To_DueDate-> 1st Inst Deposit --> Return --> AgeStore_To_DueDate-> 2nd Inst Deposit --> Return --> AgeStore_To_DueDate-> 3rd Inst Deposit --> Return -->AgeStore to GraceDays(Default--> Legal and Garnishment --> Refinance(CashOut-NO)");

				FileName = Jprop.getProperty("QC_ILP_ThreeDeposit_ThreeReturn_Default_Refinance(NO)_Txn") + ".xls";

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
						
						//1st Deposit and Return
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCDepositDropdown.depositDropDown(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCInternalTransfer.InternalTransfer(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCmgDeposit.CmgDeposit(SSN, AppURL);					
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCAdminLoginLogout.login(SSN, AppURL);
						QCReturnCheck.qcRturn(SSN, SSN);
						
						//2nd Deposit and Return
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStore2ndDueDate(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCDepositDropdown.depositDropDown(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCInternalTransfer.InternalTransfer(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCmgDeposit.CmgDeposit(SSN, AppURL);					
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCAdminLoginLogout.login(SSN, AppURL);
						QCReturnCheck.qcRturn(SSN, SSN);
						
						//3rd Deposit and Return
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStore3rdDueDate(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCDepositDropdown.depositDropDown(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCInternalTransfer.InternalTransfer(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCmgDeposit.CmgDeposit(SSN, AppURL);					
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCAdminLoginLogout.login(SSN, AppURL);
						QCReturnCheck.qcRturn(SSN, SSN);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						Default_Status.Verify(SSN, AppURL);
						//JQCCSRLoginLogout.logout(SSN, AppURL);
						
						
						JQCAdminLoginLogout.login(SSN, AppURL);
						LegalGarnishment.lAndG(SSN, AppURL);
						//JQCAdminLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRDefaultPayment.sdefaultpayment(SSN, AppURL);
						//JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						RQCMonthlyRefinance.StepUp_CashOut_No(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCRefinanceLoanValidationHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
							
						
					}
				}
			}

			catch (Exception e) {
				System.out.println("QC_ILP_Newloan_Deposit_Return_Deposit_Txn");
				// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
				// start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_ILP_ThreeDeposit_ThreeReturn_Default_Refinance(NO)_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QC_ILP_ThreeDeposit_ThreeReturn_Default_Refinance(NO)_Txn");

			}
		}
	
	@Test(priority = 16, enabled = true, groups = "Janaki")
	public static void JQC_ILP_Newloan_ThreeDeposit_ThreeReturn_Default_YesCashOutRefinance_Txn() throws Exception {
			try {
				test = reports.startTest((Jprop.getProperty("QC_ILP_ThreeDeposit_ThreeReturn_Default_Refinance(Yes)_Txn")),
						"Login -> Borrower_Registration -> New_Loan -> AgeStore_To_DueDate-> 1st Inst Deposit --> Return --> AgeStore_To_DueDate-> 2nd Inst Deposit --> Return --> AgeStore_To_DueDate-> 3rd Inst Deposit --> Return -->AgeStore to GraceDays(Default--> Legal and Garnishment --> Refinance(CashOut-Yes)");

				FileName = Jprop.getProperty("QC_ILP_ThreeDeposit_ThreeReturn_Default_Refinance(Yes)_Txn") + ".xls";

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
						
						//1st Deposit and Return
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCDepositDropdown.depositDropDown(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCInternalTransfer.InternalTransfer(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCmgDeposit.CmgDeposit(SSN, AppURL);					
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCAdminLoginLogout.login(SSN, AppURL);
						QCReturnCheck.qcRturn(SSN, SSN);
						
						//2nd Deposit and Return
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStore2ndDueDate(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCDepositDropdown.depositDropDown(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCInternalTransfer.InternalTransfer(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCmgDeposit.CmgDeposit(SSN, AppURL);					
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCAdminLoginLogout.login(SSN, AppURL);
						QCReturnCheck.qcRturn(SSN, SSN);
						
						//3rd Deposit and Return
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStore3rdDueDate(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCDepositDropdown.depositDropDown(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCInternalTransfer.InternalTransfer(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCmgDeposit.CmgDeposit(SSN, AppURL);					
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCAdminLoginLogout.login(SSN, AppURL);
						QCReturnCheck.qcRturn(SSN, SSN);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						Default_Status.Verify(SSN, AppURL);
						//JQCCSRLoginLogout.logout(SSN, AppURL);
						
						
						JQCAdminLoginLogout.login(SSN, AppURL);
						LegalGarnishment.lAndG(SSN, AppURL);
						//JQCAdminLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRDefaultPayment.sdefaultpayment(SSN, AppURL);
						//JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						RQCMonthlyRefinance.StepUp_CashOut_Yes(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCRefinanceLoanValidationHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
							
						
					}
				}
			}

			catch (Exception e) {
				System.out.println("QC_ILP_Newloan_Deposit_Return_Deposit_Txn");
				// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
				// start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_ILP_ThreeDeposit_ThreeReturn_Default_Refinance(Yes)_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QC_ILP_ThreeDeposit_ThreeReturn_Default_Refinance(Yes)_Txn");

			}
		}
	
	//@Test(priority = 17, enabled = true, groups = "Janaki")
		public static void JQC__Newloan_ThreeDeposit_ThreeReturn_Default_YesCashOutRefinance_Txn() throws Exception {
				try {
					test = reports.startTest((Jprop.getProperty("QC_ILP_ThreeDeposit_ThreeReturn_Default_Refinance(Yes)_Txn")),
							"Login -> Borrower_Registration -> New_Loan -> AgeStore_To_DueDate-> 1st Inst Deposit --> Return --> AgeStore_To_DueDate-> 2nd Inst Deposit --> Return --> AgeStore_To_DueDate-> 3rd Inst Deposit --> Return -->AgeStore to GraceDays(Default--> Legal and Garnishment --> Refinance(CashOut-Yes)");

					FileName = Jprop.getProperty("QC_ILP_ThreeDeposit_ThreeReturn_Default_Refinance(Yes)_Txn") + ".xls";

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
														
							
						}
					}
				}

				catch (Exception e) {
					System.out.println("QC_ILP_Newloan_Deposit_Return_Deposit_Txn");
					// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
					// start scenario 1 " , ExtentColor.RED));
					String screenshotPath = getScreenhot(driver, "QC_ILP_ThreeDeposit_ThreeReturn_Default_Refinance(Yes)_Txn");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QC_ILP_ThreeDeposit_ThreeReturn_Default_Refinance(Yes)_Txn");

				}
			}

	
	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException {

		try {

			BufferedReader reader;
			BufferedReader Jreader;
			BufferedReader Rreader;
			BufferedReader Areader;
			BufferedReader Vreader;

			try {
				reader = new BufferedReader(

						new FileReader("C:/QC_Batch/QC_Accouting_Scenarios/src/test/java/tests/Objects.properties"));

				prop = new Properties();
				prop.load(reader);
				reader.close();
				String AppURL = prop.getProperty("CSR_URL");
				//BAdminURL = prop.getProperty("ADMIN_CSR_URL");
				String Bfilename = prop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") + Bfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			try {
				Jreader = new BufferedReader(

						new FileReader("C:/QC_Batch11/QC_Accouting_Scenarios/src/test/java/tests/JObjects.properties"));

				Jprop = new Properties();
				Jprop.load(Jreader);
				Jreader.close();
				csr_url = Jprop.getProperty("csr_url");
				csrloginpage = Jprop.getProperty("Login_Page");
				AdminURL = Jprop.getProperty("AdminURL");
				String Jfilename = Jprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Jprop.getProperty("QC_Store_extent_report_path") + Jfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			try {
				Rreader = new BufferedReader(

						new FileReader("C:/QC_Batch/QC_Accouting_Scenarios/src/test/java/tests/RObjects.properties"));

				Rprop = new Properties();
				Rprop.load(Rreader);
				Rreader.close();
				csr_url = Rprop.getProperty("CSR_URL");
				csrloginpage = Rprop.getProperty("Login_Page");
				AdminURL = Rprop.getProperty("ADMIN_CSR_URL");
				String Rfilename = Rprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Rprop.getProperty("QC_Store_extent_report_path") + Rfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			try {
				Areader = new BufferedReader(
						new FileReader("C:/QC_Batch/QC_Accouting_Scenarios/src/test/java/tests/AObjects.properties"));
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
			try {
				Vreader = new BufferedReader(
						new FileReader("C:/QC_Batch/QC_Accouting_Scenarios/src/test/java/tests/VObjects.properties"));
				Vprop = new Properties();
				Vprop.load(Vreader);
				Vreader.close();
				//csr_url = Vprop.getProperty("CSR_URL");
				//csrloginpage = Vprop.getProperty("Login_Page");
				//AdminURL = Vprop.getProperty("ADMIN_URL");
				String Vfilename = Vprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Vprop.getProperty("QC_Store_extent_report_path") + Vfilename,
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
