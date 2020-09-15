package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class VQCCSRVoid_PDL extends QCStore
{

	public static void payment(String SSN,String AppURL) throws Exception
	{
		
		
	
			int lastrow=TestData.getLastRow("Void");
			String sheetName="Void";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
									
					String PIN = TestData.getCellData(sheetName,"PIN",row);
			
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
					
					String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);
				
					String Scenario = TestData.getCellData(sheetName,"Scenario",row);
					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					String last4cheknum = TestData.getCellData(sheetName,"last4cheknum",row);
					 String SSN1 = SSN.substring(0, 3);
					 String SSN2 = SSN.substring(3,5);
					 String SSN3 = SSN.substring(5,9);
					 
					 ;
					
					Thread.sleep(3000);
				/*	if(Scenario.equalsIgnoreCase("Partial_Return_Payment"))
					{
						test.log(LogStatus.INFO,"Partial Payment Return Payment started");
					}
					else
					{
						test.log(LogStatus.INFO,"Partial Payment started");	
					}*/
					
				    driver.switchTo().frame("topFrame");
					driver.findElement(locator(Vprop.getProperty("transactions_tab"))).click();			
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					
					driver.findElement(By.cssSelector("li[id='911101']")).click();
					test.log(LogStatus.PASS, "Clicked on Transaction");		
					driver.switchTo().frame("main");	
					Thread.sleep(500);
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
					driver.findElement(locator(Vprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
					driver.findElement(locator(Vprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
					driver.findElement(locator(Vprop.getProperty("csr_new_loan_submit_button"))).click();
					test.log(LogStatus.PASS, "Clicked on submit Button");		
					for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);				
				    driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");					    					   					     
				    driver.findElement(locator(Vprop.getProperty("csr_new_loan_go_button"))).click();
				    test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				    Thread.sleep(5000);					  
					for( String winHandle1 : driver.getWindowHandles())
					{
					    driver.switchTo().window(winHandle1);
					}			;
					 driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					
					 //driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					 
					  //driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[9]/td[13]/input")).click();
					 driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
					                                
					  test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
					 Thread.sleep(5000);                            
					                                 
					     
					     //*[@id="go_Button"]
					    
						 Thread.sleep(5000);
						 driver.findElement(By.name("transactionList")).sendKeys("Void");
						 test.log(LogStatus.PASS, "Transaction Type is selected as Void");
						 driver.findElement(By.name("button")).click();
					     test.log(LogStatus.PASS, "Clicked on button");
						 test.log(LogStatus.PASS, "Clicked on GO Button");
						/* driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button");*/
						 Thread.sleep(3000);	          
						 driver.findElement(By.name("transactionDataBean.disbursementType")).sendKeys(TenderType);
						 test.log(LogStatus.PASS, "Tender Type is :"+TenderType);	
						 
						/* driver.findElement(By.name("transactionDataBean.monetaryCd")).sendKeys(DisbType);
					     test.log(LogStatus.PASS, "DisbType is :"+DisbType);
						*/
						 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
						 test.log(LogStatus.PASS, "Pin is entered");
						 driver.findElement(By.name("Submit22")).click();
						 test.log(LogStatus.PASS, "Clicked on Finish Void Partial Payment");
						 Thread.sleep(5000);
						
						 driver.findElement(By.name("checkyes")).click();
						 test.log(LogStatus.PASS,"Void NSF Payment Completed Successfully");
						 try { 
							    Alert alert = driver.switchTo().alert();
							    alert.accept();
							    //if alert present, accept and move on.														
								
							}
							catch (NoAlertPresentException e) {
							    //do what you normally would if you didn't have the alert.
							}
						break;
						}
						 driver.close();
					
						}
					}
		
		
	}
}
	


