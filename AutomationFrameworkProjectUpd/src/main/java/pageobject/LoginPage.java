package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class LoginPage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	private WebElement emailInput;
	
	@FindBy(name="password")
	private WebElement passwordInput;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn;
	
	
	public HomePage loinToApplication(String email, String password)
	{
		emailInput.sendKeys(email);
		passwordInput.sendKeys(password);
		loginBtn.click();
		return new HomePage(driver);
	}

}
