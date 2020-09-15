package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeDriver driver;
		// TODO Auto-generated method stub
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//*[@id='flightSearchContainer']/div[4]/button")).click();
		for(int i=0; i<=8; i++)
		{
			driver.findElement(By.xpath("//*[@id='flightSearchContainer']/div[4]/button")).click();
		WebElement e = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span"));
		if(e.isEnabled())
		{
			//driver.findElement(By.xpath("//*[@id='flightSearchContainer']/div[4]/button")).click();
			e.click();
			driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[4]/td[5]/a")).click();
		}
		}

	}

}
