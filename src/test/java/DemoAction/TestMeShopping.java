package DemoAction;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestMeShopping {
	
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
	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  WebElement searchbx = driver.findElement(By.xpath("//input[@id='myInput']"));
	  
	  Actions act = new Actions(driver);
	  act.keyDown(searchbx, Keys.SHIFT).perform();
	  
	  act.sendKeys("b").pause(2000).sendKeys("a").pause(2000).sendKeys("g").perform();
	  Thread.sleep(2000);
	  
	  WebElement handbag = driver.findElement(By.xpath("(//div[contains(.,'Hand bag')])[4]"));
	  //act.moveToElement(handbag).perform();
	  act.moveToElement(handbag).click().perform();;
	  
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//form//input[@name='val']")).click();
	  
	  Set<String> allwindows = driver.getWindowHandles();
	  
		for (String singlewindow : allwindows) {
			driver.switchTo().window(singlewindow);
			System.out.println("Current window handle is:"+singlewindow);

		}
		
			//driver.findElement(By.className(className))
	  
	  String bagname = driver.findElement(By.xpath("//h4[contains(text(),'Hand bag')]")).getText();
	  Assert.assertTrue(bagname.contains("bag"));
  }
}
