package test;

import java.util.concurrent.TimeUnit;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

}
