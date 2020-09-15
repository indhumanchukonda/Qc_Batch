package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class Central_CourtesyCalls extends QCStore{
	
	
	
	public static void prmoise_to_pay(String SSN, String AppURL) throws Exception {
		
		
		int lastrow = TestData.getLastRow("Central_Login");
		String sheetName = "Central_Login";
		


		for (int row = 2; row <= lastrow; row++) {
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			String product_type = TestData.getCellData(sheetName, "Product_Type", row);
			String customer_search = TestData.getCellData(sheetName, "Customer_search", row);
			System.out.println("...." + RegSSN);
			if (SSN.equals(RegSSN)) {

				
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3, 5);
				String SSN3 = SSN.substring(5, 9);
				 String ESSN = SSN1+""+SSN2+""+SSN3; 
				 
				    QCCSRLoginLogout.login(SSN, AppURL);
				    CSRBorrower.Loan_number(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.central_login(ESSN, AppURL);
					
				 driver.switchTo().defaultContent();	
				    driver.switchTo().frame("topFrame");
			        driver.findElement(By.xpath("//*[@id='940000']/a")).click();
			        test.log(LogStatus.PASS, "Clicked on Account Management");
			
			        driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
			        driver.findElement(By.xpath("//*[@id='940002']/a")).click();
			        test.log(LogStatus.PASS, "Clicked on courtesy calls");
			        driver.switchTo().defaultContent();	
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");
				    driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[1]/td[3]/select")).sendKeys(product_type);
				    test.log(LogStatus.PASS, "product type is selected as:" +product_type);
				    Thread.sleep(3000);
				    driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[28]/td[1]/input")).click();
				    test.log(LogStatus.PASS, "Selected customer search");
				    driver.findElement(By.xpath("//*[@id='ach12']")).sendKeys(customer_search);
				    test.log(LogStatus.PASS, "customer search selected as:" +customer_search);
				    driver.findElement(By.xpath("//*[@id='lNbr']/input")).sendKeys(Loan_number);
				    test.log(LogStatus.PASS, "Loan number entered as:" +Loan_number);
				    JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,5000)", " ");
					                              //*[@id="Search"]/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[8]/td/table/tbody/tr/td/input[3]
					driver.findElement(By.xpath("//*[@id='Search']/form/table/tbody/tr/td/table/tbody/tr[6]/td/table/tbody/tr/td/input[3]")).click();
				    test.log(LogStatus.PASS, "clicked on search");
				    Thread.sleep(3000);
				    driver.findElement(By.xpath("//*[@id='SearchResults']/form/table/tbody/tr/td/table[3]/tbody/tr[3]/td[15]/input")).click();
				    test.log(LogStatus.PASS, "Clicked on Go button under curtesy calls search");
				    
				   
			       break;	

	}
		}
		}



	public static void Central_Courtesycalls_SSN_Hyperlink(String SSN, String AppURL) throws Exception {
		
		
		int lastrow = TestData.getLastRow("Borrower_Registration");
		String sheetName = "Borrower_Registration";


		for (int row = 2; row <= lastrow; row++) {
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			System.out.println("...." + RegSSN);
			if (SSN.equals(RegSSN)) {

				
				
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3, 5);
				String SSN3 = SSN.substring(5, 9);
				 String ESSN = SSN1+""+SSN2+""+SSN3; 
				 driver.switchTo().defaultContent();	
				    driver.switchTo().frame("topFrame");
			        driver.findElement(By.xpath("//*[@id='940000']/a")).click();
			        test.log(LogStatus.PASS, "Clicked on Account Management");
			
			        driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
			        driver.findElement(By.xpath("//*[@id='940002']/a")).click();
			        test.log(LogStatus.PASS, "Clicked on Courtesy calls");
			        driver.switchTo().defaultContent();	
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");
				    driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[1]/td[3]/select")).sendKeys("ALL");
				    test.log(LogStatus.PASS, "product type is selected as ALL");
				    Thread.sleep(3000);
				    driver.findElement(By.xpath("//*[@id='Search']/form/table/tbody/tr/td/table/tbody/tr[6]/td/table/tbody/tr/td/input[3]")).click();
				    test.log(LogStatus.PASS, "Clicked on search button");
				   /* JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,5000)", " ");*/
				    Thread.sleep(5000);
				                                  //*[@id="SearchResults"]/form/table/tbody/tr/td/table[3]/tbody/tr[3]/td[15]/input
				    driver.findElement(By.xpath("//*[@id='SearchResults']/form/table/tbody/tr/td/table[3]/tbody/tr[3]/td[15]/input")).click();
				    test.log(LogStatus.PASS, "Clicked on Go Button");
				    Thread.sleep(5000);
				    driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[6]/a")).click();
				    test.log(LogStatus.PASS, "clicked on SSN hyper link");
				    Thread.sleep(3000);  
				    for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}
				    Thread.sleep(5000);  
				    String ssn1 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn1);
			        String ssn2 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn2);
			        String ssn3 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn3);
			        test.log(LogStatus.PASS, ssn1+""+ssn2+""+ssn3);
			       String BSSN = ssn1+""+ssn2+""+ssn3;
				    driver.findElement(By.xpath("//*[@id='eye']")).click();
				    
			        String ssn11 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn1);
			        String ssn12 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn2);
			        String ssn13 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn3);
			        test.log(LogStatus.PASS, ssn11+""+ssn12+""+ssn13);
			        driver.quit();
			       String ASSN = ssn11+""+ssn12+""+ssn13;
			       if(ASSN.equals(BSSN))
			       {
			    	 test.log(LogStatus.PASS, "Test Failed"); 
			       }
			       else
			       {
			    	   test.log(LogStatus.PASS, "Test passed");
			       }
			       
			       break;	
			

	}
		}
		}



}
