package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	
	public WebDriver driverInitializer() throws Exception
	{
		prop= new Properties();
		String propPath=".//src//main//java//resources\\data.properties";
		FileInputStream fis=new FileInputStream(propPath);
		prop.load(fis);
		String browserName=prop.getProperty("browserName");
	   if(browserName.equalsIgnoreCase("chrome"))
	   {
		   WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
	   }
	   else if(browserName.equalsIgnoreCase("fireFox"))
	   {
		   WebDriverManager.firefoxdriver().setup();
		   driver=new FirefoxDriver();
	   }
	   
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	   return driver;
	}
	
	public String getScreenshot(WebDriver driver,String testName)
	{
		//TakesScreenshot tsk=(TakesScreenshot)driver;
		//File srcFile=tsk.getScreenshotAs(OutputType.FILE);
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destFilePath=System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		try {
			FileUtils.copyFile(SourceFile, new File(destFilePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destFilePath;
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}
	
	

}
