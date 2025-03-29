package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass {
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='email']") WebElement textEmail;
	@FindBy(xpath="//input[@name='password']") WebElement textPass;
	@FindBy(xpath="//input[@type='submit']") WebElement btnSubmit;
	
	public void setEmail(String email)
	{
		textEmail.clear();
		textEmail.sendKeys(email);
	}
	
	public void setPass(String pas)
	{
		textPass.clear();
		textPass.sendKeys(pas);
	}
	
	public void clickBtn()
	{
		btnSubmit.click();
	}
	
	
	
	
	
	

}
