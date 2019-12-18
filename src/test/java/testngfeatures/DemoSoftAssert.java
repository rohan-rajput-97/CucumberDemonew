package testngfeatures;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoSoftAssert {
	@Test
	public void test1() {
		System.out.println("Test 1 started");
		SoftAssert sa= new SoftAssert();

		System.out.println("1st condition");
		sa.assertEquals("hello", "hi");

		sa.assertNotEquals(10, 10,"Error msg: both values are same");

		System.out.println("Test 1 completed");

		sa.assertAll();
	}
}
