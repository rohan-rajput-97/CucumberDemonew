package demoWebDriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserNavigationMethodsDemo {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void f() throws InterruptedException {
		driver.navigate().to("https://www.google.com/");
		Assert.assertEquals(driver.getTitle(), "Google");
		System.out.println("Url is:"+driver.getCurrentUrl());
		Thread.sleep(3000);

		driver.navigate().to("https://mvnrepository.com/");
		Assert.assertEquals(driver.getTitle(), "Maven Repository: Search/Browse/Explore");
		System.out.println("Url is:"+driver.getCurrentUrl());
		Thread.sleep(3000);

		driver.navigate().back();
		Assert.assertEquals(driver.getTitle(), "Google");
		System.out.println("Url is:"+driver.getCurrentUrl());
		Thread.sleep(3000);

		driver.navigate().forward();
		Assert.assertEquals(driver.getTitle(), "Maven Repository: Search/Browse/Explore");
		System.out.println("Url is:"+driver.getCurrentUrl());
		Thread.sleep(3000);

		driver.navigate().refresh();
		System.out.println("Page Refreshed");


	}
}
