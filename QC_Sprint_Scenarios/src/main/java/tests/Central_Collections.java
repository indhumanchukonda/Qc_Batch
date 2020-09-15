package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

public class Central_Collections extends QCStore{
	
	public static void Central_Collections_SSN_Hyperlink(String SSN, String AppURL) throws Exception {
		
		
		int lastrow = TestData.getLastRow("Borrower_Registration");
		String sheetName = "Borrower_Registration";


		for (int row = 2; row <= lastrow; row++) {
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			System.out.println("...." + RegSSN);
			if (SSN.equals(RegSSN)) {

				
				
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3, 5);
				String SSN3 = SSN.substring(5, 9);
				 String ESSN = SSN1+""+SSN2+""+SSN3; 
				 driver.switchTo().defaultContent();	
				    driver.switchTo().frame("topFrame");
			        driver.findElement(By.xpath("//*[@id='940000']/a")).click();
			        test.log(LogStatus.PASS, "Clicked on Account Management");
			
			        driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
			        driver.findElement(By.xpath("//*[@id='940003']/a")).click();
			        test.log(LogStatus.PASS, "Clicked on collections");
			        driver.switchTo().defaultContent();	
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");
				    driver.findElement(By.xpath("//*[@id='prodType']/td[3]/select")).sendKeys("ALL");
				    test.log(LogStatus.PASS, "product type is selected as ALL");
				    Thread.sleep(3000);
				    driver.findElement(By.xpath("//*[@id='Search']/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[8]/td/table/tbody/tr/td/input[3]")).click();
				    test.log(LogStatus.PASS, "Clicked on search button");
				    Thread.sleep(30000);
				   /* JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,5000)", " ");
				    Thread.sleep(20000);*/
				    driver.findElement(By.xpath("(//*[@value='Go'])[5]")).click();
				    test.log(LogStatus.PASS, "Clicked on Go Button");
				    Thread.sleep(5000);
				    driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[6]/a")).click();
				    test.log(LogStatus.PASS, "clicked on SSN hyper link");
				 
				    for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
					}
				    Thread.sleep(5000);
				    String ssn1 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn1);
			        String ssn2 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn2);
			        String ssn3 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn3);
			        test.log(LogStatus.PASS, ssn1+""+ssn2+""+ssn3);
			       String BSSN = ssn1+""+ssn2+""+ssn3;
				    driver.findElement(By.xpath("//*[@id='eye']")).click();
				   /* Actions a = new Actions(driver);
				    a.sendKeys(Keys.chord(Keys.CONTROL, Keys.TAB)).perform();*/
			        String ssn11 = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn1);
			        String ssn12 = driver.findElement(By.xpath("//*[@id='password1']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn2);
			        String ssn13 = driver.findElement(By.xpath("//*[@id='password2']")).getAttribute("value");
			        //test.log(LogStatus.PASS, ssn3);
			        test.log(LogStatus.PASS, ssn11+""+ssn12+""+ssn13);
			        driver.close();
			       String ASSN = ssn11+""+ssn12+""+ssn13;
			       if(ASSN.equals(BSSN))
			       {
			    	 test.log(LogStatus.PASS, "Test Failed"); 
			       }
			       else
			       {
			    	   test.log(LogStatus.PASS, "Test passed");
			       }
			       break;	

	}
		}
		}

}
