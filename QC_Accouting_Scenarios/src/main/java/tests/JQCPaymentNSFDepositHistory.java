package tests;

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
import org.testng.Assert;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class JQCPaymentNSFDepositHistory extends QCStore{
	public static String ACH_type;
	public static String ACH_transaction;
	public static String ACH_status;
	public static String ACH_amount;
	public static String ACH_ABA_code;
	public static String ACH_check_acc_no;
	public static String ach_history_ach_type;
	public static String ach_history_ach_transaction;
	public static String ach_history_ach_status;
	public static String ach_history_ach_amt;
	public static String ach_history_ach_check_acc_no;
	public static String ach_history_ach_ABA_code;

	public static void history(String SSN,String AppURL)
	{
		try{
			int lastrow=TestData.getLastRow("Borrower_Registration");
			String sheetName="Borrower_Registration";
			String sheetName_calc="HistoryFieldsValidation";
			String sheetName_new_loan="New_Loan";
	       
			

			for(int row=2;row<=lastrow;row++)
			{	
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				String Deposit = TestData.getCellData(sheetName_new_loan,"Deposit",row);
				
				if(SSN.equals(RegSSN))
				{
					
			        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			        String StateID = TestData.getCellData(sheetName,"StateID",row);
			        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
			        String Header = StateID+ "_" + ProductID;	      
			        String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;                                //column name
			        System.out.println(columnname);
			      
			       String NSF_Fee = TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",2);
System.out.println(sheetName_calc);
System.out.println(columnname+"_TxnHistory_FieldValue");

 
						
						   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					        
					        String SSNverify="XXX-XX-"+SSN3;
					    				       					        					        
					Thread.sleep(4000);
					driver.switchTo().frame("bottom");
					String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
				
					
					test.log(LogStatus.PASS, ""+Str_date);
						
					test.log(LogStatus.INFO, "Transaction History validation has started");

					driver.switchTo().defaultContent();	
					
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
			        driver.findElement(By.cssSelector("li[id='910000']")).click();	
	
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
					    
					    
					  // String loan_nbr= driver.findElement(locator(Aprop.getProperty("csr_loan_nbr"))).getText();
					  // test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
					    driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Clicked on GO Button under search results");
						// driver.findElement(By.name("button")).click();
						
					for(String winHandle : driver.getWindowHandles()){
						    driver.switchTo().window(winHandle);
							}				    
						 driver.switchTo().defaultContent();
						    driver.switchTo().frame("mainFrame");
						    driver.switchTo().frame("main");
					
						   // driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
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
						 
							
							 
									String NSF_Fee_Amt=driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr[4]/td[12]/font")).getText();
									test.log(LogStatus.PASS, "Return posting NSF value from History is :"+NSF_Fee_Amt);
																											
									
									if(Deposit.equalsIgnoreCase("two")){
										
									String Deposit_two=driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr[11]/td[12]/font")).getText();
									test.log(LogStatus.PASS, "Deposit_two NSF value from History is :"+Deposit_two);
									
									String Deposit_one=driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr[8]/td[12]/font")).getText();
									test.log(LogStatus.PASS, "Deposit_one NSF value from History is :"+Deposit_one);
									
									String Deposit_oneNew = Deposit_one.replace("-", "");
									test.log(LogStatus.PASS, "Removing - in Deposit_one NSF value from History is :"+Deposit_oneNew);
									
									 String Deposit_twoNew = Deposit_two.replace("-", "");
									 test.log(LogStatus.PASS, "Removing - in Deposit_two NSF value from History is :"+Deposit_twoNew);
									 
									 float Deposit_oneNewInt=Float.valueOf(Deposit_oneNew);
									 test.log(LogStatus.PASS, "float Deposit_one value from History as :"+Deposit_oneNewInt);
									 
									 float Deposit_twoNewInt=Float.valueOf(Deposit_twoNew);
									 test.log(LogStatus.PASS, "float Deposit_two value from History as :"+Deposit_twoNewInt);
									 
									 float payment=Deposit_oneNewInt+Deposit_twoNewInt;
									 test.log(LogStatus.PASS, "Adding Deposit_two and Deposit_one value as :"+payment);
									 
									 DecimalFormat def = new DecimalFormat("0.00");
								     System.out.println("Deposit : " + def.format(payment));
								     String priciplebalance = def.format(payment);
									 
									 String payment_str=String.valueOf(priciplebalance);
									 test.log(LogStatus.PASS, "Changing to String :"+payment_str);
									 
									if(NSF_Fee_Amt.equalsIgnoreCase(payment_str))
									{
										test.log(LogStatus.PASS, "Transaction NSF Fee->Expected value:"+NSF_Fee_Amt +"; == Actual value:"+payment_str);
									}
									else
									{
										test.log(LogStatus.FAIL, "Transaction NSF Fee->Expected value:"+NSF_Fee_Amt +"; not equals to Actual value:"+payment_str);

									}
									}else{
										//*[@id="transactionDetailsTable"]/tbody/tr[8]/td[12]/font
										
										String Deposit1=driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr[8]/td[12]/font")).getText();
										test.log(LogStatus.PASS, "Deposit NSF value from History is :"+Deposit1);
										
										String DepositNew = Deposit1.replace("-", "");
										test.log(LogStatus.PASS, "Removing - in Deposit NSF value from History is :"+DepositNew);
										
	
										String Deposit_two=driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr[9]/td[12]/font")).getText();
										test.log(LogStatus.PASS, "Deposit_two NSF value from History is :"+Deposit_two);
																			
										String Deposit_one=driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr[6]/td[12]/font")).getText();
										test.log(LogStatus.PASS, "Deposit_one NSF value from History is :"+Deposit_one);
										
										String Deposit_oneNew = Deposit_one.replace("-", "");
										test.log(LogStatus.PASS, "Removing - in Deposit_one NSF value from History is :"+Deposit_oneNew);
										
										 String Deposit_twoNew = Deposit_two.replace("-", "");
										 test.log(LogStatus.PASS, "Removing - in Deposit_two NSF value from History is :"+Deposit_twoNew);
										 
										 float Deposit_oneNewInt=Float.valueOf(Deposit_oneNew);
										 test.log(LogStatus.PASS, "float Deposit_one value from History as :"+Deposit_oneNewInt);
										 
										 float Deposit_twoNewInt=Float.valueOf(Deposit_twoNew);
										 test.log(LogStatus.PASS, "float Deposit_two value from History as :"+Deposit_twoNewInt);
										 
										 float payment=Deposit_oneNewInt+Deposit_twoNewInt;
										 test.log(LogStatus.PASS, "Adding Deposit_two and Deposit_one value as :"+payment);
										 
										 DecimalFormat def = new DecimalFormat("0.00");
									     System.out.println("Deposit : " + def.format(payment));
									     String priciplebalance = def.format(payment);
										 
										 String payment_str=String.valueOf(priciplebalance);
										 test.log(LogStatus.PASS, "Changing to String :"+payment_str);
										 
										if(payment_str.trim().equalsIgnoreCase("0.00")){
											if(NSF_Fee_Amt.equalsIgnoreCase(DepositNew))
											{
												test.log(LogStatus.PASS, "Transaction NSF Fee->Expected value:"+NSF_Fee_Amt +"; == Actual value:"+DepositNew);
											}
											else
											{
												test.log(LogStatus.FAIL, "Transaction NSF Fee->Expected value:"+NSF_Fee_Amt +"; not equals to Actual value:"+DepositNew);

											}
													
									}
									else{
										if(NSF_Fee_Amt.equalsIgnoreCase(payment_str))
										{
											test.log(LogStatus.PASS, "Transaction NSF Fee->Expected value:"+NSF_Fee_Amt +"; == Actual value:"+payment_str);
										}
										else
										{
											test.log(LogStatus.FAIL, "Transaction NSF Fee->Expected value:"+NSF_Fee_Amt +"; not equals to Actual value:"+payment_str);

										}
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