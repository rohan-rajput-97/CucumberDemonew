package demoWebDriverMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertDemo {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void f() throws InterruptedException {
		driver.get("http://demo.automationtesting.in/Alerts.html");

		driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();

		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

		Alert alertbx = driver.switchTo().alert();

		String alertmsgbx = alertbx.getText();
		Thread.sleep(3000);

		System.out.println("Alert msg is:"+alertmsgbx);

		alertbx.sendKeys("Rohan");
		Thread.sleep(3000);
		alertbx.accept();


	}
}
