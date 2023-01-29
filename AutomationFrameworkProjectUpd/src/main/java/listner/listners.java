package listner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class listners extends Base implements ITestListener{
	
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

	WebDriver driver;
	

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest=extentReport.createTest(result.getName()+"Execution Started...");
		extentTestThread.set(extentTest);
	}
	
	@Override
	public void onTestSuccess(ITestResult arg0) {
		extentTestThread.get().log(Status.PASS,"Test Passed");
	}


	@Override
	public void onTestFailure(ITestResult testResult) {
		// TODO Auto-generated method stub
		extentTestThread.get().fail(testResult.getThrowable());
		extentTestThread.get().log(Status.FAIL, "Test Failed...");
		 driver=null;
		String testName=testResult.getName();
		//driver=getDriver();
		try {
			driver = (WebDriver)testResult.getTestClass().getRealClass().getDeclaredField("driver").get(testResult.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String screenShotFilePath=getScreenshot(driver,testName);
		 try {
			extentTestThread.get().addScreenCaptureFromPath(screenShotFilePath, testName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onFinish(ITestContext arg0) {
		extentReport.flush();
		
	}

	
}
