package tests;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class RepoReqDenied extends QCStore{
	
	public static void repoProcess(String SSN,String AppURL) throws Exception
	{

		try{
			
				int lastrow=TestData.getLastRow("Repo_Req_Denied");
				String sheetName="Repo_Req_Denied";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{
						

						test.log(LogStatus.INFO,"Repo process has started");
						
						driver.switchTo().frame("topFrame");
						driver.findElement(By.partialLinkText("Transactions")).click();   
						test.log(LogStatus.PASS, "Clicked on Transactions");
						
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						Thread.sleep(1500);
						driver.findElement(By.linkText("Title Loan")).click();
						test.log(LogStatus.PASS, "Clicked on Title Loan link");
						
						Thread.sleep(1500);
						driver.findElement(By.linkText("Repo Process")).click();
						test.log(LogStatus.PASS, "Clicked on Repo Process");
						//loan_nbr="10864313";
						Thread.sleep(500);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						driver.findElement(By.name("requestBean.dealNbr")).sendKeys(loan_nbr);
						test.log(LogStatus.PASS, "Enter the loan number: "+loan_nbr);
						
						driver.findElement(By.name("submit")).click();
						test.log(LogStatus.PASS, "Click on Submit button");
						Thread.sleep(1500);
						
						driver.findElement(By.xpath("//*[@name='button' and @value='Go']")).click();
						test.log(LogStatus.PASS, "Click on Go button");
						
						driver.findElement(By.xpath("//*[@name='submitBtn' and @id='submitBtn']")).click();
						test.log(LogStatus.PASS, "Click on Save and Close button");
						
						System.out.println(driver.getWindowHandles().size());						
						
						driver.findElement(By.xpath("//*[@value='Send' and @id='button']")).click();
						test.log(LogStatus.PASS, "Click on Send button");
						
						Thread.sleep(2000);

								
								/*if(driver.findElement(By.xpath("//*[@value='Ok' and @name='Ok']")).isDisplayed()){*/
									
						/*driver.findElement(By.xpath("//*[text()='Ok']")).click();
						test.log(LogStatus.PASS, "Click on Ok button");*/
								
								test.log(LogStatus.PASS, "Repo Process is Processed successfully");
								test.log(LogStatus.PASS, "***************************************");
								
								/*}else{
									
									test.log(LogStatus.INFO, "Repo Process is Processed successfully");
									test.log(LogStatus.INFO, "***************************************");									
								}*/
								
								break;
						}
					
					}
				
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Void Trasaction is failed", ExtentColor.RED));
			test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
			String screenshotPath = getScreenhot(driver, "Exception");
							test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "Repo Process Trasaction is initiated due to application sync issue");
			driver.get(Jprop.getProperty("login_page"));   
			

		}
	}
	public static void repoApprovalInbox(String SSN,String AppURL) throws Exception
	{
		try{
			
			int lastrow=TestData.getLastRow("Repo_Req_Denied");
			String sheetName="Repo_Req_Denied";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String Reasons_Denial = TestData.getCellData(sheetName,"Reasons_Denial",row);
					
					
					test.log(LogStatus.INFO,"Repo Approval Inbox process has started");
					
					driver.switchTo().frame("topFrame");
					driver.findElement(By.partialLinkText("Transactions")).click();   
					test.log(LogStatus.PASS, "Clicked on Transactions");
					
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					Thread.sleep(1500);
					driver.findElement(By.linkText("Title Loan")).click();
					test.log(LogStatus.PASS, "Clicked on Title Loan link");
					
					Thread.sleep(1500);
					driver.findElement(By.linkText("Repo Approval Inbox")).click();
					test.log(LogStatus.PASS, "Clicked on Repo Approval Inbox");
					
					Thread.sleep(1500);
					driver.findElement(By.linkText("Search")).click();
					test.log(LogStatus.PASS, "Clicked on Search");

					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					//loan_nbr="10864316";
					driver.findElement(By.name("requestBean.dealNbr")).sendKeys(loan_nbr);
					test.log(LogStatus.PASS, "Enter the loan number: "+loan_nbr);
					
					driver.findElement(By.name("submit")).click();
					test.log(LogStatus.PASS, "Click on Submit button");
					Thread.sleep(1500);
					
					driver.findElement(By.xpath("//*[@name='button' and @value='Go']")).click();
					test.log(LogStatus.PASS, "Click on Go button");
					
					driver.findElement(By.xpath("//*[@name='button3' and @value='Deny']")).click();
					test.log(LogStatus.PASS, "Click on Deny button");
					
					String mainwindow=driver.getWindowHandle();
				    System.out.println("mainwindow"+mainwindow);
					 Thread.sleep(2000);
					    for(String winHandle : driver.getWindowHandles()){
					    	System.out.println("winHandle>>>>"+winHandle);
					    	System.out.println(driver.getWindowHandles().size());
							if(!mainwindow.equalsIgnoreCase(winHandle))
							{
							System.out.println("winHandle****"+winHandle);
							Thread.sleep(6000);
						    driver.switchTo().window(winHandle);	
						    System.out.println("switch to child window*"+winHandle);
						    Thread.sleep(3000);
					
					driver.findElement(By.name("requestBean.reasonId")).sendKeys(Reasons_Denial);
					test.log(LogStatus.PASS, "Select Reason for Denial as "+Reasons_Denial);
					
					driver.findElement(By.xpath("//*[@class='sortbuttons' and @value='Submit']")).click();
					test.log(LogStatus.PASS, "Click on Go button");
					
					
					break;
							}
					    }
							driver.switchTo().window(mainwindow);
					Thread.sleep(1000);
							/*if(driver.findElement(By.xpath("//*[@value='Ok' and @name='Ok']")).isDisplayed()){
								
								driver.findElement(By.xpath("//*[@value='Ok' and @name='Ok']")).click();
								test.log(LogStatus.PASS, "Click on Ok button");*/	
							
							/*driver.findElement(By.xpath("//*[text()='Ok']")).click();
							test.log(LogStatus.PASS, "Click on Ok button");*/
							
								test.log(LogStatus.PASS, "Repo Request Denied is Processed successfully");
								test.log(LogStatus.PASS, "***************************************");
								
								/*}else{
									
									test.log(LogStatus.INFO, "Repo Request Denied is Processed successfully");
									test.log(LogStatus.INFO, "***************************************");									
								}
							break;*/
					
					}
				
				}
			
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Void Trasaction is failed", ExtentColor.RED));
		test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
		String screenshotPath = getScreenhot(driver, "Exception");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
		test.log(LogStatus.INFO, "Repo Request Denied Trasaction is initiated due to application sync issue");
		driver.get(Jprop.getProperty("login_page"));   
		
	}
		
	}

}
