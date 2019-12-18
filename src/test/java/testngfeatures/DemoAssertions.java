package testngfeatures;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoAssertions {
	@Test
	public void Test1() {
		System.out.println("Test 1 started");
		Assert.assertTrue(20>18, "Error msg-20 greater than 18");
		System.out.println("Test 1 completed");


	}

	@Test
	public void Test2() {
		System.out.println("Test 2 started");
		Assert.assertFalse(20>18, "Error msg- 20 greater than 18");
		System.out.println("Test 2 completed");
	}

	@Test
	public void Test3() {

		Assert.assertEquals("Hello", "Hi");

	}
	@Test
	public void Test4() {
		System.out.println("Test 4 started");
		Assert.assertNotEquals("Hello", "Hi");
		System.out.println("Test 4 completed");
	}
	@Test
	public void Test5() {
		Object test=null;
		Assert.assertNull(test);

	}
	@Test
	public void Test6() {
		Object test=null;
		Assert.assertNotNull(test);

	}
	@Test
	public void Test7() {
		Assert.fail("Intentional Fail");

	}
}
