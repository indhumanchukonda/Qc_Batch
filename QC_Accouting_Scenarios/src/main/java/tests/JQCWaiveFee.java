package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class JQCWaiveFee extends QCStore {
	public static void waive(String SSN,String AppURL)
	{
	try{
		int lastrow=TestData.getLastRow("WaiveFee");
		String sheetName="WaiveFee";
		System.out.println("...."+sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			System.out.println("...."+RegSSN);
			if(SSN.equals(RegSSN))
			{
				
			String PIN = TestData.getCellData(sheetName,"Password",row);
			String Partial = TestData.getCellData(sheetName,"Partial",row);
			encryption_store_no=TestData.getCellData(sheetName,"StoreID",row);
	        
	       
	    
	      	
			        String SSN1 = SSN.substring(0, 3);
			        String SSN2 = SSN.substring(3,5);
			        String SSN3 = SSN.substring(5,9);
			        		       
			
	       Thread.sleep(4000);
			test.log(LogStatus.INFO, "Refinance from CSR has initiated");
			driver.switchTo().frame("bottom");
			String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
	test.log(LogStatus.PASS, ""+Str_date);
	
	driver.switchTo().defaultContent();	
	
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
	driver.switchTo().frame("topFrame");
	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
    driver.findElement(By.cssSelector("li[id='910000']")).click();	
	
	test.log(LogStatus.PASS, "Clicked on Loan Transactions");
	Thread.sleep(3000);
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
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
	driver.findElement(locator(Jprop.getProperty("csr_new_loan_submit_button"))).click();
	test.log(LogStatus.PASS, "Clicked on submit Button");		
				
						    					   					     
	driver.findElement(locator(Jprop.getProperty("csr_new_loan_go_button"))).click();
	test.log(LogStatus.PASS, "Clicked on GO Button under search results");
	Thread.sleep(5000);		

	
	    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
	    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
	   
	    driver.switchTo().defaultContent();
		 driver.switchTo().frame("mainFrame");
		 driver.switchTo().frame("main");
		 driver.findElement(locator(Jprop.getProperty("transactionList"))).sendKeys("Waive Fee");
		 test.log(LogStatus.PASS, "Transaction type is selected as Waive Fee");
		 driver.findElement(By.xpath("//input[@name='button' and @value='Go']")).click();
		 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
		 Thread.sleep(3000);
		 lateFee=driver.findElement(By.name("balLF")).getAttribute("value");
		 test.log(LogStatus.PASS, "Getting late fee is : "+lateFee);
		 
		 driver.findElement(By.name("waiveLF")).click();
		 test.log(LogStatus.PASS, "Click on the late fee");
		 
		 driver.findElement(By.name("waiveLF")).clear();
		 test.log(LogStatus.PASS, "Clearing the value from late fee ");
		 
		 if(Partial.equalsIgnoreCase("Partial")){
			 
			 float lateFeeInt=Float.valueOf(lateFee);
			 lateFeeInt=lateFeeInt-5;
				String lateFee2 = Float.toString(lateFeeInt);
				
			 driver.findElement(By.name("waiveLF")).sendKeys(lateFee2);
			 test.log(LogStatus.PASS, "Enter late fee is "+lateFee2);
			 
		 }else{
		 
		 driver.findElement(By.name("waiveLF")).sendKeys(lateFee);
		 test.log(LogStatus.PASS, "Enter late fee is "+lateFee);
		 }
		 encryption_transaction_nbr=driver.findElement(By.name("origTranNbr")).getAttribute("value");
		 test.log(LogStatus.PASS, "encryption_transaction_nbr is : "+encryption_transaction_nbr);
		 
		 String mainwindow=driver.getWindowHandle();
		System.out.println("before CSR"+ mainwindow);
		
		 JQCAdminEncryption.getEncryption(driver,SSN, AppURL); 
		 
		 Thread.sleep(2000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");
		
		String text=driver.findElement(By.name("waiveLF")).getAttribute("value");
		test.log(LogStatus.PASS, "late fee is "+text);
		
		test.log(LogStatus.PASS, "Control switched to CSR page to enter Encryption key");
		driver.findElement(By.name("encryptionKey")).sendKeys(Eankey);
		test.log(LogStatus.PASS, "Entered the Encryption Key"+Eankey);

		driver.findElement(By.name("password")).sendKeys(PIN);
		test.log(LogStatus.PASS, "Entered the PIN number "+PIN);
		
		driver.findElement(By.name("Submit22")).click();
		test.log(LogStatus.PASS," Click on the Waive Fee finish button");
					
				driver.findElement(By.xpath("//input[@value='Yes' and @name='checkyes']")).click();
				test.log(LogStatus.PASS," Waive Fee transcation from CSR is successfull");
				 test.log(LogStatus.PASS, "**********************************************");	
								
		} 
		
		
			break;
	}
	
	 


}catch(Exception e){
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Waive Fee from CSR is failed");

}


}
}
