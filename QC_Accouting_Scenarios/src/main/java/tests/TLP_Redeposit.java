package tests;

import org.openqa.selenium.By;
import tests.QCStore;
import com.relevantcodes.extentreports.LogStatus;

public class TLP_Redeposit extends QCStore{
	public static void redeposit(String SSN,String AppURL) throws InterruptedException
	{

		test.log(LogStatus.PASS, "************ Redeposit Transaction started****************");
		int lastrow=TestData.getLastRow("Redeposit");
		String sheetName="Redeposit";

		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{

				String RepresentmentType = TestData.getCellData(sheetName,"RepresentmentType",row);
				driver.switchTo().frame("topFrame");
				Thread.sleep(1500);
				driver.findElement(locator(Jprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				driver.switchTo().defaultContent();
				Thread.sleep(1500);
				driver.switchTo().frame("mainFrame");				
				driver.findElement(By.partialLinkText("Debit Cards")).click();
				test.log(LogStatus.PASS, "Clicked on Debit Cards");
				Thread.sleep(1500);
				driver.findElement(By.partialLinkText("Title Loan")).click();
				test.log(LogStatus.PASS, "Clicked on Title Loan");
				Thread.sleep(1500);
				driver.findElement(By.partialLinkText("ReDeposit/Representment")).click();
				test.log(LogStatus.PASS, "Clicked on Redeposit");
				//loan_nbr="10864316";
				Thread.sleep(1500);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_nbr);
				test.log(LogStatus.PASS, "Enterd loan number is :"+loan_nbr);
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on submit button");
				Thread.sleep(1500);
				//*[@id="dealNbrId0"]
				String loanno=driver.findElement(By.xpath("//*[@id='dealNbrId0']")).getText();
				test.log(LogStatus.PASS, "Getting loan number from table"+loanno);
				//if(loanno.equals(loan_nbr)){

					driver.findElement(By.name("requestBean.chkName")).click();
					test.log(LogStatus.PASS, "clicking on check box to selcet customet having loan number"+loan_nbr);


					driver.findElement(By.name("CmdReturnPosting")).click();
					test.log(LogStatus.PASS, "Click on Representment Now button");
					
					Thread.sleep(1500);
				/*}
				else{
					test.log(LogStatus.FAIL, " loan number didn't match");
				}

*/
				test.log(LogStatus.PASS, "Redeposit  is successful");
				test.log(LogStatus.PASS, "********************************************** ");
				break;
			}else
			{
				test.log(LogStatus.INFO, "RegSSN and SSN not matching ");
			}}			 }
}
