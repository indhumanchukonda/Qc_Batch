package tests;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.relevantcodes.extentreports.Status;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;



public class LendNationCSR extends LendNation{

	public static void lendNationCSR(String SSN,String AppURL) throws Exception
	{
		try{
			String FileName= prop.getProperty("file_name");
			
			ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 
				int lastrow=TestData.getLastRow("Pam");
				String sheetName="Pam";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String csr_url = TestData.getCellData(sheetName,"CSRURL",row);

					String username = TestData.getCellData(sheetName,"Username",row);
					String password = TestData.getCellData(sheetName,"Password",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);
					String State = TestData.getCellData(sheetName,"State",row);
					String application_status = TestData.getCellData(sheetName,"ApplicationStatus",row);
					//String comments = TestData.getCellData(sheetName,"Comments",row);
					String ProductType = TestData.getCellData(sheetName,"ProductType",row);
					   //String  last_four_account_no=SSN.substring(SSN.length() - 4);


					if(SSN.equals(RegSSN))
					{	
				
						//test.log(LogStatus.INFO, "Opened the CSR URL " +AppURL);
						test.log(LogStatus.INFO, "Opened the CSR URL " +AppURL);


						//test.log(LogStatus.INFO, "CSR Application is launched " );
						test.log(LogStatus.INFO, "CSR Application is launched");

						driver = new InternetExplorerDriver();
						WebDriverWait wait = new WebDriverWait(driver, 15000);

						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
					
						driver.get(csr_url);
						
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
				       
				        driver.switchTo().frame("topFrame");
					    wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(locator(prop.getProperty("borrower_tab"))))));		
						Thread.sleep(2000);
						driver.findElement(locator(prop.getProperty("borrower_tab"))).click();			
						test.log(LogStatus.PASS, "Clicked on Borrower tab");
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						
						driver.findElement(locator(prop.getProperty("pam_link"))).click();			
						driver.switchTo().frame("main");		
						test.log(LogStatus.PASS, "Clicked on PAM");		
						test.log(LogStatus.INFO, "Applicant Search page is displayed");
						
						Thread.sleep(500);
						new Select(driver.findElement(By.name("requestBean.productType"))).selectByVisibleText(ProductType);
						test.log(LogStatus.PASS, "Selected the ProductType as: "+ProductType);
						  
						Thread.sleep(500);
						driver.findElement(locator(prop.getProperty("loan_number_field"))).sendKeys(loan_number);
						test.log(LogStatus.PASS, "Entered Loan number : " +loan_number );
						
						Thread.sleep(500);
						new Select(driver.findElement(By.name("requestBean.stateCode"))).selectByVisibleText(State);
						test.log(LogStatus.PASS, "Selected the State as: "+State);
						
						Thread.sleep(500);
						driver.findElement(locator(prop.getProperty("submit_button_pam"))).click();
						test.log(LogStatus.PASS, "Clicked on Submit button " );
						
						Thread.sleep(1000);
						driver.findElement(locator(prop.getProperty("radio_button_of_search"))).click();
						test.log(LogStatus.PASS, "Selected the radio button" );
						driver.findElement(locator(prop.getProperty("go_button"))).click();
						test.log(LogStatus.PASS, "Clicked on Go button "  );
						
						driver.findElement(locator(prop.getProperty("applicatino_status_selection"))).sendKeys(application_status);
						test.log(LogStatus.INFO, "PAM Action page is displayed");

						test.log(LogStatus.PASS, "Selected Application status as " +application_status);
						
						driver.findElement(locator(prop.getProperty("continue_button_loan"))).click();
						test.log(LogStatus.PASS, "Clicked on Continue button "  );
						Thread.sleep(2000);
						

			/*			Alert al=driver.switchTo().alert();
						String alert_text=al.getText();
						
						test.log(LogStatus.PASS, "Loan number  "+loan_number+" status is  "  +application_status );
						test.log(LogStatus.PASS, "  "  +alert_text );
						test.log(LogStatus.PASS, "Pop up is displayed as "  +alert_text);

						Thread.sleep(2000);

						al.accept();*/
						Thread.sleep(3000);
						String txt=driver.findElement(By.className("formHeadingCenter")).getText();
						test.log(LogStatus.PASS, " "  +txt);
						Thread.sleep(500);
						
						test.log(LogStatus.PASS, "PAM Need E-Sign Entered Successfully with SSN : " +SSN);
						test.log(LogStatus.PASS, "********************************************* ");
						driver.close();
					
		
		
		break;
	}
				}
		}
	
					catch(Exception e)
					  {
						  test.log(LogStatus.ERROR, "Unable to complete  CSR with SSN and Loan Number : " +SSN+","+loan_number);
						  test.log(LogStatus.ERROR, "Error message  " +e);
						  String screenshotPath = getScreenhot(driver, "lendNationCSR");
						  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
							System.out.println(e);
	
}
	}
	public static void LoanApprovement(String SSN,String AppURL) throws Exception
	{
		try{
			String FileName= prop.getProperty("file_name");
			
			ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 
				int lastrow=TestData.getLastRow("Pam");
				String sheetName="Pam";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String csr_url = TestData.getCellData(sheetName,"CSRURL",row);

					String username = TestData.getCellData(sheetName,"Username",row);
					String password = TestData.getCellData(sheetName,"Password",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);
					String State = TestData.getCellData(sheetName,"State",row);
					String application_status = TestData.getCellData(sheetName,"ApplicationStatus",row);
					//String comments = TestData.getCellData(sheetName,"Comments",row);
					String ProductType = TestData.getCellData(sheetName,"ProductType",row);
					   //String  last_four_account_no=SSN.substring(SSN.length() - 4);


					if(SSN.equals(RegSSN))
					{	
				
						//test.log(LogStatus.INFO, "Opened the CSR URL " +AppURL);
						test.log(LogStatus.INFO, "Opened the CSR URL " +AppURL);


						//test.log(LogStatus.INFO, "CSR Application is launched " );
						test.log(LogStatus.INFO, "CSR Application is launched");

						driver = new InternetExplorerDriver();
						WebDriverWait wait = new WebDriverWait(driver, 15000);

						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
					
						driver.get(csr_url);
						
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
				        
				        test.log(LogStatus.INFO, "ACH / Electronic Bank Transfer Loan Aprovement Started");				
						Thread.sleep(3000);
						driver.switchTo().frame("topFrame");
						driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");

						driver.findElement(By.cssSelector("li[id='911101']")).click();
						test.log(LogStatus.PASS, "Clicked on Transcations");		
						driver.switchTo().frame("main");	
						Thread.sleep(500);
						driver.findElement(By.name("requestBean.dealNbr")).sendKeys(loan_number);
						test.log(LogStatus.PASS, "Entered the loan number is :"+ loan_number);	
						Thread.sleep(500);
						driver.findElement(By.name("submit1")).click();
						test.log(LogStatus.PASS, "Clicked on Submit button");
						Thread.sleep(500);
								
							/*	 String mainwindow=driver.getWindowHandle();
					    		System.out.println("mainwindow"+mainwindow);
							    driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]")).click();
							    test.log(LogStatus.PASS, "Clicked on Customer number link");
							    Thread.sleep(2000);
							    for(String winHandle : driver.getWindowHandles()){
							    	System.out.println("winHandle>>>>"+winHandle);
							    	System.out.println(driver.getWindowHandles().size());
									if(!mainwindow.equalsIgnoreCase(winHandle))
									{
									System.out.println("winHandle****"+winHandle);
									Thread.sleep(6000);
								    driver.switchTo().window(winHandle);	
								    System.out.println("switch to child window*"+winHandle);
								    Thread.sleep(3000);*/
								  ///html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[3]
								    String loan_status= driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[3]")).getText();
									test.log(LogStatus.PASS, "Loan Number is" + loan_status);
								    if(loan_status.equalsIgnoreCase("Active")){
								    	
								    	test.log(LogStatus.PASS, "New Loan is Completed Successfully ");
										test.log(LogStatus.INFO, "**********************************************************************************");
										driver.close();
								    }							        
									break;
									//}
							    //}
									//driver.switchTo().window(mainwindow);
									//driver.close();
						//break;
					}
								}
						
		}
									catch(Exception e)
									  {
										  test.log(LogStatus.ERROR, "Unable to complete  CSR with SSN and Loan Number : " +SSN+","+loan_number);
										  test.log(LogStatus.ERROR, "Error message  " +e);
										  String screenshotPath = getScreenhot(driver, "lendNationCSR");
										  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
											System.out.println(e);
						
									  }
	}
	
}
