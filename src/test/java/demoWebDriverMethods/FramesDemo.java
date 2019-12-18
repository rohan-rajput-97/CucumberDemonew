package demoWebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FramesDemo {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void f() throws InterruptedException {
		driver.get("https://selenium.dev/selenium/docs/api/java/index.html");
		Thread.sleep(2000);

		driver.switchTo().frame(0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'org.openqa.selenium.chrome')]")).click();
		Thread.sleep(2000);

		System.out.println(driver.getTitle());

		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("packageFrame");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[1]//a[1]")).click();
		Thread.sleep(2000);

		System.out.println(driver.getTitle());

		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame(2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'HasCapabilities')]")).click();;
		Thread.sleep(2000);
		System.out.println(driver.getTitle());

	}
}
