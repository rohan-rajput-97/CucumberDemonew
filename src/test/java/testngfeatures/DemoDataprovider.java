package testngfeatures;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DemoDataprovider {
  @Test(dataProvider = "credentials")
  public void login(String username, String password) {
	  System.out.println("Username is :"+username);
	  System.out.println("Password is :"+password);
  }

  @DataProvider(name="credentials")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "lalitha", "password123" },
      new Object[] { "rohan", "rajput" },
    };
  }
}
