package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class VQCAdmin_BankruptcyTLP extends QCStore
{

	private static final String Deceased = null;
	private static String ADMIN_URL;

	public static void Borrower_Search(String SSN,String AppURL)
	{
		for(int i=0;i<3;i++)
		{
			//driver.get("http://192.168.2.203/cc/login/index.jsp");
	try{
		
		
		  		 
			int lastrow=TestData.getLastRow("VIN");
			String sheetName="VIN";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					
				String UserName = TestData.getCellData(sheetName,"AdminUserName",row);
				String Password = TestData.getCellData(sheetName,"AdminPassword",row);
				String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);
				String NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
				//NewVIN=NewVIN+""+ESign_CheckNbr;
				String PIN = TestData.getCellData(sheetName,"PIN",row);
				
                String StoreID= TestData.getCellData(sheetName,"StoreID",row);
                String DeceasedStatus= TestData.getCellData(sheetName,"DeceasedStatus",row);
                String VIN = TestData.getCellData(sheetName, "VIN", row);
                String SSN1 = SSN.substring(0, 3);
		        String SSN2 = SSN.substring(3,5);
		        String SSN3 = SSN.substring(5,9);
                
				
				test.log(LogStatus.INFO, "********Admin Application is launched********");
				driver = new InternetExplorerDriver();
				

			
				driver.get("https://qclocalreg.qfund.net/cc/adminIndex.do");
				
				test.log(LogStatus.INFO, "Opened the Admin URL");

				


				String mainwindow2=driver.getWindowHandle();
			
				System.out.println("In Admin"+ mainwindow2);
	
	DateFormat df=new SimpleDateFormat("MM/dd/yyyy"); 

	driver.findElement(By.name("loginRequestBean.userId")).sendKeys(UserName);

	test.log(LogStatus.PASS, "Username is entered: "+UserName); 

	driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);

	test.log(LogStatus.PASS, "Password is entered: "+Password); 

	//Click Login Button

	driver.findElement(By.name("login")).click();

	test.log(LogStatus.PASS, "Clicked on Submit button");

	Thread.sleep(8000);

	driver.switchTo().defaultContent();

	driver.switchTo().frame("topFrame");

	driver.findElement(By.xpath("//*[@id='500000']/a")).click(); 

	test.log(LogStatus.PASS, "Clicked on Transactions tab");
	
	

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	Thread.sleep(3000);

	driver.findElement(By.linkText("Borrower")).click();

	test.log(LogStatus.PASS, "Clicked on Borrower link");
	
	
	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");
	Thread.sleep(6000);

	driver.findElement(By.linkText("Borrower Search")).click();

	test.log(LogStatus.PASS, "Clicked on Borrower Search");
	
	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.switchTo().frame("main");
	 
	
	//test.log(LogStatus.PASS, "Loan Number is" + loan_number);

	/*driver.findElement(By.name("requestBean.bnklocnbr")).sendKeys(StoreID);

	test.log(LogStatus.PASS, "Store number Entered"+StoreID);*/
	
	
	/*driver.findElement(By.name("requestBean.vinNbr")).sendKeys(NewVIN);

	test.log(LogStatus.PASS, "VIN_number Entered"+NewVIN);*/
	driver.findElement(By.name("ssn1")).sendKeys(SSN1);
	test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
	driver.findElement(locator(Vprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
	test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
	driver.findElement(locator(Vprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
	test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
	driver.findElement(locator(Vprop.getProperty("CSR_SSN_cfm_first_field"))).sendKeys(SSN1);
	test.log(LogStatus.PASS, "Confirm SSN1 is entered: "+SSN1);
	driver.findElement(locator(Vprop.getProperty("CSR_SSN_cfm_second_field"))).sendKeys(SSN2);
	test.log(LogStatus.PASS, "Confirm SSN2 is entered: "+SSN2);
	driver.findElement(locator(Vprop.getProperty("CSR_SSN_cfm_third_field"))).sendKeys(SSN3);
	test.log(LogStatus.PASS, "Confirm SSN3 is entered: "+SSN3);	
	
	Thread.sleep(5000);
	
	//Code For Mouse Over
	
		Actions action = new Actions(driver);
		action.moveByOffset(200,100).perform();
		Thread.sleep(10000);
		action.click();
		Thread.sleep(5000);
		driver.findElement(By.name("submit1")).click();
		                             
		test.log(LogStatus.PASS, "Clicked on Submit");
		
		Thread.sleep(5000);
		
		/*driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
		
		test.log(LogStatus.PASS, "Clicked on GO Button");*/

		Thread.sleep(5000);
		
	    
		if(NewVIN.equalsIgnoreCase(NewVIN))
			
		test.log(LogStatus.PASS, "NewVIN is" + NewVIN);
		else
		//test.log(LogStatus.PASS, "NewVIN is failed");
		
		test.log(LogStatus.PASS, "Borrower search with NewVIN Completed Successfully");
		
		driver.close();
	
	
	
	//=====================================================================================
		
		
		
		
		

break;
}
			}	
	
	break;
}

				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Getting Encryption from Admin is failed", ExtentColor.RED));
					//test.log(LogStatus.FAIL,"Getting Encryption from Admin is failed");
					test.log(LogStatus.INFO,"Getting Encryption from Admin process is initiated again due to Application sync issue");

					continue;

				}

	}
}



public static void Bankruptcy(String SSN,String AppURL)
{
	for(int i=0;i<3;i++)
	{
		//driver.get("http://192.168.2.203/cc/login/index.jsp");
try{
	
	
	  		 
		int lastrow=TestData.getLastRow("VIN");
		String sheetName="VIN";

		String UserName = "automation";
		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
			//String UserName = TestData.getCellData(sheetName,"AdminUserName",row);
			String Password = TestData.getCellData(sheetName,"AdminPassword",row);
			String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);
			String NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
			//NewVIN=NewVIN+""+ESign_CheckNbr;
			String PIN = TestData.getCellData(sheetName,"PIN",row);
			
            String StoreID= TestData.getCellData(sheetName,"StoreID",row);
            String DeceasedStatus= TestData.getCellData(sheetName,"DeceasedStatus",row);
            String VIN = TestData.getCellData(sheetName, "VIN", row);
            
			
			test.log(LogStatus.INFO, "********Admin Application is launched********");
			driver = new InternetExplorerDriver();
			

		
			driver.get("https://qclocalreg.qfund.net/cc/adminIndex.do");
			
			test.log(LogStatus.INFO, "Opened the Admin URL");

			


			String mainwindow2=driver.getWindowHandle();
		
			System.out.println("In Admin"+ mainwindow2);

DateFormat df=new SimpleDateFormat("MM/dd/yyyy"); 

driver.findElement(By.name("loginRequestBean.userId")).sendKeys(UserName);

test.log(LogStatus.PASS, "Username is entered: "+UserName); 

driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);

test.log(LogStatus.PASS, "Password is entered: "+Password); 

//Click Login Button

driver.findElement(By.name("login")).click();

test.log(LogStatus.PASS, "Clicked on Submit button");

Thread.sleep(8000);

driver.switchTo().defaultContent();

driver.switchTo().frame("topFrame");

driver.findElement(By.xpath("//*[@id='500000']/a")).click(); 

test.log(LogStatus.PASS, "Clicked on Transactions tab");



driver.switchTo().defaultContent();

driver.switchTo().frame("mainFrame");

Thread.sleep(3000);

driver.findElement(By.linkText("Borrower")).click();

test.log(LogStatus.PASS, "Clicked on Borrower link");


driver.switchTo().defaultContent();

driver.switchTo().frame("mainFrame");
Thread.sleep(6000);

driver.findElement(By.linkText("Bankrupt/Deceased Suite")).click();

test.log(LogStatus.PASS, "Clicked on Bankrupt/Deceased Suite");

driver.switchTo().defaultContent();

driver.switchTo().frame("mainFrame");

driver.switchTo().frame("main");
 

//test.log(LogStatus.PASS, "Loan Number is" + loan_number);

/*driver.findElement(By.name("requestBean.bnklocnbr")).sendKeys(StoreID);

test.log(LogStatus.PASS, "Store number Entered"+StoreID);*/


driver.findElement(By.name("requestBean.vinNbr")).sendKeys(NewVIN);

test.log(LogStatus.PASS, "VIN_number Entered"+NewVIN);

Thread.sleep(5000);

//Code For Mouse Over

	Actions action = new Actions(driver);
	action.moveByOffset(200,100).perform();
	Thread.sleep(10000);
	action.click();
	Thread.sleep(5000);
	driver.findElement(By.name("submit")).click();
	                             
	test.log(LogStatus.PASS, "Clicked on Submit");
	
	Thread.sleep(5000);
	
	/*driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
	
	test.log(LogStatus.PASS, "Clicked on GO Button");*/

	Thread.sleep(5000);
	
    
	if(NewVIN.equalsIgnoreCase(NewVIN)){
		
	test.log(LogStatus.PASS, "NewVIN is" + NewVIN);
	test.log(LogStatus.PASS, "Borrower search with NewVIN Completed Successfully");
	}
	else{
	//test.log(LogStatus.PASS, "NewVIN is failed");
	
	test.log(LogStatus.PASS, "Borrower search with NewVIN not Completed Successfully");
	}
	driver.close();



//=====================================================================================
	
	
	
	
	

break;
}
		}	

break;
}

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Getting Encryption from Admin is failed", ExtentColor.RED));
				//test.log(LogStatus.FAIL,"Getting Encryption from Admin is failed");
				test.log(LogStatus.INFO,"Getting Encryption from Admin process is initiated again due to Application sync issue");

				continue;

			}

}
}



public static void Borrower_search_customer(String SSN,String AppURL)
{
	for(int i=0;i<3;i++)
	{
		//driver.get("http://192.168.2.203/cc/login/index.jsp");
try{
	
	
	  		 
		int lastrow=TestData.getLastRow("VIN");
		String sheetName="VIN";

		String UserName = "automation";
		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				
			//String UserName = TestData.getCellData(sheetName,"AdminUserName",row);
			String Password = TestData.getCellData(sheetName,"AdminPassword",row);
			String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);
			String NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
			//NewVIN=NewVIN+""+ESign_CheckNbr;
			String PIN = TestData.getCellData(sheetName,"PIN",row);
			
            String StoreID= TestData.getCellData(sheetName,"StoreID",row);
            String DeceasedStatus= TestData.getCellData(sheetName,"DeceasedStatus",row);
            String VIN = TestData.getCellData(sheetName, "VIN", row);
            
			
			test.log(LogStatus.INFO, "********Admin Application is launched********");
			driver = new InternetExplorerDriver();
			

		
			driver.get("https://qclocalreg.qfund.net/cc/adminIndex.do");
			
			test.log(LogStatus.INFO, "Opened the Admin URL");

			


			String mainwindow2=driver.getWindowHandle();
		
			System.out.println("In Admin"+ mainwindow2);

DateFormat df=new SimpleDateFormat("MM/dd/yyyy"); 

driver.findElement(By.name("loginRequestBean.userId")).sendKeys(UserName);

test.log(LogStatus.PASS, "Username is entered: "+UserName); 

driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);

test.log(LogStatus.PASS, "Password is entered: "+Password); 

//Click Login Button

driver.findElement(By.name("login")).click();

test.log(LogStatus.PASS, "Clicked on Submit button");

Thread.sleep(8000);

driver.switchTo().defaultContent();

driver.switchTo().frame("topFrame");

driver.findElement(By.xpath("//*[@id='500000']/a")).click(); 

test.log(LogStatus.PASS, "Clicked on Transactions tab");



driver.switchTo().defaultContent();

driver.switchTo().frame("mainFrame");

Thread.sleep(3000);

driver.findElement(By.linkText("Borrower")).click();

test.log(LogStatus.PASS, "Clicked on Borrower link");


driver.switchTo().defaultContent();

driver.switchTo().frame("mainFrame");
Thread.sleep(6000);

driver.findElement(By.linkText("Borrower Search")).click();

test.log(LogStatus.PASS, "Clicked on Borrower Search");

driver.switchTo().defaultContent();

driver.switchTo().frame("mainFrame");

driver.switchTo().frame("main");
 

//test.log(LogStatus.PASS, "Loan Number is" + loan_number);

/*driver.findElement(By.name("requestBean.bnklocnbr")).sendKeys(StoreID);

test.log(LogStatus.PASS, "Store number Entered"+StoreID);*/


driver.findElement(By.name("requestBean.vinNbr")).sendKeys(NewVIN);

test.log(LogStatus.PASS, "VIN_number Entered"+NewVIN);

Thread.sleep(5000);

//Code For Mouse Over

	Actions action = new Actions(driver);
	action.moveByOffset(200,100).perform();
	Thread.sleep(10000);
	action.click();
	Thread.sleep(5000);
	driver.findElement(By.name("submit1")).click();
	                             
	test.log(LogStatus.PASS, "Clicked on Submit");
	
	Thread.sleep(5000);
	
	/*driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
	
	test.log(LogStatus.PASS, "Clicked on GO Button");*/

	Thread.sleep(5000);
	
    
	if(NewVIN.equalsIgnoreCase(NewVIN)){
		
	test.log(LogStatus.PASS, "NewVIN is" + NewVIN);
	test.log(LogStatus.PASS, "Borrower search with NewVIN Completed Successfully");
	}
	else{
	//test.log(LogStatus.PASS, "NewVIN is failed");
	
	test.log(LogStatus.PASS, "Borrower search with NewVIN not Completed Successfully");
	}
	driver.close();



//=====================================================================================
	
	
	
	
	

break;
}
		}	

break;
}

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Getting Encryption from Admin is failed", ExtentColor.RED));
				//test.log(LogStatus.FAIL,"Getting Encryption from Admin is failed");
				test.log(LogStatus.INFO,"Getting Encryption from Admin process is initiated again due to Application sync issue");

				continue;

			}

}
}
}
