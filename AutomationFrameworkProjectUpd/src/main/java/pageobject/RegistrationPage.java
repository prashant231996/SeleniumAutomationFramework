package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	WebDriver driver;

	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstname")
	WebElement name;
	
	@FindBy(name="lastname")
	WebElement lastName;
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-telephone")
	WebElement telePhone;
	
	@FindBy(id="input-password")
	WebElement pwdInput;
	
	@FindBy(id="input-confirm")
	WebElement confpwd;
	
    @FindBy(xpath="//input[@value='0']")
    WebElement radioBtn;
    
    @FindBy(xpath = "//input[@name='agree']")
    WebElement agreeChkBox;
    
    @FindBy(css = "input[value='Continue']")
    WebElement continueBtn;
    
    public void doRegistration(String firstname,String LastName,String emailInput, String phoneNo,String pwd)
    {
    	name.sendKeys(firstname);
    	lastName.sendKeys(LastName);
    	email.sendKeys(emailInput);
    	telePhone.sendKeys(phoneNo);
    	pwdInput.sendKeys(pwd);
    	confpwd.sendKeys(pwd);
    	radioBtn.click();
    	continueBtn.click();
    }


}
