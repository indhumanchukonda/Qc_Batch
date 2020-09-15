package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.relevantcodes.extentreports.LogStatus;

public class AQCCSRVoid extends QCStore{

	public static void QcVoid(String SSN,String AppURL) throws InterruptedException
	{

			String sheetName="NewLoan";	
			int lastrow=TestData.getLastRow(sheetName);

			for(int row=2;row<=lastrow+1;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{

					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					String ESign_Password = TestData.getCellData(sheetName,"ESign_Password",row);
					// System.out.println(Password);

					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String Scenario = TestData.getCellData(sheetName,"Scenario",row);


					String ESign_DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);


					Thread.sleep(4000);
					//test.log(LogStatus.INFO, MarkupHelper.createLabel("Transaction Void has started", ExtentColor.BLUE));
					test.log(LogStatus.INFO, "***********Transaction Void has started****************");
					
					driver.switchTo().frame("bottom");
					
					String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
					String store_date[]=Str_date.split(":");
					String business_date=store_date[1];
					test.log(LogStatus.PASS, "Business date is :"+business_date);

					driver.switchTo().defaultContent();	

					//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					driver.findElement(By.cssSelector("li[id='910000']")).click();	
					/*driver.switchTo().defaultContent();				
					driver.switchTo().frame("topFrame");
					driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();	*/		
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(1000);
					//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
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
				
					
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
				

					if(ProductID.equals("PDL"))
					{									
						
						driver.findElement(By.xpath("//input[@name='button' and @value='Go']")).click();
						test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					
					}
					if(ProductID.equals("TLP"))
					{
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
					}

					Thread.sleep(5000);
					
					
					
					driver.findElement(By.name("transactionList")).sendKeys("Void");
					test.log(LogStatus.PASS, "Transaction selected as Void ");
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Click on go button ");
					try{
					driver.findElement(By.name("transactionDataBean.disbursementType")).click();
					driver.findElement(By.name("transactionDataBean.disbursementType")).sendKeys(Keys.ARROW_DOWN);
					test.log(LogStatus.PASS, "Select tender type ");
					}
					catch(Exception e){
						
						driver.findElement(By.name("transactionDataBean.monetaryCd")).click();
						driver.findElement(By.name("transactionDataBean.monetaryCd")).sendKeys(Keys.ARROW_DOWN);
						test.log(LogStatus.PASS, "Select tender type ");
					}
					driver.findElement(By.name("transactionDataBean.password")).sendKeys("1234");
					test.log(LogStatus.PASS, "password entered");
					try{
					driver.findElement(By.name("Submit22")).click();
					test.log(LogStatus.PASS, "Clicked on finsh void");
					}
					catch(Exception e)
					{
						driver.findElement(By.name("Submit23")).click();
						test.log(LogStatus.PASS, "Clicked on finsh void");
					}
					Thread.sleep(3000);
						if(driver.findElement(By.name("checkyes")).isDisplayed())
						{
							test.log(LogStatus.PASS, "Void Loan is Completed Successfully ");
							test.log(LogStatus.PASS, "**********************************************");
							driver.findElement(By.name("checkyes")).click();
						}
						else
						{
							test.log(LogStatus.FAIL, "Void Loan is not Completed Successfully ");
						}
					}

					//break;			 								
				}

			}
	
	public static void Originaltender_Void(String SSN,String AppURL) throws InterruptedException
	{

			String sheetName="NewLoan";	
			int lastrow=TestData.getLastRow(sheetName);

			for(int row=2;row<=lastrow+1;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{

					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					String ESign_Password = TestData.getCellData(sheetName,"ESign_Password",row);
					// System.out.println(Password);

					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String Scenario = TestData.getCellData(sheetName,"Scenario",row);


					String ESign_DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);


					Thread.sleep(4000);
					//test.log(LogStatus.INFO, MarkupHelper.createLabel("Transaction Void has started", ExtentColor.BLUE));
					test.log(LogStatus.INFO, "***********Transaction Void has started****************");
					
					driver.switchTo().frame("bottom");
					
					String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
					String store_date[]=Str_date.split(":");
					String business_date=store_date[1];
					test.log(LogStatus.PASS, "Business date is :"+business_date);

					driver.switchTo().defaultContent();	

				
					driver.switchTo().frame("topFrame");
				
					driver.findElement(By.cssSelector("li[id='910000']")).click();	
						
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(1000);
					//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
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
				
					
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
				

					if(ProductID.equals("PDL"))
					{									
						
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[5]/td[11]/input[1]")).click();
						test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					
					}
					if(ProductID.equals("TLP"))
					{
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
					}

					Thread.sleep(5000);
					
					
					
					driver.findElement(By.name("transactionList")).sendKeys("Void");
					test.log(LogStatus.PASS, "Transaction selected as Void ");
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Click on go button ");
				
					driver.findElement(By.name("transactionDataBean.disbursementType")).sendKeys("Orginal Tender");
					test.log(LogStatus.PASS, "Select tender type as orginal Tender");
					
					
					driver.findElement(By.name("transactionDataBean.password")).sendKeys("1234");
					test.log(LogStatus.PASS, "password entered");
					
					driver.findElement(By.name("Submit22")).click();
					test.log(LogStatus.PASS, "Clicked on finsh void");
					Thread.sleep(3000);
						if(driver.findElement(By.name("checkyes")).isDisplayed())
						{
							test.log(LogStatus.PASS, "Void Loan is Completed Successfully ");
							test.log(LogStatus.PASS, "**********************************************");
							driver.findElement(By.name("checkyes")).click();
						}
						else
						{
							test.log(LogStatus.FAIL, "Void Loan is not Completed Successfully ");
						}
					}

					//break;			 								
				}

			}

	

		
	}
