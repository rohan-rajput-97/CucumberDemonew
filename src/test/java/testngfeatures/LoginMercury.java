package testngfeatures;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginMercury {

	WebDriver driver;

	@Test
	public void f() {
		driver.get("https://www.google.com/"); //open site
		driver.manage().window().maximize(); //maximize chrome window
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver(); //opening chrome browser
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
