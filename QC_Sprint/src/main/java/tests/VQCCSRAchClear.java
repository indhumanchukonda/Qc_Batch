package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

public class VQCCSRAchClear extends QCStore {
	public static void achclearmenu(String SSN, String AppURL) {
		
			try {
				
				int lastrow = TestData.getLastRow("Achclear");
				
				String sheetName="Achclear";

				for (int row = 2; row <= lastrow; row++) {

					// test.log(LogStatus.INFO, MarkupHelper.createLabel("CSR
					// Application is launched", ExtentColor.BLUE));
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					String ProductType=TestData.getCellData(sheetName, "ProductType", row);
					
					if (SSN.equals(RegSSN)) {
						 String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					
		       Thread.sleep(4000);
				//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
				test.log(LogStatus.INFO, "achclear process is initiated");

				driver.switchTo().defaultContent();

		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
		        driver.findElement(By.cssSelector("li[id='910000']")).click();	
					
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(1000);
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.cssSelector("li[id='913000']")).click();			
				test.log(LogStatus.PASS, "Clicked on ACH link");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='9881909175']/a")).click();		
				test.log(LogStatus.PASS, "Clicked on LOC link");
				Thread.sleep(5000);
				driver.findElement(By.cssSelector("li[id='9881909179']")).click();			
				test.log(LogStatus.PASS, "Clicked on ACH Clear link");
				

					    Thread.sleep(5000);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("name=requestBean.installmentType")));
						Thread.sleep(500);
						//loan_number="11318319";
						driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_nbr);
						test.log(LogStatus.PASS, "Product Type Selected as :" + loan_nbr);
						Thread.sleep(500);
						driver.findElement(By.name("submit")).click();
				        test.log(LogStatus.PASS, "Clicked on Submit button");
												
								}
								}	
						
						
					}

									catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										test.log(LogStatus.FAIL,"Achclear process failed");

									}

						}
					

public static void achcleardropdown(String SSN, String AppURL) {
	
	try {
		
		int lastrow = TestData.getLastRow("New_Loan");
		
		String sheetName="New_Loan";

		for (int row = 2; row <= lastrow; row++) {

		
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			String ProductType=TestData.getCellData(sheetName, "ProductType", row);
			
			String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

			if (SSN.equals(RegSSN)) {
				 String SSN1 = SSN.substring(0, 3);
			        String SSN2 = SSN.substring(3,5);
			        String SSN3 = SSN.substring(5,9);
			
       Thread.sleep(4000);
		//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
		test.log(LogStatus.INFO, "achcleardropdown Loan process is initiated");

		driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
		driver.switchTo().frame("topFrame");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
        driver.findElement(By.cssSelector("li[id='910000']")).click();	
			
		test.log(LogStatus.PASS, "Clicked on Loan Transactions");
		
		
		Thread.sleep(1000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("li[id='911101']")).click();			
		test.log(LogStatus.PASS, "Clicked on Transactions link");
		Thread.sleep(5000);
		Thread.sleep(5000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("name=requestBean.installmentType")));
				Thread.sleep(500);				
				driver.findElement(By.name("requestBean.dealNbr")).sendKeys(loan_number);
				test.log(LogStatus.PASS, "Loan no entered as :" + loan_nbr);
				Thread.sleep(500);
				driver.findElement(By.name("submit1")).click();
		        test.log(LogStatus.PASS, "Clicked on Submit button");
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
				    Thread.sleep(6000);
				    driver.findElement(By.xpath("//input[@name='button' and @value='Go']")).click();
		            driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    if(ESign_CollateralType.equalsIgnoreCase("ACH"))
					{
						for( String winHandle1 : driver.getWindowHandles())
						{
						    driver.switchTo().window(winHandle1);
						}			
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");
						 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						 test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
						 Thread.sleep(8000);
						 driver.findElement(By.name("transactionList")).sendKeys(ESign_CollateralType+" Deposit");
						 test.log(LogStatus.PASS, "Transaction type is selected "+ESign_CollateralType+" Deposit");
						 driver.findElement(By.id("go_Button")).click();
						 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");

						 driver.findElement(By.name("Submit22")).click();
						 test.log(LogStatus.PASS, " cliked on finish ACH deposit button");
						 
	
						}
						
			}
		}
	}
				
			

							catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								test.log(LogStatus.FAIL,"achcleardropdown process failed");

							}

				}
}
			

				 
		 
