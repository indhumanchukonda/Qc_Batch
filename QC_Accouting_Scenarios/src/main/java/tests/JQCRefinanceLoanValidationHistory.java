package tests;

import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class JQCRefinanceLoanValidationHistory extends QCStore{
	public static String ACH_type;
	public static String ACH_transaction;
	public static String ACH_status;
	public static String ACH_amount;
	public static String ACH_ABA_code;
	public static String ACH_check_acc_no;
	public static String ACH_effective_date;
	public static String ach_history_ach_type;
	public static String ach_history_ach_effective_date;
	public static String ach_history_ach_transaction;
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
	//public static String loc_history_Stmt_Date;
	public static String loc_history_Stmt_Date;
	public static String loc_history_Statement_Closing_Date;
	public static String loc_history_Previous_Balance;
	public static String loc_history_Min_Payment_Amt;
	public static String loc_history_New_Balance;
	public static String loc_history_Payment_Due_Date;
	public static String loc_history_Capitalization_Interest;
	public static String loc_history_Paid_Flag;

	public static void history(String SSN,String AppURL)
	{
		try{
			int lastrow=TestData.getLastRow("Borrower_Registration");
			String sheetName="Borrower_Registration";
			String sheetName_calc="HistoryFieldsValidation";
			String sheetName_new_loan="New_Loan";
			String sheetName_History="Payment";
			
			for(int row=2;row<=lastrow;row++)
			{	
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				String Payment = TestData.getCellData(sheetName_History,"Second_Payment",row);
				if(SSN.equals(RegSSN))
				{
					
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
					for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
					}
				    driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");
				    
				    driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button under search results");
					
					for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}				    
					 driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					   					    
					    Thread.sleep(5000);
					    
					    	 driver.findElement(By.xpath("//input[contains(@onclick,',1,')]")).click();
							 test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					
						 driver.findElement(By.name("transactionList")).sendKeys("History");
						 test.log(LogStatus.PASS, "Transaction Type is selected as History");
						 
						 driver.findElement(By.id("go_Button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 
						
						 Thread.sleep(5000);
			 //Validations
						 for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 
							 String NewLoan_Amt=driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[5]/td/span[2]")).getText();
							 test.log(LogStatus.PASS, "Getting the New Loan Amount: "+NewLoan_Amt);
							 
							 driver.findElement(By.id("back")).click();
							 test.log(LogStatus.PASS, "Clicked on Back button in the History Screen");
							 Thread.sleep(3000);
							 
							 driver.findElement(By.xpath("//input[@value='Back' and @type='Button']")).click();
							 test.log(LogStatus.PASS, "Clicked on Back Button under Transaction selection section");
							 Thread.sleep(500);
							 
							 driver.findElement(By.id("showMore-1")).click();
							 test.log(LogStatus.PASS, "Clicked on show More details button");
							 Thread.sleep(500);
							 
							 driver.findElement(By.xpath("//input[contains(@onclick,',2,')]")).click();
							 test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					
						 driver.findElement(By.name("transactionList")).sendKeys("History");
						 test.log(LogStatus.PASS, "Transaction Type is selected as History");
						 
						 driver.findElement(By.id("go_Button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 
						
						 Thread.sleep(5000);
			 //Validations
						 for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 
							 String RollOver_Amt=driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr[16]/td[7]/font")).getText();
							 test.log(LogStatus.PASS, "Getting the Roll Over Amount: "+RollOver_Amt);
							 
							 String RollOver = RollOver_Amt.replaceFirst("-", "");
							 test.log(LogStatus.PASS, "Removing - in the Roll Over Amount: "+RollOver);
							 
						if(NewLoan_Amt.equalsIgnoreCase(RollOver))
						{
							test.log(LogStatus.PASS, "Loan Amount->Expected value:"+RollOver +"; == Actual value:"+NewLoan_Amt);
						}
						else
						{
							test.log(LogStatus.FAIL, "Loan Amount->Expected value:"+RollOver +"; not equals to Actual value:"+NewLoan_Amt);

						}
						
						
						test.log(LogStatus.PASS, "History Transaction is successful");
						test.log(LogStatus.PASS, "**********************************************");

						break;
								
							 }
							
			}
						
							
							
		}
			
		
			
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//test.log(LogStatus.FAIL, MarkupHelper.createLabel("History is failed", ExtentColor.RED));
					test.log(LogStatus.FAIL,"History is failed");


				}
			}
}