package tests;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class Default_Status extends QCStore {
	
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;
	
	public static void Verify(String SSN, String AppURL) {
		try {
			int lastrow = TestData.getLastRow("New_Loan");
			String sheetName = "New_Loan";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);

				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);
					
					driver.switchTo().frame("bottom");
					String Str_date = driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]"))
							.getText();
					String store_date[] = Str_date.split(":");
					business_date = store_date[1].trim();
					test.log(LogStatus.PASS, "Business date is :" + business_date);

					driver.switchTo().defaultContent();
					
					Thread.sleep(3000);
					test.log(LogStatus.INFO, "Checking Default Status started");
					driver.switchTo().frame("topFrame");
					driver.findElement(locator(Jprop.getProperty("transactions_tab"))).click();
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(By.cssSelector("li[id='911101']")).click();
					test.log(LogStatus.PASS, "Clicked on Transaction");
					driver.switchTo().frame("main");
					Thread.sleep(500);
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
					driver.findElement(locator(Jprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
					driver.findElement(locator(Jprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
					driver.findElement(locator(Jprop.getProperty("csr_new_loan_submit_button"))).click();
					test.log(LogStatus.PASS, "Clicked on submit Button");
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						driver.findElement(locator(Jprop.getProperty("csr_new_loan_go_button"))).click();
						test.log(LogStatus.PASS, "Clicked on GO Button");
						Thread.sleep(5000);
						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on GO Button");
						Thread.sleep(500);
																		///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[6]
						String BalanceStatus = driver.findElement(By.xpath("//*[@id='CustGrid']/tbody/tr[2]/td[5]")).getText();
					
						
						System.out.println(BalanceStatus);
						///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[6]
						if (BalanceStatus.equalsIgnoreCase("Default")) { 
							
							
	                        test.log(LogStatus.PASS, "The Status is Default Successfully");
	                        test.log(LogStatus.PASS, "***********************************");
							 driver.close();
						}else{
						
	                        test.log(LogStatus.FAIL, "The Status is not Default");
	                        test.log(LogStatus.PASS, "***********************************");
						}
						
							//test.log(LogStatus.PASS, "Balance Status is :" + Balance_Status);
							
					}
				}
			}
		}
					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						//test.log(LogStatus.FAIL, "Default Payment is failed");

					}

				}

}
