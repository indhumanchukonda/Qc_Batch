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

public class VQCCSRWriteOff extends QCStore {
	public static void writeoffCourtesy(String SSN, String AppURL) {
		
			try {
				
				int lastrow = TestData.getLastRow("Writeoff");
				String sheetName = "Writeoff";

				for (int row = 2; row <= lastrow; row++) {

					// test.log(LogStatus.INFO, MarkupHelper.createLabel("CSR
					// Application is launched", ExtentColor.BLUE));
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					String ProductType=TestData.getCellData(sheetName, "ProductType", row);
					String ReasonsforTransfer = TestData.getCellData(sheetName, "ReasonsforTransfer", row);
					String Comments = TestData.getCellData(sheetName, "Comments", row);
					if (SSN.equals(RegSSN)) {
						 String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					
		       Thread.sleep(4000);
				//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
				test.log(LogStatus.INFO, "Write off Loan process is initiated");

				driver.switchTo().frame("bottom");
				String Str_date = driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]"))
						.getText();
				String store_date[] = Str_date.split(":");
				business_date = store_date[1].trim();
				test.log(LogStatus.PASS, "Business date is :" + business_date);

				driver.switchTo().defaultContent();

				
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
		        driver.findElement(By.cssSelector("li[id='910000']")).click();	
					
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(1000);
				try{
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.cssSelector("li[id='911101']")).click();			
				test.log(LogStatus.PASS, "Clicked on Transactions");
				}
				catch(Exception e)
				{
					//driver.get("http://192.168.2.203/cc/login/index.jsp");
					driver.switchTo().defaultContent();	
					
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
			        driver.findElement(By.cssSelector("li[id='910000']")).click();	
						
					Thread.sleep(1000);	
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					driver.findElement(By.cssSelector("li[id='911101']")).click();	
					test.log(LogStatus.PASS, "Clicked on Transactions");
				}
				driver.switchTo().frame("main");		
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");		
				Thread.sleep(3000);
				String mainwindow=driver.getWindowHandle();
			    /*driver.switchTo().defaultContent();
			    driver.switchTo().frame("mainFrame");
			    driver.switchTo().frame("main");
			
						String mainwindow=driver.getWindowHandle();
						
					    driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					    driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).click();
					    test.log(LogStatus.PASS, "Clicked on Customer number link");
						for (String winHandle : driver.getWindowHandles()) {
							if (!mainwindow.equalsIgnoreCase(winHandle)) {
								driver.switchTo().window(winHandle);

								loan_nbr = driver.findElement(locator(Vprop.getProperty("csr_loan_nbr1"))).getText();
								test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
								Thread.sleep(2000);
								String NextDueDate = driver.findElement(locator(Vprop.getProperty("csr_due_date1"))).getText();
								test.log(LogStatus.PASS, "Next due date is " + NextDueDate);
								driver.close();
								
								break;
							}
						}
						driver.switchTo().window(mainwindow);*/
				
				//============= Taking Due Date From History ====================
				
				for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
					}
				    driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");
				    
				    
				  // String loan_nbr= driver.findElement(locator(Rprop.getProperty("csr_loan_nbr"))).getText();
				  // test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
				    driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button under search results");
					// driver.findElement(By.name("button")).click();
					
				for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}				    
					 driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					   					    
					    Thread.sleep(5000);
					    
					    	 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
							    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					
					   //  String loan_nbr= driver.findElement(locator(Rprop.getProperty("csr_loan_nbr"))).getText();
						//   test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						 driver.findElement(By.name("transactionList")).sendKeys("History");
						 test.log(LogStatus.PASS, "Transaction Type is selected as History");
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");													 													
						 Thread.sleep(3000); 
						 
						 NextDueDate=driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();
					     test.log(LogStatus.PASS, "Next due date is "+NextDueDate);		
					     Thread.sleep(1000); 
					     loan_nbr=driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[4]/td/span[2]")).getText();
					     test.log(LogStatus.PASS, "Loan Number  is "+loan_nbr);	



						Thread.sleep(5000);
				
					 
							    
						driver.switchTo().defaultContent();
						 driver.switchTo().frame("topFrame");
		// -----------------------------------
					// driver.switchTo().frame("topFrame");
						wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));
						Thread.sleep(1000);
						/*driver.get(csrloginpage);
						Thread.sleep(2000);*/

						//driver.findElement(locator(Vprop.getProperty("borrower_tab"))).click();
						driver.findElement(By.xpath("//*[@id='900000']/a")).click();
						

						test.log(LogStatus.PASS, "Clicked on Borrower");
						Thread.sleep(2000);

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.findElement(By.xpath("//*[@id='940010']/a")).click();
                        test.log(LogStatus.PASS, "Clicked on Courtesy Call Link");
                        Thread.sleep(5000);
                    	driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
                        driver.findElement(By.name("requestBean.productType")).sendKeys(ProductType);
						test.log(LogStatus.PASS, "Product Type Selected as :" + ProductType);
						Thread.sleep(1000);
						//driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[22]/td[1]/input")).click();
						driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[28]/td[1]/input")).click();
						//*[@id="queueTable"]/tbody/tr[28]/td[1]/input
						//*[@id="queueTable"]/tbody/tr[28]/td[1]/input
						test.log(LogStatus.PASS, "Clicked on Customer search radiobutton");
						Thread.sleep(5000);
						driver.findElement(By.xpath("//*[@id='ach12']/option[6]")).click();
					
						//*[@id="ach12"]/option[6]
						test.log(LogStatus.PASS, "Loan Nbr selected from List");
						Thread.sleep(3000);
						driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_nbr);
						test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_nbr);
						Thread.sleep(1000);
						
						driver.findElement(By.name("searchajax")).click();
						test.log(LogStatus.PASS, "Clicked on Search button");
						Thread.sleep(10000);	
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='SearchResults']/form/table/tbody/tr/td/table[3]/tbody/tr[3]/td[15]/input")));
						driver.findElement(By.xpath("//*[@id='SearchResults']/form/table/tbody/tr/td/table[3]/tbody/tr[3]/td[15]/input")).click();
						test.log(LogStatus.PASS, "Clicked on Go button");
						Thread.sleep(5000);	
						if(driver.findElement(By.name("transfertocoll")).isDisplayed())
						{
							test.log(LogStatus.FAIL, "Transfer to collection button is available");
							
						}
						else
						{
							test.log(LogStatus.PASS, "Transfer to collection button is not available ");
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
					
public static void transfertocentral(String SSN, String AppURL) {
	
	try {
		
		int lastrow = TestData.getLastRow("Writeoff");
		String sheetName = "Writeoff";

		for (int row = 2; row <= lastrow; row++) {

			// test.log(LogStatus.INFO, MarkupHelper.createLabel("CSR
			// Application is launched", ExtentColor.BLUE));
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			String ProductType=TestData.getCellData(sheetName, "ProductType", row);
			String ReasonsforTransfer = TestData.getCellData(sheetName, "ReasonsforTransfer", row);
			String Comments = TestData.getCellData(sheetName, "Comments", row);
			if (SSN.equals(RegSSN)) {
				 String SSN1 = SSN.substring(0, 3);
			        String SSN2 = SSN.substring(3,5);
			        String SSN3 = SSN.substring(5,9);
			
       Thread.sleep(4000);
		//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
		test.log(LogStatus.INFO, "Write off Loan process is initiated");

		driver.switchTo().frame("bottom");
		String Str_date = driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]"))
				.getText();
		String store_date[] = Str_date.split(":");
		business_date = store_date[1].trim();
		test.log(LogStatus.PASS, "Business date is :" + business_date);

		driver.switchTo().defaultContent();

		
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
		driver.switchTo().frame("topFrame");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
        driver.findElement(By.cssSelector("li[id='910000']")).click();	
			
		test.log(LogStatus.PASS, "Clicked on Loan Transactions");
		Thread.sleep(1000);
		try{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("li[id='911101']")).click();			
		test.log(LogStatus.PASS, "Clicked on Transactions");
		}
		catch(Exception e)
		{
			//driver.get("http://192.168.2.203/cc/login/index.jsp");
			driver.switchTo().defaultContent();	
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
			driver.switchTo().frame("topFrame");
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
	        driver.findElement(By.cssSelector("li[id='910000']")).click();	
				
			Thread.sleep(1000);	
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector("li[id='911101']")).click();	
			test.log(LogStatus.PASS, "Clicked on Transactions");
		}
		driver.switchTo().frame("main");		
		driver.findElement(By.name("ssn1")).sendKeys(SSN1);
		test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
		driver.findElement(By.name("ssn2")).sendKeys(SSN2);
		test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
		driver.findElement(By.name("ssn3")).sendKeys(SSN3);
		test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
		driver.findElement(By.name("submit1")).click();
		test.log(LogStatus.PASS, "Click on submit Button");		
		Thread.sleep(3000);
		String mainwindow=driver.getWindowHandle();
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame("mainFrame");
	    driver.switchTo().frame("main");
	
		/*		//String mainwindow=driver.getWindowHandle();
				
			    driver.switchTo().defaultContent();
			    driver.switchTo().frame("mainFrame");
			    driver.switchTo().frame("main");
			    driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).click();
			    test.log(LogStatus.PASS, "Clicked on Customer number link");
				for (String winHandle : driver.getWindowHandles()) {
					if (!mainwindow.equalsIgnoreCase(winHandle)) {
						driver.switchTo().window(winHandle);

						loan_nbr = driver.findElement(locator(Vprop.getProperty("csr_loan_nbr1"))).getText();
						test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						Thread.sleep(2000);
						String NextDueDate = driver.findElement(locator(Vprop.getProperty("csr_due_date1"))).getText();
						test.log(LogStatus.PASS, "Next due date is " + NextDueDate);
						driver.close();
						
						break;
					}
				}*/
				//driver.switchTo().window(mainwindow);
		
		//============= Taking Due Date From History ====================
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
			}
		    driver.switchTo().defaultContent();
		    driver.switchTo().frame("mainFrame");
		    driver.switchTo().frame("main");
		    
		    
		  // String loan_nbr= driver.findElement(locator(Rprop.getProperty("csr_loan_nbr"))).getText();
		  // test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
		    driver.findElement(By.name("button")).click();
			test.log(LogStatus.PASS, "Clicked on GO Button under search results");
			// driver.findElement(By.name("button")).click();
			
		for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
				}				    
			 driver.switchTo().defaultContent();
			    driver.switchTo().frame("mainFrame");
			    driver.switchTo().frame("main");
			   					    
			    Thread.sleep(5000);
			    
			    	 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
			
			   //  String loan_nbr= driver.findElement(locator(Rprop.getProperty("csr_loan_nbr"))).getText();
				//   test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
				 driver.findElement(By.name("transactionList")).sendKeys("History");
				 test.log(LogStatus.PASS, "Transaction Type is selected as History");
				 driver.findElement(By.name("button")).click();
				 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");													 													
				 Thread.sleep(3000); 
				 
				// NextDueDate=driver.findElement(locator(Jprop.getProperty("loan_status_inf_due_date"))).getText();
				 
				// NextDueDate=	//*[@id="transactionHistoryTable"]/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]
						 
		NextDueDate=driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();
			
				 
				 
			     test.log(LogStatus.PASS, "Next due date is "+NextDueDate);		
			     Thread.sleep(1000); 
			     //loan_nbr=driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[4]/td/span[2]")).getText();
			     loan_nbr=driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[4]/td/span[2]")).getText();
			   
			     
			     test.log(LogStatus.PASS, "Loan Number  is "+loan_nbr);	



				Thread.sleep(5000);
		
			 
					    
				driver.switchTo().defaultContent();
				 driver.switchTo().frame("topFrame");
// -----------------------------------
			// driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));
				Thread.sleep(1000);
				/*driver.get(csrloginpage);
				Thread.sleep(2000);*/

				//driver.findElement(locator(Vprop.getProperty("borrower_tab"))).click();
				driver.findElement(By.xpath("//*[@id='900000']/a")).click();
				

				test.log(LogStatus.PASS, "Clicked on Borrower");
				Thread.sleep(2000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.xpath("//*[@id='940010']/a")).click();
                test.log(LogStatus.PASS, "Clicked on Courtesy Call Link");
                Thread.sleep(5000);
            	driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
                driver.findElement(By.name("requestBean.productType")).sendKeys(ProductType);
				test.log(LogStatus.PASS, "Product Type Selected as :" + ProductType);
				Thread.sleep(1000);
				//driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[22]/td[1]/input")).click();
				
				//driver.findElement(By.name("requestBean.collectionType ")).click();
				driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[28]/td[1]/input")).click();
				
				test.log(LogStatus.PASS, "Clicked on Customer search radiobutton");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='ach12']/option[6]")).click();
			
				//*[@id="ach12"]/option[6]
				test.log(LogStatus.PASS, "Loan Nbr selected from List");
				Thread.sleep(3000);
				driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_nbr);
				test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_nbr);
				Thread.sleep(1000);
				
				driver.findElement(By.name("searchajax")).click();
				test.log(LogStatus.PASS, "Clicked on Search button");
				Thread.sleep(10000);	
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='SearchResults']/form/table/tbody/tr/td/table[3]/tbody/tr[3]/td[15]/input")));
				driver.findElement(By.xpath("//*[@id='SearchResults']/form/table/tbody/tr/td/table[3]/tbody/tr[3]/td[15]/input")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				Thread.sleep(5000);	
				
				
			    driver.switchTo().frame("mainFrame");
			    driver.switchTo().frame("main");
				
				
				if(driver.findElement(By.name("transfertocentral")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "transfer to central button is available");
					
				}
				else
				{
					test.log(LogStatus.PASS, "transfer to central button is not available ");
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
			

public static void LOCwriteoffCourtesy(String SSN, String AppURL) {
	
	try {
		
		int lastrow = TestData.getLastRow("Writeoff");
		String sheetName = "Writeoff";

		for (int row = 2; row <= lastrow; row++) {

			// test.log(LogStatus.INFO, MarkupHelper.createLabel("CSR
			// Application is launched", ExtentColor.BLUE));
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			String ProductType=TestData.getCellData(sheetName, "ProductType", row);
			String ReasonsforTransfer = TestData.getCellData(sheetName, "ReasonsforTransfer", row);
			String Comments = TestData.getCellData(sheetName, "Comments", row);
			if (SSN.equals(RegSSN)) {
				 String SSN1 = SSN.substring(0, 3);
			        String SSN2 = SSN.substring(3,5);
			        String SSN3 = SSN.substring(5,9);
			
       Thread.sleep(4000);
		//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
		test.log(LogStatus.INFO, "Write off Loan process is initiated");

		driver.switchTo().frame("bottom");
		String Str_date = driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]"))
				.getText();
		String store_date[] = Str_date.split(":");
		business_date = store_date[1].trim();
		test.log(LogStatus.PASS, "Business date is :" + business_date);

		driver.switchTo().defaultContent();

		
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
		driver.switchTo().frame("topFrame");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
        driver.findElement(By.cssSelector("li[id='910000']")).click();	
			
		test.log(LogStatus.PASS, "Clicked on Loan Transactions");
		Thread.sleep(1000);
		try{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("li[id='911101']")).click();			
		test.log(LogStatus.PASS, "Clicked on Transactions");
		}
		catch(Exception e)
		{
			//driver.get("http://192.168.2.203/cc/login/index.jsp");
			driver.switchTo().defaultContent();	
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
			driver.switchTo().frame("topFrame");
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
	        driver.findElement(By.cssSelector("li[id='910000']")).click();	
				
			Thread.sleep(1000);	
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector("li[id='911101']")).click();	
			test.log(LogStatus.PASS, "Clicked on Transactions");
		}
		driver.switchTo().frame("main");		
		driver.findElement(By.name("ssn1")).sendKeys(SSN1);
		test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
		driver.findElement(By.name("ssn2")).sendKeys(SSN2);
		test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
		driver.findElement(By.name("ssn3")).sendKeys(SSN3);
		test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
		driver.findElement(By.name("submit1")).click();
		test.log(LogStatus.PASS, "Click on submit Button");		
		Thread.sleep(3000);
		String mainwindow=driver.getWindowHandle();
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame("mainFrame");
	    driver.switchTo().frame("main");
	
		/*		//String mainwindow=driver.getWindowHandle();
				
			    driver.switchTo().defaultContent();
			    driver.switchTo().frame("mainFrame");
			    driver.switchTo().frame("main");
			    driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).click();
			    test.log(LogStatus.PASS, "Clicked on Customer number link");
				for (String winHandle : driver.getWindowHandles()) {
					if (!mainwindow.equalsIgnoreCase(winHandle)) {
						driver.switchTo().window(winHandle);

						loan_nbr = driver.findElement(locator(Vprop.getProperty("csr_loan_nbr1"))).getText();
						test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						Thread.sleep(2000);
						String NextDueDate = driver.findElement(locator(Vprop.getProperty("csr_due_date1"))).getText();
						test.log(LogStatus.PASS, "Next due date is " + NextDueDate);
						driver.close();
						
						break;
					}
				}*/
				//driver.switchTo().window(mainwindow);
		
		//============= Taking Due Date From History ====================
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
			}
		    driver.switchTo().defaultContent();
		    driver.switchTo().frame("mainFrame");
		    driver.switchTo().frame("main");
		    
		    
		  // String loan_nbr= driver.findElement(locator(Rprop.getProperty("csr_loan_nbr"))).getText();
		  // test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
		    driver.findElement(By.name("button")).click();
			test.log(LogStatus.PASS, "Clicked on GO Button under search results");
			// driver.findElement(By.name("button")).click();
			
		for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
				}				    
			 driver.switchTo().defaultContent();
			    driver.switchTo().frame("mainFrame");
			    driver.switchTo().frame("main");
			   					    
			    Thread.sleep(5000);
			    
			    	 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
			
			   //  String loan_nbr= driver.findElement(locator(Rprop.getProperty("csr_loan_nbr"))).getText();
				//   test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
				 driver.findElement(By.name("transactionList")).sendKeys("History");
				 test.log(LogStatus.PASS, "Transaction Type is selected as History");
				 driver.findElement(By.name("button")).click();
				 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");													 													
				 Thread.sleep(3000); 
				 
				 NextDueDate= driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();
				 //NextDueDate=driver.findElement(locator(Jprop.getProperty("loan_status_inf_due_date"))).getText();
			     test.log(LogStatus.PASS, "Next due date is "+NextDueDate);		
			     Thread.sleep(1000); 
			     loan_nbr=driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[4]/td/span[2]")).getText();
			     test.log(LogStatus.PASS, "Loan Number  is "+loan_nbr);	



				Thread.sleep(5000);
		
			 
					    
				driver.switchTo().defaultContent();
				 driver.switchTo().frame("topFrame");
// -----------------------------------
			// driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));
				Thread.sleep(1000);
				/*driver.get(csrloginpage);
				Thread.sleep(2000);*/

				//driver.findElement(locator(Vprop.getProperty("borrower_tab"))).click();
				driver.findElement(By.xpath("//*[@id='900000']/a")).click();
				

				test.log(LogStatus.PASS, "Clicked on Borrower");
				Thread.sleep(2000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.xpath("//*[@id='940010']/a")).click();
                test.log(LogStatus.PASS, "Clicked on Courtesy Call Link");
                Thread.sleep(5000);
            	driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
                driver.findElement(By.name("requestBean.productType")).sendKeys(ProductType);
				test.log(LogStatus.PASS, "Product Type Selected as :" + ProductType);
				Thread.sleep(1000);
				//driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[22]/td[1]/input")).click();
				
				//driver.findElement(By.name("requestBean.collectionType ")).click();
				driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[28]/td[1]/input")).click();
				
				test.log(LogStatus.PASS, "Clicked on Customer search radiobutton");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='ach12']/option[6]")).click();
			
				//*[@id="ach12"]/option[6]
				test.log(LogStatus.PASS, "Loan Nbr selected from List");
				Thread.sleep(3000);
				driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_nbr);
				test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_nbr);
				Thread.sleep(1000);
				
				driver.findElement(By.name("searchajax")).click();
				test.log(LogStatus.PASS, "Clicked on Search button");
				Thread.sleep(10000);	
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='SearchResults']/form/table/tbody/tr/td/table[3]/tbody/tr[3]/td[15]/input")));
				driver.findElement(By.xpath("//*[@id='SearchResults']/form/table/tbody/tr/td/table[3]/tbody/tr[3]/td[15]/input")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				Thread.sleep(5000);	
				if(driver.findElement(By.name("transfertocoll")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Transfer to collection button is available");
					
				}
				else
				{
					test.log(LogStatus.PASS, "Transfer to collection button is not available ");
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

		 


						 
