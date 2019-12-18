package DemoExtentReports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.aventstack.extentreports.utils.FileUtil;

public class ExtentReport {
	WebDriver driver;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    //helps to generate the logs in test report.
    ExtentTest test;
    
//  @Parameters({ "OS", "browser" })
    @BeforeTest
//    public void startReport(String OS, String browser) {
    	public void startReport() {
    	// initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport5432.html");
        
        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
         
        //To add system or environment info by using the setSystemInfo method.
//        extent.setSystemInfo("OS", OS);
//        extent.setSystemInfo("Browser", browser);
//        
        //configuration items to change the look and feel
        //add content, manage tests etc
//        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test Report");
//        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }
     
    @Test
    public void login() {
    	test = extent.createTest("TC_01", "Application Accessibility");
////        int a =10;
////        int b= 12;
////        Assert.assertEquals(a, b);
    	System.setProperty("webdriver.chrome.driver","resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		Assert.assertEquals("Srinivas", driver.getTitle());
//		driver.findElement(By.xpath("")).ge
		
//		driver.findElement(By.xpath(xpathExpression))
    }
    
    @Test
    public void testCase1() {
        test = extent.createTest("Test Case 1", "PASSED test case");
        Assert.assertTrue(true);
    }
//    
    @Test
    public void testCase2() {
        test = extent.createTest("Test Case 2", "PASSED test case");
        Assert.assertTrue(true);
    }
//    
//    @Test
//    public void testCase3() {
//        test = extent.createTest("Test Case 3", "PASSED test case");
//        Assert.assertTrue(true);
   
//    }
//     
//    @Test
//    public void testCase4() {
//        test = extent.createTest("Test Case 4", "PASSED test case");
//        Assert.assertTrue(false);
//    }
//     
//    @Test
//    public void testCase5() {
//        test = extent.createTest("Test Case 5", "SKIPPED test case");
//        throw new SkipException("Skipping this test with exception");
//    }
//    
//    @Test(enabled=false)
//	public void testCase6(){
//			test = extent.createTest("Test Case 6", "I'm Not Ready, please don't execute me");
//		}
//   
    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.PINK));
            
            TakesScreenshot snapshot =   (TakesScreenshot)driver;
            File src = snapshot.getScreenshotAs(OutputType.FILE);
            String Path = System.getProperty("user.dir") +"/test-output/screens/"+result.getName()+".png";
            FileUtils.copyFile(src, new File(Path));
            test.addScreenCaptureFromPath(Path, result.getName());
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.INDIGO));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
     
    @AfterTest
    public void tearDown() {
    	//to write or update test information to reporter
        extent.flush();
    }
}

