package testngfeatures;

import org.testng.annotations.Test;

public class MercuryApplication {
  @Test(priority=1)
  public void openbrowser() {
	  System.out.println("In openbrowser");
  }
  @Test(priority=2)
  public void openurl() {
	  System.out.println("In openurl");
  }
  @Test(priority=3)
  public void Login() {
	  System.out.println("In login");
  }
  @Test(priority=4,enabled=false)
  public void searchFlight() {
	  System.out.println("In searchflight");
  }
  @Test(priority=5)
  public void bookFlight() {
	  System.out.println("In bookflight");
  }
  @Test(priority=7)
  public void logout() {
	  System.out.println("In logout");
  }
  @Test(priority=6)
  public void closebrowser() {
	  System.out.println("In closebrowser");
  }
  
}
