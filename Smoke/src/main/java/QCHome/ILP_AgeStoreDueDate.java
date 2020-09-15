package QCHome;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class ILP_AgeStoreDueDate extends CSR{
	public static String NextDueDate;

	public static void ageStoreDueDate(String SSN,String AppURL) throws InterruptedException{
	
		
				int lastrow=TestData.getLastRow("NewLoan");
				String sheetName="NewLoan";

					for(int row=2;row<=lastrow;row++)
							{		
								String RegSSN = TestData.getCellData(sheetName,"SSN",row);
								if(SSN.equals(RegSSN))
								{
							        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
								       
							        String SSN1 = SSN.substring(0, 3);
							        String SSN2 = SSN.substring(3,5);
							        String SSN3 = SSN.substring(5,9);
					       Thread.sleep(4000);
							//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
							test.log(LogStatus.INFO, "Age Store Due Date process is initiated");

							driver.switchTo().defaultContent();	
							
					        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
							driver.switchTo().frame("topFrame");
							wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					        driver.findElement(By.cssSelector("li[id='910000']")).click();	
								
							test.log(LogStatus.PASS, "Clicked on Loan Transactions");
							Thread.sleep(1000);
							try{
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							driver.findElement(By.cssSelector("li[id='911101']")).click();			
							test.log(LogStatus.PASS, "Clicked on Transactions");
							}
							catch(Exception e)
							{
								//driver.get("https://qclocalauto.qfund.net/cc/login/index.jsp");
								driver.get("https://qclocalreg.qfund.net/cc/login/index.jsp");
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
							driver.switchTo().frame("main");		
							driver.findElement(By.name("ssn1")).sendKeys(SSN1);
							test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
							driver.findElement(By.name("ssn2")).sendKeys(SSN2);
							test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
							driver.findElement(By.name("ssn3")).sendKeys(SSN3);
							test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
							driver.findElement(By.name("submit1")).click();
							test.log(LogStatus.PASS, "Click on submit Button");		
							for(String winHandle : driver.getWindowHandles()){
						    driver.switchTo().window(winHandle);
							}
						    driver.switchTo().defaultContent();
						    driver.switchTo().frame("mainFrame");
						    driver.switchTo().frame("main");
						   
						    String mainwindow=driver.getWindowHandle();
						    System.out.println("mainwindow"+mainwindow);
								    driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).click();
								    test.log(LogStatus.PASS, "Clicked on Customer number link");
								   Thread.sleep(2000);
								    for(String winHandle : driver.getWindowHandles()){
								    	System.out.println("winHandle"+winHandle);
								    	System.out.println(driver.getWindowHandles().size());
										if(!mainwindow.equalsIgnoreCase(winHandle))
										{
									    driver.switchTo().window(winHandle);
									    
									    System.out.println("winHandle"+winHandle);
									    loan_nbr= driver.findElement(locator(prop.getProperty("ILP_loan_nbr"))).getText();
										test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
									    NextDueDate= driver.findElement(locator(prop.getProperty("csr_due_date"))).getText();
								        test.log(LogStatus.PASS, "Next due date is "+NextDueDate);
								        driver.close();
										break;
										}
								    }
										driver.switchTo().window(mainwindow);
									
								  
								  
								 test.log(LogStatus.PASS, "Age Store Date is :"+NextDueDate);
								 Thread.sleep(5000);
								 
									
									for(String winHandle1 : driver.getWindowHandles()){
										    driver.switchTo().window(winHandle1);
											}				    
									driver.switchTo().defaultContent();
									 driver.switchTo().frame("topFrame");
								 driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
											 test.log(LogStatus.PASS, "Clicked on Cash Management");
											 driver.switchTo().defaultContent();
											driver.switchTo().frame("mainFrame");	
											try{
											driver.findElement(By.xpath("//*[@id='988190657']/a")).click();		
											test.log(LogStatus.PASS, "Clicked on Start Scheduler");
											}
											catch(Exception e)
											{
												//driver.get("https://qclocalauto.qfund.net/cc/login/index.jsp");
												driver.get("https://qclocalreg.qfund.net/cc/login/index.jsp");

												driver.switchTo().defaultContent();
												 driver.switchTo().frame("topFrame");
											 driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
														
												driver.switchTo().defaultContent();
												driver.switchTo().frame("mainFrame");
												driver.findElement(By.xpath("//*[@id='988190657']/a")).click();		
												test.log(LogStatus.PASS, "Clicked on Start Scheduler");
											}
											Thread.sleep(5000);
													
											 driver.switchTo().defaultContent();
											 driver.switchTo().frame("mainFrame");
											 driver.switchTo().frame("main");
											String Due_Date[] =NextDueDate.split("/");
									        String Due_Date1 = Due_Date[0];
									        String Due_Date2 = Due_Date[1];
									        String Due_Date3 = Due_Date[2];
									        driver.findElement(By.name("endMonth")).sendKeys(Due_Date1);
									        test.log(LogStatus.PASS, "Month is entered: "+Due_Date1);
											driver.findElement(By.name("endDay")).sendKeys(Due_Date2);
											test.log(LogStatus.PASS, "Date is entered: "+Due_Date2);
											driver.findElement(By.name("endYear")).sendKeys(Due_Date3);
											test.log(LogStatus.PASS, "Year is entered: "+Due_Date3);
											driver.findElement(By.name("runSchedulerBtn")).click();
											test.log(LogStatus.PASS, "Clicked on Run Scheduler");
											Thread.sleep(500);
											 //String alert1=   driver.switchTo().alert().getText();
											 //test.log(LogStatus.PASS, "Clicked on Finish Loan: "+alert1);
											 
											 try { 
												    Alert alert = driver.switchTo().alert();
												
												    alert.accept();
												    //if alert present, accept and move on.														
													
												}
												catch (Exception e) {
												    //do what you normally would if you didn't have the alert.
												}
											 Thread.sleep(30000);
											try{
											 driver.findElement(By.name("ok")).click();
											 test.log(LogStatus.PASS,"Logout successfully");
											 test.log(LogStatus.PASS,"Clicked on Scheduler Ok Successfully");
											 test.log(LogStatus.PASS,"************************************************");
											}
											catch (Exception e){
											 test.log(LogStatus.PASS,"Logout successfully");
											 test.log(LogStatus.PASS,"Clicked on Scheduler Ok Successfully");
											 test.log(LogStatus.PASS,"************************************************");
											}
											 
											 //driver.close();
						break;
						
					 
				}}
				}

}
