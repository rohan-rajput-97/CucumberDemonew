package TestMeShopping;

import java.util.*;

import org.openqa.selenium.WebDriver;

public class internet {

	public static  String getDriver(String driver)
	{
		if (driver.equalsIgnoreCase("chrome"))

		{
			return System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");

		}
		else if (driver.equalsIgnoreCase("ie"))
		{
			return System.setProperty("webdriver.ie.driver", "resources\\IEDriverServer.exe");


		}
		else
		{
			return System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");


		}

	}


}

