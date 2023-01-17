package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.LandingPage;
import pageobject.LoginPage;
import pageobject.RegistrationPage;
import resources.Base;

public class RegistrationTest extends Base{
	
	WebDriver driver;
	
	@Test
	public void RegistrationTest()
	{
		LandingPage landingpage=new LandingPage(driver);
		RegistrationPage registrationpage=landingpage.clickRegistrationBtn();
		registrationpage.doRegistration("testname", "testLastName", "emailInput@test.com", "112233", "test");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	@BeforeTest
	public void initialiseDriver() throws Exception
	{
		driver=driverInitializer();
		driver.get(prop.getProperty("url"));
	}
	
	

}
