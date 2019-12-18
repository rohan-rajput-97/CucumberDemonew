package basics.SeleniumProject;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class trial {
	static WebDriver driver=null;
	static String UsrInput;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
			UsrInput =JOptionPane.showInputDialog("Enter Input");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(UsrInput);
	}
}