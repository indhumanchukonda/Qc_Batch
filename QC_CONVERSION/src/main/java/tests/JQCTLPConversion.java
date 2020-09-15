package tests;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class JQCTLPConversion extends QCStore {

	public static String State;
	public static String stateProductType;
	public static String stateProduct;
	public static String StoreID;
	public static String ProductType;
	public static String ProductID;
	public static String NewLoan_Term;
	public static String NewLoan_ProductName;
	public static String PhoneNbr3;
	public static String PhoneNbr2;
	public static String PhoneNbr1;
	public static String PhoneNbr;
	public static String InsuranceExpiryDate;
	public static String InsuranceExpiryDate0[] = null;
	public static String InsuranceExpiryDate3;
	public static String InsuranceExpiryDate2;
	public static String InsuranceExpiryDate1;

	public static void TLPConversion(String SSN,String AppURL) throws Exception{

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
				
				String VehicleType = TestData.getCellData(sheetName, "VehicleType", row);
				String VIN = TestData.getCellData(sheetName, "VIN", row);
				String NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
				String Miles = TestData.getCellData(sheetName, "Miles", row);
				String NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
				String TitleNumber = TestData.getCellData(sheetName, "TitleNumber", row);
				String VehicleMake = TestData.getCellData(sheetName, "VehicleMake", row);
				String VehicleModel = TestData.getCellData(sheetName, "VehicleModel", row);
				String VehicleYear = TestData.getCellData(sheetName, "VehicleYear", row);
				String License_Plate_Number = TestData.getCellData(sheetName, "License_Plate_Number", row);
				String ExteriorColor = TestData.getCellData(sheetName, "ExteriorColor", row);
				String VehicleGrade = TestData.getCellData(sheetName, "VehicleGrade", row);
				String InsuranceCoverage = TestData.getCellData(sheetName, "InsuranceCoverage", row);
				String InsuranceCompany = TestData.getCellData(sheetName, "InsuranceCompany", row);
				String PolicyNumber = TestData.getCellData(sheetName, "PolicyNumber", row);
				String InsuranceExpiryDate = TestData.getCellData(sheetName, "InsuranceExpiryDate", row);
				String Selectcard = TestData.getCellData(sheetName, "Selectcard", row);
				String CardType = TestData.getCellData(sheetName, "CardType", row);
				String CardNbr = TestData.getCellData(sheetName, "CardNbr", row);
				String Expmonth = TestData.getCellData(sheetName, "Expmonth", row);
				String Expyear = TestData.getCellData(sheetName, "Expyear", row);
				String CVV = TestData.getCellData(sheetName, "CVV", row);
				String CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);
				
				
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
								
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(2000);					  
						
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
				
				
				driver.findElement(By.xpath("//*[@id='go_Button']")).click();
				test.log(LogStatus.PASS, "Clicked on continue button");
				
				driver.findElement(By.xpath("//*[@id='veh1']")).click();
				test.log(LogStatus.PASS, "Clicked on yes button");
				
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("vehicleType_dd"))));
				driver.findElement(By.name("vehicleType_dd")).sendKeys(VehicleType);
				test.log(LogStatus.PASS, "Vehicle Type is :" +VehicleType);
				driver.findElement(By.name("existingVin")).sendKeys(VIN);
				test.log(LogStatus.PASS, "VIN Type is :" +VIN);
				driver.findElement(By.name("newVinNbr")).sendKeys(NewVIN);
				test.log(LogStatus.PASS, "New VIN nbr is :" +NewVIN);
				driver.findElement(By.name("miles")).sendKeys(Miles);
				test.log(LogStatus.PASS, "Miles entered is :" +Miles);
				driver.findElement(By.name("bbHit_Button")).click();
				test.log(LogStatus.PASS, "Clicked on HitBlackBook Button");
				//wait.until(ExpectedConditions.elementToBeClickable(By.name("button2")));
				
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@name='requestBean.collateralType']")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
				
				Thread.sleep(10000);
																		
				test.log(LogStatus.PASS, "getting product name ");
				List<WebElement>  rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")); 

				int n=rows.size();
				for(int i=2;i<=n;i++){
					String Pname=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();
					test.log(LogStatus.PASS, "getting product name "+Pname);
					

					if(Pname.equals(stateProductType.trim()))
					{
						if(NewLoan_Term.equals("Term1"))
						{
							driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/table/tbody/tr/td[2]/table[1]/tbody/tr[1]/td/b/input")).click();
							test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);	
							
							Thread.sleep(3000);
							driver.findElement(By.xpath("//*[@id='LoanButtonId']")).click();
							test.log(LogStatus.PASS, "Clicked on Conversion");
							
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='titleNumber']")));
							driver.findElement(By.xpath("//*[@id='titleNumber']")).clear();
							Thread.sleep(3000);
							driver.findElement(By.xpath("//*[@id='titleNumber']")).sendKeys(TitleNumber);
							test.log(LogStatus.PASS, "title number is :" +TitleNumber);
							Thread.sleep(3000);
							driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table[2]/tbody/tr[4]/td/input")).click();
							test.log(LogStatus.PASS, "Clicked on Update");
							wait.until(ExpectedConditions.elementToBeClickable(By.name("requestBean.vehicleMake")));
							Thread.sleep(3000);
							driver.findElement(By.name("requestBean.vehicleMake")).clear();
							driver.findElement(By.name("requestBean.vehicleMake")).sendKeys(VehicleMake);
							test.log(LogStatus.PASS, "Vehicle Make is :" +VehicleMake);
							Thread.sleep(3000);
						
							driver.findElement(By.name("requestBean.vehicleModel")).sendKeys(VehicleModel);
							test.log(LogStatus.PASS, "Vehicle Model is :" +VehicleModel);
							Thread.sleep(700);
						
							driver.findElement(By.name("requestBean.vehicleYear")).sendKeys(VehicleYear);
							test.log(LogStatus.PASS, "Vehicle Year is :" +VehicleYear);
							Thread.sleep(500);
						
							driver.findElement(By.name("requestBean.licensePltNbr")).sendKeys(License_Plate_Number);
							test.log(LogStatus.PASS, "License number is :" +License_Plate_Number);
							Thread.sleep(500);
							driver.findElement(By.name("requestBean.extClr")).sendKeys(ExteriorColor);
							test.log(LogStatus.PASS, "Exterior Color is :" +ExteriorColor);
							Thread.sleep(500);
							
							driver.findElement(By.name("requestBean.vehicleGrade")).sendKeys(VehicleGrade);
							test.log(LogStatus.PASS, "Vehicle grade is :" +VehicleGrade);
							Thread.sleep(700);
					
							driver.findElement(By.name("requestBean.coverageType")).sendKeys(InsuranceCoverage);
							test.log(LogStatus.PASS, "Insurance is :" +InsuranceCoverage);
							Thread.sleep(500);
							
							driver.findElement(By.name("requestBean.companyName")).sendKeys(InsuranceCompany);
							test.log(LogStatus.PASS, "Insurance Company is :" +InsuranceCompany);
							Thread.sleep(500);
						
							driver.findElement(By.name("requestBean.polocyNbr")).sendKeys(PolicyNumber);
							test.log(LogStatus.PASS, "Policy Number is :" +PolicyNumber);
							
							PhoneNbr  = TestData.getCellData(sheetName, "PhoneNbr", row);
							PhoneNbr1 = PhoneNbr.substring(0, 3);
							PhoneNbr2 = PhoneNbr.substring(3, 6);
							PhoneNbr3 = PhoneNbr.substring(6, 10);
							driver.findElement(By.name("iPhoneNbr1")).clear();
							driver.findElement(By.name("iPhoneNbr1")).sendKeys(PhoneNbr1);
							test.log(LogStatus.PASS, "Entereted phone number field 1 as  " + PhoneNbr1);
							Thread.sleep(500);
							driver.findElement(By.name("iPhoneNbr2")).clear();
							driver.findElement(By.name("iPhoneNbr2")).sendKeys(PhoneNbr2);
							test.log(LogStatus.PASS, "Entereted phone number field 2 as  " + PhoneNbr2);
							Thread.sleep(500);
							driver.findElement(By.name("iPhoneNbr3")).clear();
							driver.findElement(By.name("iPhoneNbr3")).sendKeys(PhoneNbr3);
							test.log(LogStatus.PASS, "Entereted phone number field 3 as  " + PhoneNbr3);
							driver.findElement(By.name("requestBean.companyName")).clear();
							driver.findElement(By.name("requestBean.companyName")).sendKeys(InsuranceCompany);
							test.log(LogStatus.PASS, "Entered Insurance company as " + InsuranceCompany);
							InsuranceExpiryDate0 = InsuranceExpiryDate.split("/");
							InsuranceExpiryDate1 = InsuranceExpiryDate0[0];
							InsuranceExpiryDate2 = InsuranceExpiryDate0[1];
							InsuranceExpiryDate3 = InsuranceExpiryDate0[2];
							Thread.sleep(500);
							driver.findElement(By.name("iexpiry1")).clear();
							driver.findElement(By.name("iexpiry1")).sendKeys(InsuranceExpiryDate1);									
							test.log(LogStatus.PASS, "Entereted Insurance expiry date field 1 as  " + InsuranceExpiryDate1);
							Thread.sleep(500);
							driver.findElement(By.name("iexpiry2")).clear();
							driver.findElement(By.name("iexpiry2")).sendKeys(InsuranceExpiryDate2);
							
							test.log(LogStatus.PASS, "Entereted Insurance expiry date field 2 as  " + InsuranceExpiryDate2);
							Thread.sleep(500);
							driver.findElement(By.name("iexpiry3")).clear();
							driver.findElement(By.name("iexpiry3")).sendKeys(InsuranceExpiryDate3);
							
							test.log(LogStatus.PASS, "Entereted Insurance expiry date field 3 as  " + InsuranceExpiryDate3);
							
							Thread.sleep(6000);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("button2")));
							driver.findElement(By.name("button2")).click();
							Thread.sleep(700);
							driver.findElement(By.name("button2")).click();
							test.log(LogStatus.PASS, "Clicked on update button ");
							Thread.sleep(5000);

							wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("process")));
							driver.findElement(By.name("process")).click();

							test.log(LogStatus.PASS, "click on process Loan button ");							
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
							Thread.sleep(500);
							
							driver.findElement(By.name("qualify")).click();
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
								
								if (ESign_CollateralType.equals("DEBIT CARD")) {
   								 driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
   	    						 test.log(LogStatus.PASS, "collateralType is :" + ESign_CollateralType);
   	    						 Thread.sleep(500);

   	    						 driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys(Selectcard);

   	    							test.log(LogStatus.PASS, "Select card as : " + "Selectcard");
   	    							Thread.sleep(500);
   	    							driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(CardNbr);

   	    							test.log(LogStatus.PASS, "Card number is :" + CardNbr);
   	    							Thread.sleep(500);
   	    							driver.findElement(By.xpath("//*[@id='cardType']/select")).sendKeys(CardType);

   	    							test.log(LogStatus.PASS, "Enterd card Type : " + CardType);
   	    							Thread.sleep(500);
   	    							driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(Expmonth);

   	    							test.log(LogStatus.PASS, "Enterd Expiry month " + Expmonth);
   	    							Thread.sleep(500);
   	    							driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(Expyear);
   	    							Thread.sleep(500);
   	    							test.log(LogStatus.PASS, "Enterd Expiry year " + Expyear);

   	    							driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(CVV);

   	    							test.log(LogStatus.PASS, "Enterd CVV " + CVV);

   	    							driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);

   	    							test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
   	    						 
   	    							driver.findElement(
   	    									By.xpath("//input[@class='sortbuttons' and @onclick='this.disabled=true;addCard(this);']")).click();

   	    							test.log(LogStatus.PASS, "Clicked on add card button ");

   	    							Thread.sleep(30000);
   	    							wait.until(ExpectedConditions.elementToBeClickable(By.name("requestBean.siilBean.courtesyCallFlag")));
   	    							driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
   	    							test.log(LogStatus.PASS, "Courtesy call selected : "+ESign_CourtesyCallConsent);
   								 
   							 }
								 else{
									 driver.findElement(By.name("collateralType")).sendKeys("SIGNATURE");
										test.log(LogStatus.PASS, "collateral type is SIGNATURE");
									
										driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
										test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
 
    							 }

								if(ESign_CourtesyCallConsent.equals("Yes"))
								{
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
								
					//=============	when getting Invalid Payload we are not getting DisbType field in Conversion screen ===========
								try {
								driver.findElement(By.xpath("//*[@name='requestBean.siilBean.disbType']")).sendKeys(DisbType);
								test.log(LogStatus.PASS, "Disb_type is selected as "+DisbType);
								//*[@name='requestBean.siilBean.balancePrincipal']
								String disb_amount=driver.findElement(By.xpath("//*[@id='refinanceLoanAmt']")).getAttribute("value");
								
								driver.findElement(By.xpath("//*[@name='requestBean.siilBean.disbAmtFirst']")).sendKeys(disb_amount);
								test.log(LogStatus.PASS, "disb_amount is selected as "+disb_amount);
								}
								catch (Exception e) {
									
								}
								Thread.sleep(1500);
								driver.findElement(By.name("finishLoan")).click();
								//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[12]/td/table/tbody/tr[11]/td[2]/input")).click();
								test.log(LogStatus.PASS, "click on Finish Conversion button ");
								
								Thread.sleep(500);
					//==================================================================================
								//------------------------------------------------------------------------------------------------------------		
								try {
									Alert alert = driver.switchTo().alert();
									alert.accept();
									//if alert present, accept and move on.
								}
								catch (NoAlertPresentException e) {
									//do what you normally would if you didn't have the alert.
								}
								Thread.sleep(15000);
								driver.switchTo().defaultContent();
								driver.switchTo().frame("mainFrame");
								driver.switchTo().frame("main");
								
							/*	String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b/b[2]")).getText();																		
								String confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();					                                                  
								String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/b/font")).getText();				                                                  
								String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[5]/td/b")).getText();
								String confirm_text5=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b")).getText();
								
								                                                  
							
								test.log(LogStatus.PASS, confirm_text5 +" Title Loan of  "+confirm_text1+" First Payment Date: "+confirm_text2+" Payout to Customer: "+confirm_text3+" Cash. This loan includes "+confirm_text4);
								Thread.sleep(800);*/
								driver.findElement(By.name("OKBut")).click();

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
									test.log(LogStatus.PASS, "Multi Title Conversion completed successfully ");
									test.log(LogStatus.INFO, "**********************************************************************************");

								}
								else
								{
									test.log(LogStatus.FAIL, "Multi Title Conversion is not completed successfully ");
								}
								break;
							
							}	
							
						break;
    								
					}
						}
						
					}
					else{
						continue;
					}
					
				}
			
							
	}
}
			
		



	






