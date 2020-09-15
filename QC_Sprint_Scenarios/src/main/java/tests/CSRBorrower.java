package tests;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class CSRBorrower extends QCStore {
	public static void Borrower_Edit(String SSN, String AppURL) throws Exception {
		
		
			int lastrow = TestData.getLastRow("Login");
			String sheetName = "Login";
	

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				System.out.println("...." + RegSSN);
				if (SSN.equals(RegSSN)) {

					
					
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3, 5);
					String SSN3 = SSN.substring(5, 9);
					 String ESSN = SSN1+""+SSN2+""+SSN3; 
					  driver.switchTo().frame("topFrame");	        
				        
				        driver.switchTo().defaultContent();	

						
						driver.switchTo().frame("topFrame");
						wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
						driver.findElement(By.cssSelector("li[id='910000']")).click();		
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");
						Thread.sleep(3000);
						
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
						String Customer_number = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).getText();
						test.log(LogStatus.PASS, "customer number is:" +Customer_number);
					    driver.switchTo().defaultContent();	
					    driver.switchTo().frame("topFrame");
				        driver.findElement(By.xpath("//*[contains(text(),'Borrower')]")).click();
				        test.log(LogStatus.PASS, "Clicked on Borrower");
				        driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.findElement(By.xpath("//*[@id='902000']/a")).click();
				        test.log(LogStatus.PASS, "Clicked on Edit");
				        driver.switchTo().frame("main");
				        driver.findElement(By.name("requestBean.cusNbr")).sendKeys(Customer_number);
				        test.log(LogStatus.PASS, "Enter customer number as "+Customer_number);
				        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[2]")).click();
				        test.log(LogStatus.PASS, "click on submit Button");
				        driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[9]/input")).click();
				        test.log(LogStatus.PASS, "click on GO Button");
				        String ssn11 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
				        //test.log(LogStatus.PASS, ssn1);
				        String ssn12 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
				        //test.log(LogStatus.PASS, ssn2);
				        String ssn13 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
				        //test.log(LogStatus.PASS, ssn3);
				        test.log(LogStatus.PASS, ssn11+""+ssn12+""+ssn13);
				        driver.findElement(By.xpath("//*[@id='eye']")).click();
				        String ssn1 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
				        //test.log(LogStatus.PASS, ssn1);
				        String ssn2 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
				        //test.log(LogStatus.PASS, ssn2);
				        String ssn3 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
				        //test.log(LogStatus.PASS, ssn3);
				        test.log(LogStatus.PASS, ssn1+""+ssn2+""+ssn3);
				       String ASSN = ssn1+""+ssn2+""+ssn3;
				       if(ASSN.equalsIgnoreCase(ESSN))
				       {
				    	 test.log(LogStatus.PASS, "Borrower_Edit Test passed"); 
				       }
				break;	

		}
			}
			}
	
	
	public static void Borrower_Edit_personal_summery(String SSN, String AppURL) throws Exception {
		
		
		int lastrow = TestData.getLastRow("Login");
		String sheetName = "Login";


		for (int row = 2; row <= lastrow; row++) {
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			System.out.println("...." + RegSSN);
			if (SSN.equals(RegSSN)) {

				
				
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3, 5);
				String SSN3 = SSN.substring(5, 9);
				 String ESSN = SSN1+""+SSN2+""+SSN3; 
				  driver.switchTo().frame("topFrame");	        
			        
			        driver.switchTo().defaultContent();	

					
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					driver.findElement(By.cssSelector("li[id='910000']")).click();		
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(3000);
					
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
					String Customer_number = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).getText();
					test.log(LogStatus.PASS, "customer number is:" +Customer_number);
				    driver.switchTo().defaultContent();	
				    driver.switchTo().frame("topFrame");
			        driver.findElement(By.xpath("//*[contains(text(),'Borrower')]")).click();
			        test.log(LogStatus.PASS, "Clicked on Borrower");
			        driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.findElement(By.xpath("//*[@id='902000']/a")).click();
			        test.log(LogStatus.PASS, "Clicked on Edit");
			        driver.switchTo().frame("main");
			        driver.findElement(By.name("requestBean.cusNbr")).sendKeys(Customer_number);
			        test.log(LogStatus.PASS, "Enter customer number as "+Customer_number);
			        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[2]")).click();
			        test.log(LogStatus.PASS, "click on submit Button");
			        driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[9]/input")).click();
			        test.log(LogStatus.PASS, "click on GO Button");
			        String ssn11 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn1);
			        String ssn12 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn2);
			        String ssn13 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn3);
			        test.log(LogStatus.PASS, ssn11+""+ssn12+""+ssn13);
			        driver.findElement(By.xpath("//*[@id='eye']")).click();
			        String ssn1 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn1);
			        String ssn2 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn2);
			        String ssn3 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn3);
			        test.log(LogStatus.PASS, ssn1+""+ssn2+""+ssn3);
			       String ASSN = ssn1+""+ssn2+""+ssn3;
			       Thread.sleep(5000);
			       try
			       {
			    	   driver.switchTo().alert().accept();
			       }
			       catch(Exception ex){
			    	   
			       }
			       if(ASSN.equalsIgnoreCase(ESSN))
			       {
			    	 test.log(LogStatus.PASS, "Test passed"); 
			       }
			       driver.findElement(By.xpath("//*[@id='perTab']/img")).click();
			       test.log(LogStatus.PASS, "clicked on personal information");
			       Thread.sleep(5000);
			       try
			       {
			    	   driver.switchTo().alert().accept();
			       }
			       catch(Exception ex){
			    	   
			       }
			       String ssn21 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn1);
			        String ssn22 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn2);
			        String ssn23 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn3);
			        test.log(LogStatus.PASS, ssn21+""+ssn22+""+ssn23);
			        driver.findElement(By.xpath("//*[@id='eye']")).click();
			        Thread.sleep(5000);
				       try
				       {
				    	   driver.switchTo().alert().accept();
				       }
				       catch(Exception ex){
				    	   
				       }
			        String ssn31 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn1);
			        String ssn32 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn2);
			        String ssn33 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn3);
			        test.log(LogStatus.PASS, ssn31+""+ssn32+""+ssn33);
			       String AASSN = ssn1+""+ssn2+""+ssn3;
			       String EESSN = SSN1+""+SSN2+""+SSN3; 
			       if(AASSN.equalsIgnoreCase(ESSN))
			       {
			    	 test.log(LogStatus.PASS, "Test passed"); 
			       }
			break;	

	}
		}
		}
	
	
	
	public static void Borrower_Edit_Saveexit_savenext(String SSN, String AppURL) throws Exception {
		
		
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
				  driver.switchTo().frame("topFrame");	        
			        
			        driver.switchTo().defaultContent();	

					
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					driver.findElement(By.cssSelector("li[id='910000']")).click();		
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(3000);
					
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
					String Customer_number = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).getText();
					test.log(LogStatus.PASS, "customer number is:" +Customer_number);
				    driver.switchTo().defaultContent();	
				    driver.switchTo().frame("topFrame");
			        driver.findElement(By.xpath("//*[contains(text(),'Borrower')]")).click();
			        test.log(LogStatus.PASS, "Clicked on Borrower");
			        driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.findElement(By.xpath("//*[@id='902000']/a")).click();
			        test.log(LogStatus.PASS, "Clicked on Edit");
			        driver.switchTo().frame("main");
			        driver.findElement(By.name("requestBean.cusNbr")).sendKeys(Customer_number);
			        test.log(LogStatus.PASS, "Enter customer number as "+Customer_number);
			        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[2]")).click();
			        test.log(LogStatus.PASS, "click on submit Button");
			        driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[9]/input")).click();
			        test.log(LogStatus.PASS, "click on GO Button");
			        String ssn11 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn1);
			        String ssn12 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn2);
			        String ssn13 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn3);
			        test.log(LogStatus.PASS, ssn11+""+ssn12+""+ssn13);
			        driver.findElement(By.xpath("//*[@id='eye']")).click();
			        String ssn1 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn1);
			        String ssn2 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn2);
			        String ssn3 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn3);
			        test.log(LogStatus.PASS, ssn1+""+ssn2+""+ssn3);
			       String ASSN = ssn1+""+ssn2+""+ssn3;
			       driver.findElement(By.xpath("//*[@id='btnShowModal']")).click();
			       test.log(LogStatus.PASS, "clicked on save and next button");
			       driver.close();
			   
			break;	

	}
		}
		}
	
public static void Misc_Transactions(String SSN, String AppURL) throws Exception {
		
		
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
				  driver.switchTo().frame("topFrame");	        
			        
			        driver.switchTo().defaultContent();	

					
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					driver.findElement(By.cssSelector("li[id='910000']")).click();		
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(3000);
					
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
					String Customer_number = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).getText();
					test.log(LogStatus.PASS, "customer number is:" +Customer_number);
				    driver.switchTo().defaultContent();	
				    driver.switchTo().frame("topFrame");
			        driver.findElement(By.xpath("//*[@id='920000']/a")).click();
			        test.log(LogStatus.PASS, "Clicked on Misc Transactions");
			        driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.findElement(By.xpath("//*[@id='921000']/a")).click();
			        test.log(LogStatus.PASS, "Clicked on Misc Receipts");
			        Thread.sleep(3000);
			        
			        driver.findElement(By.xpath("//*[@id='921001']/a")).click();
			        test.log(LogStatus.PASS, "clicked on Bill Pay");
			        driver.switchTo().frame("main");
			        driver.findElement(By.name("requestBean.cusNbr")).sendKeys(Customer_number);
			        test.log(LogStatus.PASS, "Enter customer number as "+Customer_number);
			        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[2]")).click();
			        test.log(LogStatus.PASS, "click on submit Button");
			        driver.findElement(By.xpath("//*[@id='Miscpic1']")).click();
			        test.log(LogStatus.PASS, "Clicked SSN/ITIN Hyper Link");
			        for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}
			        String ssn11 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn1);
			        String ssn12 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn2);
			        String ssn13 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn3);
			        test.log(LogStatus.PASS, ssn11+""+ssn12+""+ssn13);
			        driver.findElement(By.xpath("//*[@id='eye']")).click();
			        String ssn1 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn1);
			        String ssn2 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn2);
			        String ssn3 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn3);
			        test.log(LogStatus.PASS, ssn1+""+ssn2+""+ssn3);
			       String ASSN = ssn1+""+ssn2+""+ssn3;
			       if(ASSN.equalsIgnoreCase(ESSN))
			       {
			    	 test.log(LogStatus.PASS, "Test passed"); 
			       }
			       Thread.sleep(2000);
			       driver.close();
			break;	

			   
				

	}
		}
		}
public static void Misc_Customer_registration(String SSN, String AppURL) throws Exception {
	
	
	int lastrow = TestData.getLastRow("Borrower_Registration");
	String sheetName = "Borrower_Registration";


	for (int row = 2; row <= lastrow; row++) {
		String RegSSN = TestData.getCellData(sheetName, "SSN", row);
		System.out.println("...." + RegSSN);
		if (SSN.equals(RegSSN)) {

			String UserName = TestData.getCellData(sheetName,"UserName",row);
			String Password = TestData.getCellData(sheetName,"Password",row);
	       // System.out.println(Password);
	        String StoreId = TestData.getCellData(sheetName,"StoreID",row);
	        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
	        String StateID = TestData.getCellData(sheetName,"StateID",row);
	      	
	        String Header = StateID+ "_" + ProductID;	      
	        String ProductType= TestData.getCellData(sheetName,"ProductType",row);         
	       String LastName = TestData.getCellData(sheetName,"LastName",row);
	       String FirstName = TestData.getCellData(sheetName,"FirstName",row);
	       String AddressLine = TestData.getCellData(sheetName,"AddressLine",row);
	       String City = TestData.getCellData(sheetName,"City",row);
	       String State = TestData.getCellData(sheetName,"State",row);	      
	       String ZipCode = TestData.getCellData(sheetName,"ZipCode",row);
	       String MonthsAtAddress = TestData.getCellData(sheetName,"MonthsAtAddress",row);	     
	       String Bank_ABARoutingNbr = TestData.getCellData(sheetName,"Bank_ABARoutingNbr",row);
	      // String Bank_ChkgAcctNbr = TestData.getCellData(sheetName,"Bank_ChkgAcctNbr",row);
	       String  Bank_ChkgAcctNbr=SSN.substring(SSN.length() - 6);
	       System.out.println(Bank_ChkgAcctNbr);
	       String SSNorITIN = TestData.getCellData(sheetName,"SSNorITIN",row);
	       String Ctc_PrimaryPhone = TestData.getCellData(sheetName,"Ctc_PrimaryPhone",row);
	       String Ctc_PhoneType = TestData.getCellData(sheetName,"Ctc_PhoneType",row);
	       //String Misc_PhotoIDNbr = TestData.getCellData(sheetName,"Misc_PhotoIDNbr",row);
	       String  Misc_PhotoIDNbr=SSN.substring(SSN.length() - 6);
	       String Misc_IDExpDate = TestData.getCellData(sheetName,"Misc_IDExpDate",row);	   
	       String Misc_PhotoIDType = TestData.getCellData(sheetName,"Misc_PhotoIDType",row);
	       String BorrDOB = TestData.getCellData(sheetName,"Misc_DOB",row);
	       String Income_IncomeType = TestData.getCellData(sheetName,"Income_IncomeType",row);
	       //String Income_Employer = TestData.getCellData(sheetName,"Income_Employer",row);
	       String Income_Employer ="Employer";
	       String Income_WorkPhone = TestData.getCellData(sheetName,"Income_WorkPhone",row);
	       String Income_NetIncomeAmt = TestData.getCellData(sheetName,"Income_NetIncomeAmt",row);
	       String Income_GrossIncome = TestData.getCellData(sheetName,"Income_GrossIncome",row);
	       String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
	       String Income_HireDt = TestData.getCellData(sheetName,"Income_HireDt",row);
	       String Income_DirectDeposit=TestData.getCellData(sheetName,"Income_DirectDeposit",row);	       
	       String PrimaryRef_LastName = TestData.getCellData(sheetName,"PrimaryRef_LastName",row);
	       String PrimaryRef_FirstName = TestData.getCellData(sheetName,"PrimaryRef_FirstName",row);
	       String PrimaryRef_Relationship = TestData.getCellData(sheetName,"PrimaryRef_Relationship",row);
	       String PrimaryRef_PhoneNbr=TestData.getCellData(sheetName,"PrimaryRef_PhoneNbr",row);
	       String Ref_LastName = TestData.getCellData(sheetName,"Ref_LastName",row);
	       String Ref_FirstName = TestData.getCellData(sheetName,"Ref_FirstName",row);
	       String Ref_Relationship = TestData.getCellData(sheetName,"Ref_Relationship",row);
	       String Ref_PhoneNbr=TestData.getCellData(sheetName,"Ref_PhoneNbr",row);	       
	       String Bankruptcy=TestData.getCellData(sheetName,"Bankruptcy",row);	     
			//	test.log(LogStatus.INFO, "Borrower Registration-SSN: " +SSN);
				
				   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
			        String SSN1 = SSN.substring(0, 3);
			        String SSN2 = SSN.substring(3,5);
			        String SSN3 = SSN.substring(5,9);
			        String PP1 = Ctc_PrimaryPhone.substring(0, 3);
			        String PP2 = Ctc_PrimaryPhone.substring(3, 6);
			        String PP3 = Ctc_PrimaryPhone.substring(6, 10);
			        String IncomeP1 = Income_WorkPhone.substring(0, 3);
			        String IncomeP2 = Income_WorkPhone.substring(3, 6);
			        String IncomeP3 = Income_WorkPhone.substring(6, 10);
			        String PrimaryRef_PhoneNbr1 = PrimaryRef_PhoneNbr.substring(0, 3);
			        String PrimaryRef_PhoneNbr2 = PrimaryRef_PhoneNbr.substring(3, 6);
			        String PrimaryRef_PhoneNbr3 = PrimaryRef_PhoneNbr.substring(6, 10);
			        String Ref_PhoneNbr1 = Ref_PhoneNbr.substring(0, 3);
			        String Ref_PhoneNbr2 = Ref_PhoneNbr.substring(3, 6);
			        String Ref_PhoneNbr3 = Ref_PhoneNbr.substring(6, 10);			       
			        System.out.println(Misc_IDExpDate);
			        Date Misc_IDExpDt = df.parse(Misc_IDExpDate);
			        String IDExpDate0 =df.format(Misc_IDExpDt);	
			        System.out.println(IDExpDate0);
			        String IDExpDate[] =IDExpDate0.split("/");
			        String IDExpD1 = IDExpDate[0];
			        String IDExpD2 = IDExpDate[1];
			        String IDExpD3 = IDExpDate[2];
			        String DOB[] =BorrDOB.split("/");
			        String DOB1 = DOB[0];
			        String DOB2 = DOB[1];
			        String DOB3 = DOB[2];	
			        String Monthly_Type= TestData.getCellData(sheetName,"MonthlyType",row);
			        String Monthly_payWeek=TestData.getCellData(sheetName,"MonthlyPayWeek",row);
			        String Monthly_payWeekDay=TestData.getCellData(sheetName,"MonthlyPayWeekDay",row);
			        String Monthly_payday= TestData.getCellData(sheetName,"MonthlyPayDay",row);
			       
			
			/*String SSN1 = SSN.substring(0, 3);
			String SSN2 = SSN.substring(3, 5);
			String SSN3 = SSN.substring(5, 9);
			 String ESSN = SSN1+""+SSN2+""+SSN3; */
			  driver.switchTo().frame("topFrame");	        
		        
		        driver.switchTo().defaultContent();	

				
				driver.switchTo().frame("topFrame");
				
		        driver.findElement(By.xpath("//*[@id='920000']/a")).click();
		        test.log(LogStatus.PASS, "Clicked on Misc Transactions");
		        driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.xpath("//*[@id='921000']/a")).click();
		        test.log(LogStatus.PASS, "Clicked on Misc Receipts");
		        Thread.sleep(3000);
		        
		        driver.findElement(By.xpath("//*[@id='921001']/a")).click();
		        test.log(LogStatus.PASS, "clicked on Bill Pay");
		        driver.switchTo().frame("main");
		        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/div[1]/input")).click();
		        test.log(LogStatus.PASS, "clicked on new customer");
		        driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr[6]/td[2]/input")).sendKeys(LastName);
		        driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr[6]/td[4]/input")).sendKeys(FirstName);
		        test.log(LogStatus.PASS, "firstname entered as" +FirstName);
		        
		        driver.findElement(By.xpath("//*[@id='idDropDownBill']")).sendKeys(SSNorITIN);
		        test.log(LogStatus.PASS, "SSNorITIN entered as" +SSNorITIN);
		        if(SSNorITIN.contains("ITIN"))
		        {
		        driver.findElement(By.xpath("//*[@id='ITIN']/input[1]")).sendKeys(SSN);
		}
		      //*[@id='SSN']/input[1]
		        else
		        {
		        driver.findElement(By.xpath("//*[@id='SSN']/input[1]")).sendKeys(SSN);
		        }
		        driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr[7]/td[10]/input")).sendKeys(Misc_PhotoIDNbr);
		        driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr[11]/td[2]/input")).sendKeys(Misc_PhotoIDNbr);
		        driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr[10]/td[2]/input[1]")).sendKeys(AddressLine);
		        driver.findElement(By.xpath("//*[@id='tm1']")).sendKeys(DOB1);///html/body/form/table[1]/tbody/tr/td/table/tbody/tr[10]/td[2]/input[1]
		        driver.findElement(By.xpath("//*[@id='td1']")).sendKeys(DOB2);
		        driver.findElement(By.xpath("//*[@id='ty1']")).sendKeys(DOB3);
		        driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr[9]/td[2]/select")).sendKeys(City);
		        driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr[11]/td[4]/select")).sendKeys(State);
		        driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr[11]/td[6]/input")).sendKeys(ZipCode);
		        driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr[18]/td[2]/select")).sendKeys("Western Union");
		        driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr[19]/td[2]/input")).sendKeys("1200");
		        driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr[24]/td[2]/input")).sendKeys("1200");
		        driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr[25]/td[2]/select")).sendKeys("Cash");
		        driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/table/tbody/tr[38]/td/input")).sendKeys(Password);
		        driver.findElement(By.xpath("//*[@id='Submit1']")).click();
		       Thread.sleep(2000);
		       //driver.close();
		break;	

		   
			

}
	}
	}

public static void Insight_issue_newcard(String SSN, String AppURL) throws Exception {
	
	
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
			  driver.switchTo().frame("topFrame");	        
		        
		        driver.switchTo().defaultContent();	

				
				driver.switchTo().frame("topFrame");
			/*	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
				driver.findElement(By.cssSelector("li[id='910000']")).click();		
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(3000);
				
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
				String Customer_number = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).getText();
				test.log(LogStatus.PASS, "customer number is:" +Customer_number);
			    driver.switchTo().defaultContent();	
			    driver.switchTo().frame("topFrame");*/
		        driver.findElement(By.xpath("//*[@id='920000']/a")).click();
		        test.log(LogStatus.PASS, "Clicked on Misc Transactions");
		        driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.xpath("//*[@id='921000']/a")).click();
		        test.log(LogStatus.PASS, "Clicked on Misc Receipts");
		        Thread.sleep(3000);
		        
		        driver.findElement(By.xpath("//*[@id='922004']/a")).click();
		        test.log(LogStatus.PASS, "clicked on Insight");
		      
		       driver.findElement(By.xpath("//*[@id='922100']/a")).click();
		        test.log(LogStatus.PASS, "clicked on insight newcard");
		      
		        //driver.switchTo().defaultContent();
		        driver.switchTo().frame("main");
		        Thread.sleep(3000);
		       driver.findElement(By.xpath("//*[@name='issueNewCardnm']")).click();
		       test.log(LogStatus.PASS, "clicked on insight issue newcard");
		       driver.findElement(By.xpath("//*[@id='newCardSection']/tbody/tr[7]/td[3]/input")).click();
		       test.log(LogStatus.PASS, "clicked on ITIN radio button");
		       driver.findElement(By.xpath("//*[@id='itin']")).sendKeys(SSN,Keys.TAB);
		       Thread.sleep(3000);
		       driver.switchTo().alert().accept();
		       test.log(LogStatus.PASS, "test passed");
		       Thread.sleep(2000);
		       driver.close();
		break;	

		   
			

}
	}
	}

	public static void Borrower_EditSSN(String SSN, String AppURL) throws Exception {
		
		
		int lastrow = TestData.getLastRow("Login");
		String sheetName = "Login";


		for (int row = 2; row <= lastrow; row++) {
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			System.out.println("...." + RegSSN);
			if (SSN.equals(RegSSN)) {

				
				
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3, 5);
				String SSN3 = SSN.substring(5, 9);
				  driver.switchTo().frame("topFrame");	        
			        
			        driver.switchTo().defaultContent();	

					
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					driver.findElement(By.cssSelector("li[id='910000']")).click();		
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(3000);
					
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
					String Customer_number = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).getText();
					test.log(LogStatus.PASS, "customer number is:" +Customer_number);
				    driver.switchTo().defaultContent();	
				    driver.switchTo().frame("topFrame");
			        driver.findElement(By.xpath("//*[contains(text(),'Borrower')]")).click();
			        test.log(LogStatus.PASS, "Clicked on Borrower");
			        driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.findElement(By.xpath("//*[@id='988190542']/a")).click();
			        test.log(LogStatus.PASS, "Clicked on Edit SSN");
			        driver.switchTo().frame("main");
			        driver.findElement(By.name("requestBean.cusNbr")).sendKeys(Customer_number);
			        test.log(LogStatus.PASS, "Enter customer number as "+Customer_number);
			        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[2]/tbody/tr/td[2]/input")).click();
			        test.log(LogStatus.PASS, "click on submit Button");
			        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[6]/input")).click();
			        test.log(LogStatus.PASS, "click on GO Button");
			        String ASSN = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td[2]/input")).getAttribute("value");
			        if(ASSN.equals(SSN))
			        {
			        	test.log(LogStatus.FAIL, "test failed");
			        }
			        else
			        {
			        	test.log(LogStatus.PASS, "test passed");
			        }
				
			break;	

	}
		}
		}
public static void EditSSN_SSN_HyperLink(String SSN, String AppURL) throws Exception {
		
		
		int lastrow = TestData.getLastRow("Login");
		String sheetName = "Login";


		for (int row = 2; row <= lastrow; row++) {
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			System.out.println("...." + RegSSN);
			if (SSN.equals(RegSSN)) {

				
				
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3, 5);
				String SSN3 = SSN.substring(5, 9);
				  driver.switchTo().frame("topFrame");	        
			        
			        driver.switchTo().defaultContent();	

					
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					driver.findElement(By.cssSelector("li[id='910000']")).click();		
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(3000);
					
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
					String Customer_number = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).getText();
					test.log(LogStatus.PASS, "customer number is:" +Customer_number);
				    driver.switchTo().defaultContent();	
				    driver.switchTo().frame("topFrame");
			        driver.findElement(By.xpath("//*[contains(text(),'Borrower')]")).click();
			        test.log(LogStatus.PASS, "Clicked on Borrower");
			        driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.findElement(By.xpath("//*[@id='988190542']/a")).click();
			        test.log(LogStatus.PASS, "Clicked on Edit SSN");
			        driver.switchTo().frame("main");
			        driver.findElement(By.name("requestBean.cusNbr")).sendKeys(Customer_number);
			        test.log(LogStatus.PASS, "Enter customer number as "+Customer_number);
			        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[2]/tbody/tr/td[2]/input")).click();
			        test.log(LogStatus.PASS, "clicked on submit Button");
			        Thread.sleep(5000);
			        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[3]/a")).click();
			        test.log(LogStatus.PASS, "clicked on SSN/ITIN link");
			        for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}
					   
			        driver.findElement(By.xpath("//*[@id='eye']")).click();
			        String ssn1 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn1);
			        String ssn2 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn2);
			        String ssn3 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn3);
			        test.log(LogStatus.PASS, ssn1+""+ssn2+""+ssn3);
			        driver.close();
			       String ASSN = ssn1+""+ssn2+""+ssn3;
			       if(ASSN.equalsIgnoreCase(SSN))
			       {
			    	 test.log(LogStatus.PASS, "Test is passed"); 
			       }
			        
				
			break;	

	}
		}
		}
public static void LoanTransactions_ssn_hyperLink(String SSN, String AppURL) throws Exception {
	
	
	int lastrow = TestData.getLastRow("Login");
	String sheetName = "Login";


	for (int row = 2; row <= lastrow; row++) {
		String RegSSN = TestData.getCellData(sheetName, "SSN", row);
		System.out.println("...." + RegSSN);
		if (SSN.equals(RegSSN)) {

			
			
			String SSN1 = SSN.substring(0, 3);
			String SSN2 = SSN.substring(3, 5);
			String SSN3 = SSN.substring(5, 9);
			  driver.switchTo().frame("topFrame");	        
		        
		        driver.switchTo().defaultContent();	

				
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
				driver.findElement(By.cssSelector("li[id='910000']")).click();		
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(3000);
				
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
				String Customer_number = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).getText();
				test.log(LogStatus.PASS, "customer number is:" +Customer_number);
			   driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[4]")).click();
			   test.log(LogStatus.PASS, "clicked on SSN yper link");
			   Thread.sleep(2000);
			   for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
					}
				   
			    String ssn1 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
		        //test.log(LogStatus.PASS, ssn1);
		        String ssn2 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
		        //test.log(LogStatus.PASS, ssn2);
		        String ssn3 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
		        //test.log(LogStatus.PASS, ssn3);
		        String BSSN = ssn1+""+ssn2+""+ssn3;
		        test.log(LogStatus.PASS, ssn1+""+ssn2+""+ssn3);
			    driver.findElement(By.xpath("//*[@id='eye']")).click();
		        String ssn11 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
		        //test.log(LogStatus.PASS, ssn1);
		        String ssn12 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
		        //test.log(LogStatus.PASS, ssn2);
		        String ssn13 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
		        //test.log(LogStatus.PASS, ssn3);
		        test.log(LogStatus.PASS, ssn11+""+ssn12+""+ssn13);
		        driver.close();
		       String ASSN = ssn11+""+ssn12+""+ssn13;
		       if(ASSN.equals(BSSN))
		       {
		    	 test.log(LogStatus.PASS, "Test failed"); 
		       }
		       else
		       {
		    	   test.log(LogStatus.PASS, "Test passed");
		       }
			
		break;	

}
	}
	}
public static void admin_EditSSN(String SSN, String AppURL) throws Exception {
		
		
		int lastrow = TestData.getLastRow("Login");
		String sheetName = "Login";


		for (int row = 2; row <= lastrow; row++) {
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			 String StoreId = TestData.getCellData(sheetName,"StoreID",row);
			System.out.println("...." + RegSSN);
			if (SSN.equals(RegSSN)) {

				
				
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3, 5);
				String SSN3 = SSN.substring(5, 9);
				  driver.switchTo().frame("topFrame");	        
			        
			        driver.switchTo().defaultContent();	

					
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					driver.findElement(By.cssSelector("li[id='910000']")).click();		
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(3000);
					
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
					String Customer_number = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).getText();
					test.log(LogStatus.PASS, "customer number is:" +Customer_number);
				    driver.switchTo().defaultContent();
				    driver.close();
				    QCCSRLoginLogout.adminLogin(SSN, AppURL);
				
			

			
			driver.switchTo().frame("topFrame");
			driver.findElement(By.partialLinkText("Transactions")).click();   
			test.log(LogStatus.PASS, "Clicked on Transactions");
				
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			Thread.sleep(2500);
			driver.findElement(By.linkText("Borrower")).click();
			test.log(LogStatus.PASS, "Clicked on Borrower link");
			driver.switchTo().defaultContent();

			driver.switchTo().frame("mainFrame");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='502120']/a")).click();
			test.log(LogStatus.PASS, "Clicked on Edit SSN");
			Thread.sleep(2000);
			//driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@name='requestBean.locationNbr']")).sendKeys(StoreId);
			test.log(LogStatus.PASS, "Entered Store Number:" +StoreId);
			driver.findElement(By.xpath("//*[@name='requestBean.cusNbr']")).sendKeys(Customer_number);
			test.log(LogStatus.PASS, "Entered Store Customer_Number as:" +Customer_number);
			driver.findElement(By.xpath("//*[@value='Submit']")).click();
			test.log(LogStatus.PASS, "Clicked on submit Button");
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[6]/input")).click();
			test.log(LogStatus.PASS, "Clicked on Go Button");
			String ASSN = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td[2]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Actual ssn is:"+ ASSN);
			if(ASSN.equals(SSN))
			{
				test.log(LogStatus.FAIL, "test failed");
			}
			else
			{
				test.log(LogStatus.PASS, "test passed");
			}
			
		break;	

}
	}
	}

public static void admin_BorrowerSerach(String SSN, String AppURL) throws Exception {
	
	
	int lastrow = TestData.getLastRow("Borrower_Registration");
	String sheetName = "Borrower_Registration";


	for (int row = 2; row <= lastrow; row++) {
		String RegSSN = TestData.getCellData(sheetName, "SSN", row);
		 String StoreId = TestData.getCellData(sheetName,"StoreID",row);
		System.out.println("...." + RegSSN);
		if (SSN.equals(RegSSN)) {

			
			
			String SSN1 = SSN.substring(0, 3);
			String SSN2 = SSN.substring(3, 5);
			String SSN3 = SSN.substring(5, 9);
			  driver.switchTo().frame("topFrame");	        
		        
		        driver.switchTo().defaultContent();	

				
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
				driver.findElement(By.cssSelector("li[id='910000']")).click();		
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(3000);
				
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
				String Customer_number = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).getText();
				test.log(LogStatus.PASS, "customer number is:" +Customer_number);
			    driver.switchTo().defaultContent();
			    driver.close();
			    QCCSRLoginLogout.adminLogin(SSN, AppURL);
			
		

		
		driver.switchTo().frame("topFrame");
		driver.findElement(By.partialLinkText("Transactions")).click();   
		test.log(LogStatus.PASS, "Clicked on Transactions");
			
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		Thread.sleep(2500);
		driver.findElement(By.linkText("Borrower")).click();
		test.log(LogStatus.PASS, "Clicked on Borrower link");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("mainFrame");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='95519009']/a")).click();
		test.log(LogStatus.PASS, "Clicked on Borrower Search");
		Thread.sleep(2000);
		//driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		Thread.sleep(2000);
		/*driver.findElement(By.xpath("//*[@name='requestBean.locationNbr']")).sendKeys(StoreId);
		test.log(LogStatus.PASS, "Entered Store Number:" +StoreId);*/
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[5]/td[2]/input")).sendKeys(Customer_number);
		test.log(LogStatus.PASS, "Entered Store Customer_Number as:" +Customer_number);
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[2]")).click();
		test.log(LogStatus.PASS, "Clicked on submit Button");
		driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[3]/a")).click();
		test.log(LogStatus.PASS, "Clicked on ssn hyper link");
		Thread.sleep(2000);
	    String ssn1 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
        //test.log(LogStatus.PASS, ssn1);
        String ssn2 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
        //test.log(LogStatus.PASS, ssn2);
        String ssn3 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
        //test.log(LogStatus.PASS, ssn3);
        String BSSN = ssn1+""+ssn2+""+ssn3;
        test.log(LogStatus.PASS, ssn1+""+ssn2+""+ssn3);
	    driver.findElement(By.xpath("//*[@id='eye']")).click();
        String ssn11 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
        //test.log(LogStatus.PASS, ssn1);
        String ssn12 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
        //test.log(LogStatus.PASS, ssn2);
        String ssn13 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
        //test.log(LogStatus.PASS, ssn3);
        test.log(LogStatus.PASS, ssn11+""+ssn12+""+ssn13);
       String ASSN = ssn11+""+ssn12+""+ssn13;
       if(ASSN.equals(BSSN))
       {
    	 test.log(LogStatus.PASS, "Test failed"); 
       }
       else
       {
    	   test.log(LogStatus.PASS, "Test passed");
       }
		
	break;	

}
}
}

public static void Edit_SSN_HyperLink(String SSN, String AppURL) throws Exception {
	
	
	int lastrow = TestData.getLastRow("Login");
	String sheetName = "Login";


	for (int row = 2; row <= lastrow; row++) {
		String RegSSN = TestData.getCellData(sheetName, "SSN", row);
		System.out.println("...." + RegSSN);
		if (SSN.equals(RegSSN)) {

			
			
			String SSN1 = SSN.substring(0, 3);
			String SSN2 = SSN.substring(3, 5);
			String SSN3 = SSN.substring(5, 9);
			 String ESSN = SSN1+""+SSN2+""+SSN3; 
			  driver.switchTo().frame("topFrame");	        
		        
		        driver.switchTo().defaultContent();	

				
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
				driver.findElement(By.cssSelector("li[id='910000']")).click();		
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(3000);
				
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
				String Customer_number = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).getText();
				test.log(LogStatus.PASS, "customer number is:" +Customer_number);
			    driver.switchTo().defaultContent();	
			    driver.switchTo().frame("topFrame");
		        driver.findElement(By.xpath("//*[contains(text(),'Borrower')]")).click();
		        test.log(LogStatus.PASS, "Clicked on Borrower");
		        driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.xpath("//*[@id='902000']/a")).click();
		        test.log(LogStatus.PASS, "Clicked on Edit");
		        driver.switchTo().frame("main");
		        driver.findElement(By.name("requestBean.cusNbr")).sendKeys(Customer_number);
		        test.log(LogStatus.PASS, "Enter customer number as "+Customer_number);
		        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[2]")).click();
		        test.log(LogStatus.PASS, "click on submit Button");
		        String mainwindow=driver.getWindowHandle();
		       driver.findElement(By.xpath("//*[@id='pic1']")).click();
		       test.log(LogStatus.PASS, "Clicked on SSN/ITLN Hyper Link");
		      
		       String ssn1 = null;
		       String ssn2 = null;
		       String ssn3 = null;
		       
				    
						  
						    for(String winHandle : driver.getWindowHandles()){
								if(!mainwindow.equalsIgnoreCase(winHandle))
								{
							    driver.switchTo().window(winHandle);
							       
							       
							       Thread.sleep(3000);
							       driver.findElement(By.xpath("//*[@id='eye']")).click();
							       ssn1 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
							        //test.log(LogStatus.PASS, ssn1);
							       ssn2 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
							        //test.log(LogStatus.PASS, ssn2);
							      ssn3 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
							        //test.log(LogStatus.PASS, ssn3);
							        test.log(LogStatus.PASS, ssn1+""+ssn2+""+ssn3);
						        driver.close();
								break;
								}
						    }
								driver.switchTo().window(mainwindow);
							
		       
		       String ASSN = ssn1+""+ssn2+""+ssn3;
		       if(ASSN.equalsIgnoreCase(ESSN))
		       {
		    	 test.log(LogStatus.PASS, "Test is passed"); 
		       }
		       Thread.sleep(1000);
		       driver.quit();
		        Thread.sleep(500);
		     
		       
		break;	

}
	}
	}
public static void Courtesycalls_SSN_Hyperlink(String SSN, String AppURL) throws Exception {
	
	
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
		        driver.findElement(By.xpath("//*[contains(text(),'Borrower')]")).click();
		        test.log(LogStatus.PASS, "Clicked on Borrower");
		
		        driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
		        driver.findElement(By.xpath("//*[@id='940010']/a")).click();
		        test.log(LogStatus.PASS, "Clicked on Courtesy calls");
		        driver.switchTo().defaultContent();	
			    driver.switchTo().frame("mainFrame");
			    driver.switchTo().frame("main");
			    driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[1]/td[3]/select")).sendKeys("ALL");
			    test.log(LogStatus.PASS, "product type is selected as ALL");
			    Thread.sleep(3000);
			    driver.findElement(By.xpath("//*[@id='Search']/form/table/tbody/tr/td/table/tbody/tr[6]/td/table/tbody/tr/td/input[3]")).click();
			    test.log(LogStatus.PASS, "Clicked on search button");
			    Thread.sleep(10000);
			    driver.findElement(By.xpath("//*[@id='SearchResults']/form/table/tbody/tr/td/table[3]/tbody/tr[3]/td[15]/input")).click();
			    test.log(LogStatus.PASS, "Clicked on Go Button");
			    Thread.sleep(3000);
			    String mainwindow=driver.getWindowHandle();
			    driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[6]/a")).click();
			    test.log(LogStatus.PASS, "clicked on SSN hyper link");
			    Thread.sleep(2000);
			   
			    String ssn1 = null;
			       String ssn2 = null;
			       String ssn3 = null;
			       
					    
							  
							    for(String winHandle : driver.getWindowHandles()){
									if(!mainwindow.equalsIgnoreCase(winHandle))
									{
								    driver.switchTo().window(winHandle);
								       
								       
								       Thread.sleep(3000);
								       driver.findElement(By.xpath("//*[@id='eye']")).click();
								       ssn1 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
								        //test.log(LogStatus.PASS, ssn1);
								       ssn2 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
								        //test.log(LogStatus.PASS, ssn2);
								      ssn3 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
								        //test.log(LogStatus.PASS, ssn3);
								        test.log(LogStatus.PASS, ssn1+""+ssn2+""+ssn3);
							        driver.close();
									break;
									}
							    }
									driver.switchTo().window(mainwindow);   
			    
			    
			    
			    
			    
			    
			   /* String ssn1 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
		        //test.log(LogStatus.PASS, ssn1);
		        String ssn2 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
		        //test.log(LogStatus.PASS, ssn2);
		        String ssn3 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
		        //test.log(LogStatus.PASS, ssn3);
		        String BSSN = ssn1+""+ssn2+""+ssn3;
		        test.log(LogStatus.PASS, ssn1+""+ssn2+""+ssn3);
			    driver.findElement(By.xpath("//*[@id='eye']")).click();
		        String ssn11 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
		        //test.log(LogStatus.PASS, ssn1);
		        String ssn12 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
		        //test.log(LogStatus.PASS, ssn2);
		        String ssn13 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
		        //test.log(LogStatus.PASS, ssn3);
		        test.log(LogStatus.PASS, ssn11+""+ssn12+""+ssn13);
		        driver.close();
		       String ASSN = ssn11+""+ssn12+""+ssn13;*/
									String BSSN = ssn1+""+ssn2+""+ssn3;
		       if(SSN.equals(BSSN))
		       {
		    	 test.log(LogStatus.PASS, "Test failed"); 
		       }
		       else
		       {
		    	   test.log(LogStatus.PASS, "Test passed");
		       }
		break;	

}
	}
	}



	
	
	





public static void Collection_SSN_Hyperlink(String SSN, String AppURL) throws Exception {
	
	
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
		        driver.findElement(By.xpath("//*[contains(text(),'Borrower')]")).click();
		        test.log(LogStatus.PASS, "Clicked on Borrower");
		
		        driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
		        driver.findElement(By.xpath("//*[@id='903000']/a")).click();
		        test.log(LogStatus.PASS, "Clicked on Collections");
		        driver.switchTo().defaultContent();	
			    driver.switchTo().frame("mainFrame");
			    driver.switchTo().frame("main");
			    driver.findElement(By.xpath("//*[@id='prodType']/td[3]/select")).sendKeys("ALL");
			    test.log(LogStatus.PASS, "product type is selected as ALL");
			    Thread.sleep(3000);
			    driver.findElement(By.xpath("//*[@id='Search']/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[8]/td/table/tbody/tr/td/input[3]")).click();
			    test.log(LogStatus.PASS, "Clicked on search button");
			    Thread.sleep(20000);
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@value='Go'])[3]")));
			    driver.findElement(By.xpath("(//*[@value='Go'])[3]")).click();
			    test.log(LogStatus.PASS, "Clicked on Go Button");
			    Thread.sleep(3000);
			    driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[6]/a")).click();
			    test.log(LogStatus.PASS, "clicked on SSN hyper link");
			    for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
					}
				  Thread.sleep(3000); 
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


public static void manualdefault(String SSN,String AppURL) throws InterruptedException{
	
	
	
	int lastrow=TestData.getLastRow("ManualDefault");
	String sheetName="ManualDefault";

		for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{
					
			        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			        encryption_store_no = TestData.getCellData(sheetName, "encryption_store_no", row);
			       
					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
			       Thread.sleep(4000);
					//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
					test.log(LogStatus.INFO, "Manual Default process is initiated");
					driver.switchTo().frame("bottom");
					String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
					String store_date[]=Str_date.split(":");
					String business_date=store_date[1].trim();
					test.log(LogStatus.PASS, "Business date is :"+business_date);
					driver.switchTo().defaultContent();	
					
			       
					driver.switchTo().frame("topFrame");
				
			        driver.findElement(By.cssSelector("li[id='910000']")).click();	
						
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(1000);
				
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
					Thread.sleep(2000);
			
					
                //============= Taking Due Date From History ====================
					
				
					    driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					    
					    
				
					    driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				
						
								    
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
							 Thread.sleep(3000); //*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]
							 NextDueDate = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();
							                                            //*[@id="revolvingCreditHistTable"]/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]
						     test.log(LogStatus.PASS, "Next due date is "+NextDueDate);		
						     Thread.sleep(1000); 
						                                              //*[@id="revolvingCreditHistTable"]/tbody/tr/td[4]/table/tbody/tr[4]/td/span[2]
						     loan_number=driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[4]/td/span[2]")).getText();
						     test.log(LogStatus.PASS, "Loan Number  is "+loan_number);	
						     Thread.sleep(1000);
						                                                   //*[@id="revolvingCreditHistTable"]/tbody/tr/td[1]/table/tbody/tr[3]/td/span[3]
						    customer_number=driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[1]/table/tbody/tr[3]/td/span[3]")).getText();
					        test.log(LogStatus.PASS, "Customer Nbr is :" +customer_number);
					                                                    
					      //*[@id="transactionHistoryTable"]/tbody/tr/td[1]/table/tbody/tr[3]/td/span[2]
//==============================================================================
							
                          //Manual Default Start
								Thread.sleep(1000);
								driver.switchTo().defaultContent();
								driver.switchTo().frame("mainFrame");
								driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
								
								driver.findElement(By.xpath("//*[@id='9881908122']/a")).click();
								test.log(LogStatus.PASS, "Clicked on Manual Default tab");
								
								driver.switchTo().frame("main");
								
								driver.findElement(By.name("requestBean.cusNbr")).sendKeys(customer_number);
								test.log(LogStatus.PASS, "Customer Nbr Entered is :" +customer_number);
								
								driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_number);
								test.log(LogStatus.PASS, "Loan Nbr Entered is :" +loan_number);
								
								driver.findElement(By.name("submit")).click();
								test.log(LogStatus.PASS, "Clicked on Submit");
								Thread.sleep(8000);
								encryption_transaction_nbr = driver.findElement(By.name("requestBean.origTranNbr")).getAttribute("value");				
								test.log(LogStatus.PASS, "Trans Number is" + encryption_transaction_nbr);
								
				//Admin Login For Getting Encryption Key
								
								// driver1 = new InternetExplorerDriver();
								CSRBorrower.getEncryption(driver,SSN, AppURL);
								 Thread.sleep(5000);
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								 Thread.sleep(5000);
								 driver.findElement(By.name("requestBean.encryptionKey")).sendKeys(Eankey);
								 test.log(LogStatus.PASS, "Encryption number enter is :" +Eankey);
								 Thread.sleep(5000);
								 driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[4]/tbody/tr[4]/td/input")).click();
								 test.log(LogStatus.PASS, "Clicked on Finish Manual Default");
								 Thread.sleep(5000);
								 driver.findElement(By.name("Ok")).click();
								 test.log(LogStatus.PASS, "Clicked on Transaction Completed Successfully Ok");
								 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Manual Default Completed Successfully");
								 driver.close();
								
			
					
				break;
				
			 
		}
	}

}

public static void Loan_number(String SSN,String AppURL) throws InterruptedException{
	
	
	
	int lastrow=TestData.getLastRow("Borrower_Registration");
	String sheetName="Borrower_Registration";

		for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{
					
			              String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
			       Thread.sleep(4000);
					
			       
					driver.switchTo().frame("topFrame");
				
			        driver.findElement(By.cssSelector("li[id='910000']")).click();	
						
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(1000);
				
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
					Thread.sleep(2000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button under search results");
					Loan_number = driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[5]/td[2]")).getText();
					
				break;
		}
	}

}


public static void getEncryption(WebDriver driver,String SSN,String AppURL) throws InterruptedException
{

		int lastrow=TestData.getLastRow("Login");
		String sheetName="Login";

		String AdminUserName = "automation";
		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
			//String AdminUserName = TestData.getCellData(sheetName,"AdminUserName",row);
			String AdminPassword = TestData.getCellData(sheetName,"AdminPassword",row);
			String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);
			String PIN = TestData.getCellData(sheetName,"PIN",row);
			String Trancd = TestData.getCellData(sheetName,"Tran_cd",row);

			test.log(LogStatus.INFO,"Admin Application is launched");

			driver = new InternetExplorerDriver();
			//wait = new WebDriverWait(driver, 40000);

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		
			driver.get(prop.getProperty("ADMIN_CSR_URL"));
			test.log(LogStatus.INFO,"Opened the Admin URL"+ prop.getProperty("ADMIN_CSR_URL"));
			test.log(LogStatus.INFO,"Reading encryption details from Admin has initiated"+ AdminURL);




         DateFormat df=new SimpleDateFormat("MM/dd/yyyy"); 

          driver.findElement(By.name("loginRequestBean.userId")).sendKeys(AdminUserName);

            test.log(LogStatus.PASS, "Username is entered: "+AdminUserName); 

            driver.findElement(By.name("loginRequestBean.password")).sendKeys(AdminPassword);

           test.log(LogStatus.PASS, "Password is entered: "+AdminPassword); 

              //Click Login Button

            driver.findElement(By.name("login")).click();

               test.log(LogStatus.PASS, "Clicked on Submit button");

                       Thread.sleep(3000);
          /* driver.get(prop.getProperty("CSR_URL"));
            Thread.sleep(3000);

*/
          driver.switchTo().defaultContent();

            driver.switchTo().frame("topFrame");

             driver.findElement(By.xpath("//*[contains(text(),'Employee')]")).click(); 

             test.log(LogStatus.PASS, "Clicked on Employee tab");

                  driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

               driver.switchTo().defaultContent();

          driver.switchTo().frame("mainFrame");

          driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
          Thread.sleep(3000);
           driver.findElement(By.linkText("Encryption Key")).click();

          test.log(LogStatus.PASS, "Clicked on Encryption Key link");

          driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

            driver.switchTo().defaultContent();

           driver.switchTo().frame("mainFrame");
           Thread.sleep(3000);
          driver.findElement(By.linkText("Encryption")).click();

         test.log(LogStatus.PASS, "Clicked on Encryption");

            Thread.sleep(5000);


           driver.switchTo().defaultContent();

          driver.switchTo().frame("mainFrame");

            driver.switchTo().frame("main");
   
          driver.findElement(By.name("requestBean.locationNbr")).sendKeys(encryption_store_no);

         test.log(LogStatus.PASS, "Store number Entered"+encryption_store_no); 


        driver.findElement(By.name("requestBean.tranNbr")).sendKeys(encryption_transaction_nbr);

          test.log(LogStatus.PASS, "Tran number Entered"+encryption_transaction_nbr); 


         driver.findElement(By.name("trancd")).sendKeys(Trancd);

           test.log(LogStatus.PASS, "Transaction selected as: " +Trancd);


          driver.findElement(By.name("GetKey")).click();

           test.log(LogStatus.PASS, "GetKey clicked");


          Eankey = driver.findElement(By.name("EanKey")).getAttribute("value");

          test.log(LogStatus.PASS,"GetKey captured as:" +Eankey);
          driver.close();

break;
}
		}	


}
}





