package tests;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class LegalGarnishment extends QCStore{


	public static void lAndG(String SSN,String AppURL) throws Exception
	{
		int i;
		for(i=0;i<3;i++)
		{
			
		
		try{
			
				int lastrow=TestData.getLastRow("LAndG");
				String sheetName="LAndG";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{
						
						
						String StoreID = TestData.getCellData(sheetName,"StoreID",row);
						String Case = TestData.getCellData(sheetName,"Case#",row);
						String ProcessName = TestData.getCellData(sheetName,"ProcessName",row);
						String ProcessPhoneNbr = TestData.getCellData(sheetName, "ProcessPhoneNbr", row);
						String Fee = TestData.getCellData(sheetName, "Fee", row);
						String Comments = TestData.getCellData(sheetName, "Comments", row);

						test.log(LogStatus.INFO,"Return Posting process has started");
						
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
						Thread.sleep(3500);
						driver.findElement(By.linkText("Legal and Garnishment")).click();

						test.log(LogStatus.PASS, "Clicked on Legal and Garnishment");

						driver.switchTo().defaultContent();

						driver.switchTo().frame("mainFrame");

						Thread.sleep(2500);

						
						//.....................Colateral TYPE...........................
						Actions action = new Actions(driver);
						action.moveByOffset(200,100).perform();
						Thread.sleep(10000);
						action.click();

						
							
							Thread.sleep(500);
							
							driver.switchTo().defaultContent();

							driver.switchTo().frame("mainFrame");

							driver.switchTo().frame("main");
							WebElement e3=driver.findElement(By.name("requestBean.bnklocnbr"));
							e3.click();
							Thread.sleep(2000);
							e3.sendKeys(StoreID);
							test.log(LogStatus.PASS, "Store ID is entered: "+StoreID);
							Thread.sleep(1000);
							driver.findElement(By.name("requestBean.ssn")).sendKeys(SSN);   
							test.log(LogStatus.PASS, "Enter the SSN: "+SSN);
							Thread.sleep(1000);
							driver.findElement(By.name("submit")).click();   
							test.log(LogStatus.PASS, "Clicked on Submit Button");
						    Thread.sleep(3000);
						    driver.findElement(By.name("button")).click();   
							test.log(LogStatus.PASS, "Clicked on Go Button");
							Thread.sleep(1000);
							
							driver.findElement(By.xpath("//*[@value='Go' and @name='button']")).click();   
							test.log(LogStatus.PASS, "Clicked on Go Button");
							Thread.sleep(1000);
							
							String Due_Date[] = business_date.split("/");
							String Due_Date1 = Due_Date[0];
							String Due_Date2 = Due_Date[1];
							String Due_Date3 = Due_Date[2];
							driver.findElement(By.name("bankruptcyDate1")).sendKeys(Due_Date1);
							test.log(LogStatus.PASS, "Month is entered: " + Due_Date1);
							driver.findElement(By.name("bankruptcyDate2")).sendKeys(Due_Date2);
							test.log(LogStatus.PASS, "Date is entered: " + Due_Date2);
							driver.findElement(By.name("bankruptcyDate3")).sendKeys(Due_Date3);
							test.log(LogStatus.PASS, "Year is entered: " + Due_Date3);
							Thread.sleep(1000);
							driver.findElement(By.name("requestBean.bkrCaseNbr")).sendKeys(Case);   
							test.log(LogStatus.PASS, "Enter Case number: "+Case);
							Thread.sleep(1000);
							
							driver.findElement(By.name("requestBean.serverName")).sendKeys(ProcessName);   
							test.log(LogStatus.PASS, "Enter Process Server Name: "+ProcessName);
							Thread.sleep(1000);
							
							driver.findElement(By.name("requestBean.contactNbr")).sendKeys(ProcessPhoneNbr);   
							test.log(LogStatus.PASS, "Enter Process Server Phone Number: "+ProcessPhoneNbr);
							Thread.sleep(1000);
							
							driver.findElement(By.name("typeOfLG")).sendKeys("Legal");   
							test.log(LogStatus.PASS, "Select as: Legal");
							Thread.sleep(1000);
							
							driver.findElement(By.id("yes")).click();   
							test.log(LogStatus.PASS, "Clicked on Yes Button");
							Thread.sleep(1000);
							
							driver.findElement(By.name("requestBean.lgFee")).sendKeys(Fee);   
							test.log(LogStatus.PASS, "Enter Fee's: "+Fee);
							Thread.sleep(1000);
							
							driver.findElement(By.name("requestBean.comments")).sendKeys(Comments);   
							test.log(LogStatus.PASS, "Enter Comments: "+Comments);
							Thread.sleep(1000);
							
							
							driver.findElement(By.xpath("//*[@value='Finish' and @name='finishBank']")).click();   
							test.log(LogStatus.PASS, "Clicked on Finish Button");
							Thread.sleep(1000);

							 
							test.log(LogStatus.PASS," Legal and Garnishment Transaction Completed Successfully");
							test.log(LogStatus.PASS,"***********************************");
							driver.close();
					
						
						break;
						}
							 								
				}
		
				
				break;
		}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Void Trasaction is failed", ExtentColor.RED));
					test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
					String screenshotPath = getScreenhot(driver, "Exception");
									test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
					test.log(LogStatus.INFO, "Return Posting Trasaction is initiated due to application sync issue");
					driver.get(prop.getProperty("login_page"));   
					continue;

				}

	}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "Return Posting is failed");
			Assert.assertTrue(false);
	
		}
}
}