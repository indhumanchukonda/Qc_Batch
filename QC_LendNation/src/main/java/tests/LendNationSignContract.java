package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.relevantcodes.extentreports.Status;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;



public class LendNationSignContract extends LendNation{
	

	public static void signContract(String SSN,String AppURL) throws Exception
	{
		try{
			String FileName= prop.getProperty("file_name");
			ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";
				WebDriverWait wait = new WebDriverWait(driver, 40000);

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;
				String Funding = TestData.getCellData(sheetName,"Funding",row);

				Thread.sleep(5000);
				
			
					driver.findElement(By.id("needEsign")).click();
					test.log(LogStatus.PASS, "Clicked on Need E-Sign button on dashboard");					
					Thread.sleep(15000);
					test.log(LogStatus.INFO, "Lend Nation application navigated to Sign Contract page");
					
					driver.switchTo().frame("dispAgr0");
					test.log(LogStatus.INFO, "Enter the First Frame");
					Thread.sleep(2000);
					WebElement element = driver.findElement(By.xpath("/html/body/embed"));
					element.click();
					test.log(LogStatus.INFO, "Click on first document page");
					Thread.sleep(2000);
					Actions action = new Actions(driver);

					action.moveToElement(element);

					action.sendKeys(Keys.PAGE_DOWN).build().perform();

					//action.sendKeys(Keys.PAGE_DOWN).build().perform();

					/*action.sendKeys(Keys.PAGE_DOWN).build().perform();
					
					action.sendKeys(Keys.PAGE_DOWN).build().perform();*/
					
					Thread.sleep(2000);
					test.log(LogStatus.PASS, "Viewed Electronic Consent by scrolling down the document ");
					driver.switchTo().defaultContent();
					Thread.sleep(2000);
					driver.findElement(By.id("checkBox0")).click();
					
					test.log(LogStatus.PASS, "Checked the first checkbox ");
					Thread.sleep(2000);
					
					driver.findElement(By.id("SignatureRequired0")).sendKeys(Signaturename);
					test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
					Thread.sleep(2000);
					 
					 
				/*	driver.switchTo().frame("dispAgr1");
					WebElement element2 = driver.findElement(By.xpath("/html/body/embed"));		

					action.moveToElement(element2);

					action.sendKeys(Keys.PAGE_DOWN).build().perform();

					action.sendKeys(Keys.PAGE_DOWN).build().perform();

					action.sendKeys(Keys.PAGE_DOWN).build().perform();
					
					Thread.sleep(2000);
					test.log(LogStatus.PASS, "Viewed Electronic Consent by scrolling down the document ");*/


					driver.findElement(By.id("checkBox1")).click();
					
					test.log(LogStatus.PASS, "Checked the second checkbox ");
					Thread.sleep(2000);
					
					driver.findElement(By.id("SignatureRequired1")).sendKeys(Signaturename);
					test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
					Thread.sleep(2000);
					  if(Funding.equalsIgnoreCase("ACH / Electronic Bank Transfer")){
						  driver.findElement(By.id("checkBox2")).click();
							
							test.log(LogStatus.PASS, "Checked the second checkbox ");
							Thread.sleep(2000);
					  }
					 
					 driver.switchTo().frame("dispAgr1");
					 test.log(LogStatus.INFO, "Enter the second Frame");
						WebElement element3 = driver.findElement(By.xpath("/html/body/embed"));		
						element3.click();
					action.moveToElement(element3);

					action.sendKeys(Keys.PAGE_DOWN).build().perform();

					/*action.sendKeys(Keys.PAGE_DOWN).build().perform();

					action.sendKeys(Keys.PAGE_DOWN).build().perform();*/
					
					Thread.sleep(2000);
					test.log(LogStatus.PASS, "Viewed Electronic Consent by scrolling down the document ");
					 driver.switchTo().defaultContent();
					  if(Funding.equalsIgnoreCase("ACH / Electronic Bank Transfer")){
						  driver.findElement(By.id("checkBox3")).click();
							
							test.log(LogStatus.PASS, "Checked the thrid checkbox ");
							Thread.sleep(2000);
							/*driver.findElement(By.id("SignatureRequired2")).sendKeys(Signaturename);
							test.log(LogStatus.PASS, "Entered the thrid Signature field details as : "+Signaturename);
							Thread.sleep(2000);*/
					  }
					  else if(Funding.equalsIgnoreCase("Cash At Store")){
					driver.findElement(By.id("checkBox2")).click();
					
					test.log(LogStatus.PASS, "Checked the second checkbox ");
					Thread.sleep(2000);
					  }
					  try
					  {
					driver.findElement(By.id("SignatureRequired2")).sendKeys(Signaturename);
					test.log(LogStatus.PASS, "Entered the Second Signature field details as : "+Signaturename);
					Thread.sleep(2000);
					  }
					  catch(Exception ex)
					  {
						  
					  }
					/*driver.findElement(By.id("SignatureRequired2")).sendKeys(Signaturename);
					test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
					Thread.sleep(2000);*/
				
				driver.findElement(By.id("getLoanNowButton")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				

				 Thread.sleep(10000);
				 driver.findElement(By.id("back")).click();

					test.log(LogStatus.INFO, "Lend Nation application navigated to Dashboard page");
					test.log(LogStatus.PASS, "Clicked on go To Dashboard button");
					 Thread.sleep(2000);
					
					 test.log(LogStatus.PASS, "sign Contract Information Entered Successfully with SSN : " +SSN);
						test.log(LogStatus.PASS, "********************************************* ");
						
						String Next_due_date = driver.findElement(By.id("dueDate0")).getText();
						test.log(LogStatus.PASS, "Next Due Date is :" +Next_due_date);
						
						String Next_payment_due = driver.findElement(By.id("payDue0")).getText();
						test.log(LogStatus.PASS, "Next Payment Due is" +Next_payment_due);
						
						String current_Loan_Balance = driver.findElement(By.id("currentBal0")).getText();
						test.log(LogStatus.PASS, "current Loan Balance is :"+current_Loan_Balance);
						
						String Loan_Type = driver.findElement(By.id("oLoan0")).getText();
						test.log(LogStatus.PASS, "Loan Type is :"+Loan_Type);
						
					}
				  			 
				  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "signContract");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					System.out.println(e);

			  }
				
				
				}
	}
	
	
	

