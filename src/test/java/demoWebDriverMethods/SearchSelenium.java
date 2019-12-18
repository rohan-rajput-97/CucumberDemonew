package demoWebDriverMethods;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SearchSelenium {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Test
	public void f() throws InterruptedException {
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Selenium (software)");
		driver.findElement(By.xpath("//input[@id='searchButton']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create account')]")).click();
		Assert.assertEquals(driver.getTitle(), "Create account - Wikipedia");
		System.out.println(driver.getCurrentUrl());

		String actualurl = driver.getCurrentUrl();
		String expurl = "wikipedia.org";
		
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(actualurl.contains(expurl), "External link");
		System.out.println("Internal Link");
		/*if(actualurl.contains(expurl))
		{
			System.out.println("Internal Link");
		}
		else
		{
			System.out.println("External Link");
		}
		 */

		driver.navigate().back();
		//Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Selenium (software) - Wikipedia");
		System.out.println(driver.getCurrentUrl());

		driver.findElement(By.xpath("(//a[@class='external text'])[9]")).click();

		Assert.assertEquals(driver.getTitle(), "SeleniumHQ Browser Automation");

		String newurl = driver.getCurrentUrl();
		String oldurl = "wikipedia.org";
		
		sa.assertTrue(newurl.contains(oldurl), "External Link");
		
		System.out.println("At end");
		sa.assertAll();
		/*if(newurl.contains(oldurl))
		{
			System.out.println("Internal Link");
		}
		else
		{
			System.out.println("External Link");
		}
		 */



	}


	@AfterTest
	public void afterTest() {
	}

}
