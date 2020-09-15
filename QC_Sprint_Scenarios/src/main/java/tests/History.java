package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class History extends QCStore{
	
	public static String ACH_type;
	public static String ACH_transaction;
	public static String ACH_status;
	public static String ACH_amount;
	public static String ACH_ABA_code;
	public static String ACH_check_acc_no;
	public static String ach_history_ach_type;
	public static String ach_history_ach_transaction;
	public static String ach_history_ach_effective_date;
	public static String ach_history_ach_status;
	public static String ach_history_ach_amt;
	public static String ach_history_ach_check_acc_no;
	public static String ach_history_ach_ABA_code;
	public static String loc_history_transaction;
	public static String loc_history_tendertype;
	public static String loc_history_Tran_Amt;
	public static String loc_history_Int_Amt;
	public static String loc_history_adv_Amt;
	public static String loc_history_Lien_Amt;
	public static String loc_history_LateFee_Amt;
	public static String loc_history_Stmt_Nbr;
	public static String loc_history_Stmt_Date;
	public static String loc_history_Statement_Closing_Date;
	public static String loc_history_Previous_Balance;
	public static String loc_history_Min_Payment_Amt;
	public static String loc_history_New_Balance;
	public static String loc_history_Payment_Due_Date;
	public static String loc_history_Capitalization_Interest;
	public static String loc_history_Paid_Flag;
	public static String ACH_effective_date;

	
	public static void history(String SSN, String AppURL) throws InterruptedException
	{
		int lastrow=TestData.getLastRow("Borrower_Registration");
		String sheetName="Borrower_Registration";
		String sheetName_calc="HistoryFieldsValidation";
		String sheetName_new_loan="New_Loan";


		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				//String UserName = TestData.getCellData(sheetName,"UserName",row);
				String Password = TestData.getCellData(sheetName,"Password",row);
				//String StoreId = TestData.getCellData(sheetName,"StoreID",row);
				String store_id = nstoreid;
				String username = nusername;
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String Header = StateID+ "_" + ProductID;	      
				String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;                                //column name
				System.out.println(columnname);
				String LastName = TestData.getCellData(sheetName,"LastName",row);
				String FirstName = TestData.getCellData(sheetName,"FirstName",row);
				String customer_name=FirstName+" "+LastName;
				String AddressLine = TestData.getCellData(sheetName,"AddressLine",row);
				String City = TestData.getCellData(sheetName,"City",row);
				String State = TestData.getCellData(sheetName,"State",row);	      
				String ZipCode = TestData.getCellData(sheetName,"ZipCode",row);
				String MonthsAtAddress = TestData.getCellData(sheetName,"MonthsAtAddress",row);	     
				String Bank_ABARoutingNbr = TestData.getCellData(sheetName,"Bank_ABARoutingNbr",row);
				String Bank_ChkgAcctNbr = TestData.getCellData(sheetName,"Bank_ChkgAcctNbr",row);	       
				String Ctc_PrimaryPhone = TestData.getCellData(sheetName,"Ctc_PrimaryPhone",row);
				String Ctc_PhoneType = TestData.getCellData(sheetName,"Ctc_PhoneType",row);
				String Misc_PhotoIDNbr = TestData.getCellData(sheetName,"Misc_PhotoIDNbr",row);
				String Misc_IDExpDate = TestData.getCellData(sheetName,"Misc_IDExpDate",row);	   
				String Misc_PhotoIDType = TestData.getCellData(sheetName,"Misc_PhotoIDType",row);
				String BorrDOB = TestData.getCellData(sheetName,"Misc_DOB",row);
				String Income_IncomeType = TestData.getCellData(sheetName,"Income_IncomeType",row);
				String ESign_CollateralType = TestData.getCellData(sheetName_new_loan,"ESign_CollateralType",row);
				String courtesy_consent=TestData.getCellData(sheetName_new_loan,"ESign_CourtesyCallConsent",row);
				//  String courtesy_consent_status=TestData.getCellData(sheetName_new_loan,"ESign_Preference",row);
				String collateral_type=TestData.getCellData(sheetName_new_loan,"ESign_CollateralType",row);

				String primary_source_of_income = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",4);
				System.out.println(sheetName_calc);
				System.out.println(columnname+"_TxnHistory_FieldValue");

				String Income_Employer = TestData.getCellData(sheetName,"Income_Employer",row);
				String Income_WorkPhone = TestData.getCellData(sheetName,"Income_WorkPhone",row);
				String NetIncomeAmt = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",2);
				String GrossIncome = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",3);
				String pay_frequency=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",7);
				String loan_status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",4);
				String check_status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",5);
				String due_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",6);
				String latest_payment_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",7);
				String product_name=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",9);
				String product_type=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",10);
				String loan_amount=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",11);
				String finance_charge=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",12);
				String interest_rate=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",13);
				String loan_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",14);
				String min_pay_amt=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",15);
				String loan_frequency=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",17);
				String credot_or_verification_fee=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",18);
				String available_credit=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",18);


				String loan_balance_inf_Earned_and_unpaid_interest_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",20);
				String loan_balance_inf_Return_Fee_Due_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",21);
				String loan_balance_inf_Late_Fee_Due_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",22);
				String loan_balance_inf_Pay_Off_Amt_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",23);
				String loan_balance_inf_Past_Due_Amt_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",24);
				String loan_balance_inf_Remaining_Statement_Payment_Amount_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",25);
				String loan_balance_inf_Remaining_Min_Payment_Amount_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",26);
				String loan_balance_inf_Statement_Payment_Amount_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",27);
				String loan_balance_inf_Current_Principal_Balance_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",28);



				String principal_paid_to_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",30);

				String fee_paid_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",31);
				String return_paid_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",32);
				String late_paid_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",33);

				String total_paid_amountc=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",34);
				String repo_fee_paid=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",35);
  
				loc_history_transaction=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",2);
				loc_history_tendertype=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",3);
				loc_history_Tran_Amt=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",4);
				loc_history_adv_Amt=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",5);
				loc_history_Int_Amt=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",6);
				loc_history_Lien_Amt=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",7);
				loc_history_LateFee_Amt=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",8);
				//Statement values
				loc_history_Stmt_Nbr=TestData.getCellData(sheetName_calc,columnname+"_Statement_FieldValue",2);
				loc_history_Stmt_Date=TestData.getCellData(sheetName_calc,columnname+"_Statement_FieldValue",3);
				loc_history_Min_Payment_Amt=TestData.getCellData(sheetName_calc,columnname+"_Statement_FieldValue",4);
				loc_history_Payment_Due_Date=TestData.getCellData(sheetName_calc,columnname+"_Statement_FieldValue",5);
				loc_history_New_Balance=TestData.getCellData(sheetName_calc,columnname+"_Statement_FieldValue",6);
				loc_history_Previous_Balance=TestData.getCellData(sheetName_calc,columnname+"_Statement_FieldValue",7);
				loc_history_Paid_Flag=TestData.getCellData(sheetName_calc,columnname+"_Statement_FieldValue",8);
				loc_history_Capitalization_Interest=TestData.getCellData(sheetName_calc,columnname+"_Statement_FieldValue",9);
				loc_history_Statement_Closing_Date=TestData.getCellData(sheetName_calc,columnname+"_Statement_FieldValue",10);

				//ACH collateral details from sheet
				if(ESign_CollateralType.equals("ACH"))
				{
					//To read from Excel
					ACH_type=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",2);
					ACH_transaction=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",3);
					ACH_effective_date=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",4);
					ACH_status=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",5);
					ACH_amount=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",6);
					ACH_ABA_code=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",7);
					ACH_check_acc_no=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",8);


				}

				DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				String SSNverify="XXX-XX-"+SSN3;

				Thread.sleep(4000);
		test.log(LogStatus.INFO, "Transaction History validation has started");

		driver.switchTo().defaultContent();	

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
		driver.switchTo().frame("topFrame");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
		driver.findElement(By.cssSelector("li[id='910000']")).click();		
		test.log(LogStatus.PASS, "Clicked on Loan Transactions");
		Thread.sleep(1000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");

		driver.findElement(By.cssSelector("li[id='911101']")).click();			
		test.log(LogStatus.PASS, "Clicked on Transactions");		
		driver.switchTo().frame("main");		
		driver.findElement(By.name("ssn1")).sendKeys(SSN1);
		test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
		driver.findElement(By.name("ssn2")).sendKeys(SSN2);
		test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
		driver.findElement(By.name("ssn3")).sendKeys(SSN3);
		test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
		driver.findElement(By.name("submit1")).click();
		test.log(LogStatus.PASS, "Click on submit Button");		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");

		driver.findElement(By.name("button")).click();
		test.log(LogStatus.PASS, "Clicked on GO Button under search results");			    
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");

		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
		test.log(LogStatus.PASS, "Clicked on Go button under Loans section");

		driver.findElement(By.name("transactionList")).sendKeys("History");
		test.log(LogStatus.PASS, "Transaction Type is selected as History");
		driver.findElement(By.name("button")).click();
		test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");
		
		String customer = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[1]/table/tbody/tr[2]/td/span[2]")).getText();
		test.log(LogStatus.PASS, "Customer:" +customer);
		
		String customer_Nbr = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[1]/table/tbody/tr[3]/td/span[2]")).getText();
		 test.log(LogStatus.PASS, "customer_Nbr: " + customer_Nbr);
		    
		    String SSN_ITLN = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[1]/table/tbody/tr[4]/td/span[2]")).getText();
		    test.log(LogStatus.PASS, "SSN_ITLN:  " + SSN_ITLN);
		    
		    String primary_phone_Nbr = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[1]/table/tbody/tr[5]/td/span[2]")).getText();
		    test.log(LogStatus.PASS, "primary_phone_Nbr:  " + primary_phone_Nbr);
		    
		    String phone_type = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[1]/table/tbody/tr[6]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "phone type: " + phone_type);
		    
		    String state = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[1]/table/tbody/tr[7]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "state:  " + state);
		   
		   String Email = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[1]/table/tbody/tr[8]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Email: " +Email);
		    
		    String customer_type = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[1]/table/tbody/tr[9]/td/span[2]")).getText();
		    test.log(LogStatus.PASS, "customer_type: " + customer_type);
		    
		    //Customer Active Bank Information
		    test.log(LogStatus.INFO, "<b> <FONT color=blue style=Bold> Customer Active Bank Information </b>");
		    String type_of_account = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[1]/table/tbody/tr[12]/td/span[2]")).getText();
		    test.log(LogStatus.PASS, "type_of_account:  " + type_of_account);
		    
		    String Routing_Nbr = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[1]/table/tbody/tr[13]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Routing_Nbr:  " + Routing_Nbr);
		    
		    String Account_Nbr = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[1]/table/tbody/tr[14]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Account_Nbr:  " + Account_Nbr);
		    
		    String Account_status = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[1]/table/tbody/tr[15]/td/span[2]")).getText();
		 test.log(LogStatus.PASS, "Account_status:  " + Account_status);
		    
		    String Bank_Name = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[1]/table/tbody/tr[16]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Bank_Name:  " + Bank_Name);
		  
		    
		    
		    //Promotion/Coupon Information
		    test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> Promotion/Coupon Information </b>");
		    String Campaign_Name = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[1]/table/tbody/tr[19]/td/span[2]")).getText();
		    test.log(LogStatus.PASS, "Campaign_Name:" +Campaign_Name);
		    
		    String promotioncoupon_code = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[1]/table/tbody/tr[20]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "promotioncoupon_code:  " + promotioncoupon_code);
		    
		    
		    //Employer Information
		   test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> Employer Information </b>");
		    String 	Primary_Source_Of_Income = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[2]/table/tbody/tr[2]/td/span[2]")).getText();
		 test.log(LogStatus.PASS, "Primary_Source_Of_Income:  " + Primary_Source_Of_Income);
		    
		    String Current_Employer = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[2]/table/tbody/tr[3]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Current_Employer:  " + Current_Employer);
		    
		    String Net_Pay = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[2]/table/tbody/tr[4]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Net_pay:  " + Net_Pay);
		    
		    String Gross_Pay = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[2]/table/tbody/tr[5]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Gross_Pay:  " + Gross_Pay);
		    
		    String Pay_Frequency = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[2]/table/tbody/tr[6]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Pay_Frequency:  " + Pay_Frequency);
		    
		    String Employer_Phone_Nbr = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[2]/table/tbody/tr[7]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Employer_Phone_Nbr: " + Employer_Phone_Nbr);
		    
		    //Courtesy/Collection Information
		   test.log(LogStatus.INFO, "<b> <FONT color=blue style=Bold> Courtesy/Collection Information </b>");
		    String Courtesy_Consent = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[2]/table/tbody/tr[10]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Courtesy_Consent:  " + Courtesy_Consent);
		    
		    String Consent_Type = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[2]/table/tbody/tr[11]/td/span[2]")).getText();
		    test.log(LogStatus.PASS, "Consent_Type: " + Consent_Type);
		                                                  //*[@id="transactionHistoryTable"]/tbody/tr/td[2]/table/tbody/tr[12]/td/span[2]
		    String Status = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[2]/table/tbody/tr[12]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Staus: " + Status);
		  
		  String Assigned_To = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[2]/table/tbody/tr[13]/td/span[2]")).getText();
		    test.log(LogStatus.PASS, "Assigned_To:" +Assigned_To);
		    
		    String CAD_Flag = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[2]/table/tbody/tr[14]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "CAD_Flag:  " + CAD_Flag);
		    
		    String DMC_Details = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[2]/table/tbody/tr[15]/td/span[2]")).getText();
		 test.log(LogStatus.PASS, "DMC_Details: " + DMC_Details);
		 
		 String DMC_Customer = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[2]/table/tbody/tr[16]/td/span[2]")).getText();
		 test.log(LogStatus.PASS,"DMC_Customer: " +DMC_Customer);
		 
		 String DMC_Company = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[2]/table/tbody/tr[17]/td/span[2]")).getText();
		 test.log(LogStatus.PASS,"DMC_Company: " +DMC_Company);
		 
		 String DMC_Phone = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[2]/table/tbody/tr[18]/td/span[2]")).getText();
		 test.log(LogStatus.PASS,"DMC_Phone: " +DMC_Phone);
		 
		 String Legal_Date = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[2]/table/tbody/tr[19]/td/span[2]")).getText();
		 test.log(LogStatus.PASS,"Legal_Date: " +Legal_Date);
		 
		  String IS_Legal = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[2]/table/tbody/tr[20]/td/span[2]")).getText();
		test.log(LogStatus.PASS, "IS_Legal: " + IS_Legal);
		    
		String Granishment_Date = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[2]/table/tbody/tr[21]/td/span[2]")).getText();
		test.log(LogStatus.PASS,"Granishment_Date: " +Granishment_Date);
		
		 String IS_Garnishment = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[2]/table/tbody/tr[22]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "IS_Garnishment: " + IS_Garnishment);
		  
		   //Loan Account Status
		    test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> Loan Account Status </b>");
		    String Loan_Status = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[2]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Loan_Status:  " + Loan_Status);
		    
		    String Balance_Status = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[3]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Balance_Status: " + Balance_Status);
		    
		    String Next_Due_Date = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Next_Due_Date: " + Next_Due_Date);
		   
		    String Latest_Payment_Date = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[5]/td/span[2]")).getText();
		 test.log(LogStatus.PASS, "Latest_Payment_Date:  " + Latest_Payment_Date);
		 
		 String Default_Date = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[6]/td/span[2]")).getText();
		 test.log(LogStatus.PASS,"Default_Date: " +Default_Date);
		 
		 String Write_off_Date = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[7]/td/span[2]")).getText();
		 test.log(LogStatus.PASS,"Write_off_Date: " +Write_off_Date);
		    
		    String Pending_Bankruptcy = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[8]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Pending_Bankruptcy: " + Pending_Bankruptcy);
		  
		  String Bankruptcy_Filling_Date = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[9]/td/span[2]")).getText();
		  test.log(LogStatus.PASS,"Bankruptcy_Filling_Date: " +Bankruptcy_Filling_Date);
		  
		  String Bankruptcy_status = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[10]/td/span[2]")).getText();
		  test.log(LogStatus.PASS,"Bankruptcy_status: " +Bankruptcy_status);
		  
		  String Discharge_Date = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[11]/td/span[2]")).getText();
		  test.log(LogStatus.PASS,"Discharge_Date: " +Discharge_Date);
		
		    //Loan Balance Summery
		    test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> Loan Balance Summery </b>");
		                                                            //*[@id="transactionHistoryTable"]/tbody/tr/td[3]/table/tbody/tr[16]/td/span[2]
		    
		    String Earned_and_unpaid_intrest = driver.findElement(By.xpath("//	*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[14]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Earned_and_unpaid_intrest: " + Earned_and_unpaid_intrest);
		    
		    String Return_Fee_Due = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[15]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Return_Fee_Due: " + Return_Fee_Due);
		    
		    String Late_Fee_Due = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[16]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Late_Fee_Due: " + Late_Fee_Due);
		    
		    String Pay_off_Amt = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[17]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Pay_off_Amt: " + Pay_off_Amt);
		    
		    String Amount_Due_at_Refi = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[18]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Amount_Due_at_Refi: " + Amount_Due_at_Refi);
		    
		    String Payment_Amount = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[19]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Payment_Amount: " + Payment_Amount);
		    
		    String Statement_Payment_Amount = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[20]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Statement_Payment_Amount: " + Statement_Payment_Amount);
		   
		   String Prev_Statement_Payment_Amount_Satisfied = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[21]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Prev_Statement_Payment_Amount_Satisfied: " + Prev_Statement_Payment_Amount_Satisfied);
		   
		   String Current_Principle_Blance = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[22]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Current_Principle_Blance: " + Current_Principle_Blance);
		   
		   String Repo_Fee_Due = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[23]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Repo_Fee_Due: " + Repo_Fee_Due);
		    
		    //Loan Paid To_Date Summery
		       
		    //*[@id="transactionHistoryTable"]/tbody/tr/td[3]/table/tbody/tr[26]/td/span/span
		   test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> Loan Paid To_Date Summery </b>");
		    String Principal_Paid_To_Date = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[26]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Principal_Paid_To_Date: " + Principal_Paid_To_Date);
		    
		    String Intrest_Paid_to_date = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[27]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Intrest_Paid_to_date: " + Intrest_Paid_to_date);
		    
		    String Return_Fee_Paid_to_date = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[28]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Return_Fee_Paid_to_date: " + Return_Fee_Paid_to_date);
		    
		    String Late_Fee_Paid_to_date = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[29]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Late_Fee_Paid_to_date: " + Late_Fee_Paid_to_date);
		    
		    String Total_Paid_Amt = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[30]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Total_Paid_Amt: " + Total_Paid_Amt);
		    
		    String Repo_Fee_Paid = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[31]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Repo_Fee_Paid: " + Repo_Fee_Paid);
		    
		    //Loan Account Information
			  test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> Loan Account Information </b>");
			//*[@id="transactionHistoryTable"]/tbody/tr/td[4]/table/tbody/tr[2]/td/span/text()
			//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[2]/td
		    String Product_Name = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[2]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Product_Name: " + Product_Name);
		    
		    String Product_Type = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[3]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Product_Type: " + Product_Type);
		    
		    String Loan_Nbr = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[4]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Loan_Nbr: " + Loan_Nbr);
		    
		    String Credit_Limit = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[5]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Credit_Limit: " + Credit_Limit);
		    
		    String LOC_Amt = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[6]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "LOC_Amt: " + LOC_Amt);
		    
		    String Intrest_Fee = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[7]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Intrest_Fee: " + Intrest_Fee);
		    
		    String LOC_Date = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[8]/td/span[2]")).getText();
		 test.log(LogStatus.PASS, "LOC_Date:  " + LOC_Date);
		 
		    
		    String Collateral_Type = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[9]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Collateral_Type: " + Collateral_Type);
		    
		    String LOC_Frequency = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[10]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "LOC_Frequency:  " + LOC_Frequency);
		    
		    String Origination_Store = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[11]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Origination_Store:  " + Origination_Store);
		    
		    String Available_Credit = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[12]/td/span[2]")).getText();
		    test.log(LogStatus.PASS, "Available_Credit:  " + Available_Credit);
		    
		    String DMV_Fee = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[13]/td/span[2]")).getText();
		    test.log(LogStatus.PASS, "DMV_Fee:  " + DMV_Fee);
		    
		    String Waive_DMV_Fee = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[14]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Waive_DMV_Fee:  " + Waive_DMV_Fee);
		   
		   String Is_Unsecure = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[15]/td/span[2]")).getText();
		    test.log(LogStatus.PASS, "Is_Unsecure:  " + Is_Unsecure);
		    
		  //Loan Bank Account Information
		   test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> Loan Bank Account Information </b>");
		    String Loan_ABA_Nbr = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[21]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Loan_ABA_Nbr:  " + Loan_ABA_Nbr);
		    
		    String Loan_Account_Nbr = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[22]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Loan_Account_Nbr:  " + Loan_Account_Nbr);
		    
		    //Third Party Collection Information
		   test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> <FONT color=blue style=Bold> Third Party Collection Information </b>");
		   String Transfer_Out_Date = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[26]/td/span[2]")).getText();
		   test.log(LogStatus.PASS,"Transfer_Out_Date: " +Transfer_Out_Date);
		   
		   String Transfer_In_Date = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[27]/td/span[2]")).getText();
		   test.log(LogStatus.PASS,"Transfer_In_Date: " +Transfer_In_Date);
		   
		    String Account_Sold = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[28]/td/span[2]")).getText();
		  test.log(LogStatus.PASS, "Account_Sold:  " + Account_Sold);
		  
		  String Sold_To = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[29]/td/span[2]")).getText();
		  test.log(LogStatus.PASS,"Sold_To: " +Sold_To);
		  
		  String Sold_date = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[30]/td/span[2]")).getText();
		  test.log(LogStatus.PASS,"Sold_date: " +Sold_date);
		    
		    String Mark_For_Sale = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[31]/td/span[2]")).getText();
		   test.log(LogStatus.PASS, "Mark_For_Sale:  " + Mark_For_Sale);
		   
		   String Agency_Name = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[32]/td/span[2]")).getText();
		   test.log(LogStatus.PASS,"Agency_Name: " +Agency_Name);
		   
		   test.log(LogStatus.INFO, "<b> <FONT color=blue style=Bold>Customer Transaction field values at screen level</b>");
		   List<WebElement> list=driver.findElements(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr"));
		    int x=list.size();
		    //test.log(LogStatus.INFO, "x:" +x);
		   for(int i=2;i<list.size()-1;i++){
			    
				  //test.log(LogStatus.PASS, i-1 +  "Row");
				    	
				                        //*[@id="transactionDetailsTable"]/tbody/tr[1]/td[2]
				  String Store_Nbr = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+i+"]/td[2]")).getText();
				  test.log(LogStatus.PASS, "Store_Nbr:" + Store_Nbr);
				  
				  String Trans_date = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+i+"]/td[3]")).getText();
				  test.log(LogStatus.PASS, "Trans_date:" + Trans_date);
				  
				  String Transaction = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+i+"]/td[4]")).getText();
				  test.log(LogStatus.PASS, "Transaction:" + Transaction);
				  
				  String Tender_Type = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+i+"]/td[5]")).getText();
				  test.log(LogStatus.PASS, "Tender_Type:" + Tender_Type);
				 
				  String Tran_Amt = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+i+"]/td[6]")).getText();
				  test.log(LogStatus.PASS, "Tran_Amt:" + Tran_Amt);
				  
				  String Adv_Amt = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+i+"]/td[7]")).getText();
				  test.log(LogStatus.PASS, "Adv_Amt:" + Adv_Amt);
				  
				  String Int_amt = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+i+"]/td[8]")).getText();
				  test.log(LogStatus.PASS, "Int_amt:" + Int_amt);
				  
				  String cash_Advance_Fee_Amt = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+i+"]/td[9]")).getText();
				  test.log(LogStatus.PASS, "cash_Advance_Fee_Amt:" + cash_Advance_Fee_Amt);
				  
				  String Late_fee = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+i+"]/td[10]")).getText();
				  test.log(LogStatus.PASS, "Late_fee:" + Late_fee);
				  
				  String Nsf_Fee = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+i+"]/td[11]")).getText();
				  test.log(LogStatus.PASS, "Nsf_Fee:" + Nsf_Fee);
				  
				  String Other_Fee = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+i+"]/td[12]")).getText();
				  test.log(LogStatus.PASS, "Other_Fee:" + Other_Fee);
				  
				  String Repo_Fee = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+i+"]/td[13]")).getText();
				  test.log(LogStatus.PASS, "Repo_Fee:" + Repo_Fee);
				  
				  String Emp_Nbr = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+i+"]/td[14]")).getText();
				  test.log(LogStatus.PASS, "Emp_Nbr:" + Emp_Nbr);
				
				  String Transaction_Nbr = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+i+"]/td[15]")).getText();
				  test.log(LogStatus.PASS, "Transaction_Nbr:" + Transaction_Nbr);
				  
				  if(NetIncomeAmt.equalsIgnoreCase(Net_Pay))
					{
						test.log(LogStatus.PASS, "NetIncomeAmt->Expected value:"+NetIncomeAmt +"; == Actual value:"+Net_Pay);
					}
					else
					{
						test.log(LogStatus.FAIL, "NetIncomeAmt->Expected value:"+NetIncomeAmt +"; not equals to Actual value:"+Net_Pay);

					}
					if(GrossIncome.equalsIgnoreCase(Gross_Pay))
					{
						test.log(LogStatus.PASS, "GrossIncome->Expected value:"+GrossIncome +"; == Actual value:"+Gross_Pay);
					}
					else
					{
						test.log(LogStatus.FAIL, "GrossIncome->Expected value:"+GrossIncome +"; not equals to Actual value:"+Gross_Pay);

					}
					if(Income_PayFrequency.equalsIgnoreCase(Pay_Frequency))
					{
						test.log(LogStatus.PASS, "Income_PayFrequency->Expected value:"+Income_PayFrequency +"; == Actual value:"+Pay_Frequency);
					}
					else
					{
						test.log(LogStatus.FAIL, "Income_PayFrequency->Expected value:"+Income_PayFrequency +"; not equals to Actual value:"+Pay_Frequency);

					}
					if(loan_status.equalsIgnoreCase(Loan_Status))
					{
						test.log(LogStatus.PASS, "LOC_status->Expected value:"+loan_status +"; == Actual value:"+Loan_Status);
					}
					else
					{
						test.log(LogStatus.FAIL, "LOC_status->Expected value:"+loan_status +"; not equals to Actual value:"+Loan_Status);

					}
					/*if(check_status.equalsIgnoreCase(loan_status_inf_checkstatus))
					{
						test.log(LogStatus.PASS, "Balance_status->Expected value:"+check_status +"; == Actual value:"+loan_status_inf_checkstatus);
					}
					else
					{
						test.log(LogStatus.FAIL, "Balance_status->Expected value:"+check_status +"; not equals to Actual value:"+loan_status_inf_checkstatus);

					}*/
					if(due_date.equalsIgnoreCase(Next_Due_Date))
					{
						test.log(LogStatus.PASS, "due_date->Expected value:"+due_date +"; == Actual value:"+Next_Due_Date);
					}
					else
					{
						test.log(LogStatus.FAIL, "due_date->Expected value:"+due_date +"; not equals to Actual value:"+Next_Due_Date);

					}
					if(product_name.contains(product_name))
					{
						test.log(LogStatus.PASS, "product_name->Expected value:"+product_name +"; == Actual value:"+product_name);
					}
					else
					{
						test.log(LogStatus.PASS, "product_name->Expected value:"+product_name +"; not equals to Actual value:"+product_name);

					}
					if(product_type.equalsIgnoreCase(product_type))
					{
						test.log(LogStatus.PASS, "product_type->Expected value:"+product_type +"; == Actual value:"+product_type);
					}
					else
					{
						test.log(LogStatus.FAIL, "product_type->Expected value:"+product_type +"; not equals to Actual value:"+product_type);

					}
					if(loan_amount.equalsIgnoreCase(LOC_Amt))
					{
						test.log(LogStatus.PASS, "Credit Limit->Expected value:"+loan_amount +"; == Actual value:"+LOC_Amt);
					}
					else
					{
						test.log(LogStatus.FAIL, "Credit Limit->Expected value:"+loan_amount +"; not equals to Actual value:"+LOC_Amt);

					}
					/*if(finance_charge.equalsIgnoreCase(loan_account_inf_loc_amount))
					{
						test.log(LogStatus.PASS, "loan_amount->Expected value:"+finance_charge +"; == Actual value:"+loan_account_inf_loc_amount);
					}
					else
					{
						test.log(LogStatus.FAIL, "loan_amount->Expected value:"+finance_charge +"; not equals to Actual value:"+loan_account_inf_loc_amount);

					}*/
					if(interest_rate.equalsIgnoreCase(Intrest_Fee))
					{
						test.log(LogStatus.PASS, "interest_rate->Expected value:"+interest_rate +"; == Actual value:"+Intrest_Fee);
					}
					else
					{
						test.log(LogStatus.FAIL, "interest_rate->Expected value:"+interest_rate +"; not equals to Actual value:"+Intrest_Fee);

					}
					if(loan_date.equalsIgnoreCase(LOC_Date))
					{
						test.log(LogStatus.PASS, "LOC Date->Expected value:"+loan_date +"; == Actual value:"+LOC_Date);
					}
					else
					{
						test.log(LogStatus.FAIL, "LOC Date->Expected value:"+loan_date +"; not equals to Actual value:"+LOC_Date);

					}
					
					if(loan_balance_inf_Earned_and_unpaid_interest_test.equalsIgnoreCase(Earned_and_unpaid_intrest))
					{
						test.log(LogStatus.PASS, "Earned_and_unpaid_interest->Expected value:"+loan_balance_inf_Earned_and_unpaid_interest_test +"; == Actual value:"+Earned_and_unpaid_intrest);
					}
					else
					{
						test.log(LogStatus.FAIL, "Earned_and_unpaid_interest->Expected value:"+loan_balance_inf_Earned_and_unpaid_interest_test +"; not equals to Actual value:"+Earned_and_unpaid_intrest);

					}
					if(loan_balance_inf_Return_Fee_Due_test.equalsIgnoreCase(Return_Fee_Due))
					{
						test.log(LogStatus.PASS, "Return_Fee_Due->Expected value:"+loan_balance_inf_Return_Fee_Due_test +"; == Actual value:"+Return_Fee_Due);
					}
					else
					{
						test.log(LogStatus.FAIL, "Return_Fee_Due->Expected value:"+loan_balance_inf_Return_Fee_Due_test +"; not equals to Actual value:"+Return_Fee_Due);

					}
					if(loan_balance_inf_Late_Fee_Due_test.equalsIgnoreCase(Late_Fee_Due))
					{
						test.log(LogStatus.PASS, "Late_Fee_Due->Expected value:"+loan_balance_inf_Late_Fee_Due_test +"; == Actual value:"+Late_Fee_Due);
					}
					else
					{
						test.log(LogStatus.FAIL, "Late_Fee_Due->Expected value:"+loan_balance_inf_Late_Fee_Due_test +"; not equals to Actual value:"+Late_Fee_Due);

					}
					if(loan_balance_inf_Pay_Off_Amt_test.equalsIgnoreCase(Pay_off_Amt))
					{
						test.log(LogStatus.PASS, "Pay_Off_Amt->Expected value:"+loan_balance_inf_Pay_Off_Amt_test +"; == Actual value:"+Pay_off_Amt);
					}
					else
					{
						test.log(LogStatus.FAIL, "Pay_Off_Amt->Expected value:"+loan_balance_inf_Pay_Off_Amt_test +"; not equals to Actual value:"+Pay_off_Amt);

					}
					if(loan_balance_inf_Remaining_Statement_Payment_Amount_test.equalsIgnoreCase(Payment_Amount))
					{
						test.log(LogStatus.PASS, "Remaining_Statement_Payment_Amount->Expected value:"+loan_balance_inf_Remaining_Statement_Payment_Amount_test +"; == Actual value:"+Payment_Amount);
					}
					else
					{
						test.log(LogStatus.FAIL, "Remaining_Statement_Payment_Amount->Expected value:"+loan_balance_inf_Remaining_Statement_Payment_Amount_test +"; not equals to Actual value:"+Payment_Amount);

					}
					if(loan_balance_inf_Statement_Payment_Amount_test.equalsIgnoreCase(Statement_Payment_Amount))
					{
						test.log(LogStatus.PASS, "Statement_Payment_Amount->Expected value:"+loan_balance_inf_Statement_Payment_Amount_test +"; == Actual value:"+Statement_Payment_Amount);
					}
					else
					{
						test.log(LogStatus.FAIL, "Statement_Payment_Amount->Expected value:"+loan_balance_inf_Statement_Payment_Amount_test +"; not equals to Actual value:"+Statement_Payment_Amount);

					}
					if(loan_balance_inf_Current_Principal_Balance_test.equalsIgnoreCase(Current_Principle_Blance))
					{
						test.log(LogStatus.PASS, "Current_Principal_Balance->Expected value:"+loan_balance_inf_Current_Principal_Balance_test +"; == Actual value:"+Current_Principle_Blance);
					}
					else
					{
						test.log(LogStatus.FAIL, "Current_Principal_Balance->Expected value:"+loan_balance_inf_Current_Principal_Balance_test +"; not equals to Actual value:"+Current_Principle_Blance);

					}

					if(collateral_type.equalsIgnoreCase(Collateral_Type))
					{
						test.log(LogStatus.PASS, "collateral_type->Expected value:"+collateral_type +"; == Actual value:"+Collateral_Type);
					}
					else
					{
						test.log(LogStatus.FAIL, "collateral_type->Expected value:"+collateral_type +"; not equals to Actual value:"+Collateral_Type);

					}
					if(loan_frequency.toLowerCase().trim().equalsIgnoreCase(LOC_Frequency.toLowerCase().trim()))
					{
						test.log(LogStatus.PASS, "loan_frequency->Expected value:"+loan_frequency +"; == Actual value:"+LOC_Frequency);
					}
					else
					{
						test.log(LogStatus.FAIL, "loan_frequency->Expected value:"+loan_frequency +"; not equals to Actual value:"+LOC_Frequency);

					}
					if(available_credit.equalsIgnoreCase(Available_Credit))
					{
						test.log(LogStatus.PASS, "available_credit->Expected value:"+available_credit +"; == Actual value:"+Available_Credit);
					}
					else
					{
						test.log(LogStatus.FAIL, "available_credit->Expected value:"+available_credit +"; not equals to Actual value:"+Available_Credit);

					}
					if(courtesy_consent.equalsIgnoreCase(Courtesy_Consent))
					{
						test.log(LogStatus.PASS, "courtesy_consent->Expected value:"+courtesy_consent +"; == Actual value:"+Courtesy_Consent);
					}
					else
					{
						test.log(LogStatus.FAIL, "courtesy_consent->Expected value:"+courtesy_consent +"; not equals to Actual value:"+Courtesy_Consent);

					}
					if(principal_paid_to_date.equalsIgnoreCase(Principal_Paid_To_Date))
					{
						test.log(LogStatus.PASS, "principal_paid_to_date->Expected value:"+principal_paid_to_date +"; == Actual value:"+Principal_Paid_To_Date);
					}
					else
					{
						test.log(LogStatus.FAIL, "principal_paid_to_date->Expected value:"+principal_paid_to_date +"; not equals to Actual value:"+Principal_Paid_To_Date);

					}
					if(fee_paid_date.equalsIgnoreCase(Intrest_Paid_to_date))
					{
						test.log(LogStatus.PASS, "fee_paid_date->Expected value:"+fee_paid_date +"; == Actual value:"+Intrest_Paid_to_date);
					}
					else
					{
						test.log(LogStatus.FAIL, "fee_paid_date->Expected value:"+fee_paid_date +"; not equals to Actual value:"+Intrest_Paid_to_date);

					}
					if(return_paid_date.equalsIgnoreCase(Return_Fee_Paid_to_date))
					{
						test.log(LogStatus.PASS, "return_paid_date->Expected value:"+return_paid_date +"; == Actual value:"+Return_Fee_Paid_to_date);
					}
					else
					{
						test.log(LogStatus.FAIL, "return_paid_date->Expected value:"+return_paid_date +"; not equals to Actual value:"+Return_Fee_Paid_to_date);

					}
					if(late_paid_date.equalsIgnoreCase(Late_Fee_Paid_to_date))
					{
						test.log(LogStatus.PASS, "late_paid_date->Expected value:"+late_paid_date +"; == Actual value:"+Late_Fee_Paid_to_date);
					}
					else
					{
						test.log(LogStatus.FAIL, "late_paid_date->Expected value:"+late_paid_date +"; not equals to Actual value:"+Late_Fee_Paid_to_date);

					}

					if(total_paid_amountc.equalsIgnoreCase(Total_Paid_Amt))
					{
						test.log(LogStatus.PASS, "total_paid_amount->Expected value:"+total_paid_amountc +"; == Actual value:"+Total_Paid_Amt);
					}
					else
					{
						test.log(LogStatus.FAIL, "total_paid_amount->Expected value:"+total_paid_amountc +"; not equals to Actual value:"+Total_Paid_Amt);

					} 
					if(repo_fee_paid.equalsIgnoreCase(Repo_Fee_Paid))
					{
						test.log(LogStatus.PASS, "repo_fee_paid->Expected value:"+repo_fee_paid +"; == Actual value:"+Repo_Fee_Paid);
					}
					else
					{
						test.log(LogStatus.FAIL, "repo_fee_paid->Expected value:"+repo_fee_paid +"; not equals to Actual value:"+Repo_Fee_Paid);

					}
				  
				  
				  
		   }
		
	}

}
	}
}
