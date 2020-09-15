package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;


import com.relevantcodes.extentreports.LogStatus;

public class LendNationLoanApprovement extends LendNation{
	public static void cashAtStore(String SSN,String AppURL){
	try{
		String FileName= prop.getProperty("file_name");
		
		ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 
			int lastrow=TestData.getLastRow("Loan_Approvement");
			String sheetName="Loan_Approvement";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);
				String ESign_Password = TestData.getCellData(sheetName,"Esign_Password",row);


				if(SSN.equals(RegSSN))
				{	
			
					test.log(LogStatus.INFO, "Opened the CSR URL " +AppURL);

					test.log(LogStatus.INFO, "Cash At Store Loan Aprovement Started");				
					Thread.sleep(3000);
					driver.switchTo().frame("topFrame");
					driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(By.cssSelector("li[id='955190407']")).click();
					test.log(LogStatus.PASS, "Clicked on Cash At Store");		
					driver.switchTo().frame("main");	
					Thread.sleep(500);
					driver.findElement(By.name("requestBean.applicationNbr")).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Entered the loan number is "+loan_number);	
					Thread.sleep(500);
					driver.findElement(By.name("submit")).click();
					test.log(LogStatus.PASS, "Clicked on Submit button");
					Thread.sleep(500);
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					Thread.sleep(500);
					
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);

					if(ESign_CourtesyCallConsent.equals("Yes"))
					{
						if(ESign_Preference.equals("Phone Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
					}
					
					driver.findElement(By.name("requestBean.password")).clear();
					driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
					test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
					
					driver.findElement(By.name("finishLoan")).click();
					test.log(LogStatus.PASS, "click on Finish Loan button ");
					try {
						Alert alert = driver.switchTo().alert();
						alert.accept();
						//if alert present, accept and move on.
					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					
					String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[1]")).getText();
					
					String confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[2]")).getText();
					String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[3]")).getText();
					String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();
				
					test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an "+confirm_text2+" of "+confirm_text3+" First payment date is "+confirm_text4);
					
					driver.findElement(By.name("OKBut")).click();

					test.log(LogStatus.PASS, "click on Yes button ");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					if(driver.findElement(By.name("ok")).isDisplayed())
					{
						test.log(LogStatus.PASS, "New Loan is Completed Successfully ");
						test.log(LogStatus.INFO, "**********************************************************************************");
						//driver.findElement(By.name("ok")).click();
					}
					else
					{
						test.log(LogStatus.INFO, "New Loan is Completed Successfully ");
						test.log(LogStatus.INFO, "**********************************************************************************");
					}	
				}}}catch(Exception e){
					System.out.println(e);
				}
	}

}
