package stepdefination;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import pageobject.HomePage;
import pageobject.LandingPage;
import pageobject.LoginPage;
import resources.Base;

public class StepDefination extends Base{
	
	WebDriver driver;
	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	
	@Given("Open any Browser")
	public void open_any_browser() throws Exception {
		driver=driverInitializer();    
	}
	@Given("Navigate to Login page")
	public void navigate_to_login_page() {
		driver.get(prop.getProperty("url"));
	   landingpage=new LandingPage(driver);
	   loginpage=landingpage.clickLoginBtn();
	}
	@When("User enters username as {string} and password as {string} into the fields")
	public void user_enters_username_as_and_password_as_into_the_fields(String email, String pwd) {
		 homepage=loginpage.loinToApplication(email, pwd);
	}
	
	@Then("Verify user is able to successfully login")
	public void verify_user_is_able_to_successfully_login() {
		Assert.assertTrue(homepage.loginSuccess(), "Failed to login to application");
	}
	
	//@After Hook run after each test scenario
	@After
	public void tearDown()
	{
		driver.close();
	}


}
