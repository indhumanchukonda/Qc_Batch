package tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class JQCACHReturn extends QCStore {
	
	public static void ACHReturn(String SSN,String AppURL) throws InterruptedException
	{
		
			int lastrow=TestData.getLastRow("ACHReturn");
			String sheetName="ACHReturn";
			

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				String Return_For_Reason = TestData.getCellData(sheetName,"Return_For_Reason",row);
				
				if(SSN.equals(RegSSN))
				{
				
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		       	        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				       		       
				
		       Thread.sleep(4000);
				test.log(LogStatus.INFO, "ACH Return from CSR has initiated");
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
				
			    driver.switchTo().defaultContent();
			    driver.switchTo().frame("mainFrame");
			    driver.switchTo().frame("main");
			    
			    driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button under search results");
				
					    
				 	driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");
				    
				  
					  driver.findElement(locator(prop.getProperty("clear_go"))).click();
					  test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    
				    Thread.sleep(5000);
				     String loan_nbr= driver.findElement(locator(prop.getProperty("csr_loan_nbr"))).getText();
					  test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
					   driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");

						Thread.sleep(2000);
		
							Actions action = new Actions(driver);  
							 WebElement collateral=driver.findElement(locator(prop.getProperty("ACH")));
							 action.moveToElement(collateral).build().perform();
							 test.log(LogStatus.PASS, " Mouse hover on ACH menu");
							 Thread.sleep(2000);
							 WebElement pdl=driver.findElement(locator(prop.getProperty("deposit_ach_pdl")));
							 action.moveToElement(pdl).build().perform();
							 test.log(LogStatus.PASS, " Mouse hover on payday loan menu");
							 Thread.sleep(3000);
							 driver.findElement(locator(prop.getProperty("ACH_Return"))).click();
							 test.log(LogStatus.PASS, " click on clear menu");
							 Thread.sleep(2000);
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 driver.findElement(locator(prop.getProperty("deposite_menu_loannbr"))).sendKeys(loan_nbr);
							 driver.findElement(locator(prop.getProperty("ACH_submit"))).click();
							 test.log(LogStatus.PASS, "Clicked on submit button");
							 Thread.sleep(2000);
							 driver.findElement(locator(prop.getProperty("deposit_check_box"))).click();
							 test.log(LogStatus.PASS, "Clicked on Check box ");
							 driver.findElement(locator(prop.getProperty("ACH_Return_reason"))).sendKeys(Return_For_Reason);
							 test.log(LogStatus.PASS, "Seleted reason for return as  "+Return_For_Reason);
							 driver.findElement(locator(prop.getProperty("finish_ach_deposit"))).click();
							 test.log(LogStatus.PASS, "Clicked on  ACH Return button");
							 if(driver.findElement(locator(prop.getProperty("ACH_Return_success"))).isDisplayed()){
							 test.log(LogStatus.PASS, " ACH Return menu from CSR is successfull");
							 test.log(LogStatus.PASS, "********************************************** ");
							 }
						break;
				}
				
				 
			}
			
		
			
		
	}

	public static void AACHReturn(String SSN,String AppURL) throws InterruptedException
	{
		int lastrow=TestData.getLastRow("ACHReturn");
		String sheetName="ACHReturn";
	
			
		for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				String StoreID = TestData.getCellData(sheetName,"StoreID",row);
				String Return_For_Reason = TestData.getCellData(sheetName,"Return_For_Reason",row);
				
				if(SSN.equals(RegSSN))
				{
						
		       Thread.sleep(4000);
				test.log(LogStatus.INFO, "ACH Processing through from Admin has initiated");
				driver.switchTo().defaultContent();	
		       // //wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(prop.getProperty("admin_ACH_transaction"))).click();		
				test.log(LogStatus.PASS, "Clicked on Transactions");
				Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
			
				 Actions action = new Actions(driver);  
				 WebElement ACH=driver.findElement(locator(prop.getProperty("admin_ACH_menu")));
				 action.moveToElement(ACH).build().perform();
				 test.log(LogStatus.PASS, " Mouse hover on ACH menu");
				 Thread.sleep(2000);
				 WebElement pdl=driver.findElement(locator(prop.getProperty("admin_pdl")));
				 action.moveToElement(pdl).build().perform();
				 test.log(LogStatus.PASS, " Mouse hover on payday loan menu");
				 Thread.sleep(3000);
				 driver.findElement(By.xpath("//*[@id='503013']/a")).click();
				 //driver.findElement(locator(prop.getProperty("admin_ACH_processing"))).click();
				 test.log(LogStatus.PASS, " click on ACH Return");
				 Thread.sleep(3000);
				
						    
			 driver.switchTo().defaultContent();
			 driver.switchTo().frame("mainFrame");
			 driver.switchTo().frame("main");
			 
			 driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[1]/td[2]/input")).sendKeys(StoreID);
			// driver.findElement(locator(prop.getProperty("admin_str_nbr_btn"))).click();
			 /*driver.findElement(locator(prop.getProperty("admin_str_nbr"))).sendKeys(StoreID);
			 test.log(LogStatus.PASS, "StoreID is entered: "+StoreID);*/
			 driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[2]/tbody/tr/td[2]/input")).click();
			 driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table[2]/tbody/tr[3]/td[1]")).click();
			 driver.findElement(By.xpath("//*[@name='rtnReasonId']")).sendKeys(Return_For_Reason);
			 driver.findElement(By.xpath("//*[@id='CmdReturnPosting']")).click();
			/* System.out.println(NextDueDate);
			 test.log(LogStatus.PASS, "Age Store Date is :"+NextDueDate);
			 Thread.sleep(5000);
			 String Due_Date[] =NextDueDate.split("/");
		     String Due_Date1 = Due_Date[0];
		     String Due_Date2 = Due_Date[1];
		     String Due_Date3 = Due_Date[2];
		     driver.findElement(locator(prop.getProperty("bgn_mon"))).clear();
		     driver.findElement(locator(prop.getProperty("bgn_mon"))).sendKeys(Due_Date1);
		        test.log(LogStatus.PASS, "Begin Month is entered: "+Due_Date1);
		        driver.findElement(locator(prop.getProperty("bgn_date"))).clear();
		        driver.findElement(locator(prop.getProperty("bgn_date"))).sendKeys(Due_Date2);
				test.log(LogStatus.PASS, "Begin Date is entered: "+Due_Date2);
				driver.findElement(locator(prop.getProperty("bgn_year"))).clear();
				driver.findElement(locator(prop.getProperty("bgn_year"))).sendKeys(Due_Date3);
				test.log(LogStatus.PASS, "Begin Year is entered: "+Due_Date3);
				
				driver.findElement(locator(prop.getProperty("end_mon"))).clear();
				driver.findElement(locator(prop.getProperty("end_mon"))).sendKeys(Due_Date1);
		        test.log(LogStatus.PASS, "End Month is entered: "+Due_Date1);
		        driver.findElement(locator(prop.getProperty("end_date"))).clear();
		        driver.findElement(locator(prop.getProperty("end_date"))).sendKeys(Due_Date2);
				test.log(LogStatus.PASS, "End Date is entered: "+Due_Date2);
				driver.findElement(locator(prop.getProperty("end_year"))).clear();
				driver.findElement(locator(prop.getProperty("end_year"))).sendKeys(Due_Date3);
				test.log(LogStatus.PASS, "End Year is entered: "+Due_Date3); 
				driver.findElement(locator(prop.getProperty("admin_search"))).click();
				test.log(LogStatus.PASS, "Click on Submit button ");
				Thread.sleep(5000);
				driver.findElement(locator(prop.getProperty("ACH_process_now"))).click();
				driver.switchTo().defaultContent();
				 driver.switchTo().frame("mainFrame");
				 driver.switchTo().frame("main");
				if(driver.findElement(By.xpath("//td[text()='ACH file(s) created successfully']")).isDisplayed()){
				test.log(LogStatus.PASS, "Clicked on ACH Process Now Successfully");
				 test.log(LogStatus.PASS, "********************************************** ");
				}else{
					test.log(LogStatus.INFO, "Clicked on ACH Process Now Successfully");
					 test.log(LogStatus.PASS, "********************************************** ");
				}*/
				break;
					 
				}
			
				}


	}
}
