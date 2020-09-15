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


public class JQCTXMPDLPrincipalHistory extends QCStore{
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
							 
							 if(Payment.equalsIgnoreCase("Yes")){
								 
								 String Interest=driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr[4]/td[11]/font")).getText();
								 test.log(LogStatus.PASS, "Getting Instrest from History is :"+Interest);

								 String CSO=driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr[4]/td[21]/font")).getText();
								 test.log(LogStatus.PASS, "Getting CSO Fee from History is :"+CSO);
								 
								 String InterestNew = Interest.replace("-", "");
								 test.log(LogStatus.PASS, "Removing - in Instrest value from History is :"+InterestNew);
								 
								 String CSONew = CSO.replace("-", "");
								 test.log(LogStatus.PASS, "Removing - in CSO value from History is :"+CSONew);
								 
								 float InterestNewInt=Float.valueOf(InterestNew);
								 test.log(LogStatus.PASS, "float Instrest value from History as :"+InterestNewInt);
								 
								 float CSONewInt=Float.valueOf(CSONew);
								 test.log(LogStatus.PASS, "float CSO value from History as :"+CSONewInt);
								 
								 float payment=InterestNewInt+CSONewInt;
								 test.log(LogStatus.PASS, "Adding CSO and Instrest value as :"+payment);
								
								 float Tender_AmtInt=Float.valueOf(Tender_Amt);
								 test.log(LogStatus.PASS, "float Tender_Amt from Payment as :"+Tender_AmtInt);
								 
								 float PrincipalInt=Tender_AmtInt-payment;
								 test.log(LogStatus.PASS, "float Principal balance as :"+PrincipalInt);
								 
								 DecimalFormat def = new DecimalFormat("0.00");
							     System.out.println("salary : " + def.format(PrincipalInt));
							     String priciplebalance = def.format(PrincipalInt);
								 
								 test.log(LogStatus.PASS, "String Principal balance as :"+priciplebalance);
								
								 String principal=driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr[4]/td[10]/font")).getText();
								 test.log(LogStatus.PASS, "Getting principal from History is :"+principal);
								 
								 String principalNew = principal.replace("-", "");
								 test.log(LogStatus.PASS, "Removing - in principal from History is :"+principalNew);
								 
								 if(InterestNew.equalsIgnoreCase(Payment_Inst))
									{
										test.log(LogStatus.PASS, "Interest Amount->Expected value:"+Payment_Inst +"; == Actual value:"+InterestNew);
									}
									else
									{
										test.log(LogStatus.FAIL, "Interest Amount->Expected value:"+Payment_Inst +"; not equals to Actual value:"+InterestNew);

									}
								 if(CSONew.equalsIgnoreCase(Payment_cso))
									{
										test.log(LogStatus.PASS, "CSO Amount->Expected value:"+Payment_cso +"; == Actual value:"+CSONew);
									}
									else
									{
										test.log(LogStatus.FAIL, "CSO Amount->Expected value:"+Payment_cso +"; not equals to Actual value:"+CSONew);

									}
								 if(priciplebalance.equalsIgnoreCase(principalNew))
									{
										test.log(LogStatus.PASS, "pricipal balance->Expected value:"+priciplebalance +"; == Actual value:"+principalNew);
									}
									else
									{
										test.log(LogStatus.FAIL, "pricipal balance->Expected value:"+priciplebalance +"; not equals to Actual value:"+principalNew);

									}
							 }
							 else{
							 String Interest=driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr[3]/td[11]/font")).getText();
							 test.log(LogStatus.PASS, "Getting Instrest from History is :"+Interest);

							 String CSO=driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr[3]/td[21]/font")).getText();
							 test.log(LogStatus.PASS, "Getting CSO Fee from History is :"+CSO);
							 
							 String InterestNew = Interest.replace("-", "");
							 test.log(LogStatus.PASS, "Removing - in Instrest value from History is :"+InterestNew);
							 
							 String CSONew = CSO.replace("-", "");
							 test.log(LogStatus.PASS, "Removing - in CSO value from History is :"+CSONew);
							 
							 float InterestNewInt=Float.valueOf(InterestNew);
							 test.log(LogStatus.PASS, "float Instrest value from History as :"+InterestNewInt);
							 
							 float CSONewInt=Float.valueOf(CSONew);
							 test.log(LogStatus.PASS, "float CSO value from History as :"+CSONewInt);
							 
							 float payment=InterestNewInt+CSONewInt;
							 test.log(LogStatus.PASS, "Adding CSO and Instrest value as :"+payment);
							
							 float Tender_AmtInt=Float.valueOf(Tender_Amt);
							 test.log(LogStatus.PASS, "float Tender_Amt from Payment as :"+Tender_AmtInt);
							 
							 float PrincipalInt=Tender_AmtInt-payment;
							 test.log(LogStatus.PASS, "float Principal balance as :"+PrincipalInt);
							 
							 DecimalFormat def = new DecimalFormat("0.00");
						     System.out.println("salary : " + def.format(PrincipalInt));
						     String priciplebalance = def.format(PrincipalInt);
							 
							 test.log(LogStatus.PASS, "String Principal balance as :"+priciplebalance);
							
							 String principal=driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr[3]/td[10]/font")).getText();
							 test.log(LogStatus.PASS, "Getting principal from History is :"+principal);
							 
							 String principalNew = principal.replace("-", "");
							 test.log(LogStatus.PASS, "Removing - in principal from History is :"+principalNew);
							 
							 if(InterestNew.equalsIgnoreCase(Payment_Inst))
								{
									test.log(LogStatus.PASS, "Interest Amount->Expected value:"+Payment_Inst +"; == Actual value:"+InterestNew);
								}
								else
								{
									test.log(LogStatus.FAIL, "Interest Amount->Expected value:"+Payment_Inst +"; not equals to Actual value:"+InterestNew);

								}
							 if(CSONew.equalsIgnoreCase(Payment_cso))
								{
									test.log(LogStatus.PASS, "CSO Amount->Expected value:"+Payment_cso +"; == Actual value:"+CSONew);
								}
								else
								{
									test.log(LogStatus.FAIL, "CSO Amount->Expected value:"+Payment_cso +"; not equals to Actual value:"+CSONew);

								}
							 if(priciplebalance.equalsIgnoreCase(principalNew))
								{
									test.log(LogStatus.PASS, "pricipal balance->Expected value:"+priciplebalance +"; == Actual value:"+principalNew);
								}
								else
								{
									test.log(LogStatus.FAIL, "pricipal balance->Expected value:"+priciplebalance +"; not equals to Actual value:"+principalNew);

								}
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