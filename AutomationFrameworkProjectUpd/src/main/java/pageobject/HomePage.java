package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccountBtn;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutBtn;
	
	@FindBy(linkText = "Your Store")
	private WebElement YourStoreLabel;
	
	public void logoutFromApplication()
	{
		myAccountBtn.click();
		logoutBtn.click();
	}
	
	public boolean loginSuccess()
	{
		boolean flag=false;
		flag=YourStoreLabel.isDisplayed();
		return flag;
	}
	

}
