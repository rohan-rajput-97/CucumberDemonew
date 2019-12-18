package demoWebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WikipediaDemo {

	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void f() throws InterruptedException {

		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		Assert.assertEquals(driver.getTitle(), "Wikipedia, the free encyclopedia");

		driver.findElement(By.linkText("History")).click();

		Assert.assertEquals(driver.getTitle(), "Portal:History - Wikipedia");

		String url= driver.getCurrentUrl();
		System.out.println("Current url is:"+url);

		Thread.sleep(3000);
		System.out.println(driver.getPageSource());
	}
}
