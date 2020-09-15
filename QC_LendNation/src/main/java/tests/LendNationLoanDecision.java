package tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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

public class LendNationLoanDecision extends LendNation{

	  @Test(priority=4)
	  public static void loandecision(String SSN,String AppURL) throws Exception
	  {
		  //try{
			  String FileName= prop.getProperty("file_name");
				ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 
  		 
			int lastrow=TestData.getLastRow("Loan Decision");
			String sheetName="Loan Decision";
			WebDriverWait wait = new WebDriverWait(driver, 20000);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{	
			  String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			  String Verification_Code = TestData.getCellData(sheetName,"Verification_Code",row);
			  String NewLoan_Term = TestData.getCellData(sheetName,"NewLoan_Term",row);
			
			Thread.sleep(50000);
			test.log(LogStatus.INFO, "Lend Nation application navigated to Loan Decision page " );
			Thread.sleep(100);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='insloan']")));
			  
			  if (ProductID.equals("PDL")) {	 
			     driver.findElement(By.xpath("//*[@id='rad1']")).click();
			     test.log(LogStatus.PASS, "Clicked on Payday Loan Radio buton " );
			  }
			     else if(ProductID.equals("ILP")) {
			     driver.findElement(By.xpath("//*[@id='insloan']")).click();
			     test.log(LogStatus.PASS, "Clicked on Installment Loan Radio buton " );
			     }
			  
			  Thread.sleep(30000);
			  
			  driver.findElement(By.xpath("//*[@id='onlineLoan']")).click();
			  test.log(LogStatus.PASS, "Clicked on Next buton " );

			  Thread.sleep(30000);
			  Thread.sleep(30000);
			  
			  Thread.sleep(500);
			  
			  String MaxEligibleLoanamount = driver.findElement(By.xpath("//*[@id='maxAmt']")).getAttribute("value");
			  test.log(LogStatus.PASS, "Max Eligible Loan amount is : " +MaxEligibleLoanamount );
			  
			  Thread.sleep(500);
			  if(NewLoan_Term.equalsIgnoreCase("Term1")){
			  driver.findElement(By.xpath("//input[@type='radio' and @id='terms1']")).click();
			  test.log(LogStatus.PASS, "Clicked on term 1 " );
			  
			  }else if(NewLoan_Term.equalsIgnoreCase("Term2")){
				  driver.findElement(By.xpath("//input[@type='radio' and @id='terms2']")).click();
				  test.log(LogStatus.PASS, "Clicked on term 2 " );
			  }
			  Thread.sleep(500);
			  String Loanamount = driver.findElement(By.name("loanAmt")).getAttribute("value");
			  test.log(LogStatus.PASS, "Loan amount is : " +Loanamount );
			  
			  Thread.sleep(500);
			  			     
			  driver.findElement(By.xpath("//input[@value='3' and @type='radio']")).click();
			  test.log(LogStatus.PASS, "Clicked on send email Radio button " );
			  
			  Thread.sleep(500);
			  
			  driver.findElement(By.name("aEmailVerificationCode")).sendKeys(Verification_Code);
			  test.log(LogStatus.PASS, "Verification Code set as : " +Verification_Code );
			  
			  Thread.sleep(500);
			  
			  driver.findElement(By.xpath("//*[@id='confirm']")).click();
			  test.log(LogStatus.PASS, "Clicked on Verification Confirm button " );
			  
			  Thread.sleep(500);
			  			 
			  if(driver.findElement(By.xpath("//*[@id='msg']")).isDisplayed())
			    	
			 	{
				  test.log(LogStatus.PASS,"Verification Code Match");
				  driver.findElement(By.xpath("//*[@id='loanRateChartChk']")).click();
				  test.log(LogStatus.PASS, "Clicked on LendNation Disclosures Checkbox " );
				  driver.findElement(By.xpath("//*[@id='productSubmitBtn']")).click();
				  test.log(LogStatus.PASS, "Clicked on Submit App button " );

			 	}
			 	else
				{
				
			 		 test.log(LogStatus.FAIL,"Verification Code Doesn't Match");

				}
			  Thread.sleep(10000);
			  //Thread.sleep(30000);
			 /* if( driver.findElement(By.xpath("//h1[contains(text(),'CONGRATS')]']")).isDisplayed())
			  {	*/
			    test.log(LogStatus.PASS, "Loan Decision Information Entered Successfully with SSN : " +SSN);
				test.log(LogStatus.PASS, "********************************************* ");
			  /*}
				else
				{
				test.log(LogStatus.FAIL, "Loan Decision Information is not entered Successfully with SSN : " +SSN);
				}*/
			  	Thread.sleep(20000);
				test.log(LogStatus.INFO, "Lend Nation application navigated to Verify by Phone page " );
				
				WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Go to Dashboard')]"));

				Actions actions = new Actions(driver);

				actions.moveToElement(element).click().perform();
				test.log(LogStatus.PASS, "Clicked on Go to Dashboard button " );
				
				/*driver.findElement(By.xpath("//button[contains(text(),'Go to Dashboard')]")).click();
				test.log(LogStatus.PASS, "Clicked on Go to Dashboard button " );*/
				
				String loan_text = driver.findElement(By.xpath("//span[contains(text(),'Loan Nbr')]")).getText();
				String[] trimmedText = loan_text.split(":");
				System.out.println(trimmedText[1]);
				loan_number=trimmedText[1];
				test.log(LogStatus.PASS, "Loan Number is : " +loan_number );
				
				
				
				}
				
			}
			
		 // }
	/*	  catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "Loan Information is not entered Successfully with SSN  " +SSN);
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "LoanDecision");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));

		  }*/
			
	  }
	  
	  

}
