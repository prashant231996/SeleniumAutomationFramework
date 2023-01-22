package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageobject.HomePage;
import pageobject.LandingPage;
import pageobject.LoginPage;
import resources.Base;

public class LoginTest extends Base{

	WebDriver driver;
	Logger log;
	
	@Test(dataProvider ="LoginData" )
	public void loginTest(String email,String pwd) throws Exception
	{
		LandingPage landingpage=new LandingPage(driver);
		LoginPage loginpage=landingpage.clickLoginBtn();
		log.info("Clicking Login Button..");
		//HomePage homepage=loginpage.loinToApplication(prop.getProperty("email"), prop.getProperty("password"));
		HomePage homepage=loginpage.loinToApplication(email, pwd);
		Assert.assertTrue(homepage.loginSuccess(), "Failed to login to application");
		log.info("Successfully Log in to application..");
		homepage.logoutFromApplication();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		log.info("All Browsers opened by automation closed sucessfully..");
	}
	
	@BeforeTest
	public void initialiseDriver() throws Exception
	{
		log = LogManager.getLogger(LoginTest.class.getName());
		driver=driverInitializer();
		log.info("Driver initialised successfully");
		driver.get(prop.getProperty("url"));
		log.debug("URL launch successfully...");
	}
	
	@DataProvider(name = "LoginData")
	public Object[][] getLoginData()
	{
		return new Object[][]{{"testpm@test.com","test"},{"dummy@dummy.com","dummy"}};
	}
}
