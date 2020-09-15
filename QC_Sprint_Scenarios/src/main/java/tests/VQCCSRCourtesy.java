package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class VQCCSRCourtesy extends QCStore {
	public static void promisetoPay(String SSN,String AppURL) {
		
			try {
				
				int lastrow = TestData.getLastRow("PromisetoPay");
				
				String sheetName="PromisetoPay";

				for (int row = 2; row <= lastrow; row++) {

					// test.log(LogStatus.INFO, MarkupHelper.createLabel("CSR
					// Application is launched", ExtentColor.BLUE));
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					String ProductType=TestData.getCellData(sheetName, "ProductType", row);
					String ReasonsforTransfer = TestData.getCellData(sheetName, "ReasonsforTransfer", row);
					String Comments = TestData.getCellData(sheetName, "Comments", row);
					String Action= TestData.getCellData(sheetName, "Action", row);
					String Response= TestData.getCellData(sheetName, "Response", row);
					String StoreAge_Two = TestData.getCellData(sheetName,"StoreAge_Two",row);
					//String paymentAmt = TestData.getCellData(sheetName,"paymentAmt",row);
					String paymentType = TestData.getCellData(sheetName,"paymentType",row);

					if (SSN.equals(RegSSN)) {
						 String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					
		       Thread.sleep(4000);
		       
		      // QCCSRLoginLogout.login(SSN, AppURL);
				//CSRBorrower.Loan_number(SSN, AppURL);
			//driver.close();
		       driver.switchTo().frame("topFrame");
				
		        driver.findElement(By.cssSelector("li[id='910000']")).click();	
					
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(1000);
			
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
				Thread.sleep(2000);
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
					
					   //  String loan_nbr= driver.findElement(locator(Rprop.getProperty("csr_loan_nbr"))).getText();
						//   test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						 driver.findElement(By.name("transactionList")).sendKeys("History");
						 test.log(LogStatus.PASS, "Transaction Type is selected as History");
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");													 													
						 Thread.sleep(3000); 
						 NextDueDate = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();
						//*[@id="revolvingCreditHistTable"]/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]
					     test.log(LogStatus.PASS, "Next due date is "+NextDueDate);		
					     Thread.sleep(1000); 
					   //*[@id="revolvingCreditHistTable"]/tbody/tr/td[4]/table/tbody/tr[4]/td/span[2]
					     loan_number=driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[4]/td/span[2]")).getText();
					     test.log(LogStatus.PASS, "Loan Number  is "+loan_nbr);	
					     Thread.sleep(1000);
					  /* //*[@id="revolvingCreditHistTable"]/tbody/tr/td[1]/table/tbody/tr[3]/td/span[3]
					    customer_number=driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[3]/td/span[2]")).getText();
				        test.log(LogStatus.PASS, "Customer Nbr is :" +customer_number);*/
				
				//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
				test.log(LogStatus.INFO, "Deposit_Write off Loan process is initiated");

				driver.switchTo().defaultContent();

		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='940000']")));
		        driver.findElement(By.cssSelector("li[id='940000']")).click();	
					
				test.log(LogStatus.PASS, "Clicked on Account Management");
				Thread.sleep(1000);
				try{
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.cssSelector("li[id='940002']")).click();			
				test.log(LogStatus.PASS, "Clicked on Courtesy Calls");
				}
				catch(Exception e)
				{
					//driver.get("http://192.168.2.203/cc/login/index.jsp");
					driver.switchTo().defaultContent();	
					
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
			        driver.findElement(By.cssSelector("li[id='910000']")).click();	
						
					Thread.sleep(1000);	
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					driver.findElement(By.cssSelector("li[id='911101']")).click();	
					test.log(LogStatus.PASS, "Clicked on Transactions");
				}

					    Thread.sleep(5000);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("name=requestBean.installmentType")));
						Thread.sleep(500);
						driver.findElement(By.name("requestBean.productType")).sendKeys(ProductType);
						test.log(LogStatus.PASS, "Product Type Selected as :" + ProductType);
						Thread.sleep(500);
						
						driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[28]/td[1]/input")).click();
						test.log(LogStatus.PASS, "Clicked on Customer search radiobutton");
						Thread.sleep(6000);
						driver.findElement(By.xpath("//*[@id='ach12']/option[6]")).click();
						test.log(LogStatus.PASS, "Loan Nbr selected from List");
						Thread.sleep(6000);
						
						//loan_nbr="11318319";
						driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_number);
						test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
						Thread.sleep(500);
						driver.findElement(By.name("searchajax")).click();
						test.log(LogStatus.PASS, "Clicked on Search button");
						
						Thread.sleep(10000);									
						
						driver.findElement(By.xpath("//*[@id='SearchResults']/form/table/tbody/tr/td/table[3]/tbody/tr[3]/td[15]/input")).click();
						
						test.log(LogStatus.PASS, "Clicked on Go button");
						Thread.sleep(5000);	
						
						driver.findElement(By.name("requestBean.colleffortActivityCd")).sendKeys(Action);
						test.log(LogStatus.PASS, "Action entered as :" + Action);
						
						driver.findElement(By.name("requestBean.colleffortResponseCd")).sendKeys(Response);
						test.log(LogStatus.PASS, "Response entered as :" + Response);
						 
						int IAgeStore=Integer.parseInt(StoreAge_Two);
						 DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
							Date DDueDateminus1 = df.parse(NextDueDate);
							Calendar cal = Calendar.getInstance();
							 cal.setTime(DDueDateminus1);
							 cal.add(Calendar.DATE, IAgeStore);
							 Date DDueDate1= cal.getTime();
							 NextDueDate =df.format(DDueDate1);
						String Due_Date[] =NextDueDate.split("/");
				        String Due_Date1 = Due_Date[0];
				        String Due_Date2 = Due_Date[1];
				        String Due_Date3 = Due_Date[2];
				        Thread.sleep(5000);
				        driver.findElement(By.name("paymentDtMM")).sendKeys(Due_Date1);
				        test.log(LogStatus.PASS, "Month is entered: "+Due_Date1);
				        driver.findElement(By.name("paymentDtDD")).sendKeys(Due_Date2);
				        test.log(LogStatus.PASS, "Date is entered: "+Due_Date2);
				        driver.findElement(By.name("paymentDtYY")).sendKeys(Due_Date3);
				        test.log(LogStatus.PASS, "Year is entered: "+Due_Date3);
				        
				        Thread.sleep(2000);
				        WebElement e4=driver.findElement(By.name("paymentScheduleBean.paymentAmt"));
						e4.clear();
				        driver.findElement(By.name("paymentScheduleBean.paymentAmt")).sendKeys("120");
				        test.log(LogStatus.PASS, "Payment amount is entered as 200 ");
				        driver.findElement(By.name("paymentScheduleBean.paymentType")).sendKeys(paymentType);
				        test.log(LogStatus.PASS, "Payment type is entered as ACH ");
				        Thread.sleep(2000);
                        driver.findElement(By.xpath(" //*[@id='ptpAdd']/td/input")).click();
						
						test.log(LogStatus.PASS, "Clicked on Add payment button");
				        driver.findElement(By.name("requestBean.collEffortCommentText")).sendKeys(Comments);
				        test.log(LogStatus.PASS, "Comment is "+Comments);
				        Thread.sleep(5000);
				        driver.findElement(By.name("SubmitButton")).click();
				        test.log(LogStatus.PASS, "Clicked on Submit button");
				        
						
								}
								}	
						
						
					}

									catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										test.log(LogStatus.FAIL,"Promise to Pay process failed");

									}

						}
					}

						 
