package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BaseClass{
	
	
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	


@FindBy(xpath="//input[@id='input-firstname']") WebElement firstName;
@FindBy(xpath="//input[@id='input-lastname']") WebElement lastName;
@FindBy(xpath="//input[@id='input-email']") WebElement e_Mail;
@FindBy(xpath="//input[@id='input-telephone']") WebElement telephone;
@FindBy(xpath="//input[@id='input-password']") WebElement password;
@FindBy(xpath="//input[@id='input-confirm']") WebElement passwordConfirm;
@FindBy(xpath="//input[@name='agree']") WebElement agree;
@FindBy(xpath="//input[@value='Continue']") WebElement cont ;
		
		public void txtFirst(String s)
		{
			firstName.sendKeys(s);
		}
		
		public void txtlastName(String s)
		{
			lastName.sendKeys(s);
		}
		
		public void txte_Mail(String s)
		{
			e_Mail.sendKeys(s);
		}
		
		public void txttelephone(String s)
		{
			telephone.sendKeys(s);
		}
		
		public void txtpassword(String s)
		{
			password.sendKeys(s);
		}
		
		public void txtpasswordConfirm(String s)
		{
			passwordConfirm.sendKeys(s);
		}
		
		public void btnAgree()
		{
			agree.click();
		}
		
		public void btnCont()
		{
			cont.click();
		}
		

}
