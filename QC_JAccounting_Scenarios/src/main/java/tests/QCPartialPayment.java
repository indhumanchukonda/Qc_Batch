package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class QCPartialPayment extends QCStore{

	public static void payment(String SSN,String AppURL) throws InterruptedException
	{
		int i;
		for(i=0;i<3;i++)
		{
		
	
			int lastrow=TestData.getLastRow("Payment");
			String sheetName="Partial Payment";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
					String PIN = TestData.getCellData(sheetName,"Password",row);
					String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);	
					String PaymentType = TestData.getCellData(sheetName,"PaymentType",row);
					String PaymentAmt = TestData.getCellData(sheetName,"Payment Amt",row);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO,"PartialPayment started");
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
								
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");					    					   					     
					driver.findElement(locator(Vprop.getProperty("csr_new_loan_go_button"))).click();
					test.log(LogStatus.PASS, "Clicked on GO Button under search results");
					Thread.sleep(5000);					  
						
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
					Thread.sleep(5000);
					
					
					driver.switchTo().frame("main");
					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as :" +TxnType);
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button ");
					Thread.sleep(5000);	
				
					
					try {
						Alert alert = driver.switchTo().alert();

						alert.accept();
						// if alert present, accept and move on.

					} catch (NoAlertPresentException e) {
						// do what you normally would if you didn't have
						// the alert.
					}
					Thread.sleep(500);
					
						driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
						test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
						
						driver.findElement(By.name("Card not available ")).click();
						test.log(LogStatus.PASS, "Clicked on Card not available");
						
						driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(PaymentAmt);
						test.log(LogStatus.PASS, "PaymentAmount entered :"+PaymentAmt);
						TenderAmount=driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
						driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(TenderAmount.trim());
						test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);	
						
						
						Select dropdown = new Select(driver.findElement(By.name("crditNbrFirst")));
						dropdown.selectByIndex(2);
						test.log(LogStatus.PASS, "Clicked on Option2");
						
				
					
					
					driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
					test.log(LogStatus.PASS, "Pin is entered as "+ PIN);
					driver.findElement(By.name("finish")).click();
					test.log(LogStatus.PASS, "Clicked on Finish Payment");

					Thread.sleep(5000);
					try { 
						Alert alert = driver.switchTo().alert();

						alert.accept();
						test.log(LogStatus.PASS, "Alert Handled successfully");
																				
					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					Thread.sleep(4000);
					if(driver.findElement(By.name("checkno")).isDisplayed())
					{
					test.log(LogStatus.PASS, "Payment transaction is successfully");
					}
					test.log(LogStatus.PASS,"****************************************");
					driver.close();
					
				}
			}
		}
	}
}	
			
	
	
		
	


	
	
	
	
		
	


	
		
			

		
	
	



