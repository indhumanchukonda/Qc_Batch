package tests;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class JQCACHProcessing extends QCStore {
	
	public static void ACHProcess(String SSN,String NextDueDate)
	{
		 
		try{
			int lastrow=TestData.getLastRow("Deposit");
			String sheetName="Deposit";
			System.out.println("...."+sheetName);
				
			for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String StoreID = TestData.getCellData(sheetName,"StoreID",row);
					
					if(SSN.equals(RegSSN))
					{
							
			       Thread.sleep(4000);
					test.log(LogStatus.INFO, "ACH Processing through from Admin has initiated");
					driver.switchTo().defaultContent();	
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					driver.findElement(By.xpath("//*[@id='500000']/a")).click();		
					test.log(LogStatus.PASS, "Clicked on Transactions");
					Thread.sleep(3000);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
				
					 Actions action = new Actions(driver);  
					 WebElement ACH=driver.findElement(By.xpath("//*[@id='503000']/a"));
					 action.moveToElement(ACH).build().perform();
					 test.log(LogStatus.PASS, " Mouse hover on ACH menu");
					 Thread.sleep(2000);
					 WebElement loc=driver.findElement(By.xpath("//*[@id='955190290']/a"));
					 action.moveToElement(loc).build().perform();
					 test.log(LogStatus.PASS, " Mouse hover on payday loan menu");
					 Thread.sleep(3000);
					 driver.findElement(By.xpath("//*[@id='401']/a")).click();
					 test.log(LogStatus.PASS, " click on ACH Processing");
					 Thread.sleep(3000);
					
				for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}				    
				 driver.switchTo().defaultContent();
				 driver.switchTo().frame("mainFrame");
				 driver.switchTo().frame("main");
				 driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[1]/font/b/input")).click();
				 driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[3]/input")).sendKeys(StoreID);
				 test.log(LogStatus.PASS, "StoreID is entered: "+StoreID);
				 System.out.println(NextDueDate);
				 test.log(LogStatus.PASS, "Age Store Date is :"+NextDueDate);
				 Thread.sleep(5000);
				 String Due_Date[] =NextDueDate.split("/");
			     String Due_Date1 = Due_Date[0];
			     String Due_Date2 = Due_Date[1];
			     String Due_Date3 = Due_Date[2];
			     driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[4]/td[3]/div[1]/input")).clear();
			     driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[4]/td[3]/div[1]/input")).sendKeys(Due_Date1);
			        test.log(LogStatus.PASS, "Begin Month is entered: "+Due_Date1);
			        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[4]/td[3]/div[3]/input")).clear();
			        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[4]/td[3]/div[3]/input")).sendKeys(Due_Date2);
					test.log(LogStatus.PASS, "Begin Date is entered: "+Due_Date2);
					driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[4]/td[3]/div[5]/input")).clear();
					driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[4]/td[3]/div[5]/input")).sendKeys(Due_Date3);
					test.log(LogStatus.PASS, "Begin Year is entered: "+Due_Date3);
					
					driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[5]/td[3]/div[1]/input")).clear();
					driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[5]/td[3]/div[1]/input")).sendKeys(Due_Date1);
			        test.log(LogStatus.PASS, "End Month is entered: "+Due_Date1);
			        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[5]/td[3]/div[3]/input")).clear();
			        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[5]/td[3]/div[3]/input")).sendKeys(Due_Date2);
					test.log(LogStatus.PASS, "End Date is entered: "+Due_Date2);
					driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[5]/td[3]/div[5]/input")).clear();
					driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[5]/td[3]/div[5]/input")).sendKeys(Due_Date3);
					test.log(LogStatus.PASS, "End Year is entered: "+Due_Date3); 
					driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[3]/tbody/tr/td[2]/input")).click();
					test.log(LogStatus.PASS, "Click on Submit button ");
					Thread.sleep(4000);
					driver.findElement(By.xpath("//*[@id='CmdReturnPosting']")).click();
					test.log(LogStatus.PASS, "Clicked on ACH Process Now Successfully");
					 test.log(LogStatus.PASS, "********************************************** ");
					break;
						 
					}
				
					}
				
		
				
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(LogStatus.FAIL, "ACH Processing from Admin is failed");


		}
}

	public static void chargeback(String SSN,String AppURL) throws InterruptedException
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

								if(Esign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
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
					List<WebElement> l = driver.findElements(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr/td[1]/input"));
					int n = l.size();
					test.log(LogStatus.INFO, "size is" +n);
					for (int i = 0; i < l.size(); i++) {
						
						String transaction = driver.findElement(By.xpath("(//*[@id='revolvingCreditDetailsTable']/tbody/tr/td[4])["+i+"]")).getText();
						if(transaction.equals("Debit Card Deposit"))
						{
							
							driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+i+"]/td[1]/input")).click();
							test.log(LogStatus.PASS, "Debit card deposit radio button selected");
							}
						}
					
						
					}
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,1000)", " ");
				    
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

				break;

			}

		}
}
