package tests;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.LandingPage;
import pageobject.LoginPage;
import pageobject.RegistrationPage;
import resources.Base;

public class RegistrationTest extends Base{
	
	WebDriver driver;
	Logger log;
	
	@Test(dataProvider ="RegistrationData" )
	public void doRegistrationTest(String firstName, String lastName,String email, String phoneNo,String pwd)
	{
		LandingPage landingpage=new LandingPage(driver);
		RegistrationPage registrationpage=landingpage.clickRegistrationBtn();
		log.info("Registration done successfully..");
		registrationpage.doRegistration(firstName,lastName,email,phoneNo,pwd);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		log.info("All browsers opened by automation got closed successfully...");
	}
	
	@BeforeTest
	public void initialiseDriver() throws Exception
	{
		log=LogManager.getLogger(RegistrationTest.class.getName());
		driver=driverInitializer();
		log.debug("driver got initialised successfully..");
		driver.get(prop.getProperty("url"));
		log.debug("URL got launched successfully...");
	}
	
	@DataProvider(name="RegistrationData")
	public Object[][] getRegistrationData()
	{
		return new Object[][] {{"testname", "testLastName", "emailInput@test.com", "112233", "test"}};
	}
	
	

}
