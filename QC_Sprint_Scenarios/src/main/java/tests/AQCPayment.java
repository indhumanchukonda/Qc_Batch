package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import com.relevantcodes.extentreports.LogStatus;


public class AQCPayment extends QCStore
{

	public static void payment(String SSN,String AppURL) throws InterruptedException
	{
		try{
			int lastrow=TestData.getLastRow("Payment");
			String sheetName="Payment";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					String cardType=TestData.getCellData(sheetName,"Card Type ",row);
					String cardNumber=TestData.getCellData(sheetName,"Debit Card No",row);
					String cardEx_month=TestData.getCellData(sheetName,"Expiry Month",row);
					String cardEx_Year=TestData.getCellData(sheetName,"Expiry Year",row);
					String cvv=TestData.getCellData(sheetName,"CVV",row);
					String CardHolderName=TestData.getCellData(sheetName,"CardHolderName",row);
					String PIN = TestData.getCellData(sheetName,"Password",row);
					String CheckNO = TestData.getCellData(sheetName,"ChkgAcctNbr_lastfour",row);	
					String PaymentType = TestData.getCellData(sheetName,"PaymentType",row);
					String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
					String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);

					test.log(LogStatus.INFO, "payment type is"+PaymentType);
					Thread.sleep(3000);
					test.log(LogStatus.INFO,"***************Payment started***************");
					driver.switchTo().frame("topFrame");
					
			        driver.findElement(By.cssSelector("li[id='910000']")).click();	
						
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(1000);
				
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
					Thread.sleep(2000);
								
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");					    					   					     
					driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[9]/input")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button under search results");
					Thread.sleep(5000);					  
					                           
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/table/tbody/tr/td/table/tbody/tr[5]/td[9]/input[1]")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
					Thread.sleep(5000);
					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as :" +TxnType);
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button ");
					Thread.sleep(500);	
					
					
					if(PaymentType.equalsIgnoreCase("Pay Installment Amt")){
						driver.findElement(By.id("PD4")).click();
						test.log(LogStatus.PASS, "Clicked on Pay Installment Amt check box ");
						TenderAmount=driver.findElement(By.name("instAmt")).getAttribute("value");
						
						driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
						test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
						driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TenderAmount.trim());
						test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);	
					}
					else if(PaymentType.equalsIgnoreCase("Pay Off the balance")){
						driver.findElement(By.id("PD3")).click();
						test.log(LogStatus.PASS, "Clicked on pay other amount check box ");
						TenderAmount=driver.findElement(By.name("payOff")).getAttribute("value");
						
						driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
						test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
						driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TenderAmount.trim());
						test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);	
					}
					else if(PaymentType.equalsIgnoreCase("Pay any other Amt")){
						
						driver.findElement(By.id("PD5")).click();
						test.log(LogStatus.PASS, "Clicked on pay other amount check box ");
						
						driver.findElement(By.name("requestBean.siilBean.payAmt")).sendKeys(PaymentAmount);
						test.log(LogStatus.PASS, "PaymentAmount entered :"+PaymentAmount);
						driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
						test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
						driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TenderAmount);
						test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);	
						}
					else if(PaymentType.equalsIgnoreCase("Default Payment"))
					{
						String paymentamt = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[1]/table/tbody/tr[3]/td[2]/input[2]")).getText();
						test.log(LogStatus.INFO, "payment amount is "+paymentamt);
						driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[1]/table/tbody/tr[4]/td[2]/select")).sendKeys(TenderType);
						driver.findElement(By.xpath("//*[@id='ccmoNbrFirst']/td[2]/input")).sendKeys("100");
						driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[1]/table/tbody/tr[14]/td[2]/input")).sendKeys(paymentamt);
						//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[4]/td/table/tbody/tr[3]/td/input")).sendKeys(keysToSend);
					}
					{
						
					}
			
					Thread.sleep(10000);	
					
					/*String paymentamount=driver.findElement(By.name("requestBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "PaymentAmount captured is :"+paymentamount);*/
					String pay_installment_amt = driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input[2]")).getText();
					test.log(LogStatus.PASS, "pay installment amt captured is :"+pay_installment_amt);
					Thread.sleep(2000);	
					if(TenderType.equalsIgnoreCase("Cash")){
					driver.findElement(By.name("requestBean.tenderType")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					}
					
					else if(TenderType.equalsIgnoreCase("Debit Card")){
						
						driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
						test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");
					
						driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);
						test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
						
						driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);
						test.log(LogStatus.PASS, "Card number is :" + cardNumber);

						driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);
						test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

						driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);
						test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_month);
					
						driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);
						test.log(LogStatus.PASS, "Enterd CVV " + cvv);
						driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);
						test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
				
						driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td/table[1]/tbody/tr[17]/td[2]/div[1]/input[3]")).click();
						test.log(LogStatus.PASS, "Clicked on add card button ");
						Thread.sleep(30000);
						
					}
					else if(TenderType.equalsIgnoreCase("Check"))
					{
					 
					driver.findElement(By.name("requestBean.siilBean.checkNbrFirst")).sendKeys(CheckNO);
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TenderAmount);
				    test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);	
					}
				

					Thread.sleep(2000);	
				
					
					
					driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
					test.log(LogStatus.PASS, "Pin is entered as "+ PIN);
					driver.findElement(By.name("finish")).click();
					test.log(LogStatus.PASS, "Clicked on Finish Partial Payment");

					Thread.sleep(5000);
					try { 
						Alert alert = driver.switchTo().alert();

						alert.accept();
						test.log(LogStatus.PASS, "Alert Handled successfully");
																				
					}
					catch (NoAlertPresentException e) {
						//do what you normally wou=ld if you didn't have the alert.
					}
					Thread.sleep(4000);
					/*if(driver.findElement(By.xpath("//input[@class='sortbuttons' and @value='OK']")).isDisplayed())
					{*/
					test.log(LogStatus.PASS, "Payment transaction is successfully");
					/*}
					else{
						test.log(LogStatus.INFO, "Payment transaction is successfully");
					}*/
					test.log(LogStatus.PASS,"****************************************");
					break;
					
				}
					}
		}
		catch(Exception ex)
		{
			
		}
	}
		
		public static void cashiercheck(String SSN,String AppURL) throws InterruptedException
		{
			try{
				int lastrow=TestData.getLastRow("Payment");
				String sheetName="Payment";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{
						String TxnType = TestData.getCellData(sheetName,"TxnType",row);
						String TenderType = TestData.getCellData(sheetName,"TenderType",row);
						String cardType=TestData.getCellData(sheetName,"Card Type ",row);
						String cardNumber=TestData.getCellData(sheetName,"Debit Card No",row);
						String cardEx_month=TestData.getCellData(sheetName,"Expiry Month",row);
						String cardEx_Year=TestData.getCellData(sheetName,"Expiry Year",row);
						String cvv=TestData.getCellData(sheetName,"CVV",row);
						String CardHolderName=TestData.getCellData(sheetName,"CardHolderName",row);
						String PIN = TestData.getCellData(sheetName,"Password",row);
						String CheckNO = TestData.getCellData(sheetName,"ChkgAcctNbr_lastfour",row);	
						String PaymentType = TestData.getCellData(sheetName,"PaymentType",row);
						String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
						String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);
						String SSN1 = SSN.substring(0, 3);
						String SSN2 = SSN.substring(3,5);
						String SSN3 = SSN.substring(5,9);

						test.log(LogStatus.INFO, "payment type is"+PaymentType);
						Thread.sleep(3000);
						test.log(LogStatus.INFO,"***************Payment started***************");
						driver.switchTo().frame("topFrame");
						
				        driver.findElement(By.cssSelector("li[id='910000']")).click();	
							
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");
						Thread.sleep(1000);
					
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
						Thread.sleep(2000);
									
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");					    					   					     
						driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[9]/input")).click();
						test.log(LogStatus.PASS, "Clicked on GO Button under search results");
						Thread.sleep(5000);					  
						                           
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/table/tbody/tr/td/table/tbody/tr[5]/td[9]/input[1]")).click();
						test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
						Thread.sleep(5000);
						driver.findElement(By.name("transactionList")).sendKeys(TxnType);
						test.log(LogStatus.PASS, "Transaction Type is selected as :" +TxnType);
						driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Clicked on Go button ");
						Thread.sleep(500);	
						
						
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[1]/table/tbody/tr[2]/td[2]/input[2]")).clear();
							driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[1]/table/tbody/tr[2]/td[2]/input[2]")).sendKeys(PaymentAmount);
							test.log(LogStatus.INFO, "payment amount is "+PaymentAmount);
							driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[1]/table/tbody/tr[3]/td[2]/select")).sendKeys(TenderType);
							test.log(LogStatus.PASS, "entered tender type as"+TenderType);
							driver.findElement(By.xpath("//*[@id='ccmoNbrFirst']/td[2]/input")).sendKeys("100");
							test.log(LogStatus.PASS, "entered cc/mo as 100");
							Thread.sleep(5000);
							driver.findElement(By.xpath("//*[@name='requestBean.tenderAmt']")).sendKeys(TenderAmount);
							//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[4]/td/table/tbody/tr[3]/td/input")).sendKeys(keysToSend);
					
							test.log(LogStatus.PASS, "entered tender amount as "+TenderAmount);
						
						
						//driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[4]/td/table/tbody/tr[3]/td/input")).sendKeys(PIN);
						test.log(LogStatus.PASS, "Pin is entered as "+ PIN);
						//driver.findElement(By.name("finish")).click();
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[4]/td/table/tbody/tr[5]/td[2]/input")).click();
						test.log(LogStatus.PASS, "Clicked on Finish Partial Payment");

						Thread.sleep(5000);
						try { 
							Alert alert = driver.switchTo().alert();

							alert.accept();
							test.log(LogStatus.PASS, "Alert Handled successfully");
																					
						}
						catch (NoAlertPresentException e) {
							//do what you normally wou=ld if you didn't have the alert.
						}
						Thread.sleep(4000);
						/*if(driver.findElement(By.xpath("//input[@class='sortbuttons' and @value='OK']")).isDisplayed())
						{*/
						test.log(LogStatus.PASS, "Payment transaction is successfully");
						/*}
						else{
							test.log(LogStatus.INFO, "Payment transaction is successfully");
						}*/
						test.log(LogStatus.PASS,"****************************************");
						break;
						
					}
						}
			}
			catch(Exception ex)
			{
				
			}


	
	}
	
	
}
