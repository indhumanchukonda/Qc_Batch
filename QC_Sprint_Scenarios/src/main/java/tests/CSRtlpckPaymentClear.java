package tests;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class CSRtlpckPaymentClear extends QCStore
{

	public static void ckpaymentClear(String SSN, String AppURL) throws InterruptedException
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
				String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
				String PIN = TestData.getCellData(sheetName,"Password",row);
				String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);	
				String PaymentType = TestData.getCellData(sheetName,"PaymentType",row);
				String CCMONbr = TestData.getCellData(sheetName,"CCMONbr",row);
				String CardType = TestData.getCellData(sheetName,"Card Type ",row);
				String CardNbr = TestData.getCellData(sheetName,"Debit Card No",row);
				String ExpMonth = TestData.getCellData(sheetName,"Expiry Month",row);
				String ExpYear = TestData.getCellData(sheetName,"Expiry Year",row);
				String CVVNbr = TestData.getCellData(sheetName,"CVV",row);
				String CCName = TestData.getCellData(sheetName,"CardHolderName",row);
				String CheckNO = TestData.getCellData(sheetName,"ChkgAcctNbr_lastfour",row);

				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"PartialPayment started");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(prop.getProperty("transactions_tab"))).click();
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				
				

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(prop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		
							
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);		
				String loan_number = driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[2]")).getText();
				test.log(LogStatus.PASS,"Loan number is:" +loan_number);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.xpath("//*[text()='Collateral Checks']")).click();
				test.log(LogStatus.PASS, "clicked on collteral checks");
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//*[text()='Title Loan'])[3]")).click();
				test.log(LogStatus.PASS, "clicked on TLP link");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='9881908080']/a")).click();
				test.log(LogStatus.PASS, "clicked on Clear link");
				Thread.sleep(3000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");		
				driver.findElement(By.xpath("//*[@name='requestBean.loanCode']")).sendKeys(loan_number);
				test.log(LogStatus.PASS,"entered loan number:" +loan_number);
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[2]/tbody/tr/td[2]/input")).click();
				test.log(LogStatus.PASS, "clicked on submit button");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@name='requestBean.chkName']")).click();
				test.log(LogStatus.PASS, "clicked on checkbox");
				driver.findElement(By.xpath("//*[@name='CmdReturnPosting']")).click();
				test.log(LogStatus.PASS, "clicked on finish TLP clear");
	}
		}
	
}
		catch(Exception ex)
		{
			ex.getMessage();
		}
	}
	
	public static void adminckpaymentClear(String SSN, String AppURL) throws InterruptedException
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
				String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
				String PIN = TestData.getCellData(sheetName,"Password",row);
				String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);	
				String PaymentType = TestData.getCellData(sheetName,"PaymentType",row);
				String CCMONbr = TestData.getCellData(sheetName,"CCMONbr",row);
				String CardType = TestData.getCellData(sheetName,"Card Type ",row);
				String CardNbr = TestData.getCellData(sheetName,"Debit Card No",row);
				String ExpMonth = TestData.getCellData(sheetName,"Expiry Month",row);
				String ExpYear = TestData.getCellData(sheetName,"Expiry Year",row);
				String CVVNbr = TestData.getCellData(sheetName,"CVV",row);
				String CCName = TestData.getCellData(sheetName,"CardHolderName",row);
				String CheckNO = TestData.getCellData(sheetName,"ChkgAcctNbr_lastfour",row);

				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"PartialPayment started");
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[text()='Transactions']")).click();
				test.log(LogStatus.PASS, "Clicked on Transactions");
				
				

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(prop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		
							
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);		
				String loan_number = driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[2]")).getText();
				test.log(LogStatus.PASS,"Loan number is:" +loan_number);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.xpath("//*[text()='Collateral Checks']")).click();
				test.log(LogStatus.PASS, "clicked on collteral checks");
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//*[text()='Title Loan'])[3]")).click();
				test.log(LogStatus.PASS, "clicked on TLP link");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='9881908080']/a")).click();
				test.log(LogStatus.PASS, "clicked on Clear link");
				Thread.sleep(3000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");		
				driver.findElement(By.xpath("//*[@name='requestBean.loanCode']")).sendKeys(loan_number);
				test.log(LogStatus.PASS,"entered loan number:" +loan_number);
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[2]/tbody/tr/td[2]/input")).click();
				test.log(LogStatus.PASS, "clicked on submit button");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@name='requestBean.chkName']")).click();
				test.log(LogStatus.PASS, "clicked on checkbox");
				driver.findElement(By.xpath("//*[@name='CmdReturnPosting']")).click();
				test.log(LogStatus.PASS, "clicked on finish TLP clear");
	}
		}
	
}
		catch(Exception ex)
		{
			ex.getMessage();
		}
	}
}
