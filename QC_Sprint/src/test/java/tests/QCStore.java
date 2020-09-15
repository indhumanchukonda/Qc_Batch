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
	public static String transaction_date;
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

	public static String customer_number;

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


	// V Jyothi scenarios

     //@Test(priority = 600, enabled = true,groups ="Jyothi")

	public static void Req_ID_548_PDL_01() throws Exception {

		FileName = "Req_ID_548_PDL_01.xls";
		test = reports.startTest("Req_ID_548_PDL_01", "Login with CSR(PDL)->Borrower->Courtecy Call->Search with Loan#->Click on Search button");

		TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {

				 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				System.out.println(AppURL);

			    VQCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				
				VQCCSRLoginLogout.login(SSN, AppURL);				
				//JQCCSRNewLoan.newLoan(SSN, AppURL);
				QCCSRNewLoan_pdl.newLoan(SSN, AppURL);
				
				VCSRLoginLogout.logout(SSN, AppURL);
				
				
				VQCCSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);				
				VCSRLoginLogout.logout(SSN, AppURL);
			
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRWriteOff.transfertocentral(SSN, AppURL);
				//VQCCSRWriteOff.writeoffCourtesy(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				
				
				
			/*	VQCCSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);*/

			}
		}

	}
	
	
   //@Test(priority = 611, enabled = true,groups ="Jyothi")

	public static void Req_ID_548_PDL_02() throws Exception {

		FileName = "Req_ID_548_PDL_02.xls";
		test = reports.startTest("Req_ID_548_PDL_02","Login with 2997 --> Borrower --> Courtecy Call --> Search with Loan# -->Click on Search button");

		TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {

				 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				System.out.println(AppURL);

				VQCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				
				VQCCSRLoginLogout.login(SSN, AppURL);
				//JQCCSRNewLoan.newLoan(SSN, AppURL);
				QCCSRNewLoan_pdl.newLoan(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				
				VQCCSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				
				VQCCSRLogin2997.login(SSN, AppURL);
				//VQCCSRWriteOffDepositReturn.writeoff(SSN, AppURL);
				
				   //VQCCSRWriteOff.writeoffCourtesy(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				
				
				/*VQCCSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
*/
			}
		}

	}
	
    @Test(priority = 612, enabled = true,groups ="Jyothi")

	public static void Req_ID_548_ILP_01() throws Exception {

		FileName = "Req_ID_548_ILP_01.xls";
		test = reports.startTest("Req_ID_548_ILP_01", "Login with CSR --> Borrower --> Courtecy Call --> Search with Loan# -->Click on Search button");

		TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {

				 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				System.out.println(AppURL);

				VQCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				AQCCSRNewLoan_ILP.newLoan(SSN, AppURL);
				//QCCSRNewLoan.newLoan(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRWriteOff.writeoffCourtesy(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				
				
				/*VQCCSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);*/

			}
		}

	}
	
	
    @Test(priority = 613, enabled = true,groups ="Jyothi")

	public static void Req_ID_548_ILP_02() throws Exception {

		FileName = "Req_ID_548_ILP_02.xls";
		test = reports.startTest("Req_ID_548_ILP_02", "Login with 2997 --> Borrower --> Courtecy Call --> Search with Loan# -->Click on Search button");

		TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {

				 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				System.out.println(AppURL);

				VQCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				AQCCSRNewLoan_ILP.newLoan(SSN, AppURL);
				//QCCSRNewLoan.newLoan(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				
				VQCCSRLogin2997.login(SSN, AppURL);
				//VQCCSRWriteOffDepositReturn.writeoff(SSN, AppURL);
				
				VCSRLoginLogout.logout(SSN, AppURL);
				

			}
		}

	}



   @Test(priority = 614, enabled = true,groups ="Jyothi")

	public static void Req_ID_548_TLP_01() throws Exception {

		FileName = "Req_ID_548_TLP_01.xls";
		test = reports.startTest("Req_ID_548_TLP_01", "Login with CSR --> Borrower --> Courtecy Call --> Search with Loan# -->Click on Search button");

		TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {

				 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				System.out.println(AppURL);
 
				VQCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL); 
				//VQCCSRNewLoanTLP.newLoan(SSN, AppURL);
				TLP_AQCCSRNewLoan.newLoan(SSN, AppURL);
				
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRWriteOff.writeoffCourtesy(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				/*VQCCSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);*/

			}
		}

	}
	
   @Test(priority = 615, enabled = true,groups ="Jyothi")

	public static void Req_ID_548_TLP_02() throws Exception {

		FileName = "Req_ID_548_TLP_02.xls";
		test = reports.startTest("Req_ID_548_TLP_02", "Login with 2997 --> Borrower --> Courtecy Call --> Search with Loan# -->Click on Search button");

		TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";
		// int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {

				 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				System.out.println(AppURL);

				VQCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				//VQCCSRNewLoanTLP.newLoan(SSN, AppURL);
				TLP_AQCCSRNewLoan.newLoan(SSN, AppURL);
				
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				
				VQCCSRLogin2997.login(SSN, AppURL);
				//VQCCSRWriteOffDepositReturn.writeoff(SSN, AppURL);
				
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);

			}
		}

	}


   @Test(priority = 616, enabled = true,groups ="Jyothi")

	public static void Req_ID_548_LOC_01() throws Exception {

			FileName = "Req_ID_548_LOC_01.xls";
			test = reports.startTest("Req_ID_548_LOC_01", "Login with CSR --> Borrower --> Courtecy Call --> Search with Loan# -->Click on Search button");

			TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					VQCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					VCSRLoginLogout.logout(SSN, AppURL);
					VQCCSRLoginLogout.login(SSN, AppURL);
					 //  QCCSRNewLoan.newLoan(SSN, AppURL);
					ALOC_CSRNewLoan.newLoan(SSN, AppURL);
					VCSRLoginLogout.logout(SSN, AppURL);
					
					
					VQCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					VCSRLoginLogout.logout(SSN, AppURL);
					
					VQCCSRLoginLogout.login(SSN, AppURL);
					VQCCSRWriteOff.LOCwriteoffCourtesy(SSN, AppURL);
					VCSRLoginLogout.logout(SSN, AppURL);
					/*VQCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					VCSRLoginLogout.logout(SSN, AppURL);*/

				}
			}

		}

 @Test(priority = 617, enabled = true,groups ="Jyothi")

public static void Req_ID_548_LOC_02() throws Exception {

			FileName = "Req_ID_548_LOC_02.xls";
			test = reports.startTest("Req_ID_548_LOC_02", "Login with 2997 --> Borrower --> Courtecy Call --> Search with Loan# -->Click on Search button");

			TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					VQCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					VCSRLoginLogout.logout(SSN, AppURL);
					VQCCSRLoginLogout.login(SSN, AppURL);
					   //QCCSRNewLoan.newLoan(SSN, AppURL);
					ALOC_CSRNewLoan.newLoan(SSN, AppURL);
					VCSRLoginLogout.logout(SSN, AppURL);
					VQCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					VCSRLoginLogout.logout(SSN, AppURL);
					
					VQCCSRLogin2997.login(SSN, AppURL);
					//VQCCSRWriteOffDepositReturn.writeoff(SSN, AppURL);
					
					VCSRLoginLogout.logout(SSN, AppURL);
					/*VQCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					VCSRLoginLogout.logout(SSN, AppURL);*/

				}
			}

		}
//------------------------------------------------------------------0000---------------------------------------------------------//
		
	@Test(priority = 01, enabled = true,groups ="LOC_601")

	public static void TS_01_601_001() throws Exception {

					FileName = "TS_01_601_001.xls";
					test = reports.startTest("TS_01_601_001", "Login with 2997 --> Borrower --> Courtecy Call --> Search with Loan# -->Click on Search button");

					TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					int lastrow = TestData.getLastRow("Start");
					String sheetName = "Start";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);

							System.out.println(AppURL);

					/*		VQCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							VQCCSRLoginLogout.login(SSN, AppURL);
							RQCCSRNewLoan.newLoan(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							VQCCSRLoginLogout.login(SSN, AppURL);
							QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
							
							
							VCSRLoginLogout.logout(SSN, AppURL);
							VQCCSRLogin2997.login(SSN, AppURL);
							VQCCSRCourtesy.promisetoPay(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);*/
							try{
							DBScheduler.scheduler1025();
							Thread.sleep(8000);
							DBScheduler.scheduler116();
							Thread.sleep(8000);
							}
							catch(Exception e){
							test.log(LogStatus.FAIL, "Unable to Connect DB");
								
							}
							VQCAdminLoginLogout.login(SSN, SSN);
							VAdminachclear.achclear(driver, SSN, AppURL);
							VQCAdminLoginLogout.logout(SSN, SSN);
							
							/*VQCCSRLogin2997.login(SSN, AppURL);
							VQCCSRAchClear.achclearmenu(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);*/
							/*VQCCSRLogin2997.login(SSN, AppURL);
							VQCCSRAchClear.achcleardropdown(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
											
							
							VQCCSRLoginLogout.login(SSN, AppURL);
							QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);*/
							
							//VQCCSRLogin2997.login(SSN, AppURL);
							//VQCCSRWriteOffDepositReturn.writeoff(SSN, AppURL);
							
							//VCSRLoginLogout.logout(SSN, AppURL);
							/*VQCCSRLoginLogout.login(SSN, AppURL);
							QCCSRHistory.history(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);*/

						}
					}

				}
	
	
	@Test(priority = 02, enabled = true,groups ="LOC")

	public static void TS_01_601_002() throws Exception {

					FileName = "TS_01_601_002.xls";
					test = reports.startTest("TS_01_601_002", "Login with 2997 --> Borrower --> Courtecy Call --> Search with Loan# -->Click on Search button");

					TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					int lastrow = TestData.getLastRow("Start");
					String sheetName = "Start";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);

							System.out.println(AppURL);

							VQCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							VQCCSRLoginLogout.login(SSN, AppURL);
							RQCCSRNewLoan.newLoan(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							VQCCSRLoginLogout.login(SSN, AppURL);
							QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							VQCCSRLogin2997.login(SSN, AppURL);
							VQCCSRCourtesy.promisetoPay(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							try{
							DBScheduler.scheduler1025();
							Thread.sleep(8000);
							DBScheduler.scheduler116();
							Thread.sleep(8000);
							}
							catch(Exception e){
							test.log(LogStatus.FAIL, "Unable to Connect DB");
								
							}
							//VQCAdminLoginLogout.login(SSN, SSN);
							VAdminachclear.achclear(driver, SSN, AppURL);
							VQCAdminLoginLogout.logout(SSN, SSN);
							
							VQCCSRLogin2997.login(SSN, AppURL);
							VQCCSRAchClear.achclearmenu(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							VQCCSRLogin2997.login(SSN, AppURL);
							VQCCSRAchClear.achcleardropdown(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							
							
							
						/*	VQCCSRLoginLogout.login(SSN, AppURL);
							QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							
							VQCCSRLogin2997.login(SSN, AppURL);
							VQCCSRWriteOffDepositReturn.writeoff(SSN, AppURL);
							
							VCSRLoginLogout.logout(SSN, AppURL);*/
							/*VQCCSRLoginLogout.login(SSN, AppURL);
							QCCSRHistory.history(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);*/

						}
					}

				}
	
	//@Test(priority = 03, enabled = true,groups ="LOC_601")

		public static void TS_01_601_003() throws Exception {

						FileName = "TS_01_601_003.xls";
						test = reports.startTest("TS_01_601_003", "SLOC Login with 2997 --> Borrower --> Courtecy Call --> Search with Loan# -->Click on Search button");

						TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						int lastrow = TestData.getLastRow("Start");
						String sheetName = "Start";
						// int lastrow=TestData.getLastRow("Borrower");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
								String SSN = TestData.getCellData(sheetName, "SSN", row);

								System.out.println(AppURL);

								VQCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);
								VQCCSRLoginLogout.login(SSN, AppURL);
								RQCCSRNewLoan.newLoan(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);
								VQCCSRLoginLogout.login(SSN, AppURL);
								QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
								
								
								VCSRLoginLogout.logout(SSN, AppURL);
								VQCCSRLogin2997.login(SSN, AppURL);
								VQCCSRCourtesy.promisetoPay(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);
								try{
								DBScheduler.scheduler1025();
								Thread.sleep(8000);
								DBScheduler.scheduler116();
								Thread.sleep(8000);
								}
								catch(Exception e){
								test.log(LogStatus.FAIL, "Unable to Connect DB");
									
								}
								//VQCAdminLoginLogout.login(SSN, SSN);
								/*VAdminachclear.achclear(driver, SSN, AppURL);
								VQCAdminLoginLogout.logout(SSN, SSN);
								
								VQCCSRLogin2997.login(SSN, AppURL);
								VQCCSRAchClear.achclearmenu(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);
								VQCCSRLogin2997.login(SSN, AppURL);
								VQCCSRAchClear.achcleardropdown(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);*/
												
								
							/*	VQCCSRLoginLogout.login(SSN, AppURL);
								QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);
								
								VQCCSRLogin2997.login(SSN, AppURL);
								VQCCSRWriteOffDepositReturn.writeoff(SSN, AppURL);
								
								VCSRLoginLogout.logout(SSN, AppURL);*/
								/*VQCCSRLoginLogout.login(SSN, AppURL);
								QCCSRHistory.history(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);*/

							}
						}

					}
		//@Test(priority = 04, enabled = true,groups ="LOC1")

		public static void TS_01_601_004() throws Exception {

						FileName = "TS_01_601_004.xls";
						test = reports.startTest("TS_01_601_004", "Login with 2997 --> Borrower --> Courtecy Call --> Search with Loan# -->Click on Search button");

						TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						int lastrow = TestData.getLastRow("Start");
						String sheetName = "Start";
						// int lastrow=TestData.getLastRow("Borrower");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
								String SSN = TestData.getCellData(sheetName, "SSN", row);

								System.out.println(AppURL);

								/*VQCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);
								VQCCSRLoginLogout.login(SSN, AppURL);
								RQCCSRNewLoan.newLoan(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);*/
								VQCCSRLoginLogout.login(SSN, AppURL);
								QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);
								VQCCSRLogin2997.login(SSN, AppURL);
								VQCCSRCourtesy.promisetoPay(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);
								try{
								DBScheduler.scheduler1025();
								Thread.sleep(8000);
								DBScheduler.scheduler116();
								Thread.sleep(8000);
								}
								catch(Exception e){
								test.log(LogStatus.FAIL, "Unable to Connect DB");
									
								}
								//VQCAdminLoginLogout.login(SSN, SSN);
								VAdminachclear.achclear(driver, SSN, AppURL);
								VQCAdminLoginLogout.logout(SSN, SSN);
								
								VQCCSRLogin2997.login(SSN, AppURL);
								VQCCSRAchClear.achclearmenu(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);
								VQCCSRLogin2997.login(SSN, AppURL);
								VQCCSRAchClear.achcleardropdown(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);
								
								
								
							/*	VQCCSRLoginLogout.login(SSN, AppURL);
								QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);
								
								VQCCSRLogin2997.login(SSN, AppURL);
								VQCCSRWriteOffDepositReturn.writeoff(SSN, AppURL);
								
								VCSRLoginLogout.logout(SSN, AppURL);*/
								/*VQCCSRLoginLogout.login(SSN, AppURL);
								QCCSRHistory.history(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);*/

							}
						}

					}
		
		//@Test(priority = 07, enabled = true,groups ="LOC_601")

		public static void TS_01_601_007() throws Exception {

						FileName = "TS_01_601_007.xls";
						test = reports.startTest("TS_01_607_001", "ULOAC Login with 2997 --> Borrower --> Courtecy Call --> PTP - Partial Payment ---> Search with Loan# -->Click on Search button");

						TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						int lastrow = TestData.getLastRow("Start");
						String sheetName = "Start";
						// int lastrow=TestData.getLastRow("Borrower");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
								String SSN = TestData.getCellData(sheetName, "SSN", row);

								System.out.println(AppURL);

								/*VQCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);
								VQCCSRLoginLogout.login(SSN, AppURL);
								RQCCSRNewLoan.newLoan(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);
								VQCCSRLoginLogout.login(SSN, AppURL);
								QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);								
								
								VCSRLoginLogout.logout(SSN, AppURL);
								VQCCSRLogin2997.login(SSN, AppURL);
								VQCCSRCourtesy.promisetoPay(SSN, AppURL);*/
								
								VQCCSRLoginLogout.login(SSN, AppURL);
								
								ALOCPayments.payment(SSN, AppURL);
								
								/*ALOCPayments.payment(SSN, AppURL);
								ALOCPayments.payment(SSN, AppURL);*/
								
								JQCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);								
								QCInternalTransfer.internalTransfer(SSN, AppURL);								
								
							
								VCSRLoginLogout.logout(SSN, AppURL);
								try{
								DBScheduler.scheduler1025();
								Thread.sleep(8000);
								DBScheduler.scheduler116();
								Thread.sleep(8000);
								}
								catch(Exception e){
								test.log(LogStatus.FAIL, "Unable to Connect DB");
									
								}
								//VQCAdminLoginLogout.login(SSN, SSN);
								/*VAdminachclear.achclear(driver, SSN, AppURL);
								VQCAdminLoginLogout.logout(SSN, SSN);
								
								VQCCSRLogin2997.login(SSN, AppURL);
								VQCCSRAchClear.achclearmenu(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);
								VQCCSRLogin2997.login(SSN, AppURL);
								VQCCSRAchClear.achcleardropdown(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);*/
												
								
							/*	VQCCSRLoginLogout.login(SSN, AppURL);
								QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);
								
								VQCCSRLogin2997.login(SSN, AppURL);
								VQCCSRWriteOffDepositReturn.writeoff(SSN, AppURL);
								
								VCSRLoginLogout.logout(SSN, AppURL);*/
								/*VQCCSRLoginLogout.login(SSN, AppURL);
								QCCSRHistory.history(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);*/

							}
						}

					}


		
	
	//@Test(priority = 13, enabled = true,groups ="LOC2")

	public static void TS_01_601_013() throws Exception {

					FileName = "TS_01_601_013.xls";
					test = reports.startTest("TS_01_601_013", "NewLoan-->DefaultpaymentChek-->Clear from 2997");

					TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					int lastrow = TestData.getLastRow("Start");
					String sheetName = "Start";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);

							System.out.println(AppURL);

						/*	VQCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							VQCCSRLoginLogout.login(SSN, AppURL);
							RQCCSRNewLoan.newLoan(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							
							VQCCSRLoginLogout.login(SSN, AppURL);							
							RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);*/
							
							VQCCSRLoginLogout.login(SSN, AppURL);
							RQCCSRDefaultPayment.sdefaultpayment(SSN, AppURL);
							VQCCSRLoginLogout.login(SSN, AppURL);
							//RQCCSRInternalTransfer.internaltransfer(SSN, AppURL);
							/*AInternalTfAndCashManagement.internaltf(SSN, AppURL);

							VQCCSRLoginLogout.login(SSN, AppURL);
							QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);*/
						

						}
					}

				}
	//@Test(priority = 16, enabled = true,groups ="LOC2")

	public static void TS_01_601_016() throws Exception {

					FileName = "TS_01_601_016.xls";
					test = reports.startTest("TS_01_601_016", "Login with 2997 --> Borrower --> Courtecy Call --> Search with Loan# -->Click on Search button");

					TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					int lastrow = TestData.getLastRow("Start");
					String sheetName = "Start";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);

							System.out.println(AppURL);

							/*VQCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							VQCCSRLoginLogout.login(SSN, AppURL);
							RQCCSRNewLoan.newLoan(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							VQCCSRLoginLogout.login(SSN, AppURL);
							QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);*/
							VQCCSRLoginLogout.login(SSN, AppURL);
							VQCPayoff.payoffck(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							
						}
					}

				}
	
	//@Test(priority = 17, enabled = true,groups ="TLP")
	
    public static void B20_846_TS_1() throws Exception {

						FileName = "B20_846_TS_1.xls";
						test = reports.startTest("B20_846_TS_1", "Goto Admin Portal and provide credentials-->search with VIN and submit");

						TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						int lastrow = TestData.getLastRow("Start");
						String sheetName = "Start";
						// int lastrow=TestData.getLastRow("Borrower");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
								String SSN = TestData.getCellData(sheetName, "SSN", row);

								System.out.println(AppURL);

								VQCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);
								
								VQCCSRLoginLogout.login(SSN, AppURL);
								QCCSRNewLoan_TLP.newLoan(SSN, AppURL);
								//TLP_AQCCSRNewLoan.newLoan(SSN, AppURL);
								
								VCSRLoginLogout.logout(SSN, AppURL);
								
								VQCAdmin_BankruptcyTLP.Borrower_Search(SSN, AppURL);
								
								
							
							

							}
						}

					}
@Test(priority = 19, enabled = true,groups ="TLP")
	
    public static void B20_846_TS_3() throws Exception {

						FileName = "B20_846_TS_3.xls";
						test = reports.startTest("B20_846_TS_3", "Goto Admin Portal and provide credentials-->search with VIN and submit");

						TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						int lastrow = TestData.getLastRow("Start");
						String sheetName = "Start";
						// int lastrow=TestData.getLastRow("Borrower");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
								String SSN = TestData.getCellData(sheetName, "SSN", row);

								System.out.println(AppURL);

								VQCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);
								
								VQCCSRLoginLogout.login(SSN, AppURL);
								QCCSRNewLoan_TLP.newLoan(SSN, AppURL);
								   //TLP_AQCCSRNewLoan.newLoan(SSN, AppURL);
								
								VCSRLoginLogout.logout(SSN, AppURL);
								VQCCSRLoginLogout.login(SSN, AppURL);
								VQCCSRBorroweredit.Borroweredit(SSN, AppURL);
								VCSRLoginLogout.logout(SSN, AppURL);
									

							}
						}

					}

@Test(priority = 18, enabled = true,groups ="TLP")

public static void B20_846_TS_2() throws Exception {

					FileName = "B20_846_TS_2.xls";
					test = reports.startTest("B20_846_TS_2", "Goto Admin Portal and provide credentials-->search with VIN and submit");

					TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					int lastrow = TestData.getLastRow("Start");
					String sheetName = "Start";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);

							System.out.println(AppURL);

							VQCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							
							VQCCSRLoginLogout.login(SSN, AppURL);
							QCCSRNewLoan_TLP.newLoan(SSN, AppURL);
							   //TLP_AQCCSRNewLoan.newLoan(SSN, AppURL);
							
							VCSRLoginLogout.logout(SSN, AppURL);
							
							VQCAdmin_BankruptcyTLP.Bankruptcy(SSN, AppURL);
							
							
						
						

						}
					}

				}

@Test(priority = 20, enabled = true,groups ="TLP12")

public static void B20_846_TS_4() throws Exception {

					FileName = "B20_846_TS_4.xls";
					test = reports.startTest("B20_846_TS_4", "Goto Admin Portal and provide credentials-->search with VIN and submit");

					TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					int lastrow = TestData.getLastRow("Start");
					String sheetName = "Start";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);

							System.out.println(AppURL);

							/*VQCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							
							VQCCSRLoginLogout.login(SSN, AppURL);
							QCCSRNewLoan_TLP.newLoan(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);*/
							VQCCSRLoginLogout.login(SSN, AppURL);
							VQCCSRBorroweredit.Bankruptcy_csr(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
								

						}
					}

				}
	
@Test(priority = 21, enabled = true,groups ="TLP1")

public static void B20_846_TS_5() throws Exception {

					FileName = "B20_846_TS_5.xls";
					test = reports.startTest("B20_846_TS_5", "Goto Admin Portal and provide credentials-->search with VIN and submit");

					TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					int lastrow = TestData.getLastRow("Start");
					String sheetName = "Start";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);

							System.out.println(AppURL);

							VQCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							
							VQCCSRLoginLogout.login(SSN, AppURL);
							QCCSRNewLoan_TLP.newLoan(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							VQCCSRLoginLogout.login(SSN, AppURL);
							VQCCSRBorroweredit.New_Loan(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
								

						}
					}

				}
	
@Test(priority = 22, enabled = true,groups ="TLP")

public static void B20_846_TS_6() throws Exception {

					FileName = "B20_846_TS_6.xls";
					test = reports.startTest("B20_846_TS_6", "Goto Admin Portal and provide credentials-->search with VIN and submit");

					TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					int lastrow = TestData.getLastRow("Start");
					String sheetName = "Start";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);

							System.out.println(AppURL);

							VQCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							
							VQCCSRLoginLogout.login(SSN, AppURL);
							QCCSRNewLoan_TLP.newLoan(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							VQCCSRLoginLogout.login(SSN, AppURL);
							VQCCSRBorroweredit.Transaction(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
								

						}
					}

				}
	
//@Test(priority = 23, enabled = true,groups ="TLP")

public static void B20_846_TS_7() throws Exception {

					FileName = "B20_846_TS_7.xls";
					test = reports.startTest("B20_846_TS_7", "Goto Admin Portal and provide credentials-->search with VIN and submit");

					TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					int lastrow = TestData.getLastRow("Start");
					String sheetName = "Start";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);

							System.out.println(AppURL);

							/*VQCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);*/
							
							VQCCSRLoginLogout.login(SSN, AppURL);
							QCCSRNewLoan_TLP.newLoan(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							VQCCSRLoginLogout.login(SSN, AppURL);
							VQCCSRBorroweredit.Transaction(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
								

						}
					}

				}
	
	
@Test(priority = 24, enabled = true,groups ="TLP")

public static void B20_849_TS_1() throws Exception {

					FileName = "B20-849_TS_1.xls";
					test = reports.startTest("B20-849_TS_1", "Goto Admin Portal and provide credentials-->search with VIN and submit");

					TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					int lastrow = TestData.getLastRow("Start");
					String sheetName = "Start";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);

							System.out.println(AppURL);

							/*VQCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);*/
							
							/*VQCCSRLoginLogout.login(SSN, AppURL);
							QCCSRNewLoan_TLP.newLoan(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);*/
							
							VQCAdmin_BankruptcyTLP.Borrower_search_customer(SSN, AppURL);
							
							
						
						

						}
					}

				}

@Test(priority = 25, enabled = true,groups ="TLP")

public static void B20_849_TS_3() throws Exception {

					FileName = "B20-849_TS_3.xls";
					test = reports.startTest("B20-849_TS_3", "Goto Admin Portal and provide credentials-->search with VIN and submit");

					TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					int lastrow = TestData.getLastRow("Start");
					String sheetName = "Start";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {

							 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);

							System.out.println(AppURL);

							/*VQCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							*/
							VQCCSRLoginLogout.login(SSN, AppURL);
							VQCCSRBorroweredit.Universal_search(SSN, AppURL);
							VCSRLoginLogout.logout(SSN, AppURL);
							
							
							
							
						
						

						}
					}

				}



	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException {

		try {

			   //prop=prop.getProperty("user.dir")+"/Tests/Objects.properties";
			BufferedReader reader;
			BufferedReader Jreader;
			BufferedReader Rreader;
			BufferedReader Areader;
			BufferedReader Sreader;
			BufferedReader Vreader;

			/*try {
				reader = new BufferedReader(
						new FileReader("C:/QC_Batch_191/QC_Sprint/src/test/java/tests/Objects.properties"));

				prop = new Properties();
				prop.load(reader);
				//AppURL = prop.getProperty("CSR_URL");

				//BAdminURL = prop.getProperty("ADMIN_CSR_URL");
				String Bfilename = Vprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";


				reports = new ExtentReports(
						System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") + Bfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			try {
				Jreader = new BufferedReader(

						new FileReader("C:/QC_Batch_191/QC_Sprint/src/test/java/tests/JObjects.properties"));

				Jprop = new Properties();
				Jprop.load(Jreader);
				Jreader.close();
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

						new FileReader("C:/QC_Batch_191/QC_Sprint/src/test/java/tests/RObjects.properties"));

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
						new FileReader("C:/QC_Batch_191/QC_Sprint/src/test/java/tests/AObjects.properties"));
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

*/
			try {
			//System.out.println("In befor class");
				Vreader = new BufferedReader(
						new FileReader("C:/QC_Batch11/QC_Sprint/src/test/java/tests/VObjects.properties"));
				Vprop = new Properties();
				Vprop.load(Vreader);
				Vreader.close();
				csr_url = Vprop.getProperty("CSR_URL");
				
				csrloginpage = Vprop.getProperty("Login_Page");
				AdminURL = Vprop.getProperty("ADMIN_URL");
				String Vfilename = Vprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Vprop.getProperty("QC_Store_extent_report_path") + Vfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
			//System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/MicrosoftWebDriver.exe");
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

			//Runtime.getRuntime().exec("taskkill /IM iexplore.exe /F");
			//Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

			Thread.sleep(1000); // Allow OS to kill the process
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
			 test.log(LogStatus.FAIL, "Test Case Failed is"+result.getThrowable());

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
