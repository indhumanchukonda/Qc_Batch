package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.Status;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;



public class LendNationFinancialInformation extends LendNation {
	@Test(priority=3)
	  public static void financialInformation(String SSN,String AppURL) throws Exception
	  {
		  try{
			  String FileName= prop.getProperty("file_name");
				ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);	 
			int lastrow=TestData.getLastRow("Financial Informartion");
			String sheetName="Financial Informartion";
			WebDriverWait wait = new WebDriverWait(driver, 10000);
			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{	
			String IncomeSourse = TestData.getCellData(sheetName,"IncomeSourse",row);
			String EmployerName = TestData.getCellData(sheetName,"EmployerName",row);
			String EmployerIndustry = TestData.getCellData(sheetName,"EmployerIndustry",row);
			String WorkPhone = TestData.getCellData(sheetName,"WorkPhone",row);
			String TimeAtJob = TestData.getCellData(sheetName,"TimeAtJob",row);
			String Income_GrossIncome = TestData.getCellData(sheetName,"Income_GrossIncome",row);
			String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
			String PayMethod = TestData.getCellData(sheetName,"PayMethod",row);
			String PaidDay = TestData.getCellData(sheetName,"PaidDay",row);
			String TakeHome = TestData.getCellData(sheetName,"TakeHome",row);
			//String ReceiveType = TestData.getCellData(sheetName,"ReceiveType",row);
			
			String AccountType = TestData.getCellData(sheetName,"AccountType",row);
			String AccountNumber = TestData.getCellData(sheetName,"AccountNumber",row);
			String Bank_ABARoutingNbr = TestData.getCellData(sheetName,"Bank_ABARoutingNbr",row);
			//String RepaymentMethod = TestData.getCellData(sheetName,"RepaymentMethod",row);
			
			String SmpaidDay = TestData.getCellData(sheetName,"SmpaidDay",row);
			String SemiMonOthFirstDate = TestData.getCellData(sheetName,"SemiMonOthFirstDate",row);
			String SemiMonOthSecondDate = TestData.getCellData(sheetName,"SemiMonOthSecondDate",row);
			
			String MpaidDay = TestData.getCellData(sheetName,"MpaidDay",row);
			String MonOthFirstDate = TestData.getCellData(sheetName,"MonOthFirstDate",row);
			String MonOthSecondDate = TestData.getCellData(sheetName,"MonOthSecondDate",row);
			
			String MonOthOneFirstDate = TestData.getCellData(sheetName,"MonOthOneFirstDate",row);
			
			String Funding = TestData.getCellData(sheetName,"Funding",row);
			
			String HireDate = TestData.getCellData(sheetName,"HireDate",row);


		  
		  
			Thread.sleep(5000);
		  driver.findElement(locator(prop.getProperty("income_type"))).sendKeys(IncomeSourse);
		 //test.log(LogStatus.INFO, "Lend Nation application navigated to Financial Information page ");
	test.log(LogStatus.INFO, "Lend Nation application navigated to Financial Information page");


		  test.log(LogStatus.PASS, "Selected Income source as " + IncomeSourse);
		  Thread.sleep(3000);
		  wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(locator(prop.getProperty("employer_name")))));

		  driver.findElement(locator(prop.getProperty("employer_name"))).sendKeys(EmployerName);
		  test.log(LogStatus.PASS, "Entered Employer Name : " + EmployerName);

		  driver.findElement(locator(prop.getProperty("employer_industry"))).sendKeys(EmployerIndustry);
		  test.log(LogStatus.PASS, "Selected Employer Industry as " + EmployerIndustry);
		  Thread.sleep(3000);
		  wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(locator(prop.getProperty("employer_phone_no")))));

		  driver.findElement(locator(prop.getProperty("employer_phone_no"))).sendKeys(WorkPhone);
		  test.log(LogStatus.PASS, "Enterted Employer phone no :" + WorkPhone);
/*
		  driver.findElement(locator(prop.getProperty("time_at_employer"))).sendKeys(TimeAtJob);
		  test.log(LogStatus.PASS, "Selected Time at employer as " + TimeAtJob);
		  Thread.sleep(3000);
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("pay_frequency")))));
		  */
		  driver.findElement(By.xpath("//*[@id='hireBenefitDate']")).sendKeys(HireDate);
		  test.log(LogStatus.PASS, "Enter Hiredate as:" +HireDate);
		  
		  driver.findElement(locator(prop.getProperty("pay_frequency"))).sendKeys(Income_PayFrequency);
		  test.log(LogStatus.PASS, "Selected Pay frequency as " + Income_PayFrequency);

		  driver.findElement(locator(prop.getProperty("income_method_type"))).sendKeys(PayMethod);
		  test.log(LogStatus.PASS, "Selected Income method type as " + PayMethod);
		  
		  if(Income_PayFrequency.equalsIgnoreCase("Bi-Weekly")){
			  
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("income_pay_day")))));
		  driver.findElement(locator(prop.getProperty("income_pay_day"))).sendKeys(PaidDay);
		  test.log(LogStatus.PASS, "Selected Income paid day as " + PaidDay);

		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("next_pay_day")))));

		  driver.findElement(locator(prop.getProperty("next_pay_day"))).click();
		  test.log(LogStatus.PASS, "Selected Next pay date " );
		  
		  }else if(Income_PayFrequency.equalsIgnoreCase("Semi-Monthly")){
			  
			  if(SmpaidDay.equalsIgnoreCase("1")){
				  
				  driver.findElement(By.id("incomeWeekNxtPaydt20")).click();
				  test.log(LogStatus.PASS, "Click on The 1st and 16th day of each month radio button ");
				  
			  }else if(SmpaidDay.equalsIgnoreCase("2")){
				  
				  driver.findElement(By.id("incomeWeekNxtPaydt21")).click();
				  test.log(LogStatus.PASS, "Click on The 15th and last day of each month radio button ");
				  
			  }else if(SmpaidDay.equalsIgnoreCase("3")){
				  
				  driver.findElement(By.id("incomeWeekNxtPaydt0")).click();
				  test.log(LogStatus.PASS, "Click on other pay day of each month radio button ");
				  
				  new Select(driver.findElement(By.id("semiMonthlySel10"))).selectByVisibleText(SemiMonOthFirstDate);
				  test.log(LogStatus.PASS, "Selected the First Date : "+SemiMonOthFirstDate);
				  
				  new Select(driver.findElement(By.id("semiMonthlySel20"))).selectByVisibleText(SemiMonOthSecondDate);
				  test.log(LogStatus.PASS, "Selected the Second Date : "+SemiMonOthSecondDate);
			  }
			  
		  }else if(Income_PayFrequency.equalsIgnoreCase("Monthly")){
			  
			  if(MpaidDay.equalsIgnoreCase("1")){
				  
				  driver.findElement(By.xpath("//input[@id='incomeRadio10' and @value='1']")).click();
				  test.log(LogStatus.PASS, "Click on other pay day of each month radio button ");
				  
				  new Select(driver.findElement(By.id("income1st0"))).selectByVisibleText(MonOthOneFirstDate);
				  test.log(LogStatus.PASS, "Selected the First Date : "+MonOthOneFirstDate);
				  
			  }else if(MpaidDay.equalsIgnoreCase("2")){
				  
				  driver.findElement(By.xpath("//input[@id='incomeRadio10' and @value='2']")).click();
				  test.log(LogStatus.PASS, "Click on other pay day of each month radio button ");
				  
				  new Select(driver.findElement(By.id("income1st20"))).selectByVisibleText(MonOthFirstDate);
				  test.log(LogStatus.PASS, "Selected the First Date : "+MonOthFirstDate);
				  
				  new Select(driver.findElement(By.id("income1st30"))).selectByVisibleText(MonOthSecondDate);
				  test.log(LogStatus.PASS, "Selected the Second Date : "+MonOthSecondDate);				  
			  }
			  
		  }else if(Income_PayFrequency.equalsIgnoreCase("Weekly")){
			  
			  Thread.sleep(2000);
			  new Select(driver.findElement(By.id("week"))).selectByVisibleText(PaidDay);
			  test.log(LogStatus.PASS, "Selected Income paid day as : "+PaidDay);			 
			  
		  }
		  
		  driver.findElement(locator(prop.getProperty("gross_pay"))).sendKeys(Income_GrossIncome);
		  test.log(LogStatus.PASS, "Enterted Gross pay amount is " + Income_GrossIncome);

		  driver.findElement(locator(prop.getProperty("net_pay"))).sendKeys(TakeHome);
		  test.log(LogStatus.PASS, "Entered Net pay amount is : " + TakeHome);

		  
		  driver.findElement(locator(prop.getProperty("add_income_button"))).click();
		  test.log(LogStatus.PASS, "Added Income " );
		  Thread.sleep(5000);		  
		  
		  new Select(driver.findElement(By.xpath("//select[@id='disbType' and @ng-model='disbType']"))).selectByVisibleText(Funding);
		  test.log(LogStatus.PASS, "Selected Funding method as : "+Funding);
		  
		  if(Funding.equalsIgnoreCase("ACH / Electronic Bank Transfer")){
			  
			  new Select(driver.findElement(By.id("fAccountType"))).selectByVisibleText(AccountType);
			  test.log(LogStatus.PASS, "Selected Account Type as : "+AccountType);
			  
			  driver.findElement(locator(prop.getProperty("ABA_number_field"))).sendKeys(Bank_ABARoutingNbr);
			  test.log(LogStatus.PASS, "Entered ABA number : " + Bank_ABARoutingNbr);
			  Thread.sleep(2000);
			  driver.findElement(locator(prop.getProperty("account_number_field"))).sendKeys(AccountNumber);
			  test.log(LogStatus.PASS, "Entered Account number : " + AccountNumber);
			  Thread.sleep(3000);

			  driver.findElement(locator(prop.getProperty("confirm_account_number_field"))).sendKeys(AccountNumber);
			  test.log(LogStatus.PASS, "Confirmed account number : " + AccountNumber);			    
		  }
		
		  Thread.sleep(5000);
		  driver.findElement(locator(prop.getProperty("continue_button_financial_inf_page"))).click();
		  test.log(LogStatus.PASS, "Clicked on Continue " );
		  Thread.sleep(20000);
		  
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("repayment_method_type")))));
		  Thread.sleep(10000);
		  if( driver.findElement(locator(prop.getProperty("repayment_method_type"))).isEnabled())
		  {	
				test.log(LogStatus.PASS, "Finanacial Information Entered Successfully with SSN : " +SSN);
				test.log(LogStatus.PASS, "********************************************* ");

			 	}
				else
				{
				test.log(LogStatus.FAIL, "Financial Information is not entered Successfully with SSN : " +SSN);
				}
	  

				}
			}
			
	  }
			 catch(Exception e)
			  {
					test.log(LogStatus.ERROR, "Financial Information is not successfully filled with SSN : " +SSN);
					test.log(LogStatus.ERROR, "Error message  " +e);
					  String screenshotPath = getScreenhot(driver, "financialInformation");
					  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
			
	  }
	  

}
}
