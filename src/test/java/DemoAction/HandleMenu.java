package DemoAction;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandleMenu {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void f() {

		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm#");

		WebElement aboutus = driver.findElement(By.xpath("//span[contains(text(),'AboutUs')]"));

		WebElement ouroffices = driver.findElement(By.xpath("//span[contains(text(),'Our')]"));

		WebElement chennai = driver.findElement(By.xpath("//span[contains(text(),'Chennai')]"));

		Actions act = new  Actions(driver);

		act.moveToElement(aboutus).pause(2000).click().perform();
		act.moveToElement(ouroffices).pause(2000).click().perform();
		act.moveToElement(chennai).click().perform();

		Set<String> allwindows = driver.getWindowHandles();


		for (String singlewindow : allwindows) {
			driver.switchTo().window(singlewindow);
			System.out.println("Current window handle is:"+singlewindow);

		}
		//System.out.println("Reach checkpoint");

		WebElement frameadd = driver.findElement(By.name("main_page"));

		driver.switchTo().frame(frameadd);

		String address = driver.findElement(By.tagName("address")).getText();
		System.out.println("Address is :"+address);

	}
}
