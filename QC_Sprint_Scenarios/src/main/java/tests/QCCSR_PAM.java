
package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.relevantcodes.extentreports.Status;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;
import tests.QCStore;


public class QCCSR_PAM extends QCStore
{
	
	public static void PAM_ACH(String SSN,String AppURL,String loan_number) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("PAM");
				String sheetName="PAM";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String username = TestData.getCellData(sheetName,"Username",row);
					String password = TestData.getCellData(sheetName,"Password",row);
					String password2 = TestData.getCellData(sheetName,"Password2",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					
					String application_status = TestData.getCellData(sheetName,"ApplicationStatus",row);
					String comments = TestData.getCellData(sheetName,"Comments",row);
					String last_four_account_no = TestData.getCellData(sheetName,"LastFourAccountNo",row);
					String ProductType = TestData.getCellData(sheetName,"ProductType",row);
					String RepaymentMethod = TestData.getCellData(sheetName,"RepaymentMethod",row);
					String ReceiveType = TestData.getCellData(sheetName,"ReceiveType",row);
					String LoanAmount = TestData.getCellData(sheetName,"LoanAmount",row);
					   
					//String  last_four_account_no=SSN.substring(SSN.length() - 4);


					if(SSN.equals(RegSSN))
					{	
														        
				       Thread.sleep(5000);
				      
				if(LoanAmount.equalsIgnoreCase("0")){
				       
				    if(ReceiveType.equalsIgnoreCase("ACH")){
				    	   
				    	    driver.switchTo().frame("topFrame");
						   
						    driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
							Thread.sleep(3000);
							driver.findElement(locator(prop.getProperty("borrower_tab"))).click();			
							test.log(LogStatus.PASS, "Clicked on Borrower tab");
							driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							
							driver.findElement(locator(prop.getProperty("pam_link"))).click();			
							//driver.switchTo().defaultContent();

							driver.switchTo().frame("main");

							//driver.findElement(By.cssSelector("li[id='955190406']")).click();			
							test.log(LogStatus.PASS, "Clicked on PAM");	
							//test.log(LogStatus.INFO, "Applicant Search page is displayed");	
							test.log(LogStatus.INFO, "Applicant Search page is displayed");
							
							Thread.sleep(1000);
							driver.findElement(By.name("requestBean.productType")).sendKeys(ProductType);
							test.log(LogStatus.PASS, "Product Type Select as : " +ProductType );
				//loan_number="11457150";
							Thread.sleep(500);
							driver.findElement(locator(prop.getProperty("loan_number_field"))).sendKeys(loan_number);
							test.log(LogStatus.PASS, "Entered Loan number : " +loan_number );
							Thread.sleep(500);
							
							driver.findElement(locator(prop.getProperty("submit_button_pam"))).click();
							test.log(LogStatus.PASS, "Clicked on Submit button " );
							
							Thread.sleep(3000);
							driver.findElement(locator(prop.getProperty("radio_button_of_search"))).click();
							test.log(LogStatus.PASS, "Selected the radio button" );
							driver.findElement(locator(prop.getProperty("go_button"))).click();
							test.log(LogStatus.PASS, "Clicked on Go button "  );
							
							driver.findElement(locator(prop.getProperty("applicatino_status_selection"))).sendKeys(application_status);
							//test.log(LogStatus.INFO, "Application Status Select as :");

							//test.log(LogStatus.PASS, "Selected Application status as " +application_status );
							test.log(LogStatus.PASS, "Selected Application status as " +application_status);
							Thread.sleep(500);
							
							String ApprovedLoanAmount = driver.findElement(By.name("requestBean.appLoanAmount")).getAttribute("value");
							                                                        
							test.log(LogStatus.PASS, "Approved Loan Amount is : " +ApprovedLoanAmount);
							
							Thread.sleep(500);
							
							driver.findElement(locator(prop.getProperty("continue_button_loan"))).click();
							test.log(LogStatus.PASS, "Clicked on Continue button "  );
							Thread.sleep(2000);
							
							if(RepaymentMethod.equalsIgnoreCase("ACH")){
								Thread.sleep(500);
								driver.findElement(locator(prop.getProperty("last_four_account_no"))).sendKeys(last_four_account_no);
								test.log(LogStatus.PASS, "Entered last four digits of account no : " +last_four_account_no );
								Thread.sleep(500);
								driver.findElement(locator(prop.getProperty("finish_loan"))).click();
								test.log(LogStatus.PASS, "Clicked on Finish loan button "  );
								
							}
							 else if(RepaymentMethod.equalsIgnoreCase("DEBIT CARD")){
								 Thread.sleep(500);
								 try { 
										driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys("No");												
										test.log(LogStatus.PASS, "Courtesy Call Selected as : No "  );
									}
									catch(Exception e){
										//do what you normally would if you didn't have the alert.
									}
									
					                Thread.sleep(500);
								 driver.findElement(locator(prop.getProperty("finish_loan"))).click();
								 test.log(LogStatus.PASS, "Clicked on Finish loan button "  );
							 }
							
							
							Thread.sleep(2000);

							Alert al=driver.switchTo().alert();
							String alert_text=al.getText();
							
							test.log(LogStatus.PASS, "Loan number  "+loan_number+" status is  "  +application_status );
							test.log(LogStatus.PASS, "  "  +alert_text );
							test.log(LogStatus.PASS, "Pop up is displayed as "  +alert_text);

							Thread.sleep(2000);

							al.accept();
							Thread.sleep(3000);
							driver.findElement(locator(prop.getProperty("confirm_yes"))).click();
							test.log(LogStatus.PASS, "clicked on Yes for Confirm "  );
							Thread.sleep(5000);
							driver.findElement(By.name("ok")).click();
							test.log(LogStatus.PASS, "clicked Loan Orginated Successfully OK "  );
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> New Loan Orginated Successfully ");
							test.log(LogStatus.INFO, "******************************************************** ");
							Thread.sleep(2000);
							driver.close();
							Thread.sleep(2000);
							break;
							//Thread.sleep(2000);
				    	   
				    	   
				    }
				    
				    if(ReceiveType.equalsIgnoreCase("Cash At Store")){
				    	 Thread.sleep(500);				    	
				    					    	 
				    	 driver.switchTo().frame("topFrame");
						   
							driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
							test.log(LogStatus.PASS, "Clicked on Loan Transactiomn");
							Thread.sleep(3000);
							
							driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							
							driver.findElement(By.linkText("Cash At Store")).click();	
							test.log(LogStatus.PASS, "Clicked on Cash At Store");	
							
							driver.switchTo().frame("main");					
							test.log(LogStatus.INFO, "Applicant Search page is displayed");
							
							Thread.sleep(1000);
							driver.findElement(By.name("requestBean.productType")).sendKeys(ProductType);
							test.log(LogStatus.PASS, "Product Type Select as : " +ProductType );
							Thread.sleep(500);
							driver.findElement(By.name("requestBean.stateCode")).sendKeys(StateID);
							test.log(LogStatus.PASS, "State Select as : " +StateID );
							Thread.sleep(500);
							
				  //loan_number="11457251";
							Thread.sleep(500);
							driver.findElement(By.name("requestBean.applicationNbr")).sendKeys(loan_number);
							test.log(LogStatus.PASS, "Entered Application number : " +loan_number );
							Thread.sleep(1000);
							
							driver.findElement(locator(prop.getProperty("submit_button_pam"))).click();
							test.log(LogStatus.PASS, "Clicked on Submit button " );
							
							Thread.sleep(2000);
							
							driver.findElement(locator(prop.getProperty("go_button"))).click();
							test.log(LogStatus.PASS, "Clicked on Go button "  );
							
							Thread.sleep(5000);
						
							try { 
								driver.findElement(By.id("chkgAcctNbr")).sendKeys(last_four_account_no);
								test.log(LogStatus.PASS, "Checking account number enter as : " +last_four_account_no );												

							}
							catch(Exception e){
								//do what you normally would if you didn't have the alert.
							}
							
			                Thread.sleep(1000);
							driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(password2);
							test.log(LogStatus.PASS, "Password entered as : " +password2 );
							Thread.sleep(500);
							driver.findElement(By.name("finishadvance")).click();
							test.log(LogStatus.PASS, "Clicked On Finish Button");
							Thread.sleep(3000);
							driver.findElement(By.name("OKBut")).click();
							test.log(LogStatus.PASS, "clicked on Yes for Confirm "  );
							Thread.sleep(5000);
							driver.findElement(By.name("Ok")).click();
							test.log(LogStatus.PASS, "Advance Completed Successfully OK "  );
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> Loan Completed Successfully");
							test.log(LogStatus.INFO, "******************************************************** ");
							Thread.sleep(2000);							
							driver.close();
							Thread.sleep(2000);
							break;
				    	
				    	
				    	
				    }
				    if(ReceiveType.equalsIgnoreCase("DC Cash At Store")){
				    	 Thread.sleep(500);				    	
				    					    	 
				    	 driver.switchTo().frame("topFrame");
						   
							driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
							test.log(LogStatus.PASS, "Clicked on Loan Transactiomn");
							Thread.sleep(3000);
							
							driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							
							driver.findElement(By.linkText("Cash At Store")).click();	
							test.log(LogStatus.PASS, "Clicked on Cash At Store");	
							
							driver.switchTo().frame("main");					
							test.log(LogStatus.INFO, "Applicant Search page is displayed");
							
							Thread.sleep(1000);
							driver.findElement(By.name("requestBean.productType")).sendKeys(ProductType);
							test.log(LogStatus.PASS, "Product Type Select as : " +ProductType );
							Thread.sleep(500);
							driver.findElement(By.name("requestBean.stateCode")).sendKeys(StateID);
							test.log(LogStatus.PASS, "State Select as : " +StateID );
							Thread.sleep(500);
							
				  //loan_number="11457210";
							Thread.sleep(500);
							driver.findElement(By.name("requestBean.applicationNbr")).sendKeys(loan_number);
							test.log(LogStatus.PASS, "Entered Application number : " +loan_number );
							Thread.sleep(1000);
							
							driver.findElement(locator(prop.getProperty("submit_button_pam"))).click();
							test.log(LogStatus.PASS, "Clicked on Submit button " );
							
							Thread.sleep(2000);
							
							driver.findElement(locator(prop.getProperty("go_button"))).click();
							test.log(LogStatus.PASS, "Clicked on Go button "  );
							
							Thread.sleep(5000);
														
							driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(password2);
							test.log(LogStatus.PASS, "Password entered as : " +password2 );
							Thread.sleep(500);
							driver.findElement(By.name("finishadvance")).click();
							test.log(LogStatus.PASS, "Clicked On Finish Button");
							Thread.sleep(3000);
							driver.findElement(By.name("OKBut")).click();
							test.log(LogStatus.PASS, "clicked on Yes for Confirm "  );
							Thread.sleep(5000);
							driver.findElement(By.name("Ok")).click();
							test.log(LogStatus.PASS, "DebitCard Advance Completed Successfully OK "  );
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> Loan Completed Successfully");
							test.log(LogStatus.INFO, "******************************************************** ");
							Thread.sleep(2000);							
							driver.close();
							Thread.sleep(2000);
							break;
				    	
				    	
				    	
				    }
				    
		}
		
		else 
		{
			
			System.out.println("Write Code For NewLoan Esign");
			
		    if(ReceiveType.equalsIgnoreCase("ACH")){
		    	   
		    	 driver.switchTo().frame("topFrame");
				   
					driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
					Thread.sleep(3000);
					driver.findElement(locator(prop.getProperty("borrower_tab"))).click();			
					test.log(LogStatus.PASS, "Clicked on Borrower tab");
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					
					driver.findElement(locator(prop.getProperty("pam_link"))).click();			
					//driver.switchTo().defaultContent();

					driver.switchTo().frame("main");

					//driver.findElement(By.cssSelector("li[id='955190406']")).click();			
					test.log(LogStatus.PASS, "Clicked on PAM");	
					//test.log(LogStatus.INFO, "Applicant Search page is displayed");	
					test.log(LogStatus.INFO, "Applicant Search page is displayed");
					
					Thread.sleep(1000);
					driver.findElement(By.name("requestBean.productType")).sendKeys(ProductType);
					test.log(LogStatus.PASS, "Product Type Select as : " +ProductType );
		  //loan_number="10863923";
					Thread.sleep(500);
					driver.findElement(locator(prop.getProperty("loan_number_field"))).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Entered Loan number : " +loan_number );
					Thread.sleep(4000);
					
					driver.findElement(locator(prop.getProperty("submit_button_pam"))).click();
					test.log(LogStatus.PASS, "Clicked on Submit button " );
					
					Thread.sleep(2000);
					driver.findElement(locator(prop.getProperty("radio_button_of_search"))).click();
					test.log(LogStatus.PASS, "Selected the radio button" );
					driver.findElement(locator(prop.getProperty("go_button"))).click();
					test.log(LogStatus.PASS, "Clicked on Go button "  );
					
					Thread.sleep(500);
					driver.findElement(By.name("requestBean.appLoanAmount")).clear();
					Thread.sleep(500);
					
					driver.findElement(By.name("requestBean.appLoanAmount")).sendKeys(LoanAmount);
					test.log(LogStatus.PASS, "Approved Loan Amount Changed To : " +LoanAmount);
					
					Thread.sleep(500);
					
					
					//driver.findElement(locator(prop.getProperty("applicatino_status_selection"))).sendKeys(application_status);
					//test.log(LogStatus.INFO, "Application Status Select as :");

					//test.log(LogStatus.PASS, "Selected Application status as " +application_status );
					//test.log(LogStatus.PASS, "Selected Application status as " +application_status);

					
					driver.findElement(locator(prop.getProperty("comment_section"))).sendKeys(comments);
					test.log(LogStatus.PASS, "Given comments as  " +comments );
					
					driver.findElement(locator(prop.getProperty("continue_button_loan"))).click();
					test.log(LogStatus.PASS, "Clicked on Continue button "  );
					
					Thread.sleep(500);
					
					try { 
						Alert alert = driver.switchTo().alert();
						alert.accept();
						//if alert present, accept and move on.														

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					
					
					Thread.sleep(500);
					
					try { 
						Alert alert = driver.switchTo().alert();
						alert.accept();
						//if alert present, accept and move on.														

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
									
					
					Thread.sleep(2000);
					
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Customer Verification Details Completed Successfully, Customer need to Provide New E-sign Details");
					test.log(LogStatus.INFO, "******************************************************** ");
					Thread.sleep(2000);
					//driver.close();
					break;
					
		    }
		   break ;
		}
	
					if(RepaymentMethod.equalsIgnoreCase("ACH")){
						Thread.sleep(500);
						driver.findElement(locator(prop.getProperty("last_four_account_no"))).sendKeys(last_four_account_no);
						test.log(LogStatus.PASS, "Entered last four digits of account no : " +last_four_account_no );
						Thread.sleep(500);
						driver.findElement(locator(prop.getProperty("finish_loan"))).click();
						test.log(LogStatus.PASS, "Clicked on Finish loan button "  );
						
					}
					 else if(RepaymentMethod.equalsIgnoreCase("DEBIT CARD")){
						 Thread.sleep(500);
						 driver.findElement(locator(prop.getProperty("finish_loan"))).click();
						 test.log(LogStatus.PASS, "Clicked on Finish loan button "  );
					 }
					
					/*driver.findElement(locator(prop.getProperty("last_four_account_no"))).sendKeys(last_four_account_no);
					test.log(LogStatus.PASS, "Entered last four digits of account no : " +last_four_account_no );*/
					//Thread.sleep(500);
					/*driver.findElement(locator(prop.getProperty("finish_loan"))).click();
					test.log(LogStatus.PASS, "Clicked on Finish loan button "  );*/
					Thread.sleep(2000);

					Alert al=driver.switchTo().alert();
					String alert_text=al.getText();
					
					test.log(LogStatus.PASS, "Loan number  "+loan_number+" status is  "  +application_status );
					test.log(LogStatus.PASS, "  "  +alert_text );
					test.log(LogStatus.PASS, "Pop up is displayed as "  +alert_text);

					Thread.sleep(2000);

					al.accept();
					Thread.sleep(3000);
					driver.findElement(locator(prop.getProperty("confirm_yes"))).click();
					test.log(LogStatus.PASS, "clicked on Yes for Confirm "  );
					Thread.sleep(5000);
					driver.findElement(By.name("ok")).click();
					test.log(LogStatus.PASS, "clicked Loan Orginated Successfully OK "  );
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> New Loan Orginated Successfully ");
					test.log(LogStatus.INFO, "******************************************************** ");
					Thread.sleep(2000);
					
	
				   if(ReceiveType.equalsIgnoreCase("Cash At Store")){
				    	 Thread.sleep(500);				    	
				    	/* driver.switchTo().frame("topFrame");						   
						 driver.findElement(locator(prop.getProperty("transactions_tab"))).click();
						 test.log(LogStatus.PASS, "Clicked on Loan Transactions tab");
						 
						 driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						 Thread.sleep(500);
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 //driver.switchTo().frame("main");
						 
						 Thread.sleep(500);		
						 											
						 driver.findElement(By.xpath("//*[@id='955190407']/a")).click();
						 test.log(LogStatus.PASS, "Clicked on Cash At Store Link");*/
				    	 
				    	 driver.switchTo().frame("topFrame");
						   
							driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
							Thread.sleep(3000);
							driver.findElement(locator(prop.getProperty("borrower_tab"))).click();			
							test.log(LogStatus.PASS, "Clicked on Borrower tab");
							driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							
							driver.findElement(locator(prop.getProperty("pam_link"))).click();			
							//driver.switchTo().defaultContent();

							driver.switchTo().frame("main");

							//driver.findElement(By.cssSelector("li[id='955190406']")).click();			
							test.log(LogStatus.PASS, "Clicked on PAM");	
							//test.log(LogStatus.INFO, "Applicant Search page is displayed");	
							test.log(LogStatus.INFO, "Applicant Search page is displayed");
							
							Thread.sleep(1000);
							driver.findElement(By.name("requestBean.productType")).sendKeys(ProductType);
							test.log(LogStatus.PASS, "Product Type Select as : " +ProductType );
				  //loan_number="11457184";
							Thread.sleep(500);
							driver.findElement(locator(prop.getProperty("loan_number_field"))).sendKeys(loan_number);
							test.log(LogStatus.PASS, "Entered Loan number : " +loan_number );
							Thread.sleep(4000);
							
							driver.findElement(locator(prop.getProperty("submit_button_pam"))).click();
							test.log(LogStatus.PASS, "Clicked on Submit button " );
							
							Thread.sleep(2000);
							driver.findElement(locator(prop.getProperty("radio_button_of_search"))).click();
							test.log(LogStatus.PASS, "Selected the radio button" );
							driver.findElement(locator(prop.getProperty("go_button"))).click();
							test.log(LogStatus.PASS, "Clicked on Go button "  );
							
							driver.findElement(locator(prop.getProperty("applicatino_status_selection"))).sendKeys(application_status);
							//test.log(LogStatus.INFO, "Application Status Select as :");

							//test.log(LogStatus.PASS, "Selected Application status as " +application_status );
							test.log(LogStatus.PASS, "Selected Application status as " +application_status);

							
							driver.findElement(locator(prop.getProperty("comment_section"))).sendKeys(comments);
							test.log(LogStatus.PASS, "Given comments as  " +comments );
							
							driver.findElement(locator(prop.getProperty("continue_button_loan"))).click();
							test.log(LogStatus.PASS, "Clicked on Continue button "  );
							Thread.sleep(2000);
							
							
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> You Have Choosen Cash at Store. Please collect the Cash from nearest Store ");
							test.log(LogStatus.INFO, "******************************************************** ");
							Thread.sleep(2000);
				    	
				    	
				    	
				    }
				    

		break;
	
				}
		}
				}
	
					catch(Exception e)
					  {
						  //test.log(LogStatus.ERROR, "Unable to complete  CSR with SSN and Loan Number : " +SSN+","+loan_number);
						 // test.log(LogStatus.ERROR, "Error message  " +e);
						  //String screenshotPath = getScreenhot(driver, "lendNationCSR");
						  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
							//System.out.println(e);
	
}
	
	}
	
	public static void PAMLogin(String SSN,String AppURL) throws Exception

	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("PAM");
				String sheetName="PAM";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String username = TestData.getCellData(sheetName,"UserName",row);
					String password = TestData.getCellData(sheetName,"Password",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);
					String username2 = TestData.getCellData(sheetName,"UserName2",row);
					String password2 = TestData.getCellData(sheetName,"Password2",row);
					String store_id2 = TestData.getCellData(sheetName,"StoreID2",row);
					String application_status = TestData.getCellData(sheetName,"ApplicationStatus",row);
					String comments = TestData.getCellData(sheetName,"Comments",row);
					String last_four_account_no = TestData.getCellData(sheetName,"LastFourAccountNo",row);
					String ProductType = TestData.getCellData(sheetName,"ProductType",row);
					String ReceiveType = TestData.getCellData(sheetName,"ReceiveType",row);
					
					   //String  last_four_account_no=SSN.substring(SSN.length() - 4);


					if(SSN.equals(RegSSN))
					{	
				
						//test.log(LogStatus.INFO, "Opened the CSR URL " +AppURL);
						test.log(LogStatus.INFO, "Opened the CSR URL " +csr_url);


						//test.log(LogStatus.INFO, "CSR Application is launched " );
						test.log(LogStatus.INFO, "*******CSR Application is launched For Loan Approval*******");

						driver = new InternetExplorerDriver();
						WebDriverWait wait = new WebDriverWait(driver, 30000);

						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
					
						driver.get(csr_url);
						
					if(ReceiveType.equalsIgnoreCase("ACH"))	{
						
					    driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(username);
				        test.log(LogStatus.PASS, "Username is entered: "+username);
				        
				        

					    driver.findElement(locator(prop.getProperty("csr_password"))).clear();
					    driver.findElement(locator(prop.getProperty("csr_password"))).sendKeys(password);
				        test.log(LogStatus.PASS, "Password is entered: "+password);
				        
				       
				        driver.findElement(locator(prop.getProperty("csr_storeid"))).sendKeys(store_id);;
				        test.log(LogStatus.PASS, "Storenumber is entered: "+store_id);
				        //Click Login Button
				        driver.findElement(locator(prop.getProperty("csr_login_button"))).click();
				        test.log(LogStatus.PASS, "Clicked on login button");
				        
				       Thread.sleep(5000);
					}
				    
					else if(ReceiveType.equalsIgnoreCase("Cash At Store")){
						driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(username2);
				        test.log(LogStatus.PASS, "Username is entered: "+username2);
				        
				        

					    driver.findElement(locator(prop.getProperty("csr_password"))).clear();
					    driver.findElement(locator(prop.getProperty("csr_password"))).sendKeys(password2);
				        test.log(LogStatus.PASS, "Password is entered: "+password2);
				        
				       
				        driver.findElement(locator(prop.getProperty("csr_storeid"))).sendKeys(store_id2);;
				        test.log(LogStatus.PASS, "Storenumber is entered: "+store_id2);
				        //Click Login Button
				        driver.findElement(locator(prop.getProperty("csr_login_button"))).click();
				        test.log(LogStatus.PASS, "Clicked on login button");	
						
						
					}
					else if(ReceiveType.equalsIgnoreCase("DC Cash At Store")){
						driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(username2);
				        test.log(LogStatus.PASS, "Username is entered: "+username2);
				        
				        

					    driver.findElement(locator(prop.getProperty("csr_password"))).clear();
					    driver.findElement(locator(prop.getProperty("csr_password"))).sendKeys(password2);
				        test.log(LogStatus.PASS, "Password is entered: "+password2);
				        
				       
				        driver.findElement(locator(prop.getProperty("csr_storeid"))).sendKeys(store_id2);;
				        test.log(LogStatus.PASS, "Storenumber is entered: "+store_id2);
				        //Click Login Button
				        driver.findElement(locator(prop.getProperty("csr_login_button"))).click();
				        test.log(LogStatus.PASS, "Clicked on login button");	
						
						
					}
					
		
		
		break;
	}
				}
		}
	
					catch(Exception e)
					  {
						  test.log(LogStatus.ERROR, "Unable to complete  CSR with SSN and Loan Number : " +SSN+","+loan_number);
						  test.log(LogStatus.ERROR, "Error message  " +e);
						  String screenshotPath = getScreenhot(driver, "QCCSRLoginLogout");
						  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
							System.out.println(e);
	
}
	}
	
	
	public static void PAMLogin_CashatStore(String SSN,String AppURL) throws Exception

	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("PAM");
				String sheetName="PAM";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String username = TestData.getCellData(sheetName,"UserName",row);
					String password = TestData.getCellData(sheetName,"Password",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);
					String username2 = TestData.getCellData(sheetName,"UserName2",row);
					String password2 = TestData.getCellData(sheetName,"Password2",row);
					String store_id2 = TestData.getCellData(sheetName,"StoreID2",row);
					String application_status = TestData.getCellData(sheetName,"ApplicationStatus",row);
					String comments = TestData.getCellData(sheetName,"Comments",row);
					String last_four_account_no = TestData.getCellData(sheetName,"LastFourAccountNo",row);
					String ProductType = TestData.getCellData(sheetName,"ProductType",row);
					String ReceiveType = TestData.getCellData(sheetName,"ReceiveType",row);
					
					   //String  last_four_account_no=SSN.substring(SSN.length() - 4);


					if(SSN.equals(RegSSN))
					{	
				
						//test.log(LogStatus.INFO, "Opened the CSR URL " +AppURL);
						test.log(LogStatus.INFO, "Opened the CSR URL " +csr_url);


						//test.log(LogStatus.INFO, "CSR Application is launched " );
						test.log(LogStatus.INFO, "*******CSR Application is launched For Loan Approval*******");

						driver = new InternetExplorerDriver();
						WebDriverWait wait = new WebDriverWait(driver, 30000);

						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
					
						driver.get(csr_url);
						
					if(ReceiveType.equalsIgnoreCase("ACH"))	{
						
					    driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(username);
				        test.log(LogStatus.PASS, "Username is entered: "+username);
				        
				        

					    driver.findElement(locator(prop.getProperty("csr_password"))).clear();
					    driver.findElement(locator(prop.getProperty("csr_password"))).sendKeys(password);
				        test.log(LogStatus.PASS, "Password is entered: "+password);
				        
				       
				        driver.findElement(locator(prop.getProperty("csr_storeid"))).sendKeys(store_id);;
				        test.log(LogStatus.PASS, "Storenumber is entered: "+store_id);
				        //Click Login Button
				        driver.findElement(locator(prop.getProperty("csr_login_button"))).click();
				        test.log(LogStatus.PASS, "Clicked on login button");
				        
				       Thread.sleep(5000);
					}
				    
					else if(ReceiveType.equalsIgnoreCase("Cash At Store")){
						driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(username);
				        test.log(LogStatus.PASS, "Username is entered: "+username);
				        
				        

					    driver.findElement(locator(prop.getProperty("csr_password"))).clear();
					    driver.findElement(locator(prop.getProperty("csr_password"))).sendKeys(password);
				        test.log(LogStatus.PASS, "Password is entered: "+password);
				        
				       
				        driver.findElement(locator(prop.getProperty("csr_storeid"))).sendKeys(store_id);;
				        test.log(LogStatus.PASS, "Storenumber is entered: "+store_id);
				        //Click Login Button
				        driver.findElement(locator(prop.getProperty("csr_login_button"))).click();
				        test.log(LogStatus.PASS, "Clicked on login button");	
						
						
					}
					
		
		
		break;
	}
				}
		}
	
					catch(Exception e)
					  {
						  test.log(LogStatus.ERROR, "Unable to complete  CSR with SSN and Loan Number : " +SSN+","+loan_number);
						  test.log(LogStatus.ERROR, "Error message  " +e);
						  String screenshotPath = getScreenhot(driver, "QCCSRLoginLogout");
						  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
							System.out.println(e);
	
}
	}
	
	
	public static void CashAtStore(String SSN,String AppURL) throws Exception

	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("PAM");
				String sheetName="PAM";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String username = TestData.getCellData(sheetName,"UserName",row);
					String password = TestData.getCellData(sheetName,"Password",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);
					String username2 = TestData.getCellData(sheetName,"UserName2",row);
					String password2 = TestData.getCellData(sheetName,"Password2",row);
					String store_id2 = TestData.getCellData(sheetName,"StoreID2",row);
					String application_status = TestData.getCellData(sheetName,"ApplicationStatus",row);
					String comments = TestData.getCellData(sheetName,"Comments",row);
					String last_four_account_no = TestData.getCellData(sheetName,"LastFourAccountNo",row);
					String ProductType = TestData.getCellData(sheetName,"ProductType",row);
					String ReceiveType = TestData.getCellData(sheetName,"ReceiveType",row);
					String RepaymentMethod = TestData.getCellData(sheetName,"RepaymentMethod",row);
					
					String LoanAmount = TestData.getCellData(sheetName,"LoanAmount",row);
					   //String  last_four_account_no=SSN.substring(SSN.length() - 4);


					if(SSN.equals(RegSSN))
					{	
				
						//test.log(LogStatus.INFO, "Opened the CSR URL " +AppURL);
						test.log(LogStatus.INFO, "Opened the CSR URL " +csr_url);


						//test.log(LogStatus.INFO, "CSR Application is launched " );
						test.log(LogStatus.INFO, "*******CSR Application is launched For Cash to Store Approval*******");

						driver = new InternetExplorerDriver();
						WebDriverWait wait = new WebDriverWait(driver, 30000);

						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
					
						driver.get(csr_url);
						
					if(ReceiveType.equalsIgnoreCase("ACH"))	{
						
					    driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(username);
				        test.log(LogStatus.PASS, "Username is entered: "+username);
				        
				        

					    driver.findElement(locator(prop.getProperty("csr_password"))).clear();
					    driver.findElement(locator(prop.getProperty("csr_password"))).sendKeys(password);
				        test.log(LogStatus.PASS, "Password is entered: "+password);
				        
				       
				        driver.findElement(locator(prop.getProperty("csr_storeid"))).sendKeys(store_id);;
				        test.log(LogStatus.PASS, "Storenumber is entered: "+store_id);
				        //Click Login Button
				        driver.findElement(locator(prop.getProperty("csr_login_button"))).click();
				        test.log(LogStatus.PASS, "Clicked on login button");
				        
				       Thread.sleep(5000);
					}
				    
					else if(ReceiveType.equalsIgnoreCase("Cash At Store")){
						driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(username);
				        test.log(LogStatus.PASS, "Username is entered: "+username);
				        
				        

					    driver.findElement(locator(prop.getProperty("csr_password"))).clear();
					    driver.findElement(locator(prop.getProperty("csr_password"))).sendKeys(password);
				        test.log(LogStatus.PASS, "Password is entered: "+password);
				        
				       
				        driver.findElement(locator(prop.getProperty("csr_storeid"))).sendKeys(store_id);;
				        test.log(LogStatus.PASS, "Storenumber is entered: "+store_id);
				        //Click Login Button
				        driver.findElement(locator(prop.getProperty("csr_login_button"))).click();
				        test.log(LogStatus.PASS, "Clicked on login button");
				        Thread.sleep(3000);
				        driver.switchTo().frame("topFrame");
						   
					    driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
						Thread.sleep(3000);
						driver.findElement(locator(prop.getProperty("borrower_tab"))).click();			
						test.log(LogStatus.PASS, "Clicked on Borrower tab");
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						
						driver.findElement(locator(prop.getProperty("pam_link"))).click();			
						//driver.switchTo().defaultContent();

						driver.switchTo().frame("main");

						//driver.findElement(By.cssSelector("li[id='955190406']")).click();			
						test.log(LogStatus.PASS, "Clicked on PAM");	
						//test.log(LogStatus.INFO, "Applicant Search page is displayed");	
						test.log(LogStatus.INFO, "Applicant Search page is displayed");
						
						Thread.sleep(1000);
						driver.findElement(By.name("requestBean.productType")).sendKeys(ProductType);
						test.log(LogStatus.PASS, "Product Type Select as : " +ProductType );
			//loan_number="11457251";
						Thread.sleep(500);
						driver.findElement(locator(prop.getProperty("loan_number_field"))).sendKeys(loan_number);
						test.log(LogStatus.PASS, "Entered Loan number : " +loan_number );
						Thread.sleep(500);
						
						driver.findElement(locator(prop.getProperty("submit_button_pam"))).click();
						test.log(LogStatus.PASS, "Clicked on Submit button " );
						
						Thread.sleep(3000);
						driver.findElement(locator(prop.getProperty("radio_button_of_search"))).click();
						test.log(LogStatus.PASS, "Selected the radio button" );
						driver.findElement(locator(prop.getProperty("go_button"))).click();
						test.log(LogStatus.PASS, "Clicked on Go button "  );
						
						driver.findElement(locator(prop.getProperty("applicatino_status_selection"))).sendKeys(application_status);
						//test.log(LogStatus.INFO, "Application Status Select as :");

						//test.log(LogStatus.PASS, "Selected Application status as " +application_status );
						test.log(LogStatus.PASS, "Selected Application status as " +application_status);
						Thread.sleep(500);
						
						String ApprovedLoanAmount = driver.findElement(By.name("requestBean.appLoanAmount")).getAttribute("value");
						                                                        
						test.log(LogStatus.PASS, "Approved Loan Amount is : " +ApprovedLoanAmount);
						
						Thread.sleep(500);
						driver.findElement(By.name("Save")).click();
						test.log(LogStatus.PASS, "Clicked on Submit button "  );
						Thread.sleep(2000);
						if(driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td")).getText().contains("You have choosen cash at store option")){
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> Getting Message : You have choosen cash at store option");
						}
						else
						{
							test.log(LogStatus.FAIL, "message not displayed");}
						
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Cash At Store Completed in 2997 Store Successfully ");
						test.log(LogStatus.INFO, "**************** Navigating to Originate Loan at Cash At Store in 118 Store  **************** ");
						Thread.sleep(2000);
						driver.close();
						Thread.sleep(2000);
						break;
						
						
					}
					
		
		
		break;
	}
				}
		}
	
					catch(Exception e)
					  {
						  test.log(LogStatus.ERROR, "Unable to complete  CSR with SSN and Loan Number : " +SSN+","+loan_number);
						  test.log(LogStatus.ERROR, "Error message  " +e);
						  String screenshotPath = getScreenhot(driver, "QCCSRLoginLogout");
						  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
							System.out.println(e);
	
}
	}
	
	
//==================================== For Logout =============================================	
	
              public static void logout(String SSN,String AppURL){
							
				try{
					
					
					driver.switchTo().defaultContent();
					 driver.switchTo().frame("topFrame");
					 Thread.sleep(5000);		
			       //driver.findElement(locator(prop.getProperty(("csr_logout_link")))).click();
			     driver.findElement(By.xpath("//a[@href='/cc/logout.do']")).click();
			     test.log(LogStatus.PASS, "Clicked On logout Button");
			     if(driver.getTitle().contains("Login")){
			    	// test.log(LogStatus.PASS, "Logout is Successfully");
			    	 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Logout Successfully ");
			    	 test.log(LogStatus.INFO,"loggged out from the CSR Application");
			    	 Thread.sleep(5000);
			     driver.close();
			    	 //driver.quit();
			    	 Thread.sleep(5000);
			     }
			    else{
			    	 //test.log(LogStatus.PASS, "Logout was Successfull"); 
			    	 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Logout Successfully ");
			     }


			     	
			}
						
			
		
		
		catch(Exception e)
		{
			test.log(LogStatus.ERROR,"CSR logout is failed");

			e.printStackTrace();
		}
	
	
	
}	

//============================ For Admin Logout ===============================

public static void Adminlogout(String SSN,String AdminURL){
	try{
		
		
		driver.switchTo().defaultContent();
		 driver.switchTo().frame("topFrame");
		
driver.findElement(locator(prop.getProperty(("admin_logout_link")))).click();
     test.log(LogStatus.PASS, "Clicked On logout Button");
     if(driver.getTitle().contains("Login")){
    	 test.log(LogStatus.PASS, "Logout is Successfully"); 
    	 test.log(LogStatus.INFO,"loggged out from the Admin Application");
    	 Thread.sleep(5000);
     //driver.close();
    	 driver.quit();
     }
    else{
    	 test.log(LogStatus.PASS, "Logout was unsuccessfull"); 
     }


     	
}
			



catch(Exception e)
{
test.log(LogStatus.ERROR,"CSR logout is failed");

e.printStackTrace();
}
}





}



