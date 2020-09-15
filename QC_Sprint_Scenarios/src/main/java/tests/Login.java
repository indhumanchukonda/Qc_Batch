package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends LendNation
{
public static void login(String SSN, String AppURL) throws Exception
{
	
		String FileName= prop.getProperty("file_name");
		ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 
		int lastrow=TestData.getLastRow("Personal Information");
		String sheetName="Personal Information";
		WebDriverWait wait = new WebDriverWait(driver, 15000);
		
		
		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			System.out.println("SSN number  "+ RegSSN);
			if(SSN.equals(RegSSN))
			{	

				String UserName = TestData.getCellData(sheetName, "UserName", row);
				String PWD = TestData.getCellData(sheetName,"PWD",row);
				
				driver.findElement(By.xpath("//*[@id='loginCaption']")).click();
				driver.findElement(By.xpath("//*[@id='Username']")).sendKeys(UserName);
				driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(PWD);
				driver.findElement(By.xpath("//*[@id='loginbtn']")).click();
}
}
	}
}