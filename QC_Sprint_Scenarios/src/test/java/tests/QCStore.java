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
	public static Properties Sprop;
	public static Properties Vprop;
	public static String loan_number;
	public static String Loan_number;
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
	public static String NextDueDate;
	public static String AppURL;
	public static String App_URL;
	public static String BAdminURL;
	public static String AdminURL;
	public static String business_date;
	public static String No_of_Installments;
	public static String FirstName;
	public static String passwrd;
	public static String report_filename;
	public static String LastName;
	public static String ESign_CheckNbr;

	public static String ESign_CollateralType;

	public static String Due_Date1;
	public static String Due_Date2;
	public static String Due_Date3;

	public static String Str_date;
	public static String Ctc_PrimaryPhone;
	public static String Storeid;
	public static String SSN;
	public static String PP1;
	public static String PP2;
	public static String PP3;
	public static String age_Date1;
	public static String age_Date2;
	public static String age_Date3;
	public static String Statementdate;
	public static String Duedate_confirm_text3;
	

	//public static String customer_number;

	public static String Drawer_OverShort_Amount; 

	public static String Date1;

	public static String csr_url;

	public static String csrloginpage;

	public static String Date2;
	public static String Date3;

	public static String Password;

	public static String LOCamount;

	private static final String QCAdmin_Deceased = null;
	private static final QCCSRHistory VQC_LOC_History = null;

	public static String Bank_Status;

	public static String App_date1;

	public static String logout;

	private static Object rescind;
	public static String customer_number;

	/*public static String bstoreid="505";
	public static String busername="csr505";*/
	
	public static String bstoreid="1252";
	public static String busername="csr1252";
	
	public static String vstoreid="508";
	public static String vusername="csr508";
	
	public static String nstoreid="581";
	public static String nusername="csr581";

	public static int transaction_list;
	


	//================= QF-342 Sprint scenarios ==========================


	@Test(priority = 1, groups = { "QF-342" })

	public static void QF_342_TS001() throws Exception {
		
		try {
			test = reports.startTest("QF_342_TS001","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
			FileName = "QF-342-TS001.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					CSRBorrower.Borrower_Edit(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					}
				}
			}
		catch (Exception e) {
			
			String screenshotPath = getScreenhot(driver, "QF_342_TS001");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS001");

		}
	}

	
	
	@Test(priority = 3, groups = { "QF-342" })

	public static void QF_342_TS007() throws Exception {
		
		try {
			test = reports.startTest("QF_342_TS007","Borrower Registration-->Click on Borrower-->Click on Edit SSN-->Enter Customer number-->Click on Submit-->Click on GO Button");
			FileName = "QF-342-TS007.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					CSRBorrower.Borrower_EditSSN(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					}
				}
			}
	catch (Exception e) {
		
		String screenshotPath = getScreenhot(driver, "QF_342_TS007");
		test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

		test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS007");

	}
}
	
	@Test(priority = 7, groups = { "QF-342" })
	
	public static void QF_342_TS003() throws Exception {
		
		try {
		test = reports.startTest("QF_342_TS003","Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit-->Click on GO Button");
		FileName = "QF-342-TS007.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {

				// AppURL = TestData.getCellData(sheetName, "AppURL", row);
				SSN = TestData.getCellData(sheetName, "SSN", row);
				System.out.println(AppURL);
				
				QCCSRLoginLogout.login(SSN, AppURL);
				CSRBorrower.Borrower_Edit(SSN, SSN);
				QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}
	catch (Exception e) {
		
		String screenshotPath = getScreenhot(driver, "QF_342_TS003");
		test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

		test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS003");

	}
}
	
	@Test(priority = 5, groups = { "QF-342" })
	
	public static void QF_342_TS005() throws Exception {
			
		try {
			test = reports.startTest("QF_342_TS005","Borrower Registration with AlienCard-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit-->Click on GO Button");
			FileName = "QF-342-TS005.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					CSRBorrower.Borrower_Edit(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					}
				}
			}
	catch (Exception e) {
		
		String screenshotPath = getScreenhot(driver, "QF_342_TS005");
		test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

		test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS005");

	}
}

	@Test(priority = 6, groups = { "QF-342" })
		
	public static void QF_342_TS006() throws Exception {
		try {

				test = reports.startTest("QF_342_TS006","Borrower Registration with AlienCard-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit-->Click on GO Button");
				FileName = "QF-342-TS006.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					// System.out.println(RunFlag);
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						CSRBorrower.Borrower_Edit(SSN, SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);
						}
					}
				}
	catch (Exception e) {
		
		String screenshotPath = getScreenhot(driver, "QF_342_TS006");
		test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

		test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS006");

	}
}

	@Test(priority = 9, groups = { "QF-342" })
			
	public static void QF_342_TS009() throws Exception {
				
		try {
				test = reports.startTest("QF_342_TS009","Click on Borrower-->Click on Edit SSN-->Enter Customer number-->Click on Submit-->Click on GO Button");
				FileName = "QF-342-TS001.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					// System.out.println(RunFlag);
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						CSRBorrower.Borrower_EditSSN(SSN, SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);
						}
					}
				}
	catch (Exception e) {
		
		String screenshotPath = getScreenhot(driver, "QF_342_TS009");
		test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

		test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS009");

	}
}

	@Test(priority = 11, groups = { "QF-342" })
	
	public static void QF_342_TS011() throws Exception {
			try {

					test = reports.startTest("QF_342_TS011","Borrower Registration -->Login to PAM -->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit-->Click on GO Button");
					FileName = "QF-342-TS011.xls";

					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					String sheetName = "Start";
					int lastrow = TestData.getLastRow("Start");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							// AppURL = TestData.getCellData(sheetName, "AppURL", row);
							SSN = TestData.getCellData(sheetName, "SSN", row);
							System.out.println(AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.central_login(SSN, AppURL);							
							CSRBorrower.Borrower_Edit(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							}
						}
					}
catch (Exception e) {
			
			String screenshotPath = getScreenhot(driver, "QF_342_TS011");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS011");

		}
	}
		
	@Test(priority = 13, groups = { "QF-342" })
		
	public static void QF_342_TS013() throws Exception {
					
			try {
					test = reports.startTest("QF_342_TS013","Login to PAM-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit-->Click on GO Button");
					FileName = "QF-342-TS011.xls";

					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					String sheetName = "Start";
					int lastrow = TestData.getLastRow("Start");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							// AppURL = TestData.getCellData(sheetName, "AppURL", row);
							SSN = TestData.getCellData(sheetName, "SSN", row);
							System.out.println(AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							
							QCCSRLoginLogout.central_login(SSN, AppURL);						
							CSRBorrower.Borrower_Edit(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							}
						}
					}
catch (Exception e) {
			
			String screenshotPath = getScreenhot(driver, "QF_342_TS013");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS013");

		}
	}
	
     @Test(priority = 16, groups = { "QF-342" })
		
	public static void QF_342_TS016() throws Exception {
					
			try {
					test = reports.startTest("QF_342_TS016","Borrower Registration--> Login to admin-->click on transactions --> click on borrower--> Click on edit SSN-->Enter Customer number-->Click on Submit-->Click on GO Button");
					FileName = "QF-342-TS016.xls";

					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					String sheetName = "Start";
					int lastrow = TestData.getLastRow("Start");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							// AppURL = TestData.getCellData(sheetName, "AppURL", row);
							SSN = TestData.getCellData(sheetName, "SSN", row);
							System.out.println(AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							CSRBorrower.admin_EditSSN(SSN, AppURL);
							QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
							
							
							}
						}
					}
catch (Exception e) {
			
			String screenshotPath = getScreenhot(driver, "QF_342_TS016");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS016");

		}
	}

    @Test(priority = 17, groups = { "QF-342" })
		
	public static void QF_342_TS017() throws Exception {
					
			try {
					test = reports.startTest("QF_342_TS017","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit-->Click on SSN/ITIN Hyper Link");
					FileName = "QF-342-TS017.xls";

					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					String sheetName = "Start";
					int lastrow = TestData.getLastRow("Start");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							// AppURL = TestData.getCellData(sheetName, "AppURL", row);
							SSN = TestData.getCellData(sheetName, "SSN", row);
							System.out.println(AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							CSRBorrower.Edit_SSN_HyperLink(SSN, AppURL);
							//QCCSRLoginLogout.logout(SSN, AppURL);
							
							}
						}
					}
catch (Exception e) {
			
			String screenshotPath = getScreenhot(driver, "QF_342_TS017");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS017");

		}
	}
	
     @Test(priority = 19, groups = { "QF-342" })
		
	public static void QF_342_TS019() throws Exception {
					
			try {
					test = reports.startTest("QF_342_TS019","Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit-->Click on SSN/ITIN Hyper Link");
					FileName = "QF-342-TS017.xls";

					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					String sheetName = "Start";
					int lastrow = TestData.getLastRow("Start");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							// AppURL = TestData.getCellData(sheetName, "AppURL", row);
							SSN = TestData.getCellData(sheetName, "SSN", row);
							System.out.println(AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							CSRBorrower.Edit_SSN_HyperLink(SSN, AppURL);
							//QCCSRLoginLogout.logout(SSN, AppURL);
							
							}
						}
					}
catch (Exception e) {
			
			String screenshotPath = getScreenhot(driver, "QF_342_TS019");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS019");

		}
	}
		
	@Test(priority = 21, groups = { "QF-342" })
			
	public static void QF_342_TS021() throws Exception {
						
				try {
						test = reports.startTest("QF_342_TS021","Borrower Registration-->Click on Borrower-->Click on Edit SSN-->Enter Customer number-->Click on Submit-->Click on SSN/ITIN Hyper Link");
						FileName = "QF-342-TS021.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								// AppURL = TestData.getCellData(sheetName, "AppURL", row);
								SSN = TestData.getCellData(sheetName, "SSN", row);
								System.out.println(AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
								CSRBorrower.Edit_SSN_HyperLink(SSN, AppURL);
								//QCCSRLoginLogout.logout(SSN, AppURL);
								
								}
							}
						}
			catch (Exception e) {
				
				String screenshotPath = getScreenhot(driver, "QF_342_TS021");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS021");

			}
		}
		
	@Test(priority = 23, groups = { "QF-342" })
		
	public static void QF_342_TS023() throws Exception {
					
			try {
					test = reports.startTest("QF_342_TS023","Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit-->Click on SSN/ITIN Hyper Link");
					FileName = "QF-342-TS021.xls";

					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					String sheetName = "Start";
					int lastrow = TestData.getLastRow("Start");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							// AppURL = TestData.getCellData(sheetName, "AppURL", row);
							SSN = TestData.getCellData(sheetName, "SSN", row);
							System.out.println(AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							CSRBorrower.EditSSN_SSN_HyperLink(SSN, AppURL);
							//QCCSRLoginLogout.logout(SSN, AppURL);
							
							}
						}
					}
catch (Exception e) {
			
			String screenshotPath = getScreenhot(driver, "QF_342_TS023");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS023");

		}
	}
		
	@Test(priority = 25, groups = { "QF-342" })
		
	public static void QF_342_TS025() throws Exception {
							
			try {
							test = reports.startTest("QF_342_TS025","Borrower Registration-->Click on Loan Transactions-->Click on transactions-->Enter customer number-->click on submit-->Click on SSN/ITIN Hyper Link");
							FileName = "QF-342-TS025.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									// AppURL = TestData.getCellData(sheetName, "AppURL", row);
									SSN = TestData.getCellData(sheetName, "SSN", row);
									System.out.println(AppURL);
									QCCSRLoginLogout.login(SSN, AppURL);
									QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
									QCCSRLoginLogout.logout(SSN, AppURL);
									QCCSRLoginLogout.login(SSN, AppURL);
									CSRBorrower.LoanTransactions_ssn_hyperLink(SSN, AppURL);
								//QCCSRLoginLogout.logout(SSN, AppURL);
									
									}
								}
							}
catch (Exception e) {
			
			String screenshotPath = getScreenhot(driver, "QF_342_TS025");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS025");

		}
	}
	
	@Test(priority = 27, groups = { "QF-342" })
		
	public static void QF_342_TS027() throws Exception {
									
				try {
			test = reports.startTest("QF_342_TS027","Click on Loan Transactions-->Click on transactions-->Enter customer number-->click on submit-->Click on SSN/ITIN Hyper Link");
			FileName = "QF-342-TS025.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
			+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
										// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

											// AppURL = TestData.getCellData(sheetName, "AppURL", row);
				SSN = TestData.getCellData(sheetName, "SSN", row);
				System.out.println(AppURL);
											
				QCCSRLoginLogout.login(SSN, AppURL);
				CSRBorrower.LoanTransactions_ssn_hyperLink(SSN, AppURL);
				//QCCSRLoginLogout.logout(SSN, AppURL);
											
	}
				}
			}
			catch (Exception e) {
				
				String screenshotPath = getScreenhot(driver, "QF_342_TS027");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS027");

			}
		}
			
	@Test(priority = 29, groups = { "QF-342" })
			
	public static void QF_342_TS029() throws Exception {
									
				try {
			test = reports.startTest("QF_342_TS029","Borrower Registration--> Loginin to CSR-->click on borrower-->click on Courtesy calls->select product type:all->submit-->click on GO-->Click on SSN/ITIN Hyper link");
			FileName = "QF-342-TS029.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
			+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
										// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

											// AppURL = TestData.getCellData(sheetName, "AppURL", row);
				 SSN = TestData.getCellData(sheetName, "SSN", row);
				System.out.println(AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, SSN);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
				QCCSRLoginLogout.login(SSN, AppURL);
				CSRBorrower.Courtesycalls_SSN_Hyperlink(SSN, AppURL);
				//QCCSRLoginLogout.logout(SSN, AppURL);
											
	}
				}
			}
			catch (Exception e) {
				
				String screenshotPath = getScreenhot(driver, "QF_342_TS029");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS029");

			}
		}
		
    @Test(priority = 30, groups = { "QF-342" })
			
	public static void QF_342_TS030() throws Exception {
				try {				

			test = reports.startTest("QF_342_TS030","Borrower Registration--> Loginin to CSR-->click on borrower-->click on Collections->select product type:all->submit-->click on GO-->Click on SSN/ITIN Hyper link");
			FileName = "QF-342-TS030.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
			+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
										// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

											// AppURL = TestData.getCellData(sheetName, "AppURL", row);
				SSN = TestData.getCellData(sheetName, "SSN", row);
				System.out.println(AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, SSN);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
				QCCSRLoginLogout.login(SSN, AppURL);
				CSRBorrower.manualdefault(SSN, AppURL);
				//QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				CSRBorrower.Collection_SSN_Hyperlink(SSN, AppURL);
				//QCCSRLoginLogout.logout(SSN, AppURL);
											
	}
				}
			}
			catch (Exception e) {
				
				String screenshotPath = getScreenhot(driver, "QF_342_TS030");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS030");

			}
		}
		
     @Test(priority = 31, groups = { "QF-342" })
			
	public static void QF_342_TS031() throws Exception {
									
				try {
			test = reports.startTest("QF_342_TS031","Loginin to PAM-->click on borrower-->click on Courtesy calls->select product type:all->submit-->click on GO-->Click on SSN/ITIN Hyper link");
			FileName = "QF-342-TS031.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
			+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
										// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);
					
					QCCSRLoginLogout.central_login(SSN, AppURL);	
					Central_CourtesyCalls.Central_Courtesycalls_SSN_Hyperlink(SSN, AppURL);
					//QCCSRLoginLogout.logout(SSN, AppURL);
											
	}
				}
			}
			catch (Exception e) {
				
				String screenshotPath = getScreenhot(driver, "QF_342_TS031");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS031");

			}
		}
 
	@Test(priority = 32, groups = { "QF-342" })
			
	public static void QF_342_TS032() throws Exception {
									
				try {
			test = reports.startTest("QF_342_TS032","Loginin to PAM-->click on borrower-->click on Collections->select product type:all->submit-->click on GO-->Click on SSN/ITIN Hyper link");
			FileName = "QF-342-TS031.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
			+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
										// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);
					
					QCCSRLoginLogout.central_login(SSN, AppURL);	
					Central_Collections.Central_Collections_SSN_Hyperlink(SSN, AppURL);
					//QCCSRLoginLogout.logout(SSN, AppURL);
											
	}
				}
			}
			catch (Exception e) {
				
				String screenshotPath = getScreenhot(driver, "QF_342_TS032");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS032");

			}
		}
		
  @Test(priority = 41, groups = { "QF-342" })
			
	public static void QF_342_TS041() throws Exception {
									
				try {
			test = reports.startTest("QF_342_TS041","Loginin to CSR-->click on borrower-->click on Courtesy calls->select product type:all->submit-->click on GO-->Click on SSN/ITIN Hyper link-->click on eyeball icon");
			FileName = "QF-342-TS041.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
			+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
										// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
				
					SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					CSRBorrower.Courtesycalls_SSN_Hyperlink(SSN, AppURL);
					//QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.central_login(SSN, AppURL);	
					Central_CourtesyCalls.Central_Courtesycalls_SSN_Hyperlink(SSN, AppURL);
					//QCCSRLoginLogout.logout(SSN, AppURL);
											
	}
				}
			}
			catch (Exception e) {
				
				String screenshotPath = getScreenhot(driver, "QF_342_TS041");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS041");

			}
		}
		
    @Test(priority = 42, groups = { "QF-342" })
			
	public static void QF_342_TS042() throws Exception {
									
				try {
			test = reports.startTest("QF_342_TS042","Loginin to CSR-->click on borrower-->click on Collections->select product type:all->submit-->click on GO-->Click on SSN/ITIN Hyper link-->click on eyeball icon");
			FileName = "QF-342-TS042.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
			+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
										// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
				
					SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					CSRBorrower.manualdefault(SSN, AppURL);
					//QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					CSRBorrower.Collection_SSN_Hyperlink(SSN, AppURL);
					//QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.central_login(SSN, AppURL);	
					Central_Collections.Central_Collections_SSN_Hyperlink(SSN, AppURL);
					//QCCSRLoginLogout.logout(SSN, AppURL);
	}
				}
			}
			catch (Exception e) {
				
				String screenshotPath = getScreenhot(driver, "QF_342_TS042");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS042");

			}
		}
			
	@Test(priority = 43, groups = { "QF-342" })

	public static void QF_342_TS043() throws Exception {
				
				try {
					test = reports.startTest("QF_342_TS0043","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
					FileName = "QF-342-TS043.xls";

					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					String sheetName = "Start";
					int lastrow = TestData.getLastRow("Start");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							// AppURL = TestData.getCellData(sheetName, "AppURL", row);
							SSN = TestData.getCellData(sheetName, "SSN", row);
							System.out.println(AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							CSRBorrower.Borrower_Edit_Saveexit_savenext(SSN, AppURL);
							//QCCSRLoginLogout.logout(SSN, AppURL);
							}
						}
					}
			catch (Exception e) {
				
				String screenshotPath = getScreenhot(driver, "QF_342_TS043");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS043");

			}
		}
			
	@Test(priority = 46, groups = { "QF-342" })

	public static void QF_342_TS0046() throws Exception {
				
				try {
					test = reports.startTest("QF_342_TS046","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
					FileName = "QF-342-TS046.xls";

					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					String sheetName = "Start";
					int lastrow = TestData.getLastRow("Start");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							// AppURL = TestData.getCellData(sheetName, "AppURL", row);
							SSN = TestData.getCellData(sheetName, "SSN", row);
							System.out.println(AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							CSRBorrower.Borrower_Edit(SSN, SSN);
							QCCSRLoginLogout.logout(SSN, AppURL);
							}
						}
					}
			catch (Exception e) {
				
				String screenshotPath = getScreenhot(driver, "QF_342_TS046");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS046");

			}
		}
			
	////@Test(priority = 47, groups = { "QF-342" })

	public static void QF_342_TS0047() throws Exception {
						try {

							test = reports.startTest("QF_342_TS047","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit-->Click on SSN/ITIN Link");
							FileName = "QF-342-TS047.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									// AppURL = TestData.getCellData(sheetName, "AppURL", row);
									SSN = TestData.getCellData(sheetName, "SSN", row);
									System.out.println(AppURL);
									QCCSRLoginLogout.login(SSN, AppURL);
									QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
									QCCSRLoginLogout.logout(SSN, AppURL);
									QCCSRLoginLogout.login(SSN, AppURL);
									CSRBorrower.LoanTransactions_ssn_hyperLink(SSN, SSN);
									//QCCSRLoginLogout.logout(SSN, AppURL);
									QCCSRLoginLogout.login(SSN, AppURL);
									CSRBorrower.Borrower_Edit(SSN, SSN);
									QCCSRLoginLogout.logout(SSN, AppURL);
									QCCSRLoginLogout.login(SSN, AppURL);
									QCCSRNewLoan.newLoan(SSN, SSN);
									QCCSRLoginLogout.logout(SSN, AppURL);
									QCCSRLoginLogout.login(SSN, AppURL);
									QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
									QCCSRLoginLogout.login(SSN, AppURL);
									CSRBorrower.Courtesycalls_SSN_Hyperlink(SSN, AppURL);
									//QCCSRLoginLogout.logout(SSN, AppURL);
									QCCSRLoginLogout.login(SSN, AppURL);
									CSRBorrower.manualdefault(SSN, AppURL);
									//QCCSRLoginLogout.logout(SSN, AppURL);
									QCCSRLoginLogout.login(SSN, AppURL);
									CSRBorrower.Collection_SSN_Hyperlink(SSN, AppURL);
									//QCCSRLoginLogout.logout(SSN, AppURL);
									QCCSRLoginLogout.central_login(SSN, AppURL);	
									Central_CourtesyCalls.Central_Courtesycalls_SSN_Hyperlink(SSN, AppURL);
									//QCCSRLoginLogout.logout(SSN, AppURL);
									QCCSRLoginLogout.central_login(SSN, AppURL);	
									Central_Collections.Central_Collections_SSN_Hyperlink(SSN, AppURL);
									//QCCSRLoginLogout.logout(SSN, AppURL);
									QCCSRLoginLogout.login(SSN, AppURL);
									CSRBorrower.admin_BorrowerSerach(SSN, AppURL);
									QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
									}
								}
							}
					catch (Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_342_TS047");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS047");

					}
				}
					
			//@Test(priority = 02, groups = { "QF-3421" })

					public static void QF_342_TS002() throws Exception {
						
						try {
							test = reports.startTest("QF_342_TS002","Register customer in online-->Login to CSR-->Click on borrower-->click on Edit-->Enter customer number-->Click on submit-->click on Go button");
							FileName = "QF-342-TS002.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								if (RunFlag.equals("Y")) {

									String SSN = TestData.getCellData(sheetName, "SSN", row);
					  				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
					  				System.out.println(AppURL); 	
									
									
									
									LendNationRegistration.registration(SSN, AppURL);
									LendNationPersonalInformation.personalInformation(SSN, AppURL);
									System.out.println(AppURL);
									
									
									QCCSRLoginLogout.login(SSN, AppURL);
									CSRBorrower.Borrower_Edit(SSN, SSN);
									QCCSRLoginLogout.logout(SSN, AppURL);
								    
									}
								}
							}
					catch (Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_342_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS002");

					}
				}	
					
			//@Test(priority = 04, groups = { "QF-3421" })

				public static void QF_342_TS004() throws Exception {
					
					try {
						test = reports.startTest("QF_342_TS004","Login to CSR-->Click on borrower-->click on Edit-->Enter customer number-->Click on submit-->click on Go button");
						FileName = "QF-342-TS002.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
								String SSN = TestData.getCellData(sheetName,"SSN",row); 
								String Funding = TestData.getCellData(sheetName,"Funding",row);
								System.out.println(App_URL);
							    System.out.println(AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
								CSRBorrower.Borrower_Edit(SSN, SSN);
								QCCSRLoginLogout.logout(SSN, AppURL);
							    
								}
							}
						}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_342_TS004");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS004");

				}
			}	
				
			@Test(priority = 8, groups = { "QF-3421" })//inprogress

				public static void QF_342_TS008() throws Exception {
					
					try {
						test = reports.startTest("QF_342_TS008","Register customer in online-->Login to CSR-->Click on borrower-->click on Edit SSN-->Enter customer number-->Click on submit-->click on Go button");
						FileName = "QF-342-TS008.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
								String SSN = TestData.getCellData(sheetName,"SSN",row); 
								String Funding = TestData.getCellData(sheetName,"Funding",row);
								System.out.println(App_URL);
								
								//loan_number="10781891";
								
								System.out.println(loan_number);
								
								LendNationRegistration.registration(SSN, AppURL);
								LendNationPersonalInformation.personalInformation(SSN, AppURL);
								System.out.println(AppURL);
								
								
								QCCSRLoginLogout.login(SSN, AppURL);
								CSRBorrower.admin_EditSSN(SSN, AppURL);
								QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
							    
								}
							}
						}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_342_TS008");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS008");

				}
			}	
				
			@Test(priority = 10, groups = { "QF-3421" })//inprogress

				public static void QF_342_TS010() throws Exception {
					
					try {
						test = reports.startTest("QF_342_TS010","Login to CSR-->Click on borrower-->click on Edit-->Enter customer number-->Click on submit-->click on Go button");
						FileName = "QF-342-TS008.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
								String SSN = TestData.getCellData(sheetName,"SSN",row); 
								String Funding = TestData.getCellData(sheetName,"Funding",row);
								System.out.println(App_URL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								CSRBorrower.admin_EditSSN(SSN, AppURL);
								QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
							    
								}
							}
						}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_342_TS010");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS010");

				}
			}
				
		@Test(priority = 12, groups = { "QF-3421" })

				public static void QF_342_TS012() throws Exception {
					
					try {
						test = reports.startTest("QF_342_TS012","Register customer in online-->Login to PAmM-->Click on borrower-->click on Edit-->Enter customer number-->Click on submit-->click on Go button");
						FileName = "QF-342-TS012.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
								String SSN = TestData.getCellData(sheetName,"SSN",row); 
								String Funding = TestData.getCellData(sheetName,"Funding",row);
								System.out.println(App_URL);
								
								LendNationRegistration.registration(SSN, AppURL);
								LendNationPersonalInformation.personalInformation(SSN, AppURL);
								System.out.println(AppURL);
								
								QCCSRLoginLogout.central_login(SSN, AppURL);							
								CSRBorrower.Borrower_Edit(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
							    
								}
							}
						}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_342_TS012");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS012");

				}
			}
				
			@Test(priority = 14, groups = { "QF-3421" })

				public static void QF_342_TS014() throws Exception {
					
					try {
						test = reports.startTest("QF_342_TS014","Login to PAM-->Click on borrower-->click on Edit-->Enter customer number-->Click on submit-->click on Go button");
						FileName = "QF-342-TS012.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
								String SSN = TestData.getCellData(sheetName,"SSN",row); 
								String Funding = TestData.getCellData(sheetName,"Funding",row);
								System.out.println(App_URL);
								
								QCCSRLoginLogout.central_login(SSN, AppURL);							
								CSRBorrower.Borrower_Edit(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
							    
								}
							}
						}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_342_TS014");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS014");

				}
			}
				
				@Test(priority = 18, groups = { "QF-3421" })

				public static void QF_342_TS018() throws Exception {
					
					try {
						test = reports.startTest("QF_342_TS018","Register customer in online-->Login to CSR-->Click on borrower-->click on Edit-->Enter customer number-->Click on submit-->click on SSN/ITIN Hyper Link");
						FileName = "QF-342-TS018.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
								String SSN = TestData.getCellData(sheetName,"SSN",row); 
								String Funding = TestData.getCellData(sheetName,"Funding",row);
								System.out.println(App_URL);
								
								LendNationRegistration.registration(SSN, AppURL);
								LendNationPersonalInformation.personalInformation(SSN, AppURL);
								System.out.println(AppURL);
								
								System.out.println(AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
								CSRBorrower.Edit_SSN_HyperLink(SSN, Funding);
								//QCCSRLoginLogout.logout(SSN, AppURL);
							    
								}
							}
						}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_342_TS018");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS018");

				}
			}
				
			@Test(priority = 20, groups = { "QF-3421" })

				public static void QF_342_TS020() throws Exception {
					
					try {
						test = reports.startTest("QF_342_TS020","Take Return customer in online-->Login to CSR-->Click on borrower-->click on Edit-->Enter customer number-->Click on submit-->click on SSN/ITIN Hyper Link");
						FileName = "QF-342-TS018.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
								String SSN = TestData.getCellData(sheetName,"SSN",row); 
								String Funding = TestData.getCellData(sheetName,"Funding",row);
							
								QCCSRLoginLogout.login(SSN, AppURL);
								CSRBorrower.Edit_SSN_HyperLink(SSN, Funding);
								//QCCSRLoginLogout.logout(SSN, AppURL);
							    
								}
							}
						}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_342_TS020");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS020");

				}
			}
				
			@Test(priority = 22, groups = { "QF-3421" })//inprogress

				public static void QF_342_TS022() throws Exception {
					
					try {
						test = reports.startTest("QF_342_TS022","Register customer in online-->Login to CSR-->Click on borrower-->click on Edit SSN-->Enter customer number-->Click on submit-->click on SSN/ITIN Hyper Link");
						FileName = "QF-342-TS022.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
								String SSN = TestData.getCellData(sheetName,"SSN",row); 
								String Funding = TestData.getCellData(sheetName,"Funding",row);
								System.out.println(App_URL);
								
								LendNationRegistration.registration(SSN, AppURL);
								LendNationPersonalInformation.personalInformation(SSN, AppURL);
								System.out.println(AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								CSRBorrower.EditSSN_SSN_HyperLink(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
							    
								}
							}
						}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_342_TS022");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS022");

				}
			}
				
				@Test(priority = 24, groups = { "QF-3421" })//inprogress

				public static void QF_342_TS024() throws Exception {
					
					try {
						test = reports.startTest("QF_342_TS024","Register customer in online-->Login to CSR-->Click on borrower-->click on Edit SSN-->Enter customer number-->Click on submit-->click on SSN/ITIN Hyper Link");
						FileName = "QF-342-TS022.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
								String SSN = TestData.getCellData(sheetName,"SSN",row); 
								String Funding = TestData.getCellData(sheetName,"Funding",row);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								CSRBorrower.EditSSN_SSN_HyperLink(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
							    
								}
							}
						}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_342_TS022");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS022");

				}
			}
				
			@Test(priority = 26, groups = { "QF-3421" })

				public static void QF_342_TS026() throws Exception {
					
					try {
						test = reports.startTest("QF_342_TS026","Register customer in online-->Login to CSR-->Click on Loan Transactions-->Click on Transactions-->Enter Customer number-->click on submit-->click on SSN/ITIN Hyper Link");
						FileName = "QF-342-TS026.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
								String SSN = TestData.getCellData(sheetName,"SSN",row); 
								String Funding = TestData.getCellData(sheetName,"Funding",row);
								System.out.println(App_URL);
								LendNationRegistration.registration(SSN, App_URL);
								LendNationPersonalInformation.personalInformation(SSN, App_URL);
								
								System.out.println(AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
								CSRBorrower.LoanTransactions_ssn_hyperLink(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
							    
								}
							}
						}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_342_TS026");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS026");

				}
			}
				
			@Test(priority = 28, groups = { "QF-3421" })

				public static void QF_342_TS028() throws Exception {
					
					try {
						test = reports.startTest("QF_342_TS028","Take return customer in online-->Login to CSR-->Click on Loan Transactions-->Click on Transactions-->Enter Customer number-->click on submit-->click on SSN/ITIN Hyper Link");
						FileName = "QF-342-TS026.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
								String SSN = TestData.getCellData(sheetName,"SSN",row); 
								String Funding = TestData.getCellData(sheetName,"Funding",row);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								CSRBorrower.LoanTransactions_ssn_hyperLink(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
							    
								}
							}
						}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_342_TS028");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS028");

				}
			}
				
		@Test(priority = 33, groups = { "QF-3421" })

				public static void QF_342_TS033() throws Exception {
					
					try {
						test = reports.startTest("QF_342_TS033","Register customer in online-->Login to PAM-->Click on Loan Transactions-->Click on Transactions-->Enter Customer number-->click on submit-->click on SSN/ITIN Hyper Link");
						FileName = "QF-342-TS033.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
								String SSN = TestData.getCellData(sheetName,"SSN",row); 
								String Funding = TestData.getCellData(sheetName,"Funding",row);
								System.out.println(App_URL);
								LendNationRegistration.registration(SSN, App_URL);
								LendNationPersonalInformation.personalInformation(SSN, App_URL);
								
								System.out.println(AppURL);
								
								QCCSRLoginLogout.central_login(SSN, AppURL);
								CSRBorrower.LoanTransactions_ssn_hyperLink(SSN, AppURL);
								//QCCSRLoginLogout.logout(SSN, AppURL);
							    
								}
							}
						}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_342_TS033");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS033");

				}
			}
				
		@Test(priority = 34, groups = { "QF-3421" })

				public static void QF_342_TS034() throws Exception {
					
					try {
						test = reports.startTest("QF_342_TS034","Take return customer in online-->Login to CSR-->Click on Loan Transactions-->Click on Transactions-->Enter Customer number-->click on submit-->click on SSN/ITIN Hyper Link");
						FileName = "QF-342-TS033.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
								String SSN = TestData.getCellData(sheetName,"SSN",row); 
								String Funding = TestData.getCellData(sheetName,"Funding",row);
								
								QCCSRLoginLogout.central_login(SSN, AppURL);
								CSRBorrower.LoanTransactions_ssn_hyperLink(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
							    
								}
							}
						}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_342_TS034");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS034");

				}
			}
				
			@Test(priority = 35, groups = { "QF-342" })

				public static void QF_342_TS035() throws Exception {
					
					try {
						test = reports.startTest("QF_342_TS035","Borrower Registration-->Cluick on Misc Transactions-->Click on Bill pay-->Enter customer number-->Click on submit-->Click on SSN/ITIN Hyper Link");
						FileName = "QF-342-TS035.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								// AppURL = TestData.getCellData(sheetName, "AppURL", row);
								SSN = TestData.getCellData(sheetName, "SSN", row);
								System.out.println(AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
								CSRBorrower.Misc_Transactions(SSN, AppURL);
								//QCCSRLoginLogout.logout(SSN, AppURL);
							
								}
							}
						}
					catch (Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_342_TS035");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS035");

					}
				}
				
			@Test(priority = 36, groups = { "QF-342" })

				public static void QF_342_TS036() throws Exception {
					
					try {
						test = reports.startTest("QF_342_TS036","Take return customer-->Cluick on Misc Transactions-->Click on Bill pay-->Enter customer number-->Click on submit-->Click on SSN/ITIN Hyper Link");
						FileName = "QF-342-TS035.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								// AppURL = TestData.getCellData(sheetName, "AppURL", row);
								SSN = TestData.getCellData(sheetName, "SSN", row);
								System.out.println(AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
								CSRBorrower.Misc_Transactions(SSN, AppURL);
								//QCCSRLoginLogout.logout(SSN, AppURL);
							
								}
							}
						}
					catch (Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_342_TS036");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS036");

					}
				}
				
			/*	@Test(priority = 37, groups = { "QF-342" })

				public static void QF_342_TS037() throws Exception {
					
					try {
						test = reports.startTest("QF_342_TS037","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
						FileName = "QF-342-TS037.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								// AppURL = TestData.getCellData(sheetName, "AppURL", row);
								SSN = TestData.getCellData(sheetName, "SSN", row);
								System.out.println(AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
								CSRBorrower.Edit_SSN_HyperLink(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								
								String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
								String Funding = TestData.getCellData(sheetName,"Funding",row);
								System.out.println(App_URL);
								LendNationRegistration.registration(SSN, App_URL);
								//LendNationPersonalInformation.personalInformation(SSN, App_URL);
								QCCSRLoginLogout.login(SSN, AppURL);
								CSRBorrower.Borrower_Edit(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
							
								}
							}
						}
					catch (Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_342_TS001");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS001");

					}
				}
*/				
			@Test(priority = 39, groups = { "QF-342" })

				public static void QF_342_TS0039() throws Exception {
					
					try {
						test = reports.startTest("QF_342_TS039","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
						FileName = "QF-342-TS039.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								// AppURL = TestData.getCellData(sheetName, "AppURL", row);
								SSN = TestData.getCellData(sheetName, "SSN", row);
								System.out.println(AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								QCCSRLoginLogout.central_login(SSN, AppURL);
								CSRBorrower.Edit_SSN_HyperLink(SSN, AppURL);
								//QCCSRLoginLogout.logout(SSN, AppURL);
								}
							}
						}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_342_TS039");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS039");

				}
			}
				
			@Test(priority = 44, groups = { "QF-342" })

				public static void QF_342_TS044() throws Exception {
					
					try {
						test = reports.startTest("QF_342_TS044","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
						FileName = "QF-342-TS044.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								// AppURL = TestData.getCellData(sheetName, "AppURL", row);
								SSN = TestData.getCellData(sheetName, "SSN", row);
								System.out.println(AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
								CSRBorrower.Borrower_Edit_personal_summery(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								QCCSRLoginLogout.central_login(SSN, AppURL);
								CSRBorrower.Borrower_Edit_personal_summery(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								}
							}
						}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_342_TS044");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS044");

				}
			}
				
			@Test(priority = 48, groups = { "QF-342" })

				public static void QF_342_TS048() throws Exception {
					
					try {
						test = reports.startTest("QF_342_TS048","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
						FileName = "QF-342-TS048.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								// AppURL = TestData.getCellData(sheetName, "AppURL", row);
								SSN = TestData.getCellData(sheetName, "SSN", row);
								System.out.println(AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
								CSRBorrower.Borrower_Edit_personal_summery(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								QCCSRLoginLogout.central_login(SSN, AppURL);
								CSRBorrower.Borrower_Edit_personal_summery(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								}
							}
						}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_342_TS048");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_342_TS048");

				}
			}		

			//=============================================REQ_369================================	
				@Test(priority = 01, groups = { "QF_369" })

				public static void QF_369_TS001() throws Exception {
					
					try {
						test = reports.startTest("QF_369_TS001","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
						FileName = "QF-369-TS001.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
								String SSN = TestData.getCellData(sheetName,"SSN",row); 
								String Funding = TestData.getCellData(sheetName,"Funding",row);
								System.out.println(App_URL);
								
								//loan_number="10781891";
								
								
								
								LendNationRegistration.Validate_SSNITIN_dropdown(SSN, App_URL);
								
							    
								}
							}
						}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_369_TS001");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS001");

				}
			}		
				
			@Test(priority = 02, groups = { "QF_369" })

				public static void QF_369_TS002() throws Exception {
					
					try {
						test = reports.startTest("QF_369_TS002","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
						FileName = "QF-369-TS002.xls";

						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
								String SSN = TestData.getCellData(sheetName,"SSN",row); 
								String Funding = TestData.getCellData(sheetName,"Funding",row);
								System.out.println(App_URL);
								
								LendNationRegistration.SSNITIN_validation(SSN, AppURL);
							    
								}
							}
						}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_369_TS002");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

				}
			}		
			
			@Test(priority = 46, groups = { "QF_369" })

			public static void QF_369_TS046() throws Exception {
				
				try {
					test = reports.startTest("QF_369_TS046","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
					FileName = "QF-369-TS046.xls";

					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					String sheetName = "Start";
					int lastrow = TestData.getLastRow("Start");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
							String SSN = TestData.getCellData(sheetName,"SSN",row); 
							String Funding = TestData.getCellData(sheetName,"Funding",row);
							System.out.println(App_URL);
							
							LendNationRegistration.invalidITIN_validation(SSN, AppURL);
						    
							}
						}
					}
			catch (Exception e) {
				
				String screenshotPath = getScreenhot(driver, "QF_369_TS002");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

			}
		}		
			@Test(priority = 06, groups = { "QF_369" })
			
       public static void QF_369_TS006() throws Exception {
				
				try {
					test = reports.startTest("QF_369_TS006","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
					FileName = "QF-369-TS006.xls";

					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					String sheetName = "Start";
					int lastrow = TestData.getLastRow("Start");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
							String SSN = TestData.getCellData(sheetName,"SSN",row); 
							String Funding = TestData.getCellData(sheetName,"Funding",row);
							System.out.println(App_URL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration_WithSSNorITIN(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							LendNationRegistration.registration_with_existed_ITIN(SSN, AppURL);
							
						    
							}
						}
					}
			catch (Exception e) {
				
				String screenshotPath = getScreenhot(driver, "QF_369_TS002");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

			}
		}		
			
			@Test(priority = 07, groups = { "QF_369" })
			
		       public static void QF_369_TS007() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS007","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS007.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									QCCSRLoginLogout.login(SSN, AppURL);
									QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
									QCCSRLoginLogout.logout(SSN, AppURL);
									LendNationRegistration.registration_with_existed_SSN(SSN, AppURL);
									
								    
									}
								}
							}
					catch (Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}	
			
			@Test(priority = 8, groups = { "QF_369" })//inprogress
			
		       public static void QF_369_TS008() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS008","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS008.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									LendNationRegistration.registration_withITIN(SSN, AppURL);
									LendNationPersonalInformation.personalInformation(SSN, AppURL);
									QCCSRLoginLogout.login(SSN, AppURL);
									//QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
									QCBorrowerRegistration.borrowerRegistration_withexistedSSN(SSN, AppURL);
									QCCSRLoginLogout.logout(SSN, AppURL);
									
									
								    
									}
								}
							}
					catch (Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}		
			
			@Test(priority = 9, groups = { "QF_369" })
			
		       public static void QF_369_TS009() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS009","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS009.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									LendNationRegistration.registration(SSN, AppURL);
									LendNationPersonalInformation.personalInformation(SSN, AppURL);
									QCCSRLoginLogout.login(SSN, AppURL);
									//QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
									QCBorrowerRegistration.borrowerRegistration_withexistedSSN(SSN, AppURL);
									QCCSRLoginLogout.logout(SSN, AppURL);
									
									
								    
									}
								}
							}
					catch (Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}		

			@Test(priority = 10, groups = { "QF_369" })//inprogress
			
		       public static void QF_369_TS010() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS010","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS010.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									QCCSRLoginLogout.login(SSN, AppURL);
									QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
									QCCSRLoginLogout.logout(SSN, AppURL);
									LendNationRegistration.store_customersetup(SSN, AppURL);
									
									
									
								    
									}
								}
							}
					catch (Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}		

			@Test(priority = 11, groups = { "QF_369" })//inprogress
			
		       public static void QF_369_TS011() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS011","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS011.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									QCCSRLoginLogout.login(SSN, AppURL);
									QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
									QCCSRLoginLogout.logout(SSN, AppURL);
									LendNationRegistration.store_customersetup_WithSSN(SSN, AppURL);
									
									
									
								    
									}
								}
							}
					catch (Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}		
			
			@Test(priority = 12, groups = { "QF_369" })//inprogress
			
		       public static void QF_369_TS012() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS012","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS012.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									QCCSRLoginLogout.login(SSN, AppURL);
									QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
									QCCSRLoginLogout.logout(SSN, AppURL);
								
									LendNationRegistration.login(SSN, AppURL);
									LendNationRegistration.viewProfile(SSN, AppURL);
									
								
									
									
									
								    
									}
								}
							}
					catch (Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}	
			
			@Test(priority = 16, groups = { "QF_369" })//no records found
			
		       public static void QF_369_TS016() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS016","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS016.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									LendNationRegistration.registration(SSN, AppURL);
									LendNationPersonalInformation.personalInformation(SSN, AppURL);
									QCCSRLoginLogout.login(SSN, AppURL);
									CSRBorrower.Borrower_Edit(SSN, SSN);
									QCCSRLoginLogout.logout(SSN, AppURL);
									
									
								    
									}
								}
							}
					catch (Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS016");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS016");

					}
				}		

			@Test(priority = 17, groups = { "QF_369" })
			
		       public static void QF_369_TS017() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS017","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS017.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									LendNationRegistration.registration(SSN, AppURL);
									LendNationPersonalInformation.personalInformation(SSN, AppURL);
									QCCSRLoginLogout.login(SSN, AppURL);
									CSRBorrower.Borrower_Edit(SSN, SSN);
									QCCSRLoginLogout.logout(SSN, AppURL);
									
									
								    
									}
								}
							}
					catch (Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}		
			
			@Test(priority = 18, groups = { "QF_369" })
			
		       public static void QF_369_TS018() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS018","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS018.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									LendNationRegistration.registration_withITIN(SSN, AppURL);
									LendNationPersonalInformation.personalInformation(SSN, AppURL);
									LendNationRegistration.registration_with_existed_ITIN(SSN, AppURL);
									
									
									
								    
									}
								}
							}
					catch (Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}		
			
			@Test(priority = 23, groups = { "QF_369" })//inprogress
			
		       public static void QF_369_TS023() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS023","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS023.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									LendNationRegistration.registration_withITIN(SSN, AppURL);
									//LendNationRegistration.login(SSN, AppURL);
					   				LendNationPersonalInformation.personalInformation(SSN, AppURL);
					   			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
					   			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
					   				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
					   			    LendNationSignContract.signContract(SSN, AppURL);
					   				          				
					   			if(ReceiveType.equalsIgnoreCase("Cash At Store"))
					   			    {		  				
					   				QCCSR_PAM.CashAtStore(SSN, AppURL);
					   				
					   				QCCSR_PAM.PAMLogin(SSN, AppURL);
					   				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
					   			    }
					   			
					   			else{
					   				QCCSR_PAM.PAMLogin(SSN, AppURL);
					   				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
					   				
					   			    }
					   					
					     }
					     }
					     }
									
									
								  
								
					catch(Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}		
			
			@Test(priority = 28, groups = { "QF_369" })//no records found
			
		       public static void QF_369_TS028() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS028","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS028.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									LendNationRegistration.registration(SSN, AppURL);
									
					   				LendNationPersonalInformation.personalInformation(SSN, AppURL);
					   				QCCSRLoginLogout.login(SSN, AppURL);
									CSRBorrower.Misc_Transactions(SSN, AppURL);
					   			
					   					
					     }
					     }
					     }
									
									
								  
								
					catch(Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}	
			
			
			
			@Test(priority = 14, groups = { "QF_369" })
			
		       public static void QF_369_TS014() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS028","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS014.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									LendNationRegistration.store_customersetup(SSN, AppURL);
					   			
					   					
					     }
					     }
					     }
									
									
								  
								
					catch(Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}	
			
			@Test(priority = 15, groups = { "QF_369" })
			
		       public static void QF_369_TS015() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS015","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS015.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									LendNationRegistration.store_customersetup(SSN, AppURL);
					   			
					   					
					     }
					     }
					     }
									
									
								  
								
					catch(Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}	
			
			@Test(priority = 29, groups = { "QF_369" })
			
		       public static void QF_369_TS029() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS029","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS029.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									LendNationRegistration.registration(SSN, AppURL);									
					   				LendNationPersonalInformation.personalInformation(SSN, AppURL);
					   				QCCSRLoginLogout.login(SSN, AppURL);
									CSRBorrower.Insight_issue_newcard(SSN, AppURL);
					   			
					   					
					     }
					     }
					     }
									
									
								  
								
					catch(Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}	
			
			@Test(priority = 33, groups = { "QF_369" }) //inprogress
			
		       public static void QF_369_TS033() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS033","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS033.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
					   				QCCSRLoginLogout.login(SSN, AppURL);
									CSRBorrower.Misc_Customer_registration(SSN, AppURL);
									QCCSRLoginLogout.logout(SSN, AppURL);
									LendNationRegistration.registration_with_existed_ITIN(SSN, AppURL);
					   			
					   					
					     }
					     }
					     }
									
									
								  
								
					catch(Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}	
			
			@Test(priority = 34, groups = { "QF_369" }) //inprogress
			
		       public static void QF_369_TS034() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS034","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS034.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
					   				QCCSRLoginLogout.login(SSN, AppURL);
									CSRBorrower.Misc_Customer_registration(SSN, AppURL);
									QCCSRLoginLogout.logout(SSN, AppURL);
									LendNationRegistration.registration_with_existed_ITIN(SSN, AppURL);
					   			
					   					
					     }
					     }
					     }
									
									
								  
								
					catch(Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}	
			

			@Test(priority = 37, groups = { "QF_369" }) //inprogress
			
		       public static void QF_369_TS037() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS037","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS037.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									LendNationRegistration.registration(SSN, AppURL);
									LendNationPersonalInformation.personalInformation(SSN, AppURL);
									QCCSRLoginLogout.login(SSN, AppURL);
									QCBorrowerRegistration.borrowerRegistration_withexistedSSN(SSN, AppURL);
									QCCSRLoginLogout.logout(SSN, AppURL);
									
									
					   					
					     }
					     }
					     }
									
									
								  
								
					catch(Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}	


			@Test(priority = 38, groups = { "QF_369" }) //inprogress
			
		       public static void QF_369_TS038() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS038","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS038.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									LendNationRegistration.registration(SSN, AppURL);
									LendNationPersonalInformation.personalInformation(SSN, AppURL);
									QCCSRLoginLogout.login(SSN, AppURL);
									QCBorrowerRegistration.borrowerRegistration_withexistedSSN(SSN, AppURL);
									QCCSRLoginLogout.logout(SSN, AppURL);
									
									
					   					
					     }
					     }
					     }
									
									
								  
								
					catch(Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}
			
			@Test(priority = 39, groups = { "QF_369" }) //inprogress
			
		       public static void QF_369_TS039() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS039","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS039.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									QCCSRLoginLogout.login(SSN, AppURL);
									QCBorrowerRegistration.borrowerRegistration_WithSSNorITIN(SSN, AppURL);
									QCCSRLoginLogout.logout(SSN, AppURL);
									LendNationRegistration.registration_with_existed_ITIN(SSN, AppURL);
									
									
					   					
					     }
					     }
					     }
									
									
								  
								
					catch(Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}
			
			@Test(priority = 40, groups = { "QF_369" }) //inprogress
			
		       public static void QF_369_TS040() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS040","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS040.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									QCCSRLoginLogout.login(SSN, AppURL);
									QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
									QCCSRLoginLogout.logout(SSN, AppURL);
									LendNationRegistration.registration_with_existed_SSN(SSN, AppURL);
									
									
					   					
					     }
					     }
					     }
									
									
								  
								
					catch(Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}

			@Test(priority = 41, groups = { "QF_369" }) //inprogress
			
		       public static void QF_369_TS041() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS041","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS041.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									
									
									QCCSRLoginLogout.login(SSN, AppURL);
									QCBorrowerRegistration.borrowerRegistration_WithSSNorITIN(SSN, AppURL);
									QCCSRLoginLogout.logout(SSN, AppURL);
									LendNationRegistration.store_customersetup(SSN, AppURL);
									
									
					   					
					     }
					     }
					     }
									
									
								  
								
					catch(Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}
			
			@Test(priority = 42, groups = { "QF_369" }) //inprogress
			
		       public static void QF_369_TS042() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS042","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS042.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									QCCSRLoginLogout.login(SSN, AppURL);
									QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
									QCCSRLoginLogout.logout(SSN, AppURL);
									LendNationRegistration.store_customersetup(SSN, AppURL);
											
					   					
					     }
					     }
					     }
									
									
								  
								
					catch(Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}

			@Test(priority = 43, groups = { "QF_369" }) //inprogress
			
		       public static void QF_369_TS043() throws Exception {
						
						try {
							test = reports.startTest("QF_369_TS043","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
							FileName = "QF-369-TS042.xls";

							TestData = new ExcelNew(System.getProperty("user.dir")
									+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

							String sheetName = "Start";
							int lastrow = TestData.getLastRow("Start");
							System.out.println(lastrow);
							for (int row = 2; row <= lastrow; row++) {

								String RunFlag = TestData.getCellData(sheetName, "Run", row);
								// System.out.println(RunFlag);
								if (RunFlag.equals("Y")) {

									String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
									String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
									String SSN = TestData.getCellData(sheetName,"SSN",row); 
									String Funding = TestData.getCellData(sheetName,"Funding",row);
									System.out.println(App_URL);
									LendNationRegistration.forgot_username(SSN, AppURL);
					   					
					     }
					     }
					     }
									
									
								  
								
					catch(Exception e) {
						
						String screenshotPath = getScreenhot(driver, "QF_369_TS002");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

					}
				}



			
			@Test(priority = 045, groups = { "QF_369" })

			public static void QF_369_TS045() throws Exception {
				
				try {
					test = reports.startTest("QF_369_TS045","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
					FileName = "QF-369-TS045.xls";

					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					String sheetName = "Start";
					int lastrow = TestData.getLastRow("Start");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
							String SSN = TestData.getCellData(sheetName,"SSN",row); 
							String Funding = TestData.getCellData(sheetName,"Funding",row);
							System.out.println(App_URL);
							
							LendNationRegistration.registration_with_invalidITIN(SSN, AppURL);
						    
							}
						}
					}
			catch (Exception e) {
				
				String screenshotPath = getScreenhot(driver, "QF_369_TS002");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

			}
		}	
			
			@Test(priority = 03, groups = { "QF_369" })

			public static void QF_369_TS003() throws Exception {
				
				try {
					test = reports.startTest("QF_369_TS003","Login to online-->Click on Start loan application-->validate SSN/ITLN dropdown");
					FileName = "QF-369-TS003.xls";

					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					String sheetName = "Start";
					int lastrow = TestData.getLastRow("Start");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							String App_URL = TestData.getCellData(sheetName,"App_URL",row); 
							String SSN = TestData.getCellData(sheetName,"SSN",row); 
							String Funding = TestData.getCellData(sheetName,"Funding",row);
							System.out.println(App_URL);
							
							/*LendNationRegistration.registration(SSN, App_URL);
							LendNationPersonalInformation.personalInformation(SSN, App_URL);*/
							//LendNationRegistration.login(SSN, App_URL);
						    
							}
						}
					}
			catch (Exception e) {
				
				String screenshotPath = getScreenhot(driver, "QF_369_TS002");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QF_369_TS002");

			}
		}		
			
			//====================================REQ_TLP_601===================================
			
			@Test(priority = 1, groups = { "REQ_TLP_601" })

			public static void QF_601_TS_001() throws Exception {
				
				try {
					test = reports.startTest("QF_601_TS_001","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
					FileName = "QF_601_TS_001.xls";

					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					String sheetName = "Start";
					int lastrow = TestData.getLastRow("Start");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							// AppURL = TestData.getCellData(sheetName, "AppURL", row);
							//SSN = TestData.getCellData(sheetName, "SSN", row);
							System.out.println(AppURL);
							/*QCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);*/
							QCCSRLoginLogout.login(SSN, AppURL);
							QCCSRNewLoan2.newLoan(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							
							Central_CourtesyCalls.prmoise_to_pay(SSN, AppURL);
							
							
							}
						}
					}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_601_TS_001");
					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_601_TS_001");

				}
			}

			@Test(priority = 10, groups = { "REQ_TLP_601" }) //completed
               public static void QF_601_TS_010() throws Exception {
				
				try {
					test = reports.startTest("QF_601_TS_010","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
					FileName = "QF_601_TS_010.xls";

					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					String sheetName = "Start";
					int lastrow = TestData.getLastRow("Start");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							// AppURL = TestData.getCellData(sheetName, "AppURL", row);
							SSN = TestData.getCellData(sheetName, "SSN", row);
							System.out.println(AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCCSRNewLoan2.newLoan(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							AQCPayment.payment(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							VQCInternalTransfer.internalTransfer(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							
							}
						}
					}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_601_TS_010");
					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_601_TS_010");

				}
			}

            @Test(priority = 11, groups = { "REQ_TLP_601" }) //completed
               public static void QF_601_TS_011() throws Exception {
				
				try {
					test = reports.startTest("QF_601_TS_011","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
					FileName = "QF_601_TS_011.xls";

					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					String sheetName = "Start";
					int lastrow = TestData.getLastRow("Start");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							// AppURL = TestData.getCellData(sheetName, "AppURL", row);
							SSN = TestData.getCellData(sheetName, "SSN", row);
							System.out.println(AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCCSRNewLoan2.newLoan(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							AQCPayment.payment(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCEODDeposit.eodDeposit(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCSafeAssign.safeAssign(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCDrawerAssign.drawerAssign(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							AQCClearDropdown.clearDropDown(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							
							
							}
						}
					}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_601_TS_011");
					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_601_TS_011");

				}
			}
               
           @Test(priority = 12, groups = { "REQ_TLP_601" }) //completed
               public static void QF_601_TS_012() throws Exception {
				
				try {
					test = reports.startTest("QF_601_TS_012","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
					FileName = "QF_601_TS_012.xls";

					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					String sheetName = "Start";
					int lastrow = TestData.getLastRow("Start");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							// AppURL = TestData.getCellData(sheetName, "AppURL", row);
							SSN = TestData.getCellData(sheetName, "SSN", row);
							System.out.println(AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCCSRNewLoan2.newLoan(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							AQCPayment.payment(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							VQCInternalTransfer.internalTransfer(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							CSRtlpckPaymentClear.ckpaymentClear(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							
							
							
							}
						}
					}
				catch (Exception e) {
					
					String screenshotPath = getScreenhot(driver, "QF_601_TS_012");
					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

					test.log(LogStatus.ERROR, "Unable to start scenario QF_601_TS_012");

				}
			}
			
             @Test(priority = 13, groups = { "REQ_TLP_601" }) //completed
               public static void QF_601_TS_013() throws Exception {
   				
   				try {
   					test = reports.startTest("QF_601_TS_013","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
   					FileName = "QF_601_TS_013.xls";

   					TestData = new ExcelNew(System.getProperty("user.dir")
   							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   					String sheetName = "Start";
   					int lastrow = TestData.getLastRow("Start");
   					System.out.println(lastrow);
   					for (int row = 2; row <= lastrow; row++) {

   						String RunFlag = TestData.getCellData(sheetName, "Run", row);
   						// System.out.println(RunFlag);
   						if (RunFlag.equals("Y")) {

   							// AppURL = TestData.getCellData(sheetName, "AppURL", row);
   							SSN = TestData.getCellData(sheetName, "SSN", row);
   							System.out.println(AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
   							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
   							QCCSRLoginLogout.logout(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
   							QCCSRNewLoan2.newLoan(SSN, AppURL);
   							QCCSRLoginLogout.logout(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
   							QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
   							AQCPayment.payment(SSN, AppURL);
   							QCCSRLoginLogout.logout(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
							QCEODDeposit.eodDeposit(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCSafeAssign.safeAssign(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCDrawerAssign.drawerAssign(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							CSRtlpckPaymentClear.ckpaymentClear(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
   							
   							
   							}
   						}
   					}
   				catch (Exception e) {
   					
   					String screenshotPath = getScreenhot(driver, "QF_601_TS_013");
   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

   					test.log(LogStatus.ERROR, "Unable to start scenario QF_601_TS_013");

   				}
   			}
               
              @Test(priority = 14, groups = { "REQ_TLP_601" }) //completed
               public static void QF_601_TS_014() throws Exception {
   				
   				try {
   					test = reports.startTest("QF_601_TS_014","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
   					FileName = "QF_601_TS_014.xls";

   					TestData = new ExcelNew(System.getProperty("user.dir")
   							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   					String sheetName = "Start";
   					int lastrow = TestData.getLastRow("Start");
   					System.out.println(lastrow);
   					for (int row = 2; row <= lastrow; row++) {

   						String RunFlag = TestData.getCellData(sheetName, "Run", row);
   						// System.out.println(RunFlag);
   						if (RunFlag.equals("Y")) {

   							// AppURL = TestData.getCellData(sheetName, "AppURL", row);
   							SSN = TestData.getCellData(sheetName, "SSN", row);
   							System.out.println(AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
   							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
   							QCCSRLoginLogout.logout(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
   							QCCSRNewLoan2.newLoan(SSN, AppURL);
   							QCCSRLoginLogout.logout(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
   							QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
   							AQCPayment.payment(SSN, AppURL);
   							QCCSRLoginLogout.logout(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
							VQCInternalTransfer.internalTransfer(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
   							
   							
   							}
   						}
   					}
   				catch (Exception e) {
   					
   					String screenshotPath = getScreenhot(driver, "QF_601_TS_014");
   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

   					test.log(LogStatus.ERROR, "Unable to start scenario QF_601_TS_014");

   				}
   			}
               
               @Test(priority = 15, groups = { "REQ_TLP_601" }) //completed
               public static void QF_601_TS_015() throws Exception {
   				
   				try {
   					test = reports.startTest("QF_601_TS_015","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
   					FileName = "QF_601_TS_015.xls";

   					TestData = new ExcelNew(System.getProperty("user.dir")
   							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   					String sheetName = "Start";
   					int lastrow = TestData.getLastRow("Start");
   					System.out.println(lastrow);
   					for (int row = 2; row <= lastrow; row++) {

   						String RunFlag = TestData.getCellData(sheetName, "Run", row);
   						// System.out.println(RunFlag);
   						if (RunFlag.equals("Y")) {

   							// AppURL = TestData.getCellData(sheetName, "AppURL", row);
   							SSN = TestData.getCellData(sheetName, "SSN", row);
   							System.out.println(AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
   							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
   							QCCSRLoginLogout.logout(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
   							QCCSRNewLoan2.newLoan(SSN, AppURL);
   							QCCSRLoginLogout.logout(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
   							QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
   							AQCPayment.payment(SSN, AppURL);
   							QCCSRLoginLogout.logout(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
							QCEODDeposit.eodDeposit(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCSafeAssign.safeAssign(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCDrawerAssign.drawerAssign(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							CSRtlpckPaymentClear.ckpaymentClear(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
   							
   							
   							}
   						}
   					}
   				catch (Exception e) {
   					
   					String screenshotPath = getScreenhot(driver, "QF_601_TS_015");
   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

   					test.log(LogStatus.ERROR, "Unable to start scenario QF_601_TS_015");

   				}
   			}
               
            @Test(priority = 16, groups = { "REQ_TLP_601" }) //completed
               public static void QF_601_TS_016() throws Exception {
   				
   				try {
   					test = reports.startTest("QF_601_TS_016","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
   					FileName = "QF_601_TS_016.xls";

   					TestData = new ExcelNew(System.getProperty("user.dir")
   							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   					String sheetName = "Start";
   					int lastrow = TestData.getLastRow("Start");
   					System.out.println(lastrow);
   					for (int row = 2; row <= lastrow; row++) {

   						String RunFlag = TestData.getCellData(sheetName, "Run", row);
   						// System.out.println(RunFlag);
   						if (RunFlag.equals("Y")) {

   							// AppURL = TestData.getCellData(sheetName, "AppURL", row);
   							SSN = TestData.getCellData(sheetName, "SSN", row);
   							System.out.println(AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
   							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
   							QCCSRLoginLogout.logout(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
   							QCCSRNewLoan2.newLoan(SSN, AppURL);
   							QCCSRLoginLogout.logout(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
   							QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
   							AQCPayment.payment(SSN, AppURL);
   							QCCSRLoginLogout.logout(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
							VQCInternalTransfer.internalTransfer(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							CSRtlpckPaymentClear.ckpaymentClear(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
   							
   							}
   						}
   					}
   				catch (Exception e) {
   					
   					String screenshotPath = getScreenhot(driver, "QF_601_TS_016");
   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

   					test.log(LogStatus.ERROR, "Unable to start scenario QF_601_TS_016");

   				}
   			}
               
               
             @Test(priority = 17, groups = { "REQ_TLP_601" }) 
               public static void QF_601_TS_017() throws Exception {
   				
   				
   					test = reports.startTest("QF_601_TS_017","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
   					FileName = "QF_601_TS_017.xls";

   					TestData = new ExcelNew(System.getProperty("user.dir")
   							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   					String sheetName = "Start";
   					int lastrow = TestData.getLastRow("Start");
   					System.out.println(lastrow);
   					for (int row = 2; row <= lastrow; row++) {

   						String RunFlag = TestData.getCellData(sheetName, "Run", row);
   					
   						if (RunFlag.equals("Y")) {

   						
   							SSN = TestData.getCellData(sheetName, "SSN", row);
   							
   							QCCSRLoginLogout.login(SSN, AppURL);
   							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
   							QCCSRLoginLogout.logout(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
   							QCCSRNewLoan2.newLoan(SSN, AppURL);
   							QCCSRLoginLogout.logout(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
   							QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
   							AQCPayment.payment(SSN, AppURL);
   							QCCSRLoginLogout.logout(SSN, AppURL);
   							QCCSRLoginLogout.login(SSN, AppURL);
							QCEODDeposit.eodDeposit(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCSafeAssign.safeAssign(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCDrawerAssign.drawerAssign(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							//QCCSRLoginLogout.adminLogin(SSN, AppURL);
   							
   							}
   						}
   					
   			}
             
           //====================================REQ_LOC_884===================================
             
             @Test(priority = 01, groups = { "REQ_LOC_884" }) 
             public static void QF_884_TS_001() throws Exception {
 				
 				try{
 					test = reports.startTest("QF-884-TS-001","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
 					FileName = "QF-884-TS-001.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 						/*	QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.central_login(SSN, AppURL);
 							VQCCSRCourtesy.promisetoPay(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
 							
 							DBScheduler.scheduler1025();
 							
 							LendNationRegistration.store_customersetup(SSN, AppURL);*/
 							/*LendNationRegistration.login(SSN, AppURL);
 							LendNationRegistration.payment(SSN, AppURL);*/
 							DBScheduler.scheduler116();
 							LendNationRegistration.login(SSN, AppURL);
 							}
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "QF-884-TS-001");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario QF-884-TS-001");

 	   				}
 					
 			}
             
             @Test(priority = 02, groups = { "REQ_LOC_884" }) 
             public static void QF_884_TS_002() throws Exception {
 				
 				try{
 					test = reports.startTest("QF_601_TS_002","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
 					FileName = "QF-884-TS-002.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.central_login(SSN, AppURL);
 							VQCCSRCourtesy.promisetoPay(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
 							
 							DBScheduler.scheduler1025();
 							
 							LendNationRegistration.store_customersetup(SSN, AppURL);
 							}
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "QF-884-TS-002");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario QF-884-TS-002");

 	   				}
 					
 			}
             
             @Test(priority = 8, groups = { "REQ_LOC_884" }) 
             public static void QF_884_TS_008() throws Exception {
 				
 				try{
 					test = reports.startTest("QF-884-TS-008","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
 					FileName = "QF-884-TS-008.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							CSRBorrower.manualdefault(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
							AQCPayment.cashiercheck(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
 							LendNationRegistration.store_customersetup(SSN, AppURL);
 							LendNationRegistration.login(SSN, AppURL);
 							LendNationRegistration.payment(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCInternalTransfer.internalTransfer(SSN, AppURL);
 							LendNationRegistration.login(SSN, AppURL);
 							LendNationRegistration.payment(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
							QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
 							
 							
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "QF-884-TS-008");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario QF-884-TS-008");

 	   				}
 					
 			}
             @Test(priority = 9, groups = { "REQ_LOC_884" }) 
             public static void QF_884_TS_009() throws Exception {
 				
 				try{
 					test = reports.startTest("QF-884-TS-008","Borrower Registration-->Click on Borrower-->Click on Edit-->Enter Customer number-->Click on Submit");
 					FileName = "QF-884-TS-009.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							CSRBorrower.manualdefault(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
							AQCPayment.cashiercheck(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
 							LendNationRegistration.store_customersetup(SSN, AppURL);
 							LendNationRegistration.login(SSN, AppURL);
 							LendNationRegistration.payment(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCInternalTransfer.internalTransfer(SSN, AppURL);
 							LendNationRegistration.login(SSN, AppURL);
 							LendNationRegistration.payment(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
							QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
 							
 							
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "QF-884-TS-008");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario QF-884-TS-008");

 	   				}
 					
 			}
             
             //================================================LOC-918=================
             
             @Test(priority = 01, groups = { "REQ_918_B20_403" }) //inprogress
             public static void B20_403_TS_1() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_403_TS_1","Borrower Registration-->newloan-->1st deposit nd return-->2nd deposit and return-->store age grace days-->EOD");
 					FileName = "QF-918-001.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCEODDeposit.eodDeposit(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCSafeAssign.safeAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCDrawerAssign.drawerAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.History(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_403_TS_1");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_403_TS_1");

 	   				}
 					
 			}
             
             @Test(priority = 02, groups = { "REQ_918_B20_403" }) 
             public static void B20_403_TS_2() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_403_TS_2","Borrower Registration-->newloan-->1st deposit nd return-->2nd deposit and return");
 					FileName = "QF-918-002.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.history(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_403_TS_2");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_403_TS_2");

 	   				}
 					
 			}
             
             @Test(priority = 03, groups = { "REQ_918_B20_403" }) 
             public static void B20_403_TS_3() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_403_TS_3","Borrower Registration-->newloan-->1st deposit-->2nd deposit and return-->store age grace days-->EOD");
 					FileName = "QF-918-003.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCEODDeposit.eodDeposit(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCSafeAssign.safeAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCDrawerAssign.drawerAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.history(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_403_TS_3");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_403_TS_3");

 	   				}
 					
 			}
             
             @Test(priority = 04, groups = { "REQ_918_B20_403" }) 
             public static void B20_403_TS_4() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_403_TS_4","Borrower Registration-->newloan-->1st deposit-->2nd deposit and return");
 					FileName = "QF-918-004.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.history(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_403_TS_4");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_403_TS_4");

 	   				}
 					
 			}
             
             @Test(priority = 05, groups = { "REQ_918_B20_403" }) 
             public static void B20_403_TS_5() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_403_TS_5","Borrower Registration-->newloan-->1st deposit-->2nd deposit and return-->store age grace days-->EOD");
 					FileName = "QF-918-005.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCEODDeposit.eodDeposit(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCSafeAssign.safeAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCDrawerAssign.drawerAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.history(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_403_TS_5");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_403_TS_5");

 	   				}
 					
 			}
             
             @Test(priority = 06, groups = { "REQ_918_B20_4031" }) //post default inprogress
             public static void B20_403_TS_6() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_403_TS_6","Borrower Registration-->newloan(SLOC)-->1st deposit nd return-->2nd deposit and return-->store age grace days-->EOD");
 					FileName = "QF-918-006.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCEODDeposit.eodDeposit(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCSafeAssign.safeAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCDrawerAssign.drawerAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.history(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_403_TS_6");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_403_TS_6");

 	   				}
 					
 			}
             
             @Test(priority = 07, groups = { "REQ_918_B20_4031" }) //post default inprogress
             public static void B20_403_TS_7() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_403_TS_7","Borrower Registration-->newloan-->1st deposit nd return-->2nd deposit and return-->store age grace days-->EOD");
 					FileName = "QF-918-007.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCEODDeposit.eodDeposit(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCSafeAssign.safeAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCDrawerAssign.drawerAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.history(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_403_TS_7");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_403_TS_7");

 	   				}
 					
 			}
             
             @Test(priority = 8, groups = { "REQ_918_B20_4031" }) //safe deposit application execption inprogress
             public static void B20_403_TS_8() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_403_TS_8","Borrower Registration-->newloan-->store age to 15 days-->conversion-->cmg-->safe deposit-->");
 					FileName = "QF-918-008.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCConversion.LOCConversion(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
							VQCInternalTransfer.internalTransfer(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
 							
							
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_403_TS_8");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_403_TS_8");

 	   				}
 					
 			}
             
             @Test(priority = 9, groups = { "REQ_918_B20_4031" }) 
             public static void B20_403_TS_9() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_403_TS_9","Borrower Registration-->newloan-->store age to 15 days-->conversion");
 					FileName = "QF-918-009.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCConversion.LOCConversion(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_403_TS_9");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_403_TS_9");

 	   				}
 					
 			}
             
             @Test(priority = 10, groups = { "REQ_918_B20_4031" }) 
             public static void B20_403_TS_10() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_403_TS_10","Borrower Registration-->newloan(SLOC)-->1st deposit nd return-->2nd deposit and return-->store age grace days-->EOD");
 					FileName = "QF-918-010.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCEODDeposit.eodDeposit(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCSafeAssign.safeAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCDrawerAssign.drawerAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.history(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_403_TS_10");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_403_TS_10");

 	   				}
 					
 			}
             
             @Test(priority = 11, groups = { "REQ_918_B20_404" }) 
             public static void B20_404_TS_11() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_404_TS_11","Borrower Registration-->newloan-->1st deposi nd return-->2nd deposit and return");
 					FileName = "QF-918-011.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCEODDeposit.eodDeposit(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCSafeAssign.safeAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCDrawerAssign.drawerAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.History(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_404_TS_11");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_404_TS_11");

 	   				}
 					
 			}
             
             @Test(priority = 12, groups = { "REQ_918_B20_404" }) 
             public static void B20_404_TS_12() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_404_TS_12","Borrower Registration-->newloan-->1st deposi nd return-->2nd deposit and return");
 					FileName = "QF-918-012.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.History(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_404_TS_12");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_404_TS_12");

 	   				}
 					
 			}
             
             @Test(priority = 13, groups = { "REQ_918_B20_404" }) 
             public static void B20_404_TS_13() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_404_TS_13","Borrower Registration-->newloan-->1st deposi nd return-->2nd deposit and return");
 					FileName = "QF-918-013.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCEODDeposit.eodDeposit(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCSafeAssign.safeAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCDrawerAssign.drawerAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.History(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 				
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_404_TS_13");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_404_TS_13");

 	   				}
 					
 			}
             
             @Test(priority = 14, groups = { "REQ_918_B20_404" }) 
             public static void B20_404_TS_14() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_404_TS_14","Borrower Registration-->newloan-->1st deposit-->2nd deposit and return");
 					FileName = "QF-918-014.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.History(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_404_TS_14");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_404_TS_14");

 	   				}
 					
 			}
             
             @Test(priority = 15, groups = { "REQ_918_B20_404" }) 
             public static void B20_404_TS_15() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_404_TS_15","Borrower Registration-->newloan-->1st deposit-->2nd deposit and return-->store age grace days-->EOD");
 					FileName = "QF-918-015.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCEODDeposit.eodDeposit(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCSafeAssign.safeAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCDrawerAssign.drawerAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.History(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_404_TS_15");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_404_TS_15");

 	   				}
 					
 			}
             
             @Test(priority = 16, groups = { "REQ_918_B20_404" }) //post default inprogress
             public static void B20_404_TS_16() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_404_TS_16","Borrower Registration-->newloan(SLOC)-->1st deposit nd return-->2nd deposit and return-->store age grace days-->EOD");
 					FileName = "QF-918-016.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCEODDeposit.eodDeposit(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCSafeAssign.safeAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCDrawerAssign.drawerAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.History(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_404_TS_16");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_404_TS_16");

 	   				}
 					
 			}
             
            // @Test(priority = 17, groups = { "REQ_918_B20_4041" }) //post default inprogress
             public static void B20_404_TS_17() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_404_TS_17","Borrower Registration-->newloan-->1st deposit nd return-->2nd deposit and return-->store age grace days-->EOD");
 					FileName = "QF-918-017.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCEODDeposit.eodDeposit(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCSafeAssign.safeAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCDrawerAssign.drawerAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.History(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_404_TS_17");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_404_TS_17");

 	   				}
 					
 			}
             
            // @Test(priority = 20, groups = { "REQ_918_B20_404" }) //manual default is not applicable(inprogress)
             public static void B20_404_TS_20() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_404_TS_20","Borrower Registration-->newloan(SLOC)-->1st deposit nd return-->2nd deposit and return-->store age grace days-->EOD");
 					FileName = "QF-918-020.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCEODDeposit.eodDeposit(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCSafeAssign.safeAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCDrawerAssign.drawerAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.History(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_404_TS_20");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_404_TS_20");

 	   				}
 					
 			}
             
             @Test(priority = 21, groups = { "REQ_918_B20_40512" }) 
             public static void B20_405_TS_21() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_405_TS_21","Borrower Registration-->newloan(SLOC)-->1st deposit nd return-->2nd deposit and return-->store age grace days-->EOD");
 					FileName = "QF-918-021.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.chargeback(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.chargeback1(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL); 								
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCEODDeposit.eodDeposit(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCSafeAssign.safeAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCDrawerAssign.drawerAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.History(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_405_TS_21");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_405_TS_21");

 	   				}
 					
 			}
             
             @Test(priority = 22, groups = { "REQ_918_B20_40512" }) 
             public static void B20_405_TS_22() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_405_TS_22","Borrower Registration-->newloan(SLOC)-->1st deposit nd return-->2nd deposit and return-->store age grace days-->EOD");
 					FileName = "QF-918-022.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.chargeback(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.chargeback1(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.History(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_405_TS_22");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_405_TS_22");

 	   				}
 					
 			}
             
             @Test(priority = 23, groups = { "REQ_918_B20_40512" }) 
             public static void B20_405_TS_23() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_405_TS_23","Borrower Registration-->newloan(SLOC)-->1st deposit nd return-->2nd deposit and return-->store age grace days-->EOD");
 					FileName = "QF-918-023.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL); 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.chargeback(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCEODDeposit.eodDeposit(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCSafeAssign.safeAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCDrawerAssign.drawerAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.History(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_405_TS_23");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_405_TS_23");

 	   				}
 					
 			}
             
             @Test(priority = 24, groups = { "REQ_918_B20_405" }) 
             public static void B20_405_TS_24() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_405_TS_24","Borrower Registration-->newloan(SLOC)-->1st deposit nd return-->2nd deposit and return-->store age grace days-->EOD");
 					FileName = "QF-918-024.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL); 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.chargeback(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRHistory.History(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_405_TS_24");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_405_TS_24");

 	   				}
 					
 			}
             
             @Test(priority = 25, groups = { "REQ_918_B20_405" }) 
             public static void B20_405_TS_25() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_405_TS_25","Borrower Registration-->newloan-->1st deposit-->2nd deposit and return-->store age grace days-->EOD");
 					FileName = "QF-918-025.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCEODDeposit.eodDeposit(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCSafeAssign.safeAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCDrawerAssign.drawerAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.history(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_405_TS_25");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_405_TS_25");

 	   				}
 					
 			}
             
             @Test(priority = 26, groups = { "REQ_918_B20_405" }) //post default inprogress
             public static void B20_405_TS_26() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_405_TS_26","Borrower Registration-->newloan(SLOC)-->1st deposit nd return-->2nd deposit and return-->store age grace days-->EOD");
 					FileName = "QF-918-026.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCEODDeposit.eodDeposit(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCSafeAssign.safeAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCDrawerAssign.drawerAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.history(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_405_TS_26");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_405_TS_26");

 	   				}
 					
 			}
             
             @Test(priority = 27, groups = { "REQ_918_B20_405" }) //post default inprogress
             public static void B20_405_TS_27() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_405_TS_27","Borrower Registration-->newloan-->1st deposit nd return-->2nd deposit and return-->store age grace days-->EOD");
 					FileName = "QF-918-027.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCEODDeposit.eodDeposit(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCSafeAssign.safeAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCDrawerAssign.drawerAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.history(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_405_TS_27");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_405_TS_27");

 	   				}
 					
 			}
             
             @Test(priority = 28, groups = { "REQ_918_B20_405" }) //safe deposit application execption inprogress
             public static void B20_405_TS_28() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_405_TS_28","Borrower Registration-->newloan-->store age to 15 days-->conversion-->cmg-->safe deposit-->");
 					FileName = "QF-918-028.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCConversion.LOCConversion(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
							VQCInternalTransfer.internalTransfer(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
 							
							
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_405_TS_28");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_405_TS_28");

 	   				}
 					
 			}
             
             @Test(priority = 29, groups = { "REQ_918_B20_405" }) 
             public static void B20_405_TS_29() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_405_TS_29","Borrower Registration-->newloan-->store age to 15 days-->conversion");
 					FileName = "QF-918-029.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCConversion.LOCConversion(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_405_TS_29");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_405_TS_29");

 	   				}
 					
 			}
             
             @Test(priority = 30, groups = { "REQ_918_B20_405" }) 
             public static void B20_405_TS_30() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_405_TS_30","Borrower Registration-->newloan(SLOC)-->1st deposit nd return-->2nd deposit and return-->store age grace days-->EOD");
 					FileName = "QF-918-030.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							AQCCSR_Deposit.deposit(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.adminLogin(SSN, NextDueDate);
 							JQCACHProcessing.ACHProcess(SSN, NextDueDate);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL); 							
 							QCCSRLoginLogout.adminLogin(SSN, AppURL);
 							AQCAdminACHReturn.achreturn(SSN, AppURL);
 							QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCEODDeposit.eodDeposit(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCSafeAssign.safeAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCDrawerAssign.drawerAssign(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRHistory.history(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_405_TS_30");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_405_TS_30");

 	   				}
 					
 			}
             
             @Test(priority = 41, groups = { "REQ_9181" }) //inprogress
             public static void B20_404_TS_41() throws Exception {
 				
 				try{
 					test = reports.startTest("B20_404_TS_41","Borrower Registration-->newloan-->1st deposit nd return-->2nd deposit and return-->store age grace days-->EOD");
 					FileName = "QF-918-041.xls";

 					TestData = new ExcelNew(System.getProperty("user.dir")
 							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 					String sheetName = "Start";
 					int lastrow = TestData.getLastRow("Start");
 					System.out.println(lastrow);
 					for (int row = 2; row <= lastrow; row++) {

 						String RunFlag = TestData.getCellData(sheetName, "Run", row);
 					
 						if (RunFlag.equals("Y")) {

 						
 							SSN = TestData.getCellData(sheetName, "SSN", row);
 							
 							/*QCCSRLoginLogout.login(SSN, AppURL);
 							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCCSRNewLoan2.newLoan(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							JQCPayment.payment(SSN, AppURL);
 							QCCSRLoginLogout.logout(SSN, AppURL);
 							QCCSRLoginLogout.login(SSN, AppURL);
							VQCInternalTransfer.internalTransfer(SSN, AppURL);
							QCCSRLoginLogout.login(SSN, AppURL);
							QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);*/
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
 							QCCSRLoginLogout.login(SSN, AppURL);
 							QCEODDeposit.eodDeposit(SSN, AppURL);
 							}
 						
 						}
 				}
 					catch (Exception e) {
 	   					
 	   					String screenshotPath = getScreenhot(driver, "B20_404_TS_41");
 	   					test.log(LogStatus.ERROR, test.addScreenCapture(screenshotPath));

 	   					test.log(LogStatus.ERROR, "Unable to start scenario B20_404_TS_41");

 	   				}
 					
 			}
             
             
             
             
             
               @BeforeClass(alwaysRun = true)
	public void setup() throws IOException {

		try {

			// prop=prop.getProperty("user.dir")+"/Tests/Objects.properties";
			BufferedReader reader;
			
			try {
				reader = new BufferedReader(
						new FileReader("C:/QC_Batch11/QC_Sprint_Scenarios/src/test/java/tests/Objects.properties"));

				prop = new Properties();
				prop.load(reader);
				reader.close();
				AppURL = prop.getProperty("CSR_URL");

				BAdminURL = prop.getProperty("ADMIN_CSR_URL");
				String Bfilename = prop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";


				reports = new ExtentReports(
						System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") + Bfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");

		}

		catch (Exception e) {
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// setup for the QC Store " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to setup for the QC Store ");

		}

	}

	@BeforeMethod(alwaysRun = true)
	public void killProcess() throws Exception {

		try {

			Runtime.getRuntime().exec("taskkill /IM iexplore.exe /F");
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

			//Thread.sleep(5000); // Allow OS to kill the process
			System.out.println("killed the IE process LOC process");
			// break;

		} catch (Exception e) {
			// break;
			// continue;
		}
	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/QCStore/LOC/FailedTestsScreenshots/"
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

	// @AfterMethod(alwaysRun = true)

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
