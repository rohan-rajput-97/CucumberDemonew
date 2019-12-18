package basics.SeleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver; //creating instance of webdriver

		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");

		driver = new ChromeDriver(); //opening chrome browser

		driver.get("https://www.google.com/"); //open site

		driver.manage().window().maximize(); //maximize chrome window
		
		Thread.sleep(3000);
		
		driver.close();
		
		
	}

}
