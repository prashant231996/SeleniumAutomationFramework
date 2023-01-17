package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class LandingPage {
	
	WebDriver driver;

	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement myAccountBtn;
	
	@FindBy(linkText = "Register")
	WebElement registerBtn;
	
	@FindBy(linkText = "Login")
	WebElement loginBtn;
	
	public LoginPage clickLoginBtn()
	{
		myAccountBtn.click();
		loginBtn.click();
		return new LoginPage(driver);	
	}
	
	public RegistrationPage clickRegistrationBtn()
	{
		myAccountBtn.click();
		registerBtn.click();
		return new RegistrationPage(driver);
	}
	

}
