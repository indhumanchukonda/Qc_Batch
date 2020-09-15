package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class QCCSRILPConversion extends QCStore {
public static int rnum;
public static int cnum;
public static String PhoneNbr3;
public static String PhoneNbr2;
public static String PhoneNbr1;
public static String PhoneNbr;
public static String InsuranceExpiryDate;
public static String InsuranceExpiryDate0[] = null;
public static String InsuranceExpiryDate3;
public static String InsuranceExpiryDate2;
public static String InsuranceExpiryDate1;

	public static void conversion(String SSN, String AppURL) throws Exception
	{
	
		try {
			
			int lastrow = TestData.getLastRow("ILP_Conversion");
			String sheetName = "ILP_Conversion";

			for (int row = 2; row <= lastrow; row++) {

				
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				if (SSN.equals(RegSSN)) {
					String UserName = TestData.getCellData(sheetName, "UserName", row);
					String Password = TestData.getCellData(sheetName, "Password", row);
					String PIN = TestData.getCellData(sheetName, "PIN", row);
					
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String ProductType = TestData.getCellData(sheetName, "ProductType", row);
					String stateProductType = StateID + " " + ProductType;
					String TxnType = TestData.getCellData(sheetName, "TxnType", row);
					String DisbType = TestData.getCellData(sheetName, "DisbType", row);
					
					String TenderType = TestData.getCellData(sheetName, "TenderType", row);
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
					String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String ESign_CourtesyCallConsent = TestData.getCellData(sheetName, "ESign_CourtesyCallConsent", row);
					String Selectcard = TestData.getCellData(sheetName, "Selectcard", row);
					String CardType = TestData.getCellData(sheetName, "CardType", row);
					String CardNbr = TestData.getCellData(sheetName, "CardNbr", row);
					String Expmonth = TestData.getCellData(sheetName, "Expmonth", row);
					String Expyear = TestData.getCellData(sheetName, "Expyear", row);
					String CVV = TestData.getCellData(sheetName, "CVV", row);
					String CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);
					String No_of_checks = TestData.getCellData(sheetName, "No_of_checks", row);
					ESign_CheckNbr=SSN.substring(SSN.length() - 6);
					
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3, 5);
					String SSN3 = SSN.substring(5, 9);

					Thread.sleep(4000);
					
					test.log(LogStatus.INFO, "conversion has Started");
					driver.switchTo().defaultContent();

					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					Thread.sleep(4000);
					driver.findElement(By.cssSelector("li[id='910000']")).click();

					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(4000);

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(By.cssSelector("li[id='911101']")).click();
					test.log(LogStatus.PASS, "Clicked on Transactions");
					driver.switchTo().frame("main");
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
					driver.findElement(By.name("ssn2")).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
					driver.findElement(By.name("ssn3")).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
					driver.findElement(By.name("submit1")).click();
					test.log(LogStatus.PASS, "Click on submit Button");
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					Thread.sleep(4000);
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
				

					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					
                   				
					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as :" + TxnType);
					Thread.sleep(500);
					//driver.findElement(By.xpath("//input[@value='11032281,2']")).click();
					driver.findElement(By.xpath("//*[@id='go_Button']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					//Thread.sleep(30000);
					 
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					//driver.findElement(By.xpath("//input[@value='11032281,2']")).click();
					/*driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[5]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[4]/td[1]/input")).click();
					                             
					//*[@id="go_Button"]
					test.log(LogStatus.PASS, "Clicked on PDL check box");*/
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='go_Button']")).click();
					
					
					test.log(LogStatus.PASS, "Clicked on Continue button");
					//Thread.sleep(5000);
					
					
					
	//==============================================================================================
					

					
					
					driver.findElement(By.xpath("//*[@name='requestBean.collateralType']")).sendKeys(ESign_CollateralType);
					test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
					//List<WebElement> rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"));
					
					//driver.findElements(By.xpath("//*[@id='termSel1']"));
					
					//*[@id="termSel1"]
					
				   // List<WebElement>  rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"));
					                                                      //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]

					//int n = rows.size();

					//for (int i = 2; i <= n; i++)
					
					{

						//String Pname = driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[" + i + "]/td[2]")).getText();

						//test.log(LogStatus.PASS, "getting product name " + Pname);

						//if (Pname.equals(stateProductType))

						{

							//if (NewLoan_Term.equals("Term1"))

							{

								//driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[" + i + "]/td[5]/table/tbody/tr/td[2]/table[1]/tbody/tr[1]/td/b/input")).click();
								Thread.sleep(5000);
								driver.findElement(By.xpath("//*[@id='termSel1']")).click();
								
								//*[@id="termSel1"]

								test.log(LogStatus.PASS, "Selected check box as " + NewLoan_Term);							
								
								
								
								Thread.sleep(5000);
								driver.findElement(By.xpath("//*[@id='LoanButtonId']")).click();
								test.log(LogStatus.PASS, "Clicked on Conversion");
								
								
								driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
								test.log(LogStatus.PASS, "Clicked on Conversion popup");
															
                               
                                String PaymentAmt = driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
    							test.log(LogStatus.PASS, "PaymentAmt is :" + PaymentAmt);
    							
    							Thread.sleep(5000);
    							
    							 if (ESign_CollateralType.equals("DEBIT CARD")) {
    								 driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
    	    						 test.log(LogStatus.PASS, "collateralType is :" + ESign_CollateralType);
    	    						 Thread.sleep(500);
    	    						 
    	    						 
    	    						 
    	    						 //driver.findElement(By.name("cardNmbr")).sendKeys(Selectcard);
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
    								 Thread.sleep(5000);
    								 
    	    					
    	    						 //String totaldisbamt=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
    	    						 //test.log(LogStatus.PASS, "Total Disb Amt is : "+totaldisbamt); 
    								 
    								 
    								 
    	    						 Thread.sleep(500);
    	    							try { 
    	    							   // Alert alert = driver.switchTo().alert();
    	    							    //alert.accept();
    	    								//driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
    	    								//*[@id="documentForm"]/table/tbody/tr[4]/td/input[1]
    	    																		
    	    								
    	    							}
    	    							catch (NoAlertPresentException e) {
    	    							    //do what you normally would if you didn't have the alert.
    	    							}
    	    						 //driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys("Cash");
    	    						 //test.log(LogStatus.PASS, "Disb Type is Cash");
    	    						
    	    					
 	                                 Thread.sleep(500);
 	                                 
 	    							 
 	    							
 	                           	     //Thread.sleep(500);
	    						 
 	    						
	    						     wait.until(ExpectedConditions.elementToBeClickable(By.name("qualify")));
	                                 driver.findElement(By.name("qualify")).click();
	                                 test.log(LogStatus.PASS, "Clicked on Qualify button ");
	                                 wait.until(ExpectedConditions.elementToBeClickable(By.name("requestBean.siilBean.tenderTypeFirst")));
 	                                 Thread.sleep(5000);
 	                                 driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
 	                                 test.log(LogStatus.PASS, "Tendertype selected as "+TenderType);
	                                 driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).clear();
 	    							 driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(PaymentAmt);
 	    							 test.log(LogStatus.PASS, "TenderAmt is :" + PaymentAmt);
    	    						 driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
    	    						 test.log(LogStatus.PASS, "collateralType is :" + ESign_CollateralType);
    	    						 String totaldisbamt=driver.findElement(By.id("refinanceLoanAmt")).getAttribute("value");
    	    						 test.log(LogStatus.PASS, "Total Disb Amt is : "+totaldisbamt); 
    	    						 driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(totaldisbamt);
    	    						 test.log(LogStatus.PASS, "Disb Amount Entered as:"+totaldisbamt);
    	    						 Thread.sleep(5000);
    	    						 driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(DisbType);
   	    						     test.log(LogStatus.PASS, "Disb Amount Entered as:"+DisbType);
   	    							 Thread.sleep(6000);
   	    							 //driver.findElement(By.name("OKBut")).click();
   	    							 //test.log(LogStatus.PASS, "Clicked on Yes button");
   	    							/*driver.findElement(By.name("requestBean.siilBean.checkopt")).isSelected();
   	    						    Select checks = new Select(driver.findElement(By.name("requestBean.siilBean.checkopt")));
   	    						    checks.selectByVisibleText("1");
   	    							 driver.findElement(By.name("checkyes")).click();*/

   	    						
	                                 
    	    						 driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
 	    							 test.log(LogStatus.PASS, "Courtesy call selected : "+ESign_CourtesyCallConsent);   
 	    							 driver.findElement(By.name("requestBean.siilBean.preference")).click();
    	    						 test.log(LogStatus.PASS, "Preference as PhoneCall");
    	    						 if(DisbType.equals("Check"))	
    	    							{
    	    								
    	    						 //driver.findElement(By.name("requestBean.noOfChecks")).sendKeys(No_of_checks);
    	    						 driver.findElement(By.name("requestBean.siilBean.checkopt")).sendKeys(No_of_checks);
    	    						 
    	    			    		 test.log(LogStatus.PASS, "Selected no of checks as " + No_of_checks);
    	    			    		 driver.findElement(By.name("requestBean.siilBean.checkopt")).sendKeys(Keys.ENTER);
    	    			    		 Thread.sleep(2000);
    	    			    		 driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();
    	    			    		 test.log(LogStatus.PASS, "isCustCheck button");
    	    							
    	    			    		 
    	    			    		 //driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys("250");
    	    			    		 driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(totaldisbamt);
    	    			    		 test.log(LogStatus.PASS, "Disb Amount Entered as:"+totaldisbamt);
    	    							}
    	    			    		/* driver.findElement(By.name("chkNbr0")).sendKeys(ESign_CheckNbr);
    	    			    		 test.log(LogStatus.PASS, "Check number is " + ESign_CheckNbr);*/
    	    			    			// driver.findElement(By.name("chkBoxNbr0")).click();
    	    			    			// test.log(LogStatus.PASS, "Selected the Check option radio
    	    			    			// button");
    	    			    			/*driver.findElement(By.name("Print0")).click();
    	    			    			test.log(LogStatus.PASS, "Clicked on Print button");*/
    	    						 Thread.sleep(5000);
    	                                
    	    						/* driver.findElement(By.name("requestBean.siilBean.checkopt")).isSelected();
    	    						 Select checks = new Select(driver.findElement(By.name("requestBean.siilBean.checkopt")));
    	    						 checks.selectByVisibleText("1");*/
    	    					
    								 
    							 }
    								    							     							 
    							 Thread.sleep(5000);
    							driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
    							test.log(LogStatus.PASS, "Pin Entered :"+PIN);
    							driver.findElement(By.name("finishLoan")).click();
    							test.log(LogStatus.PASS, "Clicked on Finish Conversion");
    							Thread.sleep(30000);
    							wait.until(ExpectedConditions.elementToBeClickable(By.name("OKBut")));
    							driver.findElement(By.name("OKBut")).click();
    							test.log(LogStatus.PASS, "Clicked on Yes");
    							Thread.sleep(500);
    							test.log(LogStatus.PASS, "Conversion Completed Successfully");
    							//driver.close();
    							
    							
    							
    							
    							
								
							}

					
							
							/*else if (NewLoan_Term.equals("Term2"))

							{

								driver.findElement(By
										.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["
												+ rnum + "]/td[5]/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/b/input"))
										.click();

								test.log(LogStatus.PASS, "Selected check box as " + NewLoan_Term);

							}

						}

						else {

							continue;

						}*/
	

					break;
				}
			}

		}
	}
		}

		catch (Exception e) {
		
			test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
			String screenshotPath = getScreenhot(driver, "Exception");
							test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "Conversion failed");

		}

	}

public static void conversionwithmultipledisb(String SSN, String AppURL) throws Exception
{

	try {
		
		int lastrow = TestData.getLastRow("ILP_Conversion");
		String sheetName = "ILP_Conversion";

		for (int row = 2; row <= lastrow; row++) {

			
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			if (SSN.equals(RegSSN)) {
				String UserName = TestData.getCellData(sheetName, "UserName", row);
				String Password = TestData.getCellData(sheetName, "Password", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				
				String StateID = TestData.getCellData(sheetName, "StateID", row);
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);
				String stateProductType = StateID + " " + ProductType;
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String DisbType = TestData.getCellData(sheetName, "DisbType", row);
				String DisbType1 = TestData.getCellData(sheetName, "DisbType1", row);
				String TenderType = TestData.getCellData(sheetName, "TenderType", row);
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
				String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				String ESign_CourtesyCallConsent = TestData.getCellData(sheetName, "ESign_CourtesyCallConsent", row);
				String Selectcard = TestData.getCellData(sheetName, "Selectcard", row);
				String CardType = TestData.getCellData(sheetName, "CardType", row);
				String CardNbr = TestData.getCellData(sheetName, "CardNbr", row);
				String Expmonth = TestData.getCellData(sheetName, "Expmonth", row);
				String Expyear = TestData.getCellData(sheetName, "Expyear", row);
				String CVV = TestData.getCellData(sheetName, "CVV", row);
				String CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);
				String No_of_checks = TestData.getCellData(sheetName, "No_of_checks", row);
				ESign_CheckNbr=SSN.substring(SSN.length() - 6);
				
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3, 5);
				String SSN3 = SSN.substring(5, 9);

				Thread.sleep(4000);
				
				test.log(LogStatus.INFO, "conversion has Started");
				driver.switchTo().defaultContent();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
				Thread.sleep(4000);
				driver.findElement(By.cssSelector("li[id='910000']")).click();

				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(4000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transactions");
				driver.switchTo().frame("main");
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				Thread.sleep(4000);
				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on Go button under search results");
			

				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				
				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				
               				
				driver.findElement(By.name("transactionList")).sendKeys(TxnType);
				test.log(LogStatus.PASS, "Transaction Type is selected as :" + TxnType);
				Thread.sleep(500);
				//driver.findElement(By.xpath("//input[@value='11032281,2']")).click();
				driver.findElement(By.xpath("//*[@id='go_Button']")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				//Thread.sleep(30000);
				 
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				//driver.findElement(By.xpath("//input[@value='11032281,2']")).click();
				/*driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[5]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[4]/td[1]/input")).click();
				                             
				//*[@id="go_Button"]
				test.log(LogStatus.PASS, "Clicked on PDL check box");*/
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='go_Button']")).click();
				
				
				test.log(LogStatus.PASS, "Clicked on Continue button");
				//Thread.sleep(5000);
				
				
				
//==============================================================================================
				
				driver.findElement(By.xpath("//*[@name='requestBean.collateralType']")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
				//List<WebElement> rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"));
				
				//driver.findElements(By.xpath("//*[@id='termSel1']"));
				
				//*[@id="termSel1"]
				
			   // List<WebElement>  rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"));
				                                                      //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]

				//int n = rows.size();

				//for (int i = 2; i <= n; i++)
				
				{

					//String Pname = driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[" + i + "]/td[2]")).getText();

					//test.log(LogStatus.PASS, "getting product name " + Pname);

					//if (Pname.equals(stateProductType))

					{

						//if (NewLoan_Term.equals("Term1"))

						{

							//driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[" + i + "]/td[5]/table/tbody/tr/td[2]/table[1]/tbody/tr[1]/td/b/input")).click();
							Thread.sleep(3000);
							driver.findElement(By.xpath("//*[@id='termSel1']")).click();
							test.log(LogStatus.PASS, "Selected check box as " + NewLoan_Term);
							Thread.sleep(3000);
							driver.findElement(By.xpath("//*[@id='LoanButtonId']")).click();
							test.log(LogStatus.PASS, "Clicked on Conversion");
							
							
                           
                            String PaymentAmt = driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
							test.log(LogStatus.PASS, "PaymentAmt is :" + PaymentAmt);
							
							Thread.sleep(5000);
							
							 if (ESign_CollateralType.equals("DEBIT CARD")) {
								 driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
	    						 test.log(LogStatus.PASS, "collateralType is :" + ESign_CollateralType);
	    						 Thread.sleep(500);
	    						 
	    						 
	    						 
	    						 //driver.findElement(By.name("cardNmbr")).sendKeys(Selectcard);
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
								 Thread.sleep(5000);
								 
	    					
	    						 //String totaldisbamt=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
	    						 //test.log(LogStatus.PASS, "Total Disb Amt is : "+totaldisbamt); 
								 
								 
								 
	    						 Thread.sleep(500);
	    							try { 
	    							   // Alert alert = driver.switchTo().alert();
	    							    //alert.accept();
	    								driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
	    								//*[@id="documentForm"]/table/tbody/tr[4]/td/input[1]
	    																		
	    								
	    							}
	    							catch (NoAlertPresentException e) {
	    							    //do what you normally would if you didn't have the alert.
	    							}
	    						 //driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys("Cash");
	    						 //test.log(LogStatus.PASS, "Disb Type is Cash");
	    						
	    					
	                                 Thread.sleep(500);
	                                 
	    							 
	    							
	                           	     //Thread.sleep(500);
    						 
	    						
    						     wait.until(ExpectedConditions.elementToBeClickable(By.name("qualify")));
                                 driver.findElement(By.name("qualify")).click();
                                 test.log(LogStatus.PASS, "Clicked on Qualify button ");
                                 wait.until(ExpectedConditions.elementToBeClickable(By.name("requestBean.siilBean.tenderTypeFirst")));
	                                 Thread.sleep(5000);
	                                 driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
	                                 test.log(LogStatus.PASS, "Tendertype selected as "+TenderType);
                                 driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).clear();
	    							 driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(PaymentAmt);
	    							 test.log(LogStatus.PASS, "TenderAmt is :" + PaymentAmt);
	    						 driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
	    						 test.log(LogStatus.PASS, "collateralType is :" + ESign_CollateralType);
	    						 String totaldisbamt=driver.findElement(By.id("refinanceLoanAmt")).getAttribute("value");
	    						 test.log(LogStatus.PASS, "Total Disb Amt is : "+totaldisbamt); 
	    						 
	    						Double totaldisbamt_double=Double.parseDouble(totaldisbamt);
	 							totaldisbamt_double=totaldisbamt_double/2;
	 							totaldisbamt=Double.toString(totaldisbamt_double);
	    						 
	    						 driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(totaldisbamt);
	    						 test.log(LogStatus.PASS, "Disb Amount Entered as:"+totaldisbamt);
	    						 Thread.sleep(5000);
	    						 driver.findElement(By.name("requestBean.siilBean.disbAmtSecond")).sendKeys(totaldisbamt);
	    						 test.log(LogStatus.PASS, "Disb Amount Entered as:"+totaldisbamt);
	    						 Thread.sleep(5000);
	    						 driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(DisbType);
	    						 test.log(LogStatus.PASS, "Disb Type Entered as:"+DisbType);
	    							 Thread.sleep(6000);
	    						 driver.findElement(By.name("requestBean.siilBean.disbTypeSecond")).sendKeys(DisbType1);
		    					 test.log(LogStatus.PASS, "Disb Type Entered as:"+DisbType1);
	    							 //driver.findElement(By.name("OKBut")).click();
	    							 //test.log(LogStatus.PASS, "Clicked on Yes button");
	    							/*driver.findElement(By.name("requestBean.siilBean.checkopt")).isSelected();
	    						    Select checks = new Select(driver.findElement(By.name("requestBean.siilBean.checkopt")));
	    						    checks.selectByVisibleText("1");
	    							 driver.findElement(By.name("checkyes")).click();*/

	    						
                                 
	    						 driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
	    							 test.log(LogStatus.PASS, "Courtesy call selected : "+ESign_CourtesyCallConsent);   
	    							 driver.findElement(By.name("requestBean.siilBean.preference")).click();
	    						 test.log(LogStatus.PASS, "Preference as PhoneCall");
	    						 if(DisbType.equals("Check"))	
	    							{
	    								
	    						 //driver.findElement(By.name("requestBean.noOfChecks")).sendKeys(No_of_checks);
	    						 driver.findElement(By.name("requestBean.siilBean.checkopt")).sendKeys(No_of_checks);
	    						 
	    			    		 test.log(LogStatus.PASS, "Selected no of checks as " + No_of_checks);
	    			    		 driver.findElement(By.name("requestBean.siilBean.checkopt")).sendKeys(Keys.ENTER);
	    			    		 Thread.sleep(2000);
	    			    		 driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();
	    			    		 test.log(LogStatus.PASS, "isCustCheck button");
	    							
	    			    		 
	    			    		 //driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys("250");
	    			    		 driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(totaldisbamt);
	    			    		 test.log(LogStatus.PASS, "Disb Amount Entered as:"+totaldisbamt);
	    							}
	    			    		/* driver.findElement(By.name("chkNbr0")).sendKeys(ESign_CheckNbr);
	    			    		 test.log(LogStatus.PASS, "Check number is " + ESign_CheckNbr);*/
	    			    			// driver.findElement(By.name("chkBoxNbr0")).click();
	    			    			// test.log(LogStatus.PASS, "Selected the Check option radio
	    			    			// button");
	    			    			/*driver.findElement(By.name("Print0")).click();
	    			    			test.log(LogStatus.PASS, "Clicked on Print button");*/
	    						 Thread.sleep(5000);
	                                
	    						/* driver.findElement(By.name("requestBean.siilBean.checkopt")).isSelected();
	    						 Select checks = new Select(driver.findElement(By.name("requestBean.siilBean.checkopt")));
	    						 checks.selectByVisibleText("1");*/
	    					
								 
							 }
								    							     							 
							 Thread.sleep(5000);
							driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
							test.log(LogStatus.PASS, "Pin Entered :"+PIN);
							driver.findElement(By.name("finishLoan")).click();
							test.log(LogStatus.PASS, "Clicked on Finish Conversion");
							Thread.sleep(30000);
							wait.until(ExpectedConditions.elementToBeClickable(By.name("OKBut")));
							driver.findElement(By.name("OKBut")).click();
							test.log(LogStatus.PASS, "Clicked on Yes");
							
							Thread.sleep(500);
							test.log(LogStatus.PASS, "Conversion Completed Successfully");
							//driver.close();
							
							
							
							
							
							
						}

				
						
						/*else if (NewLoan_Term.equals("Term2"))

						{

							driver.findElement(By
									.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["
											+ rnum + "]/td[5]/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/b/input"))
									.click();

							test.log(LogStatus.PASS, "Selected check box as " + NewLoan_Term);

						}

					}

					else {

						continue;

					}*/


				break;
			}
		}

	}
}
	}

	catch (Exception e) {
	
		test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
		String screenshotPath = getScreenhot(driver, "Exception");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
		test.log(LogStatus.FAIL, "Conversion failed");

	}

}
}


