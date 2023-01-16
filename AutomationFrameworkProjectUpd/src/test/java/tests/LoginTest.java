package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageobject.HomePage;
import pageobject.LandingPage;
import pageobject.LoginPage;
import resources.Base;

public class LoginTest extends Base{

	WebDriver driver;
	@Test
	public void loginTest() throws Exception
	{
		driver=driverInitializer();
		driver.get(prop.getProperty("url"));
		LandingPage landingpage=new LandingPage(driver);
		LoginPage loginpage=landingpage.clickLoginBtn();
		HomePage homepage=loginpage.loinToApplication(prop.getProperty("email"), prop.getProperty("password"));
		Assert.assertTrue(homepage.loginSuccess(), "Failed to login to application");
		homepage.logoutFromApplication();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
