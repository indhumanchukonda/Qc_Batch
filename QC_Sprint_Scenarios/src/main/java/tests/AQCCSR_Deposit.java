package tests;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class AQCCSR_Deposit extends QCStore{

	public static void deposit(String SSN,String AppURL) throws InterruptedException
	{

		int lastrow=TestData.getLastRow("Deposit");
		String sheetName="Deposit";

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{

				String PIN = TestData.getCellData(sheetName,"Password",row);
				String DepositType = TestData.getCellData(sheetName,"DepositType",row);
				String Esign_CollateralType = TestData.getCellData(sheetName,"Esign_CollateralType",row);


				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);



				Thread.sleep(4000);
				//test.log(LogStatus.INFO, MarkupHelper.createLabel("Deposit from CSR has initiated", ExtentColor.BLUE));
				test.log(LogStatus.INFO, "Deposit through dropdown from CSR has initiated");

				driver.switchTo().frame("bottom");
				String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
				String store_date[]=Str_date.split(":");
				business_date=store_date[1];
				test.log(LogStatus.PASS, ""+Str_date);

				driver.switchTo().defaultContent();	

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
				driver.findElement(By.cssSelector("li[id='910000']")).click();	
					
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(3000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

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

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[9]/input")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);					  
					
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");

				/*loan_number=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]")).getText();

				test.log(LogStatus.PASS, "Loan Number is " + loan_number);*/
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				if(Esign_CollateralType.equalsIgnoreCase("ACH"))
				{

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("transactionList")).sendKeys(Esign_CollateralType+" Deposit");
					test.log(LogStatus.PASS, "Transaction type is selected "+Esign_CollateralType+" Deposit");
					//driver.findElement(By.id("go_Button")).click();
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");

					driver.findElement(By.name("requestBean.chkName")).click();
					test.log(LogStatus.PASS, " Selected checkbox under Checks to be ACHD");


					driver.findElement(By.name("CmdReturnPosting")).click();
					test.log(LogStatus.PASS, " Cliked on next button");

					driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
					test.log(LogStatus.PASS, " Entered password");

					driver.findElement(By.name("Submit22")).click();
					test.log(LogStatus.PASS, " cliked on finish ACH deposit button");

					if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
					{
						driver.findElement(By.name("ok")).click();
						test.log(LogStatus.PASS, "ACH Deposit Completed Successfully");
						test.log(LogStatus.PASS, Esign_CollateralType+" Deposit from CSR is successfull");
						test.log(LogStatus.PASS, "********************************************** ");
						
					}
					else{
						test.log(LogStatus.INFO, "ACH Deposit Completed Successfully");
						test.log(LogStatus.INFO, Esign_CollateralType+" Deposit from CSR is successfull");
						test.log(LogStatus.INFO, "********************************************** ");
					}
				}

				if(Esign_CollateralType.equalsIgnoreCase("CHECK"))
				{

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("transactionList")).sendKeys(Esign_CollateralType+" Deposit");
					test.log(LogStatus.PASS, "Transaction type is selected"+Esign_CollateralType+" Deposit");
					driver.findElement(By.id("go_Button")).click();
					test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");

					driver.findElement(By.name("transactionDataBean.chk21ReDepType")).sendKeys(DepositType);								 
					test.log(LogStatus.PASS, "Deposit Type is :"+DepositType);

					driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
					test.log(LogStatus.PASS, " Entered password "+PIN);

					driver.findElement(By.name("finish")).click();
					test.log(LogStatus.PASS, " Click on finish deposit button");

					if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
					{
						driver.findElement(By.name("ok")).click();
						test.log(LogStatus.PASS, "ACH Deposit Completed Successfully");
						test.log(LogStatus.PASS, Esign_CollateralType+" Deposit from CSR is successfull");
						test.log(LogStatus.PASS, "********************************************** ");
					}
				}
				if(Esign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
				{
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("transactionList")).sendKeys(Esign_CollateralType+" Deposit");
					test.log(LogStatus.PASS, "Transaction type is selected"+Esign_CollateralType+" Deposit");
					//driver.findElement(By.id("go_Button")).click();
					driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[10]/table/tbody/tr/td[2]/input")).click();
					test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");

					driver.findElement(By.name("requestBean.chkName")).click();
					test.log(LogStatus.PASS, " Selected checkbox under checks to be ACHD option");


					driver.findElement(By.name("CmdReturnPosting")).click();
					test.log(LogStatus.PASS, " Clik on next button");

					driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
					test.log(LogStatus.PASS, " Entered password");

					driver.findElement(By.name("Submit22")).click();
					test.log(LogStatus.PASS, " Clik on finsish ACH deposit button");

					if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
					{

						test.log(LogStatus.PASS, Esign_CollateralType+" Deposit from CSR is successfull");
						test.log(LogStatus.PASS, "********************************************** ");

					}
				}

				break;

			}

		}

	}
	
	public static void chargeback(String SSN,String AppURL) throws InterruptedException
	{

		int lastrow=TestData.getLastRow("Deposit");
		String sheetName="Deposit";
		String transaction = null; 

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{


				String PIN = TestData.getCellData(sheetName,"Password",row);
				String DepositType = TestData.getCellData(sheetName,"DepositType",row);
				String Esign_CollateralType = TestData.getCellData(sheetName,"Esign_CollateralType",row);
				
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);



				Thread.sleep(4000);
				//test.log(LogStatus.INFO, MarkupHelper.createLabel("Deposit from CSR has initiated", ExtentColor.BLUE));
				test.log(LogStatus.INFO, "Deposit through dropdown from CSR has initiated");

				driver.switchTo().frame("bottom");
				String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
				String store_date[]=Str_date.split(":");
				business_date=store_date[1];
				test.log(LogStatus.PASS, ""+Str_date);

				driver.switchTo().defaultContent();	

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
				driver.findElement(By.cssSelector("li[id='910000']")).click();	
					
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(3000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

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

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");			    
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				Thread.sleep(5000);

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on Go button under Loans section");

				//  String loan_nbr= driver.findElement(locator(prop.getProperty("csr_loan_nbr"))).getText();
				//   test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
				driver.findElement(By.name("transactionList")).sendKeys("History");
				test.log(LogStatus.PASS, "Transaction Type is selected as History");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
				Thread.sleep(3000);
				//Validations			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");				
				driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr[5]/td[1]/input")).click();
				test.log(LogStatus.PASS, "Debit card deposit radio button selected");
				driver.findElement(By.xpath("//*[@id='dispute']")).click();
				test.log(LogStatus.PASS, "clicked on chargeback button");
				String altmsg = driver.switchTo().alert().getText();
				test.log(LogStatus.INFO, altmsg);
				
				driver.switchTo().alert().accept();
				if(altmsg.contains("successfully"))
				{
					test.log(LogStatus.PASS, "Charge back is completed successfully");	
				}
				else
				{
					test.log(LogStatus.FAIL, "Charge back is not completed successfully");
				}

								/*if(Esign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
				{
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("transactionList")).sendKeys("History");
					test.log(LogStatus.PASS, "Transaction type is selected History");
					//driver.findElement(By.id("go_Button")).click();
					driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[10]/table/tbody/tr/td[2]/input")).click();
					test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
					List<WebElement> transaction_list = driver.findElements(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr/td[1]/input"));
					//List<WebElement> k = driver.findElements(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr/td[1]/input"));
					
					 
					int n = transaction_list.size();
					
					test.log(LogStatus.INFO, "size is" +n);
					for (int i = 1; i < n+1; i++) {
						
						transaction = driver.findElement(By.xpath("(//*[@id='revolvingCreditDetailsTable']/tbody/tr/td[4])["+i+"]")).getText();
						if(transaction.equals("Debit Card Deposit"))//(//*[@id='revolvingCreditDetailsTable']/tbody/tr/td[4])[2]
						{
							
							driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+i+"]/td[1]/input")).click();
							test.log(LogStatus.PASS, "Debit card deposit radio button selected");
							driver.findElement(By.xpath("//*[@id='dispute']")).click();
							test.log(LogStatus.PASS, "clicked on chargeback button");
							Thread.sleep(5000);
							String altmsg = driver.switchTo().alert().getText();
							test.log(LogStatus.INFO, altmsg);
							
							driver.switchTo().alert().accept();
							if(altmsg.contains("successfully"))
							{
								test.log(LogStatus.PASS, "Charge back is completed successfully");	
							}
							else
							{
								test.log(LogStatus.FAIL, "Charge back is not completed successfully");
							}
							}
						}
					
						
					}
					*//*JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,1000)", " ");*/
				    
					/*driver.findElement(By.xpath("//*[@id='dispute']")).click();
					test.log(LogStatus.PASS, "clicked on chargeback button");
					Thread.sleep(5000);
					String altmsg = driver.switchTo().alert().getText();
					test.log(LogStatus.INFO, altmsg);
					
					driver.switchTo().alert().accept();
					if(altmsg.contains("successfully"))
					{
						test.log(LogStatus.PASS, "Charge back is completed successfully");	
					}
					else
					{
						test.log(LogStatus.FAIL, "Charge back is not completed successfully");
					}*/
					/*//JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,1000)", " ");
					Thread.sleep(10000);
					
					if(transaction_list>5)
					{
						for (int i = 5; i < n; i++) {
							
							//String transaction = driver.findElement(By.xpath("(//*[@id='revolvingCreditDetailsTable']/tbody/tr/td[4])["+i+"]")).getText();
							if(transaction.equals("Debit Card Deposit"))//(//*[@id='revolvingCreditDetailsTable']/tbody/tr/td[4])[2]
							{
								
								driver.findElement(By.xpath("(//*[@id='revolvingCreditDetailsTable']/tbody/tr/td[1]/input)["+i+"]")).click();
								test.log(LogStatus.PASS, "Debit card deposit radio button selected");
								}
							}
						
							
						}*/
						
					}
					
				

				//break;

			}

		}
	public static void chargeback1(String SSN,String AppURL) throws InterruptedException
	{

		int lastrow=TestData.getLastRow("Deposit");
		String sheetName="Deposit";
		String transaction = null; 

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{


				String PIN = TestData.getCellData(sheetName,"Password",row);
				String DepositType = TestData.getCellData(sheetName,"DepositType",row);
				String Esign_CollateralType = TestData.getCellData(sheetName,"Esign_CollateralType",row);
				
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);



				Thread.sleep(4000);
				//test.log(LogStatus.INFO, MarkupHelper.createLabel("Deposit from CSR has initiated", ExtentColor.BLUE));
				test.log(LogStatus.INFO, "Deposit through dropdown from CSR has initiated");

				driver.switchTo().frame("bottom");
				String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
				String store_date[]=Str_date.split(":");
				business_date=store_date[1];
				test.log(LogStatus.PASS, ""+Str_date);

				driver.switchTo().defaultContent();	

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
				driver.findElement(By.cssSelector("li[id='910000']")).click();	
					
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(3000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

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

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");			    
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				Thread.sleep(5000);

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on Go button under Loans section");

				//  String loan_nbr= driver.findElement(locator(prop.getProperty("csr_loan_nbr"))).getText();
				//   test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
				driver.findElement(By.name("transactionList")).sendKeys("History");
				test.log(LogStatus.PASS, "Transaction Type is selected as History");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
				Thread.sleep(3000);
				//Validations			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");				
				driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr[10]/td[1]/input")).click();
				test.log(LogStatus.PASS, "Debit card deposit radio button selected");
				driver.findElement(By.xpath("//*[@id='dispute']")).click();
				test.log(LogStatus.PASS, "clicked on chargeback button");
				String altmsg = driver.switchTo().alert().getText();
				test.log(LogStatus.INFO, altmsg);
				
				driver.switchTo().alert().accept();
				if(altmsg.contains("successfully"))
				{
					test.log(LogStatus.PASS, "Charge back is completed successfully");	
				}
				else
				{
					test.log(LogStatus.FAIL, "Charge back is not completed successfully");
				}

								
					
						
					}
					
				

				//break;

			}

		}

}







