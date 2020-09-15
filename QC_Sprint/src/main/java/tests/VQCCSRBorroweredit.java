package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class VQCCSRBorroweredit extends QCStore {
	private static final String handle = null;


	public static void Borroweredit(String SSN, String AppURL) {
		
			try {
				
				int lastrow = TestData.getLastRow("Borroweredit");
				String sheetName = "Borroweredit";

				for (int row = 2; row <= lastrow; row++) {

					// test.log(LogStatus.INFO, MarkupHelper.createLabel("CSR
					// Application is launched", ExtentColor.BLUE));
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					String VIN = TestData.getCellData(sheetName, "VIN", row);
					String NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
					String ProductType=TestData.getCellData(sheetName, "ProductType", row);
					String ReasonsforTransfer = TestData.getCellData(sheetName, "ReasonsforTransfer", row);
					String Comments = TestData.getCellData(sheetName, "Comments", row);
					if (SSN.equals(RegSSN)) {
						 String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					
		       Thread.sleep(4000);
				//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
				test.log(LogStatus.INFO, "Borroweredit process is initiated");

							    
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("topFrame");
		// -----------------------------------
					// driver.switchTo().frame("topFrame");
						wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));
						Thread.sleep(1000);
						
						driver.findElement(By.xpath("//*[@id='900000']/a")).click();
						

						test.log(LogStatus.PASS, "Clicked on Borrower");
						Thread.sleep(2000);

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.findElement(By.xpath("//*[@id='902000']/a")).click();
                        test.log(LogStatus.PASS, "Clicked on Edit Link");
                        Thread.sleep(5000);
                    	driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
                        
						Thread.sleep(1000);
						driver.findElement(By.name("requestBean.vinNbr")).sendKeys(NewVIN);
						test.log(LogStatus.PASS, "VIN selected as " + NewVIN);
						Thread.sleep(1000);
						driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[2]")).click();
						test.log(LogStatus.PASS, "clicked on submit button"); 
						
						Thread.sleep(1000);
						
							
						if(NewVIN.equalsIgnoreCase(NewVIN)){
							
							test.log(LogStatus.PASS, "NewVIN is" + NewVIN);
							test.log(LogStatus.PASS, "Borrower Edit search with NewVIN Completed Successfully");
							}
							else{
							//test.log(LogStatus.PASS, "NewVIN is failed");
							
							test.log(LogStatus.PASS, "Borrower Edit search with NewVIN not Completed Successfully");
							}
					
					
                       Thread.sleep(5000);
		    driver.close();
						 
		// ------------------------------------
						
						 break;
					}
								}	
						
						
					}

									catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										

									}

						}

					
public static void Bankruptcy_csr(String SSN, String AppURL) {
	
	try {
		
		int lastrow = TestData.getLastRow("Bankruptcy");
		String sheetName = "Bankruptcy";

		for (int row = 2; row <= lastrow; row++) {

			// test.log(LogStatus.INFO, MarkupHelper.createLabel("CSR
			// Application is launched", ExtentColor.BLUE));
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			String VIN = TestData.getCellData(sheetName, "VIN", row);
			String NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
			String ProductType=TestData.getCellData(sheetName, "ProductType", row);
			String ReasonsforTransfer = TestData.getCellData(sheetName, "ReasonsforTransfer", row);
			String Comments = TestData.getCellData(sheetName, "Comments", row);
			if (SSN.equals(RegSSN)) {
				 String SSN1 = SSN.substring(0, 3);
			        String SSN2 = SSN.substring(3,5);
			        String SSN3 = SSN.substring(5,9);
			
       Thread.sleep(4000);
		//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
		test.log(LogStatus.INFO, "Bankruptcy  process is initiated");

					    
				 driver.switchTo().defaultContent();
				 driver.switchTo().frame("topFrame");
// -----------------------------------
			// driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id='900000']/a")).click();
				

				test.log(LogStatus.PASS, "Clicked on Borrower");
				Thread.sleep(2000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.xpath("//*[@id='909900']/a")).click();
                test.log(LogStatus.PASS, "Clicked on Bankrupt/Deceased Suite Link");
                Thread.sleep(5000);
            	driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
                
				Thread.sleep(1000);
				driver.findElement(By.name("requestBean.vinNbr")).sendKeys(NewVIN);
				test.log(LogStatus.PASS, "VIN selected as " + NewVIN);
				Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[3]/tbody/tr/td[2]/input")).click();
				test.log(LogStatus.PASS, "clicked on submit button"); 
				
				Thread.sleep(1000);
				
					
				if(NewVIN.equalsIgnoreCase(NewVIN)){
					
					test.log(LogStatus.PASS, "NewVIN is" + NewVIN);
					test.log(LogStatus.PASS, "Borrower Edit search with NewVIN Completed Successfully");
					}
					else{
					//test.log(LogStatus.PASS, "NewVIN is failed");
					
					test.log(LogStatus.PASS, "Borrower Edit search with NewVIN not Completed Successfully");
					}
			
			
               Thread.sleep(5000);
    driver.close();
				 
// ------------------------------------
				
				 break;
			}
						}	
				
				
			}

							catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								

							}

				}

			
public static void New_Loan(String SSN, String AppURL) {
	
	try {
		
		int lastrow = TestData.getLastRow("New_Loan");
		String sheetName = "New_Loan";

		for (int row = 2; row <= lastrow; row++) {

			// test.log(LogStatus.INFO, MarkupHelper.createLabel("CSR
			// Application is launched", ExtentColor.BLUE));
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			String VIN = TestData.getCellData(sheetName, "VIN", row);
			String NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
			String ProductType=TestData.getCellData(sheetName, "ProductType", row);
			String ReasonsforTransfer = TestData.getCellData(sheetName, "ReasonsforTransfer", row);
			String Comments = TestData.getCellData(sheetName, "Comments", row);
			if (SSN.equals(RegSSN)) {
				 String SSN1 = SSN.substring(0, 3);
			        String SSN2 = SSN.substring(3,5);
			        String SSN3 = SSN.substring(5,9);
			
       Thread.sleep(4000);
		//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
		test.log(LogStatus.INFO, "Bankruptcy  process is initiated");

					    
				    driver.switchTo().defaultContent();
				    driver.switchTo().frame("topFrame");
					driver.findElement(locator(Vprop.getProperty("transactions_tab"))).click();
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(locator(Vprop.getProperty("csr_new_loan_link"))).click();
					test.log(LogStatus.PASS, "Clicked on New Loan");
                Thread.sleep(5000);
            	driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
                
				Thread.sleep(1000);
				driver.findElement(By.name("requestBean.vinNbr")).sendKeys(NewVIN);
				test.log(LogStatus.PASS, "VIN selected as " + NewVIN);
				Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[2]")).click();
				test.log(LogStatus.PASS, "clicked on submit button"); 
				
				Thread.sleep(1000);
				
					
				if(NewVIN.equalsIgnoreCase(NewVIN)){
					
					test.log(LogStatus.PASS, "NewVIN is" + NewVIN);
					test.log(LogStatus.PASS, "New_Loan search with NewVIN Completed Successfully");
					}
					else{
					//test.log(LogStatus.PASS, "NewVIN is failed");
					
					test.log(LogStatus.PASS, "New_Loan search with NewVIN not Completed Successfully");
					}
			
			
               Thread.sleep(5000);
    driver.close();
				 
// ------------------------------------
				
				 break;
			}
						}	
				
				
			}

							catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								

							}

				}


public static void Transaction(String SSN, String AppURL) {
	
	try {
		
		int lastrow = TestData.getLastRow("New_Loan");
		String sheetName = "New_Loan";

		for (int row = 2; row <= lastrow; row++) {

			// test.log(LogStatus.INFO, MarkupHelper.createLabel("CSR
			// Application is launched", ExtentColor.BLUE));
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			String VIN = TestData.getCellData(sheetName, "VIN", row);
			String NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
			String ProductType=TestData.getCellData(sheetName, "ProductType", row);
			String ReasonsforTransfer = TestData.getCellData(sheetName, "ReasonsforTransfer", row);
			String Comments = TestData.getCellData(sheetName, "Comments", row);
			if (SSN.equals(RegSSN)) {
				 String SSN1 = SSN.substring(0, 3);
			        String SSN2 = SSN.substring(3,5);
			        String SSN3 = SSN.substring(5,9);
			
       Thread.sleep(4000);
		//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
		test.log(LogStatus.INFO, "Bankruptcy  process is initiated");

					    
				    driver.switchTo().defaultContent();
				    driver.switchTo().frame("topFrame");
					driver.findElement(locator(Vprop.getProperty("transactions_tab"))).click();
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(locator(Vprop.getProperty("csr_new_loan_link"))).click();
					test.log(LogStatus.PASS, "Clicked on New Loan");
                Thread.sleep(5000);
            	driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
                
				Thread.sleep(1000);
				driver.findElement(By.name("requestBean.vinNbr")).sendKeys(NewVIN);
				test.log(LogStatus.PASS, "VIN selected as " + NewVIN);
				Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[2]")).click();
				test.log(LogStatus.PASS, "clicked on submit button"); 
				
				Thread.sleep(1000);
				
					
				if(NewVIN.equalsIgnoreCase(NewVIN)){
					
					test.log(LogStatus.PASS, "NewVIN is" + NewVIN);
					test.log(LogStatus.PASS, "New_Loan search with NewVIN Completed Successfully");
					}
					else{
					//test.log(LogStatus.PASS, "NewVIN is failed");
					
					test.log(LogStatus.PASS, "New_Loan search with NewVIN not Completed Successfully");
					}
			
			
               Thread.sleep(5000);
    driver.close();
				 
// ------------------------------------
				
				 break;
			}
						}	
				
				
			}

							catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								

							}

				}

			
public static void  Universal_search1(String SSN, String AppURL) {
	
	try {
		
		int lastrow = TestData.getLastRow("Borrower_Registration");
		String sheetName = "Borrower_Registration";

		for (int row = 2; row <= lastrow; row++) {

			// test.log(LogStatus.INFO, MarkupHelper.createLabel("CSR
			// Application is launched", ExtentColor.BLUE));
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			String VIN = TestData.getCellData(sheetName, "VIN", row);
			String NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
			String ProductType=TestData.getCellData(sheetName, "ProductType", row);
			String ReasonsforTransfer = TestData.getCellData(sheetName, "ReasonsforTransfer", row);
			String Comments = TestData.getCellData(sheetName, "Comments", row);
			if (SSN.equals(RegSSN)) {
				 String SSN1 = SSN.substring(0, 3);
			        String SSN2 = SSN.substring(3,5);
			        String SSN3 = SSN.substring(5,9);
			
       Thread.sleep(4000);
		//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
		test.log(LogStatus.INFO, "Bankruptcy  process is initiated");

					    
				    driver.switchTo().defaultContent();
				    driver.switchTo().frame("topFrame");
		
					driver.findElement(By.xpath("//*[@id='icons']/li[1]/a")).click();
					test.log(LogStatus.PASS, "Clicked on search link");
					Thread.sleep(5000);
					
					/* Thread.sleep(5000);
            	driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");*/
                
				//Thread.sleep(1000);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					driver.switchTo().defaultContent();
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				/*driver.findElement(locator(Vprop.getProperty("CSR_SSN_cfm_first_field"))).sendKeys(SSN1);
				test.log(LogStatus.PASS, "Confirm SSN1 is entered: "+SSN1);
				driver.findElement(locator(Vprop.getProperty("CSR_SSN_cfm_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "Confirm SSN2 is entered: "+SSN2);
				driver.findElement(locator(Vprop.getProperty("CSR_SSN_cfm_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "Confirm SSN3 is entered: "+SSN3);*/	
				Thread.sleep(3000);
				//driver.findElement(By.name("submit1")).click();
				                               
				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[2]")).click();
				                                     
				test.log(LogStatus.PASS, "clicked on submit button"); 
				
				Thread.sleep(1000);
				
					
				if(SSN.equalsIgnoreCase(RegSSN)){
					
					test.log(LogStatus.PASS, "SSN is" + RegSSN);
					test.log(LogStatus.PASS, "SSN search with Universal search Reference Completed Successfully");
					}
					else{
					//test.log(LogStatus.PASS, "NewVIN is failed");
					
					test.log(LogStatus.PASS, "New_Loan search with NewVIN not Completed Successfully");
					}
			
			
               Thread.sleep(5000);
    driver.close();
				 
// ------------------------------------
				
				 break;
			}
						}	
				
				
			}

							catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								

							}

				}

		 
public static void  Universal_search(String SSN, String AppURL) {
	
	try {
		
		int lastrow = TestData.getLastRow("Borrower_Registration");
		String sheetName = "Borrower_Registration";

		for (int row = 2; row <= lastrow; row++) {

			// test.log(LogStatus.INFO, MarkupHelper.createLabel("CSR
			// Application is launched", ExtentColor.BLUE));
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			String VIN = TestData.getCellData(sheetName, "VIN", row);
			String NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
			String ProductType=TestData.getCellData(sheetName, "ProductType", row);
			String ReasonsforTransfer = TestData.getCellData(sheetName, "ReasonsforTransfer", row);
			String Comments = TestData.getCellData(sheetName, "Comments", row);
			if (SSN.equals(RegSSN)) {
				 String SSN1 = SSN.substring(0, 3);
			        String SSN2 = SSN.substring(3,5);
			        String SSN3 = SSN.substring(5,9);
			
       Thread.sleep(4000);
		//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
		test.log(LogStatus.INFO, "Bankruptcy  process is initiated");

					    
				    driver.switchTo().defaultContent();
				    driver.switchTo().frame("topFrame");
		
					driver.findElement(By.xpath("//*[@id='icons']/li[1]/a")).click();
					test.log(LogStatus.PASS, "Clicked on search link");
					Thread.sleep(5000);
					
					/* Thread.sleep(5000);
            	driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");*/
                
				//Thread.sleep(1000);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					driver.switchTo().defaultContent();
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				/*driver.findElement(locator(Vprop.getProperty("CSR_SSN_cfm_first_field"))).sendKeys(SSN1);
				test.log(LogStatus.PASS, "Confirm SSN1 is entered: "+SSN1);
				driver.findElement(locator(Vprop.getProperty("CSR_SSN_cfm_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "Confirm SSN2 is entered: "+SSN2);
				driver.findElement(locator(Vprop.getProperty("CSR_SSN_cfm_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "Confirm SSN3 is entered: "+SSN3);*/	
				Thread.sleep(3000);
				//driver.findElement(By.name("submit1")).click();
				                               
				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[2]")).click();
				                                     
				test.log(LogStatus.PASS, "clicked on submit button"); 
				
				Thread.sleep(1000);
				
					
				if(SSN.equalsIgnoreCase(RegSSN)){
					
					test.log(LogStatus.PASS, "SSN is" + RegSSN);
					test.log(LogStatus.PASS, "SSN search with Universal search Reference Completed Successfully");
					}
					else{
					//test.log(LogStatus.PASS, "NewVIN is failed");
					
					test.log(LogStatus.PASS, "New_Loan search with NewVIN not Completed Successfully");
					}
			
			
               Thread.sleep(5000);
    driver.close();
				 
// ------------------------------------
				
				 break;
			}
						}	
				
				
			}

							catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								

							}

				}
}
		 


						 
