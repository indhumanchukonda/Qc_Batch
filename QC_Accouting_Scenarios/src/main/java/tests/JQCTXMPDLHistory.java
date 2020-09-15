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


public class JQCTXMPDLHistory extends QCStore{
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
					    
					    	 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
							    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					
						 driver.findElement(By.name("transactionList")).sendKeys("History");
						 test.log(LogStatus.PASS, "Transaction Type is selected as History");
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 
						
						 Thread.sleep(3000);
			 //Validations
						 for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							                                                 //*[@id="transactionHistoryTable"]/tbody/tr/td[4]/table/tbody/tr[15]/td/text()
							 //String CSO_Fee_Due=driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[15]/td/span[2]")).getText();
						                                                                  	//*[@id="transactionHistoryTable"]/tbody/tr/td[3]/table/tbody/tr[18]/td/span[2]
							 String Earned_and_unpaid_interest=driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[18]/td/span[2]")).getText();
							                                                       //*[@id="transactionHistoryTable"]/tbody/tr/td[3]/table/tbody/tr[17]/td/span[2]
							 String Principal_Balance=driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[17]/td/span[2]")).getText();
								
					
						/*if(CSO_Fee_Due.equalsIgnoreCase("0.00"))
						{
							test.log(LogStatus.PASS, "Transaction CSO Fee Due->Expected value:"+CSO_Fee_Due +"; == Actual value:"+CSO_Fee_Due);
						}
						else
						{
							test.log(LogStatus.FAIL, "Transaction CSO Fee Due->Expected value:0.00" +"; not equals to Actual value:"+CSO_Fee_Due);

						}*/
						
						if(Earned_and_unpaid_interest.equalsIgnoreCase("0.00"))
						{
							test.log(LogStatus.PASS, "Transaction Earned_and_unpaid_interest->Expected value:"+Earned_and_unpaid_interest +"; == Actual value:"+Earned_and_unpaid_interest);
						}
						else
						{
							test.log(LogStatus.FAIL, "Transaction Earned_and_unpaid_interest->Expected value:0.00" +"; not equals to Actual value:"+Earned_and_unpaid_interest);

						}
						if(Principal_Balance.equalsIgnoreCase("0.00"))
						{
							test.log(LogStatus.PASS, "Transaction Principal_Balance->Expected value:"+Principal_Balance +"; == Actual value:"+Principal_Balance);
						}
						else
						{
							test.log(LogStatus.FAIL, "Transaction Principal_Balance->Expected value:0.00" +"; not equals to Actual value:"+Principal_Balance);

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