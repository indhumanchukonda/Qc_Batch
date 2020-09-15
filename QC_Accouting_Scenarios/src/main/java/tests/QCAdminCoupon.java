package tests;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class QCAdminCoupon extends QCStore
{
	

	public static void getCouponCode(WebDriver driver,String SSN,String AppURL) throws Exception
	{
		//String CSOFee;
		
	try{
		int lastrow=TestData.getLastRow("Login");
			String sheetName="Login";

			String UserName = "automation";
			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				
				if(SSN.equals(RegSSN))
				{
				//String UserName = TestData.getCellData(sheetName,"AdminUserName",row);
				String Password = TestData.getCellData(sheetName,"AdminPassword",row);
				String Coupon_Name = TestData.getCellData(sheetName,"Coupon_Name",row);
				String Coupon_Amt = TestData.getCellData(sheetName,"Coupon_Amt",row);

				String AdminURL =Jprop.getProperty("AdminURL");
			
				test.log(LogStatus.INFO, "********Admin Application is launched********");
				
				if(Jprop.getProperty("login_method").equalsIgnoreCase("local"))
				{
					driver = new InternetExplorerDriver();
				}
				else
				{
					String Node = "http://192.168.2.164:5555/wd/hub";
					 //String Node2 = "http://192.168.0.238:5566/wd/hub";
					 DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
					 driver = new RemoteWebDriver(new URL(Node), cap);	
				}
				wait = new WebDriverWait(driver, 40000);

			
				driver.get(AdminURL);
				test.log(LogStatus.INFO, "Opened the Admin URL" + AdminURL);

				test.log(LogStatus.INFO, "Reading encryption details from Admin has initiated"+ AdminURL);


				String mainwindow2=driver.getWindowHandle();
			
				System.out.println("In Admin"+ mainwindow2);
	
	//DateFormat df=new SimpleDateFormat("MM/dd/yyyy"); 

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

	driver.findElement(By.xpath("//*[contains(text(),'Store Setup')]")).click(); 

	test.log(LogStatus.PASS, "Clicked on Store Setup tab");

	

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 

	driver.findElement(By.linkText("Promotions")).click();

	test.log(LogStatus.PASS, "Clicked on Promotions link");



	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.findElement(By.linkText("Edit Promotions")).click();

	test.log(LogStatus.PASS, "Clicked on Edit Promotions");

	Thread.sleep(5000);


	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.switchTo().frame("main");
	

	driver.findElement(By.name("displayName")).sendKeys(Coupon_Name);
	test.log(LogStatus.PASS, "Coupon Display Name Entered "+Coupon_Name); 
	Thread.sleep(1000);
	List<WebElement>  rows = driver.findElements(By.xpath("//*[@id='timesheets']/tbody/tr")); 
	int n=rows.size();

	for(int j=2;j<=n;j++){
		
		String CouponValue = driver.findElement(By.xpath("//*[@id='timesheets']/tbody/tr["+j+"]/td[4]")).getText();
		test.log(LogStatus.PASS, "Getting CouponValue is " + CouponValue);
		Thread.sleep(500);
		CouponValueInt=Float.valueOf(CouponValue);
		test.log(LogStatus.PASS, "Getting Int CouponValue is " + CouponValueInt);
		
		if(Coupon_Amt.equalsIgnoreCase("LessThan")){
		
		if(CSOFeeInt>CouponValueInt){
			String Start_date = driver.findElement(By.xpath("//*[@id='timesheets']/tbody/tr["+j+"]/td[7]")).getText();
			test.log(LogStatus.PASS, "Getting Start_date is " + Start_date);
			String End_date = driver.findElement(By.xpath("//*[@id='timesheets']/tbody/tr["+j+"]/td[8]")).getText();
			test.log(LogStatus.PASS, "Getting End_date is " + End_date);
			
			SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
		    SimpleDateFormat formatter2=new SimpleDateFormat("dd-MM-yyyy");
		    
		    Date bdate=formatter1.parse(business_date); 
		    test.log(LogStatus.PASS, "Convert Business_date is " + bdate);
		    Date sdate=formatter2.parse(Start_date);
		    test.log(LogStatus.PASS, "Convert Start_date is " + sdate);
		    Date edate=formatter2.parse(End_date);
		    test.log(LogStatus.PASS, "Convert End_date is " + edate);
		    
		    if(sdate.before(bdate) && bdate.before(edate) ){
		    	
			//Coupon_Code = driver.findElement(By.xpath("//*[@id='timesheets']/tbody/tr["+j+"]/td[3]")).getText();
	    	Coupon_Code = driver.findElement(By.xpath("//*[@id='timesheets']/tbody/tr[2]/td[3]")).getText();

			test.log(LogStatus.PASS, "Get Coupon_Code as " + Coupon_Code);
			test.log(LogStatus.PASS, "***********************************************");
			Thread.sleep(1000);
			driver.close();
			break;
		    }else{
		    	
		    	test.log(LogStatus.INFO, "Coupon Start or End date is not matches the Business date");
		    	test.log(LogStatus.INFO, "***********************************************");
		    }
		}
		
	}else if(Coupon_Amt.equalsIgnoreCase("GreaterThan")){
		
		if(CSOFeeInt<CouponValueInt){
			driver.findElement(By.xpath("//*[@id='timesheets']/tbody/tr[2]/td[10]/input")).click();
			driver.findElement(By.xpath("//*[@id='couponid']/td[3]/div[2]/input")).clear();
		    //String value = CSOFeeNewLoan+"20";
		    
		  //================================
		    String Fee1 = CSOFeeNewLoan;
		  //string to double 
	        double d = Double.parseDouble(Fee1);
	        double dd=d+20;
	       //double to string 	       
	        String s=String.valueOf(dd);  
	        System.out.println(s);  
		    
		  //================================
		    
			driver.findElement(By.xpath("//*[@id='couponid']/td[3]/div[2]/input")).sendKeys(s);
			test.log(LogStatus.PASS, "coupon value:" +s);
			String Start_date = driver.findElement(By.xpath("//*[@id='timesheets']/tbody/tr["+j+"]/td[7]")).getText();
			test.log(LogStatus.PASS, "Getting Start_date is " + Start_date);
			String End_date = driver.findElement(By.xpath("//*[@id='timesheets']/tbody/tr["+j+"]/td[8]")).getText();
			test.log(LogStatus.PASS, "Getting End_date is " + End_date);
			
			SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
		    SimpleDateFormat formatter2=new SimpleDateFormat("dd-MM-yyyy");
		    
		    Date bdate=formatter1.parse(business_date); 
		    test.log(LogStatus.PASS, "Convert Business_date is " + bdate);
		    Date sdate=formatter2.parse(Start_date);
		    test.log(LogStatus.PASS, "Convert Start_date is " + sdate);
		    Date edate=formatter2.parse(End_date);
		    test.log(LogStatus.PASS, "Convert End_date is " + edate);
		    
		    if(sdate.before(bdate) && bdate.before(edate) ){
		    	//*[@id="timesheets"]/tbody/tr[2]/td[3]
			//Coupon_Code = driver.findElement(By.xpath("//*[@id='timesheets']/tbody/tr["+j+"]/td[3]")).getText();
		    Coupon_Code = driver.findElement(By.xpath("//*[@id='timesheets']/tbody/tr[2]/td[3]")).getText();
			test.log(LogStatus.PASS, "Get Coupon_Code as " + Coupon_Code);
			test.log(LogStatus.PASS, "***********************************************");
			Thread.sleep(1000);
			driver.close();
			break;
		    }else{
		    	
		    	test.log(LogStatus.INFO, "Coupon Start or End date is not matches the Business date");
		    	test.log(LogStatus.INFO, "***********************************************");
		    }
		}
		
	}
		
		
	}
	
break;
}
			}	
	
	//break;
}

				catch (Exception e) {
					e.printStackTrace();
					test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
					String screenshotPath = getScreenhot(driver, "Exception");
									test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
					test.log(LogStatus.INFO,"Getting Coupon_Code from Admin process is initiated again due to Application sync issue");
					driver.get(Jprop.getProperty("login_page")); 
					//continue;

				}
	//driver.close();

}
}
