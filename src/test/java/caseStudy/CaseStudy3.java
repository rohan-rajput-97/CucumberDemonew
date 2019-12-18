package caseStudy;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestMeShopping.internet;

public class CaseStudy3 {
	WebDriver driver;


	@BeforeTest
	public void beforeTest() {
		internet obj=new internet();
		obj.getDriver("chrome");
		driver=new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}


	@Test(priority=1)
	public void registration() throws InterruptedException {
		String UsrInput;
		String condn;

		driver.findElement(By.xpath("//a[contains(text(),'SignUp')]")).click();
		String exists = "Name Already Exists";
		do {
			UsrInput =JOptionPane.showInputDialog("Enter User Name");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(UsrInput);
			driver.findElement(By.xpath("//input[@id='firstName']")).click();
			Thread.sleep(2000);
			condn= driver.findElement(By.xpath("//span[@id='err']")).getText();
			Thread.sleep(2000);
			//System.out.println(condn);
		}while(exists.equalsIgnoreCase(condn));

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Rohan");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Rajput");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abcxyz");
		driver.findElement(By.xpath("//input[@id='pass_confirmation']")).sendKeys("abcxyz");
		driver.findElement(By.xpath("//span[contains(.,'Male')]")).click();
		driver.findElement(By.xpath("//input[@id='emailAddress']")).sendKeys("hound_gaming@gmail.com");
		driver.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys("1234567891");
		driver.findElement(By.xpath("//input[@placeholder='Date of Birth- mm/dd/yyyy']")).sendKeys("06/04/1997");


		driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("H.no.05,Venktesh,Aurangabad");

		Select SQ = new Select(driver.findElement(By.name("securityQuestion")));
		SQ.selectByIndex(1);
		driver.findElement(By.xpath("//input[@name='answer']")).sendKeys("Red");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	@Test(priority=2)
	public void testLogin() throws InterruptedException {

		//driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		//driver.findElement(By.xpath("//a[@href='login.htm']")).click();

		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("lalitha");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);

	}

	@Test(priority=3)
	public void testCart() throws InterruptedException {

		//driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.findElement(By.xpath("//input[@id='myInput']")).sendKeys("headphone");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Add to cart')]")).click();
		driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
		String name = driver.findElement(By.xpath("//h4[contains(@class,'nomargin')]")).getText();
		//Assert.assertEquals("Headphone", name);
		Assert.assertEquals("Headphone", name);
	}

	@Test(priority=4)
	public void testpayment() throws InterruptedException {


		driver.findElement(By.xpath("//a[@href='checkout.htm']")).click();

		driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='radio-btns']//div[1]//div[1]//div[1]")).click();

		WebDriverWait wait = new WebDriverWait(driver, 30); //Explicit Wait

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,'Continue')]")));

		driver.findElement(By.xpath("//a[contains(.,'Continue')]")).click();	

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@456");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();

		driver.findElement(By.xpath("//input[@name='transpwd']")).sendKeys("Trans@456");
		driver.findElement(By.xpath("//div[@class='user-right']//input")).click();


	}
}
