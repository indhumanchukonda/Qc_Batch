package tests;




import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class QCCSRLoginLogout extends QCStore
{
	//public static String URL;
	public static void login(String SSN,String AppURL) throws InterruptedException, MalformedURLException
	{int lastrow=TestData.getLastRow("Login");
				String sheetName="Login";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					//String csr_url = TestData.getCellData(sheetName,"AppURL",row);

					String username = TestData.getCellData(sheetName,"UserName",row);
							//TestData.getCellData(sheetName,"UserName",row);
					String Pwd =TestData.getCellData(sheetName,"Pwd",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);
					//String store_id = vstoreid;
					//TestData.getCellData(sheetName,"StoreID",row);
					


					if(SSN.equals(RegSSN))
					{	
				
						Thread.sleep(4000);
						
						test.log(LogStatus.INFO, "<FONT color=green style=Calibri > Opened the CSR URL " +AppURL);



						test.log(LogStatus.INFO, "CSR Application is launched " );
						
						if(prop.getProperty("login_method").equalsIgnoreCase("local"))
						{
							driver = new InternetExplorerDriver();
							//=========== For Browser info in report ===============
							Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();

							String browserName = cap.getBrowserName();

							reports.addSystemInfo("Browser",browserName);
						}
						else
						{
							String Node = "http://192.168.2.164:5555/wd/hub";
							
							 DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
							 driver = new RemoteWebDriver(new URL(Node), cap);	
						}
					 
					 wait = new WebDriverWait(driver, 40000);
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
					
						driver.get(AppURL);
					
						
					    driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(username);
				        test.log(LogStatus.PASS, "Username is entered: "+username);
				        
				        

					    driver.findElement(locator(prop.getProperty("csr_password"))).clear();
					    driver.findElement(locator(prop.getProperty("csr_password"))).sendKeys(Pwd);
				        test.log(LogStatus.PASS, "Password is entered: "+Pwd);
				        
				       
				        driver.findElement(locator(prop.getProperty("csr_storeid"))).sendKeys(store_id);;
				        test.log(LogStatus.PASS, "Storenumber is entered: "+store_id);
				        //Click Login Button
				        driver.findElement(locator(prop.getProperty("csr_login_button"))).click();
				        test.log(LogStatus.PASS, "Clicked on login button");

				       Thread.sleep(9000);
				       break;
}
					
	}
	
}
	public static void central_login(String SSN,String AppURL)
	{
		try{
			
				int lastrow=TestData.getLastRow("Central_Login");
				String sheetName="Central_Login";

				String username = "automation";
				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					//String username = TestData.getCellData(sheetName,"UserName",row);;
					String password =TestData.getCellData(sheetName,"Password",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);;
					
					if(SSN.equals(RegSSN))
					{	
				
						Thread.sleep(4000);
						
						test.log(LogStatus.INFO, "<FONT color=green style=Calibri > Opened the CSR URL " +AppURL);



						test.log(LogStatus.INFO, "CSR Application is launched " );
						
						if(prop.getProperty("login_method").equalsIgnoreCase("local"))
						{
							driver = new InternetExplorerDriver();
							//=========== For Browser info in report ===============
							Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();

							String browserName = cap.getBrowserName();

							reports.addSystemInfo("Browser",browserName);
						}
						else
						{
							String Node = "http://192.168.2.164:5555/wd/hub";
							
							 DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
							 driver = new RemoteWebDriver(new URL(Node), cap);	
						}
					 
					 wait = new WebDriverWait(driver, 40000);
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
					
						driver.get(AppURL);
					
						
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

				       Thread.sleep(9000);
				       break;
}
					
	}
	}
	catch (Exception e) {
		test.log(LogStatus.FAIL,"CSR login is failed");
        e.printStackTrace();
	}

}
public static void logout(String SSN,String AppURL){
		
						
				try{
					
					
					driver.switchTo().defaultContent();
					 driver.switchTo().frame("topFrame");
					
			driver.findElement(locator(prop.getProperty(("csr_logout_link")))).click();
			     test.log(LogStatus.PASS, "Clicked On logout Button");
			  
			     {
			    	 test.log(LogStatus.PASS, "Logout is Successfully"); 
			    	 
			    	 test.log(LogStatus.INFO, "loggged out from the CSR Application");

			     
			     }
			 

			     driver.quit();
			     	
			}
						
			
		
		
		catch(Exception e)
		{
			
			test.log(LogStatus.ERROR, "CSR logout is failed");


			e.printStackTrace();
		}
}
	
	public static void adminLogin(String SSN,String AppURL){
					
					
		try{
			int lastrow=TestData.getLastRow("Login");
			String sheetName="Login";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String UserName = "automation";
					String Password = "advance";
				
				test.log(LogStatus.INFO, "********Admin Application is launched********");


				if(prop.getProperty("login_method").equalsIgnoreCase("local"))
				{
					driver = new InternetExplorerDriver();
				}
				else
				{
					String Node = "http://192.168.2.164:5555/wd/hub";
					
					 DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
					 driver = new RemoteWebDriver(new URL(Node), cap);	
				}
				wait = new WebDriverWait(driver, 40000);

				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
				driver.get(BAdminURL);

				driver.findElement(By.name("loginRequestBean.userId")).sendKeys(UserName);

				test.log(LogStatus.PASS, "Username is entered: "+UserName); 

				driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);

				test.log(LogStatus.PASS, "Password is entered: "+Password); 

				//Click Login Button

				driver.findElement(By.name("login")).click();

				test.log(LogStatus.PASS, "Clicked on Submit button");
				Thread.sleep(5000);
			
				Thread.sleep(3000);
				break;

}
					
	}
	}
	catch (Exception e) {
		

		e.printStackTrace();
	}


	
}	
	public static void adminLogout(WebDriver driver,String SSN,String AppURL){
		
		
		try{
			
			
			driver.switchTo().defaultContent();
			 driver.switchTo().frame("topFrame");
			
	driver.findElement(locator(prop.getProperty(("admin_logout_link")))).click();
	     test.log(LogStatus.PASS, "Clicked On logout Button");
	     if(driver.getTitle().contains("Login")){
	    	 test.log(LogStatus.PASS, "Logout is Successfully"); 
	    	
	    	 test.log(LogStatus.INFO, "loggged out from the Admin Application");

	     driver.close();
	     }
	    else{
	    	 test.log(LogStatus.FAIL, "Logout was unsuccessfull"); 
	     }


	     	
	}
				
	


catch(Exception e)
{
	
	test.log(LogStatus.ERROR,"Admin logout is failed");


	e.printStackTrace();
}

}
}


