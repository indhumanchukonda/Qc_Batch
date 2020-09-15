package tests;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class JQCConversion extends QCStore {

	public static String State;
	public static String stateProductType;
	public static String stateProduct;
	public static String StoreID;
	public static String ProductType;
	public static String ProductID;
	public static String NewLoan_Term;
	public static String NewLoan_ProductName;

	public static void ILPConversion(String SSN,String AppURL) throws Exception{

		String sheetName="Conversion";	
		int lastrow=TestData.getLastRow(sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
				
			{		
				NewLoan_ProductName = TestData.getCellData(sheetName, "NewLoan_ProductName", row);
				NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
				ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				
				State = TestData.getCellData(sheetName, "StateID", row);
				ProductID = TestData.getCellData(sheetName, "ProductID", row);
				ProductType = TestData.getCellData(sheetName, "ProductType", row);
				StoreID = TestData.getCellData(sheetName, "StoreID", row);
				stateProduct = State + " " + ProductID;
				stateProductType = State + " " + ProductType;
				test.log(LogStatus.PASS, "Loan Type is "+stateProductType);
				
				
				String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
				String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
				String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);
				String ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);
				String No_of_checks = TestData.getCellData(sheetName,"No_of_checks",row);
				String ESign_Password = TestData.getCellData(sheetName,"ESign_Password",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String DisbType = TestData.getCellData(sheetName,"DisbType",row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"**************Coversion started**************");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Jprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(Jprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(Jprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		
				/*for(String winHandle : driver.getWindowHandles())
					{
				    driver.switchTo().window(winHandle);*/				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(2000);					  
				/*	for( String winHandle1 : driver.getWindowHandles())
					{
					    driver.switchTo().window(winHandle1);
					}*/			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys("Conversion");
				test.log(LogStatus.PASS, "Transaction Type is selected as Conversion");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				Thread.sleep(500);
				
				/*Code commented because below but button is not existed in this build 
				 * 
				 * driver.findElement(By.id("go_Button")).click();
				test.log(LogStatus.PASS, "Clicked on continue button");
				Thread.sleep(500);*/
				
				
				
				/*if (ProductID.equals("ILP")) {	*/
																		
				test.log(LogStatus.PASS, "getting product name ");
				/*driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/select")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);*/
				/*driver.findElement(By.xpath("//*[@id='go_Button']")).click();
				test.log(LogStatus.PASS, "Clicked on continue button");*/

				driver.findElement(By.xpath("//*[@name='requestBean.collateralType']")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
				try
				{
				driver.findElement(By.xpath("//*[@id='veh1']")).click();
				test.log(LogStatus.PASS, "Clicked on yes button");
				}
				catch(Exception e)
				{
					
				}
				Thread.sleep(3000);		
				
				List<WebElement>  rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")); 

				int n=rows.size();
				for(int i=2;i<=n;i++){
					String Pname=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();
					test.log(LogStatus.PASS, "getting product name "+Pname);
					/*driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/select")).sendKeys(ESign_CollateralType);
					test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
*/
					if(Pname.equals(stateProductType))
					{
						
						if(NewLoan_Term.equals("Term1"))
						{//*[@id="termSel1"]
							//*[@id="termSel1"]
							driver.findElement(By.xpath("//*[@id='termSel1']")).click();
							test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
							Thread.sleep(5000);
						}
						else if(NewLoan_Term.equals("Term2"))
						{
							driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/b/input")).click();
							test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
							Thread.sleep(5000);
						}	
						else if(NewLoan_Term.equals("Term3"))
						{
							driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/table/tbody/tr/td[2]/table[3]/tbody/tr[1]/td/b/input")).click();
							test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
							Thread.sleep(5000);
						}
					}
					else{
						continue;
					}
					
				}
					String loanAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[2]/td")).getText();
					test.log(LogStatus.PASS, "ILP loan amount is : "+loanAmt);
					String term=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[3]/td")).getText();
					test.log(LogStatus.PASS, "Term is : "+term);
					String inst=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[4]/td")).getText();
					test.log(LogStatus.PASS, "Number of installments is : "+inst);
					String rate=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[5]/td")).getText();
					test.log(LogStatus.PASS, "Interest rate is : "+rate);
					String apr=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[6]/td/input")).getAttribute("value");
					test.log(LogStatus.PASS, "APR is : "+apr);
					String payAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[7]/td/input")).getAttribute("value");
					test.log(LogStatus.PASS, "Payment Amount is : "+payAmt);
					String payDate=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[8]/td")).getText();
					test.log(LogStatus.PASS, "Payment Date is : "+payDate);
					String freq=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[9]/td")).getText();
					test.log(LogStatus.PASS,  "Frequence is : "+freq);
					String minLoanAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[10]/td")).getText();
					test.log(LogStatus.PASS, "Minimum loan amount is : "+minLoanAmt);
					String maxLoanAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[11]/td")).getText();
					test.log(LogStatus.PASS, "Maximum loan amount is : "+maxLoanAmt);

					
					//driver.findElement(By.id("//*[@id='LoanButtonId']")).click();
					driver.findElement(By.xpath("//*[@id='LoanButtonId']")).click();
					test.log(LogStatus.PASS, "Clicked on Conversion button ");
					
					Thread.sleep(3000);
					try
					{
						driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
					}
					catch(Exception ex)
					{
						
					}
				
				driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Click On Qualify button");
				Thread.sleep(500);
				
				driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Click On Qualify button");
				
					Thread.sleep(9000);
					String paymentAmount=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Payment amount is "+paymentAmount);
					
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender type is "+TenderType);
					
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).clear();
					
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(paymentAmount);
					test.log(LogStatus.PASS, "Tender amount is "+paymentAmount);
					
					driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
					test.log(LogStatus.PASS, "collateral type is "+ESign_CollateralType);
					
					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(DisbType);
					test.log(LogStatus.PASS, "Disb type is "+DisbType);
					
					String disdAmount=driver.findElement(By.id("refinanceLoanAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Total Disb amount is "+disdAmount);
					
					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(disdAmount);
					test.log(LogStatus.PASS, "Disb amount is "+disdAmount);
					
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					
					if(ESign_CourtesyCallConsent.equals("Yes"))
					{
						Thread.sleep(1000);
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try {
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					
					}
					
					driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
					test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
					driver.findElement(By.name("finishLoan")).click();
					test.log(LogStatus.PASS, "click on Finish Conversion button ");
					Thread.sleep(500);
					//------------------------------------------------------------------------------------------------------------		
					try {
						Alert alert = driver.switchTo().alert();
						alert.accept();
						//if alert present, accept and move on.
					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					
					String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b/b[2]")).getText();																		
					String confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();					                                                  
					String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/b/font")).getText();				                                                  
					String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[5]/td/b")).getText();
					String confirm_text5=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b")).getText();
					
					                                                  
				
					test.log(LogStatus.PASS, confirm_text5 +" Installment Loan of  "+confirm_text1+" First Payment Date: "+confirm_text2+" Payout to Customer: "+confirm_text3+" Cash. This loan includes "+confirm_text4);
					Thread.sleep(10000);
					driver.findElement(By.name("OKBut")).click();

					test.log(LogStatus.PASS, "click on Yes button ");
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='docEditor']/table/tbody/tr[4]/td/input[1]")).click();
					//driver.findElement(By.xpath("//*[@id='docEditor']/form/table/tbody/tr[4]/td/input[1]")).click();
					test.log(LogStatus.PASS, "click on Yes button ");
					Thread.sleep(2500);
					//*[@id="docEditor"]/form/table/tbody/tr[4]/td/input[1]
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					if(driver.findElement(By.name("ok")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Installment Conversion completed successfully ");
						test.log(LogStatus.INFO, "**********************************************************************************");

					}
					else
					{
						test.log(LogStatus.FAIL, "Installment Conversion is not completed successfully ");
					}
					break;
				
				}	
				
			//break;
		}
	}
	
	public static void ILPSignatureConversion(String SSN,String AppURL) throws Exception{
		String sheetName="Conversion";	
		int lastrow=TestData.getLastRow(sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
				
			{		
				NewLoan_ProductName = TestData.getCellData(sheetName, "NewLoan_ProductName", row);
				NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
				ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				
				State = TestData.getCellData(sheetName, "StateID", row);
				ProductID = TestData.getCellData(sheetName, "ProductID", row);
				ProductType = TestData.getCellData(sheetName, "ProductType", row);
				StoreID = TestData.getCellData(sheetName, "StoreID", row);
				stateProduct = State + " " + ProductID;
				stateProductType = State + " " + ProductType;
				test.log(LogStatus.PASS, "Loan Type is "+stateProductType);
				
				
				String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
				String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
				String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);
				String ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);
				String No_of_checks = TestData.getCellData(sheetName,"No_of_checks",row);
				String ESign_Password = TestData.getCellData(sheetName,"ESign_Password",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String DisbType = TestData.getCellData(sheetName,"DisbType",row);
				String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"**************Coversion started**************");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Jprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(Jprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(Jprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		
				/*for(String winHandle : driver.getWindowHandles())
					{
				    driver.switchTo().window(winHandle);*/				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");	
				
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(2000);					  
				/*	for( String winHandle1 : driver.getWindowHandles())
					{
					    driver.switchTo().window(winHandle1);
					}*/			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				                            ///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input[1]
				driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input[1]")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				
				driver.findElement(By.name("transactionList")).sendKeys("Conversion");
				test.log(LogStatus.PASS, "Transaction Type is selected as Conversion");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				Thread.sleep(1000);
				
				//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[5]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[4]/td[1]/input")).click();
				/*driver.findElement(By.xpath("//*[contains(@value,',2')]")).click();
				test.log(LogStatus.PASS, "Select on ILP Loan Check box");*/
				/*driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[5]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[7]/td[1]/input")).click();
				test.log(LogStatus.PASS, "Select on ILP Loan Check box");*/
				
				driver.findElement(By.id("go_Button")).click();
				test.log(LogStatus.PASS, "Clicked on Continue button");
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@name='requestBean.collateralType']")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
				try
				{
				driver.findElement(By.xpath("//*[@id='veh1']")).click();
				test.log(LogStatus.PASS, "Clicked on yes button");
				}
				catch(Exception e)
				{
					
				}
				Thread.sleep(3000);		
				
				/*Code commented because below but button is not existed in this build 
				 * 
				 * driver.findElement(By.id("go_Button")).click();
				test.log(LogStatus.PASS, "Clicked on continue button");
				Thread.sleep(500);*/
				
				
				
				/*if (ProductID.equals("ILP")) {	*/
				
																		
				test.log(LogStatus.PASS, "getting product name ");
				List<WebElement>  rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")); 

				int n=rows.size();
				for(int i=2;i<=n;i++){
					String Pname=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();
					test.log(LogStatus.PASS, "getting product name "+Pname);
					

					if(Pname.equals(stateProductType))
					{
						
						if(NewLoan_Term.equals("Term1"))
						{
							driver.findElement(By.xpath("//*[@id='termSel1']")).click();
							//driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/table/tbody/tr/td[2]/table[1]/tbody/tr[1]/td/b/input")).click();
							test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
						}
						else if(NewLoan_Term.equals("Term2"))
						{
							driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/b/input")).click();
							test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
						}	
						else if(NewLoan_Term.equals("Term3"))
						{
							driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/table/tbody/tr/td[2]/table[3]/tbody/tr[1]/td/b/input")).click();
							test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
						}
					}
					else{
						continue;
					}
					
				}
				
					/*String loanAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[2]/td")).getText();
					test.log(LogStatus.PASS, "ILP loan amount is : "+loanAmt);
					String term=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[3]/td")).getText();
					test.log(LogStatus.PASS, "Term is : "+term);
					String inst=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[4]/td")).getText();
					test.log(LogStatus.PASS, "Number of installments is : "+inst);
					String rate=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[5]/td")).getText();
					test.log(LogStatus.PASS, "Interest rate is : "+rate);
					String apr=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[6]/td/input")).getAttribute("value");
					test.log(LogStatus.PASS, "APR is : "+apr);
					String payAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[7]/td/input")).getAttribute("value");
					test.log(LogStatus.PASS, "Payment Amount is : "+payAmt);
					String payDate=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[8]/td")).getText();
					test.log(LogStatus.PASS, "Payment Date is : "+payDate);
					String freq=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[9]/td")).getText();
					test.log(LogStatus.PASS,  "Frequence is : "+freq);
					String minLoanAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[10]/td")).getText();
					test.log(LogStatus.PASS, "Minimum loan amount is : "+minLoanAmt);
					String maxLoanAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[11]/td")).getText();
					test.log(LogStatus.PASS, "Maximum loan amount is : "+maxLoanAmt);*/

					driver.findElement(By.id("LoanButtonId")).click();
					test.log(LogStatus.PASS, "Clicked on Conversion button ");
					
					Thread.sleep(3000);
					try
					{
						driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
					}
					catch(Exception ex)
					{
						
					}

				
				driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Click On Qualify button");
				Thread.sleep(1000);
				
				driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Click On Qualify button");
				Thread.sleep(500);
				
				driver.findElement(By.id("qualifyBTN")).click();
				test.log(LogStatus.PASS, "Click On Qualify button");
				Thread.sleep(500);
				
				driver.findElement(By.id("qualifyBTN")).click();
				test.log(LogStatus.PASS, "Click On Qualify button");
				
				
					Thread.sleep(9000);
					String paymentAmount=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Payment amount is "+paymentAmount);
					
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender type is "+TenderType);
					
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).clear();
					
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(paymentAmount);
					test.log(LogStatus.PASS, "Tender amount is "+paymentAmount);
					
					driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
					test.log(LogStatus.PASS, "collateral type is "+ESign_CollateralType);
					
					/*try {
					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(DisbType);
					test.log(LogStatus.PASS, "Disb type is "+DisbType);
					
					String disdAmount=driver.findElement(By.id("refinanceLoanAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Total Disb amount is "+disdAmount);
					
					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(disdAmount);
					test.log(LogStatus.PASS, "Disb amount is "+disdAmount);
					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}*/
				Thread.sleep(1000);
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					
					if(ESign_CourtesyCallConsent.equals("Yes"))
					{
						Thread.sleep(1000);
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try {
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					
					}
					
					driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
					test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
					driver.findElement(By.name("finishLoan")).click();
					                              //html/body/form[1]/table/tbody/tr[11]/td/table/tbody/tr[11]/td[2]/input
					Thread.sleep(3000);
					                            
					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[12]/td/table/tbody/tr[11]/td[2]/input")).click();
					//html/body/form[1]/table/tbody/tr[11]/td/table/tbody/tr[11]/td[2]/input
					test.log(LogStatus.PASS, "click on Finish Conversion button ");
					Thread.sleep(5000);
					//------------------------------------------------------------------------------------------------------------		
					try {
						Alert alert = driver.switchTo().alert();
						alert.accept();
						//if alert present, accept and move on.
					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
																		
					/*String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b")).getText();																							                                                  
					String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();				                                                  
					String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/b")).getText();
					*/
					                                                  
				
					//test.log(LogStatus.PASS, confirm_text1 +" First Payment Date: "+confirm_text3+". This loan includes "+confirm_text4);
					Thread.sleep(10000);
					                             //html/body/form/table/tbody/tr/td/table/tbody/tr[8]/td[1]/input
					driver.findElement(By.xpath("//*[@value='Yes']")).click();

					test.log(LogStatus.PASS, "click on Yes button ");
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='docEditor']/table/tbody/tr[4]/td/input[1]")).click();
					//driver.findElement(By.xpath("//*[@id='docEditor']/form/table/tbody/tr[4]/td/input[1]")).click();
					test.log(LogStatus.PASS, "click on Yes button ");
					Thread.sleep(2500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					if(driver.findElement(By.name("ok")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Installment Conversion completed successfully ");
						test.log(LogStatus.INFO, "**********************************************************************************");

					}
					else
					{
						test.log(LogStatus.FAIL, "Installment Conversion is not completed successfully ");
					}
					break;
				
				}	
				
			//break;
		}

	}
	public static void PDLILPConversion(String SSN,String AppURL) throws Exception{
		String sheetName="Conversion";	
		int lastrow=TestData.getLastRow(sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
				
			{		
				NewLoan_ProductName = TestData.getCellData(sheetName, "NewLoan_ProductName", row);
				NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
				ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				
				State = TestData.getCellData(sheetName, "StateID", row);
				ProductID = TestData.getCellData(sheetName, "ProductID", row);
				ProductType = TestData.getCellData(sheetName, "ProductType", row);
				StoreID = TestData.getCellData(sheetName, "StoreID", row);
				stateProduct = State + " " + ProductID;
				stateProductType = State + " " + ProductType;
				test.log(LogStatus.PASS, "Loan Type is "+stateProductType);
				
				
				String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
				String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
				String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);
				String ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);
				String No_of_checks = TestData.getCellData(sheetName,"No_of_checks",row);
				String ESign_Password = TestData.getCellData(sheetName,"ESign_Password",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String DisbType = TestData.getCellData(sheetName,"DisbType",row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"**************Coversion started**************");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Jprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(Jprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(Jprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		
				/*for(String winHandle : driver.getWindowHandles())
					{
				    driver.switchTo().window(winHandle);*/				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(2000);					  
				/*	for( String winHandle1 : driver.getWindowHandles())
					{
					    driver.switchTo().window(winHandle1);
					}*/			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys("Conversion");
				test.log(LogStatus.PASS, "Transaction Type is selected as Conversion");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				Thread.sleep(1000);
				
				/*driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[5]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[5]/td[1]/input")).click();
				test.log(LogStatus.PASS, "Select on PDL Loan Check box");*/
				
				driver.findElement(By.id("go_Button")).click();
				test.log(LogStatus.PASS, "Clicked on Continue button");
				Thread.sleep(1000);
				try
				{
				driver.findElement(By.xpath("//*[@id='veh1']")).click();
				test.log(LogStatus.PASS, "Clicked on yes button");
				}
				catch(Exception e)
				{
					
				}
				Thread.sleep(3000);		
				
				driver.findElement(By.xpath("//*[@name='requestBean.collateralType']")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
				
				test.log(LogStatus.PASS, "getting product name ");
				List<WebElement>  rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")); 

				int n=rows.size();
				for(int i=2;i<=n;i++){
					String Pname=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();
					test.log(LogStatus.PASS, "getting product name "+Pname);
					

					if(Pname.equals(stateProductType))
					{
						/*driver.findElement(By.xpath("//*[@id='termSel1']")).click();
						test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);*/
						if(NewLoan_Term.equals("Term1"))
						{
							
							driver.findElement(By.xpath("(//*[@id='termSel1'])[2]")).click();
							test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
						}
						else if(NewLoan_Term.equals("Term2"))
						{
							driver.findElement(By.xpath("(//*[@id='termSel1'])[2]")).click();
							test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
						}	
						else if(NewLoan_Term.equals("Term3"))
						{
							driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/table/tbody/tr/td[2]/table[3]/tbody/tr[1]/td/b/input")).click();
							test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
						}
					}
					else{
						continue;
					}
					
				}
					String loanAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[2]/td")).getText();
					test.log(LogStatus.PASS, "ILP loan amount is : "+loanAmt);
					String term=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[3]/td")).getText();
					test.log(LogStatus.PASS, "Term is : "+term);
					String inst=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[4]/td")).getText();
					test.log(LogStatus.PASS, "Number of installments is : "+inst);
					String rate=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[5]/td")).getText();
					test.log(LogStatus.PASS, "Interest rate is : "+rate);
					String apr=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[6]/td/input")).getAttribute("value");
					test.log(LogStatus.PASS, "APR is : "+apr);
					String payAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[7]/td/input")).getAttribute("value");
					test.log(LogStatus.PASS, "Payment Amount is : "+payAmt);
					String payDate=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[8]/td")).getText();
					test.log(LogStatus.PASS, "Payment Date is : "+payDate);
					String freq=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[9]/td")).getText();
					test.log(LogStatus.PASS,  "Frequence is : "+freq);
					String minLoanAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[10]/td")).getText();
					test.log(LogStatus.PASS, "Minimum loan amount is : "+minLoanAmt);
					String maxLoanAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[11]/td")).getText();
					test.log(LogStatus.PASS, "Maximum loan amount is : "+maxLoanAmt);

					driver.findElement(By.id("LoanButtonId")).click();
					test.log(LogStatus.PASS, "Clicked on Conversion button ");
					
					Thread.sleep(3000);
					try
					{
						driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
					}
					catch(Exception ex)
					{
						
					}

				
				driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Click On Qualify button");
				Thread.sleep(1000);
				
				driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Click On Qualify button");
				Thread.sleep(500);
				
				driver.findElement(By.id("qualifyBTN")).click();
				test.log(LogStatus.PASS, "Click On Qualify button");
				Thread.sleep(500);
				
				driver.findElement(By.id("qualifyBTN")).click();
				test.log(LogStatus.PASS, "Click On Qualify button");
				
				
					Thread.sleep(9000);
					String paymentAmount=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Payment amount is "+paymentAmount);
					
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender type is "+TenderType);
					
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).clear();
					
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(paymentAmount);
					test.log(LogStatus.PASS, "Tender amount is "+paymentAmount);
					
					driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
					test.log(LogStatus.PASS, "collateral type is "+ESign_CollateralType);
					
					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(DisbType);
					test.log(LogStatus.PASS, "Disb type is "+DisbType);
					
					String disdAmount=driver.findElement(By.id("refinanceLoanAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Total Disb amount is "+disdAmount);
					
					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(disdAmount);
					test.log(LogStatus.PASS, "Disb amount is "+disdAmount);
					
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					
					if(ESign_CourtesyCallConsent.equals("Yes"))
					{
						Thread.sleep(1000);
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try {
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					
					}
					
					driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
					test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
					driver.findElement(By.name("finishLoan")).click();
					test.log(LogStatus.PASS, "click on Finish Conversion button ");
					Thread.sleep(500);
					//------------------------------------------------------------------------------------------------------------		
					try {
						Alert alert = driver.switchTo().alert();
						alert.accept();
						//if alert present, accept and move on.
					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
																		
					String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b")).getText();																							                                                  
					String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();				                                                  
					String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/b")).getText();
					
					                                                  
				
					test.log(LogStatus.PASS, confirm_text1 +" First Payment Date: "+confirm_text3+". This loan includes "+confirm_text4);
					Thread.sleep(500);
					driver.findElement(By.name("OKBut")).click();

					test.log(LogStatus.PASS, "click on Yes button ");
					Thread.sleep(2500);
					driver.findElement(By.xpath("//*[@id='docEditor']/form/table/tbody/tr[4]/td/input[1]")).click();
					test.log(LogStatus.PASS, "click on Yes button ");
					Thread.sleep(2500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					if(driver.findElement(By.name("ok")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Installment Conversion completed successfully ");
						test.log(LogStatus.INFO, "**********************************************************************************");

					}
					else
					{
						test.log(LogStatus.FAIL, "Installment Conversion is not completed successfully ");
					}
					break;
				
				}	
				
			//break;
		}

	}
	public static void ILPILPConversion(String SSN,String AppURL) throws Exception{
		String sheetName="Conversion";	
		int lastrow=TestData.getLastRow(sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
				
			{		
				NewLoan_ProductName = TestData.getCellData(sheetName, "NewLoan_ProductName", row);
				NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
				ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				
				State = TestData.getCellData(sheetName, "StateID", row);
				ProductID = TestData.getCellData(sheetName, "ProductID", row);
				ProductType = TestData.getCellData(sheetName, "ProductType", row);
				StoreID = TestData.getCellData(sheetName, "StoreID", row);
				stateProduct = State + " " + ProductID;
				stateProductType = State + " " + ProductType;
				test.log(LogStatus.PASS, "Loan Type is "+stateProductType);
				
				
				String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
				String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
				String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);
				String ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);
				String No_of_checks = TestData.getCellData(sheetName,"No_of_checks",row);
				String ESign_Password = TestData.getCellData(sheetName,"ESign_Password",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String DisbType = TestData.getCellData(sheetName,"DisbType",row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"**************Coversion started**************");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Jprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(Jprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(Jprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		
				/*for(String winHandle : driver.getWindowHandles())
					{
				    driver.switchTo().window(winHandle);*/				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(2000);					  
				/*	for( String winHandle1 : driver.getWindowHandles())
					{
					    driver.switchTo().window(winHandle1);
					}*/			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys("Conversion");
				test.log(LogStatus.PASS, "Transaction Type is selected as Conversion");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[contains(@value,',1')]")).click();
				test.log(LogStatus.PASS, "UnSelect on PDL Loan Check box");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[contains(@value,',2')]")).click();
				test.log(LogStatus.PASS, "Select on ILP Loan Check box");
				
				driver.findElement(By.id("go_Button")).click();
				test.log(LogStatus.PASS, "Clicked on Continue button");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='veh1']")).click();
				test.log(LogStatus.PASS, "Clicked on yes button");
				Thread.sleep(3000);		
				driver.findElement(By.xpath("//*[@name='requestBean.collateralType']")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);													
				test.log(LogStatus.PASS, "getting product name ");
				List<WebElement>  rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")); 

				int n=rows.size();
				for(int i=2;i<=n;i++){
					String Pname=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();
					test.log(LogStatus.PASS, "getting product name "+Pname);
					

					if(Pname.equals(stateProductType))
					{
						driver.findElement(By.xpath("//*[@id='termSel1']")).click();
						test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
						/*if(NewLoan_Term.equals("Term1"))
						{
							driver.findElement(By.xpath("//*[@id='termSel1']")).click();
							test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
						}
						else if(NewLoan_Term.equals("Term2"))
						{
							driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/b/input")).click();
							test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
						}	
						else if(NewLoan_Term.equals("Term3"))
						{
							driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/table/tbody/tr/td[2]/table[3]/tbody/tr[1]/td/b/input")).click();
							test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
						}*/
					}
					else{
						continue;
					}
					
				}
					/*String loanAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[2]/td")).getText();
					test.log(LogStatus.PASS, "ILP loan amount is : "+loanAmt);
					String term=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[3]/td")).getText();
					test.log(LogStatus.PASS, "Term is : "+term);
					String inst=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[4]/td")).getText();
					test.log(LogStatus.PASS, "Number of installments is : "+inst);
					String rate=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[5]/td")).getText();
					test.log(LogStatus.PASS, "Interest rate is : "+rate);
					String apr=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[6]/td/input")).getAttribute("value");
					test.log(LogStatus.PASS, "APR is : "+apr);
					String payAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[7]/td/input")).getAttribute("value");
					test.log(LogStatus.PASS, "Payment Amount is : "+payAmt);
					String payDate=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[8]/td")).getText();
					test.log(LogStatus.PASS, "Payment Date is : "+payDate);
					String freq=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[9]/td")).getText();
					test.log(LogStatus.PASS,  "Frequence is : "+freq);
					String minLoanAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[10]/td")).getText();
					test.log(LogStatus.PASS, "Minimum loan amount is : "+minLoanAmt);
					String maxLoanAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[11]/td")).getText();
					test.log(LogStatus.PASS, "Maximum loan amount is : "+maxLoanAmt);*/
					Thread.sleep(500);

					driver.findElement(By.id("LoanButtonId")).click();
					test.log(LogStatus.PASS, "Clicked on Conversion button ");
					
					Thread.sleep(3000);
					try
					{
						driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
					}
					catch(Exception ex)
					{
						
					}

				
				driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Click On Qualify button");
				Thread.sleep(1000);
				
				driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Click On Qualify button");
				Thread.sleep(500);
				
				driver.findElement(By.id("qualifyBTN")).click();
				test.log(LogStatus.PASS, "Click On Qualify button");
				Thread.sleep(500);
				
				driver.findElement(By.id("qualifyBTN")).click();
				test.log(LogStatus.PASS, "Click On Qualify button");
				
				
					Thread.sleep(9000);
					String paymentAmount=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Payment amount is "+paymentAmount);
					
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender type is "+TenderType);
					
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).clear();
					
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(paymentAmount);
					test.log(LogStatus.PASS, "Tender amount is "+paymentAmount);
					
					driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
					test.log(LogStatus.PASS, "collateral type is "+ESign_CollateralType);
					
					/*driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(DisbType);
					test.log(LogStatus.PASS, "Disb type is "+DisbType);
					
					String disdAmount=driver.findElement(By.id("refinanceLoanAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Total Disb amount is "+disdAmount);
					
					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(disdAmount);
					test.log(LogStatus.PASS, "Disb amount is "+disdAmount);
					*/
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					
					if(ESign_CourtesyCallConsent.equals("Yes"))
					{
						Thread.sleep(1000);
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try {
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					
					}
					
					driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
					test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
					driver.findElement(By.name("finishLoan")).click();
					test.log(LogStatus.PASS, "click on Finish Conversion button ");
					Thread.sleep(500);
					//------------------------------------------------------------------------------------------------------------		
					try {
						Alert alert = driver.switchTo().alert();
						alert.accept();
						//if alert present, accept and move on.
					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
																		
					String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b")).getText();																							                                                  
					String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();				                                                  
					//String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/b")).getText();
					

					test.log(LogStatus.PASS, confirm_text1 +" First Payment Date: "+confirm_text3);
					Thread.sleep(500);
					driver.findElement(By.name("OKBut")).click();

					test.log(LogStatus.PASS, "click on Yes button ");
					Thread.sleep(2500);
					driver.findElement(By.xpath("//*[@id='docEditor']/form/table/tbody/tr[4]/td/input[1]")).click();
					test.log(LogStatus.PASS, "Clicked on Yes button ");
					Thread.sleep(2500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					if(driver.findElement(By.name("ok")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Installment Conversion completed successfully ");
						test.log(LogStatus.INFO, "**********************************************************************************");

					}
					else
					{
						test.log(LogStatus.FAIL, "Installment Conversion is not completed successfully ");
					}
					break;
				
				}	
				
			//break;
		}

	}
	
	public static void TLPILPConversion(String SSN,String AppURL) throws Exception{
		String sheetName="Conversion";	
		int lastrow=TestData.getLastRow(sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
				
			{		
				NewLoan_ProductName = TestData.getCellData(sheetName, "NewLoan_ProductName", row);
				NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
				ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				
				State = TestData.getCellData(sheetName, "StateID", row);
				ProductID = TestData.getCellData(sheetName, "ProductID", row);
				ProductType = TestData.getCellData(sheetName, "ProductType", row);
				StoreID = TestData.getCellData(sheetName, "StoreID", row);
				stateProduct = State + " " + ProductID;
				stateProductType = State + " " + ProductType;
				test.log(LogStatus.PASS, "Loan Type is "+stateProductType);
				
				
				String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
				String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
				String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);
				String ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);
				String No_of_checks = TestData.getCellData(sheetName,"No_of_checks",row);
				String ESign_Password = TestData.getCellData(sheetName,"ESign_Password",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String DisbType = TestData.getCellData(sheetName,"DisbType",row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"**************Coversion started**************");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Jprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(Jprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(Jprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		
				/*for(String winHandle : driver.getWindowHandles())
					{
				    driver.switchTo().window(winHandle);*/				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(2000);					  
				/*	for( String winHandle1 : driver.getWindowHandles())
					{
					    driver.switchTo().window(winHandle1);
					}*/			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/table/tbody/tr/td/table/tbody/tr[7]/td[13]/input[1]")).click();
				//driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys("Conversion");
				test.log(LogStatus.PASS, "Transaction Type is selected as Conversion");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				Thread.sleep(1000);
				
				/*driver.findElement(By.xpath("//*[contains(@value,',1')]")).click();
				test.log(LogStatus.PASS, "UnSelect on PDL Loan Check box");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[contains(@value,',2')]")).click();
				test.log(LogStatus.PASS, "Select on ILP Loan Check box");
				
				driver.findElement(By.id("go_Button")).click();
				test.log(LogStatus.PASS, "Clicked on Continue button");
				Thread.sleep(1000);*/
				try{
				driver.findElement(By.xpath("//*[@id='veh1']")).click();
				test.log(LogStatus.PASS, "Clicked on yes button");
				}
				catch(Exception ex)
				{
					
				}
				Thread.sleep(3000);		
				driver.findElement(By.xpath("//*[@name='requestBean.collateralType']")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
				Thread.sleep(10000);
				test.log(LogStatus.PASS, "getting product name ");
				List<WebElement>  rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")); 

				int n=rows.size();
				Thread.sleep(3000);	
				driver.findElement(By.xpath("(//*[@name='prodSel'])[1]")).click();
				test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
				/*for(int i=2;i<=n;i++){
					String Pname=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();
					test.log(LogStatus.PASS, "getting product name "+Pname);*/
					

					/*if(Pname.equals(stateProductType))
					{
						driver.findElement(By.xpath("//*[@id='termSel1']")).click();
						test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
						if(NewLoan_Term.equals("Term1"))
						{
							driver.findElement(By.xpath("//*[@id='termSel1']")).click();
							test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
						}
						else if(NewLoan_Term.equals("Term2"))
						{
							driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/b/input")).click();
							test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
						}	
						else if(NewLoan_Term.equals("Term3"))
						{
							driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/table/tbody/tr/td[2]/table[3]/tbody/tr[1]/td/b/input")).click();
							test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
						}
					}
					else{
						continue;
					}*/
					
				//}
					/*String loanAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[2]/td")).getText();
					test.log(LogStatus.PASS, "ILP loan amount is : "+loanAmt);
					String term=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[3]/td")).getText();
					test.log(LogStatus.PASS, "Term is : "+term);
					String inst=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[4]/td")).getText();
					test.log(LogStatus.PASS, "Number of installments is : "+inst);
					String rate=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[5]/td")).getText();
					test.log(LogStatus.PASS, "Interest rate is : "+rate);
					String apr=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[6]/td/input")).getAttribute("value");
					test.log(LogStatus.PASS, "APR is : "+apr);
					String payAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[7]/td/input")).getAttribute("value");
					test.log(LogStatus.PASS, "Payment Amount is : "+payAmt);
					String payDate=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[8]/td")).getText();
					test.log(LogStatus.PASS, "Payment Date is : "+payDate);
					String freq=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[9]/td")).getText();
					test.log(LogStatus.PASS,  "Frequence is : "+freq);
					String minLoanAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[10]/td")).getText();
					test.log(LogStatus.PASS, "Minimum loan amount is : "+minLoanAmt);
					String maxLoanAmt=driver.findElement(By.xpath("//*[@id='tableWid3']/tbody/tr[11]/td")).getText();
					test.log(LogStatus.PASS, "Maximum loan amount is : "+maxLoanAmt);*/
					Thread.sleep(5000);

					driver.findElement(By.id("LoanButtonId")).click();
					test.log(LogStatus.PASS, "Clicked on Conversion button ");
					
					Thread.sleep(5000);
					try
					{
						driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
					}
					catch(Exception ex)
					{
						
					}

				
				driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Click On Qualify button");
				Thread.sleep(1000);
				
				driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Click On Qualify button");
				Thread.sleep(500);
				
				driver.findElement(By.id("qualifyBTN")).click();
				test.log(LogStatus.PASS, "Click On Qualify button");
				Thread.sleep(500);
				
				driver.findElement(By.id("qualifyBTN")).click();
				test.log(LogStatus.PASS, "Click On Qualify button");
				
				
					Thread.sleep(9000);
					String paymentAmount=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Payment amount is "+paymentAmount);
					
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender type is "+TenderType);
					
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).clear();
					
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(paymentAmount);
					test.log(LogStatus.PASS, "Tender amount is "+paymentAmount);
					
					driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
					test.log(LogStatus.PASS, "collateral type is "+ESign_CollateralType);
					
					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(DisbType);
					test.log(LogStatus.PASS, "Disb type is "+DisbType);
					
					String disdAmount=driver.findElement(By.id("refinanceLoanAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Total Disb amount is "+disdAmount);
					
					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(disdAmount);
					test.log(LogStatus.PASS, "Disb amount is "+disdAmount);
					
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					
					if(ESign_CourtesyCallConsent.equals("Yes"))
					{
						Thread.sleep(1000);
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try {
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					
					}
					
					driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
					test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
					driver.findElement(By.name("finishLoan")).click();
					test.log(LogStatus.PASS, "click on Finish Conversion button ");
					Thread.sleep(500);
					//------------------------------------------------------------------------------------------------------------		
					try {
						Alert alert = driver.switchTo().alert();
						alert.accept();
						//if alert present, accept and move on.
					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
																		
					/*String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b")).getText();																							                                                  
					String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();				                                                  
					//String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/b")).getText();
					

					test.log(LogStatus.PASS, confirm_text1 +" First Payment Date: "+confirm_text3);*/
					Thread.sleep(30000);
					driver.findElement(By.name("OKBut")).click();

					test.log(LogStatus.PASS, "click on Yes button ");
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='docEditor']/form/table/tbody/tr[4]/td/input[1]")).click();
					test.log(LogStatus.PASS, "Clicked on Yes button ");
					Thread.sleep(2500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					if(driver.findElement(By.name("ok")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Installment Conversion completed successfully ");
						test.log(LogStatus.INFO, "**********************************************************************************");

					}
					else
					{
						test.log(LogStatus.FAIL, "Installment Conversion is not completed successfully ");
					}
					break;
				
				}	
				
			//break;
		}

	}
	public static void ILPNotEligibleConversion(String SSN,String AppURL) throws Exception{
		String sheetName="Conversion";	
		int lastrow=TestData.getLastRow(sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
				
			{		
				NewLoan_ProductName = TestData.getCellData(sheetName, "NewLoan_ProductName", row);
				NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
				ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				
				State = TestData.getCellData(sheetName, "StateID", row);
				ProductID = TestData.getCellData(sheetName, "ProductID", row);
				ProductType = TestData.getCellData(sheetName, "ProductType", row);
				StoreID = TestData.getCellData(sheetName, "StoreID", row);
				stateProduct = State + " " + ProductID;
				stateProductType = State + " " + ProductType;
				test.log(LogStatus.PASS, "Loan Type is "+stateProductType);
				
				
				String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
				String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
				String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);
				String ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);
				String No_of_checks = TestData.getCellData(sheetName,"No_of_checks",row);
				String ESign_Password = TestData.getCellData(sheetName,"ESign_Password",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String DisbType = TestData.getCellData(sheetName,"DisbType",row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"**************Coversion started**************");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Jprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(Jprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(Jprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		
				/*for(String winHandle : driver.getWindowHandles())
					{
				    driver.switchTo().window(winHandle);*/				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(2000);					  
				/*	for( String winHandle1 : driver.getWindowHandles())
					{
					    driver.switchTo().window(winHandle1);
					}*/			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys("Conversion");
				test.log(LogStatus.PASS, "Transaction Type is selected as Conversion");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				Thread.sleep(1000);
				
				/*driver.findElement(By.xpath("//*[contains(@value,',2')]")).click();
				test.log(LogStatus.PASS, "Select on ILP Loan Check box");*/
				//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[5]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[7]/td[1]/input")).click();
				//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[5]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[4]/td[1]/input")).click();
				driver.findElement(By.id("go_Button")).click();
				test.log(LogStatus.PASS, "Clicked on Continue button");
				Thread.sleep(1000);
				
				test.log(LogStatus.PASS, "getting product name ");
				List<WebElement>  rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")); 

				//*[@id="termSel1"]
				int n=rows.size();
				for(int i=2;i<=n;i++){
					String Pname=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();
					test.log(LogStatus.PASS, "getting product name "+Pname);
					

					
							String ele=driver.findElement(By.xpath("//*[@id='errMsg']/ul/li")).getText();
							test.log(LogStatus.PASS, "Getting text "+ele);
							Thread.sleep(1000);
							if(("Getting text Customer has Write Off Loans with no other paid out loans since default").contains(ele)){
								             //Getting text Customer has Write Off Loans with no other paid out loans since default
								test.log(LogStatus.PASS, "Installment Conversion is Not Eligible ");
							test.log(LogStatus.INFO, "**********************************************************************************");

							break;
							}else{
								test.log(LogStatus.FAIL, "Installment Conversion is Eligible ");
								test.log(LogStatus.INFO, "**********************************************************************************");

								break;
							}
						
					
				}
								

			}
			
		}
		}
	public static void PDLNotEligibleConversion(String SSN,String AppURL) throws Exception{
		String sheetName="Conversion";	
		int lastrow=TestData.getLastRow(sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
				
			{		
				NewLoan_ProductName = TestData.getCellData(sheetName, "NewLoan_ProductName", row);
				NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
				ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				
				State = TestData.getCellData(sheetName, "StateID", row);
				ProductID = TestData.getCellData(sheetName, "ProductID", row);
				ProductType = TestData.getCellData(sheetName, "ProductType", row);
				StoreID = TestData.getCellData(sheetName, "StoreID", row);
				stateProduct = State + " " + ProductID;
				stateProductType = State + " " + ProductType;
				test.log(LogStatus.PASS, "Loan Type is "+stateProductType);
				
				
				String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
				String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
				String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);
				String ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);
				String No_of_checks = TestData.getCellData(sheetName,"No_of_checks",row);
				String ESign_Password = TestData.getCellData(sheetName,"ESign_Password",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String DisbType = TestData.getCellData(sheetName,"DisbType",row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"**************Coversion started**************");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Jprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(Jprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(Jprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		
				/*for(String winHandle : driver.getWindowHandles())
					{
				    driver.switchTo().window(winHandle);*/				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(2000);					  
				/*	for( String winHandle1 : driver.getWindowHandles())
					{
					    driver.switchTo().window(winHandle1);
					}*/			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys("Conversion");
				test.log(LogStatus.PASS, "Transaction Type is selected as Conversion");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				Thread.sleep(1000);
				//=======================================
				/*driver.findElement(By.xpath("(//*[@name='requestBean.chkName'])[1]")).click();*/
				/*driver.findElement(By.xpath("//*[contains(@value,',2')]")).click();
				test.log(LogStatus.PASS, "Select on ILP Loan Check box");
				*/
				driver.findElement(By.id("go_Button")).click();
				test.log(LogStatus.PASS, "Clicked on Continue button");
				Thread.sleep(1000);
				
				test.log(LogStatus.PASS, "getting product name ");
				List<WebElement>  rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")); 

				int n=rows.size();
				for(int i=2;i<=n;i++){
					String Pname=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();
					test.log(LogStatus.PASS, "getting product name "+Pname);
					

							String ele=driver.findElement(By.xpath("//*[@id='errMsg']/ul/li")).getText();
							test.log(LogStatus.PASS, "Getting text "+ele);
							
							if(ele.contains("Customer already have max number open/pending loans across the products")){
							test.log(LogStatus.PASS, "Installment Conversion is Not Eligible ");
							test.log(LogStatus.INFO, "**********************************************************************************");

							break;
							}else{
								test.log(LogStatus.FAIL, "Installment Conversion is Eligible ");
								test.log(LogStatus.INFO, "**********************************************************************************");

								break;
							}
						
					
				}
								

			}
			
		}
		}
	public static void PDLDefaultNotEligibleConversion(String SSN,String AppURL) throws Exception{
		String sheetName="Conversion";	
		int lastrow=TestData.getLastRow(sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
				
			{		
				NewLoan_ProductName = TestData.getCellData(sheetName, "NewLoan_ProductName", row);
				NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
				ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				
				State = TestData.getCellData(sheetName, "StateID", row);
				ProductID = TestData.getCellData(sheetName, "ProductID", row);
				ProductType = TestData.getCellData(sheetName, "ProductType", row);
				StoreID = TestData.getCellData(sheetName, "StoreID", row);
				stateProduct = State + " " + ProductID;
				stateProductType = State + " " + ProductType;
				test.log(LogStatus.PASS, "Loan Type is "+stateProductType);
				

				
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"**************Coversion started**************");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Jprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(Jprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(Jprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		
				/*for(String winHandle : driver.getWindowHandles())
					{
				    driver.switchTo().window(winHandle);*/				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(2000);					  
				/*	for( String winHandle1 : driver.getWindowHandles())
					{
					    driver.switchTo().window(winHandle1);
					}*/			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				
				Select trans = new Select(driver.findElement(By.name("transactionList")));
				List <WebElement> elementCount = trans.getOptions();
				int iSize = elementCount.size();

				for(int i =0; i<iSize ; i++){
					String sValue = elementCount.get(i).getText();
					test.log(LogStatus.PASS, "Transcation Dropdown Value: "+sValue);
					System.out.println(sValue);
					if(sValue.equalsIgnoreCase("Conversion")){
						
						test.log(LogStatus.FAIL, "Installment Conversion is Eligible ");
						test.log(LogStatus.INFO, "**********************************************************************************");

					}else{
						test.log(LogStatus.PASS, "Installment Conversion is Not Eligible ");
						test.log(LogStatus.INFO, "**********************************************************************************");

					}
					}
			

			}
			
		}
		}
}
			
		



	






