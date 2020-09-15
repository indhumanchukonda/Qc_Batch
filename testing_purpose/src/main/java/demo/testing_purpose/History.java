package demo.testing_purpose;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class History {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.ie.driver", "C:\\QC_Batch\\testing_purpose\\IEDriverServer.exe");
		WebDriver driver= new InternetExplorerDriver();
		driver.manage().window().maximize();
		
		driver.get("https://qclocalauto.qfund.net/cc/demoIndex.do");
		driver.findElement(By.xpath("/html/body/form/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[2]/input")).sendKeys("csr3235");
		driver.findElement(By.xpath("/html/body/form/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr[2]/td[2]/input")).sendKeys("1234");
		driver.findElement(By.xpath("/html/body/form/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr[3]/td[2]/input")).sendKeys("3235");
		driver.findElement(By.xpath("/html/body/form/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr[5]/td[2]/input")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
		Thread.sleep(5000);
		driver.switchTo().frame("topFrame");
        driver.findElement(By.cssSelector("li[id='910000']")).click();	
        Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("li[id='911101']")).click();			
		Thread.sleep(5000);	
		driver.switchTo().frame("main");	
		driver.findElement(By.name("ssn3")).sendKeys("2440");
		
		driver.findElement(By.name("submit1")).click();

		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
			}
		    driver.switchTo().defaultContent();
		    driver.switchTo().frame("mainFrame");
		    driver.switchTo().frame("main");
		    driver.findElement(By.name("button")).click();
		    Thread.sleep(5000);	
		    driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
		    Thread.sleep(10000);        ////*[@id="CustGrid"]/tbody/tr[2]/td[13]/table/tbody/tr/td[1]/select 
		    driver.findElement(By.xpath("//*[@id='CustGrid']/tbody/tr[2]/td[11]/table/tbody/tr/td[1]/select")).sendKeys("History");

		    driver.findElement(By.xpath("//*[@id='go_Button']")).click();
		    
		    String customer = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[2]/td/span[2]/span")).getText();
		    System.out.println("customer:" +customer);
		   //test.log(LogStatus.INFO, "customer" + customer);
		    
		    String customer_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[3]/td/span[2]/span")).getText();
		    System.out.println("customer_Nbr:" +customer_Nbr);
		    
		    String SSN_ITLN = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[4]/td/span[2]/span")).getText();
		    System.out.println("SSN_ITLN:" +SSN_ITLN);
		    
		    String primary_phone_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[5]/td/span[2]")).getText();
		    System.out.println("primary_phone_Nbr:" +primary_phone_Nbr);
		    
		    String phone_type = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[6]/td/span[2]")).getText();
		    System.out.println("phone type:" +phone_type);
		    
		    String state = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[7]/td/span[2]")).getText();
		    System.out.println("state:" +state);
		    
		    String customer_type = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[9]/td/span[2]")).getText();
		    System.out.println("customer_type:" +customer_type);
		    
		    //Customer Active Bank Information
		    String type_of_account = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[12]/td/span[2]")).getText();
		    System.out.println("type_of_account:" +type_of_account);
		    
		    String Routing_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[13]/td/span[2]")).getText();
		    System.out.println("Routing_Nbr:" +Routing_Nbr);
		    
		    String Account_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[14]/td/span[2]")).getText();
		    System.out.println("Account_Nbr:" +Account_Nbr);
		    
		    String Account_status = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[15]/td/span[2]")).getText();
		    System.out.println("Account_status:" +Account_status);
		    
		    String Bank_Name = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[16]/td/span[2]")).getText();
		    System.out.println("Bank_Name:" +Bank_Name);
		    
		    //UnderWriting Information
		    
		    //Promotion/Coupon Info
		    
		    String promotion_code = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[25]/td/span/span")).getText();
		    System.out.println("promotion_code:" +promotion_code);
		    /*
		    String promotion_discount = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[26]/td/span/span")).getText();
		    System.out.println("promotion_discount:" +promotion_discount);
		    */
		    //Employer Information
		    
		    String 	Primary_Source_Of_Income = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[2]/td/span[2]")).getText();
		    System.out.println("Primary_Source_Of_Income:" +Primary_Source_Of_Income);
		    
		    String Current_Employer = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[3]/td/span[2]")).getText();
		    System.out.println("Current_Employer:" +Current_Employer);
		    
		    String Net_Pay = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[4]/td/span[2]")).getText();
		    System.out.println("Net_pay:" +Net_Pay);
		    
		    String Gross_Pay = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[5]/td/span[2]")).getText();
		    System.out.println("Gross_Pay:" +Gross_Pay);
		    
		    String Pay_Frequency = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[6]/td/span[2]")).getText();
		    System.out.println("Pay_Frequency:" +Pay_Frequency);
		    
		    String Employer_Phone_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[7]/td/span[2]")).getText();
		    System.out.println("Employer_Phone_Nbr:" +Employer_Phone_Nbr);
		    
		    //Courtesy/Collection Information
		    String Courtesy_Consent = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[10]/td/span[2]")).getText();
		    System.out.println("Courtesy_Consent:" +Courtesy_Consent);
		    
		    String Consent_Type = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[11]/td/span[2]")).getText();
		    System.out.println("Consent_Type:" +Consent_Type);
		    
		    String Status = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[12]/td/span[2]")).getText();
		    System.out.println("Staus:" +Status);
		    
		    String CAD_Flag = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[14]/td/span[2]")).getText();
		    System.out.println("CAD_Flag:" +CAD_Flag);
		    
		    String DMC_Details = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[15]/td/span[2]")).getText();
		    System.out.println("DMC_Details:" +DMC_Details);
		    
		    String IS_Legal = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[20]/td/span[2]")).getText();
		    System.out.println("IS_Legal:" +IS_Legal);
		    
		    String IS_Garnishment = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[22]/td/span[2]")).getText();
		    System.out.println("IS_Garnishment:" +IS_Garnishment);
		    
		    String IS_Vpd = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[24]/td/span[2]")).getText();
		    System.out.println("IS_VPD:" +IS_Vpd);
		    
		    //Loan Account Status
		    
		    String Loan_Status = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[2]/td/span[2]")).getText();
		    System.out.println("Loan_Status:" +Loan_Status);
		    
		    String Balance_Status = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[3]/td/span[2]")).getText();
		    System.out.println("Balance_Status:" +Balance_Status);
		    
		    String Next_Due_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();
		    System.out.println("Next_Due_Date:" +Next_Due_Date);
		    
		    String Number_Of_Installmets_Due = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[5]/td/span[2]")).getText();
		    System.out.println("Number_Of_Installments_Due:" +Number_Of_Installmets_Due);
		    
		    String Latest_Payment_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[6]/td/span[2]")).getText();
		    System.out.println("Latest_Payment_Date:" +Latest_Payment_Date);
		    
		    String Pending_Bankruptcy = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[9]/td/span[2]")).getText();
		    System.out.println("Pending_Bankruptcy:" +Pending_Bankruptcy);
		    
		    String As_of_Today_Accrued_Intrest = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[13]/td/span[2]")).getText();
		    System.out.println("As_of_Today_Accrued_Intrest:" +As_of_Today_Accrued_Intrest);
		    
		    //Loan Balance Summery
		    
		    String Principle_Balance = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[16]/td/span[2]")).getText();
		    System.out.println("Principle_Balance:" +Principle_Balance);
		    
		    String Earned_and_unpaid_intrest = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[17]/td/span[2]")).getText();
		    System.out.println("Earned_and_unpaid_intrest:" +Earned_and_unpaid_intrest);
		    
		    String Return_Fee_Due = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[18]/td/span[2]")).getText();
		    System.out.println("Return_Fee_Due" +Return_Fee_Due);
		    
		    String Late_Fee_Due = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[19]/td/span[2]")).getText();
		    System.out.println("Late_Fee_Due:" +Late_Fee_Due);
		    
		    String Pay_off_Amt = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[20]/td/span[2]")).getText();
		    System.out.println("Pay_off_Amt:" +Pay_off_Amt);
		    
		    String Past_Due_Amt = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[21]/td/span[2]")).getText();
		    System.out.println("Past_Due_Amt:" +Past_Due_Amt);
		    
		    String Verification_Fee_Due = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[22]/td/span[2]")).getText();
		    System.out.println("Verification_Fee_Due:" +Verification_Fee_Due);
		    
		    String CSO_Fee_Due = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[23]/td/span[2]")).getText();
		    System.out.println("CSO_Fee_Due:" +CSO_Fee_Due);
		    
		    //Loan Paid To_Date Summery
		       
		    //*[@id="transactionHistoryTable"]/tbody/tr/td[3]/table/tbody/tr[26]/td/span/span
		    Thread.sleep(5000);
		    String Principal_Paid_to_date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[26]/td/span/span")).getText();
		    System.out.println("Principal_Paid_to_date:" +Principal_Paid_to_date);
		    
		    String Intrest_Paid_to_date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[27]/td/span/span")).getText();
		    System.out.println("Intrest_Paid_to_date" +Intrest_Paid_to_date);
		    
		    String Return_Fee_Paid_to_date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[28]/td/span[2]")).getText();
		    System.out.println("Return_Fee_Paid_to_date:" +Return_Fee_Paid_to_date);
		    
		    String Late_Fee_Paid_to_date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[29]/td/span[2]")).getText();
		    System.out.println("Late_Fee_Paid_to_date:" +Late_Fee_Paid_to_date);
		    
		    String Total_Paid_Amt = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[30]/td/span[2]")).getText();
		    System.out.println("Total_Paid_Amt:" +Total_Paid_Amt);
		    
		    String Orig_Fee_Paid = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[31]/td/span[2]")).getText();
		    System.out.println("Orig_Fee_Paid" +Orig_Fee_Paid);
		    
		    String Verification_Fee_Paid = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[32]/td/span[2]")).getText();
		    System.out.println("Verification_Fee_Paid:" +Verification_Fee_Paid);
		    
		    String Orig_Fee_Waived = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[33]/td/span[2]")).getText();
		    System.out.println("Orig_Fee_Waived:" +Orig_Fee_Waived);
		    
		    String CSO_Fee_Paid = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[34]/td/span[2]")).getText();
		    System.out.println("CSO_Fee_Paid:" +CSO_Fee_Paid);
		    
		    //Loan Account Information
		  
		    String Product_Name = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[2]/td/span/b")).getText();
		    System.out.println("Product_Name:" +Product_Name);
		    
		    String Product_Type = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[3]/td/span[2]")).getText();
		    System.out.println("Product_Type:" +Product_Type);
		    
		    String Loan_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[4]/td/span[2]")).getText();
		    System.out.println("Loan_Nbr:" +Loan_Nbr);
		    
		    String Loan_Amt = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[5]/td/span[2]")).getText();
		    System.out.println("Loan_Amt:" +Loan_Amt);
		    
		    String APR = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[6]/td/span[2]")).getText();
		    System.out.println("APR:" +APR);
		    
		    String Intrest_Fee = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[7]/td/span[2]")).getText();
		    System.out.println("Intrest_Fee" +Intrest_Fee);
		    
		    String Loan_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[8]/td/span[2]")).getText();
		    System.out.println("Loan_Date:" +Loan_Date);
		    
		    String Installment_Amt = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[9]/td/span[2]")).getText();
		    System.out.println("Installment_Amt:" +Installment_Amt);
		    
		    String Number_of_installments = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[10]/td/span[2]")).getText();
		    System.out.println("Number_of_installments:" +Number_of_installments);
		    
		    String Collateral_Type = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[11]/td/span[2]")).getText();
		    System.out.println("Collateral_Type:" +Collateral_Type);
		    
		    String Loan_Frequency = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[12]/td/span[2]")).getText();
		    System.out.println("Loan_Frequency:" +Loan_Frequency);
		    
		    String Origination_Store = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[13]/td/span[2]")).getText();
		    System.out.println("Origination_Store:" +Origination_Store);
		                                                            
		    String Verification_Fee = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[32]/td/span[2]")).getText();
		    System.out.println("Verification_Fee:" +Verification_Fee);
		                                               
		    String CSO_Fee = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[34]/td/span[2]")).getText();
		    System.out.println("CSO_Fee:" +CSO_Fee);
		    
		    String Available_Credit = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[16]/td/span[2]")).getText();
		    System.out.println("Available_Credit:" +Available_Credit);
		    
		    //Loan Bank Account Information
		    String Loan_ABA_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[19]/td/span[2]")).getText();
		    System.out.println("Loan_ABA_Nbr:" +Loan_ABA_Nbr);
		    
		    String Loan_Account_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[20]/td/span[2]")).getText();
		    System.out.println("Loan_Account_Nbr" +Loan_Account_Nbr);
		    
		    //Third Party Collection Info
		    String Account_Sold = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[26]/td/span[2]")).getText();
		    System.out.println("Account_Sold:" +Account_Sold);
		    
		    String Mark_For_Sale = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[29]/td/span[2]")).getText();
		    System.out.println("Mark_For_Sale:" +Mark_For_Sale);
		    
		    //Loan Tran Code
     	    List<WebElement> loan_tran_code = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[2]"));
		   int j=loan_tran_code.size();
		    System.out.println(j);
		    
		    Thread.sleep(5000);
		    for(int i=1;i<=loan_tran_code.size();i++)
		    {
		    	for(int j1=2;j1<=25;j1++)
		    	{
		   
		    	String loan_tran_code_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td["+j1+"]")).getText();
		    	System.out.print(loan_tran_code_list);
		    }
		    }
		   /* System.out.println("last row");
		    for(int k=loan_tran_code.size()-1; k<loan_tran_code.size();k++)
		    {
		    	String loan_tran_code_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[2]")).getText();
		    	System.out.println(loan_tran_code_list);
		    }
		    
		    //Loc Number
		    List<WebElement> loc_Nbr = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[3]"));
			   
			    for(int i=1;i<loc_Nbr.size();i++)
			    {
			    	String loc_Nbr_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[3]")).getText();
			    	System.out.println(loc_Nbr_list);
			    }
			    System.out.println("last row");
			    for(int k=loc_Nbr.size()-1; k<loc_Nbr.size();k++)
			    {
			    	String loc_Nbr_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[3]")).getText();
			    	System.out.println(loc_Nbr_list);
			    }
			    
			    //Other Loc Number
             List<WebElement> other_loc_Nbr = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[4]"));
			   
			    for(int i=1;i<other_loc_Nbr.size();i++)
			    {
			    	String other_loc_Nbr_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[4]")).getText();
			    	System.out.println(other_loc_Nbr_list);
			    }
			    System.out.println("last row");
			    for(int k=other_loc_Nbr.size()-1; k<other_loc_Nbr.size();k++)
			    {
			    	String other_loc_Nbr_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[4]")).getText();
			    	System.out.println(other_loc_Nbr_list);
			    }
			    
			    //Trans Date
             List<WebElement> Trans_date = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[5]"));
			   
			    for(int i=1;i<Trans_date.size();i++)
			    {
			    	String Trasn_date_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[5]")).getText();
			    	System.out.println(Trasn_date_list);
			    }
			    System.out.println("last row");
			    for(int k=Trans_date.size()-1; k<Trans_date.size();k++)
			    {
			    	String Trasn_date_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[5]")).getText();
			    	System.out.println(Trasn_date_list);
			    }
			    
			    //Transaction
              List<WebElement> Transaction = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[6]"));
			   
			    for(int i=1;i<Transaction.size();i++)
			    {
			    	String Transaction_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[6]")).getText();
			    	System.out.println(Transaction_list);
			    }
			    System.out.println("last row");
			    for(int k=Transaction.size()-1; k<Transaction.size();k++)
			    {
			    	String Transaction_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[6]")).getText();
		    	System.out.println(Transaction_list);
			    }
			    
			    //Total amt
              List<WebElement> Total_Amt = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[7]"));
			   
			    for(int i=1;i<Total_Amt.size();i++)
			    {
			    	String Total_Amt_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[7]")).getText();
			    	System.out.println(Total_Amt_list);
			    }
			    System.out.println("last row");
			    for(int k=Total_Amt.size()-1; k<Total_Amt.size();k++)
			    {
			    	String Total_Amt_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[7]")).getText();
			    	System.out.println(Total_Amt_list);
			    }
			    
			    //Tender Type
              List<WebElement> Tender_type = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[8]"));
			   
			    for(int i=1;i<Tender_type.size();i++)
			    {
			    	String Tender_type_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[8]")).getText();
			    	System.out.println(Tender_type_list);
			    }
			    System.out.println("last row");
			    for(int k=Tender_type.size()-1; k<Tender_type.size();k++)
			    {
			    	String Tender_type_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[8]")).getText();
			    	System.out.println(Tender_type_list);
			    }
			    
			    //Inst
              List<WebElement> Inst = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[9]"));
			   
			    for(int i=1;i<Inst.size();i++)
			    {
			    	String Inst_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[9]")).getText();
			    	System.out.println(Inst_list);
			    }
			    System.out.println("last row");
			    for(int k=Inst.size()-1; k<Inst.size();k++)
			    {
			    	String Inst_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[9]")).getText();
			    	System.out.println(Inst_list);
			    }
			    
			    //Adv Amt
             List<WebElement> Adv_amt = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[10]"));
			   
			    for(int i=1;i<Adv_amt.size();i++)
			    {
			    	String Adv_amt_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[10]")).getText();
			    	System.out.println(Adv_amt_list);
			    }
			    System.out.println("last row");
			    for(int k=Adv_amt.size()-1; k<Adv_amt.size();k++)
			    {
			    	String Adv_amt_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[10]")).getText();
			    	System.out.println(Adv_amt_list);
			    }
			    
			    //Interest
           List<WebElement> Interest = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[11]"));
			  
			    for(int i=1;i<Interest.size();i++)
			    {
			    	String Interest_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[11]")).getText();
			    	System.out.println(Interest_list);
			    }
			    System.out.println("last row");
			    for(int k=Interest.size()-1; k<Interest.size();k++)
			    {
			    	String Interest_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[11]")).getText();
			    	System.out.println(Interest_list);
			    }
			    
			    //NSF Fee
            List<WebElement> Nsf_Fee = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[12]"));
			
			    for(int i=1;i<Nsf_Fee.size();i++)
			    {
			    	String Nsf_Fee_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[12]")).getText();
			    	System.out.println(Nsf_Fee_list);
			    }
			    System.out.println("last row");
			    for(int k=Nsf_Fee.size()-1; k<Nsf_Fee.size();k++)
			    {
			    	String Nsf_Fee_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[12]")).getText();
			    	System.out.println(Nsf_Fee_list);
			    }
			    
			    //Waived NSF Fee
            List<WebElement> Waived_Nsf_Fee = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[13]"));
			  
			    for(int i=1;i<Waived_Nsf_Fee.size();i++)
			    {
			    	String Waived_Nsf_Fee_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[13]")).getText();
			    	System.out.println(Waived_Nsf_Fee_list);
			    }
			    System.out.println("last row");
			    for(int k=Waived_Nsf_Fee.size()-1; k<Waived_Nsf_Fee.size();k++)
			    {
			    	String Waived_Nsf_Fee_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[13]")).getText();
			    	System.out.println(Waived_Nsf_Fee_list);
			    }
			    
			    //Late Fee
            List<WebElement> Late_fee = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[14]"));
			 
			    for(int i=1;i<Late_fee.size();i++)
			    {
			    	String Late_fee_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[14]")).getText();
			    	System.out.println(Late_fee_list);
			    }
			    System.out.println("last row");
			    for(int k=Late_fee.size()-1; k<Late_fee.size();k++)
			    {
			    	String Late_fee_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[14]")).getText();
			    	System.out.println(Late_fee_list);
			    }
			    
			    //waived Late Fee
           List<WebElement> Waived_late_fee = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[15]"));
			 
			    for(int i=1;i<Waived_late_fee.size();i++)
			    {
			    	String Waived_late_fee_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[15]")).getText();
			    	System.out.println(Waived_late_fee_list);
			    }
			    System.out.println("last row");
			    for(int k=Waived_late_fee.size()-1; k<Waived_late_fee.size();k++)
			    {
			    	String Waived_late_fee_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[15]")).getText();
			    	System.out.println(Waived_late_fee_list);
			    }
			    
			    //Other Fee
           List<WebElement> Other_fee = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[16]"));
			  
			    for(int i=1;i<Other_fee.size();i++)
			    {
			    	String Other_fee_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[16]")).getText();
			    	System.out.println(Other_fee_list);
			    }
			    System.out.println("last row");
			    for(int k=Other_fee.size()-1; k<Other_fee.size();k++)
			    {
			    	String Other_fee_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[16]")).getText();
			    	System.out.println(Other_fee_list);
			    }
			    
			    //New Balance
          List<WebElement> New_balance = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[17]"));
			  
			    for(int i=1;i<New_balance.size();i++)
			    {
			    	String New_balance_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[17]")).getText();
			    	System.out.println(New_balance_list);
			    }
			    System.out.println("last row");
			    for(int k=New_balance.size()-1; k<New_balance.size();k++)
			    {
			    	String New_balance_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[17]")).getText();
			    	System.out.println(New_balance_list);
			    }
			    
			    //Prom/CoupAmt
         List<WebElement> CoupAmt = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[18]"));
			
			    for(int i=1;i<CoupAmt.size();i++)
			    {
			    	String CoupAmt_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[18]")).getText();
			    	System.out.println(CoupAmt_list);
			    }
			    System.out.println("last row");
			    for(int k=CoupAmt.size()-1; k<CoupAmt.size();k++)
			    {
			    	String CoupAmt_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[18]")).getText();
			    	System.out.println(CoupAmt_list);
			    }
			    
			    //Orig Fee
           List<WebElement> Orig_Fee = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[19]"));
			  
			    for(int i=1;i<Orig_Fee.size();i++)
			    {
			    	String Orig_Fee_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[19]")).getText();
			    	System.out.println(Orig_Fee_list);
			    }
			    System.out.println("last row");
			    for(int k=Orig_Fee.size()-1; k<Orig_Fee.size();k++)
			    {
			    	String Orig_Fee_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[19]")).getText();
			    	System.out.println(Orig_Fee_list);
			    }
			    
			    //Verification_fee
           List<WebElement> Verification_fee = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[20]"));
			 
			    for(int i=1;i<Verification_fee.size();i++)
			    {
			    	String Verification_fee_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[20]")).getText();
			    	System.out.println(Verification_fee_list);
			    }
			    System.out.println("last row");
			    for(int k=Verification_fee.size()-1; k<Verification_fee.size();k++)
			    {
			    	String Verification_fee_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[20]")).getText();
			    	System.out.println(Verification_fee_list);
			    }
			    
			    //CSO_fee
           List<WebElement> CSO_fee = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[21]"));
			  
			    for(int i=1;i<CSO_fee.size();i++)
			    {
			    	String CSO_fee_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[21]")).getText();
			    	System.out.println(CSO_fee_list);
			    }
			    System.out.println("last row");
			    for(int k=CSO_fee.size()-1; k<CSO_fee.size();k++)
			    {
			    	String CSO_fee_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[21]")).getText();
			    	System.out.println(CSO_fee_list);
			    }  
			    
			    //EMP_Nbr
            List<WebElement> EMP_Nbr = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[22]"));
			   
			    for(int i=1;i<EMP_Nbr.size();i++)
			    {
			    	String EMP_Nbr_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[22]")).getText();
			    	System.out.println(EMP_Nbr_list);
			    }
			    System.out.println("last row");
			    for(int k=EMP_Nbr.size()-1; k<EMP_Nbr.size();k++)
			    {
			    	String EMP_Nbr_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[22]")).getText();
			    	System.out.println(EMP_Nbr_list);
			    }  
			    
			    //Is_DND
            List<WebElement> Is_DND = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[23]"));
			  
			    for(int i=1;i<Is_DND.size();i++)
			    {
			    	String Is_DND_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[23]")).getText();
			    	System.out.println(Is_DND_list);
			    }
			    System.out.println("last row");
			    for(int k=Is_DND.size()-1; k<Is_DND.size();k++)
			    {
			    	String Is_DND_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[23]")).getText();
			    	System.out.println(Is_DND_list);
			    }  
			    
			    //Owner
			    
             List<WebElement> Owner = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[24]"));
			   
			    for(int i=1;i<Owner.size();i++)
			    {
			    	String Owner_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[24]")).getText();
			    	System.out.println(Owner_list);
			    }
			    System.out.println("last row");
			    for(int k=Owner.size()-1; k<Owner.size();k++)
			    {
			    	String Owner_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[24]")).getText();
			    	System.out.println(Owner_list);
			    }  
			    
			    //Online_Transaction
             List<WebElement> Online_Transaction = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']//td[25]"));
			   
			    for(int i=1;i<Online_Transaction.size();i++)
			    {
			    	String Online_Transaction_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[25]")).getText();
			    	System.out.println(Online_Transaction_list);
			    }
			    System.out.println("last row");
			    for(int k=Online_Transaction.size()-1; k<Online_Transaction.size();k++)
			    {
			    	String Online_Transaction_list = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+k+"]/td[25]")).getText();
			    	System.out.println(Online_Transaction_list);
			    }
*/		    driver.close();
	}

}
