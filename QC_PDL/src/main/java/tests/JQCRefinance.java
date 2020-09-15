package tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class JQCRefinance extends QCStore{
	public static void Refinance(String SSN,String AppURL) throws InterruptedException
	{
		
			int lastrow=TestData.getLastRow((Jprop.getProperty("Refinance")));
			String sheetName=Jprop.getProperty("Refinance");
			System.out.println("...."+sheetName);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				String CallConsent = TestData.getCellData(sheetName,"CallConsent",row);
				String card_num = TestData.getCellData(sheetName,"Debit Card No",row);
				String card_type = TestData.getCellData(sheetName,"Card Type",row);
				String cvv = TestData.getCellData(sheetName,"CVV",row);
				String exp_year = TestData.getCellData(sheetName,"Expiry Year",row);
				String exp_mon = TestData.getCellData(sheetName,"Expiry Month",row);
				String card_name = TestData.getCellData(sheetName,"CardHolderName",row);
				
				System.out.println("...."+RegSSN);
				if(SSN.equals(RegSSN))
				{
				
				String PIN = TestData.getCellData(sheetName,"PIN#",row);
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);      
		        String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;                                //column name
		        System.out.println(columnname);		      
		       String Bank_ChkgAcctNbr = TestData.getCellData(sheetName,"Bank_ChkgAcctNbr",row);	       		      		      
		       String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);		       String TenderType = TestData.getCellData(sheetName,"TenderType",row);
		       String Checks = TestData.getCellData(sheetName,"#ofChecks",row);	
		       String CheckNbr = TestData.getCellData(sheetName,"CheckNbr",row);	
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
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");		
				for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
				}
			    driver.switchTo().defaultContent();
			    driver.switchTo().frame("mainFrame");
			    driver.switchTo().frame("main");
			    
			    driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button under search results");
				
			for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
					}				    
				 	driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");
				    
				  
				    driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
				    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    
				    Thread.sleep(5000);
				     String loan_nbr= driver.findElement(locator(Jprop.getProperty("csr_loan_nbr"))).getText();
					  test.log(LogStatus.PASS, "Loan Number is " + loan_nbr);
					   driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						System.out.println("************"+ESign_CollateralType);
						 test.log(LogStatus.PASS, "Collateral is " + ESign_CollateralType);
						Thread.sleep(2000);
		
						if(ESign_CollateralType.equalsIgnoreCase("ACH"))
						{			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 driver.findElement(locator(Jprop.getProperty("transactionList"))).sendKeys("Refinance");
							 test.log(LogStatus.PASS, "Transaction type is selected as Refinance");
							 driver.findElement(locator(Jprop.getProperty("go"))).click();
							 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
							 Thread.sleep(3000);
							 driver.findElement(locator(Jprop.getProperty("Refinance_qualify"))).click();
							 Thread.sleep(5000);
							 driver.findElement(locator(Jprop.getProperty("Refinance_acct_nbr"))).sendKeys(Bank_ChkgAcctNbr);
							 driver.findElement(locator(Jprop.getProperty("Refinance_callConsent"))).sendKeys(CallConsent);
							 driver.findElement(locator(Jprop.getProperty("Refinance_preferenceCall"))).click();
							 String ele= driver.findElement(locator(Jprop.getProperty("Refinance_PaymentAmt"))).getAttribute("value");
							 System.out.println("*******"+ele);
							 driver.findElement(locator(Jprop.getProperty("Refinance_tenderType"))).sendKeys(TenderType);
							 driver.findElement(locator(Jprop.getProperty("Refinance_tenderAmt"))).sendKeys(ele);
							 driver.findElement(locator(Jprop.getProperty("clear_pwd"))).sendKeys(PIN);
							 driver.findElement(locator(Jprop.getProperty("Refinance_finish"))).click();
							 Thread.sleep(2000);
							 driver.findElement(locator(Jprop.getProperty("Refinance_yes"))).click();
							 
							 						
								 test.log(LogStatus.PASS, ESign_CollateralType+ "Refinance from CSR is successfull");
								 test.log(LogStatus.PASS, "**********************************************");								 
							 	
							}
						else if(ESign_CollateralType.equalsIgnoreCase("CHECK"))
						{
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 driver.findElement(locator(Jprop.getProperty("transactionList"))).sendKeys("Refinance");
							 test.log(LogStatus.PASS, "Transaction type is selected as Refinance");
							 driver.findElement(locator(Jprop.getProperty("go"))).click();
							 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
							 Thread.sleep(4000);
							 driver.findElement(locator(Jprop.getProperty("Refinance_qualify"))).click();
							 test.log(LogStatus.PASS, "Click on Refinance qualify");
							 Thread.sleep(5000);
							 driver.findElement(locator(Jprop.getProperty("Refinance_acct_nbr"))).sendKeys(Bank_ChkgAcctNbr);
							 test.log(LogStatus.PASS, "Enter bank account number"+Bank_ChkgAcctNbr);
							 driver.findElement(locator(Jprop.getProperty("Refinance_callConsent"))).sendKeys(CallConsent);
			
							 driver.findElement(locator(Jprop.getProperty("Refinance_preferenceCall"))).click();
							 driver.findElement(locator(Jprop.getProperty("Refinance_checks"))).sendKeys(Checks);
							 test.log(LogStatus.PASS, "Enter Check "+Checks);
							 driver.findElement(locator(Jprop.getProperty("Refinance_check_nbr"))).sendKeys(CheckNbr);
							 String ele= driver.findElement(locator(Jprop.getProperty("Refinance_PaymentAmt"))).getAttribute("value");
							 System.out.println("*******"+ele);
							 driver.findElement(locator(Jprop.getProperty("Refinance_tenderType"))).sendKeys(TenderType);
							 test.log(LogStatus.PASS, "Select tender amount  "+ele);
							 driver.findElement(locator(Jprop.getProperty("Refinance_tenderAmt"))).sendKeys(ele);
							 test.log(LogStatus.PASS, "Select tender type "+TenderType);
							 driver.findElement(locator(Jprop.getProperty("clear_pwd"))).sendKeys(PIN);
							 test.log(LogStatus.PASS, "Enter password  "+PIN);
							 driver.findElement(locator(Jprop.getProperty("Refinance_finish"))).click();
							 test.log(LogStatus.PASS, "Click on refinance Finish button  ");
							 Thread.sleep(2000);
							 driver.findElement(locator(Jprop.getProperty("Refinance_yes"))).click();
							 
							 test.log(LogStatus.PASS, ESign_CollateralType+ "Refinance from CSR is successfull");
							 test.log(LogStatus.PASS, "********************************************** ");	
						}
						else if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
						{
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 driver.findElement(locator(Jprop.getProperty("transactionList"))).sendKeys("Refinance");
							 test.log(LogStatus.PASS, "Transaction type is selected as Refinance");
							 driver.findElement(locator(Jprop.getProperty("go"))).click();
							 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
							 Thread.sleep(3000);
							 driver.findElement(locator(Jprop.getProperty("Refinance_qualify"))).click();
							 Thread.sleep(5000);
							 driver.findElement(locator(Jprop.getProperty("Refinance_callConsent"))).sendKeys(CallConsent);
							 driver.findElement(locator(Jprop.getProperty("Refinance_preferenceCall"))).click();
							 driver.findElement(locator(Jprop.getProperty("Refinance_newcard"))).sendKeys("NEW CARD");
							 test.log(LogStatus.PASS, "Select the NewCard ");
							 driver.findElement(locator(Jprop.getProperty("Refinance_cardType"))).sendKeys(card_type);
							 test.log(LogStatus.PASS, "Select the card type");
							 driver.findElement(locator(Jprop.getProperty("Refinance_cardnum"))).sendKeys(card_num);
							 test.log(LogStatus.PASS, "Enter card number ");
							 driver.findElement(locator(Jprop.getProperty("Refinance_EM"))).sendKeys(exp_mon);
							 test.log(LogStatus.PASS, "Select Month");
							 driver.findElement(locator(Jprop.getProperty("Refinance_EY"))).sendKeys(exp_year);
							 test.log(LogStatus.PASS, "Select Year");
							 driver.findElement(locator(Jprop.getProperty("Refinance_cvv"))).sendKeys(cvv);
							 test.log(LogStatus.PASS, "Enter CVV");
							 driver.findElement(locator(Jprop.getProperty("Refinanace_addcard"))).click();
							 test.log(LogStatus.PASS, "Click add card button");
							 String ele= driver.findElement(locator(Jprop.getProperty("Refinance_PaymentAmt"))).getAttribute("value");
							 System.out.println("*******"+ele);
							 driver.findElement(locator(Jprop.getProperty("Refinance_tenderType"))).sendKeys(TenderType);
							 driver.findElement(locator(Jprop.getProperty("Refinance_tenderAmt"))).sendKeys(ele);
							 driver.findElement(locator(Jprop.getProperty("clear_pwd"))).sendKeys(PIN);
							 driver.findElement(locator(Jprop.getProperty("Refinance_finish"))).click();
							 Thread.sleep(2000);
							 driver.findElement(locator(Jprop.getProperty("Refinance_yes"))).click();
							 
							 test.log(LogStatus.PASS, ESign_CollateralType+ "Refinance from CSR is successfull");
							 test.log(LogStatus.PASS, "********************************************** ");	
						}
						break;
				}
				
				 
			}
			
		
			
		
	}
}
