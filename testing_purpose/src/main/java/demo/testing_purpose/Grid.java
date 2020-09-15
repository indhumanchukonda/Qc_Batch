package demo.testing_purpose;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Grid {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		// TODO Auto-generated method stub
		URL u1 = new URL("http:// 192.168.0.237/wd/hub");
		DesiredCapabilities dc1 = DesiredCapabilities.chrome();
		WebDriver d1 = new RemoteWebDriver(u1,dc1);
		d1.navigate().to("https://www.google.com/");
		Thread.sleep(5000);
		d1.quit();
		URL u2 = new URL("http:// 192.168.0.237/wd/hub");
		DesiredCapabilities dc2 = DesiredCapabilities.firefox();
		WebDriver d2 = new RemoteWebDriver(u2,dc2);
		d2.navigate().to("https://www.google.com/");
		Thread.sleep(5000);
		d2.quit();
		

	}

}
