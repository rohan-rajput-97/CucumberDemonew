package demoWebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.*;

public class VerifyRegisisterDemo {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void f() {
		driver.get("http://www.newtours.demoaut.com/");

		String pgtitle = driver.getTitle();
		System.out.println("Page title is:"+pgtitle);
		Assert.assertEquals(pgtitle, "Welcome: Mercury Tours");

		driver.findElement(By.linkText("REGISTER")).click();
		System.out.println("Register title is:"+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Register: Mercury Tours");

		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Rohan");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Rajput");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("6966996969");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("rohan12@gmail.com");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("f.no-5");
		driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("nisarg gandh");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Pune");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Mah");
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("411057");
		
		Select drpcout= new Select(driver.findElement(By.xpath("//select[@name='country']")));
		drpcout.selectByVisibleText("INDIA");
		//drpcout.selectByIndex(21);
		//drpcout.selectByValue("92");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("rohan_rajput");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("rohan64");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("rohan64");
		driver.findElement(By.xpath("//input[@name='register']")).click();



	}
}
