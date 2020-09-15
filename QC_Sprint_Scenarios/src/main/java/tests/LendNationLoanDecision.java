package tests;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.Status;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;

public class LendNationLoanDecision extends QCStore{

	  @Test(priority=4)
	  public static void pdl_loandecision(String SSN,String AppURL) throws Exception
		  
	  {
			 
			//try{
				//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
				
				//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
					int lastrow=TestData.getLastRow("Loan Decision");
					String sheetName="Loan Decision";

					for(int row=2;row<=lastrow;row++)
					{		
						String RegSSN = TestData.getCellData(sheetName,"SSN",row);
	  
				if(SSN.equals(RegSSN))
				{	
			//String RepaymentMethod = TestData.getCellData(sheetName,"RepaymentMethod",row);
			  String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			  String Verification_Code = TestData.getCellData(sheetName,"Verification_Code",row);
			
			Thread.sleep(500);
			test.log(LogStatus.INFO, "******Lend Nation application navigated to PDL Loan Decision page******" );
			Thread.sleep(1000);
			  //wait.until(ExpectedConditions.elementToBeClickable(locator(prop.getProperty("repayment_method_type"))));
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rad1']")));
			  
			  if (ProductID.equals("PDL")) {	 
			     driver.findElement(By.xpath("//*[@id='pdlloan']")).click();
			     test.log(LogStatus.PASS, "Clicked On Paday Loan tab " );
			     Thread.sleep(30000);
			     Thread.sleep(40000);
				 //Thread.sleep(30000);
			     //driver.findElement(By.xpath("//*[@id='rad1']")).click();			   
			     //test.log(LogStatus.PASS, "Product Type selected as : " +ProductID);
			  }
			     else{
			     driver.findElement(By.xpath("//*[@id='insloan']")).click();
			     //test.log(LogStatus.PASS, "Clicked on Installment Loan Radio buton " );
			     test.log(LogStatus.PASS, "Product Type selected as : " +ProductID);
			     Thread.sleep(30000);
			     Thread.sleep(30000);
			     }			
			 
			  
			  
			
			  //================================== Changes Added=============================== 
			  
			  driver.findElement(By.xpath("//*[@id='onlineLoan']")).click();
			  test.log(LogStatus.PASS, "Clicked On Online Loan tab " );
			  Thread.sleep(20000);
			  
			  //=================================================================================
			  Thread.sleep(500);
			  
			  String Loanamount = driver.findElement(By.name("loanAmt")).getAttribute("value");
			  test.log(LogStatus.PASS, "Loan amount is : " +Loanamount );
			  
			  Thread.sleep(500);
			  			     
			  String RepayAmount =  driver.findElement(By.xpath("//*[@id='repamt0']/strong")).getText();
			  test.log(LogStatus.PASS, "Repayment Amount is : " +RepayAmount);
			  
			  Thread.sleep(500);
			  
			  String DueDate = driver.findElement(By.xpath("//*[@id='prodGrid']/tr/td/table/tbody/tr[3]/td[1]/span/span/strong")).getText();
			  test.log(LogStatus.PASS, "Due Date is : " +DueDate);
			  
			  Thread.sleep(500);
			  
			  driver.findElement(By.name("aEmailVerificationCode")).sendKeys(Verification_Code);
			  test.log(LogStatus.PASS, "Verification Code set as : " +Verification_Code );
			  
			  Thread.sleep(500);
			  
			  driver.findElement(By.xpath("//*[@id='confirm']")).click();
			  test.log(LogStatus.PASS, "Clicked on Verification Confirm button " );
			  
			  Thread.sleep(500);
			  
			  if(driver.findElement(By.xpath("//*[@id='msg']")).getText().contains("CODE MATCHED")){
				  
				  test.log(LogStatus.INFO, "<FONT color=green style=Arial>Verification Code Matched");
				 
				}
				else
				{
					test.log(LogStatus.FAIL, "Verification Code Mismatched" );
					 Assert.assertTrue(false);
				  }		 
			  
			  Thread.sleep(500);			  			 	
			
			  //driver.findElement(By.xpath("//*[@id='custDocRadio']")).click();
			  driver.findElement(By.xpath("//input[@value='3' and @type='radio']")).click();
			  test.log(LogStatus.PASS, "Clicked on Email the Required Documents CheckBox " );
	
              Thread.sleep(1000);
              
              driver.findElement(By.xpath("//*[@id='productSubmitBtn']")).click();
              test.log(LogStatus.PASS, "Clicked on Continue Button In Loan Decision Page " );
			
			  Thread.sleep(30000);
			  Thread.sleep(1000);	  			   
			  test.log(LogStatus.INFO, "******************************************************** ");
			  test.log(LogStatus.INFO, "****************** Redirecting To Disclosure Page *************************** ");
			  Thread.sleep(1000);
			  driver.findElement(By.xpath("//*[@id='loanRateChartChk']")).click();
			  test.log(LogStatus.PASS, "Clicked on Rate Chart Checkbox in Disclosure Page " );
			  Thread.sleep(500);
			  driver.findElement(By.xpath("//*[@id='abilityToRepayChk']")).click();
			  test.log(LogStatus.PASS, "Clicked on Ability To Repay Checkbox in Disclosure Page " );
			  Thread.sleep(500);
			
			  //driver.findElement(By.xpath("//*[@id='ContinueBtn']")).click();
			  driver.findElement(By.xpath("//*[@id='discContinue']")).click();
			  
			  test.log(LogStatus.PASS, "Clicked on Submit Application button in Disclosure Page " );
			  Thread.sleep(30000);
			  test.log(LogStatus.INFO, "******************************************************** ");
			  test.log(LogStatus.INFO, "****************** Redirecting To SignContract Page *************************** ");
               
			break;
		
			
			
				}
			}
			
		
	  }
	  
	  public static void moilp_loandecision(String SSN,String AppURL) throws Exception
	  
	  {
			 
			//try{
				//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
				
				//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
					int lastrow=TestData.getLastRow("Loan Decision");
					String sheetName="Loan Decision";

					for(int row=2;row<=lastrow;row++)
					{		
						String RegSSN = TestData.getCellData(sheetName,"SSN",row);
	  
				if(SSN.equals(RegSSN))
				{	
			//String RepaymentMethod = TestData.getCellData(sheetName,"RepaymentMethod",row);
			  String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			  String Verification_Code = TestData.getCellData(sheetName,"Verification_Code",row);
			
			Thread.sleep(500);
			test.log(LogStatus.INFO, "******Lend Nation application navigated to ILP Loan Decision page******" );
			Thread.sleep(1000);
			  //wait.until(ExpectedConditions.elementToBeClickable(locator(prop.getProperty("repayment_method_type"))));
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rad1']")));
			  
			  if (ProductID.equals("PDL")) {	 
			     driver.findElement(By.xpath("//*[@id='pdlloan']")).click();
			     test.log(LogStatus.PASS, "Clicked On Paday Loan tab " );
			     Thread.sleep(30000);
			     Thread.sleep(20000);
				 //Thread.sleep(30000);
			     //driver.findElement(By.xpath("//*[@id='rad1']")).click();			   
			     //test.log(LogStatus.PASS, "Product Type selected as : " +ProductID);
			  }
			     else{
			     driver.findElement(By.xpath("//*[@id='insloan']")).click();
			     test.log(LogStatus.PASS, "Clicked on Installment Loan Tab " );
			     test.log(LogStatus.PASS, "Product Type selected as : " +ProductID);
			     Thread.sleep(30000);
			     Thread.sleep(20000);
			     }			
			 
			  
			  
			
			  //================================== Changes Added=============================== 
			  
			  driver.findElement(By.xpath("//*[@id='onlineLoan']")).click();
			  test.log(LogStatus.PASS, "Clicked On Online Loan tab " );
			  Thread.sleep(20000);
			  
			  //=================================================================================
			  Thread.sleep(500);
			  
			  String Loanamount = driver.findElement(By.name("loanAmt")).getAttribute("value");
			  test.log(LogStatus.PASS, "Loan amount is : " +Loanamount );
			  
			  Thread.sleep(500);
			                                                           
			  String No_Of_Installment =  driver.findElement(By.xpath("//*[@id='ilp20']/div/div[3]/div")).getText();
			  test.log(LogStatus.PASS, "No Of Installment is : " +No_Of_Installment);
			  
			  Thread.sleep(500);
			  
			  String First_Payment_Amt = driver.findElement(By.xpath("//*[@id='ilp20']/div/div[4]/div")).getText();
			  test.log(LogStatus.PASS, "First Payment Amt is : " +First_Payment_Amt);
			  
              Thread.sleep(500);
			  
			  String First_Payment_Date = driver.findElement(By.xpath("//*[@id='ilp20']/div/div[5]/div")).getText();
			  test.log(LogStatus.PASS, "First Payment Date is : " +First_Payment_Date);
			  
              Thread.sleep(500);
			  
			  String Future_Payment = driver.findElement(By.xpath("//*[@id='ilp20']/div/div[6]/div")).getText();
			  test.log(LogStatus.PASS, "Future_Payment is : " +Future_Payment);
			  
              Thread.sleep(500);
			  
			  String Payment_Frequency = driver.findElement(By.xpath("//*[@id='ilp20']/div/div[7]/div")).getText();
			  test.log(LogStatus.PASS, "Payment_Frequency is : " +Payment_Frequency);
			  
              Thread.sleep(500);
			  
			  String Apr = driver.findElement(By.xpath("//*[@id='ilp20']/div/div[8]/div")).getText();
			  test.log(LogStatus.PASS, "APR Amount is : " +Apr);
			  
			  Thread.sleep(500);
			  
			  driver.findElement(By.xpath("//*[@id='ilp20']/div/div[9]/button")).click();
			  test.log(LogStatus.PASS, "Clicked on Option 1 Select tab");
			  
			  Thread.sleep(500);
			  
			  driver.findElement(By.name("aEmailVerificationCode")).sendKeys(Verification_Code);
			  test.log(LogStatus.PASS, "Verification Code set as : " +Verification_Code );
			  
			  Thread.sleep(500);
			  
			  driver.findElement(By.xpath("//*[@id='confirm']")).click();
			  test.log(LogStatus.PASS, "Clicked on Verification Confirm button " );
			  
			  Thread.sleep(500);
			  if(driver.findElement(By.xpath("//*[@id='msg']/span")).getText().contains("NOT MATCHED")){
				  test.log(LogStatus.FAIL, "Verification Code Mismatched" );
				  Assert.assertTrue(false);
				}
				else
				{
				  test.log(LogStatus.INFO, "<FONT color=green style=Arial>Verification Code Matched");
				  }
			  Thread.sleep(500);
			  driver.findElement(By.xpath("//*[@id='custDocRadio']")).click();
			  test.log(LogStatus.PASS, "Clicked on Email the Required Documents CheckBox " );
			  
			  /*Thread.sleep(1000);
			  
			  driver.findElement(By.xpath("//*[@id='abilityToRepayChk']")).click();
			  test.log(LogStatus.PASS, "Clicked on Ability to Repay Check Box " );*/
			  
              Thread.sleep(1000);
              
              driver.findElement(By.xpath("//*[@id='productSubmitBtn']")).click();
			  
			/*  //driver.findElement(By.xpath("//*[@id='productSubmitBtn']")).click();
			//==============================================
				WebElement webElement = driver.findElement(By.xpath("//*[@id='finishbtn']"));//You can use xpath, ID or name whatever you like
				webElement.sendKeys(Keys.TAB);
				webElement.sendKeys(Keys.ENTER);
			  Thread.sleep(500);
			 
			  if (driver.findElement(By.id("finishbtn")).isDisplayed()){
			  System.out.println("displayed");
			  }
			  else if (driver.findElement(By.id("finishbtn")).isEnabled()) {
				  System.out.println("Enabled");
				  Thread.sleep(500);
				  WebElement element = driver.findElement(By.id("finishbtn"));

					Actions action = new Actions(driver);
					 Thread.sleep(500);
					action.moveToElement(element);
					 Thread.sleep(500);
					 action.sendKeys(Keys.PAGE_DOWN).build().perform();
					//driver.findElement(locator(prop.getProperty("first_scrolling_area"))).click();
					driver.findElement(By.id("finishbtn")).click();
				  WebElement elementToHover=driver.findElement(By.xpath("//*[@id='finishbtn']"));
				  Actions action = new Actions(driver);
					action.moveToElement(elementToHover).click(elementToHover).build().perform();
					 test.log(LogStatus.PASS, "Clicked on Finish Button In Loan Decision Page " );
					//action.sendKeys(Keys.PAGE_DOWN).build().perform();
			  }
			//robot.keyRelease(keyEvent.VK_TAB);
			
			//====================================================================
			  driver.findElement(By.id("finishbtn")).click();
			  
			                             
			  test.log(LogStatus.PASS, "Clicked on Finish Button In Loan Decision Page " );*/
			  
			  
			  Thread.sleep(30000);
			  Thread.sleep(1000);
			  //driver.findElement(By.xpath("//*[@id='InstoreFinishScreen']/div[3]/div/button")).click();
			  test.log(LogStatus.PASS, "Clicked on Continue Button In Loan Decision Page " ); 
			  test.log(LogStatus.INFO, "******************************************************** ");
			  Thread.sleep(30000);
			  Thread.sleep(1000);
			
			 
               
			break;
		
			
			
				}
			}
			
		
	  }
public static void wiilp_loandecision(String SSN,String AppURL) throws Exception
	  
	  {
			 
			//try{
				//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
				
				//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
					int lastrow=TestData.getLastRow("Loan Decision");
					String sheetName="Loan Decision";

					for(int row=2;row<=lastrow;row++)
					{		
						String RegSSN = TestData.getCellData(sheetName,"SSN",row);
	  
				if(SSN.equals(RegSSN))
				{	
			//String RepaymentMethod = TestData.getCellData(sheetName,"RepaymentMethod",row);
			  String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			  String Verification_Code = TestData.getCellData(sheetName,"Verification_Code",row);
			
			Thread.sleep(500);
			test.log(LogStatus.INFO, "******Lend Nation application navigated to ILP Loan Decision page******" );
			Thread.sleep(1000);
			  //wait.until(ExpectedConditions.elementToBeClickable(locator(prop.getProperty("repayment_method_type"))));
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rad1']")));
			  
			  if (ProductID.equals("PDL")) {	 
			     driver.findElement(By.xpath("//*[@id='pdlloan']")).click();
			     test.log(LogStatus.PASS, "Clicked On Paday Loan tab " );
			     Thread.sleep(30000);
			     Thread.sleep(20000);
				 //Thread.sleep(30000);
			     //driver.findElement(By.xpath("//*[@id='rad1']")).click();			   
			     //test.log(LogStatus.PASS, "Product Type selected as : " +ProductID);
			  }
			     else{
			     driver.findElement(By.xpath("//*[@id='insloan']")).click();
			     test.log(LogStatus.PASS, "Clicked on Installment Loan Tab " );
			     test.log(LogStatus.PASS, "Product Type selected as : " +ProductID);
			     Thread.sleep(30000);
			     Thread.sleep(20000);
			     }			
			 
			  
			  
			
			  //================================== Changes Added=============================== 
			  
			  driver.findElement(By.xpath("//*[@id='onlineLoan']")).click();
			  test.log(LogStatus.PASS, "Clicked On Online Loan tab " );
			  Thread.sleep(20000);
			  
			  //=================================================================================
			  Thread.sleep(500);
			  
			  String Loanamount = driver.findElement(By.name("loanAmt")).getAttribute("value");
			  test.log(LogStatus.PASS, "Loan amount is : " +Loanamount );
			  
			  Thread.sleep(500);
			                                                           
			  String No_Of_Installment =  driver.findElement(By.xpath("//*[@id='ilp19']/div/div[3]/div")).getText();
			  test.log(LogStatus.PASS, "No Of Installment is : " +No_Of_Installment);
			  
			  Thread.sleep(500);
			
			  String First_Payment_Amt = driver.findElement(By.xpath("//*[@id='ilp19']/div/div[4]/div")).getText();
			  test.log(LogStatus.PASS, "First Payment Amt is : " +First_Payment_Amt);
			  
              Thread.sleep(500);
            
			  String First_Payment_Date = driver.findElement(By.xpath("//*[@id='ilp19']/div/div[5]/div")).getText();
			  test.log(LogStatus.PASS, "First Payment Date is : " +First_Payment_Date);
			  
              Thread.sleep(500);
            
			  String Future_Payment = driver.findElement(By.xpath("//*[@id='ilp19']/div/div[6]/div")).getText();
			  test.log(LogStatus.PASS, "Future_Payment is : " +Future_Payment);
			  
              Thread.sleep(500);
            
			  String Payment_Frequency = driver.findElement(By.xpath("//*[@id='ilp19']/div/div[7]/div")).getText();
			  test.log(LogStatus.PASS, "Payment_Frequency is : " +Payment_Frequency);
			  
              Thread.sleep(500);
          
			  String Apr = driver.findElement(By.xpath("//*[@id='ilp19']/div/div[8]/div")).getText();
			  test.log(LogStatus.PASS, "APR Amount is : " +Apr);
			  
			  Thread.sleep(500);
			
			  driver.findElement(By.xpath("//*[@id='ilp19']/div/div[9]/button")).click();
			  test.log(LogStatus.PASS, "Clicked on Option 1 Select tab");
			  
			  Thread.sleep(500);
			  
			  driver.findElement(By.name("aEmailVerificationCode")).sendKeys(Verification_Code);
			  test.log(LogStatus.PASS, "Verification Code set as : " +Verification_Code );
			  
			  Thread.sleep(500);
			  
			  driver.findElement(By.xpath("//*[@id='confirm']")).click();
			  test.log(LogStatus.PASS, "Clicked on Verification Confirm button " );
			  
			  Thread.sleep(500);
			  if(driver.findElement(By.xpath("//*[@id='msg']/span")).getText().contains("NOT MATCHED")){
				  test.log(LogStatus.FAIL, "Verification Code Mismatched" );
				  Assert.assertTrue(false);
				}
				else
				{
				  test.log(LogStatus.INFO, "<FONT color=green style=Arial>Verification Code Matched");
				  }
			  Thread.sleep(500);
			  driver.findElement(By.xpath("//*[@id='custDocRadio']")).click();
			  test.log(LogStatus.PASS, "Clicked on Email the Required Documents CheckBox " );
			  
			  /*Thread.sleep(1000);
			  
			  driver.findElement(By.xpath("//*[@id='abilityToRepayChk']")).click();
			  test.log(LogStatus.PASS, "Clicked on Ability to Repay Check Box " );*/
			  
              Thread.sleep(1000);
              
              driver.findElement(By.xpath("//*[@id='productSubmitBtn']")).click();
			  
			/*  //driver.findElement(By.xpath("//*[@id='productSubmitBtn']")).click();
			//==============================================
				WebElement webElement = driver.findElement(By.xpath("//*[@id='finishbtn']"));//You can use xpath, ID or name whatever you like
				webElement.sendKeys(Keys.TAB);
				webElement.sendKeys(Keys.ENTER);
			  Thread.sleep(500);
			 
			  if (driver.findElement(By.id("finishbtn")).isDisplayed()){
			  System.out.println("displayed");
			  }
			  else if (driver.findElement(By.id("finishbtn")).isEnabled()) {
				  System.out.println("Enabled");
				  Thread.sleep(500);
				  WebElement element = driver.findElement(By.id("finishbtn"));

					Actions action = new Actions(driver);
					 Thread.sleep(500);
					action.moveToElement(element);
					 Thread.sleep(500);
					 action.sendKeys(Keys.PAGE_DOWN).build().perform();
					//driver.findElement(locator(prop.getProperty("first_scrolling_area"))).click();
					driver.findElement(By.id("finishbtn")).click();
				  WebElement elementToHover=driver.findElement(By.xpath("//*[@id='finishbtn']"));
				  Actions action = new Actions(driver);
					action.moveToElement(elementToHover).click(elementToHover).build().perform();
					 test.log(LogStatus.PASS, "Clicked on Finish Button In Loan Decision Page " );
					//action.sendKeys(Keys.PAGE_DOWN).build().perform();
			  }
			//robot.keyRelease(keyEvent.VK_TAB);
			
			//====================================================================
			  driver.findElement(By.id("finishbtn")).click();
			  
			                             
			  test.log(LogStatus.PASS, "Clicked on Finish Button In Loan Decision Page " );*/
			  
			  
			  Thread.sleep(30000);
			  Thread.sleep(1000);
			  //driver.findElement(By.xpath("//*[@id='InstoreFinishScreen']/div[3]/div/button")).click();
			  test.log(LogStatus.PASS, "Clicked on Continue Button In Loan Decision Page " ); 
			  test.log(LogStatus.INFO, "******************************************************** ");
			  Thread.sleep(30000);
			  Thread.sleep(1000);
			
			 
               
			break;
		
			
			
				}
			}
			
		
	  }

}
