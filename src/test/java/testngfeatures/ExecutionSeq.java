package testngfeatures;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ExecutionSeq {
	@Test
	public void f() {
		System.out.println("i m in @test");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("i m in @beforemethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("i m in @aftermethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("i m in @beforeclass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("i m in @afterclass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("i m in @beforetest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("i m in @aftertest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("i m in @beforesuite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("i m in @aftersuite");
	}

}
